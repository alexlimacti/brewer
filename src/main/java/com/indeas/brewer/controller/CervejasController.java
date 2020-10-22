package com.indeas.brewer.controller;

import com.indeas.brewer.model.Cerveja;
import com.indeas.brewer.model.Origem;
import com.indeas.brewer.model.Sabor;
import com.indeas.brewer.repository.Cervejas;
import com.indeas.brewer.repository.Estilos;
import com.indeas.brewer.service.CadastroCervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

    @Autowired
    private Estilos estilos;

    @Autowired
    private CadastroCervejaService cadastroCervejaService;

    @Autowired
    private Cervejas cervejas;

    @RequestMapping("/novo")
    public ModelAndView novo(Cerveja cerveja) {
        ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("origens", Origem.values());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(cerveja);
        }

        cadastroCervejaService.salvar(cerveja);
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
        return new ModelAndView("redirect:/cervejas/novo");
    }

    @GetMapping
    public ModelAndView pesquisar() {
        ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("sabores", Sabor.values());
        mv.addObject("origens", Origem.values());
        mv.addObject("cervejas", cervejas.findAll());
        return mv;
    }

}
