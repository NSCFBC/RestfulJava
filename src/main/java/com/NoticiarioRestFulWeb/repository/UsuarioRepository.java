package com.NoticiarioRestFulWeb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NoticiarioRestFulWeb.model.Usuario;

@Transactional
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
