package com.projetocurso.Curso.repositories;

import com.projetocurso.Curso.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
