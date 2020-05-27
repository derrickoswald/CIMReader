package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A unit with valves for three phases, together with unit control equipment, essential protective and switching devices, DC storage capacitors, phase reactors and auxiliaries, if any, used for conversion.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param baseS Base apparent power of the converter pole.
 * @param idc Converter DC current, also called Id.
 *        Converter state variable, result from power flow.
 * @param idleLoss Active power loss in pole at no power transfer.
 *        Converter configuration data used in power flow.
 * @param maxUdc The maximum voltage on the DC side at which the converter should operate.
 *        Converter configuration data used in power flow.
 * @param minUdc Minimum allowed converter DC voltage.
 *        Converter configuration data used in power flow.
 * @param numberOfValves Number of valves in the converter.
 *        Used in loss calculations.
 * @param p Active power at the point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for a steady state solution in the case a simplified power flow model is used.
 * @param poleLossP The active power loss at a DC Pole
 *        &equals; idleLoss + switchingLoss*|Idc| + resitiveLoss*Idc<sup>2</sup>
 *        For lossless operation Pdc=Pac
 *        For rectifier operation with losses Pdc=Pac-lossP
 *        For inverter operation with losses Pdc=Pac+lossP
 *        Converter state variable used in power flow.
 * @param q Reactive power at the point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for a steady state solution in the case a simplified power flow model is used.
 * @param ratedUdc Rated converter DC voltage, also called UdN.
 *        Converter configuration data used in power flow.
 * @param resistiveLoss Converter configuration data used in power flow.
 *        Refer to poleLossP.
 * @param switchingLoss Switching losses, relative to the base apparent power 'baseS'.
 *        Refer to poleLossP.
 * @param targetPpcc Real power injection target in AC grid, at point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param targetUdc Target value for DC voltage magnitude.
 * @param uc Line-to-line converter voltage, the voltage at the AC side of the valve.
 *        Converter state variable, result from power flow.
 * @param udc Converter voltage at the DC side, also called Ud.
 *        Converter state variable, result from power flow.
 * @param valveU0 Valve threshold voltage, also called Uvalve.
 *        Forward voltage drop when the valve is conducting. Used in loss calculations, i.e. the switchLoss depend on numberOfValves * valveU0.
 * @param DCTerminals [[ch.ninecode.model.ACDCConverterDCTerminal ACDCConverterDCTerminal]] A DC converter have DC converter terminals.
 *        A converter has two DC converter terminals.
 * @param PccTerminal [[ch.ninecode.model.Terminal Terminal]] Point of common coupling terminal for this converter DC side.
 *        It is typically the terminal on the power transformer (or switch) closest to the AC network. The power flow measurement shall be the sum of all flows into the transformer.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class ACDCConverter
(
    ConductingEquipment: ConductingEquipment = null,
    baseS: Double = 0.0,
    idc: Double = 0.0,
    idleLoss: Double = 0.0,
    maxUdc: Double = 0.0,
    minUdc: Double = 0.0,
    numberOfValves: Int = 0,
    p: Double = 0.0,
    poleLossP: Double = 0.0,
    q: Double = 0.0,
    ratedUdc: Double = 0.0,
    resistiveLoss: Double = 0.0,
    switchingLoss: Double = 0.0,
    targetPpcc: Double = 0.0,
    targetUdc: Double = 0.0,
    uc: Double = 0.0,
    udc: Double = 0.0,
    valveU0: Double = 0.0,
    DCTerminals: List[String] = null,
    PccTerminal: String = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = ACDCConverter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACDCConverter.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACDCConverter.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ACDCConverter.fields (position), x))
        emitelem (0, baseS)
        emitelem (1, idc)
        emitelem (2, idleLoss)
        emitelem (3, maxUdc)
        emitelem (4, minUdc)
        emitelem (5, numberOfValves)
        emitelem (6, p)
        emitelem (7, poleLossP)
        emitelem (8, q)
        emitelem (9, ratedUdc)
        emitelem (10, resistiveLoss)
        emitelem (11, switchingLoss)
        emitelem (12, targetPpcc)
        emitelem (13, targetUdc)
        emitelem (14, uc)
        emitelem (15, udc)
        emitelem (16, valveU0)
        emitattrs (17, DCTerminals)
        emitattr (18, PccTerminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACDCConverter rdf:ID=\"%s\">\n%s\t</cim:ACDCConverter>".format (id, export_fields)
    }
}

