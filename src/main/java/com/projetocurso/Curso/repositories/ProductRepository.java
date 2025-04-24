package com.projetocurso.Curso.repositories;

import com.projetocurso.Curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
