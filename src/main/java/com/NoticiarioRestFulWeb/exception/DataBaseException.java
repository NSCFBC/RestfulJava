package com.NoticiarioRestFulWeb.exception;

public class DataBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataBaseException(String nome) {
		super(nome);
	}
}
