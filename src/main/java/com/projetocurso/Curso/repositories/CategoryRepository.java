package com.projetocurso.Curso.repositories;

import com.projetocurso.Curso.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
