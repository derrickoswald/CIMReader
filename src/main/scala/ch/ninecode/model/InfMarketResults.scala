package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Model of market clearing related to results at the inter-ties.
 *
 * Identifies interval
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class InterTieClearing
(
    override val sup: MarketFactors
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[InterTieClearing] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:InterTieClearing rdf:ID=\"%s\">\n%s\t</cim:InterTieClearing>".format (id, export_fields)
    }
}

object InterTieClearing
extends
    Parseable[InterTieClearing]
{

    def parse (context: Context): InterTieClearing =
    {
        implicit val ctx: Context = context
        val ret = InterTieClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides the tie point specific output from the market applications.
 *
 * Currently, this is defined as the loop flow compensation MW value.
 *
 * @param sup Reference to the superclass object.
 * @param baseMW Net Actual MW Flow
 * @param clearedValue Net Dispatched MW
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterTieClearing [[ch.ninecode.model.InterTieClearing InterTieClearing]] <em>undocumented</em>
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class InterTieResults
(
    override val sup: BasicElement,
    baseMW: Double,
    clearedValue: Double,
    Flowgate: String,
    InterTieClearing: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[InterTieResults] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = InterTieResults.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InterTieResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InterTieResults.fields (position), value)
        emitelem (0, baseMW)
        emitelem (1, clearedValue)
        emitattr (2, Flowgate)
        emitattr (3, InterTieClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InterTieResults rdf:ID=\"%s\">\n%s\t</cim:InterTieResults>".format (id, export_fields)
    }
}

object InterTieResults
extends
    Parseable[InterTieResults]
{
    val fields: Array[String] = Array[String] (
        "baseMW",
        "clearedValue",
        "Flowgate",
        "InterTieClearing"
    )
    val baseMW: Fielder = parse_element (element (cls, fields(0)))
    val clearedValue: Fielder = parse_element (element (cls, fields(1)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(2)))
    val InterTieClearing: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): InterTieResults =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = InterTieResults (
            BasicElement.parse (context),
            toDouble (mask (baseMW (), 0)),
            toDouble (mask (clearedValue (), 1)),
            mask (Flowgate (), 2),
            mask (InterTieClearing (), 3)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("InterTieClearing", "InterTieClearing", false)
    )
}

/**
 * Market case clearing results are posted for a given settlement period.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param caseType Settlement period:
 *        'DA - Bid-in'
 *        'DA - Reliability'
 *        'DA - Amp1'
 *        'DA - Amp2'
 *        'RT - Ex-Ante'
 *        'RT - Ex-Post'
 *        'RT - Amp1'
 *        'RT - Amp2'
 * @param modifiedDate Last time and date clearing results were manually modified.
 * @param postedDate Bid clearing results posted time and date.
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class MarketCaseClearing
(
    override val sup: MarketFactors,
    caseType: String,
    modifiedDate: String,
    postedDate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[MarketCaseClearing] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketCaseClearing.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketCaseClearing.fields (position), value)
        emitelem (0, caseType)
        emitelem (1, modifiedDate)
        emitelem (2, postedDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketCaseClearing rdf:ID=\"%s\">\n%s\t</cim:MarketCaseClearing>".format (id, export_fields)
    }
}

object MarketCaseClearing
extends
    Parseable[MarketCaseClearing]
{
    val fields: Array[String] = Array[String] (
        "caseType",
        "modifiedDate",
        "postedDate"
    )
    val caseType: Fielder = parse_element (element (cls, fields(0)))
    val modifiedDate: Fielder = parse_element (element (cls, fields(1)))
    val postedDate: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): MarketCaseClearing =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MarketCaseClearing (
            MarketFactors.parse (context),
            mask (caseType (), 0),
            mask (modifiedDate (), 1),
            mask (postedDate (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Binding security constrained clearing results posted for a given settlement period.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param mwFlow Optimal MW flow
 * @param mwLimit Binding MW limit.
 * @param shadowPrice Security constraint shadow price.
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class SecurityConstraintsClearing
(
    override val sup: MarketFactors,
    mwFlow: Double,
    mwLimit: Double,
    shadowPrice: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[SecurityConstraintsClearing] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SecurityConstraintsClearing.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SecurityConstraintsClearing.fields (position), value)
        emitelem (0, mwFlow)
        emitelem (1, mwLimit)
        emitelem (2, shadowPrice)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SecurityConstraintsClearing rdf:ID=\"%s\">\n%s\t</cim:SecurityConstraintsClearing>".format (id, export_fields)
    }
}

object SecurityConstraintsClearing
extends
    Parseable[SecurityConstraintsClearing]
{
    val fields: Array[String] = Array[String] (
        "mwFlow",
        "mwLimit",
        "shadowPrice"
    )
    val mwFlow: Fielder = parse_element (element (cls, fields(0)))
    val mwLimit: Fielder = parse_element (element (cls, fields(1)))
    val shadowPrice: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): SecurityConstraintsClearing =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = SecurityConstraintsClearing (
            MarketFactors.parse (context),
            toDouble (mask (mwFlow (), 0)),
            toDouble (mask (mwLimit (), 1)),
            toDouble (mask (shadowPrice (), 2))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _InfMarketResults
{
    def register: List[ClassInfo] =
    {
        List (
            InterTieClearing.register,
            InterTieResults.register,
            MarketCaseClearing.register,
            SecurityConstraintsClearing.register
        )
    }
}