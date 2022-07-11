package com.jokes.back.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jokes.back.DAO.chistesUsuariosDAO;
import com.jokes.back.DAO.usuariosDAO;
import com.jokes.back.MODEL.chistesUsuarios;

@RestController
@RequestMapping("chistesUsuarios/")
public class chistesUsuariosREST {
    @Autowired
    private chistesUsuariosDAO chistesUserDAO;
    @Autowired
    private usuariosDAO userDAO;

    @PostMapping()
    public Boolean save(@RequestBody chistesUsuarios chiste) {
        try {
            //usuarios user = userDAO.findFirstById(chiste.usuario);
            //chiste.setUser(user.getId());
            chistesUserDAO.save(chiste);
            return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
    @GetMapping()
    public List<chistesUsuarios> listar(@RequestParam Integer id){
        return chistesUserDAO.findAllByUsuario(id);
    }
    @GetMapping("random")
    public String consultar(){
              RestTemplate restTemplate = new RestTemplate();
              String chiste = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", String.class);
              System.out.println(chiste);
        return chiste;
    }
}
