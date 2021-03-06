
package introsde.assignment.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "People", targetNamespace = "http://soap.assignment.introsde/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface People {


    /**
     * 
     * @return
     *     returns introsde.assignment.soap.PersonListResponse
     */
    @WebMethod
    @WebResult(name = "people", targetNamespace = "")
    @RequestWrapper(localName = "readPersonList", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPersonList")
    @ResponseWrapper(localName = "readPersonListResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPersonListResponse")
    @Action(input = "http://soap.assignment.introsde/People/readPersonListRequest", output = "http://soap.assignment.introsde/People/readPersonListResponse")
    public PersonListResponse readPersonList();

    /**
     * 
     * @param id
     * @return
     *     returns introsde.assignment.soap.PersonResponse
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPersonResponse")
    @Action(input = "http://soap.assignment.introsde/People/readPersonRequest", output = "http://soap.assignment.introsde/People/readPersonResponse")
    public PersonResponse readPerson(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param p
     * @return
     *     returns introsde.assignment.soap.PersonResponse
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.UpdatePersonResponse")
    @Action(input = "http://soap.assignment.introsde/People/updatePersonRequest", output = "http://soap.assignment.introsde/People/updatePersonResponse")
    public PersonResponse updatePerson(
        @WebParam(name = "p", targetNamespace = "")
        Person p);

    /**
     * 
     * @param p
     * @return
     *     returns introsde.assignment.soap.PersonResponse
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.CreatePersonResponse")
    @Action(input = "http://soap.assignment.introsde/People/createPersonRequest", output = "http://soap.assignment.introsde/People/createPersonResponse")
    public PersonResponse createPerson(
        @WebParam(name = "p", targetNamespace = "")
        Person p);

    /**
     * 
     * @param id
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.DeletePersonResponse")
    @Action(input = "http://soap.assignment.introsde/People/deletePersonRequest", output = "http://soap.assignment.introsde/People/deletePersonResponse")
    public int deletePerson(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @param measureType
     * @return
     *     returns introsde.assignment.soap.MeasureHistoryResponse
     */
    @WebMethod
    @WebResult(name = "healthProfile-history", targetNamespace = "")
    @RequestWrapper(localName = "readPersonHistory", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPersonHistory")
    @ResponseWrapper(localName = "readPersonHistoryResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPersonHistoryResponse")
    @Action(input = "http://soap.assignment.introsde/People/readPersonHistoryRequest", output = "http://soap.assignment.introsde/People/readPersonHistoryResponse")
    public MeasureHistoryResponse readPersonHistory(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType);

    /**
     * 
     * @return
     *     returns introsde.assignment.soap.MeasureTypesResponse
     */
    @WebMethod
    @WebResult(name = "measureTypes", targetNamespace = "")
    @RequestWrapper(localName = "readMeasureTypes", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadMeasureTypes")
    @ResponseWrapper(localName = "readMeasureTypesResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadMeasureTypesResponse")
    @Action(input = "http://soap.assignment.introsde/People/readMeasureTypesRequest", output = "http://soap.assignment.introsde/People/readMeasureTypesResponse")
    public MeasureTypesResponse readMeasureTypes();

    /**
     * 
     * @param mid
     * @param id
     * @param measureType
     * @return
     *     returns introsde.assignment.soap.HealthProfileItemResponse
     */
    @WebMethod
    @WebResult(name = "measure", targetNamespace = "")
    @RequestWrapper(localName = "readPersonMeasure", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPersonMeasure")
    @ResponseWrapper(localName = "readPersonMeasureResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.ReadPersonMeasureResponse")
    @Action(input = "http://soap.assignment.introsde/People/readPersonMeasureRequest", output = "http://soap.assignment.introsde/People/readPersonMeasureResponse")
    public HealthProfileItemResponse readPersonMeasure(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "mid", targetNamespace = "")
        int mid);

    /**
     * 
     * @param id
     * @param m
     * @return
     *     returns introsde.assignment.soap.HealthProfileItemResponse
     */
    @WebMethod
    @WebResult(name = "measure", targetNamespace = "")
    @RequestWrapper(localName = "savePersonMeasure", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.SavePersonMeasure")
    @ResponseWrapper(localName = "savePersonMeasureResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.SavePersonMeasureResponse")
    @Action(input = "http://soap.assignment.introsde/People/savePersonMeasureRequest", output = "http://soap.assignment.introsde/People/savePersonMeasureResponse")
    public HealthProfileItemResponse savePersonMeasure(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "m", targetNamespace = "")
        Measure m);

    /**
     * 
     * @param id
     * @param m
     * @return
     *     returns introsde.assignment.soap.HealthProfileItemResponse
     */
    @WebMethod
    @WebResult(name = "measure", targetNamespace = "")
    @RequestWrapper(localName = "updatePersonMeasure", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.UpdatePersonMeasure")
    @ResponseWrapper(localName = "updatePersonMeasureResponse", targetNamespace = "http://soap.assignment.introsde/", className = "introsde.assignment.soap.UpdatePersonMeasureResponse")
    @Action(input = "http://soap.assignment.introsde/People/updatePersonMeasureRequest", output = "http://soap.assignment.introsde/People/updatePersonMeasureResponse")
    public HealthProfileItemResponse updatePersonMeasure(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "m", targetNamespace = "")
        Measure m);

}
