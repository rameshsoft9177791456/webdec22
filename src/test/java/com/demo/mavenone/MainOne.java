/*package com.demo.mavenone;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONObject;


public class MainOne {
	public static void main(String[] args)
    {
        String path = "/app/json/companies.json";
 
        JSONObject json = new JSONObject();
        try {
            json.put("name", "Google");
            json.put("employees", 140000);
            json.put("offices", List.of("Mountain View", "Los Angeles", "New York"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/