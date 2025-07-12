package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("lInfo")
@Data
public class LabTestsInfo {
	@Value("${lab.bloodProfilePrice}")
	private float bloodProflePrice;
	
	@Value("${lab.rtpcrPrice}")
	private float rtpcrPrice;
	
	@Value("${lab.echo2Dprice}")
	private float echo2DPrice;
}
