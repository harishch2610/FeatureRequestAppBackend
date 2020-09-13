package com.webservice.beans;

import java.util.List;

import com.webservice.entities.FeatureRequest;

public class FeatureRequestBody {
	
	private List<FeatureRequest> featureRequest;
	
	private String success;

	public List<FeatureRequest> getFeatureRequest() {
		return featureRequest;
	}

	public void setFeatureRequest(List<FeatureRequest> featureRequest) {
		this.featureRequest = featureRequest;
	}
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
	
}
