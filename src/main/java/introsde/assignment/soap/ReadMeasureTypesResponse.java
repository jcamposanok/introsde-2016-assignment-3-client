
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readMeasureTypesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readMeasureTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measureTypes" type="{http://soap.assignment.introsde/}measureTypesResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readMeasureTypesResponse", propOrder = {
    "measureTypes"
})
public class ReadMeasureTypesResponse {

    protected MeasureTypesResponse measureTypes;

    /**
     * Gets the value of the measureTypes property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureTypesResponse }
     *     
     */
    public MeasureTypesResponse getMeasureTypes() {
        return measureTypes;
    }

    /**
     * Sets the value of the measureTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureTypesResponse }
     *     
     */
    public void setMeasureTypes(MeasureTypesResponse value) {
        this.measureTypes = value;
    }

}
