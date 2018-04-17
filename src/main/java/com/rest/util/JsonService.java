package com.rest.util;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.domain.Data;

@Service
public class JsonService {

	public Data JsonDeserialisation(String jsonData) {

		Data data = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.readValue(jsonData, Data.class);
		
		} catch (IOException e) {

			e.printStackTrace();
		}
		return data;
	}

}
