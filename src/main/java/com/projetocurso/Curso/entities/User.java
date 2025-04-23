package com.projetocurso.Curso.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity                                                 //entidade de modelo de dominio - especificação do jpa
@Table(name = "tb_user")                                //colocando nome na tabela de banco dedados, pois, User é uma palavra reservada no banco de dados h2
public class User implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)        //auto incremento
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(){

    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
