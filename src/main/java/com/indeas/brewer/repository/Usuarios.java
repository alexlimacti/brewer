package com.indeas.brewer.repository;

import java.util.List;
import java.util.Optional;

import com.indeas.brewer.model.Usuario;
import com.indeas.brewer.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findByCodigoIn(Long[] codigos);

}
