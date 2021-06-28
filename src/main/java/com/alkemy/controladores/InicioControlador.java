package com.alkemy.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.entidades.AutenticacionRequest;
import com.alkemy.entidades.AutenticacionResponse;
import com.alkemy.servicios.MyUserDetailsService;
import com.alkemy.util.JwtUtil;

@RestController
public class InicioControlador {
	
	@Autowired
	private AuthenticationManager authenticacionManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping("/inicio")
	public String inicio() {
		return "se ha autenticado";
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> crearTokenDeAutenticacion(@RequestBody AutenticacionRequest autenticacionRequest) throws Exception{
		
		try {
			authenticacionManager.authenticate(
					new UsernamePasswordAuthenticationToken(autenticacionRequest.getUsername(), autenticacionRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Username o Password Incorrectas", e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(autenticacionRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AutenticacionResponse(jwt));
	}

}
