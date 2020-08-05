//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.08.05 um 01:24:20 PM CEST 
//


package com.github.ckaag.service.factory.builder.hints;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hintCollectionOrHintOrSanitizeOrValidator"
})
@XmlRootElement(name = "field")
public class Field {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "localized")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String localized;
    @XmlElements({
        @XmlElement(name = "hint-collection", type = HintCollection.class),
        @XmlElement(name = "hint", type = Hint.class),
        @XmlElement(name = "sanitize", type = Sanitize.class),
        @XmlElement(name = "validator", type = Validator.class)
    })
    protected List<Object> hintCollectionOrHintOrSanitizeOrValidator;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der localized-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalized() {
        return localized;
    }

    /**
     * Legt den Wert der localized-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalized(String value) {
        this.localized = value;
    }

    /**
     * Gets the value of the hintCollectionOrHintOrSanitizeOrValidator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hintCollectionOrHintOrSanitizeOrValidator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHintCollectionOrHintOrSanitizeOrValidator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HintCollection }
     * {@link Hint }
     * {@link Sanitize }
     * {@link Validator }
     * 
     * 
     */
    public List<Object> getHintCollectionOrHintOrSanitizeOrValidator() {
        if (hintCollectionOrHintOrSanitizeOrValidator == null) {
            hintCollectionOrHintOrSanitizeOrValidator = new ArrayList<Object>();
        }
        return this.hintCollectionOrHintOrSanitizeOrValidator;
    }

}
