
package com.router.poc.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.abc package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.abc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link Payment.Request }
     * 
     */
    public Payment.Request createPaymentRequest() {
        return new Payment.Request();
    }

    /**
     * Create an instance of {@link Payment.Request.From }
     * 
     */
    public Payment.Request.From createPaymentRequestFrom() {
        return new Payment.Request.From();
    }

    /**
     * Create an instance of {@link Payment.Request.To }
     * 
     */
    public Payment.Request.To createPaymentRequestTo() {
        return new Payment.Request.To();
    }

}
