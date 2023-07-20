package com.martin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.martin.entity.Enlace;
import com.martin.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	//select *from tb_usuario where login='a' and password='b'
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String vLogin);
	//select e.idenlace,e.descripcion,e.ruta from tb_rol_enlace re join
	//tb_enlace e on e.idenlace=re.idenlace where re.idrol=2;
	@Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
	public List<Enlace> traerEnlacesDelUsuario(int codigoRol);
	@Query("select u from Usuario u where u.rol.codigo=3")
	public List<Usuario> solicitantes();
	
	
	
	
	
	
	
}
