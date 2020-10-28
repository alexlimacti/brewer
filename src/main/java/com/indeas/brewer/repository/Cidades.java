package com.indeas.brewer.repository;

import java.util.List;

import com.indeas.brewer.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cidades extends JpaRepository<Cidade, Long> {

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
	
}
