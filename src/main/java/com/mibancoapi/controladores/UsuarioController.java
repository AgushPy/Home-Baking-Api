package com.mibancoapi.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mibancoapi.models.*;
import com.mibancoapi.repository.UserRepository;
import com.mibancoapi.service.*;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/usuario/crear")
	public Usuario usuario(@RequestParam(value="nameUser",  defaultValue = "hola") String nameUser, @RequestParam(value="claveBanc",  defaultValue = "niam") String claveBanc){
		UsuarioServicioImpl usuario2= new UsuarioServicioImpl();
		Usuario usuarioCreado = (Usuario) usuario2.nuevoUsuario(nameUser,claveBanc);
		userService.save(usuarioCreado);
		return usuarioCreado ;
	}
	
	@RequestMapping("/usuario/iniciar")
		public String  ingreso(@RequestParam(value = "id", defaultValue = "1") Long id,@RequestParam(value="usuario" , defaultValue = "usuario") String usuarioName, @RequestParam(value = "clave" , defaultValue = "clave") String usuarioclave) {
			Optional<Usuario> user = userService.findById(id);
			UsuarioServicioImpl usuario2= new UsuarioServicioImpl();
			return usuario2.iniciarSesion(user,usuarioName,usuarioclave);
		}
	
	@RequestMapping("usuario/estado")
		public Usuario usuario() {
			Usuario nuevoUser = new Usuario();
			//if(nuevoUser.getLog() ==  true) {
				//return nuevoUser;
			//}
			return nuevoUser;
		}
}

