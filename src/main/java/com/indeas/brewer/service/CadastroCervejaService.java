package com.indeas.brewer.service;

import com.indeas.brewer.model.Cerveja;
import com.indeas.brewer.repository.Cervejas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCervejaService {

	@Autowired
	private Cervejas cervejas;

	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
	}
}
