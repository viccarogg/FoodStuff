package com.revature.FoodStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;

@SpringBootTest
class FoodStuffApplicationTests {

    protected URL stringToUrl(String uri) throws MalformedURLException {
        return new URL(uri);
    }
    
	@Test
	public void testUsers()
	{  
		 HttpURLConnection connection = null;
		 String uri= "http://localhost:9090/api/users/42";
		 String strCompare = null;
		 String toCompare="{\"userId\":42,\"username\":\"Ryan\",\"password\":\"abc@123\",\"email\":\"deckt5@gmail.com\"}";
		 boolean result=false;
		  URL url;
		try {
			url = stringToUrl(uri);
			connection = (HttpURLConnection) url.openConnection();
	          connection.setRequestMethod("GET");
	          connection.setRequestProperty("Content-Type", "application/json; utf-8");
	          connection.setRequestProperty("Accept", "application/json");
	 connection.setDoOutput(true);
	          
	 
	 try(BufferedReader br = new BufferedReader(
			  new InputStreamReader(connection.getInputStream(), "utf-8"))) {
			    StringBuilder response = new StringBuilder();
			    String responseLine = null;
			    while ((responseLine = br.readLine()) != null) {
			        response.append(responseLine.trim());
			    }
			    System.out.println(response.toString());
			    strCompare = response.toString();
			}
	 
	          
	        // System.out.println("HERE " + connection.getInputStream().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//result=strCompare.equals(toCompare);
		 assertEquals(strCompare,toCompare);
		//assertTrue(result);	
	}
	
	@Test
	public void testPost()
	{  
		 HttpURLConnection connection = null;
		 String uri= "http://localhost:9090/api/posts/74";
		 String strCompare = null;
		 String toCompare="{\"postId\":74,\"content\":\"This is going to work i can just tell!\",\"title\":\"Wellington Porky Pork\",\"userId\":{\"userId\":7,\"username\":\"brian\",\"password\":\"pass\",\"email\":\"bmcd720@gmail.com\"},\"comments\":[{\"commentId\":98,\"userId\":7,\"post\":74,\"comments\":\"You rock brian\",\"flag\":0}],\"flag\":0}";
		 boolean result=false;
		  URL url;
		try {
			url = stringToUrl(uri);
			connection = (HttpURLConnection) url.openConnection();
	          connection.setRequestMethod("GET");
	          connection.setRequestProperty("Content-Type", "application/json; utf-8");
	          connection.setRequestProperty("Accept", "application/json");
	 connection.setDoOutput(true);
	          
	 
	 try(BufferedReader br = new BufferedReader(
			  new InputStreamReader(connection.getInputStream(), "utf-8"))) {
			    StringBuilder response = new StringBuilder();
			    String responseLine = null;
			    while ((responseLine = br.readLine()) != null) {
			        response.append(responseLine.trim());
			    }
			    System.out.println(response.toString());
			    strCompare = response.toString();
			}
	 
	          
	        // System.out.println("HERE " + connection.getInputStream().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//result=strCompare.equals(toCompare);
		 assertEquals(strCompare,toCompare);
		//assertTrue(result);	
	}

}
