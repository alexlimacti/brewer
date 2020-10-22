package com.indeas.brewer.service.event.cerveja;

import com.indeas.brewer.storage.FotoStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CervejaListener {

    @Autowired
    private FotoStorage fotoStorage;

    @EventListener(condition = "#event.temFoto()")
    public void cervejaSalva(CervejaSalvaEvent event){
        fotoStorage.salvar(event.getCerveja().getFoto());
    }
}
