//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.08.05 um 01:24:20 PM CEST 
//


package com.github.ckaag.service.factory.builder.hints;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.github.ckaag.service.factory.builder.hints package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.github.ckaag.service.factory.builder.hints
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Field }
     * 
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Create an instance of {@link HintCollection }
     * 
     */
    public HintCollection createHintCollection() {
        return new HintCollection();
    }

    /**
     * Create an instance of {@link Hint }
     * 
     */
    public Hint createHint() {
        return new Hint();
    }

    /**
     * Create an instance of {@link Sanitize }
     * 
     */
    public Sanitize createSanitize() {
        return new Sanitize();
    }

    /**
     * Create an instance of {@link Validator }
     * 
     */
    public Validator createValidator() {
        return new Validator();
    }

    /**
     * Create an instance of {@link DefaultHints }
     * 
     */
    public DefaultHints createDefaultHints() {
        return new DefaultHints();
    }

    /**
     * Create an instance of {@link ModelHints }
     * 
     */
    public ModelHints createModelHints() {
        return new ModelHints();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

}
