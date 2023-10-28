package py.com.distapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import py.com.distapp.model.dto.MarcaDTO;
import py.com.distapp.service.MarcaService;

import javax.validation.Valid;
import java.util.*;

/**
 * Controlador para gestionar las operaciones relacionadas con las marcas.
 * Este controlador maneja solicitudes relacionadas con la gestión de marcas, como
 * la creación, actualización y eliminación de marcas.
 */
@Controller
@RequestMapping("/marcas")
@Slf4j
public class MarcasController {
	@Autowired
	private MarcaService service;

	@GetMapping
	public String list(Model model) {
		try {
			model.addAttribute("tituloTab", "DistApp - Listado");
			model.addAttribute("tituloPrincipal", "Listado de Marcas");

			Map<String, String> breadcrumbs = new HashMap<>();
			breadcrumbs.put("Inicio", "/");
			breadcrumbs.put("Listado de Marcas", "/marcas/list");
			model.addAttribute("breadcrumbs", breadcrumbs);

			model.addAttribute("cardTitle", "Marcas");
			model.addAttribute("marcas", service.findAll());

			return "/marcas/list";
		} catch (Exception e) {
			log.error("Error en la petición de listado de Marcas: {}", e.getMessage());
			return null;
		}
	}






	@GetMapping("/get")
	public String get(Model model) {
		try {
			MarcaDTO marcaDTO = new MarcaDTO();
			model.addAttribute("marca", marcaDTO);
			model.addAttribute("tituloTab", "DistApp - Búsqueda");
			model.addAttribute("tituloPrincipal", "Buscar Marca por Id");
			return "marcas/search";
		} catch (Exception e) {
			log.error("Error en la petición de buscar marca por Id: {}", e.getMessage());
			return null;
		}
	}
	@PostMapping("/get")
	public String get(MarcaDTO marcaDTO, Model model) {
		try {
			model.addAttribute("marca", marcaDTO);
			model.addAttribute("tituloTab", "DistApp - Búsqueda");
			model.addAttribute("tituloPrincipal", "Buscar Marca por Id");
			MarcaDTO result = service.get(marcaDTO.getId());
			if (result != null) {
				model.addAttribute("result", result);
				Date fecha = new Date();
				model.addAttribute("fecha", fecha);
			}
			return "marcas/search";
		} catch (Exception e) {
			log.error("Error en la petición de buscar marca por Id: {}", e.getMessage());
			return null;
		}
	}

	@GetMapping("/getByNombre")
	public String getByNombre(Model model) {
		try {
			MarcaDTO marcaDTO = new MarcaDTO();
			model.addAttribute("marca", marcaDTO);
			model.addAttribute("tituloTab", "DistApp - Búsqueda");
			model.addAttribute("tituloPrincipal", "Buscar Marca por Nombre");
			return "marcas/searchByNombre";
		} catch (Exception e) {
			log.error("Error en la petición de buscar marca por Nombre: {}", e.getMessage());
			return null;
		}
	}
	@PostMapping("/getByNombre")
	public String getByNombre(MarcaDTO marcaDTO, Model model) {
		try {
			model.addAttribute("marca", marcaDTO);
			model.addAttribute("tituloTab", "DistApp - Búsqueda");
			model.addAttribute("tituloPrincipal", "Buscar Marca por Nombre");
			MarcaDTO result = service.getByNombre(marcaDTO.getNombre());
			if (result != null) {
				model.addAttribute("result", result);
				Date fecha = new Date();
				model.addAttribute("fecha", fecha);
			}
			return "marcas/searchByNombre";
		} catch (Exception e) {
			log.error("Error en la petición de buscar marca por Nombre: {}", e.getMessage());
			return null;
		}
	}





