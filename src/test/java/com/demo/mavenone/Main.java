package com.demo.mavenone;
/*
2. Using Jackson library
Jackson is a high-performance library for processing JSON data in Java. It provides an ObjectMapper class for reading and writing JSON. The idea is to use the writeValue() method to serialize Java objects as JSON String and write the JSON to the supplied file. The following program demonstrates it:
*/
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
 
class Company {
    public String name;
    public int employees;
    public List<String> offices;
 
    public Company(String name, int employees, List<String> offices) {
        this.name = name;
        this.employees = employees;
        this.offices = offices;
    }
}
 
public class Main
{
    public static void main(String[] args)
    {
        Company companies = new Company("Google", 140000,
            Arrays.asList("Mountain View", "Los Angeles", "New York"));
 
        String path = "companies.json";
 
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(companies);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
