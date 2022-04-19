package com.mibancoapi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mibancoapi.models.Usuario;
import com.mibancoapi.repository.UserRepository;


@Service
public class UsuarioServicioImpl implements UserService{
	//Injecta dependecia
	@Autowired
	private UserRepository userRepository;
	
	public Usuario nuevoUsuario(String nombre, String clave) {
		Usuario usuario = new Usuario();
		Long num = 1L;
		//usuario.setIdClient(num);
		usuario.setNombreUsuario(nombre);
		usuario.setClaveBancaria(clave);
		usuario.setSaldoCuenta(2020.20);
		//Random entre 99 y 25
		//Con esto se determina el cbu
		int claveRara = (int)(Math.random()*(99-25+1)+25);
		usuario.setCbu(claveRara);
		usuario.setLog(true);
		System.out.println("\n");
		System.out.println(usuario);
		System.out.println("\n");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		//userRepository.saveAll(usuarios);
		return usuario;
	}
	
	public String iniciarSesion(Usuario usuario,String nombre, String clave) {
		Usuario user = usuario;
		//String tag = usuario.getNombreUsuario();
		//String tagClave = usuario.getClaveBancaria();
		String responseServer = " ";
		if(user.isLog()) {
			usuario.setLog(true);
			return responseServer = "User Logeado";
		}else {
			usuario.setLog(false);
			return responseServer = "Comuniquese con su proveedor";
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return userRepository.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id){
		userRepository.deleteById(id);
	}
	
	
		
	
}
