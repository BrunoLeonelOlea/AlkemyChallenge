package com.alkemy.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alkemy.entidades.Usuario;
import com.alkemy.servicios.UsuarioServicio;

@Controller
public class LoginControlador {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "login";
	}
	
	@GetMapping("/auth/register")
	public String registroForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@PostMapping("/auth/register")
	public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "redirect:/auth/register";
		} else {
			model.addAttribute("usuario", usuarioServicio.registrarUsuario(usuario));
		}
		
		
		return "redirect:/auth/login";
	}
}
