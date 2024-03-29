package com.indeas.brewer.repository.helper.cidade;

import com.indeas.brewer.model.Cidade;
import com.indeas.brewer.repository.filter.CidadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadesQueries {

	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);
	
}
