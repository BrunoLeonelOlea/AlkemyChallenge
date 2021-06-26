package com.alkemy.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicControlador {
	
	@GetMapping("/index")
	public String index() {
		return "logout";
	}
	

}
