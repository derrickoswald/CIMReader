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
 * An Asset Property that is described through curves rather than as a data point.
 *
 * The relationship is to be defined between an independent variable (X-axis) and one or two dependent variables (Y1-axis and Y2-axis).
 *
 * @param Curve         [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param Assets        [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param Specification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class AssetPropertyCurve
(
    Curve: Curve = null,
    Assets: List[String] = null,
    Specification: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = AssetPropertyCurve.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AssetPropertyCurve.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(AssetPropertyCurve.fields(position), x))

        emitattrs(0, Assets)
        emitattr(1, Specification)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AssetPropertyCurve rdf:%s=\"%s\">\n%s\t</cim:AssetPropertyCurve>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AssetPropertyCurve
    extends
        CIMParseable[AssetPropertyCurve]
{
    override val fields: Array[String] = Array[String](
        "Assets",
        "Specification"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship("Specification", "Specification", "0..1", "0..*")
    )
    val Assets: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val Specification: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): AssetPropertyCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetPropertyCurve(
            Curve.parse(context),
            masks(Assets(), 0),
            mask(Specification(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetPropertyCurve] = AssetPropertyCurveSerializer
}

object AssetPropertyCurveSerializer extends CIMSerializer[AssetPropertyCurve]
{
    def write (kryo: Kryo, output: Output, obj: AssetPropertyCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.Assets, output),
            () => output.writeString(obj.Specification)
        )
        CurveSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetPropertyCurve]): AssetPropertyCurve =
    {
        val parent = CurveSerializer.read(kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AssetPropertyCurve(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Bushing insulation power factor condition as a result of a test.
 *
 * Typical status values are: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 *
 * @param IdentifiedObject       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status                 <em>undocumented</em>
 * @param testKind               Kind of test for this bushing.
 * @param Bushing                [[ch.ninecode.model.Bushing Bushing]] <em>undocumented</em>
 * @param TransformerObservation [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class BushingInsulationPF
(
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    testKind: String = null,
    Bushing: String = null,
    TransformerObservation: String = null
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
        implicit val clz: String = BushingInsulationPF.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(BushingInsulationPF.fields(position), value)

        emitattr(0, status)
        emitattr(1, testKind)
        emitattr(2, Bushing)
        emitattr(3, TransformerObservation)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BushingInsulationPF rdf:%s=\"%s\">\n%s\t</cim:BushingInsulationPF>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BushingInsulationPF
    extends
        CIMParseable[BushingInsulationPF]
{
    override val fields: Array[String] = Array[String](
        "status",
        "testKind",
        "Bushing",
        "TransformerObservation"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Bushing", "Bushing", "0..1", "0..*"),
        CIMRelationship("TransformerObservation", "TransformerObservation", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val testKind: Fielder = parse_attribute(attribute(cls, fields(1)))
    val Bushing: Fielder = parse_attribute(attribute(cls, fields(2)))
    val TransformerObservation: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): BushingInsulationPF =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BushingInsulationPF(
            IdentifiedObject.parse(context),
            mask(status(), 0),
            mask(testKind(), 1),
            mask(Bushing(), 2),
            mask(TransformerObservation(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BushingInsulationPF] = BushingInsulationPFSerializer
}

object BushingInsulationPFSerializer extends CIMSerializer[BushingInsulationPF]
{
    def write (kryo: Kryo, output: Output, obj: BushingInsulationPF): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.testKind),
            () => output.writeString(obj.Bushing),
            () => output.writeString(obj.TransformerObservation)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BushingInsulationPF]): BushingInsulationPF =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BushingInsulationPF(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * There are often stages of power which are associated with stages of cooling.
 *
 * For instance, a transformer may be rated 121kV on the primary, 15kV on the secondary and 4kV on the tertiary winding. These are voltage ratings and the power ratings are generally the same for all three windings and independent of the voltage ratings, there are instances where the tertiary may have a lower power rating.
 * For example, for three stages, the power rating may be 15/20/25 MVA and the cooling is OA/FA/FOA. The 15 MVA rating goes with the OA cooling (Oil and Air cooling). This is called the self cooled rating as there are no external cooling enhancements. The 20 MVA rating goes with the FA cooling (Forced Air cooling), this means that when the fans are running and thus enhancing the cooling characteristics, the transformer can operate at a power level of 20 MVA. The 25 MVA rating goes with the FOA cooling (Forced Oil and Air cooling), this means that when the fans and pumps are running and thus enhancing the cooling characteristics even more than before, the transformer can operate at a power level of 25 MVA. This 15/20/25 MVA does not state how the power is split between the various windings. It may be 25 MVA input on the primary, 25 MVA output on the secondary and 0 MVA output on the tertiary. It may also operate at 25 MVA input on the primary, 17 MVA output on the secondary and 8 MVA output on the tertiary.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param coolingKind      Kind of cooling system.
 * @param powerRating      The power rating associated with type of cooling specified for this stage.
 * @param stage            Stage of cooling and associated power rating.
 * @param Reconditionings  [[ch.ninecode.model.Reconditioning Reconditioning]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class CoolingPowerRating
(
    IdentifiedObject: IdentifiedObject = null,
    coolingKind: String = null,
    powerRating: Double = 0.0,
    stage: Int = 0,
    Reconditionings: List[String] = null
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
        implicit val clz: String = CoolingPowerRating.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(CoolingPowerRating.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(CoolingPowerRating.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(CoolingPowerRating.fields(position), x))

        emitattr(0, coolingKind)
        emitelem(1, powerRating)
        emitelem(2, stage)
        emitattrs(3, Reconditionings)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CoolingPowerRating rdf:%s=\"%s\">\n%s\t</cim:CoolingPowerRating>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CoolingPowerRating
    extends
        CIMParseable[CoolingPowerRating]
{
    override val fields: Array[String] = Array[String](
        "coolingKind",
        "powerRating",
        "stage",
        "Reconditionings"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Reconditionings", "Reconditioning", "0..*", "0..*")
    )
    val coolingKind: Fielder = parse_attribute(attribute(cls, fields(0)))
    val powerRating: Fielder = parse_element(element(cls, fields(1)))
    val stage: Fielder = parse_element(element(cls, fields(2)))
    val Reconditionings: FielderMultiple = parse_attributes(attribute(cls, fields(3)))

    def parse (context: CIMContext): CoolingPowerRating =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CoolingPowerRating(
            IdentifiedObject.parse(context),
            mask(coolingKind(), 0),
            toDouble(mask(powerRating(), 1)),
            toInteger(mask(stage(), 2)),
            masks(Reconditionings(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CoolingPowerRating] = CoolingPowerRatingSerializer
}

object CoolingPowerRatingSerializer extends CIMSerializer[CoolingPowerRating]
{
    def write (kryo: Kryo, output: Output, obj: CoolingPowerRating): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.coolingKind),
            () => output.writeDouble(obj.powerRating),
            () => output.writeInt(obj.stage),
            () => writeList(obj.Reconditionings, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CoolingPowerRating]): CoolingPowerRating =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CoolingPowerRating(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readInt else 0,
            if (isSet(3)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * As applicable, the basic linear, area, or volume dimensions of an asset, asset type (AssetModel) or other type of object (such as land area).
 *
 * Units and multipliers are specified per dimension.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param orientation      A description of the orientation of the object relative to the dimensions.
 *                         As an example, a vault may have north-south orientation for the sizeLength measurement and sizeDepth may be the height of the vault.
 * @param sizeDepth        Depth measurement.
 * @param sizeDiameter     Diameter measurement.
 * @param sizeLength       Length measurement.
 * @param sizeWidth        Width measurement.
 * @param Specifications   [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class DimensionsInfo
(
    IdentifiedObject: IdentifiedObject = null,
    orientation: String = null,
    sizeDepth: Double = 0.0,
    sizeDiameter: Double = 0.0,
    sizeLength: Double = 0.0,
    sizeWidth: Double = 0.0,
    Specifications: List[String] = null
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
        implicit val clz: String = DimensionsInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DimensionsInfo.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DimensionsInfo.fields(position), x))

        emitelem(0, orientation)
        emitelem(1, sizeDepth)
        emitelem(2, sizeDiameter)
        emitelem(3, sizeLength)
        emitelem(4, sizeWidth)
        emitattrs(5, Specifications)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DimensionsInfo rdf:%s=\"%s\">\n%s\t</cim:DimensionsInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DimensionsInfo
    extends
        CIMParseable[DimensionsInfo]
{
    override val fields: Array[String] = Array[String](
        "orientation",
        "sizeDepth",
        "sizeDiameter",
        "sizeLength",
        "sizeWidth",
        "Specifications"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Specifications", "Specification", "0..*", "0..*")
    )
    val orientation: Fielder = parse_element(element(cls, fields(0)))
    val sizeDepth: Fielder = parse_element(element(cls, fields(1)))
    val sizeDiameter: Fielder = parse_element(element(cls, fields(2)))
    val sizeLength: Fielder = parse_element(element(cls, fields(3)))
    val sizeWidth: Fielder = parse_element(element(cls, fields(4)))
    val Specifications: FielderMultiple = parse_attributes(attribute(cls, fields(5)))

    def parse (context: CIMContext): DimensionsInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DimensionsInfo(
            IdentifiedObject.parse(context),
            mask(orientation(), 0),
            toDouble(mask(sizeDepth(), 1)),
            toDouble(mask(sizeDiameter(), 2)),
            toDouble(mask(sizeLength(), 3)),
            toDouble(mask(sizeWidth(), 4)),
            masks(Specifications(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DimensionsInfo] = DimensionsInfoSerializer
}

object DimensionsInfoSerializer extends CIMSerializer[DimensionsInfo]
{
    def write (kryo: Kryo, output: Output, obj: DimensionsInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.orientation),
            () => output.writeDouble(obj.sizeDepth),
            () => output.writeDouble(obj.sizeDiameter),
            () => output.writeDouble(obj.sizeLength),
            () => output.writeDouble(obj.sizeWidth),
            () => writeList(obj.Specifications, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DimensionsInfo]): DimensionsInfo =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DimensionsInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Pole asset.
 *
 * @param Structure        [[ch.ninecode.model.Structure Structure]] Reference to the superclass object.
 * @param baseKind         Kind of base for this pole.
 * @param breastBlock      True if a block of material has been attached to base of pole in ground for stability.
 *                         This technique is used primarily when anchors can not be used.
 * @param classification   Pole class: 1, 2, 3, 4, 5, 6, 7, H1, H2, Other, Unknown.
 * @param construction     The framing structure mounted on the pole.
 * @param diameter         Diameter of the pole.
 * @param jpaReference     Joint pole agreement reference number.
 * @param len              Length of the pole (inclusive of any section of the pole that may be underground post-installation).
 * @param preservativeKind Kind of preservative for this pole.
 * @param speciesType      Pole species.
 *                         Aluminum, Aluminum Davit, Concrete, Fiberglass, Galvanized Davit, Galvanized, Steel Davit Primed, Steel Davit, Steel Standard Primed, Steel, Truncated, Wood-Treated, Wood-Hard, Wood-Salt Treated, Wood-Soft, Wood, Other, Unknown.
 * @param treatedDateTime  Date and time pole was last treated with preservative.
 * @param treatmentKind    Kind of treatment for this pole.
 * @param Streetlights     [[ch.ninecode.model.Streetlight Streetlight]] All streetlights attached to this pole.
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class Pole
(
    Structure: Structure = null,
    baseKind: String = null,
    breastBlock: Boolean = false,
    classification: String = null,
    construction: String = null,
    diameter: Double = 0.0,
    jpaReference: String = null,
    len: Double = 0.0,
    preservativeKind: String = null,
    speciesType: String = null,
    treatedDateTime: String = null,
    treatmentKind: String = null,
    Streetlights: List[String] = null
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
    override def sup: Structure = Structure

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
        implicit val clz: String = Pole.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(Pole.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Pole.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(Pole.fields(position), x))

        emitattr(0, baseKind)
        emitelem(1, breastBlock)
        emitelem(2, classification)
        emitelem(3, construction)
        emitelem(4, diameter)
        emitelem(5, jpaReference)
        emitelem(6, len)
        emitattr(7, preservativeKind)
        emitelem(8, speciesType)
        emitelem(9, treatedDateTime)
        emitattr(10, treatmentKind)
        emitattrs(11, Streetlights)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pole rdf:%s=\"%s\">\n%s\t</cim:Pole>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Pole
    extends
        CIMParseable[Pole]
{
    override val fields: Array[String] = Array[String](
        "baseKind",
        "breastBlock",
        "classification",
        "construction",
        "diameter",
        "jpaReference",
        "length",
        "preservativeKind",
        "speciesType",
        "treatedDateTime",
        "treatmentKind",
        "Streetlights"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Streetlights", "Streetlight", "0..*", "0..1")
    )
    val baseKind: Fielder = parse_attribute(attribute(cls, fields(0)))
    val breastBlock: Fielder = parse_element(element(cls, fields(1)))
    val classification: Fielder = parse_element(element(cls, fields(2)))
    val construction: Fielder = parse_element(element(cls, fields(3)))
    val diameter: Fielder = parse_element(element(cls, fields(4)))
    val jpaReference: Fielder = parse_element(element(cls, fields(5)))
    val len: Fielder = parse_element(element(cls, fields(6)))
    val preservativeKind: Fielder = parse_attribute(attribute(cls, fields(7)))
    val speciesType: Fielder = parse_element(element(cls, fields(8)))
    val treatedDateTime: Fielder = parse_element(element(cls, fields(9)))
    val treatmentKind: Fielder = parse_attribute(attribute(cls, fields(10)))
    val Streetlights: FielderMultiple = parse_attributes(attribute(cls, fields(11)))

    def parse (context: CIMContext): Pole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Pole(
            Structure.parse(context),
            mask(baseKind(), 0),
            toBoolean(mask(breastBlock(), 1)),
            mask(classification(), 2),
            mask(construction(), 3),
            toDouble(mask(diameter(), 4)),
            mask(jpaReference(), 5),
            toDouble(mask(len(), 6)),
            mask(preservativeKind(), 7),
            mask(speciesType(), 8),
            mask(treatedDateTime(), 9),
            mask(treatmentKind(), 10),
            masks(Streetlights(), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Pole] = PoleSerializer
}

object PoleSerializer extends CIMSerializer[Pole]
{
    def write (kryo: Kryo, output: Output, obj: Pole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.baseKind),
            () => output.writeBoolean(obj.breastBlock),
            () => output.writeString(obj.classification),
            () => output.writeString(obj.construction),
            () => output.writeDouble(obj.diameter),
            () => output.writeString(obj.jpaReference),
            () => output.writeDouble(obj.len),
            () => output.writeString(obj.preservativeKind),
            () => output.writeString(obj.speciesType),
            () => output.writeString(obj.treatedDateTime),
            () => output.writeString(obj.treatmentKind),
            () => writeList(obj.Streetlights, output)
        )
        StructureSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pole]): Pole =
    {
        val parent = StructureSerializer.read(kryo, input, classOf[Structure])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Pole(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readBoolean else false,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) input.readString else null,
            if (isSet(11)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Reconditioning information for an asset.
 *
 * @param IdentifiedObject        [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dateTime                Date and time this reconditioning (or a major overhaul) has been performed.
 * @param Asset                   [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param PowerRatings            [[ch.ninecode.model.CoolingPowerRating CoolingPowerRating]] <em>undocumented</em>
 * @param TransformerObservations [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class Reconditioning
(
    IdentifiedObject: IdentifiedObject = null,
    dateTime: String = null,
    Asset: String = null,
    PowerRatings: List[String] = null,
    TransformerObservations: List[String] = null
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
        implicit val clz: String = Reconditioning.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(Reconditioning.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Reconditioning.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(Reconditioning.fields(position), x))

        emitelem(0, dateTime)
        emitattr(1, Asset)
        emitattrs(2, PowerRatings)
        emitattrs(3, TransformerObservations)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Reconditioning rdf:%s=\"%s\">\n%s\t</cim:Reconditioning>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Reconditioning
    extends
        CIMParseable[Reconditioning]
{
    override val fields: Array[String] = Array[String](
        "dateTime",
        "Asset",
        "PowerRatings",
        "TransformerObservations"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Asset", "Asset", "0..1", "0..*"),
        CIMRelationship("PowerRatings", "CoolingPowerRating", "0..*", "0..*"),
        CIMRelationship("TransformerObservations", "TransformerObservation", "0..*", "1")
    )
    val dateTime: Fielder = parse_element(element(cls, fields(0)))
    val Asset: Fielder = parse_attribute(attribute(cls, fields(1)))
    val PowerRatings: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val TransformerObservations: FielderMultiple = parse_attributes(attribute(cls, fields(3)))

    def parse (context: CIMContext): Reconditioning =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Reconditioning(
            IdentifiedObject.parse(context),
            mask(dateTime(), 0),
            mask(Asset(), 1),
            masks(PowerRatings(), 2),
            masks(TransformerObservations(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Reconditioning] = ReconditioningSerializer
}

object ReconditioningSerializer extends CIMSerializer[Reconditioning]
{
    def write (kryo: Kryo, output: Output, obj: Reconditioning): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.dateTime),
            () => output.writeString(obj.Asset),
            () => writeList(obj.PowerRatings, output),
            () => writeList(obj.TransformerObservations, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Reconditioning]): Reconditioning =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Reconditioning(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Information regarding the experienced and expected reliability of a specific asset, type of asset, or asset model.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param mTTR             Mean time to repair (MTTR - hours).
 * @param momFailureRate   Momentary failure rate (temporary failures/kft-year).
 * @param Assets           [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param Specification    [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class ReliabilityInfo
(
    IdentifiedObject: IdentifiedObject = null,
    mTTR: Double = 0.0,
    momFailureRate: Double = 0.0,
    Assets: List[String] = null,
    Specification: String = null
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
        implicit val clz: String = ReliabilityInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ReliabilityInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ReliabilityInfo.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ReliabilityInfo.fields(position), x))

        emitelem(0, mTTR)
        emitelem(1, momFailureRate)
        emitattrs(2, Assets)
        emitattr(3, Specification)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ReliabilityInfo rdf:%s=\"%s\">\n%s\t</cim:ReliabilityInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ReliabilityInfo
    extends
        CIMParseable[ReliabilityInfo]
{
    override val fields: Array[String] = Array[String](
        "mTTR",
        "momFailureRate",
        "Assets",
        "Specification"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship("Specification", "Specification", "0..1", "0..*")
    )
    val mTTR: Fielder = parse_element(element(cls, fields(0)))
    val momFailureRate: Fielder = parse_element(element(cls, fields(1)))
    val Assets: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val Specification: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): ReliabilityInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReliabilityInfo(
            IdentifiedObject.parse(context),
            toDouble(mask(mTTR(), 0)),
            toDouble(mask(momFailureRate(), 1)),
            masks(Assets(), 2),
            mask(Specification(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ReliabilityInfo] = ReliabilityInfoSerializer
}

object ReliabilityInfoSerializer extends CIMSerializer[ReliabilityInfo]
{
    def write (kryo: Kryo, output: Output, obj: ReliabilityInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.mTTR),
            () => output.writeDouble(obj.momFailureRate),
            () => writeList(obj.Assets, output),
            () => output.writeString(obj.Specification)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ReliabilityInfo]): ReliabilityInfo =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ReliabilityInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Specification can be used for various purposes relative to an asset, a logical device (PowerSystemResource), location, etc.
 *
 * Examples include documents supplied by manufacturers such as asset installation instructions, asset maintenance instructions, etc.
 *
 * @param Document                  [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param AssetProperites           [[ch.ninecode.model.UserAttribute UserAttribute]] UserAttributes used to specify further properties of the asset covered with this specification.
 *                                  Use 'name' to specify what kind of property it is, and 'value.value' attribute for the actual value.
 * @param AssetPropertyCurves       [[ch.ninecode.model.AssetPropertyCurve AssetPropertyCurve]] <em>undocumented</em>
 * @param DimensionsInfos           [[ch.ninecode.model.DimensionsInfo DimensionsInfo]] <em>undocumented</em>
 * @param Mediums                   [[ch.ninecode.model.Medium Medium]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @param Ratings                   [[ch.ninecode.model.UserAttribute UserAttribute]] UserAttributes used to specify ratings of the asset covered by this specification.
 *                                  Ratings also can be used to set the initial value of operational measurement limits. Use 'name' to specify what kind of rating it is (e.g., voltage, current), and 'value' attribute for the actual value and unit information of the rating.
 * @param ReliabilityInfos          [[ch.ninecode.model.ReliabilityInfo ReliabilityInfo]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class Specification
(
    Document: Document = null,
    AssetProperites: List[String] = null,
    AssetPropertyCurves: List[String] = null,
    DimensionsInfos: List[String] = null,
    Mediums: List[String] = null,
    QualificationRequirements: List[String] = null,
    Ratings: List[String] = null,
    ReliabilityInfos: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = Specification.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(Specification.fields(position), x))

        emitattrs(0, AssetProperites)
        emitattrs(1, AssetPropertyCurves)
        emitattrs(2, DimensionsInfos)
        emitattrs(3, Mediums)
        emitattrs(4, QualificationRequirements)
        emitattrs(5, Ratings)
        emitattrs(6, ReliabilityInfos)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Specification rdf:%s=\"%s\">\n%s\t</cim:Specification>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Specification
    extends
        CIMParseable[Specification]
{
    override val fields: Array[String] = Array[String](
        "AssetProperites",
        "AssetPropertyCurves",
        "DimensionsInfos",
        "Mediums",
        "QualificationRequirements",
        "Ratings",
        "ReliabilityInfos"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AssetProperites", "UserAttribute", "0..*", "0..1"),
        CIMRelationship("AssetPropertyCurves", "AssetPropertyCurve", "0..*", "0..1"),
        CIMRelationship("DimensionsInfos", "DimensionsInfo", "0..*", "0..*"),
        CIMRelationship("Mediums", "Medium", "0..*", "0..1"),
        CIMRelationship("QualificationRequirements", "QualificationRequirement", "0..*", "0..*"),
        CIMRelationship("Ratings", "UserAttribute", "0..*", "0..1"),
        CIMRelationship("ReliabilityInfos", "ReliabilityInfo", "0..*", "0..1")
    )
    val AssetProperites: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val AssetPropertyCurves: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val DimensionsInfos: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val Mediums: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val QualificationRequirements: FielderMultiple = parse_attributes(attribute(cls, fields(4)))
    val Ratings: FielderMultiple = parse_attributes(attribute(cls, fields(5)))
    val ReliabilityInfos: FielderMultiple = parse_attributes(attribute(cls, fields(6)))

    def parse (context: CIMContext): Specification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Specification(
            Document.parse(context),
            masks(AssetProperites(), 0),
            masks(AssetPropertyCurves(), 1),
            masks(DimensionsInfos(), 2),
            masks(Mediums(), 3),
            masks(QualificationRequirements(), 4),
            masks(Ratings(), 5),
            masks(ReliabilityInfos(), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Specification] = SpecificationSerializer
}

object SpecificationSerializer extends CIMSerializer[Specification]
{
    def write (kryo: Kryo, output: Output, obj: Specification): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.AssetProperites, output),
            () => writeList(obj.AssetPropertyCurves, output),
            () => writeList(obj.DimensionsInfos, output),
            () => writeList(obj.Mediums, output),
            () => writeList(obj.QualificationRequirements, output),
            () => writeList(obj.Ratings, output),
            () => writeList(obj.ReliabilityInfos, output)
        )
        DocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Specification]): Specification =
    {
        val parent = DocumentSerializer.read(kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Specification(
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
 * Tower asset.
 *
 * Dimensions of the Tower are specified in associated DimensionsInfo class.
 * When used for planning purposes, a transmission tower carrying two 3-phase circuits will have 2 instances of Connection, each of which will have 3 MountingPoint instances, one for each phase all with coordinates relative to a common origin on the tower. (It may also have a 3rd Connection with a single MountingPoint for the Neutral line).
 *
 * @param Structure        [[ch.ninecode.model.Structure Structure]] Reference to the superclass object.
 * @param constructionKind Construction structure on the tower.
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class Tower
(
    Structure: Structure = null,
    constructionKind: String = null
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
    override def sup: Structure = Structure

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
        implicit val clz: String = Tower.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Tower.fields(position), value)

        emitattr(0, constructionKind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Tower rdf:%s=\"%s\">\n%s\t</cim:Tower>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Tower
    extends
        CIMParseable[Tower]
{
    override val fields: Array[String] = Array[String](
        "constructionKind"
    )
    val constructionKind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): Tower =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Tower(
            Structure.parse(context),
            mask(constructionKind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Tower] = TowerSerializer
}

object TowerSerializer extends CIMSerializer[Tower]
{
    def write (kryo: Kryo, output: Output, obj: Tower): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.constructionKind)
        )
        StructureSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Tower]): Tower =
    {
        val parent = StructureSerializer.read(kryo, input, classOf[Structure])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Tower(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Common information captured during transformer inspections and/or diagnostics.
 *
 * Note that some properties may be measured through other means and therefore have measurement values in addition to the observed values recorded here.
 *
 * @param IdentifiedObject        [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param bushingTemp             Bushing temperature.
 * @param dga                     Dissolved Gas Analysis.
 *                                Typical values are: Acceptable, Overheating, Corona, Sparking, Arcing.
 * @param freqResp                Frequency Response Analysis.
 *                                Typical values are: acceptable, slight movement, significant movement, failed, near failure. A graphic of the response diagram, which is a type of document, may be associated with this analysis through the recursive document relationship of the ProcedureDataSet.
 * @param furfuralDP              Overall measure of furfural in oil and mechanical strength of paper.
 *                                DP, the degree of polymerization, is the strength of the paper. Furfural is a measure of furfural compounds, often expressed in parts per million.
 * @param hotSpotTemp             Hotspot oil temperature.
 * @param oilColor                Oil Quality Analysis-Color.
 * @param oilDielectricStrength   Oil Quality Analysis-Dielectric Strength.
 * @param oilIFT                  Oil Quality Analysis- inter facial tension (IFT) - number-Dynes/CM.
 * @param oilLevel                The level of oil in the transformer.
 * @param oilNeutralizationNumber Oil Quality Analysis-Neutralization Number - Number - Mg KOH.
 * @param pumpVibration           Pump vibration, with typical values being: nominal, high.
 * @param status                  <em>undocumented</em>
 * @param topOilTemp              Top oil temperature.
 * @param waterContent            Water Content expressed in parts per million.
 * @param BushingInsultationPFs   [[ch.ninecode.model.BushingInsulationPF BushingInsulationPF]] <em>undocumented</em>
 * @param ProcedureDataSets       [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] <em>undocumented</em>
 * @param Reconditioning          [[ch.ninecode.model.Reconditioning Reconditioning]] <em>undocumented</em>
 * @param Transformer             [[ch.ninecode.model.TransformerTank TransformerTank]] <em>undocumented</em>
 * @param WindingInsulationPFs    [[ch.ninecode.model.WindingInsulation WindingInsulation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class TransformerObservation
(
    IdentifiedObject: IdentifiedObject = null,
    bushingTemp: Double = 0.0,
    dga: String = null,
    freqResp: String = null,
    furfuralDP: String = null,
    hotSpotTemp: Double = 0.0,
    oilColor: String = null,
    oilDielectricStrength: Double = 0.0,
    oilIFT: String = null,
    oilLevel: String = null,
    oilNeutralizationNumber: String = null,
    pumpVibration: String = null,
    status: String = null,
    topOilTemp: Double = 0.0,
    waterContent: String = null,
    BushingInsultationPFs: List[String] = null,
    ProcedureDataSets: List[String] = null,
    Reconditioning: String = null,
    Transformer: String = null,
    WindingInsulationPFs: List[String] = null
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
        implicit val clz: String = TransformerObservation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TransformerObservation.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(TransformerObservation.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(TransformerObservation.fields(position), x))

        emitelem(0, bushingTemp)
        emitelem(1, dga)
        emitelem(2, freqResp)
        emitelem(3, furfuralDP)
        emitelem(4, hotSpotTemp)
        emitelem(5, oilColor)
        emitelem(6, oilDielectricStrength)
        emitelem(7, oilIFT)
        emitelem(8, oilLevel)
        emitelem(9, oilNeutralizationNumber)
        emitelem(10, pumpVibration)
        emitattr(11, status)
        emitelem(12, topOilTemp)
        emitelem(13, waterContent)
        emitattrs(14, BushingInsultationPFs)
        emitattrs(15, ProcedureDataSets)
        emitattr(16, Reconditioning)
        emitattr(17, Transformer)
        emitattrs(18, WindingInsulationPFs)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TransformerObservation rdf:%s=\"%s\">\n%s\t</cim:TransformerObservation>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TransformerObservation
    extends
        CIMParseable[TransformerObservation]
{
    override val fields: Array[String] = Array[String](
        "bushingTemp",
        "dga",
        "freqResp",
        "furfuralDP",
        "hotSpotTemp",
        "oilColor",
        "oilDielectricStrength",
        "oilIFT",
        "oilLevel",
        "oilNeutralizationNumber",
        "pumpVibration",
        "status",
        "topOilTemp",
        "waterContent",
        "BushingInsultationPFs",
        "ProcedureDataSets",
        "Reconditioning",
        "Transformer",
        "WindingInsulationPFs"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("BushingInsultationPFs", "BushingInsulationPF", "0..*", "0..1"),
        CIMRelationship("ProcedureDataSets", "ProcedureDataSet", "0..*", "0..*"),
        CIMRelationship("Reconditioning", "Reconditioning", "1", "0..*"),
        CIMRelationship("Transformer", "TransformerTank", "0..1", "0..*"),
        CIMRelationship("WindingInsulationPFs", "WindingInsulation", "0..*", "0..1")
    )
    val bushingTemp: Fielder = parse_element(element(cls, fields(0)))
    val dga: Fielder = parse_element(element(cls, fields(1)))
    val freqResp: Fielder = parse_element(element(cls, fields(2)))
    val furfuralDP: Fielder = parse_element(element(cls, fields(3)))
    val hotSpotTemp: Fielder = parse_element(element(cls, fields(4)))
    val oilColor: Fielder = parse_element(element(cls, fields(5)))
    val oilDielectricStrength: Fielder = parse_element(element(cls, fields(6)))
    val oilIFT: Fielder = parse_element(element(cls, fields(7)))
    val oilLevel: Fielder = parse_element(element(cls, fields(8)))
    val oilNeutralizationNumber: Fielder = parse_element(element(cls, fields(9)))
    val pumpVibration: Fielder = parse_element(element(cls, fields(10)))
    val status: Fielder = parse_attribute(attribute(cls, fields(11)))
    val topOilTemp: Fielder = parse_element(element(cls, fields(12)))
    val waterContent: Fielder = parse_element(element(cls, fields(13)))
    val BushingInsultationPFs: FielderMultiple = parse_attributes(attribute(cls, fields(14)))
    val ProcedureDataSets: FielderMultiple = parse_attributes(attribute(cls, fields(15)))
    val Reconditioning: Fielder = parse_attribute(attribute(cls, fields(16)))
    val Transformer: Fielder = parse_attribute(attribute(cls, fields(17)))
    val WindingInsulationPFs: FielderMultiple = parse_attributes(attribute(cls, fields(18)))

    def parse (context: CIMContext): TransformerObservation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerObservation(
            IdentifiedObject.parse(context),
            toDouble(mask(bushingTemp(), 0)),
            mask(dga(), 1),
            mask(freqResp(), 2),
            mask(furfuralDP(), 3),
            toDouble(mask(hotSpotTemp(), 4)),
            mask(oilColor(), 5),
            toDouble(mask(oilDielectricStrength(), 6)),
            mask(oilIFT(), 7),
            mask(oilLevel(), 8),
            mask(oilNeutralizationNumber(), 9),
            mask(pumpVibration(), 10),
            mask(status(), 11),
            toDouble(mask(topOilTemp(), 12)),
            mask(waterContent(), 13),
            masks(BushingInsultationPFs(), 14),
            masks(ProcedureDataSets(), 15),
            mask(Reconditioning(), 16),
            mask(Transformer(), 17),
            masks(WindingInsulationPFs(), 18)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TransformerObservation] = TransformerObservationSerializer
}

object TransformerObservationSerializer extends CIMSerializer[TransformerObservation]
{
    def write (kryo: Kryo, output: Output, obj: TransformerObservation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.bushingTemp),
            () => output.writeString(obj.dga),
            () => output.writeString(obj.freqResp),
            () => output.writeString(obj.furfuralDP),
            () => output.writeDouble(obj.hotSpotTemp),
            () => output.writeString(obj.oilColor),
            () => output.writeDouble(obj.oilDielectricStrength),
            () => output.writeString(obj.oilIFT),
            () => output.writeString(obj.oilLevel),
            () => output.writeString(obj.oilNeutralizationNumber),
            () => output.writeString(obj.pumpVibration),
            () => output.writeString(obj.status),
            () => output.writeDouble(obj.topOilTemp),
            () => output.writeString(obj.waterContent),
            () => writeList(obj.BushingInsultationPFs, output),
            () => writeList(obj.ProcedureDataSets, output),
            () => output.writeString(obj.Reconditioning),
            () => output.writeString(obj.Transformer),
            () => writeList(obj.WindingInsulationPFs, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerObservation]): TransformerObservation =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TransformerObservation(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) input.readString else null,
            if (isSet(11)) input.readString else null,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readString else null,
            if (isSet(14)) readList(input) else null,
            if (isSet(15)) readList(input) else null,
            if (isSet(16)) input.readString else null,
            if (isSet(17)) input.readString else null,
            if (isSet(18)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Underground structure.
 *
 * @param Structure                  [[ch.ninecode.model.Structure Structure]] Reference to the superclass object.
 * @param hasVentilation             True if vault is ventilating.
 * @param kind                       True if vault is ventilating.
 * @param material                   Primary material of underground structure.
 * @param sealingWarrantyExpiresDate Date sealing warranty expires.
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class UndergroundStructure
(
    Structure: Structure = null,
    hasVentilation: Boolean = false,
    kind: String = null,
    material: String = null,
    sealingWarrantyExpiresDate: String = null
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
    override def sup: Structure = Structure

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
        implicit val clz: String = UndergroundStructure.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(UndergroundStructure.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(UndergroundStructure.fields(position), value)

        emitelem(0, hasVentilation)
        emitattr(1, kind)
        emitelem(2, material)
        emitelem(3, sealingWarrantyExpiresDate)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:UndergroundStructure rdf:%s=\"%s\">\n%s\t</cim:UndergroundStructure>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object UndergroundStructure
    extends
        CIMParseable[UndergroundStructure]
{
    override val fields: Array[String] = Array[String](
        "hasVentilation",
        "kind",
        "material",
        "sealingWarrantyExpiresDate"
    )
    val hasVentilation: Fielder = parse_element(element(cls, fields(0)))
    val kind: Fielder = parse_attribute(attribute(cls, fields(1)))
    val material: Fielder = parse_element(element(cls, fields(2)))
    val sealingWarrantyExpiresDate: Fielder = parse_element(element(cls, fields(3)))

    def parse (context: CIMContext): UndergroundStructure =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UndergroundStructure(
            Structure.parse(context),
            toBoolean(mask(hasVentilation(), 0)),
            mask(kind(), 1),
            mask(material(), 2),
            mask(sealingWarrantyExpiresDate(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[UndergroundStructure] = UndergroundStructureSerializer
}

object UndergroundStructureSerializer extends CIMSerializer[UndergroundStructure]
{
    def write (kryo: Kryo, output: Output, obj: UndergroundStructure): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.hasVentilation),
            () => output.writeString(obj.kind),
            () => output.writeString(obj.material),
            () => output.writeString(obj.sealingWarrantyExpiresDate)
        )
        StructureSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UndergroundStructure]): UndergroundStructure =
    {
        val parent = StructureSerializer.read(kryo, input, classOf[Structure])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = UndergroundStructure(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Winding insulation condition as a result of a test.
 *
 * @param IdentifiedObject       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param insulationPFStatus     Status of Winding Insulation Power Factor as of statusDate: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 * @param insulationResistance   For testType, status of Winding Insulation Resistance as of statusDate.
 *                               Typical values are: Acceptable, Questionable, Failed.
 * @param leakageReactance       As of statusDate, the leakage reactance measured at the "from" winding with the "to" winding short-circuited and all other windings open-circuited.
 * @param status                 <em>undocumented</em>
 * @param FromWinding            [[ch.ninecode.model.TransformerEnd TransformerEnd]] <em>undocumented</em>
 * @param ToWinding              [[ch.ninecode.model.TransformerEnd TransformerEnd]] <em>undocumented</em>
 * @param TransformerObservation [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 *            The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 *            <ul>
 *            <li>Assets can have names, through inheritance to the Naming package</li>
 *            <li>Assets are physical entities which have a lifecycle</li>
 *            <li>One or more assets can be associated to create a PowerSystemResource</li>
 *            <li>Assets can be grouped (aggregated) with other Assets</li>
 *            <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 *            <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 *            </ul>
 *            The following sections describe the packages in the Assets package.
 *            The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 *            Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 *            Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 *            Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
final case class WindingInsulation
(
    IdentifiedObject: IdentifiedObject = null,
    insulationPFStatus: String = null,
    insulationResistance: String = null,
    leakageReactance: Double = 0.0,
    status: String = null,
    FromWinding: String = null,
    ToWinding: String = null,
    TransformerObservation: String = null
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
        implicit val clz: String = WindingInsulation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(WindingInsulation.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(WindingInsulation.fields(position), value)

        emitelem(0, insulationPFStatus)
        emitelem(1, insulationResistance)
        emitelem(2, leakageReactance)
        emitattr(3, status)
        emitattr(4, FromWinding)
        emitattr(5, ToWinding)
        emitattr(6, TransformerObservation)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WindingInsulation rdf:%s=\"%s\">\n%s\t</cim:WindingInsulation>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object WindingInsulation
    extends
        CIMParseable[WindingInsulation]
{
    override val fields: Array[String] = Array[String](
        "insulationPFStatus",
        "insulationResistance",
        "leakageReactance",
        "status",
        "FromWinding",
        "ToWinding",
        "TransformerObservation"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("FromWinding", "TransformerEnd", "1", "0..*"),
        CIMRelationship("ToWinding", "TransformerEnd", "1", "0..*"),
        CIMRelationship("TransformerObservation", "TransformerObservation", "0..1", "0..*")
    )
    val insulationPFStatus: Fielder = parse_element(element(cls, fields(0)))
    val insulationResistance: Fielder = parse_element(element(cls, fields(1)))
    val leakageReactance: Fielder = parse_element(element(cls, fields(2)))
    val status: Fielder = parse_attribute(attribute(cls, fields(3)))
    val FromWinding: Fielder = parse_attribute(attribute(cls, fields(4)))
    val ToWinding: Fielder = parse_attribute(attribute(cls, fields(5)))
    val TransformerObservation: Fielder = parse_attribute(attribute(cls, fields(6)))

    def parse (context: CIMContext): WindingInsulation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindingInsulation(
            IdentifiedObject.parse(context),
            mask(insulationPFStatus(), 0),
            mask(insulationResistance(), 1),
            toDouble(mask(leakageReactance(), 2)),
            mask(status(), 3),
            mask(FromWinding(), 4),
            mask(ToWinding(), 5),
            mask(TransformerObservation(), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WindingInsulation] = WindingInsulationSerializer
}

object WindingInsulationSerializer extends CIMSerializer[WindingInsulation]
{
    def write (kryo: Kryo, output: Output, obj: WindingInsulation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.insulationPFStatus),
            () => output.writeString(obj.insulationResistance),
            () => output.writeDouble(obj.leakageReactance),
            () => output.writeString(obj.status),
            () => output.writeString(obj.FromWinding),
            () => output.writeString(obj.ToWinding),
            () => output.writeString(obj.TransformerObservation)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WindingInsulation]): WindingInsulation =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = WindingInsulation(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfAssets
{
    def register: List[CIMClassInfo] =
    {
        List(
            AssetPropertyCurve.register,
            BushingInsulationPF.register,
            CoolingPowerRating.register,
            DimensionsInfo.register,
            Pole.register,
            Reconditioning.register,
            ReliabilityInfo.register,
            Specification.register,
            Tower.register,
            TransformerObservation.register,
            UndergroundStructure.register,
            WindingInsulation.register
        )
    }
}