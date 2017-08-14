package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Different from LimIEEEOEL, LimOEL2 has a fixed pickup threshold and reduces the excitation set-point by mean of non-windup integral regulator.
 * Irated is the rated machine excitation current (calculated from nameplate conditions: V<sub>nom</sub>, P<sub>nom</sub>, CosPhi<sub>nom</sub>).
 *
 * @param sup Reference to the superclass object.
 * @param ifdlim Limit value of rated field current (I<sub>FDLIM</sub>).
 *        Typical Value = 1.05.
 * @param koi Gain Over excitation limiter (K<sub>OI</sub>).
 *        Typical Value = 0.1.
 * @param voimax Maximum error signal (V<sub>OIMAX</sub>).
 *        Typical Value = 0.
 * @param voimin Minimum error signal (V<sub>OIMIN</sub>).
 *        Typical Value = -9999.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLim2
(
    override val sup: OverexcitationLimiterDynamics,
    ifdlim: Double,
    koi: Double,
    voimax: Double,
    voimin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLim2] }
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
        "\t\t<cim:OverexcLim2.ifdlim>" + ifdlim + "</cim:OverexcLim2.ifdlim>\n" +
        "\t\t<cim:OverexcLim2.koi>" + koi + "</cim:OverexcLim2.koi>\n" +
        "\t\t<cim:OverexcLim2.voimax>" + voimax + "</cim:OverexcLim2.voimax>\n" +
        "\t\t<cim:OverexcLim2.voimin>" + voimin + "</cim:OverexcLim2.voimin>\n"
    }
    override def export: String =
    {
        "\t<cim:OverexcLim2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverexcLim2>"
    }
}

object OverexcLim2
extends
    Parseable[OverexcLim2]
{
    val ifdlim = parse_element (element ("""OverexcLim2.ifdlim"""))
    val koi = parse_element (element ("""OverexcLim2.koi"""))
    val voimax = parse_element (element ("""OverexcLim2.voimax"""))
    val voimin = parse_element (element ("""OverexcLim2.voimin"""))
    def parse (context: Context): OverexcLim2 =
    {
        OverexcLim2(
            OverexcitationLimiterDynamics.parse (context),
            toDouble (ifdlim (context), context),
            toDouble (koi (context), context),
            toDouble (voimax (context), context),
            toDouble (voimin (context), context)
        )
    }
}