object ACDCConverter
extends
    Parseable[ACDCConverter]
{
    override val fields: Array[String] = Array[String] (
        "baseS",
        "idc",
        "idleLoss",
        "maxUdc",
        "minUdc",
        "numberOfValves",
        "p",
        "poleLossP",
        "q",
        "ratedUdc",
        "resistiveLoss",
        "switchingLoss",
        "targetPpcc",
        "targetUdc",
        "uc",
        "udc",
        "valveU0",
        "DCTerminals",
        "PccTerminal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCTerminals", "ACDCConverterDCTerminal", "0..*", "1"),
        Relationship ("PccTerminal", "Terminal", "0..1", "0..*")
    )
    val baseS: Fielder = parse_element (element (cls, fields(0)))
    val idc: Fielder = parse_element (element (cls, fields(1)))
    val idleLoss: Fielder = parse_element (element (cls, fields(2)))
    val maxUdc: Fielder = parse_element (element (cls, fields(3)))
    val minUdc: Fielder = parse_element (element (cls, fields(4)))
    val numberOfValves: Fielder = parse_element (element (cls, fields(5)))
    val p: Fielder = parse_element (element (cls, fields(6)))
    val poleLossP: Fielder = parse_element (element (cls, fields(7)))
    val q: Fielder = parse_element (element (cls, fields(8)))
    val ratedUdc: Fielder = parse_element (element (cls, fields(9)))
    val resistiveLoss: Fielder = parse_element (element (cls, fields(10)))
    val switchingLoss: Fielder = parse_element (element (cls, fields(11)))
    val targetPpcc: Fielder = parse_element (element (cls, fields(12)))
    val targetUdc: Fielder = parse_element (element (cls, fields(13)))
    val uc: Fielder = parse_element (element (cls, fields(14)))
    val udc: Fielder = parse_element (element (cls, fields(15)))
    val valveU0: Fielder = parse_element (element (cls, fields(16)))
    val DCTerminals: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val PccTerminal: Fielder = parse_attribute (attribute (cls, fields(18)))

    def parse (context: Context): ACDCConverter =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ACDCConverter (
            ConductingEquipment.parse (context),
            toDouble (mask (baseS (), 0)),
            toDouble (mask (idc (), 1)),
            toDouble (mask (idleLoss (), 2)),
            toDouble (mask (maxUdc (), 3)),
            toDouble (mask (minUdc (), 4)),
            toInteger (mask (numberOfValves (), 5)),
            toDouble (mask (p (), 6)),
            toDouble (mask (poleLossP (), 7)),
            toDouble (mask (q (), 8)),
            toDouble (mask (ratedUdc (), 9)),
            toDouble (mask (resistiveLoss (), 10)),
            toDouble (mask (switchingLoss (), 11)),
            toDouble (mask (targetPpcc (), 12)),
            toDouble (mask (targetUdc (), 13)),
            toDouble (mask (uc (), 14)),
            toDouble (mask (udc (), 15)),
            toDouble (mask (valveU0 (), 16)),
            masks (DCTerminals (), 17),
            mask (PccTerminal (), 18)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A DC electrical connection point at the AC/DC converter.
 *
 * The AC/DC converter is electrically connected also to the AC side. The AC connection is inherited from the AC conducting equipment in the same way as any other AC equipment. The AC/DC converter DC terminal is separate from generic DC terminal to restrict the connection with the AC side to AC/DC converter and so that no other DC conducting equipment can be connected to the AC side.
 *
 * @param DCBaseTerminal [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] Reference to the superclass object.
 * @param polarity Represents the normal network polarity condition.
 * @param DCConductingEquipment [[ch.ninecode.model.ACDCConverter ACDCConverter]] A DC converter terminal belong to an DC converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class ACDCConverterDCTerminal
(
    DCBaseTerminal: DCBaseTerminal = null,
    polarity: String = null,
    DCConductingEquipment: String = null
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
    override def sup: DCBaseTerminal = DCBaseTerminal

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
        implicit val clz: String = ACDCConverterDCTerminal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACDCConverterDCTerminal.fields (position), value)
        emitattr (0, polarity)
        emitattr (1, DCConductingEquipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACDCConverterDCTerminal rdf:ID=\"%s\">\n%s\t</cim:ACDCConverterDCTerminal>".format (id, export_fields)
    }
}

