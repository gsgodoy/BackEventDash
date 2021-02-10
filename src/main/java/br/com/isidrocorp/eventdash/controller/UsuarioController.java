package br.com.isidrocorp.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.isidrocorp.eventdash.dao.UsuarioDAO;
import br.com.isidrocorp.eventdash.model.Usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {
	
	@Autowired //indica a injeção de dependências 
	private UsuarioDAO dao;
	
//	@GetMapping("/usuarios")
//	public ArrayList<Usuario> recuperarTodos(){
//	ArrayList<Usuario> lista;
//		lista = (ArrayList<Usuario>)dao.findAll();
//		return lista;
//	}

	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dados){
		Usuario resultado = dao.findByEmailOrRacf(dados.getEmail(), dados.getRacf());
		if (resultado != null) { //se o usuario existe no banco
			if (resultado.getSenha().equals(dados.getSenha())){ //as senhas batem
				resultado.setSenha("**********");
				return ResponseEntity.ok(resultado);
			}
			return ResponseEntity.status(401).build(); //usuario existe mas senha não confere
		}
		//retorna 404 pois não existe o email ou racf
		return ResponseEntity.notFound().build();
	}
	
}
