package com.demo.mavenone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
 
public class ReadJSONExample1 
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("WriteJsonDemo1.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            for(int i=0; i<employeeList.size();i++) {
            	Object obj1 = employeeList.get(i);
            	JSONObject jsonObject = (JSONObject) obj1;
            	//String key = (String) obj1;
            	//System.out.println("KEY = "+key);
            	parseEmployeeObject(jsonObject);
            }
            
            //Iterate over employee array
           // employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseEmployeeObject(JSONObject employee) 
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");
         
        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");    
        System.out.println(firstName);
         
        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");  
        System.out.println(lastName);
         
        //Get employee website name
        String website = (String) employeeObject.get("website");    
        System.out.println(website);
    }
}