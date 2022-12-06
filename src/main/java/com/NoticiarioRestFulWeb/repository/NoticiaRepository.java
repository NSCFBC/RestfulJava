package com.NoticiarioRestFulWeb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NoticiarioRestFulWeb.model.Noticia;

@Transactional
@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

}
