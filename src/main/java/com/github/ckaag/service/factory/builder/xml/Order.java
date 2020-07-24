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
    "orderColumn"
})
@XmlRootElement(name = "order")
public class Order {

    @XmlAttribute(name = "by")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String by;
    @XmlElement(name = "order-column", required = true)
    protected List<OrderColumn> orderColumn;

    /**
     * Ruft den Wert der by-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBy() {
        return by;
    }

    /**
     * Legt den Wert der by-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBy(String value) {
        this.by = value;
    }

    /**
     * Gets the value of the orderColumn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderColumn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderColumn }
     * 
     * 
     */
    public List<OrderColumn> getOrderColumn() {
        if (orderColumn == null) {
            orderColumn = new ArrayList<OrderColumn>();
        }
        return this.orderColumn;
    }

}
