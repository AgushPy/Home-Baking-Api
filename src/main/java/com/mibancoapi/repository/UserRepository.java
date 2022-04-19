package com.mibancoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mibancoapi.models.Usuario;

import lombok.NonNull;


@Repository @NonNull
public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	
}
