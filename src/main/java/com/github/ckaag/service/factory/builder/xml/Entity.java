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
    "localizedEntity",
    "order",
    "finder",
    "reference",
    "txRequired"
})
@XmlRootElement(name = "entity")
public class Entity {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "human-name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String humanName;
    @XmlAttribute(name = "table")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String table;
    @XmlAttribute(name = "uuid")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uuid;
    @XmlAttribute(name = "uuid-accessor")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uuidAccessor;
    @XmlAttribute(name = "external-reference-code")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String externalReferenceCode;
    @XmlAttribute(name = "local-service")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String localService;
    @XmlAttribute(name = "remote-service")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String remoteService;
    @XmlAttribute(name = "persistence")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String persistence;
    @XmlAttribute(name = "persistence-class")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String persistenceClass;
    @XmlAttribute(name = "data-source")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dataSource;
    @XmlAttribute(name = "session-factory")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sessionFactory;
    @XmlAttribute(name = "tx-manager")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String txManager;
    @XmlAttribute(name = "cache-enabled")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String cacheEnabled;
    @XmlAttribute(name = "dynamic-update-enabled")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dynamicUpdateEnabled;
    @XmlAttribute(name = "json-enabled")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String jsonEnabled;
    @XmlAttribute(name = "mvcc-enabled")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mvccEnabled;
    @XmlAttribute(name = "trash-enabled")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String trashEnabled;
    @XmlAttribute(name = "uad-application-name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uadApplicationName;
    @XmlAttribute(name = "uad-auto-delete")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uadAutoDelete;
    @XmlAttribute(name = "uad-dir-path")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uadDirPath;
    @XmlAttribute(name = "uad-package-path")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uadPackagePath;
    @XmlAttribute(name = "versioned")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String versioned;
    @XmlAttribute(name = "deprecated")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String deprecated;
    protected List<Column> column;
    @XmlElement(name = "localized-entity")
    protected LocalizedEntity localizedEntity;
    protected Order order;
    protected List<Finder> finder;
    protected List<Reference> reference;
    @XmlElement(name = "tx-required")
    protected List<TxRequired> txRequired;

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
     * Ruft den Wert der humanName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumanName() {
        return humanName;
    }

    /**
     * Legt den Wert der humanName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumanName(String value) {
        this.humanName = value;
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
     * Ruft den Wert der uuid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Legt den Wert der uuid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Ruft den Wert der uuidAccessor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuidAccessor() {
        return uuidAccessor;
    }

    /**
     * Legt den Wert der uuidAccessor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuidAccessor(String value) {
        this.uuidAccessor = value;
    }

    /**
     * Ruft den Wert der externalReferenceCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    /**
     * Legt den Wert der externalReferenceCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalReferenceCode(String value) {
        this.externalReferenceCode = value;
    }

    /**
     * Ruft den Wert der localService-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalService() {
        return localService;
    }

    /**
     * Legt den Wert der localService-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalService(String value) {
        this.localService = value;
    }

    /**
     * Ruft den Wert der remoteService-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteService() {
        return remoteService;
    }

    /**
     * Legt den Wert der remoteService-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteService(String value) {
        this.remoteService = value;
    }

    /**
     * Ruft den Wert der persistence-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersistence() {
        return persistence;
    }

    /**
     * Legt den Wert der persistence-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersistence(String value) {
        this.persistence = value;
    }

    /**
     * Ruft den Wert der persistenceClass-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersistenceClass() {
        return persistenceClass;
    }

    /**
     * Legt den Wert der persistenceClass-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersistenceClass(String value) {
        this.persistenceClass = value;
    }

    /**
     * Ruft den Wert der dataSource-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * Legt den Wert der dataSource-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSource(String value) {
        this.dataSource = value;
    }

    /**
     * Ruft den Wert der sessionFactory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Legt den Wert der sessionFactory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionFactory(String value) {
        this.sessionFactory = value;
    }

    /**
     * Ruft den Wert der txManager-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxManager() {
        return txManager;
    }

    /**
     * Legt den Wert der txManager-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxManager(String value) {
        this.txManager = value;
    }

    /**
     * Ruft den Wert der cacheEnabled-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheEnabled() {
        return cacheEnabled;
    }

    /**
     * Legt den Wert der cacheEnabled-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheEnabled(String value) {
        this.cacheEnabled = value;
    }

    /**
     * Ruft den Wert der dynamicUpdateEnabled-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamicUpdateEnabled() {
        return dynamicUpdateEnabled;
    }

    /**
     * Legt den Wert der dynamicUpdateEnabled-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamicUpdateEnabled(String value) {
        this.dynamicUpdateEnabled = value;
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
     * Ruft den Wert der mvccEnabled-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMvccEnabled() {
        return mvccEnabled;
    }

    /**
     * Legt den Wert der mvccEnabled-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMvccEnabled(String value) {
        this.mvccEnabled = value;
    }

    /**
     * Ruft den Wert der trashEnabled-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrashEnabled() {
        return trashEnabled;
    }

    /**
     * Legt den Wert der trashEnabled-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrashEnabled(String value) {
        this.trashEnabled = value;
    }

    /**
     * Ruft den Wert der uadApplicationName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUadApplicationName() {
        return uadApplicationName;
    }

    /**
     * Legt den Wert der uadApplicationName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUadApplicationName(String value) {
        this.uadApplicationName = value;
    }

    /**
     * Ruft den Wert der uadAutoDelete-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUadAutoDelete() {
        return uadAutoDelete;
    }

    /**
     * Legt den Wert der uadAutoDelete-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUadAutoDelete(String value) {
        this.uadAutoDelete = value;
    }

    /**
     * Ruft den Wert der uadDirPath-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUadDirPath() {
        return uadDirPath;
    }

    /**
     * Legt den Wert der uadDirPath-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUadDirPath(String value) {
        this.uadDirPath = value;
    }

    /**
     * Ruft den Wert der uadPackagePath-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUadPackagePath() {
        return uadPackagePath;
    }

    /**
     * Legt den Wert der uadPackagePath-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUadPackagePath(String value) {
        this.uadPackagePath = value;
    }

    /**
     * Ruft den Wert der versioned-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersioned() {
        return versioned;
    }

    /**
     * Legt den Wert der versioned-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersioned(String value) {
        this.versioned = value;
    }

    /**
     * Ruft den Wert der deprecated-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeprecated() {
        return deprecated;
    }

    /**
     * Legt den Wert der deprecated-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeprecated(String value) {
        this.deprecated = value;
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
     * Ruft den Wert der localizedEntity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocalizedEntity }
     *     
     */
    public LocalizedEntity getLocalizedEntity() {
        return localizedEntity;
    }

    /**
     * Legt den Wert der localizedEntity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizedEntity }
     *     
     */
    public void setLocalizedEntity(LocalizedEntity value) {
        this.localizedEntity = value;
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

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reference }
     * 
     * 
     */
    public List<Reference> getReference() {
        if (reference == null) {
            reference = new ArrayList<Reference>();
        }
        return this.reference;
    }

    /**
     * Gets the value of the txRequired property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txRequired property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxRequired().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TxRequired }
     * 
     * 
     */
    public List<TxRequired> getTxRequired() {
        if (txRequired == null) {
            txRequired = new ArrayList<TxRequired>();
        }
        return this.txRequired;
    }

}
