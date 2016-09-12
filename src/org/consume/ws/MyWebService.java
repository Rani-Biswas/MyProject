package org.consume.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyWebService {
	
	public static void main(String[] args) {

	  try {

		URL url = new URL("http://202.153.34.169:8888/auth/?userid=dr54254&pwd=123456");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
	}
}//http://202.153.34.169:8888/auth/?userid=dr54254&pwd=123456
//http://localhost:8080/RESTfulExample/json/product/get

// http://202.153.34.169:8888/auth/?userid=dr124578&pwd=123456
// http://202.153.34.169:8888/auth/?userid=dr54254&pwd=123456

//https://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
