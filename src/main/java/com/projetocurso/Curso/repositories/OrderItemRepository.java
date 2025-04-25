package com.projetocurso.Curso.repositories;

import com.projetocurso.Curso.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
