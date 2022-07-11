package com.jokes.back.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jokes.back.MODEL.chistesUsuarios;

public interface chistesUsuariosDAO extends JpaRepository<chistesUsuarios,Integer>{
    List<chistesUsuarios> findAllByUsuario(Integer id);
}
