package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Models Ancillary Service Requirements.
 *
 * Describes interval for which the requirement is applicable.
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ASRequirements
(
    override val sup: BasicElement,
    intervalStartTime: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ASRequirements] }
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
        (if (null != intervalStartTime) "\t\t<cim:ASRequirements.intervalStartTime>" + intervalStartTime + "</cim:ASRequirements.intervalStartTime>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ASRequirements rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ASRequirements>"
    }
}

object ASRequirements
extends
    Parseable[ASRequirements]
{
    val intervalStartTime = parse_element (element ("""ASRequirements.intervalStartTime"""))
    def parse (context: Context): ASRequirements =
    {
        ASRequirements(
            BasicElement.parse (context),
            intervalStartTime (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Measurement quality flags for Analog Values.
 *
 * @param sup [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] Reference to the superclass object.
 * @param scadaQualityCode The quality code for the given Analog Value.
 * @param MktAnalogValue [[ch.ninecode.model.MktAnalogValue MktAnalogValue]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class AnalogMeasurementValueQuality
(
    override val sup: MeasurementValueQuality,
    scadaQualityCode: String,
    MktAnalogValue: String
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
    def MeasurementValueQuality: MeasurementValueQuality = sup.asInstanceOf[MeasurementValueQuality]
    override def copy (): Row = { clone ().asInstanceOf[AnalogMeasurementValueQuality] }
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
        (if (null != scadaQualityCode) "\t\t<cim:AnalogMeasurementValueQuality.scadaQualityCode>" + scadaQualityCode + "</cim:AnalogMeasurementValueQuality.scadaQualityCode>\n" else "") +
        (if (null != MktAnalogValue) "\t\t<cim:AnalogMeasurementValueQuality.MktAnalogValue rdf:resource=\"#" + MktAnalogValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogMeasurementValueQuality rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogMeasurementValueQuality>"
    }
}

object AnalogMeasurementValueQuality
extends
    Parseable[AnalogMeasurementValueQuality]
{
    val scadaQualityCode = parse_element (element ("""AnalogMeasurementValueQuality.scadaQualityCode"""))
    val MktAnalogValue = parse_attribute (attribute ("""AnalogMeasurementValueQuality.MktAnalogValue"""))
    def parse (context: Context): AnalogMeasurementValueQuality =
    {
        AnalogMeasurementValueQuality(
            MeasurementValueQuality.parse (context),
            scadaQualityCode (context),
            MktAnalogValue (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktAnalogValue", "MktAnalogValue", false))
}

/**
 * Area load curve definition.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param forecastType Load forecast area type.
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param MktLoadArea [[ch.ninecode.model.MktLoadArea MktLoadArea]] <em>undocumented</em>
 * @param TACArea [[ch.ninecode.model.TACArea TACArea]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class AreaLoadCurve
(
    override val sup: RegularIntervalSchedule,
    forecastType: String,
    AggregateNode: String,
    MktLoadArea: String,
    TACArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[AreaLoadCurve] }
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
        (if (null != forecastType) "\t\t<cim:AreaLoadCurve.forecastType rdf:resource=\"#" + forecastType + "\"/>\n" else "") +
        (if (null != AggregateNode) "\t\t<cim:AreaLoadCurve.AggregateNode rdf:resource=\"#" + AggregateNode + "\"/>\n" else "") +
        (if (null != MktLoadArea) "\t\t<cim:AreaLoadCurve.MktLoadArea rdf:resource=\"#" + MktLoadArea + "\"/>\n" else "") +
        (if (null != TACArea) "\t\t<cim:AreaLoadCurve.TACArea rdf:resource=\"#" + TACArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AreaLoadCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AreaLoadCurve>"
    }
}

object AreaLoadCurve
extends
    Parseable[AreaLoadCurve]
{
    val forecastType = parse_attribute (attribute ("""AreaLoadCurve.forecastType"""))
    val AggregateNode = parse_attribute (attribute ("""AreaLoadCurve.AggregateNode"""))
    val MktLoadArea = parse_attribute (attribute ("""AreaLoadCurve.MktLoadArea"""))
    val TACArea = parse_attribute (attribute ("""AreaLoadCurve.TACArea"""))
    def parse (context: Context): AreaLoadCurve =
    {
        AreaLoadCurve(
            RegularIntervalSchedule.parse (context),
            forecastType (context),
            AggregateNode (context),
            MktLoadArea (context),
            TACArea (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("AggregateNode", "AggregateNode", false),
        Relationship ("MktLoadArea", "MktLoadArea", false),
        Relationship ("TACArea", "TACArea", false))
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) assigned to a contingency analysis base case.
 *
 * Use CurveSchedule XAxisUnits to specify MW or MVA. To be used only if the BaseCaseConstraintLimit differs from the DefaultConstraintLimit.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class BaseCaseConstraintLimit
(
    override val sup: Curve,
    SecurityConstraintSum: String
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
    override def copy (): Row = { clone ().asInstanceOf[BaseCaseConstraintLimit] }
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
        (if (null != SecurityConstraintSum) "\t\t<cim:BaseCaseConstraintLimit.SecurityConstraintSum rdf:resource=\"#" + SecurityConstraintSum + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BaseCaseConstraintLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BaseCaseConstraintLimit>"
    }
}

object BaseCaseConstraintLimit
extends
    Parseable[BaseCaseConstraintLimit]
{
    val SecurityConstraintSum = parse_attribute (attribute ("""BaseCaseConstraintLimit.SecurityConstraintSum"""))
    def parse (context: Context): BaseCaseConstraintLimit =
    {
        BaseCaseConstraintLimit(
            Curve.parse (context),
            SecurityConstraintSum (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false))
}

/**
 * Dynamic flows and ratings associated with a branch end.
 *
 * @param sup Reference to the superclass object.
 * @param loadDumpRating The Load Dump Rating for the branch
 * @param longTermRating The Long Term Rating for the branch
 * @param mVARFlow The MVAR flow on the branch
 *        Attribute Usage: Reactive power flow at the series device, transformer, phase shifter, or line end
 * @param mwFlow The MW flow on the branch
 *        Attribute Usage: Active power flow at the series device, transformer, phase shifter, or line end
 * @param normalRating The Normal Rating for the branch
 * @param shortTermRating The Short Term Rating for the branch
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class BranchEndFlow
(
    override val sup: BasicElement,
    loadDumpRating: Double,
    longTermRating: Double,
    mVARFlow: Double,
    mwFlow: Double,
    normalRating: Double,
    shortTermRating: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BranchEndFlow] }
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
        "\t\t<cim:BranchEndFlow.loadDumpRating>" + loadDumpRating + "</cim:BranchEndFlow.loadDumpRating>\n" +
        "\t\t<cim:BranchEndFlow.longTermRating>" + longTermRating + "</cim:BranchEndFlow.longTermRating>\n" +
        "\t\t<cim:BranchEndFlow.mVARFlow>" + mVARFlow + "</cim:BranchEndFlow.mVARFlow>\n" +
        "\t\t<cim:BranchEndFlow.mwFlow>" + mwFlow + "</cim:BranchEndFlow.mwFlow>\n" +
        "\t\t<cim:BranchEndFlow.normalRating>" + normalRating + "</cim:BranchEndFlow.normalRating>\n" +
        "\t\t<cim:BranchEndFlow.shortTermRating>" + shortTermRating + "</cim:BranchEndFlow.shortTermRating>\n"
    }
    override def export: String =
    {
        "\t<cim:BranchEndFlow rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BranchEndFlow>"
    }
}

object BranchEndFlow
extends
    Parseable[BranchEndFlow]
{
    val loadDumpRating = parse_element (element ("""BranchEndFlow.loadDumpRating"""))
    val longTermRating = parse_element (element ("""BranchEndFlow.longTermRating"""))
    val mVARFlow = parse_element (element ("""BranchEndFlow.mVARFlow"""))
    val mwFlow = parse_element (element ("""BranchEndFlow.mwFlow"""))
    val normalRating = parse_element (element ("""BranchEndFlow.normalRating"""))
    val shortTermRating = parse_element (element ("""BranchEndFlow.shortTermRating"""))
    def parse (context: Context): BranchEndFlow =
    {
        BranchEndFlow(
            BasicElement.parse (context),
            toDouble (loadDumpRating (context), context),
            toDouble (longTermRating (context), context),
            toDouble (mVARFlow (context), context),
            toDouble (mwFlow (context), context),
            toDouble (normalRating (context), context),
            toDouble (shortTermRating (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * A constraint term is one element of a linear constraint.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param factor <em>undocumented</em>
 * @param function The function is an enumerated value that can be 'active', 'reactive', or 'VA' to indicate the type of flow.
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ConstraintTerm
(
    override val sup: IdentifiedObject,
    factor: String,
    function: String,
    SecurityConstraintSum: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ConstraintTerm] }
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
        (if (null != factor) "\t\t<cim:ConstraintTerm.factor>" + factor + "</cim:ConstraintTerm.factor>\n" else "") +
        (if (null != function) "\t\t<cim:ConstraintTerm.function>" + function + "</cim:ConstraintTerm.function>\n" else "") +
        (if (null != SecurityConstraintSum) "\t\t<cim:ConstraintTerm.SecurityConstraintSum rdf:resource=\"#" + SecurityConstraintSum + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConstraintTerm rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConstraintTerm>"
    }
}

object ConstraintTerm
extends
    Parseable[ConstraintTerm]
{
    val factor = parse_element (element ("""ConstraintTerm.factor"""))
    val function = parse_element (element ("""ConstraintTerm.function"""))
    val SecurityConstraintSum = parse_attribute (attribute ("""ConstraintTerm.SecurityConstraintSum"""))
    def parse (context: Context): ConstraintTerm =
    {
        ConstraintTerm(
            IdentifiedObject.parse (context),
            factor (context),
            function (context),
            SecurityConstraintSum (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false))
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) assigned to a constraint for a specific contingency.
 *
 * Use CurveSchedule XAxisUnits to specify MW or MVA.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param MWLimitSchedules [[ch.ninecode.model.MWLimitSchedule MWLimitSchedule]] <em>undocumented</em>
 * @param MktContingency [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ContingencyConstraintLimit
(
    override val sup: Curve,
    MWLimitSchedules: String,
    MktContingency: String,
    SecurityConstraintSum: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ContingencyConstraintLimit] }
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
        (if (null != MWLimitSchedules) "\t\t<cim:ContingencyConstraintLimit.MWLimitSchedules rdf:resource=\"#" + MWLimitSchedules + "\"/>\n" else "") +
        (if (null != MktContingency) "\t\t<cim:ContingencyConstraintLimit.MktContingency rdf:resource=\"#" + MktContingency + "\"/>\n" else "") +
        (if (null != SecurityConstraintSum) "\t\t<cim:ContingencyConstraintLimit.SecurityConstraintSum rdf:resource=\"#" + SecurityConstraintSum + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ContingencyConstraintLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ContingencyConstraintLimit>"
    }
}

object ContingencyConstraintLimit
extends
    Parseable[ContingencyConstraintLimit]
{
    val MWLimitSchedules = parse_attribute (attribute ("""ContingencyConstraintLimit.MWLimitSchedules"""))
    val MktContingency = parse_attribute (attribute ("""ContingencyConstraintLimit.MktContingency"""))
    val SecurityConstraintSum = parse_attribute (attribute ("""ContingencyConstraintLimit.SecurityConstraintSum"""))
    def parse (context: Context): ContingencyConstraintLimit =
    {
        ContingencyConstraintLimit(
            Curve.parse (context),
            MWLimitSchedules (context),
            MktContingency (context),
            SecurityConstraintSum (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MWLimitSchedules", "MWLimitSchedule", false),
        Relationship ("MktContingency", "MktContingency", false),
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false))
}

/**
 * State Estimator Solution Pool Interchange and Losses
 *
 * @param sup Reference to the superclass object.
 * @param solvedInterchange Pool MW Interchange
 *        Attribute Usage: The active power interchange of the pool
 * @param solvedLosses Pool Losses MW
 *        Attribute Usage: The active power losses of the pool in MW
 * @param MktControlArea [[ch.ninecode.model.MktControlArea MktControlArea]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ControlAreaSolutionData
(
    override val sup: BasicElement,
    solvedInterchange: Double,
    solvedLosses: Double,
    MktControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ControlAreaSolutionData] }
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
        "\t\t<cim:ControlAreaSolutionData.solvedInterchange>" + solvedInterchange + "</cim:ControlAreaSolutionData.solvedInterchange>\n" +
        "\t\t<cim:ControlAreaSolutionData.solvedLosses>" + solvedLosses + "</cim:ControlAreaSolutionData.solvedLosses>\n" +
        (if (null != MktControlArea) "\t\t<cim:ControlAreaSolutionData.MktControlArea rdf:resource=\"#" + MktControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ControlAreaSolutionData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ControlAreaSolutionData>"
    }
}

object ControlAreaSolutionData
extends
    Parseable[ControlAreaSolutionData]
{
    val solvedInterchange = parse_element (element ("""ControlAreaSolutionData.solvedInterchange"""))
    val solvedLosses = parse_element (element ("""ControlAreaSolutionData.solvedLosses"""))
    val MktControlArea = parse_attribute (attribute ("""ControlAreaSolutionData.MktControlArea"""))
    def parse (context: Context): ControlAreaSolutionData =
    {
        ControlAreaSolutionData(
            BasicElement.parse (context),
            toDouble (solvedInterchange (context), context),
            toDouble (solvedLosses (context), context),
            MktControlArea (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktControlArea", "MktControlArea", false))
}

/**
 * DefaultBid is a generic class to hold Default Energy Bid, Default Startup Bid, and Default Minimum Load Bid:
 * 
 * Default Energy Bid
 * A Default Energy Bid is a monotonically increasing staircase function consisting at maximum 10 economic bid segments, or 10 (\$/MW, MW) pairs.
 *
 * There are three methods for determining the Default Energy Bid:
 *
 * @param sup [[ch.ninecode.model.Bid Bid]] Reference to the superclass object.
 * @param bidType Default bid type such as Default Energy Bid, Default Minimum Load Bid, and Default Startup Bid
 * @param minLoadCost Minimum load cost in \$/hr
 * @param peakFlag on-peak, off-peak, or all
 * @param DefaultBidCurve [[ch.ninecode.model.DefaultBidCurve DefaultBidCurve]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DefaultBid
(
    override val sup: Bid,
    bidType: String,
    minLoadCost: Double,
    peakFlag: String,
    DefaultBidCurve: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { clone ().asInstanceOf[DefaultBid] }
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
        (if (null != bidType) "\t\t<cim:DefaultBid.bidType rdf:resource=\"#" + bidType + "\"/>\n" else "") +
        "\t\t<cim:DefaultBid.minLoadCost>" + minLoadCost + "</cim:DefaultBid.minLoadCost>\n" +
        (if (null != peakFlag) "\t\t<cim:DefaultBid.peakFlag rdf:resource=\"#" + peakFlag + "\"/>\n" else "") +
        (if (null != DefaultBidCurve) "\t\t<cim:DefaultBid.DefaultBidCurve rdf:resource=\"#" + DefaultBidCurve + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:DefaultBid.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DefaultBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DefaultBid>"
    }
}

object DefaultBid
extends
    Parseable[DefaultBid]
{
    val bidType = parse_attribute (attribute ("""DefaultBid.bidType"""))
    val minLoadCost = parse_element (element ("""DefaultBid.minLoadCost"""))
    val peakFlag = parse_attribute (attribute ("""DefaultBid.peakFlag"""))
    val DefaultBidCurve = parse_attribute (attribute ("""DefaultBid.DefaultBidCurve"""))
    val RegisteredResource = parse_attribute (attribute ("""DefaultBid.RegisteredResource"""))
    def parse (context: Context): DefaultBid =
    {
        DefaultBid(
            Bid.parse (context),
            bidType (context),
            toDouble (minLoadCost (context), context),
            peakFlag (context),
            DefaultBidCurve (context),
            RegisteredResource (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("DefaultBidCurve", "DefaultBidCurve", false),
        Relationship ("RegisteredResource", "RegisteredResource", false))
}

/**
 * Default bid curve for default energy bid curve and default startup curves (cost and time)
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param curveType To indicate a type used for a default energy bid curve, such as LMP, cost or consultative based.
 * @param debAdderFlag Default energy bid adder flag
 * @param DefaultBid [[ch.ninecode.model.DefaultBid DefaultBid]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DefaultBidCurve
(
    override val sup: Curve,
    curveType: String,
    debAdderFlag: String,
    DefaultBid: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[DefaultBidCurve] }
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
        (if (null != curveType) "\t\t<cim:DefaultBidCurve.curveType>" + curveType + "</cim:DefaultBidCurve.curveType>\n" else "") +
        (if (null != debAdderFlag) "\t\t<cim:DefaultBidCurve.debAdderFlag rdf:resource=\"#" + debAdderFlag + "\"/>\n" else "") +
        (if (null != DefaultBid) "\t\t<cim:DefaultBidCurve.DefaultBid rdf:resource=\"#" + DefaultBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DefaultBidCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DefaultBidCurve>"
    }
}

object DefaultBidCurve
extends
    Parseable[DefaultBidCurve]
{
    val curveType = parse_element (element ("""DefaultBidCurve.curveType"""))
    val debAdderFlag = parse_attribute (attribute ("""DefaultBidCurve.debAdderFlag"""))
    val DefaultBid = parse_attribute (attribute ("""DefaultBidCurve.DefaultBid"""))
    def parse (context: Context): DefaultBidCurve =
    {
        DefaultBidCurve(
            Curve.parse (context),
            curveType (context),
            debAdderFlag (context),
            DefaultBid (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("DefaultBid", "DefaultBid", false))
}

/**
 * Curve data for default bid curve and startup cost curve.
 *
 * @param sup [[ch.ninecode.model.CurveData CurveData]] Reference to the superclass object.
 * @param bidSegmentCalcType Type of calculation basis used to define the default bid segment curve.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DefaultBidCurveData
(
    override val sup: CurveData,
    bidSegmentCalcType: String
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
    def CurveData: CurveData = sup.asInstanceOf[CurveData]
    override def copy (): Row = { clone ().asInstanceOf[DefaultBidCurveData] }
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
        (if (null != bidSegmentCalcType) "\t\t<cim:DefaultBidCurveData.bidSegmentCalcType rdf:resource=\"#" + bidSegmentCalcType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DefaultBidCurveData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DefaultBidCurveData>"
    }
}

object DefaultBidCurveData
extends
    Parseable[DefaultBidCurveData]
{
    val bidSegmentCalcType = parse_attribute (attribute ("""DefaultBidCurveData.bidSegmentCalcType"""))
    def parse (context: Context): DefaultBidCurveData =
    {
        DefaultBidCurveData(
            CurveData.parse (context),
            bidSegmentCalcType (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) applied as a default value if no specific constraint limits are specified for a contingency analysis.
 *
 * Use CurveSchedule XAxisUnits to specify MW or MVA.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DefaultConstraintLimit
(
    override val sup: Curve,
    SecurityConstraintSum: String
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
    override def copy (): Row = { clone ().asInstanceOf[DefaultConstraintLimit] }
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
        (if (null != SecurityConstraintSum) "\t\t<cim:DefaultConstraintLimit.SecurityConstraintSum rdf:resource=\"#" + SecurityConstraintSum + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DefaultConstraintLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DefaultConstraintLimit>"
    }
}

object DefaultConstraintLimit
extends
    Parseable[DefaultConstraintLimit]
{
    val SecurityConstraintSum = parse_attribute (attribute ("""DefaultConstraintLimit.SecurityConstraintSum"""))
    def parse (context: Context): DefaultConstraintLimit =
    {
        DefaultConstraintLimit(
            Curve.parse (context),
            SecurityConstraintSum (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false))
}

/**
 * Measurement quality flags for Discrete Values.
 *
 * @param sup [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] Reference to the superclass object.
 * @param manualReplaceIndicator Switch Manual Replace Indicator.
 *        Flag indicating that the switch is manual replace.
 * @param removeFromOperationIndicator Removed From Operation Indicator.
 *        Flag indicating that the switch is removed from operation.
 * @param MktDiscreteValue [[ch.ninecode.model.MktDiscreteValue MktDiscreteValue]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DiscreteMeasurementValueQuality
(
    override val sup: MeasurementValueQuality,
    manualReplaceIndicator: Boolean,
    removeFromOperationIndicator: Boolean,
    MktDiscreteValue: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MeasurementValueQuality: MeasurementValueQuality = sup.asInstanceOf[MeasurementValueQuality]
    override def copy (): Row = { clone ().asInstanceOf[DiscreteMeasurementValueQuality] }
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
        "\t\t<cim:DiscreteMeasurementValueQuality.manualReplaceIndicator>" + manualReplaceIndicator + "</cim:DiscreteMeasurementValueQuality.manualReplaceIndicator>\n" +
        "\t\t<cim:DiscreteMeasurementValueQuality.removeFromOperationIndicator>" + removeFromOperationIndicator + "</cim:DiscreteMeasurementValueQuality.removeFromOperationIndicator>\n" +
        (if (null != MktDiscreteValue) "\t\t<cim:DiscreteMeasurementValueQuality.MktDiscreteValue rdf:resource=\"#" + MktDiscreteValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DiscreteMeasurementValueQuality rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscreteMeasurementValueQuality>"
    }
}

object DiscreteMeasurementValueQuality
extends
    Parseable[DiscreteMeasurementValueQuality]
{
    val manualReplaceIndicator = parse_element (element ("""DiscreteMeasurementValueQuality.manualReplaceIndicator"""))
    val removeFromOperationIndicator = parse_element (element ("""DiscreteMeasurementValueQuality.removeFromOperationIndicator"""))
    val MktDiscreteValue = parse_attribute (attribute ("""DiscreteMeasurementValueQuality.MktDiscreteValue"""))
    def parse (context: Context): DiscreteMeasurementValueQuality =
    {
        DiscreteMeasurementValueQuality(
            MeasurementValueQuality.parse (context),
            toBoolean (manualReplaceIndicator (context), context),
            toBoolean (removeFromOperationIndicator (context), context),
            MktDiscreteValue (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktDiscreteValue", "MktDiscreteValue", false))
}

/**
 * A containing class that groups all the distribution factors within a market.
 *
 * This is calculated daily for DA factors and hourly for RT factors.
 *
 * @param sup Reference to the superclass object.
 * @param intervalEndTime The end of the time interval for which requirement is defined.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param marketType <em>undocumented</em>
 * @param GenDistributionFactor [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param SysLoadDistribuFactor [[ch.ninecode.model.SysLoadDistributionFactor SysLoadDistributionFactor]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DistributionFactorSet
(
    override val sup: BasicElement,
    intervalEndTime: String,
    intervalStartTime: String,
    marketType: String,
    GenDistributionFactor: List[String],
    LoadDistributionFactor: List[String],
    SysLoadDistribuFactor: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DistributionFactorSet] }
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
        (if (null != intervalEndTime) "\t\t<cim:DistributionFactorSet.intervalEndTime>" + intervalEndTime + "</cim:DistributionFactorSet.intervalEndTime>\n" else "") +
        (if (null != intervalStartTime) "\t\t<cim:DistributionFactorSet.intervalStartTime>" + intervalStartTime + "</cim:DistributionFactorSet.intervalStartTime>\n" else "") +
        (if (null != marketType) "\t\t<cim:DistributionFactorSet.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != GenDistributionFactor) GenDistributionFactor.map (x => "\t\t<cim:DistributionFactorSet.GenDistributionFactor rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != LoadDistributionFactor) LoadDistributionFactor.map (x => "\t\t<cim:DistributionFactorSet.LoadDistributionFactor rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != SysLoadDistribuFactor) SysLoadDistribuFactor.map (x => "\t\t<cim:DistributionFactorSet.SysLoadDistribuFactor rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:DistributionFactorSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DistributionFactorSet>"
    }
}

object DistributionFactorSet
extends
    Parseable[DistributionFactorSet]
{
    val intervalEndTime = parse_element (element ("""DistributionFactorSet.intervalEndTime"""))
    val intervalStartTime = parse_element (element ("""DistributionFactorSet.intervalStartTime"""))
    val marketType = parse_attribute (attribute ("""DistributionFactorSet.marketType"""))
    val GenDistributionFactor = parse_attributes (attribute ("""DistributionFactorSet.GenDistributionFactor"""))
    val LoadDistributionFactor = parse_attributes (attribute ("""DistributionFactorSet.LoadDistributionFactor"""))
    val SysLoadDistribuFactor = parse_attributes (attribute ("""DistributionFactorSet.SysLoadDistribuFactor"""))
    def parse (context: Context): DistributionFactorSet =
    {
        DistributionFactorSet(
            BasicElement.parse (context),
            intervalEndTime (context),
            intervalStartTime (context),
            marketType (context),
            GenDistributionFactor (context),
            LoadDistributionFactor (context),
            SysLoadDistribuFactor (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("GenDistributionFactor", "GenDistributionFactor", true),
        Relationship ("LoadDistributionFactor", "LoadDistributionFactor", true),
        Relationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", true))
}

/**
 * Optimal Power Flow or State Estimator Load Data for OTS.
 *
 * This is used for RealTime, Study and Maintenance Users
 *
 * @param sup Reference to the superclass object.
 * @param loadMVAR The MVAR load
 *        Attribute Usage: The reactive power consumption of the load in MW
 * @param loadMW The active power consumption of the load in MW
 * @param MktEnergyConsumer [[ch.ninecode.model.MktEnergyConsumer MktEnergyConsumer]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class EnergyConsumerData
(
    override val sup: BasicElement,
    loadMVAR: Double,
    loadMW: Double,
    MktEnergyConsumer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnergyConsumerData] }
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
        "\t\t<cim:EnergyConsumerData.loadMVAR>" + loadMVAR + "</cim:EnergyConsumerData.loadMVAR>\n" +
        "\t\t<cim:EnergyConsumerData.loadMW>" + loadMW + "</cim:EnergyConsumerData.loadMW>\n" +
        (if (null != MktEnergyConsumer) "\t\t<cim:EnergyConsumerData.MktEnergyConsumer rdf:resource=\"#" + MktEnergyConsumer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyConsumerData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyConsumerData>"
    }
}

object EnergyConsumerData
extends
    Parseable[EnergyConsumerData]
{
    val loadMVAR = parse_element (element ("""EnergyConsumerData.loadMVAR"""))
    val loadMW = parse_element (element ("""EnergyConsumerData.loadMW"""))
    val MktEnergyConsumer = parse_attribute (attribute ("""EnergyConsumerData.MktEnergyConsumer"""))
    def parse (context: Context): EnergyConsumerData =
    {
        EnergyConsumerData(
            BasicElement.parse (context),
            toDouble (loadMVAR (context), context),
            toDouble (loadMW (context), context),
            MktEnergyConsumer (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktEnergyConsumer", "MktEnergyConsumer", false))
}

/**
 * An Energy Price Index for each Resource is valid for a period (e.g. daily) that is identified by a Valid Period Start Time and a Valid Period End Time.
 *
 * An Energy Price Index is in \$/MWh.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate End effective date
 * @param energyPriceIndex Energy price index
 * @param energyPriceIndexType EPI type such as wholesale or retail
 * @param lastModified Time updated
 * @param startEffectiveDate Start effective date
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class EnergyPriceIndex
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    energyPriceIndex: Double,
    energyPriceIndexType: String,
    lastModified: String,
    startEffectiveDate: String,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EnergyPriceIndex] }
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
        (if (null != endEffectiveDate) "\t\t<cim:EnergyPriceIndex.endEffectiveDate>" + endEffectiveDate + "</cim:EnergyPriceIndex.endEffectiveDate>\n" else "") +
        "\t\t<cim:EnergyPriceIndex.energyPriceIndex>" + energyPriceIndex + "</cim:EnergyPriceIndex.energyPriceIndex>\n" +
        (if (null != energyPriceIndexType) "\t\t<cim:EnergyPriceIndex.energyPriceIndexType rdf:resource=\"#" + energyPriceIndexType + "\"/>\n" else "") +
        (if (null != lastModified) "\t\t<cim:EnergyPriceIndex.lastModified>" + lastModified + "</cim:EnergyPriceIndex.lastModified>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:EnergyPriceIndex.startEffectiveDate>" + startEffectiveDate + "</cim:EnergyPriceIndex.startEffectiveDate>\n" else "") +
        (if (null != RegisteredGenerator) "\t\t<cim:EnergyPriceIndex.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyPriceIndex rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyPriceIndex>"
    }
}

object EnergyPriceIndex
extends
    Parseable[EnergyPriceIndex]
{
    val endEffectiveDate = parse_element (element ("""EnergyPriceIndex.endEffectiveDate"""))
    val energyPriceIndex = parse_element (element ("""EnergyPriceIndex.energyPriceIndex"""))
    val energyPriceIndexType = parse_attribute (attribute ("""EnergyPriceIndex.energyPriceIndexType"""))
    val lastModified = parse_element (element ("""EnergyPriceIndex.lastModified"""))
    val startEffectiveDate = parse_element (element ("""EnergyPriceIndex.startEffectiveDate"""))
    val RegisteredGenerator = parse_attribute (attribute ("""EnergyPriceIndex.RegisteredGenerator"""))
    def parse (context: Context): EnergyPriceIndex =
    {
        EnergyPriceIndex(
            IdentifiedObject.parse (context),
            endEffectiveDate (context),
            toDouble (energyPriceIndex (context), context),
            energyPriceIndexType (context),
            lastModified (context),
            startEffectiveDate (context),
            RegisteredGenerator (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", false))
}

/**
 * Specifies the start time, stop time, level for an EnergyTransaction.
 *
 * @param sup [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] An EnergyTransaction shall have at least one EnergyProfile.
 * @param TransactionBid [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class EnergyProfile
(
    override val sup: Profile,
    EnergyTransaction: String,
    TransactionBid: String
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
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { clone ().asInstanceOf[EnergyProfile] }
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
        (if (null != EnergyTransaction) "\t\t<cim:EnergyProfile.EnergyTransaction rdf:resource=\"#" + EnergyTransaction + "\"/>\n" else "") +
        (if (null != TransactionBid) "\t\t<cim:EnergyProfile.TransactionBid rdf:resource=\"#" + TransactionBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyProfile rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyProfile>"
    }
}

object EnergyProfile
extends
    Parseable[EnergyProfile]
{
    val EnergyTransaction = parse_attribute (attribute ("""EnergyProfile.EnergyTransaction"""))
    val TransactionBid = parse_attribute (attribute ("""EnergyProfile.TransactionBid"""))
    def parse (context: Context): EnergyProfile =
    {
        EnergyProfile(
            Profile.parse (context),
            EnergyTransaction (context),
            TransactionBid (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", false),
        Relationship ("TransactionBid", "TransactionBid", false))
}

/**
 * Specifies the schedule for energy transfers between interchange areas that are necessary to satisfy the associated interchange transaction.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param capacityBacked Interchange capacity flag.
 *        When the flag is set to true, it indicates a transaction is capacity backed.
 * @param congestChargeMax Maximum congestion charges in monetary units.
 * @param deliveryPointP Delivery point active power.
 * @param energyMin Transaction minimum active power if dispatchable.
 * @param firmInterchangeFlag Firm interchange flag indicates whether or not this energy transaction can be changed without potential financial consequences.
 * @param payCongestion Willing to Pay congestion flag
 * @param reason Reason for energy transaction.
 * @param receiptPointP Receipt point active power.
 * @param state { Approve | Deny | Study }
 * @param EnergyPriceCurves [[ch.ninecode.model.EnergyPriceCurve EnergyPriceCurve]] <em>undocumented</em>
 * @param EnergyProduct [[ch.ninecode.model.EnergyProduct EnergyProduct]] The "Source" for an EnergyTransaction is an EnergyProduct which is injected into a ControlArea.
 *        Typically this is a ServicePoint.
 * @param Export_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] Energy is transferred between interchange areas
 * @param Import_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] Energy is transferred between interchange areas
 * @param TransmissionReservation [[ch.ninecode.model.TransmissionReservation TransmissionReservation]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class EnergyTransaction
(
    override val sup: Document,
    capacityBacked: Boolean,
    congestChargeMax: Double,
    deliveryPointP: Double,
    energyMin: Double,
    firmInterchangeFlag: Boolean,
    payCongestion: Boolean,
    reason: String,
    receiptPointP: Double,
    state: String,
    EnergyPriceCurves: List[String],
    EnergyProduct: String,
    Export_SubControlArea: String,
    Import_SubControlArea: String,
    TransmissionReservation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, false, false, null, 0.0, null, List(), null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[EnergyTransaction] }
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
        "\t\t<cim:EnergyTransaction.capacityBacked>" + capacityBacked + "</cim:EnergyTransaction.capacityBacked>\n" +
        "\t\t<cim:EnergyTransaction.congestChargeMax>" + congestChargeMax + "</cim:EnergyTransaction.congestChargeMax>\n" +
        "\t\t<cim:EnergyTransaction.deliveryPointP>" + deliveryPointP + "</cim:EnergyTransaction.deliveryPointP>\n" +
        "\t\t<cim:EnergyTransaction.energyMin>" + energyMin + "</cim:EnergyTransaction.energyMin>\n" +
        "\t\t<cim:EnergyTransaction.firmInterchangeFlag>" + firmInterchangeFlag + "</cim:EnergyTransaction.firmInterchangeFlag>\n" +
        "\t\t<cim:EnergyTransaction.payCongestion>" + payCongestion + "</cim:EnergyTransaction.payCongestion>\n" +
        (if (null != reason) "\t\t<cim:EnergyTransaction.reason>" + reason + "</cim:EnergyTransaction.reason>\n" else "") +
        "\t\t<cim:EnergyTransaction.receiptPointP>" + receiptPointP + "</cim:EnergyTransaction.receiptPointP>\n" +
        (if (null != state) "\t\t<cim:EnergyTransaction.state rdf:resource=\"#" + state + "\"/>\n" else "") +
        (if (null != EnergyPriceCurves) EnergyPriceCurves.map (x => "\t\t<cim:EnergyTransaction.EnergyPriceCurves rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != EnergyProduct) "\t\t<cim:EnergyTransaction.EnergyProduct rdf:resource=\"#" + EnergyProduct + "\"/>\n" else "") +
        (if (null != Export_SubControlArea) "\t\t<cim:EnergyTransaction.Export_SubControlArea rdf:resource=\"#" + Export_SubControlArea + "\"/>\n" else "") +
        (if (null != Import_SubControlArea) "\t\t<cim:EnergyTransaction.Import_SubControlArea rdf:resource=\"#" + Import_SubControlArea + "\"/>\n" else "") +
        (if (null != TransmissionReservation) "\t\t<cim:EnergyTransaction.TransmissionReservation rdf:resource=\"#" + TransmissionReservation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyTransaction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyTransaction>"
    }
}

object EnergyTransaction
extends
    Parseable[EnergyTransaction]
{
    val capacityBacked = parse_element (element ("""EnergyTransaction.capacityBacked"""))
    val congestChargeMax = parse_element (element ("""EnergyTransaction.congestChargeMax"""))
    val deliveryPointP = parse_element (element ("""EnergyTransaction.deliveryPointP"""))
    val energyMin = parse_element (element ("""EnergyTransaction.energyMin"""))
    val firmInterchangeFlag = parse_element (element ("""EnergyTransaction.firmInterchangeFlag"""))
    val payCongestion = parse_element (element ("""EnergyTransaction.payCongestion"""))
    val reason = parse_element (element ("""EnergyTransaction.reason"""))
    val receiptPointP = parse_element (element ("""EnergyTransaction.receiptPointP"""))
    val state = parse_attribute (attribute ("""EnergyTransaction.state"""))
    val EnergyPriceCurves = parse_attributes (attribute ("""EnergyTransaction.EnergyPriceCurves"""))
    val EnergyProduct = parse_attribute (attribute ("""EnergyTransaction.EnergyProduct"""))
    val Export_SubControlArea = parse_attribute (attribute ("""EnergyTransaction.Export_SubControlArea"""))
    val Import_SubControlArea = parse_attribute (attribute ("""EnergyTransaction.Import_SubControlArea"""))
    val TransmissionReservation = parse_attribute (attribute ("""EnergyTransaction.TransmissionReservation"""))
    def parse (context: Context): EnergyTransaction =
    {
        EnergyTransaction(
            Document.parse (context),
            toBoolean (capacityBacked (context), context),
            toDouble (congestChargeMax (context), context),
            toDouble (deliveryPointP (context), context),
            toDouble (energyMin (context), context),
            toBoolean (firmInterchangeFlag (context), context),
            toBoolean (payCongestion (context), context),
            reason (context),
            toDouble (receiptPointP (context), context),
            state (context),
            EnergyPriceCurves (context),
            EnergyProduct (context),
            Export_SubControlArea (context),
            Import_SubControlArea (context),
            TransmissionReservation (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyPriceCurves", "EnergyPriceCurve", true),
        Relationship ("EnergyProduct", "EnergyProduct", false),
        Relationship ("Export_SubControlArea", "SubControlArea", false),
        Relationship ("Import_SubControlArea", "SubControlArea", false),
        Relationship ("TransmissionReservation", "TransmissionReservation", false))
}

/**
 * This class models the generation distribution factors.
 *
 * This class needs to be used along with the AggregatedPnode and the IndividualPnode to show the distriubtion of each individual party.
 *
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate generation "participation" of an individual pnond in an AggregatePnode.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class GenDistributionFactor
(
    override val sup: BasicElement,
    factor: Double,
    AggregatedPnode: String,
    IndividualPnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[GenDistributionFactor] }
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
        "\t\t<cim:GenDistributionFactor.factor>" + factor + "</cim:GenDistributionFactor.factor>\n" +
        (if (null != AggregatedPnode) "\t\t<cim:GenDistributionFactor.AggregatedPnode rdf:resource=\"#" + AggregatedPnode + "\"/>\n" else "") +
        (if (null != IndividualPnode) "\t\t<cim:GenDistributionFactor.IndividualPnode rdf:resource=\"#" + IndividualPnode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GenDistributionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenDistributionFactor>"
    }
}

object GenDistributionFactor
extends
    Parseable[GenDistributionFactor]
{
    val factor = parse_element (element ("""GenDistributionFactor.factor"""))
    val AggregatedPnode = parse_attribute (attribute ("""GenDistributionFactor.AggregatedPnode"""))
    val IndividualPnode = parse_attribute (attribute ("""GenDistributionFactor.IndividualPnode"""))
    def parse (context: Context): GenDistributionFactor =
    {
        GenDistributionFactor(
            BasicElement.parse (context),
            toDouble (factor (context), context),
            AggregatedPnode (context),
            IndividualPnode (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", false),
        Relationship ("IndividualPnode", "IndividualPnode", false))
}

/**
 * Optimal Power Flow or State Estimator Unit Data for Operator Training Simulator.
 *
 * This is used for RealTime, Study and Maintenance Users
 *
 * @param sup Reference to the superclass object.
 * @param lossFactor Loss Factor
 * @param mVAR Unit reactive power generation in MVAR
 * @param maximumMW The maximum active power generation of the unit in MW
 * @param minimumMW The minimum active power generation of the unit in MW
 * @param mw Unit active power generation in MW
 * @param sensitivity Unit sencivity factor.
 *        The distribution factors (DFAX) for the unit
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param MktGeneratingUnit [[ch.ninecode.model.MktGeneratingUnit MktGeneratingUnit]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class GeneratingUnitDynamicValues
(
    override val sup: BasicElement,
    lossFactor: Double,
    mVAR: Double,
    maximumMW: Double,
    minimumMW: Double,
    mw: Double,
    sensitivity: Double,
    Flowgate: String,
    MktGeneratingUnit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[GeneratingUnitDynamicValues] }
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
        "\t\t<cim:GeneratingUnitDynamicValues.lossFactor>" + lossFactor + "</cim:GeneratingUnitDynamicValues.lossFactor>\n" +
        "\t\t<cim:GeneratingUnitDynamicValues.mVAR>" + mVAR + "</cim:GeneratingUnitDynamicValues.mVAR>\n" +
        "\t\t<cim:GeneratingUnitDynamicValues.maximumMW>" + maximumMW + "</cim:GeneratingUnitDynamicValues.maximumMW>\n" +
        "\t\t<cim:GeneratingUnitDynamicValues.minimumMW>" + minimumMW + "</cim:GeneratingUnitDynamicValues.minimumMW>\n" +
        "\t\t<cim:GeneratingUnitDynamicValues.mw>" + mw + "</cim:GeneratingUnitDynamicValues.mw>\n" +
        "\t\t<cim:GeneratingUnitDynamicValues.sensitivity>" + sensitivity + "</cim:GeneratingUnitDynamicValues.sensitivity>\n" +
        (if (null != Flowgate) "\t\t<cim:GeneratingUnitDynamicValues.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != MktGeneratingUnit) "\t\t<cim:GeneratingUnitDynamicValues.MktGeneratingUnit rdf:resource=\"#" + MktGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GeneratingUnitDynamicValues rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneratingUnitDynamicValues>"
    }
}

object GeneratingUnitDynamicValues
extends
    Parseable[GeneratingUnitDynamicValues]
{
    val lossFactor = parse_element (element ("""GeneratingUnitDynamicValues.lossFactor"""))
    val mVAR = parse_element (element ("""GeneratingUnitDynamicValues.mVAR"""))
    val maximumMW = parse_element (element ("""GeneratingUnitDynamicValues.maximumMW"""))
    val minimumMW = parse_element (element ("""GeneratingUnitDynamicValues.minimumMW"""))
    val mw = parse_element (element ("""GeneratingUnitDynamicValues.mw"""))
    val sensitivity = parse_element (element ("""GeneratingUnitDynamicValues.sensitivity"""))
    val Flowgate = parse_attribute (attribute ("""GeneratingUnitDynamicValues.Flowgate"""))
    val MktGeneratingUnit = parse_attribute (attribute ("""GeneratingUnitDynamicValues.MktGeneratingUnit"""))
    def parse (context: Context): GeneratingUnitDynamicValues =
    {
        GeneratingUnitDynamicValues(
            BasicElement.parse (context),
            toDouble (lossFactor (context), context),
            toDouble (mVAR (context), context),
            toDouble (maximumMW (context), context),
            toDouble (minimumMW (context), context),
            toDouble (mw (context), context),
            toDouble (sensitivity (context), context),
            Flowgate (context),
            MktGeneratingUnit (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("MktGeneratingUnit", "MktGeneratingUnit", false))
}

/**
 * Generic constraints can represent secure areas, voltage profile, transient stability and voltage collapse limits.
 *
 * The generic constraints can be one of the following forms:
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param maxLimit Maximum Limit (MW)
 * @param minLimit Minimum Limit (MW)
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class GenericConstraints
(
    override val sup: IdentifiedObject,
    intervalEndTime: String,
    intervalStartTime: String,
    maxLimit: Double,
    minLimit: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[GenericConstraints] }
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
        (if (null != intervalEndTime) "\t\t<cim:GenericConstraints.intervalEndTime>" + intervalEndTime + "</cim:GenericConstraints.intervalEndTime>\n" else "") +
        (if (null != intervalStartTime) "\t\t<cim:GenericConstraints.intervalStartTime>" + intervalStartTime + "</cim:GenericConstraints.intervalStartTime>\n" else "") +
        "\t\t<cim:GenericConstraints.maxLimit>" + maxLimit + "</cim:GenericConstraints.maxLimit>\n" +
        "\t\t<cim:GenericConstraints.minLimit>" + minLimit + "</cim:GenericConstraints.minLimit>\n"
    }
    override def export: String =
    {
        "\t<cim:GenericConstraints rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenericConstraints>"
    }
}

object GenericConstraints
extends
    Parseable[GenericConstraints]
{
    val intervalEndTime = parse_element (element ("""GenericConstraints.intervalEndTime"""))
    val intervalStartTime = parse_element (element ("""GenericConstraints.intervalStartTime"""))
    val maxLimit = parse_element (element ("""GenericConstraints.maxLimit"""))
    val minLimit = parse_element (element ("""GenericConstraints.minLimit"""))
    def parse (context: Context): GenericConstraints =
    {
        GenericConstraints(
            IdentifiedObject.parse (context),
            intervalEndTime (context),
            intervalStartTime (context),
            toDouble (maxLimit (context), context),
            toDouble (minLimit (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Existing Transmission Contract data for an interchange schedule
 *
 * @param sup Reference to the superclass object.
 * @param contractNumber Existing transmission contract number
 * @param usageMW Existing transmission contract usage MW value
 * @param InterchangeSchedule [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class InterchangeETCData
(
    override val sup: BasicElement,
    contractNumber: String,
    usageMW: Double,
    InterchangeSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[InterchangeETCData] }
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
        (if (null != contractNumber) "\t\t<cim:InterchangeETCData.contractNumber>" + contractNumber + "</cim:InterchangeETCData.contractNumber>\n" else "") +
        "\t\t<cim:InterchangeETCData.usageMW>" + usageMW + "</cim:InterchangeETCData.usageMW>\n" +
        (if (null != InterchangeSchedule) "\t\t<cim:InterchangeETCData.InterchangeSchedule rdf:resource=\"#" + InterchangeSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InterchangeETCData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InterchangeETCData>"
    }
}

object InterchangeETCData
extends
    Parseable[InterchangeETCData]
{
    val contractNumber = parse_element (element ("""InterchangeETCData.contractNumber"""))
    val usageMW = parse_element (element ("""InterchangeETCData.usageMW"""))
    val InterchangeSchedule = parse_attribute (attribute ("""InterchangeETCData.InterchangeSchedule"""))
    def parse (context: Context): InterchangeETCData =
    {
        InterchangeETCData(
            BasicElement.parse (context),
            contractNumber (context),
            toDouble (usageMW (context), context),
            InterchangeSchedule (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("InterchangeSchedule", "InterchangeSchedule", false))
}

/**
 * Interchange schedule class to hold information for interchange schedules such as import export type, energy type, and etc.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param checkOutType To indicate a check out type such as adjusted capacity or dispatch capacity.
 * @param directionType Import or export.
 * @param energyType Energy product type.
 * @param intervalLength Interval length.
 * @param marketType Market type.
 * @param operatingDate Operating date, hour.
 * @param outOfMarketType To indicate an out-of-market (OOM) schedule.
 * @param scheduleType Schedule type.
 * @param wcrID Wheeling Counter-Resource ID (required when Schedule Type=Wheel).
 * @param InterTie [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class InterchangeSchedule
(
    override val sup: Curve,
    checkOutType: String,
    directionType: String,
    energyType: String,
    intervalLength: Int,
    marketType: String,
    operatingDate: String,
    outOfMarketType: Boolean,
    scheduleType: String,
    wcrID: String,
    InterTie: String,
    RegisteredInterTie: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0, null, null, false, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[InterchangeSchedule] }
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
        (if (null != checkOutType) "\t\t<cim:InterchangeSchedule.checkOutType rdf:resource=\"#" + checkOutType + "\"/>\n" else "") +
        (if (null != directionType) "\t\t<cim:InterchangeSchedule.directionType rdf:resource=\"#" + directionType + "\"/>\n" else "") +
        (if (null != energyType) "\t\t<cim:InterchangeSchedule.energyType rdf:resource=\"#" + energyType + "\"/>\n" else "") +
        "\t\t<cim:InterchangeSchedule.intervalLength>" + intervalLength + "</cim:InterchangeSchedule.intervalLength>\n" +
        (if (null != marketType) "\t\t<cim:InterchangeSchedule.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != operatingDate) "\t\t<cim:InterchangeSchedule.operatingDate>" + operatingDate + "</cim:InterchangeSchedule.operatingDate>\n" else "") +
        "\t\t<cim:InterchangeSchedule.outOfMarketType>" + outOfMarketType + "</cim:InterchangeSchedule.outOfMarketType>\n" +
        (if (null != scheduleType) "\t\t<cim:InterchangeSchedule.scheduleType rdf:resource=\"#" + scheduleType + "\"/>\n" else "") +
        (if (null != wcrID) "\t\t<cim:InterchangeSchedule.wcrID>" + wcrID + "</cim:InterchangeSchedule.wcrID>\n" else "") +
        (if (null != InterTie) "\t\t<cim:InterchangeSchedule.InterTie rdf:resource=\"#" + InterTie + "\"/>\n" else "") +
        (if (null != RegisteredInterTie) "\t\t<cim:InterchangeSchedule.RegisteredInterTie rdf:resource=\"#" + RegisteredInterTie + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InterchangeSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InterchangeSchedule>"
    }
}

object InterchangeSchedule
extends
    Parseable[InterchangeSchedule]
{
    val checkOutType = parse_attribute (attribute ("""InterchangeSchedule.checkOutType"""))
    val directionType = parse_attribute (attribute ("""InterchangeSchedule.directionType"""))
    val energyType = parse_attribute (attribute ("""InterchangeSchedule.energyType"""))
    val intervalLength = parse_element (element ("""InterchangeSchedule.intervalLength"""))
    val marketType = parse_attribute (attribute ("""InterchangeSchedule.marketType"""))
    val operatingDate = parse_element (element ("""InterchangeSchedule.operatingDate"""))
    val outOfMarketType = parse_element (element ("""InterchangeSchedule.outOfMarketType"""))
    val scheduleType = parse_attribute (attribute ("""InterchangeSchedule.scheduleType"""))
    val wcrID = parse_element (element ("""InterchangeSchedule.wcrID"""))
    val InterTie = parse_attribute (attribute ("""InterchangeSchedule.InterTie"""))
    val RegisteredInterTie = parse_attribute (attribute ("""InterchangeSchedule.RegisteredInterTie"""))
    def parse (context: Context): InterchangeSchedule =
    {
        InterchangeSchedule(
            Curve.parse (context),
            checkOutType (context),
            directionType (context),
            energyType (context),
            toInteger (intervalLength (context), context),
            marketType (context),
            operatingDate (context),
            toBoolean (outOfMarketType (context), context),
            scheduleType (context),
            wcrID (context),
            InterTie (context),
            RegisteredInterTie (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("InterTie", "SchedulingPoint", false),
        Relationship ("RegisteredInterTie", "RegisteredInterTie", false))
}

/**
 * Indicates whether unit is eligible for treatment as a intermittent variable renewable resource
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param eligibilityStatus Indicates whether a resource is eligible for PIRP program for a given hour
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class IntermittentResourceEligibility
(
    override val sup: MarketFactors,
    eligibilityStatus: String,
    RegisteredResource: String
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[IntermittentResourceEligibility] }
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
        (if (null != eligibilityStatus) "\t\t<cim:IntermittentResourceEligibility.eligibilityStatus>" + eligibilityStatus + "</cim:IntermittentResourceEligibility.eligibilityStatus>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:IntermittentResourceEligibility.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IntermittentResourceEligibility rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IntermittentResourceEligibility>"
    }
}

object IntermittentResourceEligibility
extends
    Parseable[IntermittentResourceEligibility]
{
    val eligibilityStatus = parse_element (element ("""IntermittentResourceEligibility.eligibilityStatus"""))
    val RegisteredResource = parse_attribute (attribute ("""IntermittentResourceEligibility.RegisteredResource"""))
    def parse (context: Context): IntermittentResourceEligibility =
    {
        IntermittentResourceEligibility(
            MarketFactors.parse (context),
            eligibilityStatus (context),
            RegisteredResource (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false))
}

/**
 * This class models the load distribution factors.
 *
 * This class should be used in one of two ways:
 *
 * @param sup Reference to the superclass object.
 * @param pDistFactor Real power (MW) load distribution factor
 * @param qDistFactor Reactive power (MVAr) load distribution factor
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class LoadDistributionFactor
(
    override val sup: BasicElement,
    pDistFactor: Double,
    qDistFactor: Double,
    AggregatedPnode: String,
    IndividualPnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadDistributionFactor] }
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
        "\t\t<cim:LoadDistributionFactor.pDistFactor>" + pDistFactor + "</cim:LoadDistributionFactor.pDistFactor>\n" +
        "\t\t<cim:LoadDistributionFactor.qDistFactor>" + qDistFactor + "</cim:LoadDistributionFactor.qDistFactor>\n" +
        (if (null != AggregatedPnode) "\t\t<cim:LoadDistributionFactor.AggregatedPnode rdf:resource=\"#" + AggregatedPnode + "\"/>\n" else "") +
        (if (null != IndividualPnode) "\t\t<cim:LoadDistributionFactor.IndividualPnode rdf:resource=\"#" + IndividualPnode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadDistributionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadDistributionFactor>"
    }
}

object LoadDistributionFactor
extends
    Parseable[LoadDistributionFactor]
{
    val pDistFactor = parse_element (element ("""LoadDistributionFactor.pDistFactor"""))
    val qDistFactor = parse_element (element ("""LoadDistributionFactor.qDistFactor"""))
    val AggregatedPnode = parse_attribute (attribute ("""LoadDistributionFactor.AggregatedPnode"""))
    val IndividualPnode = parse_attribute (attribute ("""LoadDistributionFactor.IndividualPnode"""))
    def parse (context: Context): LoadDistributionFactor =
    {
        LoadDistributionFactor(
            BasicElement.parse (context),
            toDouble (pDistFactor (context), context),
            toDouble (qDistFactor (context), context),
            AggregatedPnode (context),
            IndividualPnode (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", false),
        Relationship ("IndividualPnode", "IndividualPnode", false))
}

/**
 * Loss sensitivity applied to a ConnectivityNode for a given time interval.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param lossFactor Loss penalty factor.
 *        Defined as: 1 / ( 1 - Incremental Transmission Loss); with the Incremental Transmission Loss expressed as a plus or minus value. The typical range of penalty factors is (0,9 to 1,1).
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class LossSensitivity
(
    override val sup: MarketFactors,
    lossFactor: Double,
    MktConnectivityNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[LossSensitivity] }
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
        "\t\t<cim:LossSensitivity.lossFactor>" + lossFactor + "</cim:LossSensitivity.lossFactor>\n" +
        (if (null != MktConnectivityNode) "\t\t<cim:LossSensitivity.MktConnectivityNode rdf:resource=\"#" + MktConnectivityNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LossSensitivity rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LossSensitivity>"
    }
}

object LossSensitivity
extends
    Parseable[LossSensitivity]
{
    val lossFactor = parse_element (element ("""LossSensitivity.lossFactor"""))
    val MktConnectivityNode = parse_attribute (attribute ("""LossSensitivity.MktConnectivityNode"""))
    def parse (context: Context): LossSensitivity =
    {
        LossSensitivity(
            MarketFactors.parse (context),
            toDouble (lossFactor (context), context),
            MktConnectivityNode (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktConnectivityNode", "MktConnectivityNode", false))
}

/**
 * Maximum MW and optionally Minimum MW (Y1 and Y2, respectively)
 *
 * @param sup Reference to the superclass object.
 * @param SecurityConstraintLimit [[ch.ninecode.model.ContingencyConstraintLimit ContingencyConstraintLimit]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MWLimitSchedule
(
    override val sup: BasicElement,
    SecurityConstraintLimit: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MWLimitSchedule] }
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
        (if (null != SecurityConstraintLimit) "\t\t<cim:MWLimitSchedule.SecurityConstraintLimit rdf:resource=\"#" + SecurityConstraintLimit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MWLimitSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MWLimitSchedule>"
    }
}

object MWLimitSchedule
extends
    Parseable[MWLimitSchedule]
{
    val SecurityConstraintLimit = parse_attribute (attribute ("""MWLimitSchedule.SecurityConstraintLimit"""))
    def parse (context: Context): MWLimitSchedule =
    {
        MWLimitSchedule(
            BasicElement.parse (context),
            SecurityConstraintLimit (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintLimit", "ContingencyConstraintLimit", false))
}

/**
 * Subclass of IEC61970:Wires:ACLineSegment
 *
 * @param sup [[ch.ninecode.model.ACLineSegment ACLineSegment]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktACLineSegment
(
    override val sup: ACLineSegment,
    EndAFlow: String,
    EndBFlow: String
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
    def ACLineSegment: ACLineSegment = sup.asInstanceOf[ACLineSegment]
    override def copy (): Row = { clone ().asInstanceOf[MktACLineSegment] }
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
        (if (null != EndAFlow) "\t\t<cim:MktACLineSegment.EndAFlow rdf:resource=\"#" + EndAFlow + "\"/>\n" else "") +
        (if (null != EndBFlow) "\t\t<cim:MktACLineSegment.EndBFlow rdf:resource=\"#" + EndBFlow + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktACLineSegment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktACLineSegment>"
    }
}

object MktACLineSegment
extends
    Parseable[MktACLineSegment]
{
    val EndAFlow = parse_attribute (attribute ("""MktACLineSegment.EndAFlow"""))
    val EndBFlow = parse_attribute (attribute ("""MktACLineSegment.EndBFlow"""))
    def parse (context: Context): MktACLineSegment =
    {
        MktACLineSegment(
            ACLineSegment.parse (context),
            EndAFlow (context),
            EndBFlow (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", false),
        Relationship ("EndBFlow", "BranchEndFlow", false))
}

/**
 * Subclass of IEC61970:Meas:AnalogLimit
 *
 * @param sup [[ch.ninecode.model.AnalogLimit AnalogLimit]] Reference to the superclass object.
 * @param exceededLimit true if limit exceeded
 * @param limitType The type of limit the value represents
 *        Branch Limit Types:
 *        Short Term
 *        Medium Term
 *        Long Term
 *        Voltage Limits:
 *        High
 *        Low
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktAnalogLimit
(
    override val sup: AnalogLimit,
    exceededLimit: Boolean,
    limitType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AnalogLimit: AnalogLimit = sup.asInstanceOf[AnalogLimit]
    override def copy (): Row = { clone ().asInstanceOf[MktAnalogLimit] }
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
        "\t\t<cim:MktAnalogLimit.exceededLimit>" + exceededLimit + "</cim:MktAnalogLimit.exceededLimit>\n" +
        (if (null != limitType) "\t\t<cim:MktAnalogLimit.limitType rdf:resource=\"#" + limitType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktAnalogLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktAnalogLimit>"
    }
}

object MktAnalogLimit
extends
    Parseable[MktAnalogLimit]
{
    val exceededLimit = parse_element (element ("""MktAnalogLimit.exceededLimit"""))
    val limitType = parse_attribute (attribute ("""MktAnalogLimit.limitType"""))
    def parse (context: Context): MktAnalogLimit =
    {
        MktAnalogLimit(
            AnalogLimit.parse (context),
            toBoolean (exceededLimit (context), context),
            limitType (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Subclass of IEC61970:Meas:AnalogLimitSet
 *
 * @param sup [[ch.ninecode.model.AnalogLimitSet AnalogLimitSet]] Reference to the superclass object.
 * @param ratingSet Rating set numbers
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktAnalogLimitSet
(
    override val sup: AnalogLimitSet,
    ratingSet: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AnalogLimitSet: AnalogLimitSet = sup.asInstanceOf[AnalogLimitSet]
    override def copy (): Row = { clone ().asInstanceOf[MktAnalogLimitSet] }
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
        "\t\t<cim:MktAnalogLimitSet.ratingSet>" + ratingSet + "</cim:MktAnalogLimitSet.ratingSet>\n"
    }
    override def export: String =
    {
        "\t<cim:MktAnalogLimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktAnalogLimitSet>"
    }
}

object MktAnalogLimitSet
extends
    Parseable[MktAnalogLimitSet]
{
    val ratingSet = parse_element (element ("""MktAnalogLimitSet.ratingSet"""))
    def parse (context: Context): MktAnalogLimitSet =
    {
        MktAnalogLimitSet(
            AnalogLimitSet.parse (context),
            toInteger (ratingSet (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Subclass of IEC61970:Meas:AnalogValue
 *
 * @param sup [[ch.ninecode.model.AnalogValue AnalogValue]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktAnalogValue
(
    override val sup: AnalogValue
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AnalogValue: AnalogValue = sup.asInstanceOf[AnalogValue]
    override def copy (): Row = { clone ().asInstanceOf[MktAnalogValue] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MktAnalogValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktAnalogValue>"
    }
}

object MktAnalogValue
extends
    Parseable[MktAnalogValue]
{
    def parse (context: Context): MktAnalogValue =
    {
        MktAnalogValue(
            AnalogValue.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Market subclass of IEC61970:ControlArea
 *
 * @param sup [[ch.ninecode.model.ControlArea ControlArea]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktControlArea
(
    override val sup: ControlArea
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ControlArea: ControlArea = sup.asInstanceOf[ControlArea]
    override def copy (): Row = { clone ().asInstanceOf[MktControlArea] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MktControlArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktControlArea>"
    }
}

object MktControlArea
extends
    Parseable[MktControlArea]
{
    def parse (context: Context): MktControlArea =
    {
        MktControlArea(
            ControlArea.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Subclass of IEC61970:Meas:DiscreteValue
 *
 * @param sup [[ch.ninecode.model.DiscreteValue DiscreteValue]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktDiscreteValue
(
    override val sup: DiscreteValue
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DiscreteValue: DiscreteValue = sup.asInstanceOf[DiscreteValue]
    override def copy (): Row = { clone ().asInstanceOf[MktDiscreteValue] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MktDiscreteValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktDiscreteValue>"
    }
}

object MktDiscreteValue
extends
    Parseable[MktDiscreteValue]
{
    def parse (context: Context): MktDiscreteValue =
    {
        MktDiscreteValue(
            DiscreteValue.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Subclass of IEC61970:Wires:SeriesCompensator
 *
 * @param sup [[ch.ninecode.model.SeriesCompensator SeriesCompensator]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktSeriesCompensator
(
    override val sup: SeriesCompensator,
    EndAFlow: String,
    EndBFlow: String
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
    def SeriesCompensator: SeriesCompensator = sup.asInstanceOf[SeriesCompensator]
    override def copy (): Row = { clone ().asInstanceOf[MktSeriesCompensator] }
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
        (if (null != EndAFlow) "\t\t<cim:MktSeriesCompensator.EndAFlow rdf:resource=\"#" + EndAFlow + "\"/>\n" else "") +
        (if (null != EndBFlow) "\t\t<cim:MktSeriesCompensator.EndBFlow rdf:resource=\"#" + EndBFlow + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktSeriesCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktSeriesCompensator>"
    }
}

object MktSeriesCompensator
extends
    Parseable[MktSeriesCompensator]
{
    val EndAFlow = parse_attribute (attribute ("""MktSeriesCompensator.EndAFlow"""))
    val EndBFlow = parse_attribute (attribute ("""MktSeriesCompensator.EndBFlow"""))
    def parse (context: Context): MktSeriesCompensator =
    {
        MktSeriesCompensator(
            SeriesCompensator.parse (context),
            EndAFlow (context),
            EndBFlow (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", false),
        Relationship ("EndBFlow", "BranchEndFlow", false))
}

/**
 * Subclass of IEC61970:Wires:ShuntCompensator
 *
 * @param sup [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktShuntCompensator
(
    override val sup: ShuntCompensator
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { clone ().asInstanceOf[MktShuntCompensator] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MktShuntCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktShuntCompensator>"
    }
}

object MktShuntCompensator
extends
    Parseable[MktShuntCompensator]
{
    def parse (context: Context): MktShuntCompensator =
    {
        MktShuntCompensator(
            ShuntCompensator.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Subclass of IEC61970:Wires:Switch
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktSwitch
(
    override val sup: Switch
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[MktSwitch] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MktSwitch rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktSwitch>"
    }
}

object MktSwitch
extends
    Parseable[MktSwitch]
{
    def parse (context: Context): MktSwitch =
    {
        MktSwitch(
            Switch.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Subclass of IEC61970:Wires:TapChanger
 *
 * @param sup [[ch.ninecode.model.TapChanger TapChanger]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktTapChanger
(
    override val sup: TapChanger
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { clone ().asInstanceOf[MktTapChanger] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MktTapChanger rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktTapChanger>"
    }
}

object MktTapChanger
extends
    Parseable[MktTapChanger]
{
    def parse (context: Context): MktTapChanger =
    {
        MktTapChanger(
            TapChanger.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * To be used only to constrain a quantity that cannot be associated with a terminal.
 *
 * For example, a registered generating unit that is not electrically connected to the network.
 *
 * @param sup [[ch.ninecode.model.ConstraintTerm ConstraintTerm]] Reference to the superclass object.
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class NodeConstraintTerm
(
    override val sup: ConstraintTerm,
    MktConnectivityNode: String
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
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { clone ().asInstanceOf[NodeConstraintTerm] }
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
        (if (null != MktConnectivityNode) "\t\t<cim:NodeConstraintTerm.MktConnectivityNode rdf:resource=\"#" + MktConnectivityNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NodeConstraintTerm rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NodeConstraintTerm>"
    }
}

object NodeConstraintTerm
extends
    Parseable[NodeConstraintTerm]
{
    val MktConnectivityNode = parse_attribute (attribute ("""NodeConstraintTerm.MktConnectivityNode"""))
    def parse (context: Context): NodeConstraintTerm =
    {
        NodeConstraintTerm(
            ConstraintTerm.parse (context),
            MktConnectivityNode (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktConnectivityNode", "MktConnectivityNode", false))
}

/**
 * A profile is a simpler curve type.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class Profile
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Profile] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:Profile rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Profile>"
    }
}

object Profile
extends
    Parseable[Profile]
{
    def parse (context: Context): Profile =
    {
        Profile(
            IdentifiedObject.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Data for profile.
 *
 * @param sup Reference to the superclass object.
 * @param bidPrice Bid price associated with contract
 * @param capacityLevel Capacity level for the profile, in MW.
 * @param energyLevel Energy level for the profile, in MWH.
 * @param minimumLevel Minimum MW value of contract
 * @param sequenceNumber Sequence to provide item numbering for the profile. { greater than or equal to 1 }
 * @param startDateTime Start date/time for this profile.
 * @param stopDateTime Stop date/time for this profile.
 * @param Profile [[ch.ninecode.model.Profile Profile]] A profile has profile data associated with it.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ProfileData
(
    override val sup: BasicElement,
    bidPrice: Double,
    capacityLevel: Double,
    energyLevel: Double,
    minimumLevel: Double,
    sequenceNumber: Int,
    startDateTime: String,
    stopDateTime: String,
    Profile: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ProfileData] }
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
        "\t\t<cim:ProfileData.bidPrice>" + bidPrice + "</cim:ProfileData.bidPrice>\n" +
        "\t\t<cim:ProfileData.capacityLevel>" + capacityLevel + "</cim:ProfileData.capacityLevel>\n" +
        "\t\t<cim:ProfileData.energyLevel>" + energyLevel + "</cim:ProfileData.energyLevel>\n" +
        "\t\t<cim:ProfileData.minimumLevel>" + minimumLevel + "</cim:ProfileData.minimumLevel>\n" +
        "\t\t<cim:ProfileData.sequenceNumber>" + sequenceNumber + "</cim:ProfileData.sequenceNumber>\n" +
        (if (null != startDateTime) "\t\t<cim:ProfileData.startDateTime>" + startDateTime + "</cim:ProfileData.startDateTime>\n" else "") +
        (if (null != stopDateTime) "\t\t<cim:ProfileData.stopDateTime>" + stopDateTime + "</cim:ProfileData.stopDateTime>\n" else "") +
        (if (null != Profile) Profile.map (x => "\t\t<cim:ProfileData.Profile rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ProfileData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProfileData>"
    }
}

object ProfileData
extends
    Parseable[ProfileData]
{
    val bidPrice = parse_element (element ("""ProfileData.bidPrice"""))
    val capacityLevel = parse_element (element ("""ProfileData.capacityLevel"""))
    val energyLevel = parse_element (element ("""ProfileData.energyLevel"""))
    val minimumLevel = parse_element (element ("""ProfileData.minimumLevel"""))
    val sequenceNumber = parse_element (element ("""ProfileData.sequenceNumber"""))
    val startDateTime = parse_element (element ("""ProfileData.startDateTime"""))
    val stopDateTime = parse_element (element ("""ProfileData.stopDateTime"""))
    val Profile = parse_attributes (attribute ("""ProfileData.Profile"""))
    def parse (context: Context): ProfileData =
    {
        ProfileData(
            BasicElement.parse (context),
            toDouble (bidPrice (context), context),
            toDouble (capacityLevel (context), context),
            toDouble (energyLevel (context), context),
            toDouble (minimumLevel (context), context),
            toInteger (sequenceNumber (context), context),
            startDateTime (context),
            stopDateTime (context),
            Profile (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Profile", "Profile", true))
}

/**
 * Reserve demand curve.
 *
 * Models maximum quantities of reserve required per Market Region and models a reserve demand curve for the minimum quantities of reserve. The ReserveDemandCurve is a relationship between unit operating reserve price in \$/MWhr (Y-axis) and unit reserves in MW (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param reqMaxMW Region requirement maximum limit
 * @param reserveRequirementType Reserve requirement type that the max and curve apply to.
 *        For example, operating reserve, regulation and contingency.
 * @param ASRequirements [[ch.ninecode.model.ASRequirements ASRequirements]] <em>undocumented</em>
 * @param MarketRegion [[ch.ninecode.model.MarketRegion MarketRegion]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ReserveDemandCurve
(
    override val sup: Curve,
    reqMaxMW: Double,
    reserveRequirementType: String,
    ASRequirements: String,
    MarketRegion: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ReserveDemandCurve] }
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
        "\t\t<cim:ReserveDemandCurve.reqMaxMW>" + reqMaxMW + "</cim:ReserveDemandCurve.reqMaxMW>\n" +
        (if (null != reserveRequirementType) "\t\t<cim:ReserveDemandCurve.reserveRequirementType rdf:resource=\"#" + reserveRequirementType + "\"/>\n" else "") +
        (if (null != ASRequirements) "\t\t<cim:ReserveDemandCurve.ASRequirements rdf:resource=\"#" + ASRequirements + "\"/>\n" else "") +
        (if (null != MarketRegion) "\t\t<cim:ReserveDemandCurve.MarketRegion rdf:resource=\"#" + MarketRegion + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReserveDemandCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReserveDemandCurve>"
    }
}

object ReserveDemandCurve
extends
    Parseable[ReserveDemandCurve]
{
    val reqMaxMW = parse_element (element ("""ReserveDemandCurve.reqMaxMW"""))
    val reserveRequirementType = parse_attribute (attribute ("""ReserveDemandCurve.reserveRequirementType"""))
    val ASRequirements = parse_attribute (attribute ("""ReserveDemandCurve.ASRequirements"""))
    val MarketRegion = parse_attribute (attribute ("""ReserveDemandCurve.MarketRegion"""))
    def parse (context: Context): ReserveDemandCurve =
    {
        ReserveDemandCurve(
            Curve.parse (context),
            toDouble (reqMaxMW (context), context),
            reserveRequirementType (context),
            ASRequirements (context),
            MarketRegion (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ASRequirements", "ASRequirements", false),
        Relationship ("MarketRegion", "MarketRegion", false))
}

/**
 * Contains information about the update from SCADA
 *
 * @param sup Reference to the superclass object.
 * @param timeStamp time of the update from SCADA
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SCADAInformation
(
    override val sup: BasicElement,
    timeStamp: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SCADAInformation] }
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
        (if (null != timeStamp) "\t\t<cim:SCADAInformation.timeStamp>" + timeStamp + "</cim:SCADAInformation.timeStamp>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SCADAInformation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SCADAInformation>"
    }
}

object SCADAInformation
extends
    Parseable[SCADAInformation]
{
    val timeStamp = parse_element (element ("""SCADAInformation.timeStamp"""))
    def parse (context: Context): SCADAInformation =
    {
        SCADAInformation(
            BasicElement.parse (context),
            timeStamp (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Typically provided by RTO systems, constraints identified in both base case and critical contingency cases have to be transferred.
 *
 * A constraint has N (&gt;=1) constraint terms. A term is represented by an
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param BaseCaseConstraintLimit [[ch.ninecode.model.BaseCaseConstraintLimit BaseCaseConstraintLimit]] <em>undocumented</em>
 * @param DefaultConstraintLimit [[ch.ninecode.model.DefaultConstraintLimit DefaultConstraintLimit]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SecurityConstraintSum
(
    override val sup: MarketFactors,
    BaseCaseConstraintLimit: String,
    DefaultConstraintLimit: String,
    RTO: String
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[SecurityConstraintSum] }
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
        (if (null != BaseCaseConstraintLimit) "\t\t<cim:SecurityConstraintSum.BaseCaseConstraintLimit rdf:resource=\"#" + BaseCaseConstraintLimit + "\"/>\n" else "") +
        (if (null != DefaultConstraintLimit) "\t\t<cim:SecurityConstraintSum.DefaultConstraintLimit rdf:resource=\"#" + DefaultConstraintLimit + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:SecurityConstraintSum.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SecurityConstraintSum rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SecurityConstraintSum>"
    }
}

object SecurityConstraintSum
extends
    Parseable[SecurityConstraintSum]
{
    val BaseCaseConstraintLimit = parse_attribute (attribute ("""SecurityConstraintSum.BaseCaseConstraintLimit"""))
    val DefaultConstraintLimit = parse_attribute (attribute ("""SecurityConstraintSum.DefaultConstraintLimit"""))
    val RTO = parse_attribute (attribute ("""SecurityConstraintSum.RTO"""))
    def parse (context: Context): SecurityConstraintSum =
    {
        SecurityConstraintSum(
            MarketFactors.parse (context),
            BaseCaseConstraintLimit (context),
            DefaultConstraintLimit (context),
            RTO (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("BaseCaseConstraintLimit", "BaseCaseConstraintLimit", false),
        Relationship ("DefaultConstraintLimit", "DefaultConstraintLimit", false),
        Relationship ("RTO", "RTO", false))
}

/**
 * Typical for regional transmission operators (RTOs), these constraints include transmission as well as generation group constraints identified in both base case and critical contingency cases.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param actualMW Actual branch or group of branches MW flow (only for transmission constraints)
 * @param maxMW Maximum MW limit
 * @param minMW Minimum MW limit (only for transmission constraints).
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param GeneratingBid [[ch.ninecode.model.GeneratingBid GeneratingBid]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SecurityConstraints
(
    override val sup: IdentifiedObject,
    actualMW: Double,
    maxMW: Double,
    minMW: Double,
    Flowgate: String,
    GeneratingBid: String,
    RTO: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[SecurityConstraints] }
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
        "\t\t<cim:SecurityConstraints.actualMW>" + actualMW + "</cim:SecurityConstraints.actualMW>\n" +
        "\t\t<cim:SecurityConstraints.maxMW>" + maxMW + "</cim:SecurityConstraints.maxMW>\n" +
        "\t\t<cim:SecurityConstraints.minMW>" + minMW + "</cim:SecurityConstraints.minMW>\n" +
        (if (null != Flowgate) "\t\t<cim:SecurityConstraints.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != GeneratingBid) "\t\t<cim:SecurityConstraints.GeneratingBid rdf:resource=\"#" + GeneratingBid + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:SecurityConstraints.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SecurityConstraints rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SecurityConstraints>"
    }
}

object SecurityConstraints
extends
    Parseable[SecurityConstraints]
{
    val actualMW = parse_element (element ("""SecurityConstraints.actualMW"""))
    val maxMW = parse_element (element ("""SecurityConstraints.maxMW"""))
    val minMW = parse_element (element ("""SecurityConstraints.minMW"""))
    val Flowgate = parse_attribute (attribute ("""SecurityConstraints.Flowgate"""))
    val GeneratingBid = parse_attribute (attribute ("""SecurityConstraints.GeneratingBid"""))
    val RTO = parse_attribute (attribute ("""SecurityConstraints.RTO"""))
    def parse (context: Context): SecurityConstraints =
    {
        SecurityConstraints(
            IdentifiedObject.parse (context),
            toDouble (actualMW (context), context),
            toDouble (maxMW (context), context),
            toDouble (minMW (context), context),
            Flowgate (context),
            GeneratingBid (context),
            RTO (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("GeneratingBid", "GeneratingBid", false),
        Relationship ("RTO", "RTO", false))
}

/**
 * The defined termination points of a transmission path (down to distribution level or to a customer - generation or consumption or both).
 *
 * Service points are defined from the viewpoint of the transmission service. Each service point is contained within (or on the boundary of) an interchange area. A service point is source or destination of a transaction.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ServicePoint
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ServicePoint] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:ServicePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServicePoint>"
    }
}

object ServicePoint
extends
    Parseable[ServicePoint]
{
    def parse (context: Context): ServicePoint =
    {
        ServicePoint(
            IdentifiedObject.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Optimal Power Flow or State Estimator Filter Bank Data for OTS.
 *
 * This is used for RealTime, Study and Maintenance Users
 *
 * @param sup Reference to the superclass object.
 * @param connectionStatus The current status for the Voltage Control Capacitor 1= Connected 0 = Disconnected
 * @param desiredVoltage The desired voltage for the Voltage Control Capacitor
 * @param mVARInjection The injection of reactive power of the filter bank in the NA solution or VCS reactive power production
 * @param stepPosition Voltage control capacitor step position
 * @param voltageRegulationStatus Indicator if the voltage control this is regulating True = Yes, False = No
 * @param MktShuntCompensator [[ch.ninecode.model.MktShuntCompensator MktShuntCompensator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ShuntCompensatorDynamicData
(
    override val sup: BasicElement,
    connectionStatus: Int,
    desiredVoltage: Double,
    mVARInjection: Double,
    stepPosition: Int,
    voltageRegulationStatus: Boolean,
    MktShuntCompensator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, 0, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ShuntCompensatorDynamicData] }
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
        "\t\t<cim:ShuntCompensatorDynamicData.connectionStatus>" + connectionStatus + "</cim:ShuntCompensatorDynamicData.connectionStatus>\n" +
        "\t\t<cim:ShuntCompensatorDynamicData.desiredVoltage>" + desiredVoltage + "</cim:ShuntCompensatorDynamicData.desiredVoltage>\n" +
        "\t\t<cim:ShuntCompensatorDynamicData.mVARInjection>" + mVARInjection + "</cim:ShuntCompensatorDynamicData.mVARInjection>\n" +
        "\t\t<cim:ShuntCompensatorDynamicData.stepPosition>" + stepPosition + "</cim:ShuntCompensatorDynamicData.stepPosition>\n" +
        "\t\t<cim:ShuntCompensatorDynamicData.voltageRegulationStatus>" + voltageRegulationStatus + "</cim:ShuntCompensatorDynamicData.voltageRegulationStatus>\n" +
        (if (null != MktShuntCompensator) "\t\t<cim:ShuntCompensatorDynamicData.MktShuntCompensator rdf:resource=\"#" + MktShuntCompensator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorDynamicData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShuntCompensatorDynamicData>"
    }
}

object ShuntCompensatorDynamicData
extends
    Parseable[ShuntCompensatorDynamicData]
{
    val connectionStatus = parse_element (element ("""ShuntCompensatorDynamicData.connectionStatus"""))
    val desiredVoltage = parse_element (element ("""ShuntCompensatorDynamicData.desiredVoltage"""))
    val mVARInjection = parse_element (element ("""ShuntCompensatorDynamicData.mVARInjection"""))
    val stepPosition = parse_element (element ("""ShuntCompensatorDynamicData.stepPosition"""))
    val voltageRegulationStatus = parse_element (element ("""ShuntCompensatorDynamicData.voltageRegulationStatus"""))
    val MktShuntCompensator = parse_attribute (attribute ("""ShuntCompensatorDynamicData.MktShuntCompensator"""))
    def parse (context: Context): ShuntCompensatorDynamicData =
    {
        ShuntCompensatorDynamicData(
            BasicElement.parse (context),
            toInteger (connectionStatus (context), context),
            toDouble (desiredVoltage (context), context),
            toDouble (mVARInjection (context), context),
            toInteger (stepPosition (context), context),
            toBoolean (voltageRegulationStatus (context), context),
            MktShuntCompensator (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktShuntCompensator", "MktShuntCompensator", false))
}

/**
 * Optimal Power Flow or State Estimator Circuit Breaker Status.
 *
 * @param sup Reference to the superclass object.
 * @param switchStatus Circuit Breaker Status (closed or open) of the circuit breaker from the power flow.
 * @param MktSwitch [[ch.ninecode.model.MktSwitch MktSwitch]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SwitchStatus
(
    override val sup: BasicElement,
    switchStatus: String,
    MktSwitch: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SwitchStatus] }
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
        (if (null != switchStatus) "\t\t<cim:SwitchStatus.switchStatus rdf:resource=\"#" + switchStatus + "\"/>\n" else "") +
        (if (null != MktSwitch) "\t\t<cim:SwitchStatus.MktSwitch rdf:resource=\"#" + MktSwitch + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchStatus>"
    }
}

object SwitchStatus
extends
    Parseable[SwitchStatus]
{
    val switchStatus = parse_attribute (attribute ("""SwitchStatus.switchStatus"""))
    val MktSwitch = parse_attribute (attribute ("""SwitchStatus.MktSwitch"""))
    def parse (context: Context): SwitchStatus =
    {
        SwitchStatus(
            BasicElement.parse (context),
            switchStatus (context),
            MktSwitch (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktSwitch", "MktSwitch", false))
}

/**
 * This class models the system distribution factors.
 *
 * This class needs to be used along with the HostControlArea and the ConnectivityNode to show the distribution of each individual party.
 *
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate load "participation" of a connectivity node in an host control area
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SysLoadDistributionFactor
(
    override val sup: BasicElement,
    factor: Double,
    HostControlArea: String,
    MktConnectivityNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SysLoadDistributionFactor] }
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
        "\t\t<cim:SysLoadDistributionFactor.factor>" + factor + "</cim:SysLoadDistributionFactor.factor>\n" +
        (if (null != HostControlArea) "\t\t<cim:SysLoadDistributionFactor.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != MktConnectivityNode) "\t\t<cim:SysLoadDistributionFactor.MktConnectivityNode rdf:resource=\"#" + MktConnectivityNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SysLoadDistributionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SysLoadDistributionFactor>"
    }
}

object SysLoadDistributionFactor
extends
    Parseable[SysLoadDistributionFactor]
{
    val factor = parse_element (element ("""SysLoadDistributionFactor.factor"""))
    val HostControlArea = parse_attribute (attribute ("""SysLoadDistributionFactor.HostControlArea"""))
    val MktConnectivityNode = parse_attribute (attribute ("""SysLoadDistributionFactor.MktConnectivityNode"""))
    def parse (context: Context): SysLoadDistributionFactor =
    {
        SysLoadDistributionFactor(
            BasicElement.parse (context),
            toDouble (factor (context), context),
            HostControlArea (context),
            MktConnectivityNode (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("HostControlArea", "HostControlArea", false),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", false))
}

/**
 * A Transmission Right(TR) can be a chain of TR's or on individual.
 *
 * When a transmission right is not a chain, this is formally the ETC/TOR Entitlement for each ETC/TOR contract with the inclusion of CVR(Converted Rights) as an ETC. This is the sum of all entitlements on all related transmission interfaces for the same TR.
 *
 * @param sup Reference to the superclass object.
 * @param entitlement The entitlement
 * @param startOperatingDate Operating date and hour when the entitlement applies
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TREntitlement
(
    override val sup: BasicElement,
    entitlement: Double,
    startOperatingDate: String,
    TransmissionContractRight: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TREntitlement] }
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
        "\t\t<cim:TREntitlement.entitlement>" + entitlement + "</cim:TREntitlement.entitlement>\n" +
        (if (null != startOperatingDate) "\t\t<cim:TREntitlement.startOperatingDate>" + startOperatingDate + "</cim:TREntitlement.startOperatingDate>\n" else "") +
        (if (null != TransmissionContractRight) "\t\t<cim:TREntitlement.TransmissionContractRight rdf:resource=\"#" + TransmissionContractRight + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TREntitlement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TREntitlement>"
    }
}

object TREntitlement
extends
    Parseable[TREntitlement]
{
    val entitlement = parse_element (element ("""TREntitlement.entitlement"""))
    val startOperatingDate = parse_element (element ("""TREntitlement.startOperatingDate"""))
    val TransmissionContractRight = parse_attribute (attribute ("""TREntitlement.TransmissionContractRight"""))
    def parse (context: Context): TREntitlement =
    {
        TREntitlement(
            BasicElement.parse (context),
            toDouble (entitlement (context), context),
            startOperatingDate (context),
            TransmissionContractRight (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("TransmissionContractRight", "ContractRight", false))
}

/**
 * Optimal Power Flow or State Estimator Phase Shifter Data.
 *
 * This is used for RealTime, Study and Maintenance Users. SE Solution Phase Shifter Measurements from the last run of SE
 *
 * @param sup Reference to the superclass object.
 * @param angleRegulationStatus True means the phase shifter is regulating.
 * @param desiredMW Phase Shifter Desired MW.
 *        The active power regulation setpoint of the phase shifter
 * @param desiredVoltage The desired voltage for the LTC
 * @param maximumAngle The maximum phase angle shift of the phase shifter
 * @param minimumAngle The minimum phase angle shift of the phase shifter
 * @param solvedAngle Phase Shifter Angle.
 *        The solved phase angle shift of the phase shifter
 * @param tapPosition Tap position of the phase shifter, high-side tap position of the transformer, or  low-side tap position of the transformer
 * @param voltageRegulationStatus Indicator if the LTC transformer is regulating True = Yes, False = No
 * @param MktTapChanger [[ch.ninecode.model.MktTapChanger MktTapChanger]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TapChangerDynamicData
(
    override val sup: BasicElement,
    angleRegulationStatus: Boolean,
    desiredMW: Double,
    desiredVoltage: Double,
    maximumAngle: Double,
    minimumAngle: Double,
    solvedAngle: Double,
    tapPosition: Double,
    voltageRegulationStatus: Boolean,
    MktTapChanger: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TapChangerDynamicData] }
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
        "\t\t<cim:TapChangerDynamicData.angleRegulationStatus>" + angleRegulationStatus + "</cim:TapChangerDynamicData.angleRegulationStatus>\n" +
        "\t\t<cim:TapChangerDynamicData.desiredMW>" + desiredMW + "</cim:TapChangerDynamicData.desiredMW>\n" +
        "\t\t<cim:TapChangerDynamicData.desiredVoltage>" + desiredVoltage + "</cim:TapChangerDynamicData.desiredVoltage>\n" +
        "\t\t<cim:TapChangerDynamicData.maximumAngle>" + maximumAngle + "</cim:TapChangerDynamicData.maximumAngle>\n" +
        "\t\t<cim:TapChangerDynamicData.minimumAngle>" + minimumAngle + "</cim:TapChangerDynamicData.minimumAngle>\n" +
        "\t\t<cim:TapChangerDynamicData.solvedAngle>" + solvedAngle + "</cim:TapChangerDynamicData.solvedAngle>\n" +
        "\t\t<cim:TapChangerDynamicData.tapPosition>" + tapPosition + "</cim:TapChangerDynamicData.tapPosition>\n" +
        "\t\t<cim:TapChangerDynamicData.voltageRegulationStatus>" + voltageRegulationStatus + "</cim:TapChangerDynamicData.voltageRegulationStatus>\n" +
        (if (null != MktTapChanger) "\t\t<cim:TapChangerDynamicData.MktTapChanger rdf:resource=\"#" + MktTapChanger + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TapChangerDynamicData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TapChangerDynamicData>"
    }
}

object TapChangerDynamicData
extends
    Parseable[TapChangerDynamicData]
{
    val angleRegulationStatus = parse_element (element ("""TapChangerDynamicData.angleRegulationStatus"""))
    val desiredMW = parse_element (element ("""TapChangerDynamicData.desiredMW"""))
    val desiredVoltage = parse_element (element ("""TapChangerDynamicData.desiredVoltage"""))
    val maximumAngle = parse_element (element ("""TapChangerDynamicData.maximumAngle"""))
    val minimumAngle = parse_element (element ("""TapChangerDynamicData.minimumAngle"""))
    val solvedAngle = parse_element (element ("""TapChangerDynamicData.solvedAngle"""))
    val tapPosition = parse_element (element ("""TapChangerDynamicData.tapPosition"""))
    val voltageRegulationStatus = parse_element (element ("""TapChangerDynamicData.voltageRegulationStatus"""))
    val MktTapChanger = parse_attribute (attribute ("""TapChangerDynamicData.MktTapChanger"""))
    def parse (context: Context): TapChangerDynamicData =
    {
        TapChangerDynamicData(
            BasicElement.parse (context),
            toBoolean (angleRegulationStatus (context), context),
            toDouble (desiredMW (context), context),
            toDouble (desiredVoltage (context), context),
            toDouble (maximumAngle (context), context),
            toDouble (minimumAngle (context), context),
            toDouble (solvedAngle (context), context),
            toDouble (tapPosition (context), context),
            toBoolean (voltageRegulationStatus (context), context),
            MktTapChanger (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktTapChanger", "MktTapChanger", false))
}

/**
 * A constraint term associated with a specific terminal on a physical piece of equipment.
 *
 * @param sup [[ch.ninecode.model.ConstraintTerm ConstraintTerm]] Reference to the superclass object.
 * @param MktTerminal [[ch.ninecode.model.MktTerminal MktTerminal]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TerminalConstraintTerm
(
    override val sup: ConstraintTerm,
    MktTerminal: String
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
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { clone ().asInstanceOf[TerminalConstraintTerm] }
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
        (if (null != MktTerminal) "\t\t<cim:TerminalConstraintTerm.MktTerminal rdf:resource=\"#" + MktTerminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TerminalConstraintTerm rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TerminalConstraintTerm>"
    }
}

object TerminalConstraintTerm
extends
    Parseable[TerminalConstraintTerm]
{
    val MktTerminal = parse_attribute (attribute ("""TerminalConstraintTerm.MktTerminal"""))
    def parse (context: Context): TerminalConstraintTerm =
    {
        TerminalConstraintTerm(
            ConstraintTerm.parse (context),
            MktTerminal (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktTerminal", "MktTerminal", false))
}

/**
 * A Transfer Interface is made up of branches such as transmission lines and transformers.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param TransferInterfaceSolution [[ch.ninecode.model.TransferInterfaceSolution TransferInterfaceSolution]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransferInterface
(
    override val sup: IdentifiedObject,
    HostControlArea: String,
    TransferInterfaceSolution: String
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
    override def copy (): Row = { clone ().asInstanceOf[TransferInterface] }
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
        (if (null != HostControlArea) "\t\t<cim:TransferInterface.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != TransferInterfaceSolution) "\t\t<cim:TransferInterface.TransferInterfaceSolution rdf:resource=\"#" + TransferInterfaceSolution + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransferInterface rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransferInterface>"
    }
}

object TransferInterface
extends
    Parseable[TransferInterface]
{
    val HostControlArea = parse_attribute (attribute ("""TransferInterface.HostControlArea"""))
    val TransferInterfaceSolution = parse_attribute (attribute ("""TransferInterface.TransferInterfaceSolution"""))
    def parse (context: Context): TransferInterface =
    {
        TransferInterface(
            IdentifiedObject.parse (context),
            HostControlArea (context),
            TransferInterfaceSolution (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("HostControlArea", "HostControlArea", false),
        Relationship ("TransferInterfaceSolution", "TransferInterfaceSolution", false))
}

/**
 * TNA Interface Definitions from OPF for VSA
 *
 * @param sup Reference to the superclass object.
 * @param interfaceMargin The margin for the interface
 * @param postTransferMW Post Transfer MW for step
 * @param transferLimit Transfer Interface + Limit
 *        Attribute Usage: The absoloute of the maximum flow on the transfer interface.
 *        This is a positive MW value.
 * @param MktContingencyB [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @param TransferInterface [[ch.ninecode.model.TransferInterface TransferInterface]] <em>undocumented</em>
 * @param _MktContingencyA [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransferInterfaceSolution
(
    override val sup: BasicElement,
    interfaceMargin: Double,
    postTransferMW: Double,
    transferLimit: Double,
    MktContingencyB: String,
    TransferInterface: String,
    _MktContingencyA: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransferInterfaceSolution] }
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
        "\t\t<cim:TransferInterfaceSolution.interfaceMargin>" + interfaceMargin + "</cim:TransferInterfaceSolution.interfaceMargin>\n" +
        "\t\t<cim:TransferInterfaceSolution.postTransferMW>" + postTransferMW + "</cim:TransferInterfaceSolution.postTransferMW>\n" +
        "\t\t<cim:TransferInterfaceSolution.transferLimit>" + transferLimit + "</cim:TransferInterfaceSolution.transferLimit>\n" +
        (if (null != MktContingencyB) "\t\t<cim:TransferInterfaceSolution.MktContingencyB rdf:resource=\"#" + MktContingencyB + "\"/>\n" else "") +
        (if (null != TransferInterface) "\t\t<cim:TransferInterfaceSolution.TransferInterface rdf:resource=\"#" + TransferInterface + "\"/>\n" else "") +
        (if (null != _MktContingencyA) "\t\t<cim:TransferInterfaceSolution. MktContingencyA rdf:resource=\"#" + _MktContingencyA + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransferInterfaceSolution rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransferInterfaceSolution>"
    }
}

object TransferInterfaceSolution
extends
    Parseable[TransferInterfaceSolution]
{
    val interfaceMargin = parse_element (element ("""TransferInterfaceSolution.interfaceMargin"""))
    val postTransferMW = parse_element (element ("""TransferInterfaceSolution.postTransferMW"""))
    val transferLimit = parse_element (element ("""TransferInterfaceSolution.transferLimit"""))
    val MktContingencyB = parse_attribute (attribute ("""TransferInterfaceSolution.MktContingencyB"""))
    val TransferInterface = parse_attribute (attribute ("""TransferInterfaceSolution.TransferInterface"""))
    val _MktContingencyA = parse_attribute (attribute ("""TransferInterfaceSolution. MktContingencyA"""))
    def parse (context: Context): TransferInterfaceSolution =
    {
        TransferInterfaceSolution(
            BasicElement.parse (context),
            toDouble (interfaceMargin (context), context),
            toDouble (postTransferMW (context), context),
            toDouble (transferLimit (context), context),
            MktContingencyB (context),
            TransferInterface (context),
            _MktContingencyA (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktContingencyB", "MktContingency", false),
        Relationship ("TransferInterface", "TransferInterface", false),
        Relationship ("_MktContingencyA", "MktContingency", false))
}

/**
 * This class models the transmission (either a transmission interface or a POR/POD pair) capacity including Total Transfer Capacity (TTC), Operating Transfer Capacity (OTC), and Capacity Benefit Margin (CBM)
 *
 * @param sup Reference to the superclass object.
 * @param capacityBenefitMargin Capacity Benefit Margin (CBM) is used by Markets to calculate the transmission interface limits.
 *        This number could be manually or procedurally determined. The CBM is defined per transmission interface (branch group).
 * @param operationalTransmissionCapacity The Operational Transmission Capacity (OTC) is the transmission capacity under the operating condition during a specific time period, incorporating the effects of derates and current settings of operation controls.
 *        The OTCs for all transmission interface (branch group) are always provided regardless of outage or switching conditions.
 * @param startOperatingDate Operating date &amp; hour when the entitlement applies
 * @param totalTransmissionCapacity Total Transmission Capacity
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param GenericConstraints [[ch.ninecode.model.GenericConstraints GenericConstraints]] <em>undocumented</em>
 * @param OTC15min_emergency The Operational Transmission Capacity (OTC) 15 minute Emergency Limit
 * @param OTCemergency The Operational Transmission Capacity (OTC) Emergency Limit.
 * @param POD point of delivery
 * @param POR point of receipt
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransmissionCapacity
(
    override val sup: BasicElement,
    capacityBenefitMargin: Double,
    operationalTransmissionCapacity: Double,
    startOperatingDate: String,
    totalTransmissionCapacity: Double,
    Flowgate: String,
    GenericConstraints: String,
    OTC15min_emergency: Double,
    OTCemergency: Double,
    POD: String,
    POR: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, null, null, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionCapacity] }
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
        "\t\t<cim:TransmissionCapacity.capacityBenefitMargin>" + capacityBenefitMargin + "</cim:TransmissionCapacity.capacityBenefitMargin>\n" +
        "\t\t<cim:TransmissionCapacity.operationalTransmissionCapacity>" + operationalTransmissionCapacity + "</cim:TransmissionCapacity.operationalTransmissionCapacity>\n" +
        (if (null != startOperatingDate) "\t\t<cim:TransmissionCapacity.startOperatingDate>" + startOperatingDate + "</cim:TransmissionCapacity.startOperatingDate>\n" else "") +
        "\t\t<cim:TransmissionCapacity.totalTransmissionCapacity>" + totalTransmissionCapacity + "</cim:TransmissionCapacity.totalTransmissionCapacity>\n" +
        (if (null != Flowgate) "\t\t<cim:TransmissionCapacity.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != GenericConstraints) "\t\t<cim:TransmissionCapacity.GenericConstraints rdf:resource=\"#" + GenericConstraints + "\"/>\n" else "") +
        "\t\t<cim:TransmissionCapacity.OTC15min_emergency>" + OTC15min_emergency + "</cim:TransmissionCapacity.OTC15min_emergency>\n" +
        "\t\t<cim:TransmissionCapacity.OTCemergency>" + OTCemergency + "</cim:TransmissionCapacity.OTCemergency>\n" +
        (if (null != POD) "\t\t<cim:TransmissionCapacity.POD>" + POD + "</cim:TransmissionCapacity.POD>\n" else "") +
        (if (null != POR) "\t\t<cim:TransmissionCapacity.POR>" + POR + "</cim:TransmissionCapacity.POR>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionCapacity rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionCapacity>"
    }
}

object TransmissionCapacity
extends
    Parseable[TransmissionCapacity]
{
    val capacityBenefitMargin = parse_element (element ("""TransmissionCapacity.capacityBenefitMargin"""))
    val operationalTransmissionCapacity = parse_element (element ("""TransmissionCapacity.operationalTransmissionCapacity"""))
    val startOperatingDate = parse_element (element ("""TransmissionCapacity.startOperatingDate"""))
    val totalTransmissionCapacity = parse_element (element ("""TransmissionCapacity.totalTransmissionCapacity"""))
    val Flowgate = parse_attribute (attribute ("""TransmissionCapacity.Flowgate"""))
    val GenericConstraints = parse_attribute (attribute ("""TransmissionCapacity.GenericConstraints"""))
    val OTC15min_emergency = parse_element (element ("""TransmissionCapacity.OTC15min_emergency"""))
    val OTCemergency = parse_element (element ("""TransmissionCapacity.OTCemergency"""))
    val POD = parse_element (element ("""TransmissionCapacity.POD"""))
    val POR = parse_element (element ("""TransmissionCapacity.POR"""))
    def parse (context: Context): TransmissionCapacity =
    {
        TransmissionCapacity(
            BasicElement.parse (context),
            toDouble (capacityBenefitMargin (context), context),
            toDouble (operationalTransmissionCapacity (context), context),
            startOperatingDate (context),
            toDouble (totalTransmissionCapacity (context), context),
            Flowgate (context),
            GenericConstraints (context),
            toDouble (OTC15min_emergency (context), context),
            toDouble (OTCemergency (context), context),
            POD (context),
            POR (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("GenericConstraints", "GenericConstraints", false))
}

/**
 * This is formally called the branch group ETC/TOR entitlement with the inclusion of CVR as ETC.
 *
 * Is used to represent the entitlements. This could be also used to represent the TR entitlement on a POR/POD.
 *
 * @param sup Reference to the superclass object.
 * @param entitlement the entitlement
 * @param startOperatingDate Operating date and hour when the entitlement applies
 * @param ContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param POD point of delivery
 * @param POR point of receipt
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransmissionInterfaceRightEntitlement
(
    override val sup: BasicElement,
    entitlement: Double,
    startOperatingDate: String,
    ContractRight: String,
    Flowgate: String,
    POD: String,
    POR: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionInterfaceRightEntitlement] }
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
        "\t\t<cim:TransmissionInterfaceRightEntitlement.entitlement>" + entitlement + "</cim:TransmissionInterfaceRightEntitlement.entitlement>\n" +
        (if (null != startOperatingDate) "\t\t<cim:TransmissionInterfaceRightEntitlement.startOperatingDate>" + startOperatingDate + "</cim:TransmissionInterfaceRightEntitlement.startOperatingDate>\n" else "") +
        (if (null != ContractRight) "\t\t<cim:TransmissionInterfaceRightEntitlement.ContractRight rdf:resource=\"#" + ContractRight + "\"/>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:TransmissionInterfaceRightEntitlement.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != POD) "\t\t<cim:TransmissionInterfaceRightEntitlement.POD>" + POD + "</cim:TransmissionInterfaceRightEntitlement.POD>\n" else "") +
        (if (null != POR) "\t\t<cim:TransmissionInterfaceRightEntitlement.POR>" + POR + "</cim:TransmissionInterfaceRightEntitlement.POR>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionInterfaceRightEntitlement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionInterfaceRightEntitlement>"
    }
}

object TransmissionInterfaceRightEntitlement
extends
    Parseable[TransmissionInterfaceRightEntitlement]
{
    val entitlement = parse_element (element ("""TransmissionInterfaceRightEntitlement.entitlement"""))
    val startOperatingDate = parse_element (element ("""TransmissionInterfaceRightEntitlement.startOperatingDate"""))
    val ContractRight = parse_attribute (attribute ("""TransmissionInterfaceRightEntitlement.ContractRight"""))
    val Flowgate = parse_attribute (attribute ("""TransmissionInterfaceRightEntitlement.Flowgate"""))
    val POD = parse_element (element ("""TransmissionInterfaceRightEntitlement.POD"""))
    val POR = parse_element (element ("""TransmissionInterfaceRightEntitlement.POR"""))
    def parse (context: Context): TransmissionInterfaceRightEntitlement =
    {
        TransmissionInterfaceRightEntitlement(
            BasicElement.parse (context),
            toDouble (entitlement (context), context),
            startOperatingDate (context),
            ContractRight (context),
            Flowgate (context),
            POD (context),
            POR (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ContractRight", "ContractRight", false),
        Relationship ("Flowgate", "Flowgate", false))
}

/**
 * An electrical connection, link, or line consisting of one or more parallel transmission elements between two areas of the interconnected electric systems, or portions thereof.
 *
 * TransmissionCorridor and TransmissionRightOfWay refer to legal aspects. The TransmissionPath refers to the segments between a TransmissionProvider's ServicePoints.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param availTransferCapability The available transmission capability of a transmission path for the reference direction.
 * @param parallelPathFlag Flag which indicates if the transmission path is also a designated interconnection "parallel path".
 * @param totalTransferCapability The total transmission capability of a transmission path in the reference direction.
 * @param DeliveryPoint [[ch.ninecode.model.ServicePoint ServicePoint]] A transmission path has a "point-of-delivery" service point
 * @param For [[ch.ninecode.model.TransmissionCorridor TransmissionCorridor]] A TransmissionPath is contained in a TransmissionCorridor.
 * @param PointOfReceipt [[ch.ninecode.model.ServicePoint ServicePoint]] A transmission path has a "point-of-receipt" service point
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransmissionPath
(
    override val sup: IdentifiedObject,
    availTransferCapability: Double,
    parallelPathFlag: Boolean,
    totalTransferCapability: Double,
    DeliveryPoint: String,
    For: String,
    PointOfReceipt: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionPath] }
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
        "\t\t<cim:TransmissionPath.availTransferCapability>" + availTransferCapability + "</cim:TransmissionPath.availTransferCapability>\n" +
        "\t\t<cim:TransmissionPath.parallelPathFlag>" + parallelPathFlag + "</cim:TransmissionPath.parallelPathFlag>\n" +
        "\t\t<cim:TransmissionPath.totalTransferCapability>" + totalTransferCapability + "</cim:TransmissionPath.totalTransferCapability>\n" +
        (if (null != DeliveryPoint) "\t\t<cim:TransmissionPath.DeliveryPoint rdf:resource=\"#" + DeliveryPoint + "\"/>\n" else "") +
        (if (null != For) "\t\t<cim:TransmissionPath.For rdf:resource=\"#" + For + "\"/>\n" else "") +
        (if (null != PointOfReceipt) "\t\t<cim:TransmissionPath.PointOfReceipt rdf:resource=\"#" + PointOfReceipt + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionPath rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionPath>"
    }
}

object TransmissionPath
extends
    Parseable[TransmissionPath]
{
    val availTransferCapability = parse_element (element ("""TransmissionPath.availTransferCapability"""))
    val parallelPathFlag = parse_element (element ("""TransmissionPath.parallelPathFlag"""))
    val totalTransferCapability = parse_element (element ("""TransmissionPath.totalTransferCapability"""))
    val DeliveryPoint = parse_attribute (attribute ("""TransmissionPath.DeliveryPoint"""))
    val For = parse_attribute (attribute ("""TransmissionPath.For"""))
    val PointOfReceipt = parse_attribute (attribute ("""TransmissionPath.PointOfReceipt"""))
    def parse (context: Context): TransmissionPath =
    {
        TransmissionPath(
            IdentifiedObject.parse (context),
            toDouble (availTransferCapability (context), context),
            toBoolean (parallelPathFlag (context), context),
            toDouble (totalTransferCapability (context), context),
            DeliveryPoint (context),
            For (context),
            PointOfReceipt (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("DeliveryPoint", "ServicePoint", false),
        Relationship ("For", "TransmissionCorridor", false),
        Relationship ("PointOfReceipt", "ServicePoint", false))
}

/**
 * A transmission reservation is obtained from the OASIS system to reserve transmission for a specified time period, transmission path and transmission product.
 *
 * @param sup Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] <em>undocumented</em>
 * @param Sink [[ch.ninecode.model.ServicePoint ServicePoint]] <em>undocumented</em>
 * @param Source [[ch.ninecode.model.ServicePoint ServicePoint]] <em>undocumented</em>
 * @param TransactionBid [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param TransmissionPath [[ch.ninecode.model.TransmissionPath TransmissionPath]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransmissionReservation
(
    override val sup: BasicElement,
    EnergyTransaction: String,
    Sink: String,
    Source: String,
    TransactionBid: String,
    TransmissionPath: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionReservation] }
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
        (if (null != EnergyTransaction) "\t\t<cim:TransmissionReservation.EnergyTransaction rdf:resource=\"#" + EnergyTransaction + "\"/>\n" else "") +
        (if (null != Sink) "\t\t<cim:TransmissionReservation.Sink rdf:resource=\"#" + Sink + "\"/>\n" else "") +
        (if (null != Source) "\t\t<cim:TransmissionReservation.Source rdf:resource=\"#" + Source + "\"/>\n" else "") +
        (if (null != TransactionBid) "\t\t<cim:TransmissionReservation.TransactionBid rdf:resource=\"#" + TransactionBid + "\"/>\n" else "") +
        (if (null != TransmissionPath) "\t\t<cim:TransmissionReservation.TransmissionPath rdf:resource=\"#" + TransmissionPath + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionReservation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionReservation>"
    }
}

object TransmissionReservation
extends
    Parseable[TransmissionReservation]
{
    val EnergyTransaction = parse_attribute (attribute ("""TransmissionReservation.EnergyTransaction"""))
    val Sink = parse_attribute (attribute ("""TransmissionReservation.Sink"""))
    val Source = parse_attribute (attribute ("""TransmissionReservation.Source"""))
    val TransactionBid = parse_attribute (attribute ("""TransmissionReservation.TransactionBid"""))
    val TransmissionPath = parse_attribute (attribute ("""TransmissionReservation.TransmissionPath"""))
    def parse (context: Context): TransmissionReservation =
    {
        TransmissionReservation(
            BasicElement.parse (context),
            EnergyTransaction (context),
            Sink (context),
            Source (context),
            TransactionBid (context),
            TransmissionPath (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", false),
        Relationship ("Sink", "ServicePoint", false),
        Relationship ("Source", "ServicePoint", false),
        Relationship ("TransactionBid", "TransactionBid", false),
        Relationship ("TransmissionPath", "TransmissionPath", false))
}

/**
 * Resource status at the end of a given clearing period.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param cumEnergy Cumulative energy production over trading period.
 * @param cumStatusChanges Cumulative number of status changes of the resource.
 * @param numberOfStartups Number of start ups in the Operating Day until the end of previous hour.
 * @param onlineStatus 'true' if the GeneratingUnit is currently On-Line
 * @param resourceMW Resource MW output at the end of previous clearing period.
 * @param resourceStatus Resource status at the end of previous clearing period:
 *        0 - off-line
 *        1 - on-line production
 *        2 - in shutdown process
 *        3 - in startup process
 * @param statusDate Time and date for resourceStatus
 * @param timeInStatus Time in market trading intervals the resource is in the state as of the end of the previous clearing period.
 * @param timeInterval Time interval
 * @param GeneratingUnit [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class UnitInitialConditions
(
    override val sup: IdentifiedObject,
    cumEnergy: Double,
    cumStatusChanges: Int,
    numberOfStartups: Int,
    onlineStatus: Boolean,
    resourceMW: Double,
    resourceStatus: Int,
    statusDate: String,
    timeInStatus: Double,
    timeInterval: String,
    GeneratingUnit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, 0, false, 0.0, 0, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[UnitInitialConditions] }
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
        "\t\t<cim:UnitInitialConditions.cumEnergy>" + cumEnergy + "</cim:UnitInitialConditions.cumEnergy>\n" +
        "\t\t<cim:UnitInitialConditions.cumStatusChanges>" + cumStatusChanges + "</cim:UnitInitialConditions.cumStatusChanges>\n" +
        "\t\t<cim:UnitInitialConditions.numberOfStartups>" + numberOfStartups + "</cim:UnitInitialConditions.numberOfStartups>\n" +
        "\t\t<cim:UnitInitialConditions.onlineStatus>" + onlineStatus + "</cim:UnitInitialConditions.onlineStatus>\n" +
        "\t\t<cim:UnitInitialConditions.resourceMW>" + resourceMW + "</cim:UnitInitialConditions.resourceMW>\n" +
        "\t\t<cim:UnitInitialConditions.resourceStatus>" + resourceStatus + "</cim:UnitInitialConditions.resourceStatus>\n" +
        (if (null != statusDate) "\t\t<cim:UnitInitialConditions.statusDate>" + statusDate + "</cim:UnitInitialConditions.statusDate>\n" else "") +
        "\t\t<cim:UnitInitialConditions.timeInStatus>" + timeInStatus + "</cim:UnitInitialConditions.timeInStatus>\n" +
        (if (null != timeInterval) "\t\t<cim:UnitInitialConditions.timeInterval>" + timeInterval + "</cim:UnitInitialConditions.timeInterval>\n" else "") +
        (if (null != GeneratingUnit) "\t\t<cim:UnitInitialConditions.GeneratingUnit rdf:resource=\"#" + GeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UnitInitialConditions rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnitInitialConditions>"
    }
}

object UnitInitialConditions
extends
    Parseable[UnitInitialConditions]
{
    val cumEnergy = parse_element (element ("""UnitInitialConditions.cumEnergy"""))
    val cumStatusChanges = parse_element (element ("""UnitInitialConditions.cumStatusChanges"""))
    val numberOfStartups = parse_element (element ("""UnitInitialConditions.numberOfStartups"""))
    val onlineStatus = parse_element (element ("""UnitInitialConditions.onlineStatus"""))
    val resourceMW = parse_element (element ("""UnitInitialConditions.resourceMW"""))
    val resourceStatus = parse_element (element ("""UnitInitialConditions.resourceStatus"""))
    val statusDate = parse_element (element ("""UnitInitialConditions.statusDate"""))
    val timeInStatus = parse_element (element ("""UnitInitialConditions.timeInStatus"""))
    val timeInterval = parse_element (element ("""UnitInitialConditions.timeInterval"""))
    val GeneratingUnit = parse_attribute (attribute ("""UnitInitialConditions.GeneratingUnit"""))
    def parse (context: Context): UnitInitialConditions =
    {
        UnitInitialConditions(
            IdentifiedObject.parse (context),
            toDouble (cumEnergy (context), context),
            toInteger (cumStatusChanges (context), context),
            toInteger (numberOfStartups (context), context),
            toBoolean (onlineStatus (context), context),
            toDouble (resourceMW (context), context),
            toInteger (resourceStatus (context), context),
            statusDate (context),
            toDouble (timeInStatus (context), context),
            timeInterval (context),
            GeneratingUnit (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("GeneratingUnit", "RegisteredGenerator", false))
}

private[ninecode] object _ExternalInputs
{
    def register: List[ClassInfo] =
    {
        List (
            ASRequirements.register,
            AnalogMeasurementValueQuality.register,
            AreaLoadCurve.register,
            BaseCaseConstraintLimit.register,
            BranchEndFlow.register,
            ConstraintTerm.register,
            ContingencyConstraintLimit.register,
            ControlAreaSolutionData.register,
            DefaultBid.register,
            DefaultBidCurve.register,
            DefaultBidCurveData.register,
            DefaultConstraintLimit.register,
            DiscreteMeasurementValueQuality.register,
            DistributionFactorSet.register,
            EnergyConsumerData.register,
            EnergyPriceIndex.register,
            EnergyProfile.register,
            EnergyTransaction.register,
            GenDistributionFactor.register,
            GeneratingUnitDynamicValues.register,
            GenericConstraints.register,
            InterchangeETCData.register,
            InterchangeSchedule.register,
            IntermittentResourceEligibility.register,
            LoadDistributionFactor.register,
            LossSensitivity.register,
            MWLimitSchedule.register,
            MktACLineSegment.register,
            MktAnalogLimit.register,
            MktAnalogLimitSet.register,
            MktAnalogValue.register,
            MktControlArea.register,
            MktDiscreteValue.register,
            MktSeriesCompensator.register,
            MktShuntCompensator.register,
            MktSwitch.register,
            MktTapChanger.register,
            NodeConstraintTerm.register,
            Profile.register,
            ProfileData.register,
            ReserveDemandCurve.register,
            SCADAInformation.register,
            SecurityConstraintSum.register,
            SecurityConstraints.register,
            ServicePoint.register,
            ShuntCompensatorDynamicData.register,
            SwitchStatus.register,
            SysLoadDistributionFactor.register,
            TREntitlement.register,
            TapChangerDynamicData.register,
            TerminalConstraintTerm.register,
            TransferInterface.register,
            TransferInterfaceSolution.register,
            TransmissionCapacity.register,
            TransmissionInterfaceRightEntitlement.register,
            TransmissionPath.register,
            TransmissionReservation.register,
            UnitInitialConditions.register
        )
    }
}