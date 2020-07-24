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
    "column",
    "localizedColumn",
    "order",
    "finder"
})
@XmlRootElement(name = "localized-entity")
public class LocalizedEntity {

    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "table")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String table;
    protected List<Column> column;
    @XmlElement(name = "localized-column", required = true)
    protected List<LocalizedColumn> localizedColumn;
    protected Order order;
    protected List<Finder> finder;

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
     * Ruft den Wert der table-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTable() {
        return table;
    }

    /**
     * Legt den Wert der table-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTable(String value) {
        this.table = value;
    }

    /**
     * Gets the value of the column property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the column property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Column }
     * 
     * 
     */
    public List<Column> getColumn() {
        if (column == null) {
            column = new ArrayList<Column>();
        }
        return this.column;
    }

    /**
     * Gets the value of the localizedColumn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localizedColumn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalizedColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizedColumn }
     * 
     * 
     */
    public List<LocalizedColumn> getLocalizedColumn() {
        if (localizedColumn == null) {
            localizedColumn = new ArrayList<LocalizedColumn>();
        }
        return this.localizedColumn;
    }

    /**
     * Ruft den Wert der order-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Legt den Wert der order-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setOrder(Order value) {
        this.order = value;
    }

    /**
     * Gets the value of the finder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the finder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Finder }
     * 
     * 
     */
    public List<Finder> getFinder() {
        if (finder == null) {
            finder = new ArrayList<Finder>();
        }
        return this.finder;
    }

}
