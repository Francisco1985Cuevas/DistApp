package py.com.distapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.distapp.domain.Proveedor;
import py.com.distapp.service.ProveedorService;

//La anotación @Controller indica que la clase es un bean controlador y nos ahorra el trabajo 
//de definir en XML el bean correspondiente. Con @RequestMapping asociamos una URL 
//a este controlador.
@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	
	//NO FUNCIONA EL SAVE
	
	//http://localhost:9898/proveedores/
	
	//inyeccion de dependencia
	@Autowired
	private ProveedorService service;
	
	@GetMapping(path= "")
	public String index(Model model) {
		System.out.println("Estoy en el controller Proveedores/list...");
		List<Proveedor> lista = service.findAll();
		
		model.addAttribute("titulo", "Lista de Proveedores");
		model.addAttribute("proveedores", lista);
		
		return "/proveedores/list";
	}
	
	
	
	//@GetMapping(path= "/create")
	@GetMapping("/create")
	public String create(Model model) {
		Proveedor entity = new Proveedor();
		model.addAttribute("proveedor", entity);
		System.out.println("Estoy en el controller Proveedores/create...");
		return "/proveedores/create";
	}
	
	@PostMapping("/save")
	public String save(@Valid Proveedor proveedor, BindingResult result, Model model) {
		System.out.println("Estoy en el controller Proveedores/save...");
		if(result.hasErrors()) {
			return "proveedores/create";
		}
		
		service.create(proveedor);
		model.addAttribute("titulo", "Lista de Proveedores");
		model.addAttribute("proveedores", service.findAll());

		return "/proveedores/list";
	}
	
	

}
