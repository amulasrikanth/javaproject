package com.srikanth.Firstcontroller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Controllerr {
	
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView helloWorld() {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
		        "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY",
		        String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		Location staff1 = null;
		try {
			staff1 = mapper.readValue(response.toString(), Location.class);
			System.out.println(staff1);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
 
		String message = staff1.getLocation() ;
		return new ModelAndView("welcome", "message", message);
		
	}

}
