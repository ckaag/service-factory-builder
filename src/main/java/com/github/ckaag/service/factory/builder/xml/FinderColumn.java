//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.07.24 um 01:57:53 PM CEST 
//


package com.github.ckaag.service.factory.builder.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "finder-column")
public class FinderColumn {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "case-sensitive")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String caseSensitive;
    @XmlAttribute(name = "comparator")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String comparator;
    @XmlAttribute(name = "arrayable-operator")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String arrayableOperator;
    @XmlAttribute(name = "arrayable-pagination")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String arrayablePagination;
    @XmlValue
    protected String value;

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
     * Ruft den Wert der caseSensitive-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseSensitive() {
        return caseSensitive;
    }

    /**
     * Legt den Wert der caseSensitive-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseSensitive(String value) {
        this.caseSensitive = value;
    }

    /**
     * Ruft den Wert der comparator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComparator() {
        return comparator;
    }

    /**
     * Legt den Wert der comparator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComparator(String value) {
        this.comparator = value;
    }

    /**
     * Ruft den Wert der arrayableOperator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrayableOperator() {
        return arrayableOperator;
    }

    /**
     * Legt den Wert der arrayableOperator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrayableOperator(String value) {
        this.arrayableOperator = value;
    }

    /**
     * Ruft den Wert der arrayablePagination-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrayablePagination() {
        return arrayablePagination;
    }

    /**
     * Legt den Wert der arrayablePagination-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrayablePagination(String value) {
        this.arrayablePagination = value;
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getvalue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setvalue(String value) {
        this.value = value;
    }

}
