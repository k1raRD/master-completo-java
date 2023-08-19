package com.k1rard.bolsaideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.k1rard.bolsaideas.springboot.web.app.models.Usuario;

/**
 * @author k1rard
 */
@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	

	@GetMapping({"/","/index", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";		
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Alex");
		usuario.setApellido("Collado");
		usuario.setEmail("alexc@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Guzman", "andresg@mail.com"),
				new Usuario("Alex", "Collado", "alexc@mail.com"),
				new Usuario("Julio", "Perez", "julioP@mail.com"));
		return usuarios;
	}
} 	
