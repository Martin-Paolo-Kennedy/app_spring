package com.martin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.dao.BoletaRepository;
import com.martin.dao.ProductoHasBoletaRepository;
import com.martin.entity.Boleta;
import com.martin.entity.ProductoHasBoleta;
import com.martin.entity.ProductoHasBoletaPK;

import jakarta.transaction.Transactional;

@Service
public class BoletaServices {

	@Autowired
	private BoletaRepository repoBol;
	@Autowired
	private ProductoHasBoletaRepository repoDet;
	
	@Transactional
	public void registrarBoleta(Boleta bean){
		try {
			//grabar cabecera
			repoBol.save(bean);
			//grabar detalle
			//bucle
			for(ProductoHasBoleta mhb:bean.getListaMedicamentoHasBoleta()) {
				//generar hashcode
				ProductoHasBoletaPK pk=new ProductoHasBoletaPK();
				pk.setNumeroBoleta(bean.getNumeroBoleta());
				pk.setCodigoProducto(mhb.getProductoH().getCodigo());
				//enviar "pk" dentro de mhb
				mhb.setPk(pk);
				//grabar
				repoDet.save(mhb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
