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

import com.NoticiarioRestFulWeb.dto.CategoriaDTO;
import com.NoticiarioRestFulWeb.exception.DataBaseException;
import com.NoticiarioRestFulWeb.model.Categoria;
import com.NoticiarioRestFulWeb.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService {

	@SuppressWarnings("unused")
	private final CategoriaRepository categoriaRepository;

	public List<CategoriaDTO> findAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();
		categorias.forEach(categoria -> categoriaDTOs.add(new CategoriaDTO(categoria)));
		return categoriaDTOs;
	}

	public CategoriaDTO findById(Long id) {
		return categoriaRepository.findById(id).map(data -> new CategoriaDTO(data))
				.orElseThrow(() -> new NoSuchElementException("Não existe dado com esse valor informado"));
	}

	public Page<CategoriaDTO> paginacao(Pageable pageable) {
		List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();
		Page<Categoria> pageCat = categoriaRepository.findAll(pageable);
		pageCat.forEach(cat -> categoriaDTOs.add(new CategoriaDTO(cat)));
		Page<CategoriaDTO> page = new PageImpl<CategoriaDTO>(categoriaDTOs);
		return page;
	}

	public void delete(Long id) {
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação referencial ao excluir dados");
		} catch (EmptyResultDataAccessException e) {
			throw new DataBaseException("Não há dados para serem excluidos");
		}
	}


	public CategoriaDTO salvar(Categoria categoria) {
		Categoria categoria2 = categoriaRepository.save(categoria);
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoria2);
		return categoriaDTO;
	}

}