	/**
	 * Muestra formulario para crear un nuevo registro de Marca en el sistema.
	 * @param model Model.
	 * @return Formulario para crear Nuevo Registro.
	 *
	 * ¿Qué es Model en Spring?
	 * El Model es una variable cuyo ciclo de vida tiene validez durante la ejecución
	 * del servlet. Sirve para reemplazar los valores que tenga en la plantilla que
	 * uses (JSP, Thymeleaf, etc.) Una vez devuelta la respuesta al cliente
	 * HTTP, el Model se envía al recolector de basura.
	 * Este método usa una variable de tipo "Model" para comunicar datos entre el
	 * propio controlador y la vista. Esta comunicación se hace a través del
	 * método "addAttribute" que permite comunicar ambas partes.
	 */
	@GetMapping("/add")
	public String add(Model model) {
		MarcaDTO marcaDTO = new MarcaDTO();
		model.addAttribute("marcaDTO", marcaDTO);

		model.addAttribute("tituloTab", "DistApp - Crear Nuevo Registro");
		model.addAttribute("tituloPrincipal", "Crear Nuevo Registro");
		Map<String, String> breadcrumbs = new HashMap<>();
		breadcrumbs.put("Inicio", "/");
		breadcrumbs.put("Crear Nuevo Registro", "/marcas/add");
		model.addAttribute("breadcrumbs", breadcrumbs);

		model.addAttribute("cardTitle", "Crear Nuevo Registro");
		log.info("Get.MarcasController.add.marcaDTO");
		return "marcas/add";
	}

	/**
	 * Crea un nuevo registro de Marcas en el sistema.
	 * @param marcaDTO DTO que contiene la información de la nueva Marca.
	 * @return Si no hay ningún error se redirecciona al listado.
	 */
	@PostMapping("/add")
	public String add(@Valid MarcaDTO marcaDTO, BindingResult result, Model model) {
		log.info("Post.MarcasController.add.marcaDTO: {}", marcaDTO);
		log.info("Post.MarcasController.add.result: {}", result);
		log.info("Post.MarcasController.add.result.hasErrors: {}", result.hasErrors());
		log.info("Post.MarcasController.add.model: {}", model);


		if (result.hasErrors()) {
			//MarcaDTO dto = new MarcaDTO();
			model.addAttribute("marcaDTO", marcaDTO);

			model.addAttribute("tituloTab", "DistApp - Crear Nuevo Registro");
			model.addAttribute("tituloPrincipal", "Crear Nuevo Registro");
			Map<String, String> breadcrumbs = new HashMap<>();
			breadcrumbs.put("Inicio", "/");
			breadcrumbs.put("Crear Nuevo Registro", "/marcas/add");
			model.addAttribute("breadcrumbs", breadcrumbs);

			model.addAttribute("cardTitle", "Crear Nuevo Registro");
			log.error("Error en la validación: {}", result);
			return "marcas/add";
		}

		try {
			service.create(marcaDTO);

			model.addAttribute("tituloTab", "DistApp - Listado");
			model.addAttribute("tituloPrincipal", "Listado de Marcas");

			Map<String, String> breadcrumbs = new HashMap<>();
			breadcrumbs.put("Inicio", "/");
			breadcrumbs.put("Listado de Marcas", "/marcas/list");
			model.addAttribute("breadcrumbs", breadcrumbs);

			model.addAttribute("cardTitle", "Marcas");
			model.addAttribute("marcas", service.findAll());

			return "/marcas/list";
		} catch (Exception e) {
			log.error("Error en la petición para crear nueva Marca: {}", e.getMessage());
			return null;
		}
	}


