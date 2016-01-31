package ch.ninecode

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.InputSplit
import org.apache.hadoop.mapreduce.JobContext
import org.apache.hadoop.mapreduce.RecordReader
import org.apache.hadoop.mapreduce.TaskAttemptContext

class CIMInputFormat extends FileInputFormat[String, Element]
{
    /**
     * Generate the list of files and make them into FileSplits.
     *
     * Logically split the set of input files for the job.
     * Each InputSplit is then assigned to an individual Mapper for processing.
     * Note: The split is a logical split of the inputs and the input files are not physically split into chunks.
     * For e.g. a split could be <input-file-path, start, offset> tuple.
     * The InputFormat also creates the RecordReader to consume the InputSplit objects produced.
     *
     * @param context the job context
     * @returns the list of FileSplit objects for the job
     * @throws IOException
     */
    override def getSplits (context: JobContext): java.util.List[InputSplit] =
    {
        var ret: java.util.List[InputSplit] = new java.util.ArrayList[InputSplit]

        // Note: we don't need to override this yet,
        // but the JobContext has the Credentials (@see org.apache.hadoop.mapreduce.JobContext.getCredentials())
        // which would be checked here.
        ret = super.getSplits (context)

        return (ret)
    }

   /**
    * Create a record reader for a given split. The framework will call
    * {@link RecordReader#initialize(InputSplit, TaskAttemptContext)} before
    * the split is used.
    * @param split the split to be read
    * @param context the information about the task
    * @return a new record reader
    */
    def createRecordReader (split: InputSplit, context: TaskAttemptContext): RecordReader[String, Element] =
    {
        return (new CIMRecordReader ());
    }
}
