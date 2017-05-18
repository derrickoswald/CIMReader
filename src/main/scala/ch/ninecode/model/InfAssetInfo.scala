package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Catalogue of available types of products and materials that are used to build or install, maintain or operate an Asset.
 * Each catalogue item is for a specific product (AssetModel) available from a specific supplier.
 * @param sup Reference to the superclass object.
 * @param status
 */
case class AssetModelCatalogue
(
    override val sup: Element,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetModelCatalogue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetModelCatalogue
extends
    Parseable[AssetModelCatalogue]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""AssetModelCatalogue.status"""))
    def parse (context: Context): AssetModelCatalogue =
    {
        AssetModelCatalogue(
            sup (context),
            status (context)
        )
    }
}

/**
 * Provides pricing and other relevant information about a specific manufacturer's product (i.e., AssetModel), and its price from a given supplier.
 * A single AssetModel may be availble from multiple suppliers. Note that manufacturer and supplier are both types of organisation, which the association is inherited from Document.
 * @param sup Reference to the superclass object.
 * @param unitCost Unit cost for an asset model from a specific supplier, either for a unit cost or cost per unit length.
 *        Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param AssetModel
 * @param AssetModelCatalogue
 */
case class AssetModelCatalogueItem
(
    override val sup: Element,
    val unitCost: Double,
    val AssetModel: String,
    val AssetModelCatalogue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetModelCatalogueItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetModelCatalogueItem
extends
    Parseable[AssetModelCatalogueItem]
{
    val sup = Document.parse _
    val unitCost = parse_element (element ("""AssetModelCatalogueItem.unitCost"""))
    val AssetModel = parse_attribute (attribute ("""AssetModelCatalogueItem.AssetModel"""))
    val AssetModelCatalogue = parse_attribute (attribute ("""AssetModelCatalogueItem.AssetModelCatalogue"""))
    def parse (context: Context): AssetModelCatalogueItem =
    {
        AssetModelCatalogueItem(
            sup (context),
            toDouble (unitCost (context), context),
            AssetModel (context),
            AssetModelCatalogue (context)
        )
    }
}

/**
 * Properties of breaker assets.
 * @param sup Reference to the superclass object.
 * @param phaseTrip Phase trip rating.
 */
case class BreakerInfo
(
    override val sup: Element,
    val phaseTrip: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def OldSwitchInfo: OldSwitchInfo = sup.asInstanceOf[OldSwitchInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[BreakerInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BreakerInfo
extends
    Parseable[BreakerInfo]
{
    val sup = OldSwitchInfo.parse _
    val phaseTrip = parse_element (element ("""BreakerInfo.phaseTrip"""))
    def parse (context: Context): BreakerInfo =
    {
        BreakerInfo(
            sup (context),
            toDouble (phaseTrip (context), context)
        )
    }
}

/**
 * Properties of a composite switch.
 * @param sup Reference to the superclass object.
 * @param ganged True if multi-phase switch controls all phases concurrently.
 * @param initOpMode Initial operating mode, with the following values: Automatic, Manual.
 * @param interruptingRating Breaking capacity, or short circuit rating, is the maximum rated current which the device can safely interrupt at the rated voltage.
 * @param kind Kind of composite switch.
 * @param phaseCode Phases carried, if applicable.
 * @param phaseCount Supported number of phases, typically 0, 1 or 3.
 * @param ratedVoltage Rated voltage.
 * @param remote True if device is capable of being operated by remote control.
 * @param switchStateCount Number of switch states represented by the composite switch.
 */
case class CompositeSwitchInfo
(
    override val sup: Element,
    val ganged: Boolean,
    val initOpMode: String,
    val interruptingRating: Double,
    val kind: String,
    val phaseCode: String,
    val phaseCount: Int,
    val ratedVoltage: Double,
    val remote: Boolean,
    val switchStateCount: Int
)
extends
    Element
{
    def this () = { this (null, false, null, 0.0, null, null, 0, 0.0, false, 0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[CompositeSwitchInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CompositeSwitchInfo
extends
    Parseable[CompositeSwitchInfo]
{
    val sup = AssetInfo.parse _
    val ganged = parse_element (element ("""CompositeSwitchInfo.ganged"""))
    val initOpMode = parse_element (element ("""CompositeSwitchInfo.initOpMode"""))
    val interruptingRating = parse_element (element ("""CompositeSwitchInfo.interruptingRating"""))
    val kind = parse_attribute (attribute ("""CompositeSwitchInfo.kind"""))
    val phaseCode = parse_attribute (attribute ("""CompositeSwitchInfo.phaseCode"""))
    val phaseCount = parse_element (element ("""CompositeSwitchInfo.phaseCount"""))
    val ratedVoltage = parse_element (element ("""CompositeSwitchInfo.ratedVoltage"""))
    val remote = parse_element (element ("""CompositeSwitchInfo.remote"""))
    val switchStateCount = parse_element (element ("""CompositeSwitchInfo.switchStateCount"""))
    def parse (context: Context): CompositeSwitchInfo =
    {
        CompositeSwitchInfo(
            sup (context),
            toBoolean (ganged (context), context),
            initOpMode (context),
            toDouble (interruptingRating (context), context),
            kind (context),
            phaseCode (context),
            toInteger (phaseCount (context), context),
            toDouble (ratedVoltage (context), context),
            toBoolean (remote (context), context),
            toInteger (switchStateCount (context), context)
        )
    }
}

/**
 * Kind of composite switch.
 * @param sup Reference to the superclass object.
 * @param escoThrowOver
 * @param gral
 * @param other
 * @param ral
 * @param regulatorBypass
 * @param throwOver
 * @param ugMultiSwitch
 */
case class CompositeSwitchKind
(
    override val sup: Element,
    val escoThrowOver: String,
    val gral: String,
    val other: String,
    val ral: String,
    val regulatorBypass: String,
    val throwOver: String,
    val ugMultiSwitch: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CompositeSwitchKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CompositeSwitchKind
extends
    Parseable[CompositeSwitchKind]
{
    val sup = BasicElement.parse _
    val escoThrowOver = parse_attribute (attribute ("""CompositeSwitchKind.escoThrowOver"""))
    val gral = parse_attribute (attribute ("""CompositeSwitchKind.gral"""))
    val other = parse_attribute (attribute ("""CompositeSwitchKind.other"""))
    val ral = parse_attribute (attribute ("""CompositeSwitchKind.ral"""))
    val regulatorBypass = parse_attribute (attribute ("""CompositeSwitchKind.regulatorBypass"""))
    val throwOver = parse_attribute (attribute ("""CompositeSwitchKind.throwOver"""))
    val ugMultiSwitch = parse_attribute (attribute ("""CompositeSwitchKind.ugMultiSwitch"""))
    def parse (context: Context): CompositeSwitchKind =
    {
        CompositeSwitchKind(
            sup (context),
            escoThrowOver (context),
            gral (context),
            other (context),
            ral (context),
            regulatorBypass (context),
            throwOver (context),
            ugMultiSwitch (context)
        )
    }
}

/**
 * Properties of current transformer asset.
 * @param sup Reference to the superclass object.
 * @param accuracyClass CT accuracy classification.
 * @param accuracyLimit Accuracy limit.
 * @param coreCount Number of cores.
 * @param ctClass
 * @param kneePointCurrent Maximum primary current where the CT still displays linear characteristicts.
 * @param kneePointVoltage Maximum voltage across the secondary terminals where the CT still displays linear characteristicts.
 * @param maxRatio Maximum ratio between the primary and secondary current.
 * @param nominalRatio Nominal ratio between the primary and secondary current; i.e. 100:5.
 * @param primaryFlsRating Full load secondary (FLS) rating for primary winding.
 * @param primaryRatio Ratio for the primary winding tap changer.
 * @param ratedCurrent Rated current on the primary side.
 * @param secondaryFlsRating Full load secondary (FLS) rating for secondary winding.
 * @param secondaryRatio Ratio for the secondary winding tap changer.
 * @param tertiaryFlsRating Full load secondary (FLS) rating for tertiary winding.
 * @param tertiaryRatio Ratio for the tertiary winding tap changer.
 * @param usage Usage: eg. metering, protection, etc.
 */
case class CurrentTransformerInfo
(
    override val sup: Element,
    val accuracyClass: String,
    val accuracyLimit: Double,
    val coreCount: Int,
    val ctClass: String,
    val kneePointCurrent: Double,
    val kneePointVoltage: Double,
    val maxRatio: String,
    val nominalRatio: String,
    val primaryFlsRating: Double,
    val primaryRatio: String,
    val ratedCurrent: Double,
    val secondaryFlsRating: Double,
    val secondaryRatio: String,
    val tertiaryFlsRating: Double,
    val tertiaryRatio: String,
    val usage: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, null, 0.0, 0.0, null, null, 0.0, null, 0.0, 0.0, null, 0.0, null, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentTransformerInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentTransformerInfo
extends
    Parseable[CurrentTransformerInfo]
{
    val sup = AssetInfo.parse _
    val accuracyClass = parse_element (element ("""CurrentTransformerInfo.accuracyClass"""))
    val accuracyLimit = parse_element (element ("""CurrentTransformerInfo.accuracyLimit"""))
    val coreCount = parse_element (element ("""CurrentTransformerInfo.coreCount"""))
    val ctClass = parse_element (element ("""CurrentTransformerInfo.ctClass"""))
    val kneePointCurrent = parse_element (element ("""CurrentTransformerInfo.kneePointCurrent"""))
    val kneePointVoltage = parse_element (element ("""CurrentTransformerInfo.kneePointVoltage"""))
    val maxRatio = parse_attribute (attribute ("""CurrentTransformerInfo.maxRatio"""))
    val nominalRatio = parse_attribute (attribute ("""CurrentTransformerInfo.nominalRatio"""))
    val primaryFlsRating = parse_element (element ("""CurrentTransformerInfo.primaryFlsRating"""))
    val primaryRatio = parse_attribute (attribute ("""CurrentTransformerInfo.primaryRatio"""))
    val ratedCurrent = parse_element (element ("""CurrentTransformerInfo.ratedCurrent"""))
    val secondaryFlsRating = parse_element (element ("""CurrentTransformerInfo.secondaryFlsRating"""))
    val secondaryRatio = parse_attribute (attribute ("""CurrentTransformerInfo.secondaryRatio"""))
    val tertiaryFlsRating = parse_element (element ("""CurrentTransformerInfo.tertiaryFlsRating"""))
    val tertiaryRatio = parse_attribute (attribute ("""CurrentTransformerInfo.tertiaryRatio"""))
    val usage = parse_element (element ("""CurrentTransformerInfo.usage"""))
    def parse (context: Context): CurrentTransformerInfo =
    {
        CurrentTransformerInfo(
            sup (context),
            accuracyClass (context),
            toDouble (accuracyLimit (context), context),
            toInteger (coreCount (context), context),
            ctClass (context),
            toDouble (kneePointCurrent (context), context),
            toDouble (kneePointVoltage (context), context),
            maxRatio (context),
            nominalRatio (context),
            toDouble (primaryFlsRating (context), context),
            primaryRatio (context),
            toDouble (ratedCurrent (context), context),
            toDouble (secondaryFlsRating (context), context),
            secondaryRatio (context),
            toDouble (tertiaryFlsRating (context), context),
            tertiaryRatio (context),
            usage (context)
        )
    }
}

/**
 * Parameters of fault indicator asset.
 * @param sup Reference to the superclass object.
 * @param resetKind Kind of reset mechanisim of this fault indicator.
 */
case class FaultIndicatorInfo
(
    override val sup: Element,
    val resetKind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[FaultIndicatorInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FaultIndicatorInfo
extends
    Parseable[FaultIndicatorInfo]
{
    val sup = AssetInfo.parse _
    val resetKind = parse_attribute (attribute ("""FaultIndicatorInfo.resetKind"""))
    def parse (context: Context): FaultIndicatorInfo =
    {
        FaultIndicatorInfo(
            sup (context),
            resetKind (context)
        )
    }
}

/**
 * Kind of resetting the fault indicators.
 * @param sup Reference to the superclass object.
 * @param automatic
 * @param manual
 * @param other
 * @param remote
 */
case class FaultIndicatorResetKind
(
    override val sup: Element,
    val automatic: String,
    val manual: String,
    val other: String,
    val remote: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FaultIndicatorResetKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FaultIndicatorResetKind
extends
    Parseable[FaultIndicatorResetKind]
{
    val sup = BasicElement.parse _
    val automatic = parse_attribute (attribute ("""FaultIndicatorResetKind.automatic"""))
    val manual = parse_attribute (attribute ("""FaultIndicatorResetKind.manual"""))
    val other = parse_attribute (attribute ("""FaultIndicatorResetKind.other"""))
    val remote = parse_attribute (attribute ("""FaultIndicatorResetKind.remote"""))
    def parse (context: Context): FaultIndicatorResetKind =
    {
        FaultIndicatorResetKind(
            sup (context),
            automatic (context),
            manual (context),
            other (context),
            remote (context)
        )
    }
}

/**
 * Kind of oil preservation.
 * @param sup Reference to the superclass object.
 * @param conservator
 * @param freeBreathing
 * @param nitrogenBlanket
 * @param other
 */
case class OilPreservationKind
(
    override val sup: Element,
    val conservator: String,
    val freeBreathing: String,
    val nitrogenBlanket: String,
    val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OilPreservationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OilPreservationKind
extends
    Parseable[OilPreservationKind]
{
    val sup = BasicElement.parse _
    val conservator = parse_attribute (attribute ("""OilPreservationKind.conservator"""))
    val freeBreathing = parse_attribute (attribute ("""OilPreservationKind.freeBreathing"""))
    val nitrogenBlanket = parse_attribute (attribute ("""OilPreservationKind.nitrogenBlanket"""))
    val other = parse_attribute (attribute ("""OilPreservationKind.other"""))
    def parse (context: Context): OilPreservationKind =
    {
        OilPreservationKind(
            sup (context),
            conservator (context),
            freeBreathing (context),
            nitrogenBlanket (context),
            other (context)
        )
    }
}

/**
 * Properties of switch assets.
 * @param sup Reference to the superclass object.
 * @param dielectricStrength The maximum rms voltage that may be applied across an open contact without breaking down the dielectric properties of the switch in the open position.
 * @param loadBreak True if switch has load breaking capabiity.
 *        Unless specified false, this is always assumed to be true for breakers and reclosers.
 * @param makingCapacity The highest value of current the switch can make at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param minimumCurrent The lowest value of current that the switch can make, carry and break in uninterrupted duty at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param poleCount Number of poles (i.e. of current carrying conductors that are switched).
 * @param remote True if device is capable of being operated by remote control.
 * @param withstandCurrent The highest value of current the switch can carry in the closed position at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 */
case class OldSwitchInfo
(
    override val sup: Element,
    val dielectricStrength: Double,
    val loadBreak: Boolean,
    val makingCapacity: Double,
    val minimumCurrent: Double,
    val poleCount: Int,
    val remote: Boolean,
    val withstandCurrent: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0, false, 0.0) }
    def SwitchInfo: SwitchInfo = sup.asInstanceOf[SwitchInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[OldSwitchInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OldSwitchInfo
extends
    Parseable[OldSwitchInfo]
{
    val sup = SwitchInfo.parse _
    val dielectricStrength = parse_element (element ("""OldSwitchInfo.dielectricStrength"""))
    val loadBreak = parse_element (element ("""OldSwitchInfo.loadBreak"""))
    val makingCapacity = parse_element (element ("""OldSwitchInfo.makingCapacity"""))
    val minimumCurrent = parse_element (element ("""OldSwitchInfo.minimumCurrent"""))
    val poleCount = parse_element (element ("""OldSwitchInfo.poleCount"""))
    val remote = parse_element (element ("""OldSwitchInfo.remote"""))
    val withstandCurrent = parse_element (element ("""OldSwitchInfo.withstandCurrent"""))
    def parse (context: Context): OldSwitchInfo =
    {
        OldSwitchInfo(
            sup (context),
            toDouble (dielectricStrength (context), context),
            toBoolean (loadBreak (context), context),
            toDouble (makingCapacity (context), context),
            toDouble (minimumCurrent (context), context),
            toInteger (poleCount (context), context),
            toBoolean (remote (context), context),
            toDouble (withstandCurrent (context), context)
        )
    }
}

case class OldTransformerEndInfo
(
    override val sup: Element,
    val dayOverLoadRating: Double,
    val hourOverLoadRating: Double,
    val solidInsulationWeight: Double,
    val windingInsulationKind: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    def TransformerEndInfo: TransformerEndInfo = sup.asInstanceOf[TransformerEndInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[OldTransformerEndInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OldTransformerEndInfo
extends
    Parseable[OldTransformerEndInfo]
{
    val sup = TransformerEndInfo.parse _
    val dayOverLoadRating = parse_element (element ("""OldTransformerEndInfo.dayOverLoadRating"""))
    val hourOverLoadRating = parse_element (element ("""OldTransformerEndInfo.hourOverLoadRating"""))
    val solidInsulationWeight = parse_element (element ("""OldTransformerEndInfo.solidInsulationWeight"""))
    val windingInsulationKind = parse_attribute (attribute ("""OldTransformerEndInfo.windingInsulationKind"""))
    def parse (context: Context): OldTransformerEndInfo =
    {
        OldTransformerEndInfo(
            sup (context),
            toDouble (dayOverLoadRating (context), context),
            toDouble (hourOverLoadRating (context), context),
            toDouble (solidInsulationWeight (context), context),
            windingInsulationKind (context)
        )
    }
}

case class OldTransformerTankInfo
(
    override val sup: Element,
    val constructionKind: String,
    val coreCoilsWeight: Double,
    val coreKind: String,
    val function: String,
    val neutralBIL: Double,
    val oilPreservationKind: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, 0.0, null) }
    def TransformerTankInfo: TransformerTankInfo = sup.asInstanceOf[TransformerTankInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[OldTransformerTankInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OldTransformerTankInfo
extends
    Parseable[OldTransformerTankInfo]
{
    val sup = TransformerTankInfo.parse _
    val constructionKind = parse_attribute (attribute ("""OldTransformerTankInfo.constructionKind"""))
    val coreCoilsWeight = parse_element (element ("""OldTransformerTankInfo.coreCoilsWeight"""))
    val coreKind = parse_attribute (attribute ("""OldTransformerTankInfo.coreKind"""))
    val function = parse_attribute (attribute ("""OldTransformerTankInfo.function"""))
    val neutralBIL = parse_element (element ("""OldTransformerTankInfo.neutralBIL"""))
    val oilPreservationKind = parse_attribute (attribute ("""OldTransformerTankInfo.oilPreservationKind"""))
    def parse (context: Context): OldTransformerTankInfo =
    {
        OldTransformerTankInfo(
            sup (context),
            constructionKind (context),
            toDouble (coreCoilsWeight (context), context),
            coreKind (context),
            function (context),
            toDouble (neutralBIL (context), context),
            oilPreservationKind (context)
        )
    }
}

/**
 * Properties of potential transformer asset.
 * @param sup Reference to the superclass object.
 * @param accuracyClass
 * @param nominalRatio
 * @param primaryRatio Ratio for the primary winding tap changer.
 * @param ptClass
 * @param ratedVoltage Rated voltage on the primary side.
 * @param secondaryRatio Ratio for the secondary winding tap changer.
 * @param tertiaryRatio Ratio for the tertiary winding tap changer.
 */
case class PotentialTransformerInfo
(
    override val sup: Element,
    val accuracyClass: String,
    val nominalRatio: String,
    val primaryRatio: String,
    val ptClass: String,
    val ratedVoltage: Double,
    val secondaryRatio: String,
    val tertiaryRatio: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, null, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[PotentialTransformerInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PotentialTransformerInfo
extends
    Parseable[PotentialTransformerInfo]
{
    val sup = AssetInfo.parse _
    val accuracyClass = parse_element (element ("""PotentialTransformerInfo.accuracyClass"""))
    val nominalRatio = parse_attribute (attribute ("""PotentialTransformerInfo.nominalRatio"""))
    val primaryRatio = parse_attribute (attribute ("""PotentialTransformerInfo.primaryRatio"""))
    val ptClass = parse_element (element ("""PotentialTransformerInfo.ptClass"""))
    val ratedVoltage = parse_element (element ("""PotentialTransformerInfo.ratedVoltage"""))
    val secondaryRatio = parse_attribute (attribute ("""PotentialTransformerInfo.secondaryRatio"""))
    val tertiaryRatio = parse_attribute (attribute ("""PotentialTransformerInfo.tertiaryRatio"""))
    def parse (context: Context): PotentialTransformerInfo =
    {
        PotentialTransformerInfo(
            sup (context),
            accuracyClass (context),
            nominalRatio (context),
            primaryRatio (context),
            ptClass (context),
            toDouble (ratedVoltage (context), context),
            secondaryRatio (context),
            tertiaryRatio (context)
        )
    }
}

/**
 * Properties of protection equipment asset.
 * @param sup Reference to the superclass object.
 * @param groundTrip Actual ground trip for this type of relay, if applicable.
 * @param phaseTrip Actual phase trip for this type of relay, if applicable.
 */
case class ProtectionEquipmentInfo
(
    override val sup: Element,
    val groundTrip: Double,
    val phaseTrip: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectionEquipmentInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectionEquipmentInfo
extends
    Parseable[ProtectionEquipmentInfo]
{
    val sup = AssetInfo.parse _
    val groundTrip = parse_element (element ("""ProtectionEquipmentInfo.groundTrip"""))
    val phaseTrip = parse_element (element ("""ProtectionEquipmentInfo.phaseTrip"""))
    def parse (context: Context): ProtectionEquipmentInfo =
    {
        ProtectionEquipmentInfo(
            sup (context),
            toDouble (groundTrip (context), context),
            toDouble (phaseTrip (context), context)
        )
    }
}

/**
 * Properties of recloser assets.
 * @param sup Reference to the superclass object.
 * @param groundTripCapable True if device has ground trip capability.
 * @param groundTripNormalEnabled True if normal status of ground trip is enabled.
 * @param groundTripRating Ground trip rating.
 * @param phaseTripRating Phase trip rating.
 * @param recloseLockoutCount Total number of phase reclose operations.
 */
case class RecloserInfo
(
    override val sup: Element,
    val groundTripCapable: Boolean,
    val groundTripNormalEnabled: Boolean,
    val groundTripRating: Double,
    val phaseTripRating: Double,
    val recloseLockoutCount: Int
)
extends
    Element
{
    def this () = { this (null, false, false, 0.0, 0.0, 0) }
    def OldSwitchInfo: OldSwitchInfo = sup.asInstanceOf[OldSwitchInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[RecloserInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RecloserInfo
extends
    Parseable[RecloserInfo]
{
    val sup = OldSwitchInfo.parse _
    val groundTripCapable = parse_element (element ("""RecloserInfo.groundTripCapable"""))
    val groundTripNormalEnabled = parse_element (element ("""RecloserInfo.groundTripNormalEnabled"""))
    val groundTripRating = parse_element (element ("""RecloserInfo.groundTripRating"""))
    val phaseTripRating = parse_element (element ("""RecloserInfo.phaseTripRating"""))
    val recloseLockoutCount = parse_element (element ("""RecloserInfo.recloseLockoutCount"""))
    def parse (context: Context): RecloserInfo =
    {
        RecloserInfo(
            sup (context),
            toBoolean (groundTripCapable (context), context),
            toBoolean (groundTripNormalEnabled (context), context),
            toDouble (groundTripRating (context), context),
            toDouble (phaseTripRating (context), context),
            toInteger (recloseLockoutCount (context), context)
        )
    }
}

/**
 * Kind of regulation branch for shunt impedance.
 * @param sup Reference to the superclass object.
 * @param breaker
 * @param fuse
 * @param line
 * @param other
 * @param recloser
 * @param sectionner
 * @param switch
 * @param transformer
 */
case class RegulationBranchKind
(
    override val sup: Element,
    val breaker: String,
    val fuse: String,
    val line: String,
    val other: String,
    val recloser: String,
    val sectionner: String,
    val switch: String,
    val transformer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RegulationBranchKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegulationBranchKind
extends
    Parseable[RegulationBranchKind]
{
    val sup = BasicElement.parse _
    val breaker = parse_attribute (attribute ("""RegulationBranchKind.breaker"""))
    val fuse = parse_attribute (attribute ("""RegulationBranchKind.fuse"""))
    val line = parse_attribute (attribute ("""RegulationBranchKind.line"""))
    val other = parse_attribute (attribute ("""RegulationBranchKind.other"""))
    val recloser = parse_attribute (attribute ("""RegulationBranchKind.recloser"""))
    val sectionner = parse_attribute (attribute ("""RegulationBranchKind.sectionner"""))
    val switch = parse_attribute (attribute ("""RegulationBranchKind.switch"""))
    val transformer = parse_attribute (attribute ("""RegulationBranchKind.transformer"""))
    def parse (context: Context): RegulationBranchKind =
    {
        RegulationBranchKind(
            sup (context),
            breaker (context),
            fuse (context),
            line (context),
            other (context),
            recloser (context),
            sectionner (context),
            switch (context),
            transformer (context)
        )
    }
}

/**
 * Kind of control for shunt impedance.
 * @param sup Reference to the superclass object.
 * @param fixed
 * @param localOnly
 * @param remoteOnly
 * @param remoteWithLocalOverride
 */
case class ShuntImpedanceControlKind
(
    override val sup: Element,
    val fixed: String,
    val localOnly: String,
    val remoteOnly: String,
    val remoteWithLocalOverride: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntImpedanceControlKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShuntImpedanceControlKind
extends
    Parseable[ShuntImpedanceControlKind]
{
    val sup = BasicElement.parse _
    val fixed = parse_attribute (attribute ("""ShuntImpedanceControlKind.fixed"""))
    val localOnly = parse_attribute (attribute ("""ShuntImpedanceControlKind.localOnly"""))
    val remoteOnly = parse_attribute (attribute ("""ShuntImpedanceControlKind.remoteOnly"""))
    val remoteWithLocalOverride = parse_attribute (attribute ("""ShuntImpedanceControlKind.remoteWithLocalOverride"""))
    def parse (context: Context): ShuntImpedanceControlKind =
    {
        ShuntImpedanceControlKind(
            sup (context),
            fixed (context),
            localOnly (context),
            remoteOnly (context),
            remoteWithLocalOverride (context)
        )
    }
}

/**
 * Kind of local control for shunt impedance.
 * @param sup Reference to the superclass object.
 * @param current
 * @param none
 * @param powerFactor
 * @param reactivePower
 * @param temperature
 * @param time
 * @param voltage
 */
case class ShuntImpedanceLocalControlKind
(
    override val sup: Element,
    val current: String,
    val none: String,
    val powerFactor: String,
    val reactivePower: String,
    val temperature: String,
    val time: String,
    val voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntImpedanceLocalControlKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShuntImpedanceLocalControlKind
extends
    Parseable[ShuntImpedanceLocalControlKind]
{
    val sup = BasicElement.parse _
    val current = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.current"""))
    val none = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.none"""))
    val powerFactor = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.powerFactor"""))
    val reactivePower = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.reactivePower"""))
    val temperature = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.temperature"""))
    val time = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.time"""))
    val voltage = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.voltage"""))
    def parse (context: Context): ShuntImpedanceLocalControlKind =
    {
        ShuntImpedanceLocalControlKind(
            sup (context),
            current (context),
            none (context),
            powerFactor (context),
            reactivePower (context),
            temperature (context),
            time (context),
            voltage (context)
        )
    }
}

