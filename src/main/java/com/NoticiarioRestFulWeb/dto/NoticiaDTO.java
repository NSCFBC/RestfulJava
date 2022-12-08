package com.NoticiarioRestFulWeb.dto;

import java.io.Serializable;

import com.NoticiarioRestFulWeb.model.Noticia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticiaDTO implements Serializable {
	
	public NoticiaDTO(Noticia ntc) {
		this.conteudo = ntc.getConteudo();
		this.subtitulo = ntc.getSubtitulo();
		this.titulo = ntc.getTitulo();
	}
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String subtitulo;
	private String conteudo;
}
