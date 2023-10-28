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

import py.com.distapp.domain.UnidadMedida;
import py.com.distapp.service.UnidadMedidaService;

//La anotación @Controller indica que la clase es un bean controlador y nos ahorra el trabajo 
//de definir en XML el bean correspondiente. Con @RequestMapping asociamos una URL 
//a este controlador.
@Controller
@RequestMapping("/unidadesMedidas")
public class UnidadesMedidasController {
	
	//http://localhost:9898/unidadesmedidas/index
	
	//inyeccion de dependencia
	@Autowired
	private UnidadMedidaService service;
	
	@GetMapping(path= "")
	public String index(Model model) {
		System.out.println("Estoy en el controller UnidadesMedidas/list...");
		List<UnidadMedida> lista = service.findAll();
		
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("unidadesMedida", lista);
		
		return "/unidadesMedidas/list";
	}
	
	
	@GetMapping("/create")
	public String create(Model model) {
		System.out.println("Estoy en el controller UnidadesMedida/create...");
		UnidadMedida entity = new UnidadMedida();
		model.addAttribute("unidadMedida", entity);
		return "unidadesMedidas/create";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid UnidadMedida unidadMedida, BindingResult result, Model model) {
		System.out.println("Estoy en el controller UnidadesMedida/save...");
		
		if(result.hasErrors()) { return "unidadesMedidas/create"; }
		
		service.create(unidadMedida);
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("unidadesMedida", service.findAll());
		
		return "/unidadesMedidas/list";
	}
	

}
