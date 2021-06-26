package com.alkemy.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alkemy.entidades.Usuario;
import com.alkemy.servicios.UsuarioServicio;

@Controller
@RequestMapping("/private")
public class PrivateControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("/index")
	public String index(Authentication auth, HttpSession session) {
		String username = auth.getName();
		
		if (session.getAttribute("usuario") == null) {
			Usuario usuario = usuarioServicio.findByUsername(username);
			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);
		}
		
		return "index";
	}

}
