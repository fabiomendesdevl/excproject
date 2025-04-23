package com.projetocurso.Curso.repositories;

import com.projetocurso.Curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
