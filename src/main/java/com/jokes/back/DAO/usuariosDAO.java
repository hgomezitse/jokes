package com.jokes.back.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jokes.back.MODEL.usuarios;

public interface usuariosDAO extends JpaRepository<usuarios,Integer>{
    usuarios findFirstById(Integer id);
    usuarios findFirstByMailAndPass(String user, String pass);
}
