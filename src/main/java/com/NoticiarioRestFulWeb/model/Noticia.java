package com.NoticiarioRestFulWeb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "noticia")
public class Noticia implements Serializable{

	private static final long serialVersionUID = -3002592381585388456L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ntc")
	@EqualsAndHashCode.Include
	private Long id;
	
	private String titulo;
	private String subtitulo;
	private String conteudo;
	
	
}
