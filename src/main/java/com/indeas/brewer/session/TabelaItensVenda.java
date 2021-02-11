package com.indeas.brewer.session;

import com.indeas.brewer.model.Cerveja;
import com.indeas.brewer.model.ItemVenda;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class TabelaItensVenda {

    private List<ItemVenda> itensVenda = new ArrayList<>();

    public BigDecimal getValorTotal(){
        return itensVenda.stream()
                .map(ItemVenda::getValorTotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void adicionarItem(Cerveja cerveja, Integer quantidade){
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setCerveja(cerveja);
        itemVenda.setQuantidade(quantidade);
        itemVenda.setValorUnitario(cerveja.getValor());
        itensVenda.add(itemVenda);
    }

}
