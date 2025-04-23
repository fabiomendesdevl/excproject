package com.projetocurso.Curso.repositories;

import com.projetocurso.Curso.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
