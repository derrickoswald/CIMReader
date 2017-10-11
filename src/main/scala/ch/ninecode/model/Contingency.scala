package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An event threatening system reliability, consisting of one or more contingency elements.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param mustStudy Set true if must study this contingency.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
case class Contingency
(
    override val sup: IdentifiedObject,
    mustStudy: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Contingency] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:Contingency.mustStudy>" + mustStudy + "</cim:Contingency.mustStudy>\n"
    }
    override def export: String =
    {
        "\t<cim:Contingency rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Contingency>"
    }
}

object Contingency
extends
    Parseable[Contingency]
{
    val mustStudy = parse_element (element ("""Contingency.mustStudy"""))
    def parse (context: Context): Contingency =
    {
        Contingency(
            IdentifiedObject.parse (context),
            toBoolean (mustStudy (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * An element of a system event to be studied by contingency analysis, representing a change in status of a single piece of equipment.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Contingency [[ch.ninecode.model.Contingency Contingency]] A contingency element belongs to one contingency.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
case class ContingencyElement
(
    override val sup: IdentifiedObject,
    Contingency: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ContingencyElement] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != Contingency) "\t\t<cim:ContingencyElement.Contingency rdf:resource=\"#" + Contingency + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ContingencyElement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ContingencyElement>"
    }
}

object ContingencyElement
extends
    Parseable[ContingencyElement]
{
    val Contingency = parse_attribute (attribute ("""ContingencyElement.Contingency"""))
    def parse (context: Context): ContingencyElement =
    {
        ContingencyElement(
            IdentifiedObject.parse (context),
            Contingency (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Contingency", "Contingency", false))
}

/**
 * A equipment to which the in service status is to change such as a power transformer or AC line segment.
 *
 * @param sup [[ch.ninecode.model.ContingencyElement ContingencyElement]] Reference to the superclass object.
 * @param contingentStatus The status for the associated equipment when in the contingency state.
 *        This status is independent of the case to which the contingency is originally applied, but defines the equipment status when the contingency is applied.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The single piece of equipment to which to apply the contingency.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
case class ContingencyEquipment
(
    override val sup: ContingencyElement,
    contingentStatus: String,
    Equipment: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ContingencyElement: ContingencyElement = sup.asInstanceOf[ContingencyElement]
    override def copy (): Row = { clone ().asInstanceOf[ContingencyEquipment] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != contingentStatus) "\t\t<cim:ContingencyEquipment.contingentStatus rdf:resource=\"#" + contingentStatus + "\"/>\n" else "") +
        (if (null != Equipment) "\t\t<cim:ContingencyEquipment.Equipment rdf:resource=\"#" + Equipment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ContingencyEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ContingencyEquipment>"
    }
}

object ContingencyEquipment
extends
    Parseable[ContingencyEquipment]
{
    val contingentStatus = parse_attribute (attribute ("""ContingencyEquipment.contingentStatus"""))
    val Equipment = parse_attribute (attribute ("""ContingencyEquipment.Equipment"""))
    def parse (context: Context): ContingencyEquipment =
    {
        ContingencyEquipment(
            ContingencyElement.parse (context),
            contingentStatus (context),
            Equipment (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", false))
}

private[ninecode] object _Contingency
{
    def register: List[ClassInfo] =
    {
        List (
            Contingency.register,
            ContingencyElement.register,
            ContingencyEquipment.register
        )
    }
}