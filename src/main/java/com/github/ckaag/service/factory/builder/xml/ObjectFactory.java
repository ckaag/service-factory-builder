//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.07.24 um 01:57:53 PM CEST 
//


package com.github.ckaag.service.factory.builder.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.github.ckaag.service.factory.builder.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.github.ckaag.service.factory.builder.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Column }
     * 
     */
    public Column createColumn() {
        return new Column();
    }

    /**
     * Create an instance of {@link LocalizedColumn }
     * 
     */
    public LocalizedColumn createLocalizedColumn() {
        return new LocalizedColumn();
    }

    /**
     * Create an instance of {@link Exceptions }
     * 
     */
    public Exceptions createExceptions() {
        return new Exceptions();
    }

    /**
     * Create an instance of {@link TxRequired }
     * 
     */
    public TxRequired createTxRequired() {
        return new TxRequired();
    }

    /**
     * Create an instance of {@link Finder }
     * 
     */
    public Finder createFinder() {
        return new Finder();
    }

    /**
     * Create an instance of {@link FinderColumn }
     * 
     */
    public FinderColumn createFinderColumn() {
        return new FinderColumn();
    }

    /**
     * Create an instance of {@link Reference }
     * 
     */
    public Reference createReference() {
        return new Reference();
    }

    /**
     * Create an instance of {@link ServiceBuilderImport }
     * 
     */
    public ServiceBuilderImport createServiceBuilderImport() {
        return new ServiceBuilderImport();
    }

    /**
     * Create an instance of {@link LocalizedEntity }
     * 
     */
    public LocalizedEntity createLocalizedEntity() {
        return new LocalizedEntity();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link ServiceBuilder }
     * 
     */
    public ServiceBuilder createServiceBuilder() {
        return new ServiceBuilder();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link OrderColumn }
     * 
     */
    public OrderColumn createOrderColumn() {
        return new OrderColumn();
    }

}
