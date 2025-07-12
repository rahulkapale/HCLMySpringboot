package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component("custInfo")
@ConfigurationProperties(prefix="cust.info")
@Data
public class CustomerInfo {
	//spring bean properties	
	private String name;
	private int age;
	private String addr;
	private float billAmt;
	

	
	
	
}
