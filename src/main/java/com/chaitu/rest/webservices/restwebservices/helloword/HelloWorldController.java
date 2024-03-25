package com.chaitu.rest.webservices.restwebservices.helloword;



import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	@Autowired
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return"Hello World hai";
	}
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Hello World");
	}
	@GetMapping(path="/hello-world-bean/{name}")
	public HelloWorldBean helloworldBeanPath( @PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s",name ));
	}
	@GetMapping(path = "/hello-world-bean-Internationalized")
	public String helloworldBeanInternationalized() {
		
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//return "hai";
	}

}
