package com.air.resource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

//@author Anjana
//This IdeaUtil class is to write the common methods like parsing the response XML and generation of data accessed time stamp
public class IdeaUtil {

	public static List<Table> parseTheXML(String result){

		InputStream is = new ByteArrayInputStream(result.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));			
		JAXBContext jaxbContext;
		NewDataSet newDataSet = null;
		try {
			jaxbContext = JAXBContext.newInstance(NewDataSet.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
			newDataSet= (NewDataSet) jaxbUnmarshaller.unmarshal(br); 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newDataSet.getTable();
	}
	
	// This is to get Data Accessed Timestamp
	public static String getCurrentDate(){
		 DateFormat df = new SimpleDateFormat();
	       Date dateobj = new Date();
	       Calendar calobj = Calendar.getInstance();
	       return df.format(calobj.getTime());
	}
	
	public static String asString(JAXBContext pContext,Object pObject)	throws JAXBException {

		StringWriter sw = new StringWriter();

		Marshaller marshaller = pContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(pObject, sw);

		return sw.toString();
	}
}
