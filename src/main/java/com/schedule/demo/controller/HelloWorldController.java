package com.schedule.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") // mapeia uma requisição, um caminho, basta colocar na url /hello
public class HelloWorldController {
	
	@GetMapping
	public String getHello() {
		return "Hello word!!!!";
	}
	
}
