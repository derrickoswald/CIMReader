package ch.ninecode.cim

import scala.collection.mutable
import scala.util.Try

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs._
import org.apache.hadoop.io.compress.{CompressionCodecFactory, SplittableCompressionCodec}
import org.apache.hadoop.mapred.{FileInputFormat, JobConf}
import org.apache.hadoop.mapreduce.{Job, TaskAttemptContext}

import org.apache.spark.annotation.Experimental
import org.apache.spark.internal.Logging
import org.apache.spark.sql._
import org.apache.spark.sql.catalyst.{CatalystTypeConverters, InternalRow}
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.codegen.GenerateUnsafeProjection
import org.apache.spark.sql.execution.datasources.FileFormat
import org.apache.spark.sql.execution.FileRelation
import org.apache.spark.sql.sources.{BaseRelation, DataSourceRegister, Filter}
import org.apache.spark.sql.types.StructType
import org.apache.spark.util.SerializableConfiguration

import org.apache.spark.sql.execution.datasources.PartitionedFile
import org.apache.spark.sql.execution.datasources.OutputWriterFactory

import org.apache.spark.sql.types.Element
import org.slf4j.LoggerFactory

//
// NOTE: This class is not used (yet).
//
// The match statement in DataSource will either match a RelationProvider or a FileFormat
// see https://github.com/apache/spark/blob/branch-2.0/sql/core/src/main/scala/org/apache/spark/sql/execution/datasources/DataSource.scala
//
// If (our class) DefaultSource inherits from FileFormat, we get no chance to do subsetting, named RDD setup, Join, Edges etc.
//
class CIMFileFormat
extends
    FileFormat
{
    private val log = LoggerFactory.getLogger (getClass) 

    // just to get a schema
    case class dummy
    (
        override val sup: Element = null
    )
    extends
        Element

    /**
     * When possible, this method should return the schema of the given `files`.
     * Derrick: The schema of a CIM file is always just a single Element
     */
    override def inferSchema (
        sparkSession: SparkSession,
        options: Map[String, String],
        files: Seq[FileStatus]): Option[StructType] =
    {
        return (Some (ScalaReflection.schemaFor[dummy].dataType.asInstanceOf[StructType]))
    }

    /**
     * Prepares a write job and returns an [[OutputWriterFactory]].
     * <em>Currently not supported</em>
     */
    override def prepareWrite (
        sparkSession: SparkSession,
        job: Job,
        options: Map[String, String],
        dataSchema: StructType): OutputWriterFactory =
    {
        throw new UnsupportedOperationException ("prepareWrite is not supported")
    }

    /**
     * Returns whether a file with `path` could be splitted or not.
     * Derrick: This is used to allow (or not) the splitting of compressed files,
     * and since the CIM RDF files are not compressed (for now),
     * we return <code>true</code>.
     */
    override def isSplitable (
        sparkSession: SparkSession,
        options: Map[String, String],
        path: Path): Boolean =
    {
        return (true)
    }

    /**
     * Returns a function that can be used to read a single file in as an Iterator of InternalRow.
     *
     * @param dataSchema The global data schema. It can be either specified by the user, or
     *                   reconciled/merged from all underlying data files. If any partition columns
     *                   are contained in the files, they are preserved in this schema.
     * @param partitionSchema The schema of the partition column row that will be present in each
     *                        PartitionedFile. These columns should be appended to the rows that
     *                        are produced by the iterator.
     * @param requiredSchema The schema of the data that should be output for each row.  This may be a
     *                       subset of the columns that are present in the file if column pruning has
     *                       occurred.
     * @param filters A set of filters than can optionally be used to reduce the number of rows output
     * @param options A set of string -> string configuration options.
     * @return
     */
    override def buildReader (
        sparkSession: SparkSession,
        dataSchema: StructType,
        partitionSchema: StructType,
        requiredSchema: StructType,
        filters: Seq[Filter],
        options: Map[String, String],
        hadoopConf: Configuration): PartitionedFile => Iterator[InternalRow] =
    {
        log.info ("buildReader")

        new (PartitionedFile => Iterator[InternalRow]) with Serializable
        {
            override def apply (file: PartitionedFile): Iterator[InternalRow] =
            {
                Iterator.empty // not implemented
            }
        }
    }

    /**
     * Returns a [[OutputWriterFactory]] for generating output writers that can write data.
     * <em>Currently not supported</em>
     */
    override def buildWriter (
        sqlContext: SQLContext,
        dataSchema: StructType,
        options: Map[String, String]): OutputWriterFactory =
    {
        throw new UnsupportedOperationException ("buildWriter is not supported")
    }
}