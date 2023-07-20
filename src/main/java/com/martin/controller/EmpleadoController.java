package com.martin.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.martin.entity.Empleado;
import com.martin.entity.Rol;
import com.martin.services.EmpleadoServices;
import com.martin.services.RolServices;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoServices servEmp;
	@Autowired
	private RolServices servRol;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaEmpleado",servEmp.listarTodo());
		model.addAttribute("listaRol",servRol.listarTodo());
		return "empleado";
	}
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") Integer cod,
							@RequestParam("apellido") String ape,
							@RequestParam("nombre") String nom,
							@RequestParam("dni") int dni,
							@RequestParam("fecha") String fech,
							@RequestParam("telefono") int cel,
							@RequestParam("rol") int codRol,
							RedirectAttributes redirect) {
		try {
			//crear objeto de la entidad Medicamento
			Empleado emp=new Empleado();
			//setear
			emp.setApellido(ape);
			emp.setNombre(nom);
			emp.setDni(dni);
			emp.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fech));
			emp.setTelf(cel);
			//crear objeto de la entidad TipoMedicamento 
			Rol ro=new Rol();
			//setear codigo
			ro.setCodigo(codRol);
			//enviar objeto "tm" al objeto "med"
			emp.setRol(ro);
			//valida cod
			if(cod==0) {
				//invocar al método registrarr
				servEmp.registrar(emp);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Empleado registrado");
			}
			else {
				//setear el código del objeto med
				emp.setCodigo(cod);
				//invocar al método actualizar
				servEmp.actualizar(emp);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Empleado actualizado");					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/empleado/lista";
	}
	@RequestMapping("/buscar")
	@ResponseBody//--- para convertir en JSON el objeto retornado 
	public Empleado buscarPorID(@RequestParam("codigo") Integer cod) {
		return servEmp.buscarPorID(cod);
	}
	
	//ruta para eliminar medicamento por su código
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servEmp.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Empleado eliminado");
		
		return "redirect:/empleado/lista";
	}
}
