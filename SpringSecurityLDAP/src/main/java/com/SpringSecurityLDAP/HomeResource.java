package com.SpringSecurityLDAP;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeResource {
	
	@GetMapping("/")
  public String index() {
		return "Home Page";
	}
	
	
}
