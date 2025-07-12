package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
@Data
public class Hospital {
	@Value("KIMS")		//hard coding values
	private String name;
	@Value("5")	//hard coding values
	private int rank;
	
	
	@Value("${hsptl.name}")  //collecting from properties file
	private String name1;
	@Value("${hsptl.age}")	//collecting from properties file
	private int age;
	

	@Value("${os.name}")	//collecting from system property value
	private String os;	
	
	@Value("${Path}")	//collecting from env.. variable
	private String pathData;

//	@Autowired      //autowiring 
	@Value("#{lInfo}") 	// using SPEL performing enjection to obj type property
	private LabTestsInfo info;	//HAS-A property
	
	@Value("#{lInfo.bloodProflePrice + lInfo.rtpcrPrice + lInfo.echo2DPrice}") //SPEL based arithmetic operation & injection
	private float labTestBillsAmt;
}
