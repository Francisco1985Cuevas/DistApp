//Controller Kits
package com.distapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.distapp.model.Kits;
import com.distapp.services.KitsService;

@Controller
@RequestMapping("/kits")
public class KitsController {
	
	//http://localhost:9898/kits
	
	@Autowired
	private KitsService service;
	
	@GetMapping(path= "")
	public String index(Model model) {
		List<Kits> lista = service.findAll();
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("kits", lista);
		System.out.println("Estoy en el controller Kits...");
		return "/kits/list";
	}
	
	
	@GetMapping("/create")
	public String create(Model model) {
		Kits entity = new Kits();
		model.addAttribute("kit", entity);
		System.out.println("Estoy en el controller Kits/create...");
		return "kits/create";
		//return "/kits/create";
	}
	
	@PostMapping("/save")
	public String save(@Valid Kits kit, BindingResult result, Model model) {
		if(result.hasErrors()) { return "kits/create"; }
		
		service.create(kit);
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("kits", service.findAll());
		System.out.println("Estoy en el controller Kits/save...");
		return "/kits/list";
	}
	
	
}
