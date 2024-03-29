package com.indeas.brewer.controller;

import com.indeas.brewer.controller.page.PageWrapper;
import com.indeas.brewer.dto.CervejaDTO;
import com.indeas.brewer.model.Cerveja;
import com.indeas.brewer.model.Origem;
import com.indeas.brewer.model.Sabor;
import com.indeas.brewer.repository.Cervejas;
import com.indeas.brewer.repository.Estilos;
import com.indeas.brewer.repository.filter.CervejaFilter;
import com.indeas.brewer.service.CadastroCervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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
    public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result
            , @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("sabores", Sabor.values());
        mv.addObject("origens", Origem.values());
        PageWrapper<Cerveja> paginaWrapper = new PageWrapper<>(cervejas.filtrar(cervejaFilter, pageable)
                , httpServletRequest);
        mv.addObject("pagina", paginaWrapper);
        return mv;
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CervejaDTO> pesquisar(String skuOuNome) {
        return cervejas.porSkuOuNome(skuOuNome);
    }

}
