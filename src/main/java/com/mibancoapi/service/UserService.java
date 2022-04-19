package com.mibancoapi.service;

import java.util.Optional;

import org.springframework.data.domain.*;

import com.mibancoapi.models.Usuario;

public interface UserService {
	public Iterable<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);

	public Optional<Usuario> findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
}
