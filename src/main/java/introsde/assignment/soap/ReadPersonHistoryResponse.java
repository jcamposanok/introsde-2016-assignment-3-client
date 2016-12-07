
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readPersonHistoryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonHistoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="healthProfile-history" type="{http://soap.assignment.introsde/}measureHistoryResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonHistoryResponse", propOrder = {
    "healthProfileHistory"
})
public class ReadPersonHistoryResponse {

    @XmlElement(name = "healthProfile-history")
    protected MeasureHistoryResponse healthProfileHistory;

    /**
     * Gets the value of the healthProfileHistory property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureHistoryResponse }
     *     
     */
    public MeasureHistoryResponse getHealthProfileHistory() {
        return healthProfileHistory;
    }

    /**
     * Sets the value of the healthProfileHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureHistoryResponse }
     *     
     */
    public void setHealthProfileHistory(MeasureHistoryResponse value) {
        this.healthProfileHistory = value;
    }

}
