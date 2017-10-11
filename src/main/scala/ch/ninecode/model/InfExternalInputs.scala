package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Requirements for minimum amount of reserve and/or regulation to be supplied by a set of qualified resources.
 *
 * @param sup [[ch.ninecode.model.ResourceGroupReq ResourceGroupReq]] Reference to the superclass object.
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] Market product associated with reserve requirement must be a reserve or regulation product.
 * @param ReserveReqCurve [[ch.ninecode.model.ReserveReqCurve ReserveReqCurve]] <em>undocumented</em>
 * @param SensitivityPriceCurve [[ch.ninecode.model.SensitivityPriceCurve SensitivityPriceCurve]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ReserveReq
(
    override val sup: ResourceGroupReq,
    MarketProduct: String,
    ReserveReqCurve: String,
    SensitivityPriceCurve: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ResourceGroupReq: ResourceGroupReq = sup.asInstanceOf[ResourceGroupReq]
    override def copy (): Row = { clone ().asInstanceOf[ReserveReq] }
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
        (if (null != MarketProduct) "\t\t<cim:ReserveReq.MarketProduct rdf:resource=\"#" + MarketProduct + "\"/>\n" else "") +
        (if (null != ReserveReqCurve) "\t\t<cim:ReserveReq.ReserveReqCurve rdf:resource=\"#" + ReserveReqCurve + "\"/>\n" else "") +
        (if (null != SensitivityPriceCurve) "\t\t<cim:ReserveReq.SensitivityPriceCurve rdf:resource=\"#" + SensitivityPriceCurve + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReserveReq rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReserveReq>"
    }
}

object ReserveReq
extends
    Parseable[ReserveReq]
{
    val MarketProduct = parse_attribute (attribute ("""ReserveReq.MarketProduct"""))
    val ReserveReqCurve = parse_attribute (attribute ("""ReserveReq.ReserveReqCurve"""))
    val SensitivityPriceCurve = parse_attribute (attribute ("""ReserveReq.SensitivityPriceCurve"""))
    def parse (context: Context): ReserveReq =
    {
        ReserveReq(
            ResourceGroupReq.parse (context),
            MarketProduct (context),
            ReserveReqCurve (context),
            SensitivityPriceCurve (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketProduct", "MarketProduct", false),
        Relationship ("ReserveReqCurve", "ReserveReqCurve", false),
        Relationship ("SensitivityPriceCurve", "SensitivityPriceCurve", false))
}

/**
 * A curve relating  reserve requirement versus time, showing the values of a specific reserve requirement for each unit of the period covered.
 *
 * The  curve can be based on "absolute" time or on "normalized' time.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param ReserveReq [[ch.ninecode.model.ReserveReq ReserveReq]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ReserveReqCurve
(
    override val sup: Curve,
    ReserveReq: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ReserveReqCurve] }
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
        (if (null != ReserveReq) "\t\t<cim:ReserveReqCurve.ReserveReq rdf:resource=\"#" + ReserveReq + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReserveReqCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReserveReqCurve>"
    }
}

object ReserveReqCurve
extends
    Parseable[ReserveReqCurve]
{
    val ReserveReq = parse_attribute (attribute ("""ReserveReqCurve.ReserveReq"""))
    def parse (context: Context): ReserveReqCurve =
    {
        ReserveReqCurve(
            Curve.parse (context),
            ReserveReq (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ReserveReq", "ReserveReq", false))
}

/**
 * A logical grouping of resources that are used to model location of types of requirements for ancillary services such as spinning reserve zones, regulation zones, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status Status of this group.
 * @param typ Type of this group.
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ResourceGroup
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ResourceGroup] }
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
        (if (null != status) "\t\t<cim:ResourceGroup.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:ResourceGroup.type>" + typ + "</cim:ResourceGroup.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceGroup>"
    }
}

object ResourceGroup
extends
    Parseable[ResourceGroup]
{
    val status = parse_attribute (attribute ("""ResourceGroup.status"""))
    val typ = parse_element (element ("""ResourceGroup.type"""))
    def parse (context: Context): ResourceGroup =
    {
        ResourceGroup(
            IdentifiedObject.parse (context),
            status (context),
            typ (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Ancillary service requirements for a market.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RTOs [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param ResourceGroup [[ch.ninecode.model.ResourceGroup ResourceGroup]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ResourceGroupReq
(
    override val sup: IdentifiedObject,
    RTOs: List[String],
    ResourceGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ResourceGroupReq] }
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
        (if (null != RTOs) RTOs.map (x => "\t\t<cim:ResourceGroupReq.RTOs rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ResourceGroup) "\t\t<cim:ResourceGroupReq.ResourceGroup rdf:resource=\"#" + ResourceGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceGroupReq rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceGroupReq>"
    }
}

object ResourceGroupReq
extends
    Parseable[ResourceGroupReq]
{
    val RTOs = parse_attributes (attribute ("""ResourceGroupReq.RTOs"""))
    val ResourceGroup = parse_attribute (attribute ("""ResourceGroupReq.ResourceGroup"""))
    def parse (context: Context): ResourceGroupReq =
    {
        ResourceGroupReq(
            IdentifiedObject.parse (context),
            RTOs (context),
            ResourceGroup (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("RTOs", "RTO", true),
        Relationship ("ResourceGroup", "ResourceGroup", false))
}

/**
 * Optionally, this curve expresses elasticity of the associated requirement.
 *
 * For example, used to reduce requirements when clearing price exceeds reasonable values when the supply quantity becomes scarce. For example, a single point value of \$1000/MW for a spinning reserve will cause a reduction in the required spinning reserve.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param ReserveReq [[ch.ninecode.model.ReserveReq ReserveReq]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class SensitivityPriceCurve
(
    override val sup: Curve,
    ReserveReq: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[SensitivityPriceCurve] }
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
        (if (null != ReserveReq) "\t\t<cim:SensitivityPriceCurve.ReserveReq rdf:resource=\"#" + ReserveReq + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SensitivityPriceCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SensitivityPriceCurve>"
    }
}

object SensitivityPriceCurve
extends
    Parseable[SensitivityPriceCurve]
{
    val ReserveReq = parse_attribute (attribute ("""SensitivityPriceCurve.ReserveReq"""))
    def parse (context: Context): SensitivityPriceCurve =
    {
        SensitivityPriceCurve(
            Curve.parse (context),
            ReserveReq (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ReserveReq", "ReserveReq", false))
}

private[ninecode] object _InfExternalInputs
{
    def register: List[ClassInfo] =
    {
        List (
            ReserveReq.register,
            ReserveReqCurve.register,
            ResourceGroup.register,
            ResourceGroupReq.register,
            SensitivityPriceCurve.register
        )
    }
}