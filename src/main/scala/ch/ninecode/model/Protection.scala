package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * An extension to the Core and Wires packages that models information for protection equipment such as relays.
 * These entities are used within training simulators and distribution network fault location applications.
 */

/**
 * A device that checks current flow values in any direction or designated direction.
 * @param sup Reference to the superclass object.
 * @param currentLimit1 Current limit number one 1 for inverse time pickup.
 * @param currentLimit2 Current limit number 2 for inverse time pickup.
 * @param currentLimit3 Current limit number 3 for inverse time pickup.
 * @param inverseTimeFlag Set true if the current relay has inverse time characteristic.
 * @param timeDelay1 Inverse time delay number 1 for current limit number 1.
 * @param timeDelay2 Inverse time delay number 2 for current limit number 2.
 * @param timeDelay3 Inverse time delay number 3 for current limit number 3.
 */
case class CurrentRelay
(
    override val sup: Element,
    val currentLimit1: Double,
    val currentLimit2: Double,
    val currentLimit3: Double,
    val inverseTimeFlag: Boolean,
    val timeDelay1: Double,
    val timeDelay2: Double,
    val timeDelay3: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentRelay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentRelay
extends
    Parseable[CurrentRelay]
{
    val sup = ProtectionEquipment.parse _
    val currentLimit1 = parse_element (element ("""CurrentRelay.currentLimit1"""))
    val currentLimit2 = parse_element (element ("""CurrentRelay.currentLimit2"""))
    val currentLimit3 = parse_element (element ("""CurrentRelay.currentLimit3"""))
    val inverseTimeFlag = parse_element (element ("""CurrentRelay.inverseTimeFlag"""))
    val timeDelay1 = parse_element (element ("""CurrentRelay.timeDelay1"""))
    val timeDelay2 = parse_element (element ("""CurrentRelay.timeDelay2"""))
    val timeDelay3 = parse_element (element ("""CurrentRelay.timeDelay3"""))
    def parse (context: Context): CurrentRelay =
    {
        CurrentRelay(
            sup (context),
            toDouble (currentLimit1 (context), context),
            toDouble (currentLimit2 (context), context),
            toDouble (currentLimit3 (context), context),
            toBoolean (inverseTimeFlag (context), context),
            toDouble (timeDelay1 (context), context),
            toDouble (timeDelay2 (context), context),
            toDouble (timeDelay3 (context), context)
        )
    }
}

/**
 * An electrical device designed to respond to input conditions in a prescribed manner and after specified conditions are met to cause contact operation or similar abrupt change in associated electric control circuits, or simply to display the detected condition.
 * Protection equipment are associated with conducting equipment and usually operate circuit breakers.
 * @param sup Reference to the superclass object.
 * @param highLimit The maximum allowable value.
 * @param lowLimit The minimum allowable value.
 * @param powerDirectionFlag Direction same as positive active power flow value.
 * @param relayDelayTime The time delay from detection of abnormal conditions to relay operation.
 * @param unitMultiplier The unit multiplier of the value.
 * @param unitSymbol The unit of measure of the value.
 * @param ConductingEquipments Protection equipment may be used to protect specific conducting equipment.
 * @param ProtectedSwitches Protected switches operated by this ProtectionEquipment.
 */
case class ProtectionEquipment
(
    override val sup: Element,
    val highLimit: Double,
    val lowLimit: Double,
    val powerDirectionFlag: Boolean,
    val relayDelayTime: Double,
    val unitMultiplier: String,
    val unitSymbol: String,
    val ConductingEquipments: List[String],
    val ProtectedSwitches: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, null, null, List(), List()) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectionEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectionEquipment
extends
    Parseable[ProtectionEquipment]
{
    val sup = Equipment.parse _
    val highLimit = parse_element (element ("""ProtectionEquipment.highLimit"""))
    val lowLimit = parse_element (element ("""ProtectionEquipment.lowLimit"""))
    val powerDirectionFlag = parse_element (element ("""ProtectionEquipment.powerDirectionFlag"""))
    val relayDelayTime = parse_element (element ("""ProtectionEquipment.relayDelayTime"""))
    val unitMultiplier = parse_attribute (attribute ("""ProtectionEquipment.unitMultiplier"""))
    val unitSymbol = parse_attribute (attribute ("""ProtectionEquipment.unitSymbol"""))
    val ConductingEquipments = parse_attributes (attribute ("""ProtectionEquipment.ConductingEquipments"""))
    val ProtectedSwitches = parse_attributes (attribute ("""ProtectionEquipment.ProtectedSwitches"""))
    def parse (context: Context): ProtectionEquipment =
    {
        ProtectionEquipment(
            sup (context),
            toDouble (highLimit (context), context),
            toDouble (lowLimit (context), context),
            toBoolean (powerDirectionFlag (context), context),
            toDouble (relayDelayTime (context), context),
            unitMultiplier (context),
            unitSymbol (context),
            ConductingEquipments (context),
            ProtectedSwitches (context)
        )
    }
}

/**
 * A reclose sequence (open and close) is defined for each possible reclosure of a breaker.
 * @param sup Reference to the superclass object.
 * @param recloseDelay Indicates the time lapse before the reclose step will execute a reclose.
 * @param recloseStep Indicates the ordinal position of the reclose step relative to other steps in the sequence.
 * @param ProtectedSwitch A breaker may have zero or more automatic reclosures after a trip occurs.
 */
case class RecloseSequence
(
    override val sup: Element,
    val recloseDelay: Double,
    val recloseStep: Int,
    val ProtectedSwitch: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[RecloseSequence]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RecloseSequence
extends
    Parseable[RecloseSequence]
{
    val sup = IdentifiedObject.parse _
    val recloseDelay = parse_element (element ("""RecloseSequence.recloseDelay"""))
    val recloseStep = parse_element (element ("""RecloseSequence.recloseStep"""))
    val ProtectedSwitch = parse_attribute (attribute ("""RecloseSequence.ProtectedSwitch"""))
    def parse (context: Context): RecloseSequence =
    {
        RecloseSequence(
            sup (context),
            toDouble (recloseDelay (context), context),
            toInteger (recloseStep (context), context),
            ProtectedSwitch (context)
        )
    }
}

/**
 * A device that operates when two AC circuits are within the desired limits of frequency, phase angle, and voltage, to permit or to cause the paralleling of these two circuits.
 * Used to prevent the paralleling of non-synchronous topological islands.
 * @param sup Reference to the superclass object.
 * @param maxAngleDiff The maximum allowable voltage vector phase angle difference across the open device.
 * @param maxFreqDiff The maximum allowable frequency difference across the open device.
 * @param maxVoltDiff The maximum allowable difference voltage across the open device.
 */
case class SynchrocheckRelay
(
    override val sup: Element,
    val maxAngleDiff: Double,
    val maxFreqDiff: Double,
    val maxVoltDiff: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchrocheckRelay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchrocheckRelay
extends
    Parseable[SynchrocheckRelay]
{
    val sup = ProtectionEquipment.parse _
    val maxAngleDiff = parse_element (element ("""SynchrocheckRelay.maxAngleDiff"""))
    val maxFreqDiff = parse_element (element ("""SynchrocheckRelay.maxFreqDiff"""))
    val maxVoltDiff = parse_element (element ("""SynchrocheckRelay.maxVoltDiff"""))
    def parse (context: Context): SynchrocheckRelay =
    {
        SynchrocheckRelay(
            sup (context),
            toDouble (maxAngleDiff (context), context),
            toDouble (maxFreqDiff (context), context),
            toDouble (maxVoltDiff (context), context)
        )
    }
}

object _Protection
{
    def register: Unit =
    {
        CurrentRelay.register
        ProtectionEquipment.register
        RecloseSequence.register
        SynchrocheckRelay.register
    }
}