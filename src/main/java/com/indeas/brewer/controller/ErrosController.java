package com.indeas.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrosController {

	@RequestMapping("/500")
	public String erroServidor() {
		return "500";
	}

	@GetMapping("/404")
	public String paginaNaoEncontrada() {
		return "404";
	}
	
}
