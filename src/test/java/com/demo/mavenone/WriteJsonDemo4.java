package com.demo.mavenone;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class WriteJsonDemo4 {
public static void main(String[] args) throws IOException {
	
	JSONObject employeeDetails = new JSONObject();
	employeeDetails.put("firstName", "Lokesh");
    employeeDetails.put("lastName", "Gupta");
    employeeDetails.put("website", "howtodoinjava.com");
    
    System.out.println(employeeDetails);
    
    FileWriter file = new FileWriter("WriteJsonDemo4.json");
    employeeDetails.writeJSONString(file);
	file.flush();
}
}
