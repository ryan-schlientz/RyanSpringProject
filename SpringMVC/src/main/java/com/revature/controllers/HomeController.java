package com.revature.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello World!!!!!";
	}
	
	@RequestMapping(value="/characters", method = RequestMethod.GET)
	public String getCharacters() {
		//simulating retrieving all characters in the DB
		return "Peach Daisy Yoshi Mario";
	}
	
	@RequestMapping(value="/characters/{id}", method = RequestMethod.GET)
	public String getCharacter(@PathVariable("id") String id) {

		//Call some service with our ID to retrieve a specific character.
		//Simulation of our services
		return characterServiceGetCharacter(id);
	}
	
	private String characterServiceGetCharacter(String id) {
		
		String[] characters = {"Peach", "Daisy", "Yoshi", "Mario"};
		int num;
		if(id.matches("^[0-9]+"))
			num = Integer.parseInt(id);
		else num = 0;
		System.out.println(num);
		if(num >= 1 && num <= 4) {
			return characters[num - 1];
		} else {
			return "The character you are looking for is in another app";
		}
	}

}
