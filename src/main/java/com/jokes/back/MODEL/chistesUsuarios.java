package com.jokes.back.MODEL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class chistesUsuarios {
    @Id
    @GeneratedValue
    public Integer id;
    public String texto;
    public Integer usuario;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Integer getUser() {
        return usuario;
    }
    public void setUser(Integer usuario) {
        this.usuario = usuario;
    }
    
}
