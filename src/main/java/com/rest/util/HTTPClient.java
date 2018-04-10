package com.rest.util;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Service
public class HTTPClient {
	
	
	OkHttpClient client = new OkHttpClient();

	public String doGetRequest(String url) throws IOException {
		
		Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
		return response.body().string();

	}

}
