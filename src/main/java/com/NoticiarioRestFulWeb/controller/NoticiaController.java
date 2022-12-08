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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NoticiarioRestFulWeb.dto.NoticiaDTO;
import com.NoticiarioRestFulWeb.model.Noticia;
import com.NoticiarioRestFulWeb.service.NoticiaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/noticias")
public class NoticiaController {

	private final NoticiaService noticiaService;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<NoticiaDTO>> findAll(){
		List<NoticiaDTO> dtos =  noticiaService.findAll();
		return new ResponseEntity<List<NoticiaDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<NoticiaDTO> findId(@PathVariable Long id){
		NoticiaDTO dto = noticiaService.findId(id);
		return new ResponseEntity<NoticiaDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/paginacao")
	public ResponseEntity<Page<NoticiaDTO>> paginacao(Pageable pageable){
		Page<NoticiaDTO> page = noticiaService.paginar(pageable);
		return new ResponseEntity<Page<NoticiaDTO>>(page, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		noticiaService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<NoticiaDTO> save(@RequestBody Noticia noticia){
		NoticiaDTO noticiaDTO = noticiaService.save(noticia);
		return new ResponseEntity<NoticiaDTO>(noticiaDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Noticia noticia){
		NoticiaDTO noticiaDTO = noticiaService.atualiza(id, noticia);
		return new ResponseEntity<NoticiaDTO>(noticiaDTO, HttpStatus.ACCEPTED);
	}
	
}
