package com.chaitu.rest.webservices.restwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	@GetMapping("/v1/person")
	public Person1 getFristVersionPerson(){
		
		return new Person1("Surya Ram Teja");
		
	}
	@GetMapping("/v2/person")
	public Person2 getSecondVersionPerson(){
		
		return new Person2(new Name("Surya Ram Teja","Kolluri"));
		
	}
	@GetMapping(path="/person",params="version=1")
	public Person1 getFristVersionPersonRequestParam(){
		
		return new Person1("Surya Ram Teja");
		
	}
	@GetMapping(path="/person",params="version=2")
	public Person2 getSecondVersionPersonRequestParam(){
		
		return new Person2(new Name("Surya Ram Teja","Kolluri"));
		
	}
	@GetMapping(path="/person/headers",headers="X-API-version=1")
	public Person1 getFristVersionPersonRequestheaders(){
		
		return new Person1("Surya Ram Teja");
		
	}
	@GetMapping(path="/person/headers",headers="X-API-version=2")
	public Person2 getSecondVersionPersonRequestheaders(){
		
		return new Person2(new Name("Surya Ram Teja","Kolluri"));
		
	}
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
	public Person1 getFristVersionPersonAcceptheaders(){
		
		return new Person1("Surya Ram Teja");
		
	}
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v2+json")
	public Person2 getSecondVersionPersonAcceptheaders(){
		
		return new Person2(new Name("Surya Ram Teja","Kolluri"));
		
	}
}
