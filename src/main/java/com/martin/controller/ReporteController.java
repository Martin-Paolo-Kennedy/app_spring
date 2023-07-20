package com.martin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martin.services.BoletaServices;
import com.martin.services.ClienteServices;
import com.martin.services.EmpleadoServices;
import com.martin.services.ProductoServices;
import com.martin.services.UsuarioServices;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	@Autowired
	private ProductoServices servPro;
	
	@Autowired
	private BoletaServices servBol;
	
	@Autowired
	private UsuarioServices servUsu;
	
	@Autowired
	private ClienteServices servCli;
	
	@Autowired
	private EmpleadoServices servEmp;
	
	@GetMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaEmpleado",servEmp.listarTodo());
		model.addAttribute("listaCliente",servCli.listarTodos());
		model.addAttribute("listaProducto",servPro.listarTodos());
		model.addAttribute("listaUsuarios", servUsu.listarTodos());
		return "reporte";
	}
}
