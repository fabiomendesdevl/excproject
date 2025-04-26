package com.projetocurso.Curso.services;

import com.projetocurso.Curso.entities.Payment;
import com.projetocurso.Curso.entities.Product;
import com.projetocurso.Curso.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> findall(){
        return repository.findAll();
    }

    public Payment findById(Long id){
        Optional<Payment> obj = repository.findById(id);
        return obj.get();
    }
}
