package com.jokes.back.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jokes.back.DAO.usuariosDAO;
import com.jokes.back.MODEL.respuesta;
import com.jokes.back.MODEL.usuarios;

@RestController
@RequestMapping("usuarios/")
public class usuariosREST {
    @Autowired
    private usuariosDAO usuarioDAO;

    @PostMapping()
    public String save(@RequestBody usuarios user) {
		try {
			if (user.getMail() != "" && user.getPass() != "") {
				usuarioDAO.save(user).getMail(); 
				return "Created";
			}
		} catch (Exception e) {
			return "hg"; 
		}
		return "hg";
        
    }

    @GetMapping()
    public List<usuarios> listar(){
		return usuarioDAO.findAll();
	}
	
    @GetMapping("login") 
	public respuesta validar(@RequestParam (required = false) String mail,@RequestParam (required = true) String password){
		respuesta rta = new respuesta(); 
		rta.setError("No se encontró el usuario");
		
		try { usuarios usuario = usuarioDAO.findFirstByMailAndPass(mail,password); 
				rta.setIdCreado(usuario.getId());
                rta.setError("Usuario encontrado");
		} catch (Exception e) { 
			rta.setError("Error en Login"); 
		} 
		return rta;
	}
}
