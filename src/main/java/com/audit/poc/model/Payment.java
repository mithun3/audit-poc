
package com.audit.poc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "request"
})
@XmlRootElement(name = "payment", namespace = "http://www.xyz.com/req")
public class Payment {
    @XmlElement(namespace = "http://www.xyz.com/req", required = true)
    protected List<Payment.Request> request;
    public List<Payment.Request> getRequest() {
        if (request == null) {
            request = new ArrayList<Payment.Request>();
        }
        return this.request;
    }
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "requestId",
        "originId",
        "someId",
        "from",
        "to",
        "amount"
    })
    @ToString
    @Getter
    @Setter
    public static class Request {
        @XmlElement(namespace = "http://www.xyz.com/req", required = true)
        protected String requestId;
        @XmlElement(namespace = "http://www.xyz.com/req", required = true)
        protected String originId;
        @XmlElement(namespace = "http://www.xyz.com/req", required = true)
        protected String someId;
        @XmlElement(namespace = "http://www.xyz.com/req", required = true)
        protected Payment.Request.From from;
        @XmlElement(namespace = "http://www.xyz.com/req", required = true)
        protected Payment.Request.To to;
        @XmlElement(namespace = "http://www.xyz.com/req", required = true)
        protected BigDecimal amount;
        @XmlAttribute(name = "type", required = true)
        protected String type;
        @XmlAttribute(name = "transactionDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar transactionDate;
        @XmlAttribute(name = "code", required = true)
        protected String code;

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "firstName",
            "lastName",
            "acnum",
            "branch",
            "type"
        })
        @Getter
        @Setter
        @ToString
        public static class From {
            @XmlElement(name = "first-name", namespace = "http://www.xyz.com/req", required = true)
            protected String firstName;
            @XmlElement(name = "last-name", namespace = "http://www.xyz.com/req", required = true)
            protected String lastName;
            @XmlElement(namespace = "http://www.xyz.com/req", required = true)
            protected String acnum;
            @XmlElement(namespace = "http://www.xyz.com/req", required = true)
            protected String branch;
            @XmlElement(namespace = "http://www.xyz.com/req", required = true)
            protected String type;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "firstName",
            "lastName",
            "acnum",
            "branch",
            "type"
        })
        @Getter
        @Setter
        @ToString
        public static class To {
            @XmlElement(name = "first-name", namespace = "http://www.xyz.com/req", required = true)
            protected String firstName;
            @XmlElement(name = "last-name", namespace = "http://www.xyz.com/req", required = true)
            protected String lastName;
            @XmlElement(namespace = "http://www.xyz.com/req", required = true)
            protected String acnum;
            @XmlElement(namespace = "http://www.xyz.com/req", required = true)
            protected String branch;
            @XmlElement(namespace = "http://www.xyz.com/req", required = true)
            protected String type;
        }
    }
}
