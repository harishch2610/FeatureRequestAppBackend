package com.webservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webservice.beans.FeatureRequestBody;
import com.webservice.beans.FeatureResponseBody;
import com.webservice.controllers.entityRepository.FeatureRequestRepository;
import com.webservice.entities.FeatureRequest;
import com.webservice.service.FeatureRequestService;

@Controller
public class FeatureRequestSearchController {
	
	@Autowired
	private FeatureRequestService featureRequest;
	
	@Autowired
	private FeatureRequestRepository featureRepo;
	
	@RequestMapping(method = RequestMethod.GET, value="/search")
	@ResponseBody
	public FeatureRequestBody getFeatureRequests(@RequestBody FeatureRequest fr){
		FeatureRequestBody fRB = new FeatureRequestBody();
		List <FeatureRequest> frList = new ArrayList<FeatureRequest>();
		try {
			frList = featureRepo.findAllRequestsByClient(fr.getClient());
			fRB.setFeatureRequest(frList);
			fRB.setSuccess("TRUE");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while searching");
			FeatureRequest frr = new FeatureRequest();
			fRB.setSuccess("FAIL");	
		}		
		return fRB;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/searchId")
	@ResponseBody
	public FeatureResponseBody getFeatureRequestbyId(@RequestBody FeatureRequest fr){
		FeatureResponseBody fRB = new FeatureResponseBody();
		FeatureRequest freq = new FeatureRequest();
		try {
			freq = featureRepo.findAllRequestsById(fr.getId());
			fRB.setFeatureRequest(freq);
			fRB.setSuccess("TRUE");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while searching");
			fRB.setSuccess("FAIL");	
		}		
		return fRB;
	}

}
