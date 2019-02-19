package com.service.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/


@Path("/colors")
public class UserServices {
	@GET
	@Path("/getColors")
	@Produces(MediaType.APPLICATION_JSON)
	/*@Produces(MediaType.TEXT_PLAIN)
	public String getColors(){
		return "Hello";
	}*/
	public ArrayList<MyPojo> Showall() throws FileNotFoundException, IOException, ParseException  {
		System.out.println("Inside updateUser 1");
		
		
		File jsonFile = new File("input.json");
		FileWriter fileWriter = new FileWriter(jsonFile);
		System.out.println(jsonFile.getAbsolutePath());
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print("{ \"colors\": [ { \"color\": \"black\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[255,255,255,1]\", \"hex\": \"#000\" } }, { \"color\": \"white\", \"category\": \"value\", \"code\": { \"rgba\": \"[0,0,0,1]\", \"hex\": \"#FFF\" } }, { \"color\": \"red\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[255,0,0,1]\", \"hex\": \"#FF0\" } }, { \"color\": \"blue\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[0,0,255,1]\", \"hex\": \"#00F\" } }, { \"color\": \"yellow\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[255,255,0,1]\", \"hex\": \"#FF0\" } }, { \"color\": \"green\", \"category\": \"hue\", \"type\": \"secondary\", \"code\": { \"rgba\": \"[0,255,0,1]\", \"hex\": \"#0F0\" } }, ] }");
	    printWriter.close();
	    
		
		
		JSONParser parser = new JSONParser();
	    JSONObject jo = (JSONObject) parser.parse(new FileReader(jsonFile.getAbsolutePath()));
		//JSONObject jo = (JSONObject) parser.parse(new FileReader("C:\\Users\\hp-pc\\workspace\\rest\\RESTfulWebService\\src\\com\\service\\user\\input.json"));
		//String abc= "src"+File.separator+"com"+File.separator+"service"+File.separator+"user"+File.separator;
//		String abc= "src\\com\\service\\user\\";
		String abc= "";
		/*JSONParser parser = new JSONParser();
		JSONObject jo = (JSONObject) parser
				.parse(new FileInputStream(abc+"input.json").);*/
		MyPojo color1;// = new MyPojo();
		ArrayList<MyPojo> data = new ArrayList<MyPojo>();
		
		JSONArray a = (JSONArray)jo.get("colors");
		
		System.out.println(a);
		System.out.println("ss");
		
		for (Object o : a) {
			color1 = new MyPojo();
			JSONObject colors = (JSONObject) o;
			JSONObject code = (JSONObject) colors.get("code");
			System.out.println((String) code.get("rgba"));
			color1.setRgba((String) code.get("rgba"));
			System.out.println((String) code.get("hex"));
			color1.setHex((String) code.get("hex"));
			String color = (String) colors.get("color");
			System.out.println(color);
			color1.setColor(color);
			String category = (String) colors.get("category");
			color1.setCategory(category);
			System.out.println(category);

			String type = (String) colors.get("type");
			color1.setType(type);
			System.out.println(type);
			data.add(color1);
		}
		return data;
	}
	
	@GET
	@Path("/getSingleColors/{varX}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<MyPojo> showSingleRecord(@PathParam("varX") String varX) throws FileNotFoundException, IOException, ParseException  {
		System.out.println("Inside getSingleColors"+varX+"-----");
		/*JSONParser parser = new JSONParser();
		
	    
		//JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\hp-pc\\workspace\\rest\\RESTfulWebService\\src\\input.json"));
				//JSONArray a = (JSONArray)((JSONArray) parser.parse(new FileReader("C:\\Users\\hp-pc\\workspace\\rest\\RESTfulWebService\\src\\com\\service\\user\\input.json")));
				//String path="/WEB-INF/input.json";
				//String rpath=getServletContext().getRealPath();
		
		JSONObject jo = (JSONObject) parser
				.parse(new FileReader("C:\\Users\\hp-pc\\workspace\\rest\\RESTfulWebService\\src\\com\\service\\user\\input.json"));*/

		File jsonFile = new File("input.json");
		FileWriter fileWriter = new FileWriter(jsonFile);
		System.out.println(jsonFile.getAbsolutePath());
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print("{ \"colors\": [ { \"color\": \"black\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[255,255,255,1]\", \"hex\": \"#000\" } }, { \"color\": \"white\", \"category\": \"value\", \"code\": { \"rgba\": \"[0,0,0,1]\", \"hex\": \"#FFF\" } }, { \"color\": \"red\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[255,0,0,1]\", \"hex\": \"#FF0\" } }, { \"color\": \"blue\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[0,0,255,1]\", \"hex\": \"#00F\" } }, { \"color\": \"yellow\", \"category\": \"hue\", \"type\": \"primary\", \"code\": { \"rgba\": \"[255,255,0,1]\", \"hex\": \"#FF0\" } }, { \"color\": \"green\", \"category\": \"hue\", \"type\": \"secondary\", \"code\": { \"rgba\": \"[0,255,0,1]\", \"hex\": \"#0F0\" } }, ] }");
	    printWriter.close();
	    
		
		
		JSONParser parser = new JSONParser();
	    JSONObject jo = (JSONObject) parser.parse(new FileReader(jsonFile.getAbsolutePath()));
		
		MyPojo color1;// = new MyPojo();
JSONArray a = (JSONArray)jo.get("colors");
		
		System.out.println(a);
		System.out.println("ss");
		ArrayList<MyPojo> data = new ArrayList<MyPojo>();
		for (Object o : a) {
			color1 = new MyPojo();
			
			JSONObject colors = (JSONObject) o;
			
			String color = (String) colors.get("color").toString();
			System.out.println(color);
			if(color.equals(varX))
			{
			
			
			color1.setColor(color);
			JSONObject code = (JSONObject) colors.get("code");
			System.out.println((String) code.get("rgba"));
			color1.setRgba((String) code.get("rgba"));
			System.out.println((String) code.get("hex"));
			color1.setHex((String) code.get("hex"));
			
			String category = (String) colors.get("category");
			color1.setCategory(category);
			System.out.println(category);

			String type = (String) colors.get("type");
			color1.setType(type);
			System.out.println(type);
			data.add(color1);
		}
			else
			{
				color1.setCategory("dataNotAvailable");
			}
		}
		return data;
	}
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException{
		UserServices us = new UserServices();
		String abc= "src"+File.separator+"com"+File.separator+"service"+File.separator+"user"+File.separator;
		JSONParser parser = new JSONParser();
		JSONObject jo = (JSONObject) parser
				.parse(new FileReader(abc+"input.json"));
		System.out.println(jo);
	}
}
