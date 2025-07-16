 package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pInfo")
@Data
@ConfigurationProperties(prefix="per.info")
public class PersonInfo {
	//simple/wrapper type
	private Integer pid;
	private  String pname;
	//array type
	private String[] favColors;
	//List-Collection type
	private List<String> studies;
	//set-Collection type
	private Set<String> phoneNumbers;
	//Map-Collection type
	private Map<String,Object> idDetails;
	
	//HAS-A composition
	private JobDetails jobInfo;
}
