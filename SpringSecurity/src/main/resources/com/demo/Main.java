package com.demo;



@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class Main {
	@RequestMapping("/")
	String home() {
		return "hello springboot";
	}

	public static void main(String[] args) {
		
		SpringApplication.run(Main.class,args);

	}

}
