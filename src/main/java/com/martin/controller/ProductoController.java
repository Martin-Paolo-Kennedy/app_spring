package com.martin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.martin.entity.Categoria;
import com.martin.entity.Producto;
import com.martin.services.CategoriaServices;
import com.martin.services.ProductoServices;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoServices servPro;
	@Autowired
	private CategoriaServices servCat;
	
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaProducto",servPro.listarTodos());
		model.addAttribute("listaCategoria",servCat.listarTodos());
		return "producto";
	}
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") Integer cod,
							@RequestParam("descripcion") String des,
							@RequestParam("stock") int sto,
							@RequestParam("precio") double pre,
							@RequestParam("categoria") int codCat,
							RedirectAttributes redirect,
							ModelMap model) {
		try {
			
			//crear objeto de la entidad Medicamento
			Producto pro=new Producto();
			//setear
			pro.setDescripcion(des);
			pro.setPre_pro(pre);
			pro.setStock(sto);
			//crear objeto de la entidad TipoMedicamento 
			Categoria ca=new Categoria();
			//setear codigo
			ca.setCodigo(codCat);
			//enviar objeto "tm" al objeto "med"
			pro.setCatagoriaP(ca);
			//valida cod
			if(cod==0) {
				//invocar al método registrarr
				servPro.registrar(pro);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Producto registrado");
			}
			
			else {
				//setear el código del objeto med
				pro.setCodigo(cod);
				//invocar al método actualizar
				servPro.actualizar(pro);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Producto actualizado");					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/producto/lista";
	}
	@RequestMapping("/buscar")
	@ResponseBody//--- para convertir en JSON el objeto retornado 
	public Producto buscarPorID(@RequestParam("codigo") Integer cod) {
		return servPro.buscarPorID(cod);
	}
	
	//ruta para eliminar medicamento por su código
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		servPro.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Producto eliminado");
		
		return "redirect:/producto/lista";
	}
}
