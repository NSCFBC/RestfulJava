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

import com.NoticiarioRestFulWeb.dto.CategoriaDTO;
import com.NoticiarioRestFulWeb.model.Categoria;
import com.NoticiarioRestFulWeb.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	private final CategoriaService categoriaService;

	@GetMapping(value = "/")
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> categoriaDTOs = categoriaService.findAll();
		return new ResponseEntity<List<CategoriaDTO>>(categoriaDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
		CategoriaDTO categoriaDTO = categoriaService.findById(id);
		return new ResponseEntity<CategoriaDTO>(categoriaDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/paginacao")
	public ResponseEntity<Page<CategoriaDTO>> paginacao(Pageable pageable) {
		Page<CategoriaDTO> page = categoriaService.paginacao(pageable);
		return new ResponseEntity<Page<CategoriaDTO>>(page, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<CategoriaDTO>salvar(@RequestBody Categoria categoria){
		CategoriaDTO categoriaDTO = categoriaService.salvar(categoria);
		return new ResponseEntity<CategoriaDTO>(categoriaDTO, HttpStatus.CREATED);
	}
	
}
