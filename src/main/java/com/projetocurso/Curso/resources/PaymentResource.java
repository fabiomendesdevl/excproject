package com.projetocurso.Curso.resources;

import com.projetocurso.Curso.entities.Payment;
import com.projetocurso.Curso.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "payment")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        List<Payment> obj = service.findall();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable  Long id){
        Payment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
