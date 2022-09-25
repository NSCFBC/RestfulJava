package com.NoticiarioRestFulWeb.exception;

import java.time.Instant;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.NoticiarioRestFulWeb.model.ErroPadrao;

@ControllerAdvice
public class HandleAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErroPadrao> executeExcepiton(NoSuchElementException erro, HttpServletRequest req) {
		ErroPadrao erroPadrao = populaErro(new ErroPadrao(), erro, req);
		erroPadrao.setError("Não existe informação com esse valor informado");
		erroPadrao.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		return new ResponseEntity<ErroPadrao>(erroPadrao, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErroPadrao> erroTipoLetraUrlFind(MethodArgumentTypeMismatchException erro,
			HttpServletRequest req) {
		ErroPadrao erroPadrao = populaErro(new ErroPadrao(), erro, req);
		erroPadrao.setError("Parametros inválidos");
		erroPadrao.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		return new ResponseEntity<ErroPadrao>(erroPadrao, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<ErroPadrao> exceuteDataBaseErro(DataBaseException erro, HttpServletRequest req) {
		ErroPadrao erroPadrao = populaErro(new ErroPadrao(), erro, req);
		erroPadrao.setStatus(HttpStatus.BAD_REQUEST.value());
		erroPadrao.setError("Erro. Violação de banco de dados");
		return new ResponseEntity<ErroPadrao>(erroPadrao, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErroPadrao> exceuteDataBaseErro(EmptyResultDataAccessException erro, HttpServletRequest req) {
		ErroPadrao erroPadrao = populaErro(new ErroPadrao(), erro, req);
		erroPadrao.setStatus(HttpStatus.BAD_REQUEST.value());
		erroPadrao.setError("Erro ao excluir dado");
		return new ResponseEntity<ErroPadrao>(erroPadrao, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ValidationError> categoriaNotFound(MethodArgumentNotValidException erro,
			HttpServletRequest req) {
		ValidationError erroPadrao = new ValidationError();
		erroPadrao.setTimestamp(Instant.now());
		erroPadrao.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		erroPadrao.setError("Formato inválido");
		erroPadrao.setMessage(erro.getMessage());
		erroPadrao.setPath(req.getRequestURI());

		for (FieldError error : erro.getBindingResult().getFieldErrors()) {
			erroPadrao.addError(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<ValidationError>(erroPadrao, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	public ErroPadrao populaErro(ErroPadrao erroPadrao, RuntimeException erro, HttpServletRequest req) {
		erroPadrao.setTimestamp(Instant.now());
		erroPadrao.setMessage(erro.getMessage());
		erroPadrao.setPath(req.getRequestURI());
		return erroPadrao;
	}
}