object ACDCConverterDCTerminal
extends
    Parseable[ACDCConverterDCTerminal]
{
    override val fields: Array[String] = Array[String] (
        "polarity",
        "DCConductingEquipment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCConductingEquipment", "ACDCConverter", "1", "0..*")
    )
    val polarity: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ACDCConverterDCTerminal =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ACDCConverterDCTerminal (
            DCBaseTerminal.parse (context),
            mask (polarity (), 0),
            mask (DCConductingEquipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * DC side of the current source converter (CSC).
 *
 * @param ACDCConverter [[ch.ninecode.model.ACDCConverter ACDCConverter]] Reference to the superclass object.
 * @param alpha Firing angle, typical value between 10 degrees and 18 degrees for a rectifier.
 *        CSC state variable, result from power flow.
 * @param gamma Extinction angle.
 *        CSC state variable, result from power flow.
 * @param maxAlpha Maximum firing angle.
 *        CSC configuration data used in power flow.
 * @param maxGamma Maximum extinction angle.
 *        CSC configuration data used in power flow.
 * @param maxIdc The maximum direct current (Id) on the DC side at which the converter should operate.
 *        Converter configuration data use in power flow.
 * @param minAlpha Minimum firing angle.
 *        CSC configuration data used in power flow.
 * @param minGamma Minimum extinction angle.
 *        CSC configuration data used in power flow.
 * @param minIdc The minimum direct current (Id) on the DC side at which the converter should operate.
 *        CSC configuration data used in power flow.
 * @param operatingMode Indicates whether the DC pole is operating as an inverter or as a rectifier.
 *        CSC control variable used in power flow.
 * @param pPccControl Kind of active power control.
 * @param ratedIdc Rated converter DC current, also called IdN.
 *        Converter configuration data used in power flow.
 * @param targetAlpha Target firing angle.
 *        CSC control variable used in power flow.
 * @param targetGamma Target extinction angle.
 *        CSC  control variable used in power flow.
 * @param targetIdc DC current target value.
 *        CSC control variable used in power flow.
 * @param CSCDynamics [[ch.ninecode.model.CSCDynamics CSCDynamics]] Current source converter dynamics model used to describe dynamic behaviour of this converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class CsConverter
(
    ACDCConverter: ACDCConverter = null,
    alpha: Double = 0.0,
    gamma: Double = 0.0,
    maxAlpha: Double = 0.0,
    maxGamma: Double = 0.0,
    maxIdc: Double = 0.0,
    minAlpha: Double = 0.0,
    minGamma: Double = 0.0,
    minIdc: Double = 0.0,
    operatingMode: String = null,
    pPccControl: String = null,
    ratedIdc: Double = 0.0,
    targetAlpha: Double = 0.0,
    targetGamma: Double = 0.0,
    targetIdc: Double = 0.0,
    CSCDynamics: String = null
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
    override def sup: ACDCConverter = ACDCConverter

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
        implicit val clz: String = CsConverter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CsConverter.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CsConverter.fields (position), value)
        emitelem (0, alpha)
        emitelem (1, gamma)
        emitelem (2, maxAlpha)
        emitelem (3, maxGamma)
        emitelem (4, maxIdc)
        emitelem (5, minAlpha)
        emitelem (6, minGamma)
        emitelem (7, minIdc)
        emitattr (8, operatingMode)
        emitattr (9, pPccControl)
        emitelem (10, ratedIdc)
        emitelem (11, targetAlpha)
        emitelem (12, targetGamma)
        emitelem (13, targetIdc)
        emitattr (14, CSCDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CsConverter rdf:ID=\"%s\">\n%s\t</cim:CsConverter>".format (id, export_fields)
    }
}

object CsConverter
extends
    Parseable[CsConverter]
{
    override val fields: Array[String] = Array[String] (
        "alpha",
        "gamma",
        "maxAlpha",
        "maxGamma",
        "maxIdc",
        "minAlpha",
        "minGamma",
        "minIdc",
        "operatingMode",
        "pPccControl",
        "ratedIdc",
        "targetAlpha",
        "targetGamma",
        "targetIdc",
        "CSCDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CSCDynamics", "CSCDynamics", "0..1", "1")
    )
    val alpha: Fielder = parse_element (element (cls, fields(0)))
    val gamma: Fielder = parse_element (element (cls, fields(1)))
    val maxAlpha: Fielder = parse_element (element (cls, fields(2)))
    val maxGamma: Fielder = parse_element (element (cls, fields(3)))
    val maxIdc: Fielder = parse_element (element (cls, fields(4)))
    val minAlpha: Fielder = parse_element (element (cls, fields(5)))
    val minGamma: Fielder = parse_element (element (cls, fields(6)))
    val minIdc: Fielder = parse_element (element (cls, fields(7)))
    val operatingMode: Fielder = parse_attribute (attribute (cls, fields(8)))
    val pPccControl: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ratedIdc: Fielder = parse_element (element (cls, fields(10)))
    val targetAlpha: Fielder = parse_element (element (cls, fields(11)))
    val targetGamma: Fielder = parse_element (element (cls, fields(12)))
    val targetIdc: Fielder = parse_element (element (cls, fields(13)))
    val CSCDynamics: Fielder = parse_attribute (attribute (cls, fields(14)))

    def parse (context: Context): CsConverter =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CsConverter (
            ACDCConverter.parse (context),
            toDouble (mask (alpha (), 0)),
            toDouble (mask (gamma (), 1)),
            toDouble (mask (maxAlpha (), 2)),
            toDouble (mask (maxGamma (), 3)),
            toDouble (mask (maxIdc (), 4)),
            toDouble (mask (minAlpha (), 5)),
            toDouble (mask (minGamma (), 6)),
            toDouble (mask (minIdc (), 7)),
            mask (operatingMode (), 8),
            mask (pPccControl (), 9),
            toDouble (mask (ratedIdc (), 10)),
            toDouble (mask (targetAlpha (), 11)),
            toDouble (mask (targetGamma (), 12)),
            toDouble (mask (targetIdc (), 13)),
            mask (CSCDynamics (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An electrical connection point at a piece of DC conducting equipment.
 *
 * DC terminals are connected at one physical DC node that may have multiple DC terminals connected. A DC node is similar to an AC connectivity node. The model requires that DC connections are distinct from AC connections.
 *
 * @param ACDCTerminal [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] Reference to the superclass object.
 * @param DCNode [[ch.ninecode.model.DCNode DCNode]] The DC connectivity node to which this DC base terminal connects with zero impedance.
 * @param DCTopologicalNode [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] See association end Terminal.
 *        TopologicalNode.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCBaseTerminal
(
    ACDCTerminal: ACDCTerminal = null,
    DCNode: String = null,
    DCTopologicalNode: String = null
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
    override def sup: ACDCTerminal = ACDCTerminal

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
        implicit val clz: String = DCBaseTerminal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCBaseTerminal.fields (position), value)
        emitattr (0, DCNode)
        emitattr (1, DCTopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCBaseTerminal rdf:ID=\"%s\">\n%s\t</cim:DCBaseTerminal>".format (id, export_fields)
    }
}

object DCBaseTerminal
extends
    Parseable[DCBaseTerminal]
{
    override val fields: Array[String] = Array[String] (
        "DCNode",
        "DCTopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCNode", "DCNode", "0..1", "0..*"),
        Relationship ("DCTopologicalNode", "DCTopologicalNode", "0..1", "0..*")
    )
    val DCNode: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCTopologicalNode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): DCBaseTerminal =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCBaseTerminal (
            ACDCTerminal.parse (context),
            mask (DCNode (), 0),
            mask (DCTopologicalNode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A breaker within a DC system.
 *
 * @param DCSwitch [[ch.ninecode.model.DCSwitch DCSwitch]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCBreaker
(
    DCSwitch: DCSwitch = null
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
    override def sup: DCSwitch = DCSwitch

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
        "\t<cim:DCBreaker rdf:ID=\"%s\">\n%s\t</cim:DCBreaker>".format (id, export_fields)
    }
}

object DCBreaker
extends
    Parseable[DCBreaker]
{

    def parse (context: Context): DCBreaker =
    {
        val ret = DCBreaker (
            DCSwitch.parse (context)
        )
        ret
    }
}

/**
 * A busbar within a DC system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCBusbar
(
    DCConductingEquipment: DCConductingEquipment = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        "\t<cim:DCBusbar rdf:ID=\"%s\">\n%s\t</cim:DCBusbar>".format (id, export_fields)
    }
}

object DCBusbar
extends
    Parseable[DCBusbar]
{

    def parse (context: Context): DCBusbar =
    {
        val ret = DCBusbar (
            DCConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * Low resistance equipment used in the internal DC circuit to balance voltages.
 *
 * It has typically positive and negative pole terminals and a ground.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCChopper
(
    DCConductingEquipment: DCConductingEquipment = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        "\t<cim:DCChopper rdf:ID=\"%s\">\n%s\t</cim:DCChopper>".format (id, export_fields)
    }
}

object DCChopper
extends
    Parseable[DCChopper]
{

    def parse (context: Context): DCChopper =
    {
        val ret = DCChopper (
            DCConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * The parts of the DC power system that are designed to carry current or that are conductively connected through DC terminals.
 *
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param ratedUdc Rated DC device voltage.
 *        Converter configuration data used in power flow.
 * @param DCTerminals [[ch.ninecode.model.DCTerminal DCTerminal]] A DC conducting equipment has DC terminals.
 * @param ProtectiveActionAdjustment [[ch.ninecode.model.ProtectiveActionAdjustment ProtectiveActionAdjustment]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCConductingEquipment
(
    Equipment: Equipment = null,
    ratedUdc: Double = 0.0,
    DCTerminals: List[String] = null,
    ProtectiveActionAdjustment: List[String] = null
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
    override def sup: Equipment = Equipment

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
        implicit val clz: String = DCConductingEquipment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCConductingEquipment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DCConductingEquipment.fields (position), x))
        emitelem (0, ratedUdc)
        emitattrs (1, DCTerminals)
        emitattrs (2, ProtectiveActionAdjustment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCConductingEquipment rdf:ID=\"%s\">\n%s\t</cim:DCConductingEquipment>".format (id, export_fields)
    }
}

object DCConductingEquipment
extends
    Parseable[DCConductingEquipment]
{
    override val fields: Array[String] = Array[String] (
        "ratedUdc",
        "DCTerminals",
        "ProtectiveActionAdjustment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCTerminals", "DCTerminal", "0..*", "1"),
        Relationship ("ProtectiveActionAdjustment", "ProtectiveActionAdjustment", "0..*", "1")
    )
    val ratedUdc: Fielder = parse_element (element (cls, fields(0)))
    val DCTerminals: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ProtectiveActionAdjustment: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): DCConductingEquipment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCConductingEquipment (
            Equipment.parse (context),
            toDouble (mask (ratedUdc (), 0)),
            masks (DCTerminals (), 1),
            masks (ProtectiveActionAdjustment (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indivisible operative unit comprising all equipment between the point of common coupling on the AC side and the point of common coupling – DC side, essentially one or more converters, together with one or more converter transformers, converter control equipment, essential protective and switching devices and auxiliaries, if any, used for conversion.
 *
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] Reference to the superclass object.
 * @param operationMode The operating mode of an HVDC bipole (bipolar, monopolar metallic return, etc).
 * @param Substation [[ch.ninecode.model.Substation Substation]] The containing substation of the DC converter unit.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCConverterUnit
(
    DCEquipmentContainer: DCEquipmentContainer = null,
    operationMode: String = null,
    Substation: String = null
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
    override def sup: DCEquipmentContainer = DCEquipmentContainer

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
        implicit val clz: String = DCConverterUnit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCConverterUnit.fields (position), value)
        emitattr (0, operationMode)
        emitattr (1, Substation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCConverterUnit rdf:ID=\"%s\">\n%s\t</cim:DCConverterUnit>".format (id, export_fields)
    }
}

object DCConverterUnit
extends
    Parseable[DCConverterUnit]
{
    override val fields: Array[String] = Array[String] (
        "operationMode",
        "Substation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Substation", "Substation", "0..1", "0..*")
    )
    val operationMode: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Substation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): DCConverterUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCConverterUnit (
            DCEquipmentContainer.parse (context),
            mask (operationMode (), 0),
            mask (Substation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A disconnector within a DC system.
 *
 * @param DCSwitch [[ch.ninecode.model.DCSwitch DCSwitch]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCDisconnector
(
    DCSwitch: DCSwitch = null
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
    override def sup: DCSwitch = DCSwitch

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
        "\t<cim:DCDisconnector rdf:ID=\"%s\">\n%s\t</cim:DCDisconnector>".format (id, export_fields)
    }
}

object DCDisconnector
extends
    Parseable[DCDisconnector]
{

    def parse (context: Context): DCDisconnector =
    {
        val ret = DCDisconnector (
            DCSwitch.parse (context)
        )
        ret
    }
}

/**
 * A modelling construct to provide a root class for containment of DC as well as AC equipment.
 *
 * The class differ from the EquipmentContaner for AC in that it may also contain DCNodes. Hence it can contain both AC and DC equipment.
 *
 * @param EquipmentContainer [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param DCNodes [[ch.ninecode.model.DCNode DCNode]] The DC nodes contained in the DC equipment container.
 * @param DCTopologicalNode [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] The topological nodes which belong to this connectivity node container.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCEquipmentContainer
(
    EquipmentContainer: EquipmentContainer = null,
    DCNodes: List[String] = null,
    DCTopologicalNode: List[String] = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        implicit val clz: String = DCEquipmentContainer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DCEquipmentContainer.fields (position), x))
        emitattrs (0, DCNodes)
        emitattrs (1, DCTopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCEquipmentContainer rdf:ID=\"%s\">\n%s\t</cim:DCEquipmentContainer>".format (id, export_fields)
    }
}

object DCEquipmentContainer
extends
    Parseable[DCEquipmentContainer]
{
    override val fields: Array[String] = Array[String] (
        "DCNodes",
        "DCTopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCNodes", "DCNode", "0..*", "1"),
        Relationship ("DCTopologicalNode", "DCTopologicalNode", "0..*", "0..1")
    )
    val DCNodes: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val DCTopologicalNode: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): DCEquipmentContainer =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCEquipmentContainer (
            EquipmentContainer.parse (context),
            masks (DCNodes (), 0),
            masks (DCTopologicalNode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A ground within a DC system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param inductance Inductance to ground.
 * @param r Resistance to ground.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCGround
(
    DCConductingEquipment: DCConductingEquipment = null,
    inductance: Double = 0.0,
    r: Double = 0.0
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCGround.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCGround.fields (position), value)
        emitelem (0, inductance)
        emitelem (1, r)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCGround rdf:ID=\"%s\">\n%s\t</cim:DCGround>".format (id, export_fields)
    }
}

object DCGround
extends
    Parseable[DCGround]
{
    override val fields: Array[String] = Array[String] (
        "inductance",
        "r"
    )
    val inductance: Fielder = parse_element (element (cls, fields(0)))
    val r: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DCGround =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCGround (
            DCConductingEquipment.parse (context),
            toDouble (mask (inductance (), 0)),
            toDouble (mask (r (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Overhead lines and/or cables connecting two or more HVDC substations.
 *
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] Reference to the superclass object.
 * @param Region [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] The SubGeographicalRegion containing the DC line.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCLine
(
    DCEquipmentContainer: DCEquipmentContainer = null,
    Region: String = null
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
    override def sup: DCEquipmentContainer = DCEquipmentContainer

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
        implicit val clz: String = DCLine.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCLine.fields (position), value)
        emitattr (0, Region)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCLine rdf:ID=\"%s\">\n%s\t</cim:DCLine>".format (id, export_fields)
    }
}

object DCLine
extends
    Parseable[DCLine]
{
    override val fields: Array[String] = Array[String] (
        "Region"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Region", "SubGeographicalRegion", "0..1", "0..*")
    )
    val Region: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): DCLine =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCLine (
            DCEquipmentContainer.parse (context),
            mask (Region (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A wire or combination of wires not insulated from one another, with consistent electrical characteristics, used to carry direct current between points in the DC region of the power system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param capacitance Capacitance of the DC line segment.
 *        Significant for cables only.
 * @param inductance Inductance of the DC line segment.
 *        Negligible compared with DCSeriesDevice used for smoothing.
 * @param len Segment length for calculating line section capabilities.
 * @param resistance Resistance of the DC line segment.
 * @param PerLengthParameter [[ch.ninecode.model.PerLengthDCLineParameter PerLengthDCLineParameter]] Set of per-length parameters for this line segment.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCLineSegment
(
    DCConductingEquipment: DCConductingEquipment = null,
    capacitance: Double = 0.0,
    inductance: Double = 0.0,
    len: Double = 0.0,
    resistance: Double = 0.0,
    PerLengthParameter: String = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCLineSegment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCLineSegment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCLineSegment.fields (position), value)
        emitelem (0, capacitance)
        emitelem (1, inductance)
        emitelem (2, len)
        emitelem (3, resistance)
        emitattr (4, PerLengthParameter)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCLineSegment rdf:ID=\"%s\">\n%s\t</cim:DCLineSegment>".format (id, export_fields)
    }
}

object DCLineSegment
extends
    Parseable[DCLineSegment]
{
    override val fields: Array[String] = Array[String] (
        "capacitance",
        "inductance",
        "length",
        "resistance",
        "PerLengthParameter"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PerLengthParameter", "PerLengthDCLineParameter", "0..1", "0..*")
    )
    val capacitance: Fielder = parse_element (element (cls, fields(0)))
    val inductance: Fielder = parse_element (element (cls, fields(1)))
    val len: Fielder = parse_element (element (cls, fields(2)))
    val resistance: Fielder = parse_element (element (cls, fields(3)))
    val PerLengthParameter: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): DCLineSegment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCLineSegment (
            DCConductingEquipment.parse (context),
            toDouble (mask (capacitance (), 0)),
            toDouble (mask (inductance (), 1)),
            toDouble (mask (len (), 2)),
            toDouble (mask (resistance (), 3)),
            mask (PerLengthParameter (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * DC nodes are points where terminals of DC conducting equipment are connected together with zero impedance.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] The DC container for the DC nodes.
 * @param DCTerminals [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] DC base terminals interconnected with zero impedance at a this DC connectivity node.
 * @param DCTopologicalNode [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] The DC topological node to which this DC connectivity node is assigned.
 *        May depend on the current state of switches in the network.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCNode
(
    IdentifiedObject: IdentifiedObject = null,
    DCEquipmentContainer: String = null,
    DCTerminals: List[String] = null,
    DCTopologicalNode: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = DCNode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DCNode.fields (position), x))
        emitattr (0, DCEquipmentContainer)
        emitattrs (1, DCTerminals)
        emitattr (2, DCTopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCNode rdf:ID=\"%s\">\n%s\t</cim:DCNode>".format (id, export_fields)
    }
}

object DCNode
extends
    Parseable[DCNode]
{
    override val fields: Array[String] = Array[String] (
        "DCEquipmentContainer",
        "DCTerminals",
        "DCTopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCEquipmentContainer", "DCEquipmentContainer", "1", "0..*"),
        Relationship ("DCTerminals", "DCBaseTerminal", "0..*", "0..1"),
        Relationship ("DCTopologicalNode", "DCTopologicalNode", "0..1", "0..*")
    )
    val DCEquipmentContainer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCTerminals: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val DCTopologicalNode: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): DCNode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCNode (
            IdentifiedObject.parse (context),
            mask (DCEquipmentContainer (), 0),
            masks (DCTerminals (), 1),
            mask (DCTopologicalNode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A series device within the DC system, typically a reactor used for filtering or smoothing.
 *
 * Needed for transient and short circuit studies.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param inductance Inductance of the device.
 * @param resistance Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCSeriesDevice
(
    DCConductingEquipment: DCConductingEquipment = null,
    inductance: Double = 0.0,
    resistance: Double = 0.0
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCSeriesDevice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCSeriesDevice.fields (position), value)
        emitelem (0, inductance)
        emitelem (1, resistance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCSeriesDevice rdf:ID=\"%s\">\n%s\t</cim:DCSeriesDevice>".format (id, export_fields)
    }
}

object DCSeriesDevice
extends
    Parseable[DCSeriesDevice]
{
    override val fields: Array[String] = Array[String] (
        "inductance",
        "resistance"
    )
    val inductance: Fielder = parse_element (element (cls, fields(0)))
    val resistance: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DCSeriesDevice =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCSeriesDevice (
            DCConductingEquipment.parse (context),
            toDouble (mask (inductance (), 0)),
            toDouble (mask (resistance (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A shunt device within the DC system, typically used for filtering.
 *
 * Needed for transient and short circuit studies.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param capacitance Capacitance of the DC shunt.
 * @param resistance Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCShunt
(
    DCConductingEquipment: DCConductingEquipment = null,
    capacitance: Double = 0.0,
    resistance: Double = 0.0
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCShunt.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCShunt.fields (position), value)
        emitelem (0, capacitance)
        emitelem (1, resistance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCShunt rdf:ID=\"%s\">\n%s\t</cim:DCShunt>".format (id, export_fields)
    }
}

object DCShunt
extends
    Parseable[DCShunt]
{
    override val fields: Array[String] = Array[String] (
        "capacitance",
        "resistance"
    )
    val capacitance: Fielder = parse_element (element (cls, fields(0)))
    val resistance: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DCShunt =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCShunt (
            DCConductingEquipment.parse (context),
            toDouble (mask (capacitance (), 0)),
            toDouble (mask (resistance (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A switch within the DC system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCSwitch
(
    DCConductingEquipment: DCConductingEquipment = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        "\t<cim:DCSwitch rdf:ID=\"%s\">\n%s\t</cim:DCSwitch>".format (id, export_fields)
    }
}

object DCSwitch
extends
    Parseable[DCSwitch]
{

    def parse (context: Context): DCSwitch =
    {
        val ret = DCSwitch (
            DCConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * An electrical connection point to generic DC conducting equipment.
 *
 * @param DCBaseTerminal [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] Reference to the superclass object.
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] An DC  terminal belong to a DC conducting equipment.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCTerminal
(
    DCBaseTerminal: DCBaseTerminal = null,
    DCConductingEquipment: String = null
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
    override def sup: DCBaseTerminal = DCBaseTerminal

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
        implicit val clz: String = DCTerminal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCTerminal.fields (position), value)
        emitattr (0, DCConductingEquipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCTerminal rdf:ID=\"%s\">\n%s\t</cim:DCTerminal>".format (id, export_fields)
    }
}

object DCTerminal
extends
    Parseable[DCTerminal]
{
    override val fields: Array[String] = Array[String] (
        "DCConductingEquipment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCConductingEquipment", "DCConductingEquipment", "1", "0..*")
    )
    val DCConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): DCTerminal =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCTerminal (
            DCBaseTerminal.parse (context),
            mask (DCConductingEquipment (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An electrically connected subset of the network.
 *
 * DC topological islands can change as the current network state changes: e.g. due to
 * - disconnect switches or breakers changing state in a SCADA/EMS.
 * - manual creation, change or deletion of topological nodes in a planning tool.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCTopologicalNodes [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] The DC topological nodes in a DC topological island.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCTopologicalIsland
(
    IdentifiedObject: IdentifiedObject = null,
    DCTopologicalNodes: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = DCTopologicalIsland.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DCTopologicalIsland.fields (position), x))
        emitattrs (0, DCTopologicalNodes)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCTopologicalIsland rdf:ID=\"%s\">\n%s\t</cim:DCTopologicalIsland>".format (id, export_fields)
    }
}

object DCTopologicalIsland
extends
    Parseable[DCTopologicalIsland]
{
    override val fields: Array[String] = Array[String] (
        "DCTopologicalNodes"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCTopologicalNodes", "DCTopologicalNode", "1..*", "0..1")
    )
    val DCTopologicalNodes: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): DCTopologicalIsland =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCTopologicalIsland (
            IdentifiedObject.parse (context),
            masks (DCTopologicalNodes (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * DC bus.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] The connectivity node container to which the topological node belongs.
 * @param DCNodes [[ch.ninecode.model.DCNode DCNode]] The DC connectivity nodes combined together to form this DC topological node.
 *        May depend on the current state of switches in the network.
 * @param DCTerminals [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] See association end TopologicalNode.
 *        Terminal.
 * @param DCTopologicalIsland [[ch.ninecode.model.DCTopologicalIsland DCTopologicalIsland]] A DC topological node belongs to a DC topological island.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCTopologicalNode
(
    IdentifiedObject: IdentifiedObject = null,
    DCEquipmentContainer: String = null,
    DCNodes: List[String] = null,
    DCTerminals: List[String] = null,
    DCTopologicalIsland: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = DCTopologicalNode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCTopologicalNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DCTopologicalNode.fields (position), x))
        emitattr (0, DCEquipmentContainer)
        emitattrs (1, DCNodes)
        emitattrs (2, DCTerminals)
        emitattr (3, DCTopologicalIsland)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCTopologicalNode rdf:ID=\"%s\">\n%s\t</cim:DCTopologicalNode>".format (id, export_fields)
    }
}

object DCTopologicalNode
extends
    Parseable[DCTopologicalNode]
{
    override val fields: Array[String] = Array[String] (
        "DCEquipmentContainer",
        "DCNodes",
        "DCTerminals",
        "DCTopologicalIsland"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCEquipmentContainer", "DCEquipmentContainer", "0..1", "0..*"),
        Relationship ("DCNodes", "DCNode", "0..*", "0..1"),
        Relationship ("DCTerminals", "DCBaseTerminal", "0..*", "0..1"),
        Relationship ("DCTopologicalIsland", "DCTopologicalIsland", "0..1", "1..*")
    )
    val DCEquipmentContainer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCNodes: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val DCTerminals: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val DCTopologicalIsland: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): DCTopologicalNode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCTopologicalNode (
            IdentifiedObject.parse (context),
            mask (DCEquipmentContainer (), 0),
            masks (DCNodes (), 1),
            masks (DCTerminals (), 2),
            mask (DCTopologicalIsland (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Common type for per-length electrical catalogues describing DC line parameters.
 *
 * @param PerLengthLineParameter [[ch.ninecode.model.PerLengthLineParameter PerLengthLineParameter]] Reference to the superclass object.
 * @param capacitance Capacitance per unit of length of the DC line segment; significant for cables only.
 * @param inductance Inductance per unit of length of the DC line segment.
 * @param resistance Resistance per length of the DC line segment.
 * @param DCLineSegments [[ch.ninecode.model.DCLineSegment DCLineSegment]] All line segments described by this set of per-length parameters.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class PerLengthDCLineParameter
(
    PerLengthLineParameter: PerLengthLineParameter = null,
    capacitance: Double = 0.0,
    inductance: Double = 0.0,
    resistance: Double = 0.0,
    DCLineSegments: List[String] = null
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
    override def sup: PerLengthLineParameter = PerLengthLineParameter

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
        implicit val clz: String = PerLengthDCLineParameter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PerLengthDCLineParameter.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PerLengthDCLineParameter.fields (position), x))
        emitelem (0, capacitance)
        emitelem (1, inductance)
        emitelem (2, resistance)
        emitattrs (3, DCLineSegments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PerLengthDCLineParameter rdf:ID=\"%s\">\n%s\t</cim:PerLengthDCLineParameter>".format (id, export_fields)
    }
}

object PerLengthDCLineParameter
extends
    Parseable[PerLengthDCLineParameter]
{
    override val fields: Array[String] = Array[String] (
        "capacitance",
        "inductance",
        "resistance",
        "DCLineSegments"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCLineSegments", "DCLineSegment", "0..*", "0..1")
    )
    val capacitance: Fielder = parse_element (element (cls, fields(0)))
    val inductance: Fielder = parse_element (element (cls, fields(1)))
    val resistance: Fielder = parse_element (element (cls, fields(2)))
    val DCLineSegments: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): PerLengthDCLineParameter =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PerLengthDCLineParameter (
            PerLengthLineParameter.parse (context),
            toDouble (mask (capacitance (), 0)),
            toDouble (mask (inductance (), 1)),
            toDouble (mask (resistance (), 2)),
            masks (DCLineSegments (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The P-Q capability curve for a voltage source converter, with P on X-axis and Qmin and Qmax on Y1-axis and Y2-axis.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param VsConverterDCSides [[ch.ninecode.model.VsConverter VsConverter]] All converters with this capability curve.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class VsCapabilityCurve
(
    Curve: Curve = null,
    VsConverterDCSides: List[String] = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = VsCapabilityCurve.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VsCapabilityCurve.fields (position), x))
        emitattrs (0, VsConverterDCSides)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VsCapabilityCurve rdf:ID=\"%s\">\n%s\t</cim:VsCapabilityCurve>".format (id, export_fields)
    }
}

object VsCapabilityCurve
extends
    Parseable[VsCapabilityCurve]
{
    override val fields: Array[String] = Array[String] (
        "VsConverterDCSides"
    )
    override val relations: List[Relationship] = List (
        Relationship ("VsConverterDCSides", "VsConverter", "0..*", "0..1")
    )
    val VsConverterDCSides: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): VsCapabilityCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VsCapabilityCurve (
            Curve.parse (context),
            masks (VsConverterDCSides (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * DC side of the voltage source converter (VSC).
 *
 * @param ACDCConverter [[ch.ninecode.model.ACDCConverter ACDCConverter]] Reference to the superclass object.
 * @param delta Angle between uf and uc.
 *        Converter state variable used in power flow.
 * @param droop Droop constant; pu value is obtained as D [kV/MW] x Sb / Ubdc.
 * @param droopCompensation Compensation constant.
 *        Used to compensate for voltage drop when controlling voltage at a distant bus.
 * @param maxModulationIndex The maximum quotient between the AC converter voltage (Uc) and DC voltage (Ud).
 *        A factor typically less than 1. VSC configuration data used in power flow.
 * @param maxValveCurrent The maximum current through a valve.
 *        This current limit is the basis for calculating the capability diagram. VSC  configuration data.
 * @param pPccControl Kind of control of real power and/or DC voltage.
 * @param qPccControl Kind of reactive power control.
 * @param qShare Reactive power sharing factor among parallel converters on Uac control.
 * @param targetQpcc Reactive power injection target in AC grid, at point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param targetUpcc Voltage target in AC grid, at point of common coupling.
 * @param uv Line-to-line voltage on the valve side of the converter transformer.
 *        Converter state variable, result from power flow.
 * @param CapabilityCurve [[ch.ninecode.model.VsCapabilityCurve VsCapabilityCurve]] Capability curve of this converter.
 * @param VSCDynamics [[ch.ninecode.model.VSCDynamics VSCDynamics]] Voltage source converter dynamics model used to describe dynamic behaviour of this converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class VsConverter
(
    ACDCConverter: ACDCConverter = null,
    delta: Double = 0.0,
    droop: Double = 0.0,
    droopCompensation: Double = 0.0,
    maxModulationIndex: Double = 0.0,
    maxValveCurrent: Double = 0.0,
    pPccControl: String = null,
    qPccControl: String = null,
    qShare: Double = 0.0,
    targetQpcc: Double = 0.0,
    targetUpcc: Double = 0.0,
    uv: Double = 0.0,
    CapabilityCurve: String = null,
    VSCDynamics: String = null
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
    override def sup: ACDCConverter = ACDCConverter

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
        implicit val clz: String = VsConverter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VsConverter.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VsConverter.fields (position), value)
        emitelem (0, delta)
        emitelem (1, droop)
        emitelem (2, droopCompensation)
        emitelem (3, maxModulationIndex)
        emitelem (4, maxValveCurrent)
        emitattr (5, pPccControl)
        emitattr (6, qPccControl)
        emitelem (7, qShare)
        emitelem (8, targetQpcc)
        emitelem (9, targetUpcc)
        emitelem (10, uv)
        emitattr (11, CapabilityCurve)
        emitattr (12, VSCDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VsConverter rdf:ID=\"%s\">\n%s\t</cim:VsConverter>".format (id, export_fields)
    }
}

object VsConverter
extends
    Parseable[VsConverter]
{
    override val fields: Array[String] = Array[String] (
        "delta",
        "droop",
        "droopCompensation",
        "maxModulationIndex",
        "maxValveCurrent",
        "pPccControl",
        "qPccControl",
        "qShare",
        "targetQpcc",
        "targetUpcc",
        "uv",
        "CapabilityCurve",
        "VSCDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CapabilityCurve", "VsCapabilityCurve", "0..1", "0..*"),
        Relationship ("VSCDynamics", "VSCDynamics", "0..1", "1")
    )
    val delta: Fielder = parse_element (element (cls, fields(0)))
    val droop: Fielder = parse_element (element (cls, fields(1)))
    val droopCompensation: Fielder = parse_element (element (cls, fields(2)))
    val maxModulationIndex: Fielder = parse_element (element (cls, fields(3)))
    val maxValveCurrent: Fielder = parse_element (element (cls, fields(4)))
    val pPccControl: Fielder = parse_attribute (attribute (cls, fields(5)))
    val qPccControl: Fielder = parse_attribute (attribute (cls, fields(6)))
    val qShare: Fielder = parse_element (element (cls, fields(7)))
    val targetQpcc: Fielder = parse_element (element (cls, fields(8)))
    val targetUpcc: Fielder = parse_element (element (cls, fields(9)))
    val uv: Fielder = parse_element (element (cls, fields(10)))
    val CapabilityCurve: Fielder = parse_attribute (attribute (cls, fields(11)))
    val VSCDynamics: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): VsConverter =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VsConverter (
            ACDCConverter.parse (context),
            toDouble (mask (delta (), 0)),
            toDouble (mask (droop (), 1)),
            toDouble (mask (droopCompensation (), 2)),
            toDouble (mask (maxModulationIndex (), 3)),
            toDouble (mask (maxValveCurrent (), 4)),
            mask (pPccControl (), 5),
            mask (qPccControl (), 6),
            toDouble (mask (qShare (), 7)),
            toDouble (mask (targetQpcc (), 8)),
            toDouble (mask (targetUpcc (), 9)),
            toDouble (mask (uv (), 10)),
            mask (CapabilityCurve (), 11),
            mask (VSCDynamics (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _DC
{
    def register: List[ClassInfo] =
    {
        List (
            ACDCConverter.register,
            ACDCConverterDCTerminal.register,
            CsConverter.register,
            DCBaseTerminal.register,
            DCBreaker.register,
            DCBusbar.register,
            DCChopper.register,
            DCConductingEquipment.register,
            DCConverterUnit.register,
            DCDisconnector.register,
            DCEquipmentContainer.register,
            DCGround.register,
            DCLine.register,
            DCLineSegment.register,
            DCNode.register,
            DCSeriesDevice.register,
            DCShunt.register,
            DCSwitch.register,
            DCTerminal.register,
            DCTopologicalIsland.register,
            DCTopologicalNode.register,
            PerLengthDCLineParameter.register,
            VsCapabilityCurve.register,
            VsConverter.register
        )
    }
}