package com.router.poc.routes;

import org.apache.camel.RoutesBuilder;

@FunctionalInterface
public interface RoutingBuilder {

	public RoutesBuilder buildRoute();

}
