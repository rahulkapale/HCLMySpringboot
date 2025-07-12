package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.CustomerInfo;
import com.nt.beans.EmployeeInfo;

@SpringBootApplication
public class BootProj05ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj05ConfigurationPropertiesAnnotationApplication.class, args);
		//get spring bean clas obj
		CustomerInfo info=ctx.getBean("custInfo",CustomerInfo.class);
		//invoke the business method
		System.out.println("customer info obj data::"+info);
		System.out.println("===========================================");
		//get spring bean employee class obj
		EmployeeInfo einfo=ctx.getBean("empinfo",EmployeeInfo.class);
		System.out.println("Employee info obj data::"+einfo);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
