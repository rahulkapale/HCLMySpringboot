package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component("empinfo")
@ConfigurationProperties(prefix="emp.details")
@Data
public class EmployeeInfo {
	//spring bean properties	
	@Value("${emp.data.name}")
	private String name;
	private int age;
	private String addr;


	public EmployeeInfo() {
		System.out.println("EmployeeInfo:: 0 param construction::"+name);
	}
	
	public void setName(String name) {
		System.out.println(this.name);
		this.name=name;
		System.out.println("EmployeeInfo.setName()::"+name);
	}
	
	
	
	
	

	
	
	
}
