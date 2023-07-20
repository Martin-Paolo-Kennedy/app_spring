package com.martin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.martin.entity.Cliente;
import com.martin.services.ClienteServices;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteServices servCli;
	
	@RequestMapping("/grabar")
	public String registrarCliente(@RequestParam("nombre") String nom,
			@RequestParam("paterno") String pat,@RequestParam("materno") String mat,
			@RequestParam("dni") String dni, @RequestParam("email") String email,
			@RequestParam("nacimiento")String fec, @RequestParam("celular")int cel,
			@RequestParam("direccion")String direc,@RequestParam("sexo")String sex,
			RedirectAttributes redirect) throws ParseException {
			

		Cliente cli = new Cliente();
		cli.setCodigo(0);
		cli.setNombre(nom);
		cli.setPaterno(pat);
		cli.setMaterno(mat);
		cli.setSexo(sex);
		cli.setDni(cel);
		cli.setCorreo(email);
		cli.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
		cli.setCelular(cel);
		cli.setDireccion(direc);
		
			//invocar al método registrarr
			servCli.Registrar(cli);
			//crear un atributo
			redirect.addFlashAttribute("MENSAJE","Cliente registrado");
		return "redirect:/usuario/validar";
	}
	@PostMapping("/grabarCliente")
	public String guardarSolicitante(@RequestParam("nombre") String nom,
			@RequestParam("codigo")Integer cod,
			@RequestParam("paterno") String pat,@RequestParam("materno") String mat,
			@RequestParam("dni") String dni, @RequestParam("email") String email,
			@RequestParam("nacimiento")String fec, @RequestParam("celular")int cel,
			@RequestParam("direccion")String direc,@RequestParam("sexo")String sex,
			RedirectAttributes redirect) throws ParseException {
			

		Cliente cli = new Cliente();
		cli.setCodigo(0);
		cli.setNombre(nom);
		cli.setPaterno(pat);
		cli.setMaterno(mat);
		cli.setSexo(sex);
		cli.setDni(cel);
		cli.setCorreo(email);
		cli.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
		cli.setCelular(cel);
		cli.setDireccion(direc);
		if(cod==0) {
			//invocar al método registrarr
			servCli.Registrar(cli);
			//crear un atributo
			redirect.addFlashAttribute("MENSAJE","Cliente registrado");
		}
		else {
			//setear el código del objeto med
			cli.setCodigo(cod);
			//invocar al método actualizar
			servCli.actualizar(cli);
			//crear un atributo
			redirect.addFlashAttribute("MENSAJE","Cliente actualizado");					
		}
		return "redirect:/cliente/lista";
	}
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaCliente",servCli.listarTodos());
		return "cliente";
	}

	@RequestMapping("/buscar")
	@ResponseBody//--- para convertir en JSON el objeto retornado 
	public Cliente buscarPorID(@RequestParam("codigo") Integer cod) {
		return servCli.buscarPorID(cod);
	}
	
	//ruta para eliminar medicamento por su código
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servCli.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Cliente eliminado");
		
		return "redirect:/cliente/lista";
	}
}
