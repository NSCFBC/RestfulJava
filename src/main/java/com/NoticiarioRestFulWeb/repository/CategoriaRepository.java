package com.NoticiarioRestFulWeb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NoticiarioRestFulWeb.model.Categoria;

@Transactional
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
