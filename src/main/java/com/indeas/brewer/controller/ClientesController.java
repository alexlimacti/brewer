package com.indeas.brewer.controller;

import com.indeas.brewer.model.TipoPessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@RequestMapping("novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		return mv;
	}
	
}
