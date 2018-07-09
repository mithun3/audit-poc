package com.router.poc.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractBaseRoute extends RouteBuilder {

	//TODO: put logger
	@Value(value = "${retry.count}")
	protected String retryCount;
	
	@Value(value = "${retry.delay}")
	protected String retryDelay;
	
	@Value(value = "${retry.host}")
	protected String retryHost;
	
	public Processor metricsInitProcessor = new Processor() {
		@Override
		public void process(Exchange exchange) throws Exception {
			exchange.setProperty("START_TIME", System.currentTimeMillis());
		}
	};
	
	public Processor metricsCompleteProcessor = new Processor() {
		@Override
		public void process(Exchange exchange) throws Exception {
			final long startTime = exchange.getProperty("START_TIME", Long.class);
			final long execTime = System.currentTimeMillis() - startTime;
			final String routePath = null; //TODO exchange.getProperty("START_TIME", Long.class);
			log.info("Total processing time");
		}
	};
	
	@Override
	public void configure() throws Exception {
		
	}
}
