package com.martin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.martin.entity.Boleta;
import com.martin.entity.Cliente;
import com.martin.entity.Detalle;
import com.martin.entity.Producto;
import com.martin.entity.ProductoHasBoleta;
import com.martin.entity.Usuario;
import com.martin.services.BoletaServices;
import com.martin.services.ClienteServices;
import com.martin.services.ProductoServices;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/boleta")
public class BoletaController {

	@Autowired
	private BoletaServices serBoleta;
	@Autowired
	private ClienteServices serCliente;
	@Autowired
	private ProductoServices serProducto;
	
	@RequestMapping("/lista")
	public String index(Model model) {
	
		return "boleta";
	}
	
	@RequestMapping("/listaClienteJSON")
	@ResponseBody
	public List<Cliente> listaClienteJSON(@RequestParam("apellido") String ape) {
		return serCliente.listaPorApellido(ape+"%");
	}
	
	@RequestMapping("/listaProductoJSON")
	@ResponseBody
	public List<Producto> listaProductoJSON(@RequestParam("descripcion") String des) {
		return serProducto.listarProductosPorDescripcion(des);
	}
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,@RequestParam("descripcion") String des,
							@RequestParam("precio") double pre,@RequestParam("cantidad") int can,
							HttpSession session) {
		//declarar un arreglo de obejtos de clase Detalle
		List<Detalle> lista=null;
		try {
			//validar si existe el atributo de tipo sesión "datos"
			if(session.getAttribute("datitos")==null)//no existe el atributo "datos"
				//crear el arreglo lista
				lista=new ArrayList<Detalle>();
			else//si existe el atributo "datos"
				//recuperar el atributo "datos" y guardarlo en lista
			lista=(List<Detalle>) session.getAttribute("datitos");
			
			//crear objeto de la clase Detalle con los valores de los parámetros del método adiconar
			Detalle det=new Detalle();
			det.setCodigo(cod);
			det.setDescripcion(des);
			det.setPrecio(pre);
			det.setCantidad(can);
			//adicionar objeto "det" dentro del arreglo "lista"
			lista.add(det);
			//crear o actualizar el atributo "datos"
			session.setAttribute("datitos", lista);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("cliente") String cli,@RequestParam("fecha") String fec,
						@SessionAttribute("codigoUsuario") int codUsu,HttpSession session){
		try {
			//crear objeto de la entidad Boleta
			Boleta bol=new Boleta();
			bol.setFechaEmision(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
			//separar	cli=5-Soto Mora Luis
			String sep[]=cli.split("-");
			//objeto de la entidad Cliente
			Cliente c=new Cliente();
			c.setCodigo(Integer.parseInt(sep[0]));
			bol.setCliente(c);
			bol.setMonto(1500);
			//objeto de la entidad Usuario
			Usuario u=new Usuario();
			u.setIdUsuario(codUsu);
			bol.setBoletaU(u);
			//detalle  ---> listaMedicamentoHasBoleta
			//arreglo de objetos de la entidad MedicamentoHasBoleta
			List<ProductoHasBoleta> data=new ArrayList<ProductoHasBoleta>();
			//recuperar atributo de tipo sesión "datos"
			List<Detalle> lista=(List<Detalle>) session.getAttribute("datitos");
			//bucle sobre ""lista
			for(Detalle d:lista) {
				ProductoHasBoleta mhb=new ProductoHasBoleta();
				//setear mhb con los valoes del objeto "d"
				mhb.setPrecio(d.getPrecio());
				//
				Producto m=new Producto();
				m.setCodigo(d.getCodigo());
				mhb.setProductoH(m);
				//enviar mhb al arreglo "data"
				data.add(mhb);
			}
			//adicionar objeto "data" dentro "bol"
			bol.setListaMedicamentoHasBoleta(data);
			//grabar boleta
			serBoleta.registrarBoleta(bol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/boleta/lista";
	}
	
	
}







