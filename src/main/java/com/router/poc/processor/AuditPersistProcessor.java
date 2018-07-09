package com.router.poc.processor;

import java.io.StringReader;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.router.poc.entity.Audit;
import com.router.poc.exception.RouterException;
import com.router.poc.model.Payment;
import com.router.poc.model.Payment.Request;
import com.router.poc.repo.AuditRepo;

import lombok.extern.slf4j.Slf4j;

@Component(value="auditPersistProcessor")
@Slf4j
public class AuditPersistProcessor implements Processor {

	@Autowired
	private AuditRepo auditRepo;
	
	private JAXBContext jaxbContext;
	private Unmarshaller unmarshaller;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		final String incomingMessage = exchange.getIn().getBody(String.class);
		final String channelId = exchange.getProperty("SOURCE_ID", String.class);
		final String reqId = exchange.getProperty("REQUEST_ID", String.class);
		log.info("Started Persisting of XML - Inocming Message : {}, channelId : {}, reqId : {}", incomingMessage, channelId, reqId);
		try {
			if(StringUtils.isBlank(incomingMessage)) {
				log.error("Incoming Message is blank");
				throw new RouterException("Incoming Message is blank");
			}
		} catch (RouterException e) {
			exchange.setProperty("SOME_FAIL", "SOME_FAIL");
			log.error("Some exception has occured {}", e.getMessage());
			throw e;
		}
		
		try {
			persistData(incomingMessage, exchange);
		} catch (Exception e) {
			log.error("Exception has occured, during persisting process, {}", e.getMessage());
			throw new RouterException("Exception has occured, during persisting process");
		}
	}

	private void persistData(String incomingMessage, Exchange exchange) throws JAXBException {
		
		jaxbContext = JAXBContext.newInstance(Payment.class);
		unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(incomingMessage);
		Payment payment = (Payment) unmarshaller.unmarshal(reader);
		
		for(Payment.Request request : payment.getRequest()) {
			Audit audit = mapAudit(request);
			auditRepo.save(audit);
		}
	}

	private Audit mapAudit(Request request) {
		Audit audit = new Audit (null, request.getRequestId(), request.getOriginId(), request.getSomeId(), request.getCode(),
				new Date(), request.getCode(), request.getFrom().getFirstName(), request.getFrom().getLastName(), 
				request.getFrom().getAcnum(), request.getFrom().getBranch(), request.getFrom().getType(), request.getTo().getFirstName(), 
				request.getTo().getLastName(), request.getTo().getAcnum(), request.getTo().getBranch(), request.getTo().getType(), request.getAmount());
		return audit;
	}

}
