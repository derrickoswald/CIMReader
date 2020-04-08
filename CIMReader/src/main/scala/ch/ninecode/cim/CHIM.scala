package ch.ninecode.cim

import java.io.File
import java.io.FileInputStream
import java.nio.CharBuffer
import java.nio.ByteBuffer
import java.nio.charset.{Charset, CharsetEncoder}
import java.util.regex.{Matcher, Pattern}

import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.HashMap
import scala.language.existentials
import scala.reflect.ClassTag
import scala.reflect.classTag
import scala.reflect.runtime.universe.TypeTag

import ch.ninecode.model._

/**
 * Provides common infrastructure for parsing CIM elements.
 * Subclasses (actually their companion objects) must implement the <code>parse</code> method.
 * Other methods are helpers for parsing the regular XML structure of CIM rdf files.
 */
trait Parser
{
    import Parser._

    type Expression = (Pattern, Int)

    type Field = Option[String]
    trait FielderFunction
    {
        def apply ()(implicit context:Context): Field
    }
    type Fielder = FielderFunction

    type Fields = Option[List[String]]
    trait FielderFunctionMultiple
    {
        def apply ()(implicit context:Context): Fields
    }
    type FielderMultiple = FielderFunctionMultiple

    val fields: Array[String] = Array ()
    val relations: List[Relationship] = List ()

    /**
     * Regular expression to parse an element.
     * For example: <cim:ACLineSegment.r>0.224</cim:ACLineSegment.r>
     * @param cls The class name.
     * @param name The element name (without namespace prefix).
     * @return The compiled regex pattern and the index of the match group.
     */
    def element (cls: String, name: String): Expression =
    {
        val trigger = s"$namespace:$cls.$name"
        (Pattern.compile ("""<""" + trigger + """>([\s\S]*?)<\/""" + trigger + """>"""), 1)
    }

    /**
     * Regular expression to parse an attribute.
     * For example: <cim:ACLineSegmentPhase.phase rdf:resource="http://iec.ch/TC57/2013/CIM-schema-cim16#SinglePhaseKind.A"/>
     * @param cls The class name.
     * @param name The attribute name (without namespace prefix).
     * @return The compiled regex pattern and the index of the match group.
     */
    def attribute (cls: String, name: String): Expression =
    {
        val trigger = s"$namespace:$cls.$name"
        (Pattern.compile ("""<""" + trigger + """\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>"""), 2)
    }

    /**
     * Abstract parse function.
     * To be overridden in each implemented class.
     * This is intended to be used by the companion object of
     * each CIM class to provide a way to parse the XML element
     * and generate the CIM class.
     * The hierarchical nature of the generated elements necessitates
     * CIM classes to call their CIM superclass parser, for example,
     * since Terminal is a subclass of ACDCTerminal, it should
     * invoke the superclass parse method.
     * {{{
     *     def parse (context: Context): Terminal =
     *     {
     *         Terminal
     *         (
     *             ACDCTerminal.parse (context),
     *             ...
     *         )
     *     }
     * }}}
     * @param context The context for the substring in the XML and
     * line number and position context for reporting in case of an error.
     * @return The parsed CIM element, e.g. ACLineSegment.
     */
    def parse (context: Context): Element

    /**
     * Create a function to parse one XML element from a string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the element.
     */
    def parse_element (pattern: Expression): FielderFunction =
    {
        // Anonymous function to parse an element field
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The matched group from the regular expression, or null if the pattern wasn't found.
        new FielderFunction
        {
            def apply () (implicit context: Context): Field =
            {
                val matcher = pattern._1.matcher (context.subxml)
                if (matcher.find ())
                {
                    val string = matcher.group (pattern._2)
                    if (Context.DEBUG)
                        context.coverage.append ((matcher.start, matcher.end))
                    Some (string)
                }
                else
                    None
            }
        }
    }

    /**
     * Parse one or more XML elements from a string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the elements.
     */
    def parse_elements (pattern: Expression): FielderFunctionMultiple =
    {
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The matched group(s) from the regular expression or null if none were found.
        new FielderFunctionMultiple
        {
            def apply () (implicit context: Context): Fields =
            {
                val matcher = pattern._1.matcher (context.subxml)
                val enumerator = new Iterator[String]()
                    {
                        def hasNext: Boolean = matcher.find ()
                        def next (): String =
                        {
                            if (Context.DEBUG)
                                context.coverage.append ((matcher.start, matcher.end))
                            matcher.group (pattern._2)
                        }
                    }
                val iterator = for (string <- enumerator)
                    yield string
                if (iterator.isEmpty) None else Some (iterator.toList)
            }
        }
    }

