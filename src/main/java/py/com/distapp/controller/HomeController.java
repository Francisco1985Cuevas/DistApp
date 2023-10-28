package py.com.distapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
//@RequestMapping("/")
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("tituloTab", "DistApp - Inicio");
		model.addAttribute("tituloPrincipal", "Dashboard");

		Map<String, String> breadcrumbs = new HashMap<>();
		breadcrumbs.put("Inicio", "/");
		breadcrumbs.put("Dashboard", "/");
		model.addAttribute("breadcrumbs", breadcrumbs);

		return "admin/index";
	}

}
