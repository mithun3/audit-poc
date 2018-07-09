package com.router.poc.routes.impl;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.router.poc.exception.RouterException;
import com.router.poc.processor.ValidationProcessor;
import com.router.poc.routes.AbstractBaseRoute;
import com.router.poc.routes.RoutingBuilder;

@Component
public class RequestRouteBuilder extends AbstractBaseRoute implements RoutingBuilder {
	
	@Autowired
	@Qualifier("validationProcessor")
	private ValidationProcessor validationProcessor;
	
	

	@Override
	public RouteBuilder buildRoute() {
		
		RouteBuilder builder = new RouteBuilder() {
			public void configure() {
				onException(Exception.class)
					.handled(true)
					.maximumRedeliveries(getRetryCount())
					.maximumRedeliveryDelay(getRetryDelay())
					.end()
					.to("activemq:payment.request.failed");
				
				onException(RouterException.class)
					.handled(true)
					.maximumRedeliveries(getRetryCount())
					.maximumRedeliveryDelay(getRetryDelay())
					.end()
					.to("activemq:payment.request.failed");;
				
				from("activemq:payment.request")
					.log("")
					.setProperty("ROUTE_PATH", constant("REQUEST"))//SET PATH here
					.process(metricsInitProcessor)
					//do some more processing if possible
					.wireTap("activemq:payment.request.wiretap")
					.log("Schema Validation")
					.process(validationProcessor)
					.end()
					.multicast()
					.process(metricsCompleteProcessor)
					.to("activemq:payment.request.processed")
					.to("activemq:payment.request.processed.mirror");
			}
		};
		
		return builder;
	}


}
