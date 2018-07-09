package com.router.poc.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.router.poc.exception.RouterException;
import com.router.poc.processor.AuditPersistProcessor;
import com.router.poc.processor.MetricsCompleteProcessor;
import com.router.poc.processor.MetricsInitProcessor;

import lombok.extern.slf4j.Slf4j;

/**
 * Magic Route Builder
 */
@Component
@Slf4j
public class CustomAuditRoutesBuilder extends RouteBuilder implements RoutesBuilder {
	
	@Autowired
	private MetricsInitProcessor metricsInitProcessor;
	
	@Autowired
	private MetricsCompleteProcessor metricsCompleteProcessor;
	
	@Autowired
	@Qualifier("auditPersistProcessor")
	private AuditPersistProcessor auditProcessor;
	
    public void configure() {
		
				onException(Exception.class)
					.handled(true)
//					.maximumRedeliveries(getRetryCount())
//					.maximumRedeliveryDelay(getRetryDelay())
					.end()
					.to("activemq:payment.request.acknowledge.failed");
				
				onException(RouterException.class)
					.handled(true)
//					.maximumRedeliveries(getRetryCount())
//					.maximumRedeliveryDelay(getRetryDelay())
					.end()
					.to("activemq:payment.request.acknowledge.failed");
				
				from("activemq:payment.request.acknowledge")
					.log("Obtained the message from payment.request.acknowledge queue")
					.setProperty("ROUTE_PATH", constant("REQUEST"))
					.process(metricsInitProcessor)
					.wireTap("activemq:payment.request.acknowledge.wiretap")
					.log("Dropped the message to the wiretap queue")
					.log("Schema Validation Started")
					.process(auditProcessor)
					.end()
					.multicast()
					.process(metricsCompleteProcessor)
					.to("activemq:payment.request.acknowledge.processed"); //write some logic to carryout acknowledgement
	}
}