package com.NoticiarioRestFulWeb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.NoticiarioRestFulWeb.model.Usuario;

@Transactional
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String username);
	
	@Query("select u from Usuario u where u.email = ?1")
	Usuario findUserByLogin(String login);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true ,value = "update usuario set token = ?1 where email = ?2")
	void atualizaTokenUser(String token, String user);
}
