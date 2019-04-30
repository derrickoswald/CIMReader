package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A unit with valves for three phases, together with unit control equipment, essential protective and switching devices, DC storage capacitors, phase reactors and auxiliaries, if any, used for conversion.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param baseS Base apparent power of the converter pole.
 * @param idc Converter DC current, also called Id.
 *        Converter state variable, result from power flow.
 * @param idleLoss Active power loss in pole at no power transfer.
 *        Converter configuration data used in power flow.
 * @param maxUdc The maximum voltage on the DC side at which the converter should operate.
 *        Converter configuration data used in power flow.
 * @param minUdc Min allowed converter DC voltage.
 *        Converter configuration data used in power flow.
 * @param numberOfValves Number of valves in the converter.
 *        Used in loss calculations.
 * @param p Active power at the point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param poleLossP The active power loss at a DC Pole
 *        &equals; idleLoss + switchingLoss*|Idc| + resitiveLoss*Idc<sup>2</sup>
 *        For lossless operation Pdc=Pac
 *        For rectifier operation with losses Pdc=Pac-lossP
 *        For inverter operation with losses Pdc=Pac+lossP
 *        Converter state variable used in power flow.
 * @param q Reactive power at the point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param ratedUdc Rated converter DC voltage, also called UdN.
 *        Converter configuration data used in power flow.
 * @param resistiveLoss Converter configuration data used in power flow.
 *        Refer to poleLossP.
 * @param switchingLoss Switching losses, relative to the base apparent power 'baseS'.
 *        Refer to poleLossP.
 * @param targetPpcc Real power injection target in AC grid, at point of common coupling.
 * @param targetUdc Target value for DC voltage magnitude.
 * @param uc Line-to-line converter voltage, the voltage at the AC side of the valve.
 *        Converter state variable, result from power flow.
 * @param udc Converter voltage at the DC side, also called Ud.
 *        Converter state variable, result from power flow.
 * @param valveU0 Valve threshold voltage, also called Uvalve.
 *        Forward voltage drop when the valve is conducting. Used in loss calculations, i.e. the switchLoss depends on numberOfValves * valveU0.
 * @param DCTerminals [[ch.ninecode.model.ACDCConverterDCTerminal ACDCConverterDCTerminal]] <em>undocumented</em>
 * @param PccTerminal [[ch.ninecode.model.Terminal Terminal]] Point of common coupling terminal for this converter DC side.
 *        It is typically the terminal on the power transformer (or switch) closest to the AC network. The power flow measurement must be the sum of all flows into the transformer.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class ACDCConverter
