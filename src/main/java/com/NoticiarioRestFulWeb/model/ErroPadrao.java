package com.NoticiarioRestFulWeb.model;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErroPadrao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}