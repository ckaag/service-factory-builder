//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.07.24 um 01:57:53 PM CEST 
//


package com.github.ckaag.service.factory.builder.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "finderColumn"
})
@XmlRootElement(name = "finder")
public class Finder {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "return-type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String returnType;
    @XmlAttribute(name = "unique")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String unique;
    @XmlAttribute(name = "where")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String where;
    @XmlAttribute(name = "db-index")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dbIndex;
    @XmlElement(name = "finder-column", required = true)
    protected List<FinderColumn> finderColumn;

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
     * Ruft den Wert der returnType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * Legt den Wert der returnType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnType(String value) {
        this.returnType = value;
    }

    /**
     * Ruft den Wert der unique-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnique() {
        return unique;
    }

    /**
     * Legt den Wert der unique-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnique(String value) {
        this.unique = value;
    }

    /**
     * Ruft den Wert der where-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhere() {
        return where;
    }

    /**
     * Legt den Wert der where-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhere(String value) {
        this.where = value;
    }

    /**
     * Ruft den Wert der dbIndex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbIndex() {
        return dbIndex;
    }

    /**
     * Legt den Wert der dbIndex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbIndex(String value) {
        this.dbIndex = value;
    }

    /**
     * Gets the value of the finderColumn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the finderColumn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinderColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinderColumn }
     * 
     * 
     */
    public List<FinderColumn> getFinderColumn() {
        if (finderColumn == null) {
            finderColumn = new ArrayList<FinderColumn>();
        }
        return this.finderColumn;
    }

}
