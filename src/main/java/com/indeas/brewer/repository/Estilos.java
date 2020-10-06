package com.indeas.brewer.repository;

import com.indeas.brewer.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {
}
