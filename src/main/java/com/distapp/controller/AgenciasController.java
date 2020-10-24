package com.distapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.distapp.model.Agencia;
import com.distapp.services.AgenciaService;


@Controller
@RequestMapping("/agencias")
public class AgenciasController {
	
	//http://localhost:9898/agencias/
	
	@Autowired
	private AgenciaService service;

	
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Agencia> lista = service.findAll();
		
		System.out.println("Estoy en el controller...");
		for (Agencia agencia : lista) {
			System.out.println(agencia.getId()+"-"+agencia.getNombre());
		}
		
		model.addAttribute("titulo", "Lista de Agencias");
		model.addAttribute("agencias", lista);
		
		return "/agencias/index";
	}
	
	@GetMapping("/agencias/create")
	public String create(Agencia a) {		
		service.create(a);
		return "create";
	}
	
	
}
