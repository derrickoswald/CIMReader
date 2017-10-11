package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Site of an interface between interchange areas.
 *
 * The tie point can be a network branch (e.g., transmission line or transformer) or a switching device. For transmission lines, the interchange area boundary is usually at a designated point such as the middle of the line. Line end metering is then corrected for line losses.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tiePointMWRating The MW rating of the tie point.
 * @group InfReservation
 * @groupname InfReservation Package InfReservation
 */
case class TiePoint
(
    override val sup: IdentifiedObject,
    tiePointMWRating: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TiePoint] }
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
        "\t\t<cim:TiePoint.tiePointMWRating>" + tiePointMWRating + "</cim:TiePoint.tiePointMWRating>\n"
    }
    override def export: String =
    {
        "\t<cim:TiePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TiePoint>"
    }
}

object TiePoint
extends
    Parseable[TiePoint]
{
    val tiePointMWRating = parse_element (element ("""TiePoint.tiePointMWRating"""))
    def parse (context: Context): TiePoint =
    {
        TiePoint(
            IdentifiedObject.parse (context),
            toDouble (tiePointMWRating (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

private[ninecode] object _InfReservation
{
    def register: List[ClassInfo] =
    {
        List (
            TiePoint.register
        )
    }
}