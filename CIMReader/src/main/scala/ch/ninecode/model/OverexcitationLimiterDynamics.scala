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
 * Different from LimIEEEOEL, LimOEL2 has a fixed pickup threshold and reduces the excitation set-point by means of a non-windup integral regulator.
 *
 * <i>Irated</i> is the rated machine excitation current (calculated from nameplate conditions: <i>V</i><i><sub>nom</sub></i>, <i>P</i><i><sub>nom</sub></i>, <i>CosPhi</i><i><sub>nom</sub></i>).
 *
 * @param OverexcitationLimiterDynamics [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param ifdlim                        Limit value of rated field current (<i>I</i><i><sub>FDLIM</sub></i>).
 *                                      Typical value = 1,05.
 * @param koi                           Gain Over excitation limiter (<i>K</i><i><sub>OI</sub></i>).
 *                                      Typical value = 0,1.
 * @param voimax                        Maximum error signal (<i>V</i><i><sub>OIMAX</sub></i>) (&gt; OverexcLim2.voimin).
 *                                      Typical value = 0.
 * @param voimin                        Minimum error signal (<i>V</i><i><sub>OIMIN</sub></i>) (&lt; OverexcLim2.voimax).
 *                                      Typical value = -9999.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
final case class OverexcLim2
(
    OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = null,
    ifdlim: Double = 0.0,
    koi: Double = 0.0,
    voimax: Double = 0.0,
    voimin: Double = 0.0
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
    override def sup: OverexcitationLimiterDynamics = OverexcitationLimiterDynamics

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
        implicit val clz: String = OverexcLim2.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OverexcLim2.fields(position), value)

        emitelem(0, ifdlim)
        emitelem(1, koi)
        emitelem(2, voimax)
        emitelem(3, voimin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OverexcLim2 rdf:%s=\"%s\">\n%s\t</cim:OverexcLim2>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OverexcLim2
    extends
        CIMParseable[OverexcLim2]
{
    override val fields: Array[String] = Array[String](
        "ifdlim",
        "koi",
        "voimax",
        "voimin"
    )
    val ifdlim: Fielder = parse_element(element(cls, fields(0)))
    val koi: Fielder = parse_element(element(cls, fields(1)))
    val voimax: Fielder = parse_element(element(cls, fields(2)))
    val voimin: Fielder = parse_element(element(cls, fields(3)))

    def parse (context: CIMContext): OverexcLim2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OverexcLim2(
            OverexcitationLimiterDynamics.parse(context),
            toDouble(mask(ifdlim(), 0)),
            toDouble(mask(koi(), 1)),
            toDouble(mask(voimax(), 2)),
            toDouble(mask(voimin(), 3))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OverexcLim2] = OverexcLim2Serializer
}

object OverexcLim2Serializer extends CIMSerializer[OverexcLim2]
{
    def write (kryo: Kryo, output: Output, obj: OverexcLim2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.ifdlim),
            () => output.writeDouble(obj.koi),
            () => output.writeDouble(obj.voimax),
            () => output.writeDouble(obj.voimin)
        )
        OverexcitationLimiterDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OverexcLim2]): OverexcLim2 =
    {
        val parent = OverexcitationLimiterDynamicsSerializer.read(kryo, input, classOf[OverexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OverexcLim2(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The over excitation limiter model is intended to represent the significant features of OELs necessary for some large-scale system studies.
 *
 * It is the result of a pragmatic approach to obtain a model that can be widely applied with attainable data from generator owners. An attempt to include all variations in the functionality of OELs and duplicate how they interact with the rest of the excitation systems would likely result in a level of application insufficient for the studies for which they are intended.
 * Reference: IEEE OEL 421.5-2005, 9.
 *
 * @param OverexcitationLimiterDynamics [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param hyst                          OEL pickup/drop-out hysteresis (<i>HYST</i>).
 *                                      Typical value = 0,03.
 * @param ifdlim                        OEL timed field current limit (<i>I</i><i><sub>FDLIM</sub></i>).
 *                                      Typical value = 1,05.
 * @param ifdmax                        OEL instantaneous field current limit (<i>I</i><i><sub>FDMAX</sub></i>).
 *                                      Typical value = 1,5.
 * @param itfpu                         OEL timed field current limiter pickup level (<i>I</i><i><sub>TFPU</sub></i>).
 *                                      Typical value = 1,05.
 * @param kcd                           OEL cooldown gain (<i>K</i><i><sub>CD</sub></i>).
 *                                      Typical value = 1.
 * @param kramp                         OEL ramped limit rate (<i>K</i><i><sub>RAMP</sub></i>).
 *                                      Unit = PU / s.  Typical value = 10.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
final case class OverexcLimIEEE
(
    OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = null,
    hyst: Double = 0.0,
    ifdlim: Double = 0.0,
    ifdmax: Double = 0.0,
    itfpu: Double = 0.0,
    kcd: Double = 0.0,
    kramp: Double = 0.0
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
    override def sup: OverexcitationLimiterDynamics = OverexcitationLimiterDynamics

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
        implicit val clz: String = OverexcLimIEEE.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OverexcLimIEEE.fields(position), value)

        emitelem(0, hyst)
        emitelem(1, ifdlim)
        emitelem(2, ifdmax)
        emitelem(3, itfpu)
        emitelem(4, kcd)
        emitelem(5, kramp)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OverexcLimIEEE rdf:%s=\"%s\">\n%s\t</cim:OverexcLimIEEE>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OverexcLimIEEE
    extends
        CIMParseable[OverexcLimIEEE]
{
    override val fields: Array[String] = Array[String](
        "hyst",
        "ifdlim",
        "ifdmax",
        "itfpu",
        "kcd",
        "kramp"
    )
    val hyst: Fielder = parse_element(element(cls, fields(0)))
    val ifdlim: Fielder = parse_element(element(cls, fields(1)))
    val ifdmax: Fielder = parse_element(element(cls, fields(2)))
    val itfpu: Fielder = parse_element(element(cls, fields(3)))
    val kcd: Fielder = parse_element(element(cls, fields(4)))
    val kramp: Fielder = parse_element(element(cls, fields(5)))

    def parse (context: CIMContext): OverexcLimIEEE =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OverexcLimIEEE(
            OverexcitationLimiterDynamics.parse(context),
            toDouble(mask(hyst(), 0)),
            toDouble(mask(ifdlim(), 1)),
            toDouble(mask(ifdmax(), 2)),
            toDouble(mask(itfpu(), 3)),
            toDouble(mask(kcd(), 4)),
            toDouble(mask(kramp(), 5))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OverexcLimIEEE] = OverexcLimIEEESerializer
}

object OverexcLimIEEESerializer extends CIMSerializer[OverexcLimIEEE]
{
    def write (kryo: Kryo, output: Output, obj: OverexcLimIEEE): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.hyst),
            () => output.writeDouble(obj.ifdlim),
            () => output.writeDouble(obj.ifdmax),
            () => output.writeDouble(obj.itfpu),
            () => output.writeDouble(obj.kcd),
            () => output.writeDouble(obj.kramp)
        )
        OverexcitationLimiterDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OverexcLimIEEE]): OverexcLimIEEE =
    {
        val parent = OverexcitationLimiterDynamicsSerializer.read(kryo, input, classOf[OverexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OverexcLimIEEE(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Field voltage over excitation limiter.
 *
 * @param OverexcitationLimiterDynamics [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param efd1                          Low voltage point on the inverse time characteristic (<i>EFD</i><i><sub>1</sub></i>).
 *                                      Typical value = 1,1.
 * @param efd2                          Mid voltage point on the inverse time characteristic (<i>EFD</i><i><sub>2</sub></i>).
 *                                      Typical value = 1,2.
 * @param efd3                          High voltage point on the inverse time characteristic (<i>EFD</i><i><sub>3</sub></i>).
 *                                      Typical value = 1,5.
 * @param efddes                        Desired field voltage (<i>EFD</i><i><sub>DES</sub></i>).
 *                                      Typical value = 0,9.
 * @param efdrated                      Rated field voltage (<i>EFD</i><i><sub>RATED</sub></i>).
 *                                      Typical value = 1,05.
 * @param kmx                           Gain (<i>K</i><i><sub>MX</sub></i>).
 *                                      Typical value = 0,01.
 * @param t1                            Time to trip the exciter at the low voltage point on the inverse time characteristic (<i>TIME</i><i><sub>1</sub></i>) (&gt;= 0).
 *                                      Typical value = 120.
 * @param t2                            Time to trip the exciter at the mid voltage point on the inverse time characteristic (<i>TIME</i><i><sub>2</sub></i>) (&gt;= 0).
 *                                      Typical value = 40.
 * @param t3                            Time to trip the exciter at the high voltage point on the inverse time characteristic (<i>TIME</i><i><sub>3</sub></i>) (&gt;= 0).
 *                                      Typical value = 15.
 * @param vlow                          Low voltage limit (<i>V</i><i><sub>LOW</sub></i>) (&gt; 0).
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
final case class OverexcLimX1
(
    OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    efd3: Double = 0.0,
    efddes: Double = 0.0,
    efdrated: Double = 0.0,
    kmx: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    vlow: Double = 0.0
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
    override def sup: OverexcitationLimiterDynamics = OverexcitationLimiterDynamics

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
        implicit val clz: String = OverexcLimX1.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OverexcLimX1.fields(position), value)

        emitelem(0, efd1)
        emitelem(1, efd2)
        emitelem(2, efd3)
        emitelem(3, efddes)
        emitelem(4, efdrated)
        emitelem(5, kmx)
        emitelem(6, t1)
        emitelem(7, t2)
        emitelem(8, t3)
        emitelem(9, vlow)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OverexcLimX1 rdf:%s=\"%s\">\n%s\t</cim:OverexcLimX1>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OverexcLimX1
    extends
        CIMParseable[OverexcLimX1]
{
    override val fields: Array[String] = Array[String](
        "efd1",
        "efd2",
        "efd3",
        "efddes",
        "efdrated",
        "kmx",
        "t1",
        "t2",
        "t3",
        "vlow"
    )
    val efd1: Fielder = parse_element(element(cls, fields(0)))
    val efd2: Fielder = parse_element(element(cls, fields(1)))
    val efd3: Fielder = parse_element(element(cls, fields(2)))
    val efddes: Fielder = parse_element(element(cls, fields(3)))
    val efdrated: Fielder = parse_element(element(cls, fields(4)))
    val kmx: Fielder = parse_element(element(cls, fields(5)))
    val t1: Fielder = parse_element(element(cls, fields(6)))
    val t2: Fielder = parse_element(element(cls, fields(7)))
    val t3: Fielder = parse_element(element(cls, fields(8)))
    val vlow: Fielder = parse_element(element(cls, fields(9)))

    def parse (context: CIMContext): OverexcLimX1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OverexcLimX1(
            OverexcitationLimiterDynamics.parse(context),
            toDouble(mask(efd1(), 0)),
            toDouble(mask(efd2(), 1)),
            toDouble(mask(efd3(), 2)),
            toDouble(mask(efddes(), 3)),
            toDouble(mask(efdrated(), 4)),
            toDouble(mask(kmx(), 5)),
            toDouble(mask(t1(), 6)),
            toDouble(mask(t2(), 7)),
            toDouble(mask(t3(), 8)),
            toDouble(mask(vlow(), 9))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OverexcLimX1] = OverexcLimX1Serializer
}

object OverexcLimX1Serializer extends CIMSerializer[OverexcLimX1]
{
    def write (kryo: Kryo, output: Output, obj: OverexcLimX1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.efd1),
            () => output.writeDouble(obj.efd2),
            () => output.writeDouble(obj.efd3),
            () => output.writeDouble(obj.efddes),
            () => output.writeDouble(obj.efdrated),
            () => output.writeDouble(obj.kmx),
            () => output.writeDouble(obj.t1),
            () => output.writeDouble(obj.t2),
            () => output.writeDouble(obj.t3),
            () => output.writeDouble(obj.vlow)
        )
        OverexcitationLimiterDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OverexcLimX1]): OverexcLimX1 =
    {
        val parent = OverexcitationLimiterDynamicsSerializer.read(kryo, input, classOf[OverexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OverexcLimX1(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Field voltage or current overexcitation limiter designed to protect the generator field of an AC machine with automatic excitation control from overheating due to prolonged overexcitation.
 *
 * @param OverexcitationLimiterDynamics [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param efd1                          Low voltage or current point on the inverse time characteristic (<i>EFD</i><i><sub>1</sub></i>).
 *                                      Typical value = 1,1.
 * @param efd2                          Mid voltage or current point on the inverse time characteristic (<i>EFD</i><i><sub>2</sub></i>).
 *                                      Typical value = 1,2.
 * @param efd3                          High voltage or current point on the inverse time characteristic (<i>EFD</i><i><sub>3</sub></i>).
 *                                      Typical value = 1,5.
 * @param efddes                        Desired field voltage if <i>m</i> = false or desired field current if <i>m </i>= true (<i>EFD</i><i><sub>DES</sub></i>).
 *                                      Typical value = 1.
 * @param efdrated                      Rated field voltage if m = false or rated field current if m = true (<i>EFD</i><i><sub>RATED</sub></i>).
 *                                      Typical value = 1,05.
 * @param kmx                           Gain (<i>K</i><i><sub>MX</sub></i>).
 *                                      Typical value = 0,002.
 * @param m                             (<i>m</i>).
 *                                      true = IFD limiting
 *                                      false = EFD limiting.
 * @param t1                            Time to trip the exciter at the low voltage or current point on the inverse time characteristic (<i>TIME</i><i><sub>1</sub></i>) (&gt;= 0).
 *                                      Typical value = 120.
 * @param t2                            Time to trip the exciter at the mid voltage or current point on the inverse time characteristic (<i>TIME</i><i><sub>2</sub></i>) (&gt;= 0).
 *                                      Typical value = 40.
 * @param t3                            Time to trip the exciter at the high voltage or current point on the inverse time characteristic (<i>TIME</i><i><sub>3</sub></i>) (&gt;= 0).
 *                                      Typical value = 15.
 * @param vlow                          Low voltage limit (<i>V</i><i><sub>LOW</sub></i>) (&gt; 0).
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
final case class OverexcLimX2
(
    OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    efd3: Double = 0.0,
    efddes: Double = 0.0,
    efdrated: Double = 0.0,
    kmx: Double = 0.0,
    m: Boolean = false,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    vlow: Double = 0.0
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
    override def sup: OverexcitationLimiterDynamics = OverexcitationLimiterDynamics

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
        implicit val clz: String = OverexcLimX2.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OverexcLimX2.fields(position), value)

        emitelem(0, efd1)
        emitelem(1, efd2)
        emitelem(2, efd3)
        emitelem(3, efddes)
        emitelem(4, efdrated)
        emitelem(5, kmx)
        emitelem(6, m)
        emitelem(7, t1)
        emitelem(8, t2)
        emitelem(9, t3)
        emitelem(10, vlow)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OverexcLimX2 rdf:%s=\"%s\">\n%s\t</cim:OverexcLimX2>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OverexcLimX2
    extends
        CIMParseable[OverexcLimX2]
{
    override val fields: Array[String] = Array[String](
        "efd1",
        "efd2",
        "efd3",
        "efddes",
        "efdrated",
        "kmx",
        "m",
        "t1",
        "t2",
        "t3",
        "vlow"
    )
    val efd1: Fielder = parse_element(element(cls, fields(0)))
    val efd2: Fielder = parse_element(element(cls, fields(1)))
    val efd3: Fielder = parse_element(element(cls, fields(2)))
    val efddes: Fielder = parse_element(element(cls, fields(3)))
    val efdrated: Fielder = parse_element(element(cls, fields(4)))
    val kmx: Fielder = parse_element(element(cls, fields(5)))
    val m: Fielder = parse_element(element(cls, fields(6)))
    val t1: Fielder = parse_element(element(cls, fields(7)))
    val t2: Fielder = parse_element(element(cls, fields(8)))
    val t3: Fielder = parse_element(element(cls, fields(9)))
    val vlow: Fielder = parse_element(element(cls, fields(10)))

    def parse (context: CIMContext): OverexcLimX2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OverexcLimX2(
            OverexcitationLimiterDynamics.parse(context),
            toDouble(mask(efd1(), 0)),
            toDouble(mask(efd2(), 1)),
            toDouble(mask(efd3(), 2)),
            toDouble(mask(efddes(), 3)),
            toDouble(mask(efdrated(), 4)),
            toDouble(mask(kmx(), 5)),
            toBoolean(mask(m(), 6)),
            toDouble(mask(t1(), 7)),
            toDouble(mask(t2(), 8)),
            toDouble(mask(t3(), 9)),
            toDouble(mask(vlow(), 10))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OverexcLimX2] = OverexcLimX2Serializer
}

object OverexcLimX2Serializer extends CIMSerializer[OverexcLimX2]
{
    def write (kryo: Kryo, output: Output, obj: OverexcLimX2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.efd1),
            () => output.writeDouble(obj.efd2),
            () => output.writeDouble(obj.efd3),
            () => output.writeDouble(obj.efddes),
            () => output.writeDouble(obj.efdrated),
            () => output.writeDouble(obj.kmx),
            () => output.writeBoolean(obj.m),
            () => output.writeDouble(obj.t1),
            () => output.writeDouble(obj.t2),
            () => output.writeDouble(obj.t3),
            () => output.writeDouble(obj.vlow)
        )
        OverexcitationLimiterDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OverexcLimX2]): OverexcLimX2 =
    {
        val parent = OverexcitationLimiterDynamicsSerializer.read(kryo, input, classOf[OverexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OverexcLimX2(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readBoolean else false,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Overexcitation limiter function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock    [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this overexcitation limiter model is associated.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
final case class OverexcitationLimiterDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    ExcitationSystemDynamics: String = null
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
    override def sup: DynamicsFunctionBlock = DynamicsFunctionBlock

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
        implicit val clz: String = OverexcitationLimiterDynamics.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OverexcitationLimiterDynamics.fields(position), value)

        emitattr(0, ExcitationSystemDynamics)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OverexcitationLimiterDynamics rdf:%s=\"%s\">\n%s\t</cim:OverexcitationLimiterDynamics>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OverexcitationLimiterDynamics
    extends
        CIMParseable[OverexcitationLimiterDynamics]
{
    override val fields: Array[String] = Array[String](
        "ExcitationSystemDynamics"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OverexcitationLimiterDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OverexcitationLimiterDynamics(
            DynamicsFunctionBlock.parse(context),
            mask(ExcitationSystemDynamics(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OverexcitationLimiterDynamics] = OverexcitationLimiterDynamicsSerializer
}

object OverexcitationLimiterDynamicsSerializer extends CIMSerializer[OverexcitationLimiterDynamics]
{
    def write (kryo: Kryo, output: Output, obj: OverexcitationLimiterDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.ExcitationSystemDynamics)
        )
        DynamicsFunctionBlockSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OverexcitationLimiterDynamics]): OverexcitationLimiterDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read(kryo, input, classOf[DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OverexcitationLimiterDynamics(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _OverexcitationLimiterDynamics
{
    def register: List[CIMClassInfo] =
    {
        List(
            OverexcLim2.register,
            OverexcLimIEEE.register,
            OverexcLimX1.register,
            OverexcLimX2.register,
            OverexcitationLimiterDynamics.register
        )
    }
}