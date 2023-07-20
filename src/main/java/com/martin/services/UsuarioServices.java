package com.martin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.dao.UsuarioRepository;
import com.martin.entity.Enlace;
import com.martin.entity.Usuario;

@Service
public class UsuarioServices {
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario validarUsuario(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	public List<Enlace> enlacesDelUsuario(int codRol){
		return repo.traerEnlacesDelUsuario(codRol);
	}
	public void Registrar (Usuario usuario) {
		 repo.save(usuario);
	}
	public void actualizar(Usuario u) {
		repo.save(u);
	}
	public void eliminar(Usuario usu) {
		repo.deleteById(usu.getIdUsuario());
	}
	public Usuario buscarPorID(Usuario usu) {
		return repo.findById(usu.getIdUsuario()).orElse(null);
	}
	public List<Usuario> listarTodos(){
		return repo.findAll();
	}
	
}





