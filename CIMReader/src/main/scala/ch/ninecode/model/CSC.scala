package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**

 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CCAinverter
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CCAinverter rdf:ID=\"%s\">\n%s\t</cim:CCAinverter>".format (id, export_fields)
    }
}

object CCAinverter
extends
    Parseable[CCAinverter]
{

    def parse (context: Context): CCAinverter =
    {
        val ret = CCAinverter (
            BasicElement.parse (context)
        )
        ret
    }
}

/**

 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CCArectifierControl
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CCArectifierControl rdf:ID=\"%s\">\n%s\t</cim:CCArectifierControl>".format (id, export_fields)
    }
}

object CCArectifierControl
extends
    Parseable[CCArectifierControl]
{

    def parse (context: Context): CCArectifierControl =
    {
        val ret = CCArectifierControl (
            BasicElement.parse (context)
        )
        ret
    }
}

/**

 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CSCtype1
(
    override val sup: CSCDynamics = null
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
    def CSCDynamics: CSCDynamics = sup
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CSCtype1 rdf:ID=\"%s\">\n%s\t</cim:CSCtype1>".format (id, export_fields)
    }
}

object CSCtype1
extends
    Parseable[CSCtype1]
{

    def parse (context: Context): CSCtype1 =
    {
        val ret = CSCtype1 (
            CSCDynamics.parse (context)
        )
        ret
    }
}

/**

 * @group CSC
 * @groupname CSC Package CSC
 */
final case class IdcInverterControl
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:IdcInverterControl rdf:ID=\"%s\">\n%s\t</cim:IdcInverterControl>".format (id, export_fields)
    }
}

object IdcInverterControl
extends
    Parseable[IdcInverterControl]
{

    def parse (context: Context): IdcInverterControl =
    {
        val ret = IdcInverterControl (
            BasicElement.parse (context)
        )
        ret
    }
}

/**

 * @group CSC
 * @groupname CSC Package CSC
 */
final case class IgnAngleContInverter
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:IgnAngleContInverter rdf:ID=\"%s\">\n%s\t</cim:IgnAngleContInverter>".format (id, export_fields)
    }
}

object IgnAngleContInverter
extends
    Parseable[IgnAngleContInverter]
{

    def parse (context: Context): IgnAngleContInverter =
    {
        val ret = IgnAngleContInverter (
            BasicElement.parse (context)
        )
        ret
    }
}

/**

 * @group CSC
 * @groupname CSC Package CSC
 */
final case class VDCOL
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:VDCOL rdf:ID=\"%s\">\n%s\t</cim:VDCOL>".format (id, export_fields)
    }
}

object VDCOL
extends
    Parseable[VDCOL]
{

    def parse (context: Context): VDCOL =
    {
        val ret = VDCOL (
            BasicElement.parse (context)
        )
        ret
    }
}

private[ninecode] object _CSC
{
    def register: List[ClassInfo] =
    {
        List (
            CCAinverter.register,
            CCArectifierControl.register,
            CSCtype1.register,
            IdcInverterControl.register,
            IgnAngleContInverter.register,
            VDCOL.register
        )
    }
}