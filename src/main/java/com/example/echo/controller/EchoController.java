package com.example.echo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EchoController {

	@GetMapping
	public String getEcho (){
		return "Hello world, from Spring Boot with AWS and Sonar Cloud";				
	}
	
}