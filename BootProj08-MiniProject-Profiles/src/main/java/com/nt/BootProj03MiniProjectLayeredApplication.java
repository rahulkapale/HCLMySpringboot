package com.nt;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollSystemController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjectLayeredApplication {
	@Bean(name="c3p0dDs")
	@Profile("uat")
	public ComboPooledDataSource createC3PODs() throws Exception{
		System.out.println("BootProj03MiniProjectLayeredApplication.createC3PODs()");
		ComboPooledDataSource cds= new ComboPooledDataSource();
		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/FREEPDB1");
		cds.setUser("ruser");
		cds.setPassword("root");
	
		return cds;
	}	
	public static void main(String[] args) {
		//get IOC Container
	ApplicationContext ctx=SpringApplication.run(BootProj03MiniProjectLayeredApplication.class, args);
	//get Controller class obj
	PayrollSystemController controller = ctx.getBean("controller",PayrollSystemController.class);
	//gather inputs from Enduser
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter desg1:");
	String desg1=sc.next().toUpperCase();
	System.out.println("Enter desg2:");
	String desg2=sc.next().toUpperCase();
	System.out.println("Enter desg3:");
	String desg3=sc.next().toUpperCase();
	//invoke method
	try {
			List<Employee> listEmps=controller.showEmpsDetailsByDesgs(desg1, desg2, desg3);
			/*for(Employee e:listEmps) {
				System.out.println(e);
			}*/
			
			//listEmps.forEach(emp->System.out.println(emp));  //java8  forEach syntax
			listEmps.forEach(System.out::println);                      //java8  forEach with method reference 
				}//try
	catch(SQLException se) {
		se.printStackTrace();
		System.out.println("Internal unknown problem");
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("Internal DB problem");
	}//cathch	
	
	//close container
	//sc.close();
	((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
