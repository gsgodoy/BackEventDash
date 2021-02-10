package br.com.isidrocorp.eventdash.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.eventdash.model.Usuario;

/*Essa é a ponte para gerar os SQL de Inserts, selects, Updates, etc
 * 
 */

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	public Usuario findByEmailOrRacf(String email, String racf);
	
}
