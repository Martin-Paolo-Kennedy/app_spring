package com.martin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.martin.entity.Categoria;
import com.martin.entity.Enlace;
import com.martin.entity.Producto;
import com.martin.entity.Rol;
import com.martin.entity.Usuario;
import com.martin.services.RolServices;
import com.martin.services.UsuarioServices;
@SessionAttributes({"datos","enlaces","codigoUsuario"})
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServices servUsu;
	
	@Autowired
	private RolServices servRol;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/validar")
	public String index() {
		
		return "login";
	}
	@RequestMapping("/intranet")
	public String intranet(Authentication auth,Model model) {
		String nomLogin=auth.getName();
		Usuario bean=servUsu.validarUsuario(nomLogin);
		List<Enlace> datos=servUsu.enlacesDelUsuario(bean.getRol().getCodigo());
		model.addAttribute("enlaces",datos);
		model.addAttribute("datos",bean.getApellido()+" "+bean.getNombre());
		model.addAttribute("codigoUsuario",bean.getIdUsuario());
		return "intranet";
	}
	
	@GetMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaUsuarios", servUsu.listarTodos());
		return "usuario";
	}
	
	@GetMapping("/agregar")
	public String agregar(Usuario usuario, Model model) {
		 model.addAttribute("rol", servRol.listarTodo());
		// model.addAttribute("profesores", serProfesor.listarProfesores());
		return "mantenimientoUsuario";
	}
	
	
	
	@PostMapping("/grabar")
	public String guardar(Usuario usuario) {
		servUsu.Registrar(usuario);
		return "redirect:/usuario/lista";
	}
	
	@GetMapping("/editar/{idUsuario}")
	public String editar(Usuario usuario, Model model) {
		usuario = servUsu.buscarPorID(usuario);
		model.addAttribute("rol", servRol.listarTodo());
		// model.addAttribute("profesores", serProfesor.listarProfesores());
		model.addAttribute("usuario", usuario);

		return "mantenimientoUsuario";
	}

	@GetMapping("/eliminar/{idUsuario}")
	public String eliminar(Usuario usuario,RedirectAttributes redirect) {
		servUsu.eliminar(usuario);
		redirect.addFlashAttribute("MENSAJE","Usuario eliminado");
		return "redirect:/usuario/lista";
	}
}
