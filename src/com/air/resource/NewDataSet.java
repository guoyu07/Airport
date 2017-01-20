package com.air.resource;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@author Anjana
//This class is to parse the XML output 

@XmlRootElement(name = "NewDataSet")
public class NewDataSet {
	
	private List<Table> table;  
	
	@XmlElement(name="Table")
	public List<Table> getTable() {  
	    return table;  
	}  
	public void setTable(List<Table> table) {  
	    this.table = table;  
	}  
	  
}
