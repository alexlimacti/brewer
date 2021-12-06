package com.indeas.brewer.repository.helper.cliente;

import com.indeas.brewer.model.Cliente;
import com.indeas.brewer.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientesQueries {

	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);
	
}
