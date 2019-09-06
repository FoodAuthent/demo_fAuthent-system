
package com.ftrace.epcis;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ftrace.ns.epcis package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FTRACETrackingCode_QNAME = new QName("http://ns.ftrace.com/epcis", "fTRACETrackingCode");
    private final static QName _DescendentId_QNAME = new QName("http://ns.ftrace.com/epcis", "descendentId");
    private final static QName _StreetAddressTwo_QNAME = new QName("http://ns.ftrace.com/epcis", "streetAddressTwo");
    private final static QName _City_QNAME = new QName("http://ns.ftrace.com/epcis", "city");
    private final static QName _PreservingPeriodStart_QNAME = new QName("http://ns.ftrace.com/epcis", "preservingPeriodStart");
    private final static QName _BreedCode_QNAME = new QName("http://ns.ftrace.com/epcis", "breedCode");
    private final static QName _CountryCode_QNAME = new QName("http://ns.ftrace.com/epcis", "countryCode");
    private final static QName _BreedOfMotherCode_QNAME = new QName("http://ns.ftrace.com/epcis", "breedOfMotherCode");
    private final static QName _EventPeriodEnd_QNAME = new QName("http://ns.ftrace.com/epcis", "eventPeriodEnd");
    private final static QName _Quantity_QNAME = new QName("http://ns.ftrace.com/epcis", "quantity");
    private final static QName _BestBeforeDate_QNAME = new QName("http://ns.ftrace.com/epcis", "bestBeforeDate");
    private final static QName _DateOfBirth_QNAME = new QName("http://ns.ftrace.com/epcis", "dateOfBirth");
    private final static QName _StreetAddressOne_QNAME = new QName("http://ns.ftrace.com/epcis", "streetAddressOne");
    private final static QName _LotNumber_QNAME = new QName("http://ns.ftrace.com/epcis", "lotNumber");
    private final static QName _CertificationCode_QNAME = new QName("http://ns.ftrace.com/epcis", "certificationCode");
    private final static QName _CountyCode_QNAME = new QName("http://ns.ftrace.com/epcis", "countyCode");
    private final static QName _CatchMethod_QNAME = new QName("http://ns.ftrace.com/epcis", "catchMethod");
    private final static QName _CrossBreedIndicator_QNAME = new QName("http://ns.ftrace.com/epcis", "crossBreedIndicator");
    private final static QName _PreservingPeriodEnd_QNAME = new QName("http://ns.ftrace.com/epcis", "preservingPeriodEnd");
    private final static QName _CountryOfOrigin_QNAME = new QName("http://ns.ftrace.com/epcis", "countryOfOrigin");
    private final static QName _DataProvider_QNAME = new QName("http://ns.ftrace.com/epcis", "dataProvider");
    private final static QName _PostalCode_QNAME = new QName("http://ns.ftrace.com/epcis", "postalCode");
    private final static QName _ProportionRankingOfLot_QNAME = new QName("http://ns.ftrace.com/epcis", "proportionRankingOfLot");
    private final static QName _CatchArea_QNAME = new QName("http://ns.ftrace.com/epcis", "catchArea");
    private final static QName _AnimalID_QNAME = new QName("http://ns.ftrace.com/epcis", "animalID");
    private final static QName _NumberOfAnimals_QNAME = new QName("http://ns.ftrace.com/epcis", "numberOfAnimals");
    private final static QName _DateOfFirstFreezing_QNAME = new QName("http://ns.ftrace.com/epcis", "dateOfFirstFreezing");
    private final static QName _State_QNAME = new QName("http://ns.ftrace.com/epcis", "state");
    private final static QName _ProportionPercentOfLot_QNAME = new QName("http://ns.ftrace.com/epcis", "proportionPercentOfLot");
    private final static QName _EventProfile_QNAME = new QName("http://ns.ftrace.com/epcis", "eventProfile");
    private final static QName _UseByDate_QNAME = new QName("http://ns.ftrace.com/epcis", "useByDate");
    private final static QName _BreedOfFatherCode_QNAME = new QName("http://ns.ftrace.com/epcis", "breedOfFatherCode");
    private final static QName _Name_QNAME = new QName("http://ns.ftrace.com/epcis", "name");
    private final static QName _StorageStateCode_QNAME = new QName("http://ns.ftrace.com/epcis", "storageStateCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ftrace.ns.epcis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Father }
     * 
     */
    public Father createFather() {
        return new Father();
    }

    /**
     * Create an instance of {@link AnimalIdentifications }
     * 
     */
    public AnimalIdentifications createAnimalIdentifications() {
        return new AnimalIdentifications();
    }

    /**
     * Create an instance of {@link Animal }
     * 
     */
    public Animal createAnimal() {
        return new Animal();
    }

    /**
     * Create an instance of {@link PlaceOfBirth }
     * 
     */
    public PlaceOfBirth createPlaceOfBirth() {
        return new PlaceOfBirth();
    }

    /**
     * Create an instance of {@link Mother }
     * 
     */
    public Mother createMother() {
        return new Mother();
    }

    /**
     * Create an instance of {@link CountriesOfBirth }
     * 
     */
    public CountriesOfBirth createCountriesOfBirth() {
        return new CountriesOfBirth();
    }

    /**
     * Create an instance of {@link PreStageDetails }
     * 
     */
    public PreStageDetails createPreStageDetails() {
        return new PreStageDetails();
    }

    /**
     * Create an instance of {@link AgricultureDetails }
     * 
     */
    public AgricultureDetails createAgricultureDetails() {
        return new AgricultureDetails();
    }

    /**
     * Create an instance of {@link FarmIdentificationNumber }
     * 
     */
    public FarmIdentificationNumber createFarmIdentificationNumber() {
        return new FarmIdentificationNumber();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Farm }
     * 
     */
    public Farm createFarm() {
        return new Farm();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link ListOfFarms }
     * 
     */
    public ListOfFarms createListOfFarms() {
        return new ListOfFarms();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "fTRACETrackingCode")
    public JAXBElement<String> createFTRACETrackingCode(String value) {
        return new JAXBElement<String>(_FTRACETrackingCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "descendentId")
    public JAXBElement<Integer> createDescendentId(Integer value) {
        return new JAXBElement<Integer>(_DescendentId_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "streetAddressTwo")
    public JAXBElement<String> createStreetAddressTwo(String value) {
        return new JAXBElement<String>(_StreetAddressTwo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "city")
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "preservingPeriodStart")
    public JAXBElement<XMLGregorianCalendar> createPreservingPeriodStart(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PreservingPeriodStart_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "breedCode")
    public JAXBElement<String> createBreedCode(String value) {
        return new JAXBElement<String>(_BreedCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "countryCode")
    public JAXBElement<String> createCountryCode(String value) {
        return new JAXBElement<String>(_CountryCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "breedOfMotherCode")
    public JAXBElement<String> createBreedOfMotherCode(String value) {
        return new JAXBElement<String>(_BreedOfMotherCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "eventPeriodEnd")
    public JAXBElement<String> createEventPeriodEnd(String value) {
        return new JAXBElement<String>(_EventPeriodEnd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "quantity")
    public JAXBElement<Integer> createQuantity(Integer value) {
        return new JAXBElement<Integer>(_Quantity_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "bestBeforeDate")
    public JAXBElement<XMLGregorianCalendar> createBestBeforeDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_BestBeforeDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "dateOfBirth")
    public JAXBElement<XMLGregorianCalendar> createDateOfBirth(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateOfBirth_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "streetAddressOne")
    public JAXBElement<String> createStreetAddressOne(String value) {
        return new JAXBElement<String>(_StreetAddressOne_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "lotNumber")
    public JAXBElement<String> createLotNumber(String value) {
        return new JAXBElement<String>(_LotNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "certificationCode")
    public JAXBElement<String> createCertificationCode(String value) {
        return new JAXBElement<String>(_CertificationCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "countyCode")
    public JAXBElement<String> createCountyCode(String value) {
        return new JAXBElement<String>(_CountyCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "catchMethod")
    public JAXBElement<String> createCatchMethod(String value) {
        return new JAXBElement<String>(_CatchMethod_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "crossBreedIndicator")
    public JAXBElement<Boolean> createCrossBreedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CrossBreedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "preservingPeriodEnd")
    public JAXBElement<XMLGregorianCalendar> createPreservingPeriodEnd(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PreservingPeriodEnd_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "countryOfOrigin")
    public JAXBElement<String> createCountryOfOrigin(String value) {
        return new JAXBElement<String>(_CountryOfOrigin_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "dataProvider")
    public JAXBElement<String> createDataProvider(String value) {
        return new JAXBElement<String>(_DataProvider_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "postalCode")
    public JAXBElement<String> createPostalCode(String value) {
        return new JAXBElement<String>(_PostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "proportionRankingOfLot")
    public JAXBElement<BigInteger> createProportionRankingOfLot(BigInteger value) {
        return new JAXBElement<BigInteger>(_ProportionRankingOfLot_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "catchArea")
    public JAXBElement<String> createCatchArea(String value) {
        return new JAXBElement<String>(_CatchArea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "animalID")
    public JAXBElement<String> createAnimalID(String value) {
        return new JAXBElement<String>(_AnimalID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "numberOfAnimals")
    public JAXBElement<BigInteger> createNumberOfAnimals(BigInteger value) {
        return new JAXBElement<BigInteger>(_NumberOfAnimals_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "dateOfFirstFreezing")
    public JAXBElement<XMLGregorianCalendar> createDateOfFirstFreezing(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateOfFirstFreezing_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "state")
    public JAXBElement<String> createState(String value) {
        return new JAXBElement<String>(_State_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "proportionPercentOfLot")
    public JAXBElement<Float> createProportionPercentOfLot(Float value) {
        return new JAXBElement<Float>(_ProportionPercentOfLot_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "eventProfile")
    public JAXBElement<String> createEventProfile(String value) {
        return new JAXBElement<String>(_EventProfile_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "useByDate")
    public JAXBElement<XMLGregorianCalendar> createUseByDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UseByDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "breedOfFatherCode")
    public JAXBElement<String> createBreedOfFatherCode(String value) {
        return new JAXBElement<String>(_BreedOfFatherCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/epcis", name = "storageStateCode")
    public JAXBElement<String> createStorageStateCode(String value) {
        return new JAXBElement<String>(_StorageStateCode_QNAME, String.class, null, value);
    }

}
