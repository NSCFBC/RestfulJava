package com.NoticiarioRestFulWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.NoticiarioRestFulWeb.appContext.ApplicationContextLoad;
import com.NoticiarioRestFulWeb.appContext.BCryptComponent;
import com.NoticiarioRestFulWeb.dto.UsuarioDTO;
import com.NoticiarioRestFulWeb.exception.DataBaseException;
import com.NoticiarioRestFulWeb.model.Usuario;
import com.NoticiarioRestFulWeb.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UsuarioService implements UserDetailsService{
	
	private final UsuarioRepository usuarioRepository;
	private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		usuarios.forEach(user -> {
			usuarioDTOs.add(new UsuarioDTO(user));
		});
		return usuarioDTOs;
	}

	public UsuarioDTO findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(user -> new UsuarioDTO(user))
				.orElseThrow(() -> new NoSuchElementException("Erro ao buscar usuário informado"));
	}

	public Page<UsuarioDTO> paginacao(Pageable pageable) {
		Page<Usuario> page = usuarioRepository.findAll(pageable);
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		page.forEach(data -> usuarioDTOs.add(new UsuarioDTO(data)));
		Page<UsuarioDTO> page2 = new PageImpl<UsuarioDTO>(usuarioDTOs);
		return page2;
	}

	public UsuarioDTO save(Usuario usuario) {
		usuario.setSenha(BCryptComponent.getEncode().encode(usuario.getSenha()));
		Usuario usuario2 = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario2);
	}

	public void delete(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Não existe usuário com esse valor informado", 1);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação referencial ao excluir usuário informado");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = ApplicationContextLoad.getApplicationContext().getBean(UsuarioRepository.class).findByEmail(username);
		if (user == null) {
			logger.error("user encontrado" + username);
			throw new UsernameNotFoundException("Email não encontrado");
		}
		logger.info("user encontrado" + username);
		return user;
	}

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

}
