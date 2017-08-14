package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Organisation that is a commercial bank, agency, or other institution that offers a similar service.
 *
 * @param sup Reference to the superclass object.
 * @param bic Bank identifier code as defined in ISO 9362; for use in countries wher IBAN is not yet in operation.
 * @param iban International bank account number defined in ISO 13616; for countries where IBAN is not in operation, the existing BIC or SWIFT codes may be used instead (see ISO 9362).
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Bank
(
    override val sup: OrganisationRole,
    bic: String,
    iban: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[Bank] }
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
        (if (null != bic) "\t\t<cim:Bank.bic>" + bic + "</cim:Bank.bic>\n" else "") +
        (if (null != iban) "\t\t<cim:Bank.iban>" + iban + "</cim:Bank.iban>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Bank rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Bank>"
    }
}

object Bank
extends
    Parseable[Bank]
{
    val bic = parse_element (element ("""Bank.bic"""))
    val iban = parse_element (element ("""Bank.iban"""))
    def parse (context: Context): Bank =
    {
        Bank(
            OrganisationRole.parse (context),
            bic (context),
            iban (context)
        )
    }
}

/**
 * Bank account.
 *
 * @param sup Reference to the superclass object.
 * @param accountNumber Account reference number.
 * @param Bank Bank that provides this BankAccount.
 * @param ServiceSupplier ServiceSupplier that is owner of this BankAccount.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class BankAccount
(
    override val sup: Document,
    accountNumber: String,
    Bank: String,
    ServiceSupplier: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[BankAccount] }
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
        (if (null != accountNumber) "\t\t<cim:BankAccount.accountNumber>" + accountNumber + "</cim:BankAccount.accountNumber>\n" else "") +
        (if (null != Bank) "\t\t<cim:BankAccount.Bank rdf:resource=\"#" + Bank + "\"/>\n" else "") +
        (if (null != ServiceSupplier) "\t\t<cim:BankAccount.ServiceSupplier rdf:resource=\"#" + ServiceSupplier + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BankAccount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BankAccount>"
    }
}

object BankAccount
extends
    Parseable[BankAccount]
{
    val accountNumber = parse_element (element ("""BankAccount.accountNumber"""))
    val Bank = parse_attribute (attribute ("""BankAccount.Bank"""))
    val ServiceSupplier = parse_attribute (attribute ("""BankAccount.ServiceSupplier"""))
    def parse (context: Context): BankAccount =
    {
        BankAccount(
            Document.parse (context),
            accountNumber (context),
            Bank (context),
            ServiceSupplier (context)
        )
    }
}

/**
 * A BusinessPlan is an organized sequence of predetermined actions required to complete a future organizational objective.
 * It is a type of document that typically references a schedule, physical and/or logical resources (assets and/or PowerSystemResources), locations, etc.
 *
 * @param sup Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class BusinessPlan
(
    override val sup: Document
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[BusinessPlan] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:BusinessPlan rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BusinessPlan>"
    }
}

object BusinessPlan
extends
    Parseable[BusinessPlan]
{
    def parse (context: Context): BusinessPlan =
    {
        BusinessPlan(
            Document.parse (context)
        )
    }
}

/**
 * A business role that this organisation plays.
 * A single organisation typically performs many functions, each one described as a role.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Classification by utility's corporate standards and practices.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class BusinessRole
(
    override val sup: OrganisationRole,
    status: String,
    typ: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[BusinessRole] }
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
        (if (null != status) "\t\t<cim:BusinessRole.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:BusinessRole.type>" + typ + "</cim:BusinessRole.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BusinessRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BusinessRole>"
    }
}

object BusinessRole
extends
    Parseable[BusinessRole]
{
    val status = parse_attribute (attribute ("""BusinessRole.status"""))
    val typ = parse_element (element ("""BusinessRole.type"""))
    def parse (context: Context): BusinessRole =
    {
        BusinessRole(
            OrganisationRole.parse (context),
            status (context),
            typ (context)
        )
    }
}

/**
 * Craft of a person or a crew.
 * Examples include overhead electric, underground electric, high pressure gas, etc. This ensures necessary knowledge and skills before being allowed to perform certain types of work.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Classification by utility's work mangement standards and practices.
 * @param ErpPersons <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Craft
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String,
    ErpPersons: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Craft] }
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
        (if (null != status) "\t\t<cim:Craft.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:Craft.type>" + typ + "</cim:Craft.type>\n" else "") +
        (if (null != ErpPersons) ErpPersons.map (x => "\t\t<cim:Craft.ErpPersons rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Craft rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Craft>"
    }
}

object Craft
extends
    Parseable[Craft]
{
    val status = parse_attribute (attribute ("""Craft.status"""))
    val typ = parse_element (element ("""Craft.type"""))
    val ErpPersons = parse_attributes (attribute ("""Craft.ErpPersons"""))
    def parse (context: Context): Craft =
    {
        Craft(
            IdentifiedObject.parse (context),
            status (context),
            typ (context),
            ErpPersons (context)
        )
    }
}

/**
 * Role an organisation plays with respect to documents.
 *
 * @param sup Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class DocumentOrganisationRole
(
    override val sup: OrganisationRole
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[DocumentOrganisationRole] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:DocumentOrganisationRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DocumentOrganisationRole>"
    }
}

object DocumentOrganisationRole
extends
    Parseable[DocumentOrganisationRole]
{
    def parse (context: Context): DocumentOrganisationRole =
    {
        DocumentOrganisationRole(
            OrganisationRole.parse (context)
        )
    }
}

/**
 * A crew is a group of people with specific skills, tools, and vehicles.
 *
 * @param sup Reference to the superclass object.
 * @param typ Classification by utility's work management standards and practices.
 * @param Assignments All Assignments for this Crew.
 * @param Locations <em>undocumented</em>
 * @param Route <em>undocumented</em>
 * @param ShiftPatterns <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class OldCrew
(
    override val sup: Crew,
    typ: String,
    Assignments: List[String],
    Locations: List[String],
    Route: String,
    ShiftPatterns: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Crew: Crew = sup.asInstanceOf[Crew]
    override def copy (): Row = { clone ().asInstanceOf[OldCrew] }
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
        (if (null != typ) "\t\t<cim:OldCrew.type>" + typ + "</cim:OldCrew.type>\n" else "") +
        (if (null != Assignments) Assignments.map (x => "\t\t<cim:OldCrew.Assignments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Locations) Locations.map (x => "\t\t<cim:OldCrew.Locations rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Route) "\t\t<cim:OldCrew.Route rdf:resource=\"#" + Route + "\"/>\n" else "") +
        (if (null != ShiftPatterns) ShiftPatterns.map (x => "\t\t<cim:OldCrew.ShiftPatterns rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:OldCrew rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OldCrew>"
    }
}

object OldCrew
extends
    Parseable[OldCrew]
{
    val typ = parse_element (element ("""OldCrew.type"""))
    val Assignments = parse_attributes (attribute ("""OldCrew.Assignments"""))
    val Locations = parse_attributes (attribute ("""OldCrew.Locations"""))
    val Route = parse_attribute (attribute ("""OldCrew.Route"""))
    val ShiftPatterns = parse_attributes (attribute ("""OldCrew.ShiftPatterns"""))
    def parse (context: Context): OldCrew =
    {
        OldCrew(
            Crew.parse (context),
            typ (context),
            Assignments (context),
            Locations (context),
            Route (context),
            ShiftPatterns (context)
        )
    }
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Utility-specific classification for this person, according to the utility's corporate standards and practices.
 *        Examples include employee, contractor, agent, not affiliated, etc.
 * @param CustomerData <em>undocumented</em>
 * @param ErpCompetency <em>undocumented</em>
 * @param ErpPersonnel <em>undocumented</em>
 * @param LaborItems <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class OldPerson
(
    override val sup: Person,
    status: String,
    typ: String,
    CustomerData: String,
    ErpCompetency: String,
    ErpPersonnel: String,
    LaborItems: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Person: Person = sup.asInstanceOf[Person]
    override def copy (): Row = { clone ().asInstanceOf[OldPerson] }
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
        (if (null != status) "\t\t<cim:OldPerson.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:OldPerson.type>" + typ + "</cim:OldPerson.type>\n" else "") +
        (if (null != CustomerData) "\t\t<cim:OldPerson.CustomerData rdf:resource=\"#" + CustomerData + "\"/>\n" else "") +
        (if (null != ErpCompetency) "\t\t<cim:OldPerson.ErpCompetency rdf:resource=\"#" + ErpCompetency + "\"/>\n" else "") +
        (if (null != ErpPersonnel) "\t\t<cim:OldPerson.ErpPersonnel rdf:resource=\"#" + ErpPersonnel + "\"/>\n" else "") +
        (if (null != LaborItems) LaborItems.map (x => "\t\t<cim:OldPerson.LaborItems rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:OldPerson rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OldPerson>"
    }
}

object OldPerson
extends
    Parseable[OldPerson]
{
    val status = parse_attribute (attribute ("""OldPerson.status"""))
    val typ = parse_element (element ("""OldPerson.type"""))
    val CustomerData = parse_attribute (attribute ("""OldPerson.CustomerData"""))
    val ErpCompetency = parse_attribute (attribute ("""OldPerson.ErpCompetency"""))
    val ErpPersonnel = parse_attribute (attribute ("""OldPerson.ErpPersonnel"""))
    val LaborItems = parse_attributes (attribute ("""OldPerson.LaborItems"""))
    def parse (context: Context): OldPerson =
    {
        OldPerson(
            Person.parse (context),
            status (context),
            typ (context),
            CustomerData (context),
            ErpCompetency (context),
            ErpPersonnel (context),
            LaborItems (context)
        )
    }
}

/**
 * Roles played between Organisations and other Organisations.
 * This includes role ups for ogranisations, cost centers, profit centers, regulatory reporting, etc.
 *
 * @param sup Reference to the superclass object.
 * @param clientID Identifiers of the organisation held by another organisation, such as a government agency (federal, state, province, city, county), financial institution (Dun and Bradstreet), etc.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class OrgOrgRole
(
    override val sup: OrganisationRole,
    clientID: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[OrgOrgRole] }
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
        (if (null != clientID) "\t\t<cim:OrgOrgRole.clientID>" + clientID + "</cim:OrgOrgRole.clientID>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OrgOrgRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OrgOrgRole>"
    }
}

object OrgOrgRole
extends
    Parseable[OrgOrgRole]
{
    val clientID = parse_element (element ("""OrgOrgRole.clientID"""))
    def parse (context: Context): OrgOrgRole =
    {
        OrgOrgRole(
            OrganisationRole.parse (context),
            clientID (context)
        )
    }
}

/**
 * Roles played between Persons and Documents.
 *
 * @param sup Reference to the superclass object.
 * @param Person <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class PersonDocumentRole
(
    override val sup: Role,
    Person: String
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
    def Role: Role = sup.asInstanceOf[Role]
    override def copy (): Row = { clone ().asInstanceOf[PersonDocumentRole] }
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
        (if (null != Person) "\t\t<cim:PersonDocumentRole.Person rdf:resource=\"#" + Person + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PersonDocumentRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PersonDocumentRole>"
    }
}

object PersonDocumentRole
extends
    Parseable[PersonDocumentRole]
{
    val Person = parse_attribute (attribute ("""PersonDocumentRole.Person"""))
    def parse (context: Context): PersonDocumentRole =
    {
        PersonDocumentRole(
            Role.parse (context),
            Person (context)
        )
    }
}

/**
 * Role an organisation plays with respect to persons.
 *
 * @param sup Reference to the superclass object.
 * @param clientID Identifiers of the person held by an organisation, such as a government agency (federal, state, province, city, county), financial institutions, etc.
 * @param ErpPerson <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class PersonOrganisationRole
(
    override val sup: OrganisationRole,
    clientID: String,
    ErpPerson: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[PersonOrganisationRole] }
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
        (if (null != clientID) "\t\t<cim:PersonOrganisationRole.clientID>" + clientID + "</cim:PersonOrganisationRole.clientID>\n" else "") +
        (if (null != ErpPerson) "\t\t<cim:PersonOrganisationRole.ErpPerson rdf:resource=\"#" + ErpPerson + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PersonOrganisationRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PersonOrganisationRole>"
    }
}

object PersonOrganisationRole
extends
    Parseable[PersonOrganisationRole]
{
    val clientID = parse_element (element ("""PersonOrganisationRole.clientID"""))
    val ErpPerson = parse_attribute (attribute ("""PersonOrganisationRole.ErpPerson"""))
    def parse (context: Context): PersonOrganisationRole =
    {
        PersonOrganisationRole(
            OrganisationRole.parse (context),
            clientID (context),
            ErpPerson (context)
        )
    }
}

/**
 * The role of a person relative to a given piece of property.
 * Examples of roles include: owner, renter, contractor, etc.
 *
 * @param sup Reference to the superclass object.
 * @param LandProperty <em>undocumented</em>
 * @param Person <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class PersonPropertyRole
(
    override val sup: Role,
    LandProperty: String,
    Person: String
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
    def Role: Role = sup.asInstanceOf[Role]
    override def copy (): Row = { clone ().asInstanceOf[PersonPropertyRole] }
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
        (if (null != LandProperty) "\t\t<cim:PersonPropertyRole.LandProperty rdf:resource=\"#" + LandProperty + "\"/>\n" else "") +
        (if (null != Person) "\t\t<cim:PersonPropertyRole.Person rdf:resource=\"#" + Person + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PersonPropertyRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PersonPropertyRole>"
    }
}

object PersonPropertyRole
extends
    Parseable[PersonPropertyRole]
{
    val LandProperty = parse_attribute (attribute ("""PersonPropertyRole.LandProperty"""))
    val Person = parse_attribute (attribute ("""PersonPropertyRole.Person"""))
    def parse (context: Context): PersonPropertyRole =
    {
        PersonPropertyRole(
            Role.parse (context),
            LandProperty (context),
            Person (context)
        )
    }
}

/**
 * Role an organisation plays with respect to property (for example, the organisation may be the owner, renter, occupier, taxiing authority, etc.).
 *
 * @param sup Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class PropertyOrganisationRole
(
    override val sup: OrganisationRole
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[PropertyOrganisationRole] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:PropertyOrganisationRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PropertyOrganisationRole>"
    }
}

object PropertyOrganisationRole
extends
    Parseable[PropertyOrganisationRole]
{
    def parse (context: Context): PropertyOrganisationRole =
    {
        PropertyOrganisationRole(
            OrganisationRole.parse (context)
        )
    }
}

/**
 * Fraction specified explicitly with a numerator and denominator, which can be used to calculate the quotient.
 *
 * @param sup Reference to the superclass object.
 * @param denominator The part of a fraction that is below the line and that functions as the divisor of the numerator.
 * @param numerator The part of a fraction that is above the line and signifies the number to be divided by the denominator.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Ratio
(
    override val sup: BasicElement,
    denominator: Double,
    numerator: Double
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Ratio] }
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
        "\t\t<cim:Ratio.denominator>" + denominator + "</cim:Ratio.denominator>\n" +
        "\t\t<cim:Ratio.numerator>" + numerator + "</cim:Ratio.numerator>\n"
    }
    override def export: String =
    {
        "\t<cim:Ratio rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Ratio>"
    }
}

object Ratio
extends
    Parseable[Ratio]
{
    val denominator = parse_element (element ("""Ratio.denominator"""))
    val numerator = parse_element (element ("""Ratio.numerator"""))
    def parse (context: Context): Ratio =
    {
        Ratio(
            BasicElement.parse (context),
            toDouble (denominator (context), context),
            toDouble (numerator (context), context)
        )
    }
}

/**
 * Enumeration of potential roles that might be played by one object relative to another.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Type of role.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Role
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String
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
    override def copy (): Row = { clone ().asInstanceOf[Role] }
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
        (if (null != status) "\t\t<cim:Role.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:Role.type>" + typ + "</cim:Role.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Role rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Role>"
    }
}

object Role
extends
    Parseable[Role]
{
    val status = parse_attribute (attribute ("""Role.status"""))
    val typ = parse_element (element ("""Role.type"""))
    def parse (context: Context): Role =
    {
        Role(
            IdentifiedObject.parse (context),
            status (context),
            typ (context)
        )
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 *
 * @param sup Reference to the superclass object.
 * @param certificationPeriod Interval between the certification and its expiry.
 * @param effectiveDateTime Date and time the skill became effective.
 * @param level Level of skill for a Craft.
 * @param Crafts <em>undocumented</em>
 * @param ErpPerson <em>undocumented</em>
 * @param QualificationRequirements <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Skill
(
    override val sup: Document,
    certificationPeriod: String,
    effectiveDateTime: String,
    level: String,
    Crafts: List[String],
    ErpPerson: String,
    QualificationRequirements: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Skill] }
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
        (if (null != certificationPeriod) "\t\t<cim:Skill.certificationPeriod rdf:resource=\"#" + certificationPeriod + "\"/>\n" else "") +
        (if (null != effectiveDateTime) "\t\t<cim:Skill.effectiveDateTime>" + effectiveDateTime + "</cim:Skill.effectiveDateTime>\n" else "") +
        (if (null != level) "\t\t<cim:Skill.level rdf:resource=\"#" + level + "\"/>\n" else "") +
        (if (null != Crafts) Crafts.map (x => "\t\t<cim:Skill.Crafts rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ErpPerson) "\t\t<cim:Skill.ErpPerson rdf:resource=\"#" + ErpPerson + "\"/>\n" else "") +
        (if (null != QualificationRequirements) QualificationRequirements.map (x => "\t\t<cim:Skill.QualificationRequirements rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Skill rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Skill>"
    }
}

object Skill
extends
    Parseable[Skill]
{
    val certificationPeriod = parse_attribute (attribute ("""Skill.certificationPeriod"""))
    val effectiveDateTime = parse_element (element ("""Skill.effectiveDateTime"""))
    val level = parse_attribute (attribute ("""Skill.level"""))
    val Crafts = parse_attributes (attribute ("""Skill.Crafts"""))
    val ErpPerson = parse_attribute (attribute ("""Skill.ErpPerson"""))
    val QualificationRequirements = parse_attributes (attribute ("""Skill.QualificationRequirements"""))
    def parse (context: Context): Skill =
    {
        Skill(
            Document.parse (context),
            certificationPeriod (context),
            effectiveDateTime (context),
            level (context),
            Crafts (context),
            ErpPerson (context),
            QualificationRequirements (context)
        )
    }
}

private[ninecode] object _InfCommon
{
    def register: List[ClassInfo] =
    {
        List (
            Bank.register,
            BankAccount.register,
            BusinessPlan.register,
            BusinessRole.register,
            Craft.register,
            DocumentOrganisationRole.register,
            OldCrew.register,
            OldPerson.register,
            OrgOrgRole.register,
            PersonDocumentRole.register,
            PersonOrganisationRole.register,
            PersonPropertyRole.register,
            PropertyOrganisationRole.register,
            Ratio.register,
            Role.register,
            Skill.register
        )
    }
}