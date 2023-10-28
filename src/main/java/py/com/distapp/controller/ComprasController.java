package py.com.distapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.distapp.domain.Compra;
import py.com.distapp.service.CompraService;

@Controller
@RequestMapping("/compras")
public class ComprasController {
	
	@Autowired
	private CompraService service;
	
	@GetMapping("")
	public String index(Model model) {
		List<Compra> lista = service.findAll();
		
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("compras", lista);
		System.out.println("Estoy en el controller Compras/list...");
		
		return "/compras/list";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		Compra entity = new Compra();
		model.addAttribute("compra", entity);
		System.out.println("Estoy en el controller Compras/create...");
		return "/compras/create";
	}

}