/**
 * Properties of surge arrester.
 * @param sup Reference to the superclass object.
 * @param continuousOperatingVoltage Maximum continuous power frequency voltage allowed on the surge arrester.
 * @param isPolymer If true, the arrester has a polymer housing, porcelain otherwise.
 * @param lightningImpulseDischargeVoltage Residual voltage during an 8x20 microsecond current impulse at the nominal discharge current level.
 * @param lineDischargeClass Determines the arrester energy discharge capability.
 *        Choices are limited to 0 (none) through 5 (highest) by IEC 60099. Classes 1..3 require a 10-kA nominal discharge current. Classes 4..5 require a 20-kA nominal discharge current. Lower nominal discharge currents must use class 0.
 * @param nominalDischargeCurrent The lightning discharge current used to classify the arrester.
 *        Choices are limited to 1.5, 2.5, 5, 10, and 20 kA by IEC 60099.
 * @param pressureReliefClass Fault current level at which all parts of the failed arrester lie within a circle prescribed by IEC 60099.
 * @param ratedVoltage The temporary overvoltage (TOV) level at power frequency that the surge arrester withstands for 10 seconds.
 * @param steepFrontDischargeVoltage Residual voltage during a current impulse with front time of 1 microsecond, and magnitude equal to the nominal discharge current level.
 * @param switchingImpulseDischargeVoltage Residual voltage during a current impulse with front time of at least 30 microseconds, and magnitude specified in IEC 60099 for the line discharge class.
 *        Does not apply to line discharge class 0.
 */