(
    override val sup: ConductingEquipment,
    baseS: Double,
    idc: Double,
    idleLoss: Double,
    maxUdc: Double,
    minUdc: Double,
    numberOfValves: Int,
    p: Double,
    poleLossP: Double,
    q: Double,
    ratedUdc: Double,
    resistiveLoss: Double,
    switchingLoss: Double,
    targetPpcc: Double,
    targetUdc: Double,
    uc: Double,
    udc: Double,
    valveU0: Double,
    DCTerminals: List[String],
    PccTerminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[ACDCConverter] }
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
        implicit val clz: String = ACDCConverter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACDCConverter.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACDCConverter.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ACDCConverter.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] Reference to the superclass object.
 * @param polarity Represents the normal network polarity condition.
 * @param DCConductingEquipment [[ch.ninecode.model.ACDCConverter ACDCConverter]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class ACDCConverterDCTerminal
(
    override val sup: DCBaseTerminal,
    polarity: String,
    DCConductingEquipment: String
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
    def DCBaseTerminal: DCBaseTerminal = sup.asInstanceOf[DCBaseTerminal]
    override def copy (): Row = { clone ().asInstanceOf[ACDCConverterDCTerminal] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.ACDCConverter ACDCConverter]] Reference to the superclass object.
 * @param alpha Firing angle, typical value between 10 and 18 degrees for a rectifier.
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
 * @param pPccControl <em>undocumented</em>
 * @param ratedIdc Rated converter DC current, also called IdN.
 *        Converter configuration data used in power flow.
 * @param targetAlpha Target firing angle.
 *        CSC control variable used in power flow.
 * @param targetGamma Target extinction angle.
 *        CSC  control variable used in power flow.
 * @param targetIdc DC current target value.
 *        CSC control variable used in power flow.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class CsConverter
(
    override val sup: ACDCConverter,
    alpha: Double,
    gamma: Double,
    maxAlpha: Double,
    maxGamma: Double,
    maxIdc: Double,
    minAlpha: Double,
    minGamma: Double,
    minIdc: Double,
    operatingMode: String,
    pPccControl: String,
    ratedIdc: Double,
    targetAlpha: Double,
    targetGamma: Double,
    targetIdc: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ACDCConverter: ACDCConverter = sup.asInstanceOf[ACDCConverter]
    override def copy (): Row = { clone ().asInstanceOf[CsConverter] }
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
        "targetIdc"
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

    def parse (context: Context): CsConverter =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
            toDouble (mask (targetIdc (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An electrical connection point at a piece of DC conducting equipment.
 *
 * DC terminals are connected at one physical DC node that may have multiple DC terminals connected. A DC node is similar to an AC connectivity node. The model enforces that DC connections are distinct from AC connections.
 *
 * @param sup [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] Reference to the superclass object.
 * @param DCNode [[ch.ninecode.model.DCNode DCNode]] <em>undocumented</em>
 * @param DCTopologicalNode [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] See association end Terminal.
 *        TopologicalNode.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCBaseTerminal
(
    override val sup: ACDCTerminal,
    DCNode: String,
    DCTopologicalNode: String
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
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { clone ().asInstanceOf[DCBaseTerminal] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.DCSwitch DCSwitch]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCBreaker
(
    override val sup: DCSwitch
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
    def DCSwitch: DCSwitch = sup.asInstanceOf[DCSwitch]
    override def copy (): Row = { clone ().asInstanceOf[DCBreaker] }
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
        "\t<cim:DCBreaker rdf:ID=\"%s\">\n%s\t</cim:DCBreaker>".format (id, export_fields)
    }
}

object DCBreaker
extends
    Parseable[DCBreaker]
{

    def parse (context: Context): DCBreaker =
    {
        implicit val ctx: Context = context
        val ret = DCBreaker (
            DCSwitch.parse (context)
        )
        ret
    }
}

/**
 * A busbar within a DC system.
 *
 * @param sup [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCBusbar
(
    override val sup: DCConductingEquipment
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCBusbar] }
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
        "\t<cim:DCBusbar rdf:ID=\"%s\">\n%s\t</cim:DCBusbar>".format (id, export_fields)
    }
}

object DCBusbar
extends
    Parseable[DCBusbar]
{

    def parse (context: Context): DCBusbar =
    {
        implicit val ctx: Context = context
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
 * @param sup [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCChopper
(
    override val sup: DCConductingEquipment
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCChopper] }
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
        "\t<cim:DCChopper rdf:ID=\"%s\">\n%s\t</cim:DCChopper>".format (id, export_fields)
    }
}

object DCChopper
extends
    Parseable[DCChopper]
{

    def parse (context: Context): DCChopper =
    {
        implicit val ctx: Context = context
        val ret = DCChopper (
            DCConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * The parts of the DC power system that are designed to carry current or that are conductively connected through DC terminals.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param DCTerminals [[ch.ninecode.model.DCTerminal DCTerminal]] <em>undocumented</em>
 * @param ProtectiveActionAdjustment [[ch.ninecode.model.ProtectiveActionAdjustment ProtectiveActionAdjustment]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCConductingEquipment
(
    override val sup: Equipment,
    DCTerminals: List[String],
    ProtectiveActionAdjustment: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[DCConductingEquipment] }
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
        implicit val clz: String = DCConductingEquipment.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (DCConductingEquipment.fields (position), x))
        emitattrs (0, DCTerminals)
        emitattrs (1, ProtectiveActionAdjustment)
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
        "DCTerminals",
        "ProtectiveActionAdjustment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCTerminals", "DCTerminal", "0..*", "1"),
        Relationship ("ProtectiveActionAdjustment", "ProtectiveActionAdjustment", "0..*", "1")
    )
    val DCTerminals: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ProtectiveActionAdjustment: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): DCConductingEquipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DCConductingEquipment (
            Equipment.parse (context),
            masks (DCTerminals (), 0),
            masks (ProtectiveActionAdjustment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indivisible operative unit comprising all equipment between the point of common coupling on the AC side and the point of common coupling � DC side, essentially one or more converters, together with one or more converter transformers, converter control equipment, essential protective and switching devices and auxiliaries, if any, used for conversion.
 *
 * @param sup [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] Reference to the superclass object.
 * @param operationMode <em>undocumented</em>
 * @param Substation [[ch.ninecode.model.Substation Substation]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCConverterUnit
(
    override val sup: DCEquipmentContainer,
    operationMode: String,
    Substation: String
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
    def DCEquipmentContainer: DCEquipmentContainer = sup.asInstanceOf[DCEquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[DCConverterUnit] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.DCSwitch DCSwitch]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCDisconnector
(
    override val sup: DCSwitch
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
    def DCSwitch: DCSwitch = sup.asInstanceOf[DCSwitch]
    override def copy (): Row = { clone ().asInstanceOf[DCDisconnector] }
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
        "\t<cim:DCDisconnector rdf:ID=\"%s\">\n%s\t</cim:DCDisconnector>".format (id, export_fields)
    }
}

object DCDisconnector
extends
    Parseable[DCDisconnector]
{

    def parse (context: Context): DCDisconnector =
    {
        implicit val ctx: Context = context
        val ret = DCDisconnector (
            DCSwitch.parse (context)
        )
        ret
    }
}

/**
 * A modeling construct to provide a root class for containment of DC as well as AC equipment.
 *
 * The class differ from the EquipmentContaner for AC in that it may also contain DCNodes. Hence it can contain both AC and DC equipment.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param DCNodes [[ch.ninecode.model.DCNode DCNode]] <em>undocumented</em>
 * @param DCTopologicalNode [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCEquipmentContainer
(
    override val sup: EquipmentContainer,
    DCNodes: List[String],
    DCTopologicalNode: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[DCEquipmentContainer] }
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
        implicit val clz: String = DCEquipmentContainer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (DCEquipmentContainer.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param inductance Inductance to ground.
 * @param r Resistance to ground.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCGround
(
    override val sup: DCConductingEquipment,
    inductance: Double,
    r: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCGround] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] Reference to the superclass object.
 * @param Region [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCLine
(
    override val sup: DCEquipmentContainer,
    Region: String
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
    def DCEquipmentContainer: DCEquipmentContainer = sup.asInstanceOf[DCEquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[DCLine] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param capacitance Capacitance of the DC line segment.
 *        Significant for cables only.
 * @param inductance Inductance of the DC line segment.
 *        Neglectable compared with DCSeriesDevice used for smoothing.
 * @param length Segment length for calculating line section capabilities.
 * @param resistance Resistance of the DC line segment.
 * @param PerLengthParameter [[ch.ninecode.model.PerLengthDCLineParameter PerLengthDCLineParameter]] Set of per-length parameters for this line segment.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCLineSegment
(
    override val sup: DCConductingEquipment,
    capacitance: Double,
    inductance: Double,
    len: Double,
    resistance: Double,
    PerLengthParameter: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCLineSegment] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] <em>undocumented</em>
 * @param DCTerminals [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] <em>undocumented</em>
 * @param DCTopologicalNode [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] See association end ConnectivityNode.
 *        TopologicalNode.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCNode
(
    override val sup: IdentifiedObject,
    DCEquipmentContainer: String,
    DCTerminals: List[String],
    DCTopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DCNode] }
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
        implicit val clz: String = DCNode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (DCNode.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param inductance Inductance of the device.
 * @param ratedUdc Rated DC device voltage.
 *        Converter configuration data used in power flow.
 * @param resistance Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCSeriesDevice
(
    override val sup: DCConductingEquipment,
    inductance: Double,
    ratedUdc: Double,
    resistance: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCSeriesDevice] }
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
        implicit val clz: String = DCSeriesDevice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCSeriesDevice.fields (position), value)
        emitelem (0, inductance)
        emitelem (1, ratedUdc)
        emitelem (2, resistance)
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
        "ratedUdc",
        "resistance"
    )
    val inductance: Fielder = parse_element (element (cls, fields(0)))
    val ratedUdc: Fielder = parse_element (element (cls, fields(1)))
    val resistance: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): DCSeriesDevice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DCSeriesDevice (
            DCConductingEquipment.parse (context),
            toDouble (mask (inductance (), 0)),
            toDouble (mask (ratedUdc (), 1)),
            toDouble (mask (resistance (), 2))
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
 * @param sup [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param capacitance Capacitance of the DC shunt.
 * @param ratedUdc Rated DC device voltage.
 *        Converter configuration data used in power flow.
 * @param resistance Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCShunt
(
    override val sup: DCConductingEquipment,
    capacitance: Double,
    ratedUdc: Double,
    resistance: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCShunt] }
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
        implicit val clz: String = DCShunt.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCShunt.fields (position), value)
        emitelem (0, capacitance)
        emitelem (1, ratedUdc)
        emitelem (2, resistance)
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
        "ratedUdc",
        "resistance"
    )
    val capacitance: Fielder = parse_element (element (cls, fields(0)))
    val ratedUdc: Fielder = parse_element (element (cls, fields(1)))
    val resistance: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): DCShunt =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DCShunt (
            DCConductingEquipment.parse (context),
            toDouble (mask (capacitance (), 0)),
            toDouble (mask (ratedUdc (), 1)),
            toDouble (mask (resistance (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A switch within the DC system.
 *
 * @param sup [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCSwitch
(
    override val sup: DCConductingEquipment
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCSwitch] }
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
        "\t<cim:DCSwitch rdf:ID=\"%s\">\n%s\t</cim:DCSwitch>".format (id, export_fields)
    }
}

object DCSwitch
extends
    Parseable[DCSwitch]
{

    def parse (context: Context): DCSwitch =
    {
        implicit val ctx: Context = context
        val ret = DCSwitch (
            DCConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * An electrical connection point to generic DC conducting equipment.
 *
 * @param sup [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] Reference to the superclass object.
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCTerminal
(
    override val sup: DCBaseTerminal,
    DCConductingEquipment: String
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
    def DCBaseTerminal: DCBaseTerminal = sup.asInstanceOf[DCBaseTerminal]
    override def copy (): Row = { clone ().asInstanceOf[DCTerminal] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCTopologicalNodes [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCTopologicalIsland
(
    override val sup: IdentifiedObject,
    DCTopologicalNodes: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DCTopologicalIsland] }
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
        implicit val clz: String = DCTopologicalIsland.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (DCTopologicalIsland.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DCTopologicalIsland (
            IdentifiedObject.parse (context),
            masks (DCTopologicalNodes (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class PerLengthDCLineParameter
(
    override val sup: PerLengthLineParameter,
    capacitance: Double,
    inductance: Double,
    resistance: Double,
    DCLineSegments: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PerLengthLineParameter: PerLengthLineParameter = sup.asInstanceOf[PerLengthLineParameter]
    override def copy (): Row = { clone ().asInstanceOf[PerLengthDCLineParameter] }
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
        implicit val clz: String = PerLengthDCLineParameter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PerLengthDCLineParameter.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PerLengthDCLineParameter.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * The P-Q capability curve for a voltage source converter, with P on x-axis and Qmin and Qmax on y1-axis and y2-axis.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param VsConverterDCSides [[ch.ninecode.model.VsConverter VsConverter]] All converters with this capability curve.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class VsCapabilityCurve
(
    override val sup: Curve,
    VsConverterDCSides: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[VsCapabilityCurve] }
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
        implicit val clz: String = VsCapabilityCurve.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (VsCapabilityCurve.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.ACDCConverter ACDCConverter]] Reference to the superclass object.
 * @param delta Angle between uf and uc.
 *        Converter state variable used in power flow.
 * @param droop Droop constant; pu value is obtained as D [kV/MW] x Sb / Ubdc.
 * @param droopCompensation Compensation constant.
 *        Used to compensate for voltage drop when controlling voltage at a distant bus.
 * @param maxModulationIndex The max quotient between the AC converter voltage (Uc) and DC voltage (Ud).
 *        A factor typically less than 1. VSC configuration data used in power flow.
 * @param maxValveCurrent The maximum current through a valve.
 *        This current limit is the basis for calculating the capability diagram. VSC  configuration data.
 * @param pPccControl Kind of control of real power and/or DC voltage.
 * @param qPccControl <em>undocumented</em>
 * @param qShare Reactive power sharing factor among parallel converters on Uac control.
 * @param targetQpcc Reactive power injection target in AC grid, at point of common coupling.
 * @param targetUpcc Voltage target in AC grid, at point of common coupling.
 * @param uf Line-to-line voltage on the valve side of the converter transformer.
 *        Converter state variable, result from power flow.
 * @param CapabilityCurve [[ch.ninecode.model.VsCapabilityCurve VsCapabilityCurve]] Capability curve of this converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class VsConverter
(
    override val sup: ACDCConverter,
    delta: Double,
    droop: Double,
    droopCompensation: Double,
    maxModulationIndex: Double,
    maxValveCurrent: Double,
    pPccControl: String,
    qPccControl: String,
    qShare: Double,
    targetQpcc: Double,
    targetUpcc: Double,
    uf: Double,
    CapabilityCurve: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ACDCConverter: ACDCConverter = sup.asInstanceOf[ACDCConverter]
    override def copy (): Row = { clone ().asInstanceOf[VsConverter] }
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
        emitelem (10, uf)
        emitattr (11, CapabilityCurve)
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
        "uf",
        "CapabilityCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CapabilityCurve", "VsCapabilityCurve", "0..1", "0..*")
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
    val uf: Fielder = parse_element (element (cls, fields(10)))
    val CapabilityCurve: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): VsConverter =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
            toDouble (mask (uf (), 10)),
            mask (CapabilityCurve (), 11)
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
            PerLengthDCLineParameter.register,
            VsCapabilityCurve.register,
            VsConverter.register
        )
    }
}