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
    "author",
    "namespace",
    "entity",
    "exceptions",
    "serviceBuilderImport"
})
@XmlRootElement(name = "service-builder")
public class ServiceBuilder {

    @XmlAttribute(name = "package-path", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String packagePath;
    @XmlAttribute(name = "auto-import-default-references")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String autoImportDefaultReferences;
    @XmlAttribute(name = "auto-namespace-tables")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String autoNamespaceTables;
    @XmlAttribute(name = "dependency-injector")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dependencyInjector;
    @XmlAttribute(name = "mvcc-enabled")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mvccEnabled;
    protected String author;
    @XmlElement(required = true)
    protected String namespace;
    protected List<Entity> entity;
    protected Exceptions exceptions;
    @XmlElement(name = "service-builder-import")
    protected List<ServiceBuilderImport> serviceBuilderImport;

    /**
     * Ruft den Wert der packagePath-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackagePath() {
        return packagePath;
    }

    /**
     * Legt den Wert der packagePath-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackagePath(String value) {
        this.packagePath = value;
    }

    /**
     * Ruft den Wert der autoImportDefaultReferences-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoImportDefaultReferences() {
        return autoImportDefaultReferences;
    }

    /**
     * Legt den Wert der autoImportDefaultReferences-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoImportDefaultReferences(String value) {
        this.autoImportDefaultReferences = value;
    }

    /**
     * Ruft den Wert der autoNamespaceTables-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoNamespaceTables() {
        return autoNamespaceTables;
    }

    /**
     * Legt den Wert der autoNamespaceTables-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoNamespaceTables(String value) {
        this.autoNamespaceTables = value;
    }

    /**
     * Ruft den Wert der dependencyInjector-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependencyInjector() {
        return dependencyInjector;
    }

    /**
     * Legt den Wert der dependencyInjector-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependencyInjector(String value) {
        this.dependencyInjector = value;
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
     * Ruft den Wert der author-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Legt den Wert der author-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Ruft den Wert der namespace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Legt den Wert der namespace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    /**
     * Gets the value of the entity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entity }
     * 
     * 
     */
    public List<Entity> getEntity() {
        if (entity == null) {
            entity = new ArrayList<Entity>();
        }
        return this.entity;
    }

    /**
     * Ruft den Wert der exceptions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Exceptions }
     *     
     */
    public Exceptions getExceptions() {
        return exceptions;
    }

    /**
     * Legt den Wert der exceptions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Exceptions }
     *     
     */
    public void setExceptions(Exceptions value) {
        this.exceptions = value;
    }

    /**
     * Gets the value of the serviceBuilderImport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceBuilderImport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceBuilderImport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceBuilderImport }
     * 
     * 
     */
    public List<ServiceBuilderImport> getServiceBuilderImport() {
        if (serviceBuilderImport == null) {
            serviceBuilderImport = new ArrayList<ServiceBuilderImport>();
        }
        return this.serviceBuilderImport;
    }

}
