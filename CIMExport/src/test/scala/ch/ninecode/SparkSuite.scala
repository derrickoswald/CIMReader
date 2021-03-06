package ch.ninecode

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipInputStream

import scala.reflect.ClassTag
import scala.reflect.classTag

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

import ch.ninecode.cim.CIMClasses

import org.scalatest.Outcome
import org.scalatest.funsuite.FixtureAnyFunSuite

class SparkSuite extends FixtureAnyFunSuite
{
    type FixtureParam = SparkSession

    /**
     * This utility extracts files and directories of a standard zip file to
     * a destination directory.
     *
     * @author www.codejava.net
     *
     */
    class Unzip
    {
        /**
         * Extracts a zip file specified by the file to a directory.
         *
         * The directory will be created if does not exist.
         *
         * @param file      The Zip file.
         * @param directory The directory to extract it to
         * @throws IOException If there is a problem with the zip extraction
         */
        @throws[IOException]
        def unzip (file: String, directory: String): Unit =
        {
            val dir = new File(directory)
            if (!dir.exists)
                dir.mkdir
            val zip = new ZipInputStream(new FileInputStream(file))
            var entry = zip.getNextEntry
            // iterates over entries in the zip file
            while (null != entry)
            {
                val path = s"$directory${entry.getName}"
                val time = entry.getLastModifiedTime
                if (!entry.isDirectory)
                {
                    // if the entry is a file, extracts it
                    extractFile(zip, path)
                    if (null != time)
                        new File(path).setLastModified(time.toMillis)
                }
                else
                // if the entry is a directory, make the directory
                    new File(path).mkdir
                zip.closeEntry()
                entry = zip.getNextEntry
            }
            zip.close()
        }

        /**
         * Extracts a zip entry (file entry).
         *
         * @param zip  The Zip input stream for the file.
         * @param path The path to extract he file to.
         * @throws IOException If there is a problem with the zip extraction
         */
        @throws[IOException]
        private def extractFile (zip: ZipInputStream, path: String): Unit =
        {
            val bos = new BufferedOutputStream(new FileOutputStream(path))
            val bytesIn = new Array[Byte](4096)
            var read = -1
            while (
            {
                read = zip.read(bytesIn);
                read != -1
            })
                bos.write(bytesIn, 0, read)
            bos.close()
        }
    }

    /**
     * Delete files and directories recursively.
     *
     * @param path The starting path.
     */
    def deleteRecursive (path: File): Unit =
    {
        if (path.isDirectory)
            for (subpath <- path.list)
                deleteRecursive(new File(path, subpath))
        path.delete
    }

    def withFixture (test: OneArgTest): Outcome =
    {
        // create the configuration
        val configuration = new SparkConf(false)
        configuration.setAppName("CIMSparkSuite")
        configuration.setMaster("local[2]")
        configuration.set("spark.driver.memory", "2g")
        configuration.set("spark.executor.memory", "2g")
        configuration.set("spark.ui.showConsoleProgress", "false")
        configuration.registerKryoClasses(CIMClasses.list)

        val session = SparkSession.builder().config(configuration).getOrCreate() // create the fixture
        session.sparkContext.setLogLevel("INFO") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
        withFixture(test.toNoArgTest(session)) // "loan" the fixture to the test
        finally session.stop() // clean up the fixture
    }

    def readFile (filename: String, options: Map[String, String] = Map[String, String]())(implicit spark: SparkSession): DataFrame =
    {
        val o = options + ("StorageLevel" -> "MEMORY_AND_DISK_SER")
        spark.read.format("ch.ninecode.cim").options(o).load(filename) // ToDo: why doesn't this work? load (filename.split (","):_*)
    }

    /**
     * Get the named RDD.
     *
     * @param name  The name of the RDD, usually the same as the CIM class.
     * @param spark The Spark session which persisted the named RDD.
     * @tparam T The type of objects contained in the named RDD.
     * @return The typed RDD, e.g. <code>RDD[T]</code>.
     * @example If there were two CIM files read in and stored with names having suffix _1 and _2,
     *          this would get both of the RDD[Element] :
     * {{{val elements_1: RDD[Element] = get[Element]("Element_1")}}}
     * {{{val elements_2: RDD[Element] = get[Element]("Element_2")}}}
     */
    def get[T: ClassTag] (name: String)(implicit spark: SparkSession): RDD[T] =
    {

        val rdd: collection.Map[Int, RDD[_]] = spark.sparkContext.getPersistentRDDs
        rdd.find(_._2.name == name) match
        {
            case Some((_, rdd: RDD[_])) =>
                rdd.asInstanceOf[RDD[T]]
            case Some(_) =>
                null
            case None =>
                null
        }
    }


    /**
     * Get the typed RDD.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return The RDD with the given type of objects, e.g. <code>RDD[ACLineSegment]</code>.
     */
    def get[T: ClassTag] (implicit spark: SparkSession): RDD[T] =
    {
        val classname = classTag[T].runtimeClass.getName
        val name = classname.substring(classname.lastIndexOf(".") + 1)
        get(name)
    }
}
