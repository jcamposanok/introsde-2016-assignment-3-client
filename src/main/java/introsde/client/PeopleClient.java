package introsde.client;

import introsde.assignment.soap.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import java.io.*;
import java.net.URL;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


public class PeopleClient {

    static String environment;
    static String logPath;
    static String baseUrl;

    private static void setBaseUrl(String env) {
        Properties props = new Properties();
        URL propFileUrl = PeopleClient.class.getClassLoader().getResource("project.properties");
        try {
            props.load(propFileUrl.openStream());
            baseUrl = props.getProperty("project.baseurl." + env);
        } catch (IOException e) {
            e.printStackTrace();
            baseUrl = "";
        }
        baseUrl = (baseUrl.charAt(baseUrl.length() - 1) == '/') ? baseUrl + "/" : baseUrl;
        String message = "WSDL URL: " + baseUrl + "?wsdl";
        System.out.println(message);
        log(message, logPath);
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    private static void setLogger(String filepath) {
        File f = new File(filepath);
        if (f.getParentFile() != null) {
            f.getParentFile().mkdirs();
        }
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void log(String message, String filepath) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(filepath, true), true);
            out.write(message);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        environment = (args == null || args.length < 1) ? "local" : args[0];
        logPath = (args == null || args.length < 2) ? "client-server-xml.log" : args[1];

        setLogger(logPath);
        setBaseUrl(environment);

        PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();


        // Method 1

        PersonListResponse personListResponse = people.readPersonList();
        printRequest(1, "readPersonList", Collections.EMPTY_LIST, personListResponse);


        // Method 2

        PersonResponse personResponse = people.readPerson(1);
        printRequest(2, "readPerson", 1, personResponse);


        // Method 3

        Person updatePerson = new Person();
        String oldName = personResponse.getFirstname();
        String newNameSeq = String.valueOf(Math.random());
        String newName = oldName + newNameSeq.substring(newNameSeq.length() - 1);
        updatePerson.setPersonId(personResponse.getPersonId());
        updatePerson.setLastname(personResponse.getLastname());
        updatePerson.setFirstname(newName);
        updatePerson.setBirthdate(personResponse.getBirthdate());

        PersonResponse updatedPersonResponse = people.updatePerson(updatePerson);
        printRequest(3, "updatePerson", updatePerson, updatedPersonResponse);


        // Method 4

        Person newPerson = new Person();
        newPerson.setFirstname("Tom");
        newPerson.setLastname("Ryddle");

        GregorianCalendar c = GregorianCalendar.from(
                (LocalDate.parse("1926-12-31")).atStartOfDay(ZoneId.systemDefault())
        );
        /*
        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("1926-12-31"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */
        XMLGregorianCalendar date2 = null;
        try {
            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        newPerson.setBirthdate(date2);

        PersonResponse newPersonResponse = people.createPerson(newPerson);
        printRequest(4, "createPerson", newPerson, newPersonResponse);


        // Method 5

        int deletedId = people.deletePerson(newPersonResponse.getPersonId());
        printRequest(5, "deletePerson", newPersonResponse.getPersonId(), deletedId);


        // Method 6

        MeasureHistoryResponse measureHistoryResponse = people.readPersonHistory(1, "weight");
        printRequest(6, "readPersonHistory", new Object[]{1, "weight"}, measureHistoryResponse);


        // Method 7

        MeasureTypesResponse measureTypesResponse = people.readMeasureTypes();
        printRequest(7, "readMeasureTypes", Collections.EMPTY_LIST, measureTypesResponse);


        // Method 8

        if (measureHistoryResponse != null && measureHistoryResponse.getMeasure().size() > 0) {
            HealthProfileItemResponse healthProfileItemResponse = measureHistoryResponse.getMeasure().get(0);
            HealthProfileItemResponse sameAsAbove = people.readPersonMeasure(1, "weight", healthProfileItemResponse.getMid());
            printRequest(8, "readPersonMeasure", new Object[]{1, "weight", healthProfileItemResponse.getMid()}, sameAsAbove);
        }


        // Method 9

        Measure newMeasure = new Measure();
        newMeasure.setDateRegistered(date2);
        newMeasure.setMeasureType("weight");
        newMeasure.setMeasureValue("80");
        newMeasure.setMeasureValueType("Int");
        HealthProfileItemResponse savePersonMeasureResponse = people.savePersonMeasure(1, newMeasure);
        printRequest(9, "savePersonMeasure", new Object[]{1, newMeasure}, savePersonMeasureResponse);


        // Method 10

        newMeasure.setMid(Long.valueOf(savePersonMeasureResponse.getMid()));
        newMeasure.setMeasureValue("85.5");
        newMeasure.setMeasureValueType("Float");
        HealthProfileItemResponse updatePersonMeasureResponse = people.updatePersonMeasure(1, newMeasure);
        printRequest(10, "updatePersonMeasure", new Object[]{1, newMeasure}, updatePersonMeasureResponse);
    }

    private static void printRequest(int methodNum, String methodName, Object[] parameters, Object response) {
        String message = System.lineSeparator()
                + "Method #" + methodNum + ": "
                + methodName + System.lineSeparator()
                + "Parameters: ";
        for (Object o : parameters) {
            message += " " + o + " ";
        }
        message += System.lineSeparator()
                + "Response: " + response.toString();
        System.out.println(message);
        log(message, logPath);
    }

    private static void printRequest(int methodNum, String methodName, Object parameter, Object response) {
        String message = System.lineSeparator()
                + "Method #" + methodNum + ": "
                + methodName + System.lineSeparator()
                + "Parameters: " + parameter.toString() + System.lineSeparator()
                + "Response: " + response.toString();
        System.out.println(message);
        log(message, logPath);
    }
}
