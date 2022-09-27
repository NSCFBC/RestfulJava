package com.NoticiarioRestFulWeb.dto;

import com.NoticiarioRestFulWeb.model.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

	private String nome;
	
	public CategoriaDTO(Categoria categoria) {
		this.nome = categoria.getNome();
	}
}
