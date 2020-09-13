package com.webservice.controllers;

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

@Controller
public class FeatureRequestDeleteController {
	
	@Autowired
	private FeatureRequestRepository featureRepo;
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete")
	@ResponseBody
	public FeatureResponseBody deleteFeatureRequest(@RequestBody FeatureRequest fr) {
		FeatureResponseBody fRB = new FeatureResponseBody();
		try {
			featureRepo.deleteFeatureRequestById(fr.getId());
			fRB.setSuccess("TRUE");
		}catch(Exception ex) {
			ex.printStackTrace();
			fRB.setSuccess("FALSE");
			return fRB;
		}
		return fRB;
	}

}
