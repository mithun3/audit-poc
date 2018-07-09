package com.router.poc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.router.poc.model.Payment;

public class AuditVal {
	
	public static void main(String[] args) throws JAXBException, IOException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Payment.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(readFile("C:\\code\\anz\\router-poc\\src\\main\\resources\\sample\\test.xml"));
		Payment person = (Payment) unmarshaller.unmarshal(reader);
		for(Payment.Request req : person.getRequest()) {
			System.out.println(req.toString());
		}
	}

	static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
}
