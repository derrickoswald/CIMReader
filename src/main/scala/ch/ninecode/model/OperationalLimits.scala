package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Limit on active power flow.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value Value of active power limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class ActivePowerLimit
(
    override val sup: OperationalLimit,
    value: Double
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
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[ActivePowerLimit] }
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
        "\t\t<cim:ActivePowerLimit.value>" + value + "</cim:ActivePowerLimit.value>\n"
    }
    override def export: String =
    {
        "\t<cim:ActivePowerLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ActivePowerLimit>"
    }
}

object ActivePowerLimit
extends
    Parseable[ActivePowerLimit]
{
    val value = parse_element (element ("""ActivePowerLimit.value"""))
    def parse (context: Context): ActivePowerLimit =
    {
        ActivePowerLimit(
            OperationalLimit.parse (context),
            toDouble (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Apparent power limit.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value The apparent power limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class ApparentPowerLimit
(
    override val sup: OperationalLimit,
    value: Double
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
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[ApparentPowerLimit] }
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
        "\t\t<cim:ApparentPowerLimit.value>" + value + "</cim:ApparentPowerLimit.value>\n"
    }
    override def export: String =
    {
        "\t<cim:ApparentPowerLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ApparentPowerLimit>"
    }
}

object ApparentPowerLimit
extends
    Parseable[ApparentPowerLimit]
{
    val value = parse_element (element ("""ApparentPowerLimit.value"""))
    def parse (context: Context): ApparentPowerLimit =
    {
        ApparentPowerLimit(
            OperationalLimit.parse (context),
            toDouble (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * A group of branch terminals whose directed flow summation is to be monitored.
 *
 * A branch group need not form a cutset of the network.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param maximumActivePower The maximum active power flow.
 * @param maximumReactivePower The maximum reactive power flow.
 * @param minimumActivePower The minimum active power flow.
 * @param minimumReactivePower The minimum reactive power flow.
 * @param monitorActivePower Monitor the active power flow.
 * @param monitorReactivePower Monitor the reactive power flow.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class BranchGroup
(
    override val sup: IdentifiedObject,
    maximumActivePower: Double,
    maximumReactivePower: Double,
    minimumActivePower: Double,
    minimumReactivePower: Double,
    monitorActivePower: Boolean,
    monitorReactivePower: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BranchGroup] }
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
        "\t\t<cim:BranchGroup.maximumActivePower>" + maximumActivePower + "</cim:BranchGroup.maximumActivePower>\n" +
        "\t\t<cim:BranchGroup.maximumReactivePower>" + maximumReactivePower + "</cim:BranchGroup.maximumReactivePower>\n" +
        "\t\t<cim:BranchGroup.minimumActivePower>" + minimumActivePower + "</cim:BranchGroup.minimumActivePower>\n" +
        "\t\t<cim:BranchGroup.minimumReactivePower>" + minimumReactivePower + "</cim:BranchGroup.minimumReactivePower>\n" +
        "\t\t<cim:BranchGroup.monitorActivePower>" + monitorActivePower + "</cim:BranchGroup.monitorActivePower>\n" +
        "\t\t<cim:BranchGroup.monitorReactivePower>" + monitorReactivePower + "</cim:BranchGroup.monitorReactivePower>\n"
    }
    override def export: String =
    {
        "\t<cim:BranchGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BranchGroup>"
    }
}

object BranchGroup
extends
    Parseable[BranchGroup]
{
    val maximumActivePower = parse_element (element ("""BranchGroup.maximumActivePower"""))
    val maximumReactivePower = parse_element (element ("""BranchGroup.maximumReactivePower"""))
    val minimumActivePower = parse_element (element ("""BranchGroup.minimumActivePower"""))
    val minimumReactivePower = parse_element (element ("""BranchGroup.minimumReactivePower"""))
    val monitorActivePower = parse_element (element ("""BranchGroup.monitorActivePower"""))
    val monitorReactivePower = parse_element (element ("""BranchGroup.monitorReactivePower"""))
    def parse (context: Context): BranchGroup =
    {
        BranchGroup(
            IdentifiedObject.parse (context),
            toDouble (maximumActivePower (context), context),
            toDouble (maximumReactivePower (context), context),
            toDouble (minimumActivePower (context), context),
            toDouble (minimumReactivePower (context), context),
            toBoolean (monitorActivePower (context), context),
            toBoolean (monitorReactivePower (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * A specific directed terminal flow for a branch group.
 *
 * @param sup Reference to the superclass object.
 * @param positiveFlowIn The flow into the terminal is summed if set true.
 *        The flow out of the terminanl is summed if set false.
 * @param BranchGroup [[ch.ninecode.model.BranchGroup BranchGroup]] The branch group to which the directed branch group terminals belong.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal to be summed.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class BranchGroupTerminal
(
    override val sup: BasicElement,
    positiveFlowIn: Boolean,
    BranchGroup: String,
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BranchGroupTerminal] }
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
        "\t\t<cim:BranchGroupTerminal.positiveFlowIn>" + positiveFlowIn + "</cim:BranchGroupTerminal.positiveFlowIn>\n" +
        (if (null != BranchGroup) "\t\t<cim:BranchGroupTerminal.BranchGroup rdf:resource=\"#" + BranchGroup + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:BranchGroupTerminal.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BranchGroupTerminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BranchGroupTerminal>"
    }
}

object BranchGroupTerminal
extends
    Parseable[BranchGroupTerminal]
{
    val positiveFlowIn = parse_element (element ("""BranchGroupTerminal.positiveFlowIn"""))
    val BranchGroup = parse_attribute (attribute ("""BranchGroupTerminal.BranchGroup"""))
    val Terminal = parse_attribute (attribute ("""BranchGroupTerminal.Terminal"""))
    def parse (context: Context): BranchGroupTerminal =
    {
        BranchGroupTerminal(
            BasicElement.parse (context),
            toBoolean (positiveFlowIn (context), context),
            BranchGroup (context),
            Terminal (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("BranchGroup", "BranchGroup", false),
        Relationship ("Terminal", "Terminal", false))
}

/**
 * Operational limit on current.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value Limit on current flow.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class CurrentLimit
(
    override val sup: OperationalLimit,
    value: Double
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
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[CurrentLimit] }
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
        "\t\t<cim:CurrentLimit.value>" + value + "</cim:CurrentLimit.value>\n"
    }
    override def export: String =
    {
        "\t<cim:CurrentLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentLimit>"
    }
}

object CurrentLimit
extends
    Parseable[CurrentLimit]
{
    val value = parse_element (element ("""CurrentLimit.value"""))
    def parse (context: Context): CurrentLimit =
    {
        CurrentLimit(
            OperationalLimit.parse (context),
            toDouble (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * A value associated with a specific kind of limit.
 *
 * The sub class value attribute shall be positive.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param LimitDependencyModel [[ch.ninecode.model.LimitDependency LimitDependency]] The limit dependency models which are used to calculate this limit.
 *        If no limit dependencies are specified then the native limit value is used.
 * @param OperationalLimitSet [[ch.ninecode.model.OperationalLimitSet OperationalLimitSet]] The limit set to which the limit values belong.
 * @param OperationalLimitType [[ch.ninecode.model.OperationalLimitType OperationalLimitType]] The limit type associated with this limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class OperationalLimit
(
    override val sup: IdentifiedObject,
    LimitDependencyModel: List[String],
    OperationalLimitSet: String,
    OperationalLimitType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OperationalLimit] }
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
        (if (null != LimitDependencyModel) LimitDependencyModel.map (x => "\t\t<cim:OperationalLimit.LimitDependencyModel rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != OperationalLimitSet) "\t\t<cim:OperationalLimit.OperationalLimitSet rdf:resource=\"#" + OperationalLimitSet + "\"/>\n" else "") +
        (if (null != OperationalLimitType) "\t\t<cim:OperationalLimit.OperationalLimitType rdf:resource=\"#" + OperationalLimitType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperationalLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperationalLimit>"
    }
}

object OperationalLimit
extends
    Parseable[OperationalLimit]
{
    val LimitDependencyModel = parse_attributes (attribute ("""OperationalLimit.LimitDependencyModel"""))
    val OperationalLimitSet = parse_attribute (attribute ("""OperationalLimit.OperationalLimitSet"""))
    val OperationalLimitType = parse_attribute (attribute ("""OperationalLimit.OperationalLimitType"""))
    def parse (context: Context): OperationalLimit =
    {
        OperationalLimit(
            IdentifiedObject.parse (context),
            LimitDependencyModel (context),
            OperationalLimitSet (context),
            OperationalLimitType (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitDependencyModel", "LimitDependency", true),
        Relationship ("OperationalLimitSet", "OperationalLimitSet", false),
        Relationship ("OperationalLimitType", "OperationalLimitType", false))
}

/**
 * A set of limits associated with equipment.
 *
 * Sets of limits might apply to a specific temperature, or season for example. A set of limits may contain different severities of limit levels that would apply to the same equipment. The set may contain limits of different types such as apparent power and current limits or high and low voltage limits  that are logically applied together as a set.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The equipment to which the limit set applies.
 * @param Terminal [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] <em>undocumented</em>
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class OperationalLimitSet
(
    override val sup: IdentifiedObject,
    Equipment: String,
    Terminal: String
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
    override def copy (): Row = { clone ().asInstanceOf[OperationalLimitSet] }
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
        (if (null != Equipment) "\t\t<cim:OperationalLimitSet.Equipment rdf:resource=\"#" + Equipment + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:OperationalLimitSet.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperationalLimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperationalLimitSet>"
    }
}

object OperationalLimitSet
extends
    Parseable[OperationalLimitSet]
{
    val Equipment = parse_attribute (attribute ("""OperationalLimitSet.Equipment"""))
    val Terminal = parse_attribute (attribute ("""OperationalLimitSet.Terminal"""))
    def parse (context: Context): OperationalLimitSet =
    {
        OperationalLimitSet(
            IdentifiedObject.parse (context),
            Equipment (context),
            Terminal (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", false),
        Relationship ("Terminal", "ACDCTerminal", false))
}

/**
 * The operational meaning of a category of limits.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param acceptableDuration The nominal acceptable duration of the limit.
 *        Limits are commonly expressed in terms of the a time limit for which the limit is normally acceptable.   The actual acceptable duration of a specific limit may depend on other local factors such as temperature or wind speed.
 * @param direction The direction of the limit.
 * @param TargetOperationalLimitmTypeScaling [[ch.ninecode.model.OperatonalLimitTypeScaling OperatonalLimitTypeScaling]] <em>undocumented</em>
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class OperationalLimitType
(
    override val sup: IdentifiedObject,
    acceptableDuration: Double,
    direction: String,
    TargetOperationalLimitmTypeScaling: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OperationalLimitType] }
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
        "\t\t<cim:OperationalLimitType.acceptableDuration>" + acceptableDuration + "</cim:OperationalLimitType.acceptableDuration>\n" +
        (if (null != direction) "\t\t<cim:OperationalLimitType.direction rdf:resource=\"#" + direction + "\"/>\n" else "") +
        (if (null != TargetOperationalLimitmTypeScaling) "\t\t<cim:OperationalLimitType.TargetOperationalLimitmTypeScaling rdf:resource=\"#" + TargetOperationalLimitmTypeScaling + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperationalLimitType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperationalLimitType>"
    }
}

object OperationalLimitType
extends
    Parseable[OperationalLimitType]
{
    val acceptableDuration = parse_element (element ("""OperationalLimitType.acceptableDuration"""))
    val direction = parse_attribute (attribute ("""OperationalLimitType.direction"""))
    val TargetOperationalLimitmTypeScaling = parse_attribute (attribute ("""OperationalLimitType.TargetOperationalLimitmTypeScaling"""))
    def parse (context: Context): OperationalLimitType =
    {
        OperationalLimitType(
            IdentifiedObject.parse (context),
            toDouble (acceptableDuration (context), context),
            direction (context),
            TargetOperationalLimitmTypeScaling (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("TargetOperationalLimitmTypeScaling", "OperatonalLimitTypeScaling", false))
}

/**
 * Operational limit applied to voltage.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value Limit on voltage.
 *        High or low limit nature of the limit depends upon the properties of the operational limit type.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class VoltageLimit
(
    override val sup: OperationalLimit,
    value: Double
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
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[VoltageLimit] }
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
        "\t\t<cim:VoltageLimit.value>" + value + "</cim:VoltageLimit.value>\n"
    }
    override def export: String =
    {
        "\t<cim:VoltageLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VoltageLimit>"
    }
}

object VoltageLimit
extends
    Parseable[VoltageLimit]
{
    val value = parse_element (element ("""VoltageLimit.value"""))
    def parse (context: Context): VoltageLimit =
    {
        VoltageLimit(
            OperationalLimit.parse (context),
            toDouble (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

private[ninecode] object _OperationalLimits
{
    def register: List[ClassInfo] =
    {
        List (
            ActivePowerLimit.register,
            ApparentPowerLimit.register,
            BranchGroup.register,
            BranchGroupTerminal.register,
            CurrentLimit.register,
            OperationalLimit.register,
            OperationalLimitSet.register,
            OperationalLimitType.register,
            VoltageLimit.register
        )
    }
}