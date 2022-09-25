package com.NoticiarioRestFulWeb.dto;

import java.io.Serializable;

import com.NoticiarioRestFulWeb.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String nome;
	private String senha;

	public UsuarioDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
}
