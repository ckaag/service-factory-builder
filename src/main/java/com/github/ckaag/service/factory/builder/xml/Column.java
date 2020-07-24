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
@XmlRootElement(name = "column")
public class Column {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "db-name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dbName;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "primary")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String primary;
    @XmlAttribute(name = "accessor")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String accessor;
    @XmlAttribute(name = "filter-primary")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String filterPrimary;
    @XmlAttribute(name = "entity")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String entity;
    @XmlAttribute(name = "mapping-table")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mappingTable;
    @XmlAttribute(name = "id-type")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String idType;
    @XmlAttribute(name = "id-param")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String idParam;
    @XmlAttribute(name = "convert-null")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String convertNull;
    @XmlAttribute(name = "lazy")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lazy;
    @XmlAttribute(name = "localized")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String localized;
    @XmlAttribute(name = "json-enabled")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String jsonEnabled;
    @XmlAttribute(name = "container-model")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String containerModel;
    @XmlAttribute(name = "parent-container-model")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parentContainerModel;
    @XmlAttribute(name = "uad-anonymize-field-name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uadAnonymizeFieldName;
    @XmlAttribute(name = "uad-nonanonymizable")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uadNonanonymizable;
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
     * Ruft den Wert der dbName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * Legt den Wert der dbName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbName(String value) {
        this.dbName = value;
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
     * Ruft den Wert der primary-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimary() {
        return primary;
    }

    /**
     * Legt den Wert der primary-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimary(String value) {
        this.primary = value;
    }

    /**
     * Ruft den Wert der accessor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessor() {
        return accessor;
    }

    /**
     * Legt den Wert der accessor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessor(String value) {
        this.accessor = value;
    }

    /**
     * Ruft den Wert der filterPrimary-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterPrimary() {
        return filterPrimary;
    }

    /**
     * Legt den Wert der filterPrimary-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterPrimary(String value) {
        this.filterPrimary = value;
    }

    /**
     * Ruft den Wert der entity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntity() {
        return entity;
    }

    /**
     * Legt den Wert der entity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntity(String value) {
        this.entity = value;
    }

    /**
     * Ruft den Wert der mappingTable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMappingTable() {
        return mappingTable;
    }

    /**
     * Legt den Wert der mappingTable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMappingTable(String value) {
        this.mappingTable = value;
    }

    /**
     * Ruft den Wert der idType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Legt den Wert der idType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdType(String value) {
        this.idType = value;
    }

    /**
     * Ruft den Wert der idParam-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdParam() {
        return idParam;
    }

    /**
     * Legt den Wert der idParam-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdParam(String value) {
        this.idParam = value;
    }

    /**
     * Ruft den Wert der convertNull-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvertNull() {
        return convertNull;
    }

    /**
     * Legt den Wert der convertNull-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvertNull(String value) {
        this.convertNull = value;
    }

    /**
     * Ruft den Wert der lazy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLazy() {
        return lazy;
    }

    /**
     * Legt den Wert der lazy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLazy(String value) {
        this.lazy = value;
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
     * Ruft den Wert der jsonEnabled-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonEnabled() {
        return jsonEnabled;
    }

    /**
     * Legt den Wert der jsonEnabled-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonEnabled(String value) {
        this.jsonEnabled = value;
    }

    /**
     * Ruft den Wert der containerModel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerModel() {
        return containerModel;
    }

    /**
     * Legt den Wert der containerModel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerModel(String value) {
        this.containerModel = value;
    }

    /**
     * Ruft den Wert der parentContainerModel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentContainerModel() {
        return parentContainerModel;
    }

    /**
     * Legt den Wert der parentContainerModel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentContainerModel(String value) {
        this.parentContainerModel = value;
    }

    /**
     * Ruft den Wert der uadAnonymizeFieldName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUadAnonymizeFieldName() {
        return uadAnonymizeFieldName;
    }

    /**
     * Legt den Wert der uadAnonymizeFieldName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUadAnonymizeFieldName(String value) {
        this.uadAnonymizeFieldName = value;
    }

    /**
     * Ruft den Wert der uadNonanonymizable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUadNonanonymizable() {
        return uadNonanonymizable;
    }

    /**
     * Legt den Wert der uadNonanonymizable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUadNonanonymizable(String value) {
        this.uadNonanonymizable = value;
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