	@GetMapping("/show/{id}")
	public String show(@PathVariable(name = "id") final Long id, final Model model) {
		try {
			model.addAttribute("tituloTab", "DistApp - Visualizar Registro");
			model.addAttribute("tituloPrincipal", "Visualizar Registro");
			//model.addAttribute("breadcrumbItem", "Visualizar");
			Map<String, String> breadcrumbs = new HashMap<>();
			breadcrumbs.put("Inicio", "/");
			breadcrumbs.put("Detalles de Marca", "/marcas/show/{id}");
			model.addAttribute("breadcrumbs", breadcrumbs);

			model.addAttribute("cardTitle", "Marca");

			MarcaDTO marcaDTO = service.get(id);
			model.addAttribute("result", marcaDTO);
			return "/marcas/show";
		} catch (Exception e) {
			log.error("Error en la petición visualizar marca: {}", e.getMessage());
			return null;
		}
	}





	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(name = "id") final Long id, final Model model) {
		try {
			model.addAttribute("tituloTab", "DistApp - Actualizar Registro");
			model.addAttribute("tituloPrincipal", "Actualizar Registro");
			model.addAttribute("breadcrumbItem", "Actualizar");
			model.addAttribute("cardTitle", "Marca");

			MarcaDTO marcaDTO = service.get(id);
			model.addAttribute("marca", marcaDTO);
			return "/marcas/edit";
		} catch (Exception e) {
			log.error("Error en la petición actualizar marca: {}", e.getMessage());
			return null;
		}
	}
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable(name = "id") final Long id,
			@Valid MarcaDTO marcaDTO, BindingResult result, Model model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("tituloTab", "DistApp - Actualizar Registro");
				model.addAttribute("tituloPrincipal", "Actualizar Registro");
				model.addAttribute("breadcrumbItem", "Actualizar");
				model.addAttribute("cardTitle", "Marca");

				return "marcas/edit";
			}

			service.update(id, marcaDTO);
			model.addAttribute("tituloTab", "DistApp - Listado");
			model.addAttribute("tituloPrincipal", "Listado");
			model.addAttribute("breadcrumbItem", "Listado");
			model.addAttribute("cardTitle", "Marcas");
			model.addAttribute("marcas", service.findAll());

			return "/marcas/list";

		} catch (Exception e) {
			log.error("Error en la petición actualizar marca: {}", e.getMessage());
			return null;
		}

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") final Long id, Model model) {
		try {
			model.addAttribute("tituloTab", "DistApp - Listado");
			model.addAttribute("tituloPrincipal", "Listado de Marcas");
			model.addAttribute("breadcrumbItem", "Listado de Marcas");
			model.addAttribute("cardTitle", "Marcas");
			service.delete(id);
			model.addAttribute("marcas", service.findAll());

			return "/marcas/list";
		} catch (Exception e) {
			log.error("Error en la petición eliminar marca: {}", e.getMessage());
			return null;
		}

	}

	/*
	@GetMapping
	public String list(Model model) {
		model.addAttribute("tituloTab", "DistApp - Listado");
		model.addAttribute("tituloPrincipal", "Listado");
		model.addAttribute("breadcrumbItem", "Listado");
		model.addAttribute("cardTitle", "Marcas");

		model.addAttribute("marcas", service.findAll());

		return "/marcas/list";
	}


	@GetMapping("/add")
	public String add(Model model) {
		Marca entity = new Marca();
		model.addAttribute("marca", entity);

		model.addAttribute("tituloTab", "DistApp - Crear Nuevo Registro");
		model.addAttribute("tituloPrincipal", "Crear Nuevo Registro");
		model.addAttribute("breadcrumbItem", "Nuevo");
		model.addAttribute("cardTitle", "Marca");

		return "marcas/add";
	}
	@PostMapping("/add")
	public String add(@Valid Marca marca, BindingResult result, Model model) {
		model.addAttribute("tituloTab", "DistApp - Crear Registro");
		model.addAttribute("tituloPrincipal", "Crear Nueva Marca");
		model.addAttribute("titulo", "Crear Nueva Marca");
		model.addAttribute("breadcrumbItem", "Crear marca");
		model.addAttribute("cardTitle", "Crear Nueva Marca");

		if (result.hasErrors()) {
			return "marcas/add";
		}
		
		service.create(marca);

		model.addAttribute("tituloTab", "DistApp - Listado");
		model.addAttribute("tituloPrincipal", "Listado");
		model.addAttribute("breadcrumbItem", "Listado");
		model.addAttribute("cardTitle", "Marcas");

		model.addAttribute("marcas", service.findAll());

		return "redirect:/marcas";
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
	*/

}
