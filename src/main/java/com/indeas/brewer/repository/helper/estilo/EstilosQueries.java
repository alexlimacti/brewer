package com.indeas.brewer.repository.helper.estilo;

import com.indeas.brewer.model.Estilo;
import com.indeas.brewer.repository.filter.EstiloFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstilosQueries {
	
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
	
}
