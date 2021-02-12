package com.indeas.brewer.session;

import com.indeas.brewer.model.Cerveja;
import com.indeas.brewer.model.ItemVenda;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<ItemVenda> itemVendaOptional = itensVenda.stream()
                .filter(i -> i.getCerveja().equals(cerveja))
                .findAny();
        ItemVenda itemVenda = null;
        if (itemVendaOptional.isPresent()) {
            itemVenda = itemVendaOptional.get();
            itemVenda.setQuantidade(itemVenda.getQuantidade() + quantidade);
        } else {
            itemVenda = new ItemVenda();
            itemVenda.setCerveja(cerveja);
            itemVenda.setQuantidade(quantidade);
            itemVenda.setValorUnitario(cerveja.getValor());
            itensVenda.add(0, itemVenda);
        }
    }

    public int totalItems(){
        return itensVenda.size();
    }

    public Object getItems() {
        return itensVenda;
    }
}
