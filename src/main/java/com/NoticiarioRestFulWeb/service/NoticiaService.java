package com.NoticiarioRestFulWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.NoticiarioRestFulWeb.dto.NoticiaDTO;
import com.NoticiarioRestFulWeb.exception.DataBaseException;
import com.NoticiarioRestFulWeb.model.Noticia;
import com.NoticiarioRestFulWeb.repository.NoticiaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class NoticiaService {
	
	private final NoticiaRepository noticiaRepository;

	public List<NoticiaDTO> findAll() {
		List<Noticia> noticias = noticiaRepository.findAll();
		List<NoticiaDTO> noticiaDTOs = new ArrayList<NoticiaDTO>();
		noticias.forEach(ntc -> {noticiaDTOs.add(new NoticiaDTO(ntc));});
		return noticiaDTOs;
	}

	public NoticiaDTO findId(Long id) {
		// TODO Auto-generated method stub
		return noticiaRepository.findById(id).map(ntc -> new NoticiaDTO(ntc))
		.orElseThrow(() -> new NoSuchElementException("Não existe notícia com esse valor informado"));
	}

	public Page<NoticiaDTO> paginar(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Noticia> page = noticiaRepository.findAll(pageable);
		List<NoticiaDTO> usuarioDTOs = new ArrayList<NoticiaDTO>();
		page.forEach(ntc -> usuarioDTOs.add(new NoticiaDTO(ntc)));
		return new PageImpl<>(usuarioDTOs);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(Long id) {
		try {
			noticiaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Não existe notícia com esse valor informado", 1);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação referencial ao excluir notícia informado");
		}
	}

	public NoticiaDTO save(Noticia noticia) {
		Noticia not = noticiaRepository.save(noticia);
		return new NoticiaDTO(not);
	}

	public NoticiaDTO atualiza(Long id, Noticia noticia) {
		// TODO Auto-generated method stub
		return null;
	}

}