/**
 * The over excitation limiter model is intended to represent the significant features of OELs necessary for some large-scale system studies.
 * It is the result of a pragmatic approach to obtain a model that can be widely applied with attainable data from generator owners. An attempt to include all variations in the functionality of OELs and duplicate how they interact with the rest of the excitation systems would likely result in a level of application insufficient for the studies for which they are intended.
 *
 * @param sup Reference to the superclass object.
 * @param hyst OEL pickup/drop-out hysteresis (HYST).
 *        Typical Value = 0.03.
 * @param ifdlim OEL timed field current limit (I<sub>FDLIM</sub>).
 *        Typical Value = 1.05.
 * @param ifdmax OEL instantaneous field current limit (I<sub>FDMAX</sub>).
 *        Typical Value = 1.5.
 * @param itfpu OEL timed field current limiter pickup level (I<sub>TFPU</sub>).
 *        Typical Value = 1.05.
 * @param kcd OEL cooldown gain (K<sub>CD</sub>).
 *        Typical Value = 1.
 * @param kramp OEL ramped limit rate (K<sub>RAMP</sub>).
 *        Unit = PU/sec.  Typical Value = 10.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLimIEEE
(
    override val sup: OverexcitationLimiterDynamics,
    hyst: Double,
    ifdlim: Double,
    ifdmax: Double,
    itfpu: Double,
    kcd: Double,
    kramp: Double
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
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLimIEEE] }
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
        "\t\t<cim:OverexcLimIEEE.hyst>" + hyst + "</cim:OverexcLimIEEE.hyst>\n" +
        "\t\t<cim:OverexcLimIEEE.ifdlim>" + ifdlim + "</cim:OverexcLimIEEE.ifdlim>\n" +
        "\t\t<cim:OverexcLimIEEE.ifdmax>" + ifdmax + "</cim:OverexcLimIEEE.ifdmax>\n" +
        "\t\t<cim:OverexcLimIEEE.itfpu>" + itfpu + "</cim:OverexcLimIEEE.itfpu>\n" +
        "\t\t<cim:OverexcLimIEEE.kcd>" + kcd + "</cim:OverexcLimIEEE.kcd>\n" +
        "\t\t<cim:OverexcLimIEEE.kramp>" + kramp + "</cim:OverexcLimIEEE.kramp>\n"
    }
    override def export: String =
    {
        "\t<cim:OverexcLimIEEE rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverexcLimIEEE>"
    }
}

object OverexcLimIEEE
extends
    Parseable[OverexcLimIEEE]
{
    val hyst = parse_element (element ("""OverexcLimIEEE.hyst"""))
    val ifdlim = parse_element (element ("""OverexcLimIEEE.ifdlim"""))
    val ifdmax = parse_element (element ("""OverexcLimIEEE.ifdmax"""))
    val itfpu = parse_element (element ("""OverexcLimIEEE.itfpu"""))
    val kcd = parse_element (element ("""OverexcLimIEEE.kcd"""))
    val kramp = parse_element (element ("""OverexcLimIEEE.kramp"""))
    def parse (context: Context): OverexcLimIEEE =
    {
        OverexcLimIEEE(
            OverexcitationLimiterDynamics.parse (context),
            toDouble (hyst (context), context),
            toDouble (ifdlim (context), context),
            toDouble (ifdmax (context), context),
            toDouble (itfpu (context), context),
            toDouble (kcd (context), context),
            toDouble (kramp (context), context)
        )
    }
}

/**
 * Field voltage over excitation limiter.
 *
 * @param sup Reference to the superclass object.
 * @param efd1 Low voltage point on the inverse time characteristic (EFD<sub>1</sub>).
 *        Typical Value = 1.1.
 * @param efd2 Mid voltage point on the inverse time characteristic (EFD<sub>2</sub>).
 *        Typical Value = 1.2.
 * @param efd3 High voltage point on the inverse time characteristic (EFD<sub>3</sub>).
 *        Typical Value = 1.5.
 * @param efddes Desired field voltage (EFD<sub>DES</sub>).
 *        Typical Value = 0.9.
 * @param efdrated Rated field voltage (EFD<sub>RATED</sub>).
 *        Typical Value = 1.05.
 * @param kmx Gain (K<sub>MX</sub>).
 *        Typical Value = 0.01.
 * @param t1 Time to trip the exciter at the low voltage point on the inverse time characteristic (TIME<sub>1</sub>).
 *        Typical Value = 120.
 * @param t2 Time to trip the exciter at the mid voltage point on the inverse time characteristic (TIME<sub>2</sub>).
 *        Typical Value = 40.
 * @param t3 Time to trip the exciter at the high voltage point on the inverse time characteristic (TIME<sub>3</sub>).
 *        Typical Value = 15.
 * @param vlow Low voltage limit (V<sub>LOW</sub>) (&gt;0).
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLimX1
(
    override val sup: OverexcitationLimiterDynamics,
    efd1: Double,
    efd2: Double,
    efd3: Double,
    efddes: Double,
    efdrated: Double,
    kmx: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    vlow: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLimX1] }
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
        "\t\t<cim:OverexcLimX1.efd1>" + efd1 + "</cim:OverexcLimX1.efd1>\n" +
        "\t\t<cim:OverexcLimX1.efd2>" + efd2 + "</cim:OverexcLimX1.efd2>\n" +
        "\t\t<cim:OverexcLimX1.efd3>" + efd3 + "</cim:OverexcLimX1.efd3>\n" +
        "\t\t<cim:OverexcLimX1.efddes>" + efddes + "</cim:OverexcLimX1.efddes>\n" +
        "\t\t<cim:OverexcLimX1.efdrated>" + efdrated + "</cim:OverexcLimX1.efdrated>\n" +
        "\t\t<cim:OverexcLimX1.kmx>" + kmx + "</cim:OverexcLimX1.kmx>\n" +
        "\t\t<cim:OverexcLimX1.t1>" + t1 + "</cim:OverexcLimX1.t1>\n" +
        "\t\t<cim:OverexcLimX1.t2>" + t2 + "</cim:OverexcLimX1.t2>\n" +
        "\t\t<cim:OverexcLimX1.t3>" + t3 + "</cim:OverexcLimX1.t3>\n" +
        "\t\t<cim:OverexcLimX1.vlow>" + vlow + "</cim:OverexcLimX1.vlow>\n"
    }
    override def export: String =
    {
        "\t<cim:OverexcLimX1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverexcLimX1>"
    }
}

object OverexcLimX1
extends
    Parseable[OverexcLimX1]
{
    val efd1 = parse_element (element ("""OverexcLimX1.efd1"""))
    val efd2 = parse_element (element ("""OverexcLimX1.efd2"""))
    val efd3 = parse_element (element ("""OverexcLimX1.efd3"""))
    val efddes = parse_element (element ("""OverexcLimX1.efddes"""))
    val efdrated = parse_element (element ("""OverexcLimX1.efdrated"""))
    val kmx = parse_element (element ("""OverexcLimX1.kmx"""))
    val t1 = parse_element (element ("""OverexcLimX1.t1"""))
    val t2 = parse_element (element ("""OverexcLimX1.t2"""))
    val t3 = parse_element (element ("""OverexcLimX1.t3"""))
    val vlow = parse_element (element ("""OverexcLimX1.vlow"""))
    def parse (context: Context): OverexcLimX1 =
    {
        OverexcLimX1(
            OverexcitationLimiterDynamics.parse (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (efd3 (context), context),
            toDouble (efddes (context), context),
            toDouble (efdrated (context), context),
            toDouble (kmx (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (vlow (context), context)
        )
    }
}

/**
 * Field Voltage or Current overexcitation limiter designed to protect the generator field of an AC machine with automatic excitation control from overheating due to prolonged overexcitation.
 *
 * @param sup Reference to the superclass object.
 * @param efd1 Low voltage or current point on the inverse time characteristic (EFD<sub>1</sub>).
 *        Typical Value = 1.1.
 * @param efd2 Mid voltage or current point on the inverse time characteristic (EFD<sub>2</sub>).
 *        Typical Value = 1.2.
 * @param efd3 High voltage or current point on the inverse time characteristic (EFD<sub>3</sub>).
 *        Typical Value = 1.5.
 * @param efddes Desired field voltage if m=F or field current if m=T (EFD<sub>DES</sub>).
 *        Typical Value = 1.
 * @param efdrated Rated field voltage if m=F or field current if m=T (EFD<sub>RATED</sub>).
 *        Typical Value = 1.05.
 * @param kmx Gain (K<sub>MX</sub>).
 *        Typical Value = 0.002.
 * @param m (m).
 *        true = IFD limiting
 *        false = EFD limiting.
 * @param t1 Time to trip the exciter at the low voltage or current point on the inverse time characteristic (TIME<sub>1</sub>).
 *        Typical Value = 120.
 * @param t2 Time to trip the exciter at the mid voltage or current point on the inverse time characteristic (TIME<sub>2</sub>).
 *        Typical Value = 40.
 * @param t3 Time to trip the exciter at the high voltage or current point on the inverse time characteristic (TIME<sub>3</sub>).
 *        Typical Value = 15.
 * @param vlow Low voltage limit (V<sub>LOW</sub>) (&gt;0).
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLimX2
(
    override val sup: OverexcitationLimiterDynamics,
    efd1: Double,
    efd2: Double,
    efd3: Double,
    efddes: Double,
    efdrated: Double,
    kmx: Double,
    m: Boolean,
    t1: Double,
    t2: Double,
    t3: Double,
    vlow: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLimX2] }
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
        "\t\t<cim:OverexcLimX2.efd1>" + efd1 + "</cim:OverexcLimX2.efd1>\n" +
        "\t\t<cim:OverexcLimX2.efd2>" + efd2 + "</cim:OverexcLimX2.efd2>\n" +
        "\t\t<cim:OverexcLimX2.efd3>" + efd3 + "</cim:OverexcLimX2.efd3>\n" +
        "\t\t<cim:OverexcLimX2.efddes>" + efddes + "</cim:OverexcLimX2.efddes>\n" +
        "\t\t<cim:OverexcLimX2.efdrated>" + efdrated + "</cim:OverexcLimX2.efdrated>\n" +
        "\t\t<cim:OverexcLimX2.kmx>" + kmx + "</cim:OverexcLimX2.kmx>\n" +
        "\t\t<cim:OverexcLimX2.m>" + m + "</cim:OverexcLimX2.m>\n" +
        "\t\t<cim:OverexcLimX2.t1>" + t1 + "</cim:OverexcLimX2.t1>\n" +
        "\t\t<cim:OverexcLimX2.t2>" + t2 + "</cim:OverexcLimX2.t2>\n" +
        "\t\t<cim:OverexcLimX2.t3>" + t3 + "</cim:OverexcLimX2.t3>\n" +
        "\t\t<cim:OverexcLimX2.vlow>" + vlow + "</cim:OverexcLimX2.vlow>\n"
    }
    override def export: String =
    {
        "\t<cim:OverexcLimX2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverexcLimX2>"
    }
}

object OverexcLimX2
extends
    Parseable[OverexcLimX2]
{
    val efd1 = parse_element (element ("""OverexcLimX2.efd1"""))
    val efd2 = parse_element (element ("""OverexcLimX2.efd2"""))
    val efd3 = parse_element (element ("""OverexcLimX2.efd3"""))
    val efddes = parse_element (element ("""OverexcLimX2.efddes"""))
    val efdrated = parse_element (element ("""OverexcLimX2.efdrated"""))
    val kmx = parse_element (element ("""OverexcLimX2.kmx"""))
    val m = parse_element (element ("""OverexcLimX2.m"""))
    val t1 = parse_element (element ("""OverexcLimX2.t1"""))
    val t2 = parse_element (element ("""OverexcLimX2.t2"""))
    val t3 = parse_element (element ("""OverexcLimX2.t3"""))
    val vlow = parse_element (element ("""OverexcLimX2.vlow"""))
    def parse (context: Context): OverexcLimX2 =
    {
        OverexcLimX2(
            OverexcitationLimiterDynamics.parse (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (efd3 (context), context),
            toDouble (efddes (context), context),
            toDouble (efdrated (context), context),
            toDouble (kmx (context), context),
            toBoolean (m (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (vlow (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">O</font>Overexcitation limiter function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this overexcitation limiter model is associated.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcitationLimiterDynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[OverexcitationLimiterDynamics] }
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
        (if (null != ExcitationSystemDynamics) "\t\t<cim:OverexcitationLimiterDynamics.ExcitationSystemDynamics rdf:resource=\"#" + ExcitationSystemDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OverexcitationLimiterDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverexcitationLimiterDynamics>"
    }
}

object OverexcitationLimiterDynamics
extends
    Parseable[OverexcitationLimiterDynamics]
{
    val ExcitationSystemDynamics = parse_attribute (attribute ("""OverexcitationLimiterDynamics.ExcitationSystemDynamics"""))
    def parse (context: Context): OverexcitationLimiterDynamics =
    {
        OverexcitationLimiterDynamics(
            DynamicsFunctionBlock.parse (context),
            ExcitationSystemDynamics (context)
        )
    }
}

private[ninecode] object _OverexcitationLimiterDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            OverexcLim2.register,
            OverexcLimIEEE.register,
            OverexcLimX1.register,
            OverexcLimX2.register,
            OverexcitationLimiterDynamics.register
        )
    }
}