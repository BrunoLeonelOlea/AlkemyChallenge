//package com.alkemy.servicios;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.alkemy.entidades.Usuario;
//import com.alkemy.repositorios.UsuarioRepositorio;
//
//@Service
//public class UsuarioServicio {
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private UsuarioRepositorio usuarioRepositorio;
//	
//	public Usuario findByUsername(String username) {
//		return usuarioRepositorio.findByUsername(username);
//	}
//	
//	public Usuario registrarUsuario(Usuario usuario) {
//		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//		return usuarioRepositorio.save(usuario);
//		
//	}
//
//}