    /**
     * Create a function to parse one attribute from an XML string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the attribute.
     */
    def parse_attribute (pattern: (Pattern, Int)): FielderFunction =
    {
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The attribute value (with leading # stripped off), or null if the pattern wasn't found.
        new FielderFunction
        {
            def apply () (implicit context: Context): Field =
            {
                val matcher = pattern._1.matcher (context.subxml)
                if (matcher.find ())
                {
                    val start = matcher.start (pattern._2)
                    val end = matcher.end (pattern._2)
                    if ((-1 != start) && (-1 != end))
                    {
                        val begin = if ('#' == context.subxml.charAt (start)) start + 1 else start // remove '#'
                        val string = context.subxml.subSequence (begin, end).toString
                        if (Context.DEBUG)
                            context.coverage.append ((matcher.start, matcher.end))
                        Option (string)
                    }
                    else
                        None
                }
                else
                    None
            }
        }
    }

    /**
     * Create a function to parse one or more attributes from an XML string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the attributes.
     */
    def parse_attributes (pattern: (Pattern, Int)): FielderMultiple =
    {
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The attribute value(s) (with leading # stripped off).
        new FielderFunctionMultiple
        {
            def apply () (implicit context: Context): Fields =
            {
                val matcher = pattern._1.matcher (context.subxml)
                val enumerator = new Iterator[Option[String]]()
                {
                    def hasNext: Boolean = matcher.find ()
                    def next (): Option[String] =
                    {
                        val start = matcher.start (pattern._2)
                        val end = matcher.end (pattern._2)
                        if ((-1 != start) && (-1 != end))
                        {
                            val begin = if ('#' == context.subxml.charAt (start)) start + 1 else start // remove '#'
                            val string = context.subxml.subSequence (begin, end).toString
                            if (Context.DEBUG)
                                context.coverage.append ((matcher.start, matcher.end))
                            Some (string)
                        }
                        else
                            None
                    }
                }
                val iterator = for (string <- enumerator)
                    yield string
                val l = iterator.flatten
                if (l.isEmpty) None else Some (l.toList)
            }
        }
    }

    /**
     * Convert a string into a boolean.
     * @param string The string to convert. Should be either "true" or "false". <null> and the empty string are considered false.
     * @param context The context for reporting in case of an unparseable boolean.
     * @return The boolean value.
     */
    def toBoolean (string: String) (implicit context: Context): Boolean =
    {
        var ret = false

        if ((null != string) && ("" != string))
            try
                ret = string.toBoolean
            catch
            {
                case _: Throwable => throw new Exception (s"unparsable boolean ($string) found while parsing at line ${context.line_number()}")
            }

        ret
    }

    /**
     * Convert a string into an integer.
     * @param string The string to convert. Should be just digits although whitespace at the beginning or end is tolerated.
     * @param context The context for reporting in case of an unparseable integer.
     * @return The integer value.
     */
    def toInteger (string: String) (implicit context: Context): Int =
    {
        var ret: Int = 0

        if ((null != string) && ("" != string))
            try
                ret = string.trim.toInt
            catch
            {
                case _: Throwable => throw new Exception (s"unparsable integer ($string) found while parsing at line ${context.line_number()}")
            }

        ret
    }

    /**
     * Convert a string into a floating point value.
     * @param string The string to convert. Should be a valid floating point formatted number although whitespace at the beginning or end is tolerated.
     * @param context The context for reporting in case of an unparseable double.
     * @return The double value.
     */
    def toDouble (string: String) (implicit context: Context): Double =
    {
        var ret = 0.0

        if ((null != string) && ("" != string))
            try
                ret = string.trim.toDouble
            catch
            {
                case _: Throwable => throw new Exception (s"unparsable double ($string) found while parsing at line ${context.line_number()}")
            }

        ret
    }
}

/**
 * Holds constant members of the Parser trait.
 * Includes constants for use by subclasses and the parser.
 * This parser companion object is only needed because Scala doesn't have a static declaration,
 * and instead invents a "companion object" to hold the trait or class
 * members that should be accessible without an instantiated object.
 */
object Parser
{
    /**
     * The CIM namespace ("cim").
     */
    val namespace: String = "cim"
    /**
     * The regular expression for parsing top level elements.
     */
    val rddex: Pattern = Pattern.compile ("""\s*<(""" + namespace + """:[^>\.\s]+)([>\s][\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace
}

case class Relationship (
    field: String,
    clazz: String,
    this_cardinality: String,
    mate_cardinality: String)
{
    def multiple: Boolean = !(this_cardinality.equals ("1") || this_cardinality.endsWith ("..1"))
    // true if the class with this relationship is the N side in a 1:N relation
    def heavyside: Boolean = multiple && (mate_cardinality.equals ("1") || mate_cardinality.endsWith ("..1"))
}

case class ClassInfo (
    name: String,
    parseable: Parseable[Product],
    subsetter: CIMSubsetter[_ <: Product],
    relations: List[Relationship])

/**
 * Typed base class for registration and subsetting.
 * Provides facilities to register subclasses with the CHIM parsing framework
 * and forms the subsetting 'typed object' to specify RDDs of specific CIM classes.
 * Typical usage:
 * {{{
 * object Terminal extends Parseable[Terminal]
 * {
 *     // implement Parser abstract method
 *     def parse (context: Context): Terminal = ???
 * }
 * }}}
 *
 * @tparam A The CIM class type.
 */
abstract class Parseable[+A <: Product : ClassTag : TypeTag] extends Parser
{
    val runtime_class: Class[_] = classTag[A].runtimeClass
    val classname: String = runtime_class.getName
    val cls: String = classname.substring (classname.lastIndexOf (".") + 1)
    val subsetter: CIMSubsetter[_ <: Product] = new CIMSubsetter[A]()
    def register: ClassInfo =
        ClassInfo (cls, this, subsetter, relations)
    def mask (field: Field, position: Int) (implicit bitfields: Array[Int]): String =
    {
        field match
        {
            case Some (string) =>
                bitfields(position / 32) |= (1 << (position % 32))
                string
            case None =>
                null
        }
    }
    def masks (fields: Fields, position: Int) (implicit bitfields: Array[Int]): List[String] =
    {
        fields match
        {
            case Some (list) =>
                bitfields(position / 32) |= (1 << (position % 32))
                list
            case None =>
                null
        }
    }
}

// Classes are organized by CIM package in .scala files and arranged alphabetically within the package.
// All attributes have been included for the classes except:
//   - m:n relations, e.g. ConnectDisconnectFunctions in Switch
//   - containment attributes and relations
// At the end of a package .scala file is an object with the same name as the package
// with an underscore prefix, e.g. _Common, used to register the classes at runtime.
// ** It is important to include any new classes in their package object so they are registered **

/**
 * Common Hierarchical Information Model
 * CIM classes for parsing RDF files.
 * @param xml The CIM RDF to parse.
 * @param start The initial character position in the xml to start parsing at.
 * @param finish The final character position in the xml to parse.
 * @param first_byte The first byte offset of the xml.
 * @param last_byte The last byte offset within the xml at which to stop parsing.
 */
class CHIM (val xml: String, val start: Long = 0L, val finish: Long = 0L, val first_byte: Long = 0L, val last_byte: Long = 0L) extends Serializable
{
    val last: Long = if (last_byte != 0L) last_byte else xml.getBytes ("UTF-8").length
    val context: Context = new Context (xml, start, start, first_byte)
    val matcher: Matcher = Parser.rddex.matcher (xml)
    val bytes: ByteBuffer = ByteBuffer.wrap (new Array[Byte] (4 * CHIM.OVERREAD))
    val encoder: CharsetEncoder = Charset.forName ("UTF-8").newEncoder ()
    var value: Element = _

    lazy val classes: List[ClassInfo] =
        List (
            _AlternateModels.register,
            _AssetInfo.register,
            _AssetMeas.register,
            _Assets.register,
            _AsynchronousMachineDynamics.register,
            _AuxiliaryEquipment.register,
            _CSC.register,
            _Common.register,
            _CongestionRevenueRights.register,
            _Contingency.register,
            _ControlArea.register,
            _Core.register,
            _Customers.register,
            _DC.register,
            _DER.register,
            _DiagramLayout.register,
            _DiscontinuousExcitationControlDynamics.register,
            _Domain.register,
            _EnergyArea.register,
            _EnvDomain.register,
            _Environmental.register,
            _Equivalents.register,
            _ExcitationSystemDynamics.register,
            _ExternalInputs.register,
            _Faults.register,
            _Feeder.register,
            _GenerationTrainingSimulation.register,
            _GenericDataSet.register,
            _HVDCDynamics.register,
            _ICCPConfiguration.register,
            _IEC61968.register,
            _IEC61970.register,
            _IEC62325.register,
            _InfAssetInfo.register,
            _InfAssets.register,
            _InfAvailabilityPlans.register,
            _InfCommon.register,
            _InfCongestionRevenueRights.register,
            _InfCustomers.register,
            _InfDomain.register,
            _InfERPSupport.register,
            _InfEnergyScheduling.register,
            _InfExternalInputs.register,
            _InfFinancial.register,
            _InfHVDCDynamics.register,
            _InfLocations.register,
            _InfMarketOpCommon.register,
            _InfMarketOperations.register,
            _InfMarketResults.register,
            _InfOperationalLimits.register,
            _InfParticipantInterfaces.register,
            _InfReferenceData.register,
            _InfReservation.register,
            _InfSIPS.register,
            _InfTypeAsset.register,
            _InfWiresExt.register,
            _InfWork.register,
            _LoadControl.register,
            _LoadDynamics.register,
            _LoadModel.register,
            _MarketCommon.register,
            _MarketManagement.register,
            _MarketOpCommon.register,
            _MarketPlan.register,
            _MarketQualitySystem.register,
            _MarketResults.register,
            _Meas.register,
            _MechanicalLoadDynamics.register,
            _Metering.register,
            _ModelOperations.register,
            _NetworkModelFrames.register,
            _NetworkModelProjects.register,
            _OperationalLimits.register,
            _Operations.register,
            _OverexcitationLimiterDynamics.register,
            _PFVArControllerType1Dynamics.register,
            _PFVArControllerType2Dynamics.register,
            _PackageDependencies.register,
            _ParticipantInterfaces.register,
            _PaymentMetering.register,
            _PowerSystemStabilizerDynamics.register,
            _Production.register,
            _Protection.register,
            _ReferenceData.register,
            _SCADA.register,
            _StandardInterconnections.register,
            _StandardModels.register,
            _StateVariables.register,
            _StaticVarCompensatorDynamics.register,
            _SynchronousMachineDynamics.register,
            _Topology.register,
            _TurbineGovernorDynamics.register,
            _TurbineLoadControllerDynamics.register,
            _UnderexcitationLimiterDynamics.register,
            _UserDefinedModels.register,
            _VSC.register,
            _VoltageAdjusterDynamics.register,
            _VoltageCompensatorDynamics.register,
            _WindDynamics.register,
            _Wires.register,
            _Work.register,
            _unused.register
        ).flatten
    lazy val parsers: List[(String, Parseable[Product])] = classes.map (x => (s"${Parser.namespace}:${x.name}", x.parseable))
    lazy val lookup: HashMap[String, Parseable[Product]] = HashMap (parsers: _*)

    def progress (): Float =
    {
        (context.end - context.start).toFloat / xml.length ().toFloat
    }

    def byte_count (xml: String, begin: Int, end: Int): Int =
    {
        val cb = CharBuffer.wrap (xml, begin, end)
        val _ = bytes.rewind
        val cr = encoder.encode (cb, bytes, true)
        if (!cr.isUnderflow)
            cr.throwException ()
        bytes.position
    }

    def parse_one (): Boolean =
    {
        var ret = false

        var found = false
        if (context.last_byte < last)
        {
            while (!found && matcher.find ())
            {
                val name = matcher.group (1)
                // heuristic (along with the while and the 'not a dot' in rddex regular expression)
                // that allows jumping into the middle of a large file:
                // top level RDF elements do not have a period in their name
                if (!name.contains ('.'))
                {
                    context.subxml = matcher.group (2)
                    Unknown.name = name
                    value = lookup.getOrElse (name, Unknown).parse (context)

                    // return success unless there was unrecognized text before the match
                    // that wasn't at the start of the xml
                    if (context.end != (matcher.start + context.start))
                    {
                        val unknown = xml.substring (context.end.toInt, matcher.start + context.start.toInt)
                        if (context.end == context.start)
                        {
                            context.end += unknown.length
                            val l = byte_count (unknown, 0, unknown.length)
                            context.last_byte += l
                            ret = true // ignore unrecognized text at the start of the xml string
                        }
                        else
                        {
                            val snippet = if (unknown.length > 50) s"${unknown.substring (0, 50)}..." else unknown
                            context.errors.append (s"""Unknown content "$snippet" at line ${context.line_number ()}""")
                            ret = false
                        }
                    }
                    else
                        ret = true
                    // or there is non-whitespace not covered
                    if (Context.DEBUG)
                        if (!context.covered () && Context.STOP_ON_ERROR)
                            ret = false

                    // set up for next parse
                    val l = byte_count (xml, context.end.toInt - context.start.toInt, matcher.end)
                    context.last_byte += l
                    context.end = matcher.end () + context.start
                    context.coverage.clear
                    found = true
                }
            }
        }

        ret
    }
}

object CHIM
{
    val CHUNK: Int = 1024*1024*64
    val OVERREAD: Int = 1024*256 // should be large enough that no RDF element is bigger than this

    def parse (parser: CHIM): (scala.collection.mutable.HashMap[String, Element], ArrayBuffer[String]) =
    {
        val result = new scala.collection.mutable.HashMap[String, Element]
        while (parser.parse_one ())
        {
            val _ = result.put (parser.value.id, parser.value)
        }
        (result, parser.context.errors)
    }

    def apply_to_all_classes (fn: CIMSubsetter[_] => Unit): Unit =
    {
        val chim = new CHIM ("") // ensure registration has occurred
        for (i <- chim.classes)
            fn (i.subsetter)
    }

    def read (filename: String, start: Long, size: Long, overread: Long = OVERREAD): (String, Long, Long) =
    {
        val file = new File (filename)
        val end = start + size
        if (file.exists ())
        {
            // open the file and skip to the starting offset
            val in = new FileInputStream (file)
            val skipped = in.skip (start)
            if (start == skipped)
            {
                val extra = if (in.available () > end - start) CHIM.OVERREAD else 0
                // ToDo: may need to handle block sizes bigger than 2GB - what happens for size > 2^31?
                val size = (end - start + extra).toInt
                val buffer = new Array[Byte] (size)
                val _ = in.read (buffer)

                val low =
                    if (0 == start)
                        // strip any BOM(Byte Order Mark) i.e. 0xEF,0xBB,0xBF
                        if ((size >= 3) && (buffer(0) == 0xef) && (buffer(1) == 0xbb) && (buffer(2) == 0xbf))
                            3
                        else
                            0
                    else
                        0

                val first =
                    if (0 != start)
                    {
                        // skip to next UTF-8 non-continuation byte (high order bit zero)
                        // by advancing past at most 4 bytes
                        var i = 0
                        if ((buffer(low + i) & 0xc0) != 0xc0) // check for the start of a UTF-8 character
                            while (0 != (buffer(low + i) & 0x80) && (i < Math.min (4, size)))
                                i += 1
                        low + i
                    }
                    else
                        low

                val len = new String (buffer, first, size - first - extra, "UTF-8").length
                val xml = new String (buffer, first, size - first, "UTF-8")
                (xml, first, first + len)
            }
            else
                ("", 0L, 0L)
        }
        else
            ("", 0L, 0L)
    }

    /**
     * Main program for testing purposes.
     */
    def main (args: Array[String])
    {
        if (args.length > 0)
        {
            if (args.length > 1)
            {
                println ("Press [Return] to continue...")
                val _ = System.console().readLine()
            }

            val filename = args (0)
            val fis = new FileInputStream (filename)
            val size = fis.available ()
            fis.close ()

            val result = new scala.collection.mutable.HashMap[String, Element]
            var offset = 0L
            var reading = 0.0
            var parsing = 0.0
            while (offset < size)
            {
                val start = System.nanoTime
                val (xml, lo, hi) = read (filename, offset, CHUNK)
                val before = System.nanoTime
                reading += (before - start) / 1000

                val parser = new CHIM (xml, lo, hi, offset, offset + CHUNK)
                offset += CHUNK
                val map = CHIM.parse (parser)
                val _ = result ++= map._1

                val after = System.nanoTime
                parsing += (after - before) / 1000
                print (".")

                for (error <- parser.context.errors)
                    println (error)
            }
            println ()

            println (f"reading ${reading / 1e6}%g seconds")
            println (f"parsing ${parsing / 1e6}%g seconds")
            println (s"${result.size} identified elements parsed")
            val subset = result.values.filter (_.getClass == classOf[Unknown])
            println (s"${subset.size} unknown elements")
        }
        else
            println ("CIM XML input file not specified")
    }
}
