package com.indeas.brewer.repository;

import java.util.List;
import java.util.Optional;

import com.indeas.brewer.model.Cidade;
import com.indeas.brewer.model.Estado;
import com.indeas.brewer.repository.helper.cidade.CidadesQueries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);

	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
	
}
