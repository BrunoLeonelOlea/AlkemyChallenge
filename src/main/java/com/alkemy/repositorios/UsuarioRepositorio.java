package com.alkemy.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
}
