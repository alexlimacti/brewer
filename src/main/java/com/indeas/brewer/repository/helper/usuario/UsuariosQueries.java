package com.indeas.brewer.repository.helper.usuario;

import com.indeas.brewer.model.Usuario;

import java.util.Optional;

public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	
}
