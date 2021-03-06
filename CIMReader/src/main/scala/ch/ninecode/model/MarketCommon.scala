package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * An environmental monitoring station, examples of which could be a weather station or a seismic monitoring station.
 *
 * @param IdentifiedObject    [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dstObserved         Whether this station is currently reporting using daylight saving time.
 *                            Intended to aid a utility Weather Service in interpreting information coming from a station and has no direct relationship to the manner in which time is expressed in EnvironmentalValueSet.
 * @param isNetworked         Indication that station is part of a network of stations used to monitor weather phenomena covering a large geographical area.
 * @param timeZoneOffset      The time offset from UTC (a.k.a.
 *                            GMT) configured in the station "clock", not (necessarily) the time zone in which the station is physically located.
 *                            This attribute exists to support management of utility monitoring stations and has no direct relationship to the manner in which time is expressed in EnvironmentalValueSet.
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Environmental analog measurement provided by this monitoring station.
 * @param Location            [[ch.ninecode.model.Location Location]] Location of this monitoring station.
 * @param ReportingCapability [[ch.ninecode.model.ReportingCapability ReportingCapability]] One of the reporting capabilities of this monitoring station.
 * @param TimeSeries          [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @param UsagePoint          [[ch.ninecode.model.UsagePoint UsagePoint]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class EnvironmentalMonitoringStation
(
    IdentifiedObject: IdentifiedObject = null,
    dstObserved: Boolean = false,
    isNetworked: Boolean = false,
    timeZoneOffset: Double = 0.0,
    EnvironmentalAnalog: List[String] = null,
    Location: String = null,
    ReportingCapability: List[String] = null,
    TimeSeries: List[String] = null,
    UsagePoint: List[String] = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = EnvironmentalMonitoringStation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(EnvironmentalMonitoringStation.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(EnvironmentalMonitoringStation.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(EnvironmentalMonitoringStation.fields(position), x))

        emitelem(0, dstObserved)
        emitelem(1, isNetworked)
        emitelem(2, timeZoneOffset)
        emitattrs(3, EnvironmentalAnalog)
        emitattr(4, Location)
        emitattrs(5, ReportingCapability)
        emitattrs(6, TimeSeries)
        emitattrs(7, UsagePoint)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:EnvironmentalMonitoringStation rdf:%s=\"%s\">\n%s\t</cim:EnvironmentalMonitoringStation>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object EnvironmentalMonitoringStation
    extends
        CIMParseable[EnvironmentalMonitoringStation]
{
    override val fields: Array[String] = Array[String](
        "dstObserved",
        "isNetworked",
        "timeZoneOffset",
        "EnvironmentalAnalog",
        "Location",
        "ReportingCapability",
        "TimeSeries",
        "UsagePoint"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        CIMRelationship("Location", "Location", "0..1", "0..*"),
        CIMRelationship("ReportingCapability", "ReportingCapability", "0..*", "1"),
        CIMRelationship("TimeSeries", "TimeSeries", "0..*", "0..*"),
        CIMRelationship("UsagePoint", "UsagePoint", "0..*", "0..1")
    )
    val dstObserved: Fielder = parse_element(element(cls, fields(0)))
    val isNetworked: Fielder = parse_element(element(cls, fields(1)))
    val timeZoneOffset: Fielder = parse_element(element(cls, fields(2)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val Location: Fielder = parse_attribute(attribute(cls, fields(4)))
    val ReportingCapability: FielderMultiple = parse_attributes(attribute(cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes(attribute(cls, fields(6)))
    val UsagePoint: FielderMultiple = parse_attributes(attribute(cls, fields(7)))

    def parse (context: CIMContext): EnvironmentalMonitoringStation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalMonitoringStation(
            IdentifiedObject.parse(context),
            toBoolean(mask(dstObserved(), 0)),
            toBoolean(mask(isNetworked(), 1)),
            toDouble(mask(timeZoneOffset(), 2)),
            masks(EnvironmentalAnalog(), 3),
            mask(Location(), 4),
            masks(ReportingCapability(), 5),
            masks(TimeSeries(), 6),
            masks(UsagePoint(), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EnvironmentalMonitoringStation] = EnvironmentalMonitoringStationSerializer
}

object EnvironmentalMonitoringStationSerializer extends CIMSerializer[EnvironmentalMonitoringStation]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalMonitoringStation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.dstObserved),
            () => output.writeBoolean(obj.isNetworked),
            () => output.writeDouble(obj.timeZoneOffset),
            () => writeList(obj.EnvironmentalAnalog, output),
            () => output.writeString(obj.Location),
            () => writeList(obj.ReportingCapability, output),
            () => writeList(obj.TimeSeries, output),
            () => writeList(obj.UsagePoint, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalMonitoringStation]): EnvironmentalMonitoringStation =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = EnvironmentalMonitoringStation(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) input.readBoolean else false,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) readList(input) else null,
            if (isSet(6)) readList(input) else null,
            if (isSet(7)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An identification of a party acting in a electricity market business process.
 *
 * This class is used to identify organizations that can participate in market management and/or market operations.
 *
 * @param Organisation          [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param Bid                   [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param MarketDocument        [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param MarketPerson          [[ch.ninecode.model.MarketPerson MarketPerson]] <em>undocumented</em>
 * @param MarketRole            [[ch.ninecode.model.MarketRole MarketRole]] <em>undocumented</em>
 * @param RegisteredResource    [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param TimeSeries            [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class MarketParticipant
(
    Organisation: Organisation = null,
    Bid: List[String] = null,
    MarketDocument: List[String] = null,
    MarketPerson: List[String] = null,
    MarketRole: List[String] = null,
    RegisteredResource: List[String] = null,
    SchedulingCoordinator: List[String] = null,
    TimeSeries: List[String] = null
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
    override def sup: Organisation = Organisation

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MarketParticipant.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MarketParticipant.fields(position), x))

        emitattrs(0, Bid)
        emitattrs(1, MarketDocument)
        emitattrs(2, MarketPerson)
        emitattrs(3, MarketRole)
        emitattrs(4, RegisteredResource)
        emitattrs(5, SchedulingCoordinator)
        emitattrs(6, TimeSeries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketParticipant rdf:%s=\"%s\">\n%s\t</cim:MarketParticipant>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MarketParticipant
    extends
        CIMParseable[MarketParticipant]
{
    override val fields: Array[String] = Array[String](
        "Bid",
        "MarketDocument",
        "MarketPerson",
        "MarketRole",
        "RegisteredResource",
        "SchedulingCoordinator",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Bid", "Bid", "0..*", "0..1"),
        CIMRelationship("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship("MarketPerson", "MarketPerson", "0..*", "0..*"),
        CIMRelationship("MarketRole", "MarketRole", "0..*", "0..*"),
        CIMRelationship("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        CIMRelationship("SchedulingCoordinator", "SchedulingCoordinator", "0..*", "0..1"),
        CIMRelationship("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val Bid: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val MarketDocument: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val MarketPerson: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val MarketRole: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val RegisteredResource: FielderMultiple = parse_attributes(attribute(cls, fields(4)))
    val SchedulingCoordinator: FielderMultiple = parse_attributes(attribute(cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes(attribute(cls, fields(6)))

    def parse (context: CIMContext): MarketParticipant =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketParticipant(
            Organisation.parse(context),
            masks(Bid(), 0),
            masks(MarketDocument(), 1),
            masks(MarketPerson(), 2),
            masks(MarketRole(), 3),
            masks(RegisteredResource(), 4),
            masks(SchedulingCoordinator(), 5),
            masks(TimeSeries(), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketParticipant] = MarketParticipantSerializer
}

object MarketParticipantSerializer extends CIMSerializer[MarketParticipant]
{
    def write (kryo: Kryo, output: Output, obj: MarketParticipant): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.Bid, output),
            () => writeList(obj.MarketDocument, output),
            () => writeList(obj.MarketPerson, output),
            () => writeList(obj.MarketRole, output),
            () => writeList(obj.RegisteredResource, output),
            () => writeList(obj.SchedulingCoordinator, output),
            () => writeList(obj.TimeSeries, output)
        )
        OrganisationSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketParticipant]): MarketParticipant =
    {
        val parent = OrganisationSerializer.read(kryo, input, classOf[Organisation])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MarketParticipant(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) readList(input) else null,
            if (isSet(5)) readList(input) else null,
            if (isSet(6)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The external intended behavior played by a party within the electricity market.
 *
 * @param OrganisationRole  [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param type              The kind of market roles that can be played by parties for given domains within the electricity market.
 *                          Types are flexible using dataType of string for free-entry of role types.
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class MarketRole
(
    OrganisationRole: OrganisationRole = null,
    `type`: String = null,
    MarketParticipant: List[String] = null
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
    override def sup: OrganisationRole = OrganisationRole

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MarketRole.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(MarketRole.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MarketRole.fields(position), x))

        emitelem(0, `type`)
        emitattrs(1, MarketParticipant)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketRole rdf:%s=\"%s\">\n%s\t</cim:MarketRole>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MarketRole
    extends
        CIMParseable[MarketRole]
{
    override val fields: Array[String] = Array[String](
        "type",
        "MarketParticipant"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("MarketParticipant", "MarketParticipant", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element(element(cls, fields(0)))
    val MarketParticipant: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): MarketRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketRole(
            OrganisationRole.parse(context),
            mask(`type`(), 0),
            masks(MarketParticipant(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketRole] = MarketRoleSerializer
}

object MarketRoleSerializer extends CIMSerializer[MarketRole]
{
    def write (kryo: Kryo, output: Output, obj: MarketRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.`type`),
            () => writeList(obj.MarketParticipant, output)
        )
        OrganisationRoleSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketRole]): MarketRole =
    {
        val parent = OrganisationRoleSerializer.read(kryo, input, classOf[OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MarketRole(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC61970:Production:GeneratingUnit.
 *
 * @param GeneratingUnit              [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @param GeneratingUnitDynamicValues [[ch.ninecode.model.GeneratingUnitDynamicValues GeneratingUnitDynamicValues]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class MktGeneratingUnit
(
    GeneratingUnit: GeneratingUnit = null,
    GeneratingUnitDynamicValues: List[String] = null
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
    override def sup: GeneratingUnit = GeneratingUnit

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MktGeneratingUnit.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktGeneratingUnit.fields(position), x))

        emitattrs(0, GeneratingUnitDynamicValues)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktGeneratingUnit rdf:%s=\"%s\">\n%s\t</cim:MktGeneratingUnit>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktGeneratingUnit
    extends
        CIMParseable[MktGeneratingUnit]
{
    override val fields: Array[String] = Array[String](
        "GeneratingUnitDynamicValues"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("GeneratingUnitDynamicValues", "GeneratingUnitDynamicValues", "0..*", "1")
    )
    val GeneratingUnitDynamicValues: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): MktGeneratingUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktGeneratingUnit(
            GeneratingUnit.parse(context),
            masks(GeneratingUnitDynamicValues(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktGeneratingUnit] = MktGeneratingUnitSerializer
}

object MktGeneratingUnitSerializer extends CIMSerializer[MktGeneratingUnit]
{
    def write (kryo: Kryo, output: Output, obj: MktGeneratingUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.GeneratingUnitDynamicValues, output)
        )
        GeneratingUnitSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktGeneratingUnit]): MktGeneratingUnit =
    {
        val parent = GeneratingUnitSerializer.read(kryo, input, classOf[GeneratingUnit])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktGeneratingUnit(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A resource that is registered through the market participant registration system.
 *
 * Examples include generating unit, load, and non-physical generator or load.
 *
 * @param PowerSystemResource                   [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param commercialOpDate                      Resource Commercial Operation Date.
 * @param contingencyAvailFlag                  Contingent operating reserve availiability (Yes/No).
 *                                              Resource is availiable to participate with capacity in contingency dispatch.
 * @param dispatchable                          Dispatchable: indicates whether the resource is dispatchable.
 *                                              This implies that the resource intends to submit Energy bids/offers or Ancillary Services bids/offers, or self-provided schedules.
 * @param flexibleOfferFlag                     Flexible offer flag (Y/N).
 * @param hourlyPredispatch                     Indicates need to dispatch before the start of the operating hour.
 *                                              Only relevant in Real-Time Market. Applies to generation, intertie and participating load resource. Value (Y/N).
 * @param isAggregatedRes                       A flag to indicate if a resource is an aggregated resource.
 * @param lastModified                          Indication of the last time this item was modified/versioned.
 * @param marketParticipationFlag               Market Participation flag: indicates whether the resource participate in the market.
 * @param maxBaseSelfSchedQty_1                 Maximum base self schedule quantity.
 * @param maxOnTime                             Maximum on time after start up.
 * @param minDispatchTime                       Minimum number of consecutive hours a resource shall be dispatched if bid is accepted.
 * @param minOffTime                            Minimum off time after shut down.
 * @param minOnTime                             Minimum on time after start up.
 * @param mustOfferFlag                         Must offer flag: indicates whether the unit is subject to the must offer provisions (Y/N).
 * @param nonMarket                             Flag to indicate that the Resource is not participating in the Market Operations.
 * @param pointOfDeliveryFlag                   Indication that the registered resource is a Point of Delivery (YES) resource which implies there is a POD Loss Factor.
 * @param priceSetFlagDA                        Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the DA market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N).
 *                                              Initially in the RegisteredGenerator class. It was moved to the RegisteredResource class for the participating load dispatch purpose.
 * @param priceSetFlagRT                        Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the RT market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N).
 *                                              Initially in the RegisteredGenerator class. It was moved to the RegisteredResource class for the participating load dispatch purpose.
 * @param registrationStatus                    Registration Status of resource - Active, Mothballed, Planned, or Decommissioned.
 * @param resourceAdequacyFlag                  Indication that this resource participates in the resource adequacy function.
 * @param ACAFlag                               Indication that this resource is associated with an Adjacent Control Area.
 * @param ASSPOptimizationFlag                  Indication that the resource participates in the optimization process by default.
 * @param AdjacentCASet                         [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode                         [[ch.ninecode.model.AggregateNode AggregateNode]] An AggregateNode may be associated with up to many RegisteredResources.
 * @param AllocationResultValues                [[ch.ninecode.model.AllocationResultValues AllocationResultValues]] <em>undocumented</em>
 * @param Commitments                           [[ch.ninecode.model.Commitments Commitments]] <em>undocumented</em>
 * @param ContractDistributionFactor            [[ch.ninecode.model.ContractDistributionFactor ContractDistributionFactor]] <em>undocumented</em>
 * @param ControlAreaDesignation                [[ch.ninecode.model.ControlAreaDesignation ControlAreaDesignation]] <em>undocumented</em>
 * @param DefaultBid                            [[ch.ninecode.model.DefaultBid DefaultBid]] <em>undocumented</em>
 * @param DispatchInstReply                     [[ch.ninecode.model.DispatchInstReply DispatchInstReply]] <em>undocumented</em>
 * @param Domain                                [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param DopInstruction                        [[ch.ninecode.model.DopInstruction DopInstruction]] <em>undocumented</em>
 * @param DotInstruction                        [[ch.ninecode.model.DotInstruction DotInstruction]] <em>undocumented</em>
 * @param ECAFlag                               Indication that this resource is associated with an Embedded Control area.
 * @param EnergyMarkets                         [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @param ExPostResourceResults                 [[ch.ninecode.model.ExPostResourceResults ExPostResourceResults]] <em>undocumented</em>
 * @param ExpectedEnergyValues                  [[ch.ninecode.model.ExpectedEnergyValues ExpectedEnergyValues]] <em>undocumented</em>
 * @param ForbiddenRegion                       [[ch.ninecode.model.ForbiddenRegion ForbiddenRegion]] <em>undocumented</em>
 * @param FormerReference                       [[ch.ninecode.model.FormerReference FormerReference]] <em>undocumented</em>
 * @param HostControlArea                       [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param Instructions                          [[ch.ninecode.model.Instructions Instructions]] <em>undocumented</em>
 * @param InterTie                              [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param IntermittentResourceEligibility       [[ch.ninecode.model.IntermittentResourceEligibility IntermittentResourceEligibility]] <em>undocumented</em>
 * @param LMPMFlag                              LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No).
 * @param LoadFollowingInst                     [[ch.ninecode.model.LoadFollowingInst LoadFollowingInst]] <em>undocumented</em>
 * @param LoadFollowingOperatorInput            [[ch.ninecode.model.LoadFollowingOperatorInput LoadFollowingOperatorInput]] <em>undocumented</em>
 * @param MPMResourceStatus                     [[ch.ninecode.model.MPMResourceStatus MPMResourceStatus]] <em>undocumented</em>
 * @param MPMTestThreshold                      [[ch.ninecode.model.MPMTestThreshold MPMTestThreshold]] <em>undocumented</em>
 * @param MarketObjectStatus                    [[ch.ninecode.model.MarketObjectStatus MarketObjectStatus]] <em>undocumented</em>
 * @param MarketParticipant                     [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param MktConnectivityNode                   [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param OrgResOwnership                       [[ch.ninecode.model.OrgResOwnership OrgResOwnership]] <em>undocumented</em>
 * @param Pnode                                 [[ch.ninecode.model.Pnode Pnode]] A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param RMROperatorInput                      [[ch.ninecode.model.RMROperatorInput RMROperatorInput]] <em>undocumented</em>
 * @param RUCAwardInstruction                   [[ch.ninecode.model.RUCAwardInstruction RUCAwardInstruction]] <em>undocumented</em>
 * @param RampRateCurve                         [[ch.ninecode.model.RampRateCurve RampRateCurve]] <em>undocumented</em>
 * @param Reason                                [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @param ResourceAncillaryServiceQualification [[ch.ninecode.model.ResourceCertification ResourceCertification]] RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
 * @param ResourceAwardInstruction              [[ch.ninecode.model.ResourceAwardInstruction ResourceAwardInstruction]] <em>undocumented</em>
 * @param ResourceCapacity                      [[ch.ninecode.model.ResourceCapacity ResourceCapacity]] <em>undocumented</em>
 * @param ResourceCertification                 [[ch.ninecode.model.ResourceCertification2 ResourceCertification2]] <em>undocumented</em>
 * @param ResourceDispatchResults               [[ch.ninecode.model.ResourceDispatchResults ResourceDispatchResults]] <em>undocumented</em>
 * @param ResourceGroups                        [[ch.ninecode.model.ResourceGroup ResourceGroup]] <em>undocumented</em>
 * @param ResourceLoadFollowingInst             [[ch.ninecode.model.ResourceLoadFollowingInst ResourceLoadFollowingInst]] <em>undocumented</em>
 * @param ResourceVerifiableCosts               [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @param SMPMFlag                              SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No).
 * @param SubControlArea                        [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param SubstitutionResourceList              [[ch.ninecode.model.SubstitutionResourceList SubstitutionResourceList]] <em>undocumented</em>
 * @param TimeSeries                            [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class RegisteredResource
(
    PowerSystemResource: PowerSystemResource = null,
    commercialOpDate: String = null,
    contingencyAvailFlag: String = null,
    dispatchable: Boolean = false,
    flexibleOfferFlag: String = null,
    hourlyPredispatch: String = null,
    isAggregatedRes: String = null,
    lastModified: String = null,
    marketParticipationFlag: String = null,
    maxBaseSelfSchedQty_1: Double = 0.0,
    maxOnTime: Double = 0.0,
    minDispatchTime: Double = 0.0,
    minOffTime: Double = 0.0,
    minOnTime: Double = 0.0,
    mustOfferFlag: String = null,
    nonMarket: String = null,
    pointOfDeliveryFlag: String = null,
    priceSetFlagDA: String = null,
    priceSetFlagRT: String = null,
    registrationStatus: String = null,
    resourceAdequacyFlag: String = null,
    ACAFlag: String = null,
    ASSPOptimizationFlag: String = null,
    AdjacentCASet: String = null,
    AggregateNode: String = null,
    AllocationResultValues: List[String] = null,
    Commitments: List[String] = null,
    ContractDistributionFactor: List[String] = null,
    ControlAreaDesignation: List[String] = null,
    DefaultBid: String = null,
    DispatchInstReply: List[String] = null,
    Domain: List[String] = null,
    DopInstruction: List[String] = null,
    DotInstruction: List[String] = null,
    ECAFlag: String = null,
    EnergyMarkets: List[String] = null,
    ExPostResourceResults: List[String] = null,
    ExpectedEnergyValues: List[String] = null,
    ForbiddenRegion: List[String] = null,
    FormerReference: List[String] = null,
    HostControlArea: String = null,
    Instructions: List[String] = null,
    InterTie: List[String] = null,
    IntermittentResourceEligibility: List[String] = null,
    LMPMFlag: String = null,
    LoadFollowingInst: List[String] = null,
    LoadFollowingOperatorInput: List[String] = null,
    MPMResourceStatus: List[String] = null,
    MPMTestThreshold: List[String] = null,
    MarketObjectStatus: List[String] = null,
    MarketParticipant: String = null,
    MktConnectivityNode: String = null,
    OrgResOwnership: List[String] = null,
    Pnode: String = null,
    RMROperatorInput: List[String] = null,
    RUCAwardInstruction: List[String] = null,
    RampRateCurve: List[String] = null,
    Reason: List[String] = null,
    ResourceAncillaryServiceQualification: List[String] = null,
    ResourceAwardInstruction: List[String] = null,
    ResourceCapacity: List[String] = null,
    ResourceCertification: List[String] = null,
    ResourceDispatchResults: List[String] = null,
    ResourceGroups: List[String] = null,
    ResourceLoadFollowingInst: List[String] = null,
    ResourceVerifiableCosts: String = null,
    SMPMFlag: String = null,
    SubControlArea: List[String] = null,
    SubstitutionResourceList: List[String] = null,
    TimeSeries: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = RegisteredResource.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(RegisteredResource.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(RegisteredResource.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(RegisteredResource.fields(position), x))

        emitelem(0, commercialOpDate)
        emitattr(1, contingencyAvailFlag)
        emitelem(2, dispatchable)
        emitattr(3, flexibleOfferFlag)
        emitattr(4, hourlyPredispatch)
        emitattr(5, isAggregatedRes)
        emitelem(6, lastModified)
        emitattr(7, marketParticipationFlag)
        emitelem(8, maxBaseSelfSchedQty_1)
        emitelem(9, maxOnTime)
        emitelem(10, minDispatchTime)
        emitelem(11, minOffTime)
        emitelem(12, minOnTime)
        emitattr(13, mustOfferFlag)
        emitattr(14, nonMarket)
        emitattr(15, pointOfDeliveryFlag)
        emitattr(16, priceSetFlagDA)
        emitattr(17, priceSetFlagRT)
        emitattr(18, registrationStatus)
        emitattr(19, resourceAdequacyFlag)
        emitattr(20, ACAFlag)
        emitattr(21, ASSPOptimizationFlag)
        emitattr(22, AdjacentCASet)
        emitattr(23, AggregateNode)
        emitattrs(24, AllocationResultValues)
        emitattrs(25, Commitments)
        emitattrs(26, ContractDistributionFactor)
        emitattrs(27, ControlAreaDesignation)
        emitattr(28, DefaultBid)
        emitattrs(29, DispatchInstReply)
        emitattrs(30, Domain)
        emitattrs(31, DopInstruction)
        emitattrs(32, DotInstruction)
        emitattr(33, ECAFlag)
        emitattrs(34, EnergyMarkets)
        emitattrs(35, ExPostResourceResults)
        emitattrs(36, ExpectedEnergyValues)
        emitattrs(37, ForbiddenRegion)
        emitattrs(38, FormerReference)
        emitattr(39, HostControlArea)
        emitattrs(40, Instructions)
        emitattrs(41, InterTie)
        emitattrs(42, IntermittentResourceEligibility)
        emitattr(43, LMPMFlag)
        emitattrs(44, LoadFollowingInst)
        emitattrs(45, LoadFollowingOperatorInput)
        emitattrs(46, MPMResourceStatus)
        emitattrs(47, MPMTestThreshold)
        emitattrs(48, MarketObjectStatus)
        emitattr(49, MarketParticipant)
        emitattr(50, MktConnectivityNode)
        emitattrs(51, OrgResOwnership)
        emitattr(52, Pnode)
        emitattrs(53, RMROperatorInput)
        emitattrs(54, RUCAwardInstruction)
        emitattrs(55, RampRateCurve)
        emitattrs(56, Reason)
        emitattrs(57, ResourceAncillaryServiceQualification)
        emitattrs(58, ResourceAwardInstruction)
        emitattrs(59, ResourceCapacity)
        emitattrs(60, ResourceCertification)
        emitattrs(61, ResourceDispatchResults)
        emitattrs(62, ResourceGroups)
        emitattrs(63, ResourceLoadFollowingInst)
        emitattr(64, ResourceVerifiableCosts)
        emitattr(65, SMPMFlag)
        emitattrs(66, SubControlArea)
        emitattrs(67, SubstitutionResourceList)
        emitattrs(68, TimeSeries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RegisteredResource rdf:%s=\"%s\">\n%s\t</cim:RegisteredResource>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object RegisteredResource
    extends
        CIMParseable[RegisteredResource]
{
    override val fields: Array[String] = Array[String](
        "commercialOpDate",
        "contingencyAvailFlag",
        "dispatchable",
        "flexibleOfferFlag",
        "hourlyPredispatch",
        "isAggregatedRes",
        "lastModified",
        "marketParticipationFlag",
        "maxBaseSelfSchedQty ",
        "maxOnTime",
        "minDispatchTime",
        "minOffTime",
        "minOnTime",
        "mustOfferFlag",
        "nonMarket",
        "pointOfDeliveryFlag",
        "priceSetFlagDA",
        "priceSetFlagRT",
        "registrationStatus",
        "resourceAdequacyFlag",
        "ACAFlag",
        "ASSPOptimizationFlag",
        "AdjacentCASet",
        "AggregateNode",
        "AllocationResultValues",
        "Commitments",
        "ContractDistributionFactor",
        "ControlAreaDesignation",
        "DefaultBid",
        "DispatchInstReply",
        "Domain",
        "DopInstruction",
        "DotInstruction",
        "ECAFlag",
        "EnergyMarkets",
        "ExPostResourceResults",
        "ExpectedEnergyValues",
        "ForbiddenRegion",
        "FormerReference",
        "HostControlArea",
        "Instructions",
        "InterTie",
        "IntermittentResourceEligibility",
        "LMPMFlag",
        "LoadFollowingInst",
        "LoadFollowingOperatorInput",
        "MPMResourceStatus",
        "MPMTestThreshold",
        "MarketObjectStatus",
        "MarketParticipant",
        "MktConnectivityNode",
        "OrgResOwnership",
        "Pnode",
        "RMROperatorInput",
        "RUCAwardInstruction",
        "RampRateCurve",
        "Reason",
        "ResourceAncillaryServiceQualification",
        "ResourceAwardInstruction",
        "ResourceCapacity",
        "ResourceCertification",
        "ResourceDispatchResults",
        "ResourceGroups",
        "ResourceLoadFollowingInst",
        "ResourceVerifiableCosts",
        "SMPMFlag",
        "SubControlArea",
        "SubstitutionResourceList",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AdjacentCASet", "AdjacentCASet", "0..1", "0..*"),
        CIMRelationship("AggregateNode", "AggregateNode", "0..1", "0..*"),
        CIMRelationship("AllocationResultValues", "AllocationResultValues", "0..*", "0..1"),
        CIMRelationship("Commitments", "Commitments", "0..*", "1"),
        CIMRelationship("ContractDistributionFactor", "ContractDistributionFactor", "0..*", "0..1"),
        CIMRelationship("ControlAreaDesignation", "ControlAreaDesignation", "0..*", "0..*"),
        CIMRelationship("DefaultBid", "DefaultBid", "0..1", "1"),
        CIMRelationship("DispatchInstReply", "DispatchInstReply", "0..*", "1"),
        CIMRelationship("Domain", "Domain", "0..*", "0..*"),
        CIMRelationship("DopInstruction", "DopInstruction", "0..*", "0..1"),
        CIMRelationship("DotInstruction", "DotInstruction", "0..*", "0..1"),
        CIMRelationship("EnergyMarkets", "EnergyMarket", "0..*", "0..*"),
        CIMRelationship("ExPostResourceResults", "ExPostResourceResults", "0..*", "0..1"),
        CIMRelationship("ExpectedEnergyValues", "ExpectedEnergyValues", "0..*", "0..1"),
        CIMRelationship("ForbiddenRegion", "ForbiddenRegion", "0..*", "0..*"),
        CIMRelationship("FormerReference", "FormerReference", "0..*", "1"),
        CIMRelationship("HostControlArea", "HostControlArea", "0..1", "0..*"),
        CIMRelationship("Instructions", "Instructions", "0..*", "1"),
        CIMRelationship("InterTie", "SchedulingPoint", "0..*", "0..*"),
        CIMRelationship("IntermittentResourceEligibility", "IntermittentResourceEligibility", "0..*", "1"),
        CIMRelationship("LoadFollowingInst", "LoadFollowingInst", "0..*", "1"),
        CIMRelationship("LoadFollowingOperatorInput", "LoadFollowingOperatorInput", "0..*", "0..1"),
        CIMRelationship("MPMResourceStatus", "MPMResourceStatus", "0..*", "0..1"),
        CIMRelationship("MPMTestThreshold", "MPMTestThreshold", "0..*", "0..*"),
        CIMRelationship("MarketObjectStatus", "MarketObjectStatus", "0..*", "0..*"),
        CIMRelationship("MarketParticipant", "MarketParticipant", "0..1", "0..*"),
        CIMRelationship("MktConnectivityNode", "MktConnectivityNode", "0..1", "0..*"),
        CIMRelationship("OrgResOwnership", "OrgResOwnership", "0..*", "1"),
        CIMRelationship("Pnode", "Pnode", "0..1", "0..*"),
        CIMRelationship("RMROperatorInput", "RMROperatorInput", "0..*", "0..1"),
        CIMRelationship("RUCAwardInstruction", "RUCAwardInstruction", "0..*", "0..1"),
        CIMRelationship("RampRateCurve", "RampRateCurve", "0..*", "0..*"),
        CIMRelationship("Reason", "Reason", "0..*", "0..*"),
        CIMRelationship("ResourceAncillaryServiceQualification", "ResourceCertification", "0..*", "1"),
        CIMRelationship("ResourceAwardInstruction", "ResourceAwardInstruction", "0..*", "0..1"),
        CIMRelationship("ResourceCapacity", "ResourceCapacity", "0..*", "0..*"),
        CIMRelationship("ResourceCertification", "ResourceCertification2", "0..*", "0..*"),
        CIMRelationship("ResourceDispatchResults", "ResourceDispatchResults", "0..*", "0..1"),
        CIMRelationship("ResourceGroups", "ResourceGroup", "0..*", "1..*"),
        CIMRelationship("ResourceLoadFollowingInst", "ResourceLoadFollowingInst", "0..*", "0..1"),
        CIMRelationship("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1"),
        CIMRelationship("SubControlArea", "SubControlArea", "0..*", "0..*"),
        CIMRelationship("SubstitutionResourceList", "SubstitutionResourceList", "0..*", "0..1"),
        CIMRelationship("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val commercialOpDate: Fielder = parse_element(element(cls, fields(0)))
    val contingencyAvailFlag: Fielder = parse_attribute(attribute(cls, fields(1)))
    val dispatchable: Fielder = parse_element(element(cls, fields(2)))
    val flexibleOfferFlag: Fielder = parse_attribute(attribute(cls, fields(3)))
    val hourlyPredispatch: Fielder = parse_attribute(attribute(cls, fields(4)))
    val isAggregatedRes: Fielder = parse_attribute(attribute(cls, fields(5)))
    val lastModified: Fielder = parse_element(element(cls, fields(6)))
    val marketParticipationFlag: Fielder = parse_attribute(attribute(cls, fields(7)))
    val maxBaseSelfSchedQty_1: Fielder = parse_element(element(cls, fields(8)))
    val maxOnTime: Fielder = parse_element(element(cls, fields(9)))
    val minDispatchTime: Fielder = parse_element(element(cls, fields(10)))
    val minOffTime: Fielder = parse_element(element(cls, fields(11)))
    val minOnTime: Fielder = parse_element(element(cls, fields(12)))
    val mustOfferFlag: Fielder = parse_attribute(attribute(cls, fields(13)))
    val nonMarket: Fielder = parse_attribute(attribute(cls, fields(14)))
    val pointOfDeliveryFlag: Fielder = parse_attribute(attribute(cls, fields(15)))
    val priceSetFlagDA: Fielder = parse_attribute(attribute(cls, fields(16)))
    val priceSetFlagRT: Fielder = parse_attribute(attribute(cls, fields(17)))
    val registrationStatus: Fielder = parse_attribute(attribute(cls, fields(18)))
    val resourceAdequacyFlag: Fielder = parse_attribute(attribute(cls, fields(19)))
    val ACAFlag: Fielder = parse_attribute(attribute(cls, fields(20)))
    val ASSPOptimizationFlag: Fielder = parse_attribute(attribute(cls, fields(21)))
    val AdjacentCASet: Fielder = parse_attribute(attribute(cls, fields(22)))
    val AggregateNode: Fielder = parse_attribute(attribute(cls, fields(23)))
    val AllocationResultValues: FielderMultiple = parse_attributes(attribute(cls, fields(24)))
    val Commitments: FielderMultiple = parse_attributes(attribute(cls, fields(25)))
    val ContractDistributionFactor: FielderMultiple = parse_attributes(attribute(cls, fields(26)))
    val ControlAreaDesignation: FielderMultiple = parse_attributes(attribute(cls, fields(27)))
    val DefaultBid: Fielder = parse_attribute(attribute(cls, fields(28)))
    val DispatchInstReply: FielderMultiple = parse_attributes(attribute(cls, fields(29)))
    val Domain: FielderMultiple = parse_attributes(attribute(cls, fields(30)))
    val DopInstruction: FielderMultiple = parse_attributes(attribute(cls, fields(31)))
    val DotInstruction: FielderMultiple = parse_attributes(attribute(cls, fields(32)))
    val ECAFlag: Fielder = parse_attribute(attribute(cls, fields(33)))
    val EnergyMarkets: FielderMultiple = parse_attributes(attribute(cls, fields(34)))
    val ExPostResourceResults: FielderMultiple = parse_attributes(attribute(cls, fields(35)))
    val ExpectedEnergyValues: FielderMultiple = parse_attributes(attribute(cls, fields(36)))
    val ForbiddenRegion: FielderMultiple = parse_attributes(attribute(cls, fields(37)))
    val FormerReference: FielderMultiple = parse_attributes(attribute(cls, fields(38)))
    val HostControlArea: Fielder = parse_attribute(attribute(cls, fields(39)))
    val Instructions: FielderMultiple = parse_attributes(attribute(cls, fields(40)))
    val InterTie: FielderMultiple = parse_attributes(attribute(cls, fields(41)))
    val IntermittentResourceEligibility: FielderMultiple = parse_attributes(attribute(cls, fields(42)))
    val LMPMFlag: Fielder = parse_attribute(attribute(cls, fields(43)))
    val LoadFollowingInst: FielderMultiple = parse_attributes(attribute(cls, fields(44)))
    val LoadFollowingOperatorInput: FielderMultiple = parse_attributes(attribute(cls, fields(45)))
    val MPMResourceStatus: FielderMultiple = parse_attributes(attribute(cls, fields(46)))
    val MPMTestThreshold: FielderMultiple = parse_attributes(attribute(cls, fields(47)))
    val MarketObjectStatus: FielderMultiple = parse_attributes(attribute(cls, fields(48)))
    val MarketParticipant: Fielder = parse_attribute(attribute(cls, fields(49)))
    val MktConnectivityNode: Fielder = parse_attribute(attribute(cls, fields(50)))
    val OrgResOwnership: FielderMultiple = parse_attributes(attribute(cls, fields(51)))
    val Pnode: Fielder = parse_attribute(attribute(cls, fields(52)))
    val RMROperatorInput: FielderMultiple = parse_attributes(attribute(cls, fields(53)))
    val RUCAwardInstruction: FielderMultiple = parse_attributes(attribute(cls, fields(54)))
    val RampRateCurve: FielderMultiple = parse_attributes(attribute(cls, fields(55)))
    val Reason: FielderMultiple = parse_attributes(attribute(cls, fields(56)))
    val ResourceAncillaryServiceQualification: FielderMultiple = parse_attributes(attribute(cls, fields(57)))
    val ResourceAwardInstruction: FielderMultiple = parse_attributes(attribute(cls, fields(58)))
    val ResourceCapacity: FielderMultiple = parse_attributes(attribute(cls, fields(59)))
    val ResourceCertification: FielderMultiple = parse_attributes(attribute(cls, fields(60)))
    val ResourceDispatchResults: FielderMultiple = parse_attributes(attribute(cls, fields(61)))
    val ResourceGroups: FielderMultiple = parse_attributes(attribute(cls, fields(62)))
    val ResourceLoadFollowingInst: FielderMultiple = parse_attributes(attribute(cls, fields(63)))
    val ResourceVerifiableCosts: Fielder = parse_attribute(attribute(cls, fields(64)))
    val SMPMFlag: Fielder = parse_attribute(attribute(cls, fields(65)))
    val SubControlArea: FielderMultiple = parse_attributes(attribute(cls, fields(66)))
    val SubstitutionResourceList: FielderMultiple = parse_attributes(attribute(cls, fields(67)))
    val TimeSeries: FielderMultiple = parse_attributes(attribute(cls, fields(68)))

    def parse (context: CIMContext): RegisteredResource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0, 0, 0)
        val ret = RegisteredResource(
            PowerSystemResource.parse(context),
            mask(commercialOpDate(), 0),
            mask(contingencyAvailFlag(), 1),
            toBoolean(mask(dispatchable(), 2)),
            mask(flexibleOfferFlag(), 3),
            mask(hourlyPredispatch(), 4),
            mask(isAggregatedRes(), 5),
            mask(lastModified(), 6),
            mask(marketParticipationFlag(), 7),
            toDouble(mask(maxBaseSelfSchedQty_1(), 8)),
            toDouble(mask(maxOnTime(), 9)),
            toDouble(mask(minDispatchTime(), 10)),
            toDouble(mask(minOffTime(), 11)),
            toDouble(mask(minOnTime(), 12)),
            mask(mustOfferFlag(), 13),
            mask(nonMarket(), 14),
            mask(pointOfDeliveryFlag(), 15),
            mask(priceSetFlagDA(), 16),
            mask(priceSetFlagRT(), 17),
            mask(registrationStatus(), 18),
            mask(resourceAdequacyFlag(), 19),
            mask(ACAFlag(), 20),
            mask(ASSPOptimizationFlag(), 21),
            mask(AdjacentCASet(), 22),
            mask(AggregateNode(), 23),
            masks(AllocationResultValues(), 24),
            masks(Commitments(), 25),
            masks(ContractDistributionFactor(), 26),
            masks(ControlAreaDesignation(), 27),
            mask(DefaultBid(), 28),
            masks(DispatchInstReply(), 29),
            masks(Domain(), 30),
            masks(DopInstruction(), 31),
            masks(DotInstruction(), 32),
            mask(ECAFlag(), 33),
            masks(EnergyMarkets(), 34),
            masks(ExPostResourceResults(), 35),
            masks(ExpectedEnergyValues(), 36),
            masks(ForbiddenRegion(), 37),
            masks(FormerReference(), 38),
            mask(HostControlArea(), 39),
            masks(Instructions(), 40),
            masks(InterTie(), 41),
            masks(IntermittentResourceEligibility(), 42),
            mask(LMPMFlag(), 43),
            masks(LoadFollowingInst(), 44),
            masks(LoadFollowingOperatorInput(), 45),
            masks(MPMResourceStatus(), 46),
            masks(MPMTestThreshold(), 47),
            masks(MarketObjectStatus(), 48),
            mask(MarketParticipant(), 49),
            mask(MktConnectivityNode(), 50),
            masks(OrgResOwnership(), 51),
            mask(Pnode(), 52),
            masks(RMROperatorInput(), 53),
            masks(RUCAwardInstruction(), 54),
            masks(RampRateCurve(), 55),
            masks(Reason(), 56),
            masks(ResourceAncillaryServiceQualification(), 57),
            masks(ResourceAwardInstruction(), 58),
            masks(ResourceCapacity(), 59),
            masks(ResourceCertification(), 60),
            masks(ResourceDispatchResults(), 61),
            masks(ResourceGroups(), 62),
            masks(ResourceLoadFollowingInst(), 63),
            mask(ResourceVerifiableCosts(), 64),
            mask(SMPMFlag(), 65),
            masks(SubControlArea(), 66),
            masks(SubstitutionResourceList(), 67),
            masks(TimeSeries(), 68)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RegisteredResource] = RegisteredResourceSerializer
}

object RegisteredResourceSerializer extends CIMSerializer[RegisteredResource]
{
    def write (kryo: Kryo, output: Output, obj: RegisteredResource): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.commercialOpDate),
            () => output.writeString(obj.contingencyAvailFlag),
            () => output.writeBoolean(obj.dispatchable),
            () => output.writeString(obj.flexibleOfferFlag),
            () => output.writeString(obj.hourlyPredispatch),
            () => output.writeString(obj.isAggregatedRes),
            () => output.writeString(obj.lastModified),
            () => output.writeString(obj.marketParticipationFlag),
            () => output.writeDouble(obj.maxBaseSelfSchedQty_1),
            () => output.writeDouble(obj.maxOnTime),
            () => output.writeDouble(obj.minDispatchTime),
            () => output.writeDouble(obj.minOffTime),
            () => output.writeDouble(obj.minOnTime),
            () => output.writeString(obj.mustOfferFlag),
            () => output.writeString(obj.nonMarket),
            () => output.writeString(obj.pointOfDeliveryFlag),
            () => output.writeString(obj.priceSetFlagDA),
            () => output.writeString(obj.priceSetFlagRT),
            () => output.writeString(obj.registrationStatus),
            () => output.writeString(obj.resourceAdequacyFlag),
            () => output.writeString(obj.ACAFlag),
            () => output.writeString(obj.ASSPOptimizationFlag),
            () => output.writeString(obj.AdjacentCASet),
            () => output.writeString(obj.AggregateNode),
            () => writeList(obj.AllocationResultValues, output),
            () => writeList(obj.Commitments, output),
            () => writeList(obj.ContractDistributionFactor, output),
            () => writeList(obj.ControlAreaDesignation, output),
            () => output.writeString(obj.DefaultBid),
            () => writeList(obj.DispatchInstReply, output),
            () => writeList(obj.Domain, output),
            () => writeList(obj.DopInstruction, output),
            () => writeList(obj.DotInstruction, output),
            () => output.writeString(obj.ECAFlag),
            () => writeList(obj.EnergyMarkets, output),
            () => writeList(obj.ExPostResourceResults, output),
            () => writeList(obj.ExpectedEnergyValues, output),
            () => writeList(obj.ForbiddenRegion, output),
            () => writeList(obj.FormerReference, output),
            () => output.writeString(obj.HostControlArea),
            () => writeList(obj.Instructions, output),
            () => writeList(obj.InterTie, output),
            () => writeList(obj.IntermittentResourceEligibility, output),
            () => output.writeString(obj.LMPMFlag),
            () => writeList(obj.LoadFollowingInst, output),
            () => writeList(obj.LoadFollowingOperatorInput, output),
            () => writeList(obj.MPMResourceStatus, output),
            () => writeList(obj.MPMTestThreshold, output),
            () => writeList(obj.MarketObjectStatus, output),
            () => output.writeString(obj.MarketParticipant),
            () => output.writeString(obj.MktConnectivityNode),
            () => writeList(obj.OrgResOwnership, output),
            () => output.writeString(obj.Pnode),
            () => writeList(obj.RMROperatorInput, output),
            () => writeList(obj.RUCAwardInstruction, output),
            () => writeList(obj.RampRateCurve, output),
            () => writeList(obj.Reason, output),
            () => writeList(obj.ResourceAncillaryServiceQualification, output),
            () => writeList(obj.ResourceAwardInstruction, output),
            () => writeList(obj.ResourceCapacity, output),
            () => writeList(obj.ResourceCertification, output),
            () => writeList(obj.ResourceDispatchResults, output),
            () => writeList(obj.ResourceGroups, output),
            () => writeList(obj.ResourceLoadFollowingInst, output),
            () => output.writeString(obj.ResourceVerifiableCosts),
            () => output.writeString(obj.SMPMFlag),
            () => writeList(obj.SubControlArea, output),
            () => writeList(obj.SubstitutionResourceList, output),
            () => writeList(obj.TimeSeries, output)
        )
        PowerSystemResourceSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegisteredResource]): RegisteredResource =
    {
        val parent = PowerSystemResourceSerializer.read(kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = RegisteredResource(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readBoolean else false,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readString else null,
            if (isSet(14)) input.readString else null,
            if (isSet(15)) input.readString else null,
            if (isSet(16)) input.readString else null,
            if (isSet(17)) input.readString else null,
            if (isSet(18)) input.readString else null,
            if (isSet(19)) input.readString else null,
            if (isSet(20)) input.readString else null,
            if (isSet(21)) input.readString else null,
            if (isSet(22)) input.readString else null,
            if (isSet(23)) input.readString else null,
            if (isSet(24)) readList(input) else null,
            if (isSet(25)) readList(input) else null,
            if (isSet(26)) readList(input) else null,
            if (isSet(27)) readList(input) else null,
            if (isSet(28)) input.readString else null,
            if (isSet(29)) readList(input) else null,
            if (isSet(30)) readList(input) else null,
            if (isSet(31)) readList(input) else null,
            if (isSet(32)) readList(input) else null,
            if (isSet(33)) input.readString else null,
            if (isSet(34)) readList(input) else null,
            if (isSet(35)) readList(input) else null,
            if (isSet(36)) readList(input) else null,
            if (isSet(37)) readList(input) else null,
            if (isSet(38)) readList(input) else null,
            if (isSet(39)) input.readString else null,
            if (isSet(40)) readList(input) else null,
            if (isSet(41)) readList(input) else null,
            if (isSet(42)) readList(input) else null,
            if (isSet(43)) input.readString else null,
            if (isSet(44)) readList(input) else null,
            if (isSet(45)) readList(input) else null,
            if (isSet(46)) readList(input) else null,
            if (isSet(47)) readList(input) else null,
            if (isSet(48)) readList(input) else null,
            if (isSet(49)) input.readString else null,
            if (isSet(50)) input.readString else null,
            if (isSet(51)) readList(input) else null,
            if (isSet(52)) input.readString else null,
            if (isSet(53)) readList(input) else null,
            if (isSet(54)) readList(input) else null,
            if (isSet(55)) readList(input) else null,
            if (isSet(56)) readList(input) else null,
            if (isSet(57)) readList(input) else null,
            if (isSet(58)) readList(input) else null,
            if (isSet(59)) readList(input) else null,
            if (isSet(60)) readList(input) else null,
            if (isSet(61)) readList(input) else null,
            if (isSet(62)) readList(input) else null,
            if (isSet(63)) readList(input) else null,
            if (isSet(64)) input.readString else null,
            if (isSet(65)) input.readString else null,
            if (isSet(66)) readList(input) else null,
            if (isSet(67)) readList(input) else null,
            if (isSet(68)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class model the various capacities of a resource.
 *
 * A resource may have numbers of capacities related to operating, ancillary services, energy trade and so forth. Capacities may be defined for active power or reactive power.
 *
 * @param Element            Reference to the superclass object.
 * @param capacityType       capacity type
 *
 *                           The types are but not limited to:
 *
 *                           Regulation Up
 *                           Regulation Dn
 *                           Spinning Reserve
 *                           Non-Spinning Reserve
 *                           FOO capacity
 *                           MOO capacity
 * @param defaultCapacity    default capacity
 * @param maximumCapacity    maximum capacity
 * @param minimumCapacity    minimum capacity
 * @param unitSymbol         Unit selection for the capacity values.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class ResourceCapacity
(
    Element: BasicElement = null,
    capacityType: String = null,
    defaultCapacity: Double = 0.0,
    maximumCapacity: Double = 0.0,
    minimumCapacity: Double = 0.0,
    unitSymbol: String = null,
    RegisteredResource: List[String] = null
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
    override def sup: Element = Element

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ResourceCapacity.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ResourceCapacity.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ResourceCapacity.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ResourceCapacity.fields(position), x))

        emitattr(0, capacityType)
        emitelem(1, defaultCapacity)
        emitelem(2, maximumCapacity)
        emitelem(3, minimumCapacity)
        emitattr(4, unitSymbol)
        emitattrs(5, RegisteredResource)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ResourceCapacity rdf:%s=\"%s\">\n%s\t</cim:ResourceCapacity>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ResourceCapacity
    extends
        CIMParseable[ResourceCapacity]
{
    override val fields: Array[String] = Array[String](
        "capacityType",
        "defaultCapacity",
        "maximumCapacity",
        "minimumCapacity",
        "unitSymbol",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val capacityType: Fielder = parse_attribute(attribute(cls, fields(0)))
    val defaultCapacity: Fielder = parse_element(element(cls, fields(1)))
    val maximumCapacity: Fielder = parse_element(element(cls, fields(2)))
    val minimumCapacity: Fielder = parse_element(element(cls, fields(3)))
    val unitSymbol: Fielder = parse_attribute(attribute(cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes(attribute(cls, fields(5)))

    def parse (context: CIMContext): ResourceCapacity =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceCapacity(
            BasicElement.parse(context),
            mask(capacityType(), 0),
            toDouble(mask(defaultCapacity(), 1)),
            toDouble(mask(maximumCapacity(), 2)),
            toDouble(mask(minimumCapacity(), 3)),
            mask(unitSymbol(), 4),
            masks(RegisteredResource(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ResourceCapacity] = ResourceCapacitySerializer
}

object ResourceCapacitySerializer extends CIMSerializer[ResourceCapacity]
{
    def write (kryo: Kryo, output: Output, obj: ResourceCapacity): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.capacityType),
            () => output.writeDouble(obj.defaultCapacity),
            () => output.writeDouble(obj.maximumCapacity),
            () => output.writeDouble(obj.minimumCapacity),
            () => output.writeString(obj.unitSymbol),
            () => writeList(obj.RegisteredResource, output)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceCapacity]): ResourceCapacity =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ResourceCapacity(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _MarketCommon
{
    def register: List[CIMClassInfo] =
    {
        List(
            EnvironmentalMonitoringStation.register,
            MarketParticipant.register,
            MarketRole.register,
            MktGeneratingUnit.register,
            RegisteredResource.register,
            ResourceCapacity.register
        )
    }
}