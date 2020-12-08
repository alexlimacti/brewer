package com.indeas.brewer.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SegurancaController {


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@AuthenticationPrincipal User user) {
		ModelAndView mv;
		if (user != null) {
			mv = new ModelAndView("cerveja/CadastroCerveja");
			return mv;
		}
		mv = new ModelAndView("Login");
		return mv;
	}
	
}
