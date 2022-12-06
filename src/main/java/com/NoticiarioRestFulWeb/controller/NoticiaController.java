package com.NoticiarioRestFulWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NoticiarioRestFulWeb.service.NoticiaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/noticia")
public class NoticiaController {

	private final NoticiaService noticiaService;
}
