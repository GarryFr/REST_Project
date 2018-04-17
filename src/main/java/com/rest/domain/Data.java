package com.rest.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	
	@JsonProperty
	private List<Document> data;
	

	public void setData(List<Document> data) {

		this.data = data;

	}
	
	public List<Document> getData() {

		return data;
	}

}
