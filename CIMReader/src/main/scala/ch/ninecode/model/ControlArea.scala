package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A prioritized measurement to be used for the generating unit in the control area specification.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority Priority of a measurement usage.
 *        Lower numbers have first priority.
 * @param AnalogValue [[ch.ninecode.model.AnalogValue AnalogValue]] The specific analog value used as a source.
 * @param ControlAreaGeneratingUnit [[ch.ninecode.model.ControlAreaGeneratingUnit ControlAreaGeneratingUnit]] The control area generating unit to which the prioritized measurement assignment is applied.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class AltGeneratingUnitMeas
(
    override val sup: IdentifiedObject = null,
    priority: Int = 0,
    AnalogValue: String = null,
    ControlAreaGeneratingUnit: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = AltGeneratingUnitMeas.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AltGeneratingUnitMeas.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AltGeneratingUnitMeas.fields (position), value)
        emitelem (0, priority)
        emitattr (1, AnalogValue)
        emitattr (2, ControlAreaGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AltGeneratingUnitMeas rdf:ID=\"%s\">\n%s\t</cim:AltGeneratingUnitMeas>".format (id, export_fields)
    }
}

object AltGeneratingUnitMeas
extends
    Parseable[AltGeneratingUnitMeas]
{
    override val fields: Array[String] = Array[String] (
        "priority",
        "AnalogValue",
        "ControlAreaGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", "1", "0..*"),
        Relationship ("ControlAreaGeneratingUnit", "ControlAreaGeneratingUnit", "1", "0..*")
    )
    val priority: Fielder = parse_element (element (cls, fields(0)))
    val AnalogValue: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ControlAreaGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AltGeneratingUnitMeas =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AltGeneratingUnitMeas (
            IdentifiedObject.parse (context),
            toInteger (mask (priority (), 0)),
            mask (AnalogValue (), 1),
            mask (ControlAreaGeneratingUnit (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A prioritized measurement to be used for the tie flow as part of the control area specification.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority Priority of a measurement usage.
 *        Lower numbers have first priority.
 * @param AnalogValue [[ch.ninecode.model.AnalogValue AnalogValue]] The specific analog value used as a source.
 * @param TieFlow [[ch.ninecode.model.TieFlow TieFlow]] The tie flow of the alternate measurements.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class AltTieMeas
(
    override val sup: IdentifiedObject = null,
    priority: Int = 0,
    AnalogValue: String = null,
    TieFlow: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = AltTieMeas.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AltTieMeas.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AltTieMeas.fields (position), value)
        emitelem (0, priority)
        emitattr (1, AnalogValue)
        emitattr (2, TieFlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AltTieMeas rdf:ID=\"%s\">\n%s\t</cim:AltTieMeas>".format (id, export_fields)
    }
}

object AltTieMeas
extends
    Parseable[AltTieMeas]
{
    override val fields: Array[String] = Array[String] (
        "priority",
        "AnalogValue",
        "TieFlow"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", "1", "0..*"),
        Relationship ("TieFlow", "TieFlow", "1", "0..*")
    )
    val priority: Fielder = parse_element (element (cls, fields(0)))
    val AnalogValue: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TieFlow: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AltTieMeas =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AltTieMeas (
            IdentifiedObject.parse (context),
            toInteger (mask (priority (), 0)),
            mask (AnalogValue (), 1),
            mask (TieFlow (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A control area is a grouping of generating units and/or loads and a cutset of tie lines (as terminals) which may be used for a variety of purposes including automatic generation control, powerflow solution area interchange control specification, and input to load forecasting.
 *
 * All generation and load within the area defined by the terminals on the border are considered in the area interchange control.  Note that any number of overlapping control area specifications can be superimposed on the physical model.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param netInterchange The specified positive net interchange into the control area, i.e. positive sign means flow in to the area.
 * @param pTolerance Active power net interchange tolerance.
 * @param type The primary type of control area definition used to determine if this is used for automatic generation control, for planning interchange control, or other purposes.
 *        A control area specified with primary type of automatic generation control could still be forecast and used as an interchange area in power flow analysis.
 * @param ControlAreaGeneratingUnit [[ch.ninecode.model.ControlAreaGeneratingUnit ControlAreaGeneratingUnit]] The generating unit specifications for the control area.
 * @param EnergyArea [[ch.ninecode.model.EnergyArea EnergyArea]] The energy area that is forecast from this control area specification.
 * @param TieFlow [[ch.ninecode.model.TieFlow TieFlow]] The tie flows associated with the control area.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class ControlArea
(
    override val sup: PowerSystemResource = null,
    netInterchange: Double = 0.0,
    pTolerance: Double = 0.0,
    `type`: String = null,
    ControlAreaGeneratingUnit: List[String] = null,
    EnergyArea: String = null,
    TieFlow: List[String] = null
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
    def PowerSystemResource: PowerSystemResource = sup
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
        implicit val clz: String = ControlArea.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ControlArea.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ControlArea.fields (position), x))
        emitelem (0, netInterchange)
        emitelem (1, pTolerance)
        emitattr (2, `type`)
        emitattrs (3, ControlAreaGeneratingUnit)
        emitattr (4, EnergyArea)
        emitattrs (5, TieFlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlArea rdf:ID=\"%s\">\n%s\t</cim:ControlArea>".format (id, export_fields)
    }
}

object ControlArea
extends
    Parseable[ControlArea]
{
    override val fields: Array[String] = Array[String] (
        "netInterchange",
        "pTolerance",
        "type",
        "ControlAreaGeneratingUnit",
        "EnergyArea",
        "TieFlow"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ControlAreaGeneratingUnit", "ControlAreaGeneratingUnit", "0..*", "1"),
        Relationship ("EnergyArea", "EnergyArea", "0..1", "0..1"),
        Relationship ("TieFlow", "TieFlow", "0..*", "1")
    )
    val netInterchange: Fielder = parse_element (element (cls, fields(0)))
    val pTolerance: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ControlAreaGeneratingUnit: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EnergyArea: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TieFlow: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): ControlArea =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlArea (
            PowerSystemResource.parse (context),
            toDouble (mask (netInterchange (), 0)),
            toDouble (mask (pTolerance (), 1)),
            mask (`type` (), 2),
            masks (ControlAreaGeneratingUnit (), 3),
            mask (EnergyArea (), 4),
            masks (TieFlow (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A control area generating unit.
 *
 * This class is needed so that alternate control area definitions may include the same generating unit.   It should be noted that only one instance within a control area should reference a specific generating unit.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AltGeneratingUnitMeas [[ch.ninecode.model.AltGeneratingUnitMeas AltGeneratingUnitMeas]] The link to prioritized measurements for this GeneratingUnit.
 * @param ControlArea [[ch.ninecode.model.ControlArea ControlArea]] The parent control area for the generating unit specifications.
 * @param GeneratingUnit [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] The generating unit specified for this control area.
 *        Note that a control area should include a GeneratingUnit only once.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class ControlAreaGeneratingUnit
(
    override val sup: IdentifiedObject = null,
    AltGeneratingUnitMeas: List[String] = null,
    ControlArea: String = null,
    GeneratingUnit: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = ControlAreaGeneratingUnit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlAreaGeneratingUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ControlAreaGeneratingUnit.fields (position), x))
        emitattrs (0, AltGeneratingUnitMeas)
        emitattr (1, ControlArea)
        emitattr (2, GeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlAreaGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:ControlAreaGeneratingUnit>".format (id, export_fields)
    }
}

object ControlAreaGeneratingUnit
extends
    Parseable[ControlAreaGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "AltGeneratingUnitMeas",
        "ControlArea",
        "GeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AltGeneratingUnitMeas", "AltGeneratingUnitMeas", "0..*", "1"),
        Relationship ("ControlArea", "ControlArea", "1", "0..*"),
        Relationship ("GeneratingUnit", "GeneratingUnit", "1", "0..*")
    )
    val AltGeneratingUnitMeas: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ControlArea: Fielder = parse_attribute (attribute (cls, fields(1)))
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ControlAreaGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlAreaGeneratingUnit (
            IdentifiedObject.parse (context),
            masks (AltGeneratingUnitMeas (), 0),
            mask (ControlArea (), 1),
            mask (GeneratingUnit (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A flow specification in terms of location and direction for a control area.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param positiveFlowIn True if the flow into the terminal (load convention) is also flow into the control area.
 *        For example, this attribute should be true if using the tie line terminal further away from the control area. For example to represent a tie to a shunt component (like a load or generator) in another area, this is the near end of a branch and this attribute would be specified as false.
 * @param AltTieMeas [[ch.ninecode.model.AltTieMeas AltTieMeas]] The primary and alternate tie flow measurements associated with the tie flow.
 * @param ControlArea [[ch.ninecode.model.ControlArea ControlArea]] The control area of the tie flows.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal to which this tie flow belongs.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class TieFlow
(
    override val sup: IdentifiedObject = null,
    positiveFlowIn: Boolean = false,
    AltTieMeas: List[String] = null,
    ControlArea: String = null,
    Terminal: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = TieFlow.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TieFlow.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TieFlow.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TieFlow.fields (position), x))
        emitelem (0, positiveFlowIn)
        emitattrs (1, AltTieMeas)
        emitattr (2, ControlArea)
        emitattr (3, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TieFlow rdf:ID=\"%s\">\n%s\t</cim:TieFlow>".format (id, export_fields)
    }
}

object TieFlow
extends
    Parseable[TieFlow]
{
    override val fields: Array[String] = Array[String] (
        "positiveFlowIn",
        "AltTieMeas",
        "ControlArea",
        "Terminal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AltTieMeas", "AltTieMeas", "0..*", "1"),
        Relationship ("ControlArea", "ControlArea", "1", "0..*"),
        Relationship ("Terminal", "Terminal", "1", "0..2")
    )
    val positiveFlowIn: Fielder = parse_element (element (cls, fields(0)))
    val AltTieMeas: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): TieFlow =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TieFlow (
            IdentifiedObject.parse (context),
            toBoolean (mask (positiveFlowIn (), 0)),
            masks (AltTieMeas (), 1),
            mask (ControlArea (), 2),
            mask (Terminal (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _ControlArea
{
    def register: List[ClassInfo] =
    {
        List (
            AltGeneratingUnitMeas.register,
            AltTieMeas.register,
            ControlArea.register,
            ControlAreaGeneratingUnit.register,
            TieFlow.register
        )
    }
}