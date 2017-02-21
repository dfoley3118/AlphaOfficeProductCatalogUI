package com.soleng;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class ExampleIntegrationTest {

	@Test
	public void getDeployedUrlStatus() throws Exception {
		// setup
		String url = "http://140.86.32.144/AlphaProducts/viewrecords";

		HttpGet request = new HttpGet(url);
        request.addHeader("Content-Type", "text/html");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		//execute and assert
		assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
	}
}
