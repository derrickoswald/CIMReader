package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * This is the IEC 61970 CIM version number assigned to this UML model.
 *
 * @param Element Reference to the superclass object.
 * @param date Form is YYYY-MM-DD for example for January 5, 2009 it is 2009-01-05.
 * @param version Form is IEC61970CIMXXvYY where XX is the major CIM package version and the YY is the minor version.
 *        For example IEC61970CIM13v18.
 * @group IEC61970
 * @groupname IEC61970 Package IEC61970
 * @groupdesc IEC61970 Top package for IEC 61970.
 */
final case class IEC61970CIMVersion
(
    Element: BasicElement = null,
    date: String = null,
    version: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IEC61970CIMVersion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IEC61970CIMVersion.fields (position), value)
        emitelem (0, date)
        emitelem (1, version)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IEC61970CIMVersion rdf:ID=\"%s\">\n%s\t</cim:IEC61970CIMVersion>".format (id, export_fields)
    }
}

object IEC61970CIMVersion
extends
    Parseable[IEC61970CIMVersion]
{
    override val fields: Array[String] = Array[String] (
        "date",
        "version"
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val version: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): IEC61970CIMVersion =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IEC61970CIMVersion (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (version (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _IEC61970
{
    def register: List[ClassInfo] =
    {
        List (
            IEC61970CIMVersion.register
        )
    }
}