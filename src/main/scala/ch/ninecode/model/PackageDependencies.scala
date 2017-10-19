package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The version of dependencies description among top level subpackages of the combined CIM model.
 *
 * This is not the same as the combined packages version.
 *
 * @param sup Reference to the superclass object.
 * @param date Date of last change to the main package dependencies in format YYYY-MM-DD.
 *        This is updated when the version attribute is updated.
 * @param version The version of the main subpackages of the combined CIM model.
 *        The format is simply an integer.  The version (and date) initial values should be updated any time the dependencies in the model change and require an actual change to the diagrams within this package.
 * @group PackageDependencies
 * @groupname PackageDependencies Package PackageDependencies
 * @groupdesc PackageDependencies This package shows all the root level subpackage dependencies of the combined CIM model.
 */
case class PackageDependenciesCIMVersion
(
    override val sup: BasicElement,
    date: String,
    version: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PackageDependenciesCIMVersion] }
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
        implicit val clz: String = PackageDependenciesCIMVersion.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PackageDependenciesCIMVersion.fields (position), value)
        emitelem (0, date)
        emitelem (1, version)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PackageDependenciesCIMVersion rdf:ID=\"%s\">\n%s\t</cim:PackageDependenciesCIMVersion>".format (id, export_fields)
    }
}

object PackageDependenciesCIMVersion
extends
    Parseable[PackageDependenciesCIMVersion]
{
    val fields: Array[String] = Array[String] (
        "date",
        "version"
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val version: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): PackageDependenciesCIMVersion =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PackageDependenciesCIMVersion (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (version (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _PackageDependencies
{
    def register: List[ClassInfo] =
    {
        List (
            PackageDependenciesCIMVersion.register
        )
    }
}