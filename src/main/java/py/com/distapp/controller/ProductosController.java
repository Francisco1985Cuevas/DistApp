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

import py.com.distapp.domain.Marca;
import py.com.distapp.domain.Producto;
import py.com.distapp.domain.UnidadMedida;
import py.com.distapp.service.MarcaService;
import py.com.distapp.service.ProductoService;
import py.com.distapp.service.UnidadMedidaService;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private ProductoService service;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private UnidadMedidaService unidadMedidaService;
	
	@GetMapping("")
	public String index(Model model) {
		List<Producto> lista = service.findAll();
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("productos", lista);
		System.out.println("Estoy en el controller Productos/list...");
		return "/productos/list";
	}
	
	
	/*@GetMapping("/create")
	public String create(Model model) {
		Producto entity = new Producto();
		
		//list marcas
        List<Marca> listMarcas = marcaService.findAll();
        model.addAttribute("listMarcas", listMarcas);
        
        //list unidadesMedidas
        List<UnidadMedida> listUnidadMedida = unidadMedidaService.findAll();
        model.addAttribute("listUnidadMedida", listUnidadMedida);
        
		model.addAttribute("producto", entity);
		System.out.println("Estoy en el controller Productos/create...");
		return "productos/create";
	}*/
	
	@PostMapping("/save")
	public String save(@Valid Producto producto, BindingResult result, Model model) {
		if(result.hasErrors()) { return "productos/create"; }
		
		service.create(producto);
		model.addAttribute("titulo", "Listado Principal");
		model.addAttribute("productos", service.findAll());
		System.out.println("Estoy en el controller Productos/save...");
		return "/productos/list";
	}
	

}
