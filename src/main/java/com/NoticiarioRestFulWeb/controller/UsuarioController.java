package com.NoticiarioRestFulWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NoticiarioRestFulWeb.dto.UsuarioDTO;
import com.NoticiarioRestFulWeb.model.Usuario;
import com.NoticiarioRestFulWeb.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/")
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> usuarioDTOs = usuarioService.findAll();
		return new ResponseEntity<List<UsuarioDTO>>(usuarioDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		UsuarioDTO usuarioDTO = usuarioService.findById(id);
		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
	}

	@GetMapping("/paginacao")
	public ResponseEntity<Page<UsuarioDTO>> paginacao(Pageable pageable) {
		Page<UsuarioDTO> page = usuarioService.paginacao(pageable);
		return new ResponseEntity<Page<UsuarioDTO>>(page, HttpStatus.OK);
	}

	@PostMapping(value = "/")
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody Usuario usuario) {
		UsuarioDTO usuarioDTO = usuarioService.save(usuario);
		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
