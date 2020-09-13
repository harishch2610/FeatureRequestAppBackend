package com.webservice.beans;

import com.webservice.entities.FeatureRequest;

public class FeatureResponseBody {
	
	private FeatureRequest featureRequest;
	
	private String success;

	public FeatureRequest getFeatureRequest() {
		return featureRequest;
	}

	public void setFeatureRequest(FeatureRequest featureRequest) {
		this.featureRequest = featureRequest;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}
