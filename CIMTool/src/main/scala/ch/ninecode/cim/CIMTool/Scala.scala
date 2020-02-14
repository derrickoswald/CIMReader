package ch.ninecode.cim.CIMTool

import scala.collection.mutable

case class Scala (parser: ModelParser, pkg: Package)
{
    def valid_class_name (s: String): String =
    {
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "`type`"
            case "val" => "`val`"
            case "class" => "`class`"
            case "%" => "percent"
            case "length" => "len"
            case "Boolean" => "`Boolean`"
            case "String" => "`String`"
            case _ =>
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        if (name == "Unit")
            "Unit_"
        else
            name
    }

    def valid_attribute_name (attribute: Attribute): String =
    {
        val s = attribute.name
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "`type`"
            case "val" => "`val`"
            case "class" => "`class`"
            case "%" => "percent"
            case "length" => "len"
            case "size" => "size1"
            case "lock" => "lock1"
            case "switch" => "`switch`"
            case "char" => "`char`"
            case "default" => "`default`"
            case "native" => "`native`"
            case _ =>
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""").replace (""":""", """_""").replace ("""(""", """_""").replace (""")""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        val stupid_name =
            if (name == attribute.cls.name)
                name + "_attr"
            else if ((attribute.cls.sup != null) && (name == attribute.cls.sup.name))
                name + "_attr"
            else
                name
        stupid_name
    }

    def valid_role_name (role: Role): String =
    {
        val s = role.name
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "`type`"
            case "val" => "`val`"
            case "class" => "`class`"
            case "%" => "percent"
            case "length" => "len"
            case "size" => "size1"
            case "lock" => "lock1"
            case "switch" => "`switch`"
            case "char" => "`char`"
            case "default" => "`default`"
            case "native" => "`native`"
            case "" => "unknown" // ToDo: WTF?
            case _ => 
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        val stupid_name =
            if (name == role.src.name)
                name + "_attr"
            else if ((role.src.sup != null) && (name == role.src.sup.name))
                name + "_attr"
            else
                name
        stupid_name
    }

    val register: String =
    {
        "_" + valid_class_name (pkg.name)
    }

    def details (classes: mutable.Set[Class]) (attribute: Attribute): Member =
    {
        val name = attribute.name
        val variable = valid_attribute_name (attribute)
        val comment = attribute.notes
        parser.domains.find (_.name == attribute.typ) match
        {
            case Some (dom) =>
                dom.stereotype match
                {
                    case "Primitive" ⇒
                        dom.name match
                        {
                            case "Time" =>
                                Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Integer" => Member (name, variable, false, comment, false, "0..1", "0..*", "Int", "0", "toInteger", null)
                            case "Float" =>
                                Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Decimal" => Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Boolean" => Member (name, variable, false, comment, false, "0..1", "0..*", "Boolean", "false", "toBoolean", null)
                            case "Date" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Duration" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "String" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "DateTime" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "MonthDay" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "URI" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case _ =>
                                throw new Exception ("""unknown primitive type "%s"""".format (dom.name))
                        }
                    case "enumeration" ⇒
                        Member (name, variable, false, comment, true, "0..1", "0..*", "String", "null", "", null)
                    case "Compound" ⇒
                        Member (name, variable, false, comment, true, "0..1", "0..*", "String", "null", "",
                            classes.find (_.name == attribute.typ) match
                            {
                                case Some (clz: Class) ⇒ valid_class_name (clz.name)
                                case None ⇒ null
                            }
                        )
                    case "CIMDatatype" ⇒
                        dom.value match
                        {
                            case "Time" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Integer" => Member (name, variable, false, comment, false, "0..1", "0..*", "Int", "0", "toInteger", null)
                            case "Float" => Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Decimal" => Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Boolean" => Member (name, variable, false, comment, false, "0..1", "0..*", "Boolean", "false", "toBoolean", null)
                            case "Date" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Duration" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "String" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "DateTime" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "MonthDay" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case _ =>
                                Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                        }
                    case _ =>
                        throw new Exception ("""unknown Domain stereotype "%s"""".format (dom.stereotype))
                }
            case None =>
                classes.find (_.name == attribute.typ) match
                {
                    case Some (clz: Class) ⇒
                        Member (name, variable, false, comment, true, "0..1", "0..*", "String", "null", "", valid_class_name (clz.name))
                    case None ⇒
                        Member (name, variable, false, comment, true, "0..1", "", "String", "null", "", null)
                }
        }
    }

    def details (role: Role): Member =
    {
        val name = role.name
        val variable = valid_role_name (role)
        val comment = role.note
        val referenced_class = valid_class_name (role.dst.name)
        if (role.upper == 1)
            Member (name, variable, false, comment, true, role.card, role.mate.card, "String", "null", "", referenced_class)
        else
            Member (name, variable, false, comment, true, role.card, role.mate.card, "List[String]", "List()", "", referenced_class)
    }

    def asText (): String =
    {
        val case_classes = parser.classesFor (pkg)
        val p = new StringBuilder ()
        for (cls <- case_classes)
        {
            val name = valid_class_name (cls.name)
            val identified_object = name == "IdentifiedObject" // special handling for IdentifiedObject.mRID
            implicit val ordering: Ordering[Member] = new Ordering[Member]
            {
                def compare (a: Member, b: Member): Int =
                    if (a.name == "sup")
                        -1
                    else if (b.name == "sup")
                        1
                    else
                    {
                        val a_ = if (a.variable.charAt (0) == '`') a.variable.substring (1, a.variable.length - 1) else a.variable
                        val b_ = if (b.variable.charAt (0) == '`') b.variable.substring (1, b.variable.length - 1) else b.variable
                        if (a_.charAt (0).isLower)
                            if (b_.charAt (0).isLower)
                                a_.compareTo (b_)
                            else
                                -1
                        else
                            if (b_.charAt (0).isLower)
                                1
                            else
                                a_.compareTo (b_)
                    }
            }
            val sup = Member ("sup", "sup", true, "Reference to the superclass object.", false, "1", "", if (null != cls.sup) cls.sup.name else "BasicElement", "null", "", if (null == cls.sup) null else valid_class_name (cls.sup.name))
            val members: mutable.SortedSet[Member] =
                mutable.SortedSet[Member](sup) ++
                    parser.attributesFor (cls).map (details (case_classes)).toSet
                        .union (parser.rolesFor (cls).map (details).toSet)
            val fields: mutable.SortedSet[Member] = members.filter ("sup" != _.name)
            val s = new StringBuilder ()
            val n = if (null != pkg.notes) pkg.notes else ""
            s.append (JavaDoc (cls.note, 0, members, pkg.name, "Package " + pkg.name, n).asText)
            s.append ("case class ")
            s.append (name)
            s.append ("""
                |(
                |""".stripMargin)
            val initializers = new StringBuilder ()
            for (product <- members)
            {
                if (initializers.nonEmpty)
                {
                    initializers.append (", ")
                    s.append (""",
                    |""".stripMargin)
                }
                initializers.append (product.initializer)
                s.append ("""    """)
                if (product.overrid) s.append ("""override val """)
                s.append (product.variable)
                s.append (""": """)
                s.append (product.datatype)
            }

            s.append ("""
            |)
            |extends
            |    Element
            |{
            |    /**
            |     * Zero args constructor.
            |     */
            |    def this () = { this (""".stripMargin)
            s.append (initializers.toString)
            s.append (""") }
            |    /**
            |     * Return the superclass object.
            |     *
            |     * @return The typed superclass nested object.
            |     * @group Hierarchy
            |     * @groupname Hierarchy Class Hierarchy Related
            |     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
            |     */
            |    def """.stripMargin)
            if (null != cls.sup)
            {
                s.append (cls.sup.name)
                s.append (""": """)
                s.append (cls.sup.name)
                s.append (""" = sup.asInstanceOf[""")
                s.append (cls.sup.name)
            }
            else
                s.append (""" Element: Element = sup.asInstanceOf[Element""")
            s.append ("""]
            |    override def copy (): Row = { clone ().asInstanceOf[""".stripMargin)
            s.append (name)
            s.append ("""] }
            |    override def get (i: Int): Object =
            |    {
            |        if (i < productArity)
            |            productElement (i).asInstanceOf[AnyRef]
            |        else
            |            throw new IllegalArgumentException ("invalid property index " + i)
            |    }
            |    override def length: Int = productArity
            |    override def export_fields: String =
            |    {
            |""".stripMargin.format (name))
            if (fields.exists (_.name != sup))
            {
                s.append ("""        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
                    |        implicit val clz: String = %s.cls
                    |""".stripMargin.format (name))
                if (fields.exists (!_.reference))
                    s.append ("        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (%s.fields (position), value)\n".format (name))
                if (fields.exists (x ⇒ x.reference && !x.multiple))
                    s.append ("        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (%s.fields (position), value)\n".format (name))
                if (fields.exists (_.multiple))
                    s.append ("        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (%s.fields (position), x))\n".format (name))
                s.append (fields.iterator.zipWithIndex.map (x ⇒ (if (x._1.multiple) "emitattrs" else if (x._1.reference) "emitattr" else "emitelem") + " (" + x._2 + ", " + x._1.variable + ")").mkString ("        ", "\n        ", "\n"))
                s.append ("        s.toString\n")
            }
            else
                s.append ("        sup.export_fields\n")
            s.append ("""    }
            |    override def export: String =
            |    {
            |        "\t<cim:%s rdf:ID=\"%s\">\n%s\t</cim:%s>".format (id, export_fields)
            |    }
            |}
            |""".stripMargin.format (cls.name, "%s", "%s", cls.name))
            s.append ("""
            |object %s
            |extends
            |    Parseable[%s]
            |{
            |""".stripMargin.format (name, name))

            val any = members.exists (_.name != "sup")
            if (any)
            {
                // output the fields map
                s.append (fields.iterator.map ("\"" + _.name + "\"").mkString ("    override val fields: Array[String] = Array[String] (\n        ", ",\n        ", "\n    )\n"))

                // output the relations list
                val relationships = members.filter (member => (member.name != "sup") && (null != member.referenced_class))
                if (relationships.nonEmpty)
                    s.append (relationships.iterator.map (
                        member => """        Relationship ("%s", "%s", "%s", "%s")""".format (member.variable, member.referenced_class, member.this_cardinality, member.mate_cardinality)).mkString ("    override val relations: List[Relationship] = List (\n", ",\n", "\n    )\n"))

                // output the field parsers
                def pa (m: Member): String =
                {
                    if (m.reference)
                        if (m.multiple)
                            "parse_attributes (attribute"
                        else
                            "parse_attribute (attribute"
                    else
                        "parse_element (element"
                }
                s.append (fields.iterator.zipWithIndex.map (x ⇒ "val " + x._1.variable + ": %s = ".format (if (x._1.multiple) "FielderMultiple" else "Fielder") + pa (x._1) + " (cls, fields(" + x._2 + ")))").mkString ("    ", "\n    ", "\n"))
            }
            // output the parse method
            s.append ("""
            |    def parse (context: Context): %s =
            |    {
            |        implicit val ctx: Context = context
            |""".stripMargin.format (name))
            if (any)
            {
                val initializer = (for (i ← 0 until 1 + (fields.size / 32)) yield "0").mkString (",")
                s.append ("        implicit val bitfields: Array[Int] = Array(%s)\n".format (initializer))
            }
            if (identified_object)
                s.append ("        val base = BasicElement.parse (context)\n")
            s.append ("        val ret = %s (\n".format (name))
            // add field parser calls
            s.append (
                if (identified_object)
                    members.iterator.zipWithIndex.map (x ⇒ (x._1, if (x._1.name == "sup") "base" else if (x._1.name == "mRID") "base.id" else (if (x._1.multiple) "masks" else "mask") + " (" + x._1.variable + " (), " + (x._2 - 1) + ")"))
                        .map (x ⇒ if (x._1.function != "") x._1.function + " (" + x._2 + ")" else x._2).mkString ("            ", ",\n            ", "\n")
                else
                    members.iterator.zipWithIndex.map (x ⇒ (x._1, if (x._1.name == "sup") x._1.datatype + ".parse (context)" else (if (x._1.multiple) "masks" else "mask") + " (" + x._1.variable + " (), " + (x._2 - 1) + ")"))
                        .map (x ⇒ if (x._1.function != "") x._1.function + " (" + x._2 + ")" else x._2).mkString ("            ", ",\n            ", "\n")
            )
            s.append ("        )\n")
            if (any)
                s.append ("        ret.bitfields = bitfields\n")
            s.append ("        ret\n    }\n")
            s.append ("""}
                |
                |""".stripMargin)

            p.append (s)
        }

        if (case_classes.nonEmpty)
        {
            val v = new StringBuilder ()

            v.append ("""package ch.ninecode.model
            |
            |import org.apache.spark.sql.Row
            |
            |import ch.ninecode.cim.ClassInfo
            |import ch.ninecode.cim.Context
            |import ch.ninecode.cim.Parseable
            |import ch.ninecode.cim.Relationship
            |
            |""".stripMargin)
            v.append (p.toString)

            v.append ("""private[ninecode] object """)
            v.append (register)
            v.append ("""
                |{
                |    def register: List[ClassInfo] =
                |    {
                |""".stripMargin)
            v.append (case_classes.map (cls ⇒ valid_class_name (cls.name) + ".register").mkString ("        List (\n            ", ",\n            ", "\n        )"))
            v.append ("""
                |    }
                |}""".stripMargin)

            v.toString
        }
        else
            ""
    }
}