case class SurgeArresterInfo
(
    override val sup: Element,
    val continuousOperatingVoltage: Double,
    val isPolymer: Boolean,
    val lightningImpulseDischargeVoltage: Double,
    val lineDischargeClass: Int,
    val nominalDischargeCurrent: Double,
    val pressureReliefClass: Double,
    val ratedVoltage: Double,
    val steepFrontDischargeVoltage: Double,
    val switchingImpulseDischargeVoltage: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[SurgeArresterInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SurgeArresterInfo
extends
    Parseable[SurgeArresterInfo]
{
    val sup = AssetInfo.parse _
    val continuousOperatingVoltage = parse_element (element ("""SurgeArresterInfo.continuousOperatingVoltage"""))
    val isPolymer = parse_element (element ("""SurgeArresterInfo.isPolymer"""))
    val lightningImpulseDischargeVoltage = parse_element (element ("""SurgeArresterInfo.lightningImpulseDischargeVoltage"""))
    val lineDischargeClass = parse_element (element ("""SurgeArresterInfo.lineDischargeClass"""))
    val nominalDischargeCurrent = parse_element (element ("""SurgeArresterInfo.nominalDischargeCurrent"""))
    val pressureReliefClass = parse_element (element ("""SurgeArresterInfo.pressureReliefClass"""))
    val ratedVoltage = parse_element (element ("""SurgeArresterInfo.ratedVoltage"""))
    val steepFrontDischargeVoltage = parse_element (element ("""SurgeArresterInfo.steepFrontDischargeVoltage"""))
    val switchingImpulseDischargeVoltage = parse_element (element ("""SurgeArresterInfo.switchingImpulseDischargeVoltage"""))
    def parse (context: Context): SurgeArresterInfo =
    {
        SurgeArresterInfo(
            sup (context),
            toDouble (continuousOperatingVoltage (context), context),
            toBoolean (isPolymer (context), context),
            toDouble (lightningImpulseDischargeVoltage (context), context),
            toInteger (lineDischargeClass (context), context),
            toDouble (nominalDischargeCurrent (context), context),
            toDouble (pressureReliefClass (context), context),
            toDouble (ratedVoltage (context), context),
            toDouble (steepFrontDischargeVoltage (context), context),
            toDouble (switchingImpulseDischargeVoltage (context), context)
        )
    }
}

/**
 * Kind of transformer construction.
 * @param sup Reference to the superclass object.
 * @param aerial
 * @param dryType
 * @param network
 * @param onePhase
 * @param overhead
 * @param padmountDeadFront
 * @param padmountFeedThrough
 * @param padmountLiveFront
 * @param padmountLoopThrough
 * @param padmounted
 * @param subway
 * @param threePhase
 * @param underground
 * @param unknown
 * @param vault
 * @param vaultThreePhase
 */
case class TransformerConstructionKind
(
    override val sup: Element,
    val aerial: String,
    val dryType: String,
    val network: String,
    val onePhase: String,
    val overhead: String,
    val padmountDeadFront: String,
    val padmountFeedThrough: String,
    val padmountLiveFront: String,
    val padmountLoopThrough: String,
    val padmounted: String,
    val subway: String,
    val threePhase: String,
    val underground: String,
    val unknown: String,
    val vault: String,
    val vaultThreePhase: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerConstructionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerConstructionKind
extends
    Parseable[TransformerConstructionKind]
{
    val sup = BasicElement.parse _
    val aerial = parse_attribute (attribute ("""TransformerConstructionKind.aerial"""))
    val dryType = parse_attribute (attribute ("""TransformerConstructionKind.dryType"""))
    val network = parse_attribute (attribute ("""TransformerConstructionKind.network"""))
    val onePhase = parse_attribute (attribute ("""TransformerConstructionKind.onePhase"""))
    val overhead = parse_attribute (attribute ("""TransformerConstructionKind.overhead"""))
    val padmountDeadFront = parse_attribute (attribute ("""TransformerConstructionKind.padmountDeadFront"""))
    val padmountFeedThrough = parse_attribute (attribute ("""TransformerConstructionKind.padmountFeedThrough"""))
    val padmountLiveFront = parse_attribute (attribute ("""TransformerConstructionKind.padmountLiveFront"""))
    val padmountLoopThrough = parse_attribute (attribute ("""TransformerConstructionKind.padmountLoopThrough"""))
    val padmounted = parse_attribute (attribute ("""TransformerConstructionKind.padmounted"""))
    val subway = parse_attribute (attribute ("""TransformerConstructionKind.subway"""))
    val threePhase = parse_attribute (attribute ("""TransformerConstructionKind.threePhase"""))
    val underground = parse_attribute (attribute ("""TransformerConstructionKind.underground"""))
    val unknown = parse_attribute (attribute ("""TransformerConstructionKind.unknown"""))
    val vault = parse_attribute (attribute ("""TransformerConstructionKind.vault"""))
    val vaultThreePhase = parse_attribute (attribute ("""TransformerConstructionKind.vaultThreePhase"""))
    def parse (context: Context): TransformerConstructionKind =
    {
        TransformerConstructionKind(
            sup (context),
            aerial (context),
            dryType (context),
            network (context),
            onePhase (context),
            overhead (context),
            padmountDeadFront (context),
            padmountFeedThrough (context),
            padmountLiveFront (context),
            padmountLoopThrough (context),
            padmounted (context),
            subway (context),
            threePhase (context),
            underground (context),
            unknown (context),
            vault (context),
            vaultThreePhase (context)
        )
    }
}

/**
 * Kind of transformer construction.
 * @param sup Reference to the superclass object.
 * @param core
 * @param shell
 */
case class TransformerCoreKind
(
    override val sup: Element,
    val core: String,
    val shell: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerCoreKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerCoreKind
extends
    Parseable[TransformerCoreKind]
{
    val sup = BasicElement.parse _
    val core = parse_attribute (attribute ("""TransformerCoreKind.core"""))
    val shell = parse_attribute (attribute ("""TransformerCoreKind.shell"""))
    def parse (context: Context): TransformerCoreKind =
    {
        TransformerCoreKind(
            sup (context),
            core (context),
            shell (context)
        )
    }
}

/**
 * Function of a transformer.
 * @param sup Reference to the superclass object.
 * @param autotransformer
 * @param other
 * @param powerTransformer
 * @param secondaryTransformer
 * @param voltageRegulator
 */
case class TransformerFunctionKind
(
    override val sup: Element,
    val autotransformer: String,
    val other: String,
    val powerTransformer: String,
    val secondaryTransformer: String,
    val voltageRegulator: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerFunctionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerFunctionKind
extends
    Parseable[TransformerFunctionKind]
{
    val sup = BasicElement.parse _
    val autotransformer = parse_attribute (attribute ("""TransformerFunctionKind.autotransformer"""))
    val other = parse_attribute (attribute ("""TransformerFunctionKind.other"""))
    val powerTransformer = parse_attribute (attribute ("""TransformerFunctionKind.powerTransformer"""))
    val secondaryTransformer = parse_attribute (attribute ("""TransformerFunctionKind.secondaryTransformer"""))
    val voltageRegulator = parse_attribute (attribute ("""TransformerFunctionKind.voltageRegulator"""))
    def parse (context: Context): TransformerFunctionKind =
    {
        TransformerFunctionKind(
            sup (context),
            autotransformer (context),
            other (context),
            powerTransformer (context),
            secondaryTransformer (context),
            voltageRegulator (context)
        )
    }
}

/**
 * Insulation kind for windings.
 * @param sup Reference to the superclass object.
 * @param nomex
 * @param other
 * @param paper
 * @param thermallyUpgradedPaper
 */
case class WindingInsulationKind
(
    override val sup: Element,
    val nomex: String,
    val other: String,
    val paper: String,
    val thermallyUpgradedPaper: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WindingInsulationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindingInsulationKind
extends
    Parseable[WindingInsulationKind]
{
    val sup = BasicElement.parse _
    val nomex = parse_attribute (attribute ("""WindingInsulationKind.nomex"""))
    val other = parse_attribute (attribute ("""WindingInsulationKind.other"""))
    val paper = parse_attribute (attribute ("""WindingInsulationKind.paper"""))
    val thermallyUpgradedPaper = parse_attribute (attribute ("""WindingInsulationKind.thermallyUpgradedPaper"""))
    def parse (context: Context): WindingInsulationKind =
    {
        WindingInsulationKind(
            sup (context),
            nomex (context),
            other (context),
            paper (context),
            thermallyUpgradedPaper (context)
        )
    }
}

object _InfAssetInfo
{
    def register: Unit =
    {
        AssetModelCatalogue.register
        AssetModelCatalogueItem.register
        BreakerInfo.register
        CompositeSwitchInfo.register
        CompositeSwitchKind.register
        CurrentTransformerInfo.register
        FaultIndicatorInfo.register
        FaultIndicatorResetKind.register
        OilPreservationKind.register
        OldSwitchInfo.register
        OldTransformerEndInfo.register
        OldTransformerTankInfo.register
        PotentialTransformerInfo.register
        ProtectionEquipmentInfo.register
        RecloserInfo.register
        RegulationBranchKind.register
        ShuntImpedanceControlKind.register
        ShuntImpedanceLocalControlKind.register
        SurgeArresterInfo.register
        TransformerConstructionKind.register
        TransformerCoreKind.register
        TransformerFunctionKind.register
        WindingInsulationKind.register
    }
}