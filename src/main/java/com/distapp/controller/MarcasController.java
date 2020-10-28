//Controller Marcas
//@override: En Java se trabaja con clases y estas heredan sus métodos a otras clases, @override se 
//coloca delante un método heredado para sobrecargar (modificar) su comportamiento original.
//@Override Permite sobrescribir un método al momento que se hereda de una Interface en 
//Java. Esta anotación es opcional.
package com.distapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.distapp.model.Marca;
import com.distapp.services.MarcaService;

//La anotación @Controller indica que la clase es un bean controlador y nos ahorra el trabajo 
//de definir en XML el bean correspondiente. Con @RequestMapping asociamos una URL 
//a este controlador.
@Controller
@RequestMapping("/marcas")
public class MarcasController {
	
	//http://localhost:9898/marcas/index
	
	//@Autowired se trata de la anotación que permite inyectar unas dependencias con otras 
	//dentro de Spring.
	//Usamos @AutoWired a nivel de la propiedad que deseamos inyectar. Spring funciona como 
	//una mega factoria de objetos. Cada clase se registra para instanciar objetos con 
	//alguna de las anotaciones @Controller, @Service, @repository o @RestController.
	@Autowired
	private MarcaService service; //es como crear una nueva instancia de la Clase MarcaService
	
	//listado de registros
	//@GetMapping(path= "/marcas")
	@GetMapping(path= "")
	public String index(Model model) {
		List<Marca> lista = service.findAll();
				
		System.out.println("Estoy en el controller Marcas...");
		for (Marca marca : lista) {
			System.out.println(marca.getId()+"-"+marca.getNombre());
		}
		
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("marcas", lista);
		
		return "/marcas/list";
	}
	
	//crear registro
	@GetMapping("/create")
	public String create(Model model) {
		Marca entity = new Marca();
		model.addAttribute("marca", entity);
		System.out.println("Llamando a create...");
		return "marcas/create";
	}
	
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String save(@Valid Marca marca, BindingResult result, Model model) {//save(@ModelAttribute("marca") Marca marca) {
		System.out.println("Estoy en el controller...");
		if(result.hasErrors()) { return "marcas/create"; }
		
		service.create(marca);
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("marcas", service.findAll());
		return "/marcas/list";
	}
	
	//update registro
	@GetMapping("/edit/{id}")
	public String update(@PathVariable(name = "id") long id, Model model) {
		Marca marca = service.findById(id);
		model.addAttribute("marca", marca);
		System.out.println("Estoy en el controller/edit...");
		//return "/marcas/edit";
		return "/marcas/edit";
	}
	
	@PostMapping("/update")
	public String update(@Valid Marca marca, BindingResult result, Model model) {
		System.out.println("Estoy en el update...");
		if(result.hasErrors()) { return "marcas/create"; }
		
		service.update(marca);
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("marcas", service.findAll());
		return "/marcas/list";
	}
	
	//delete registro
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id, Model model) {
		Marca marca = service.findById(id);
		model.addAttribute("marca", marca);
		System.out.println("Estoy en el controller/delete...");
		return "/marcas/delete";
	}
	//NO BORRA
	@PostMapping("/destroy")
	public String destroy(@Valid Marca marca, BindingResult result, Model model) {
		if(result.hasErrors()) { return "marcas/delete"; }
		System.out.println("Estoy en el controller/destroy...");
		
		service.delete(marca);
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("marcas", service.findAll());
		return "/marcas/list";
	}
	
	
	
	@GetMapping(path= "/prueba")
	public String prueba(Model model) {
		model.addAttribute("title", "SSSSSS");
		return "/p_helloform";
	}
	
	
}
