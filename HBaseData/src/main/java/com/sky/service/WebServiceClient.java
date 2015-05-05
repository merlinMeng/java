//package com.sky.service;
//
//import java.io.StringReader;
//
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.transform.stream.StreamSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.client.core.WebServiceTemplate;
//
//public class WebServiceClient {
//	
//	private static final String MESSAGE ="<message xmlns=\"http://tempuri.org\">Hello World</message>";
//	
//	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
//
//	public void setDefaultUri(String defaultUri){
//		webServiceTemplate.setDefaultUri(defaultUri);
//	}
//	public void simpleSendAndReceive(){
//		StreamSource source = new StreamSource(new StringReader(MESSAGE));
//		StreamResult result = new StreamResult(System.out);
//		webServiceTemplate.sendSourceAndReceiveToResult(source, result);
//	}
//	
//	public void customSendAndReceive(){
//		StreamSource source = new StreamSource(new StringReader(MESSAGE));
//        StreamResult result = new StreamResult(System.out);
//        webServiceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/AnotherWebService",
//            source, result);
//	}
//	
//	
//}
