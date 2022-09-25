package com.NoticiarioRestFulWeb.exception;

import java.util.ArrayList;
import java.util.List;

import com.NoticiarioRestFulWeb.model.ErroPadrao;
import com.NoticiarioRestFulWeb.model.FieldErrorMessage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationError extends ErroPadrao {

	private static final long serialVersionUID = 1L;

	private List<FieldErrorMessage> errorMessages = new ArrayList<FieldErrorMessage>();

	public void addError(String fieldName, String message) {
		errorMessages.add(new FieldErrorMessage(fieldName, message));
	}

}
