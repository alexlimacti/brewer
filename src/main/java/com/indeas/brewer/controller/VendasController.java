package com.indeas.brewer.controller;

import com.indeas.brewer.model.Cerveja;
import com.indeas.brewer.repository.Cervejas;
import com.indeas.brewer.session.TabelaItensVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private Cervejas cervejas;

    @Autowired
    private TabelaItensVenda tabelaItensVenda;

    @GetMapping("/nova")
    public String nova() {
        return "venda/CadastroVenda";
    }

    @PostMapping("/item")
    public ModelAndView adicionarItem(Long codigoCerveja) {
        Cerveja cerveja = cervejas.findById(codigoCerveja).orElse(null);
        tabelaItensVenda.adicionarItem(cerveja, 1);
        ModelAndView mv = new ModelAndView("venda/TabelaItensVenda");
        mv.addObject("itens", tabelaItensVenda.getItems());
        return mv;
    }

}
