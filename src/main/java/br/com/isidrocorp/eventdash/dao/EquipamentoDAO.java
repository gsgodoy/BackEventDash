package br.com.isidrocorp.eventdash.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import br.com.isidrocorp.eventdash.model.Equipamento;



public interface EquipamentoDAO extends CrudRepository<Equipamento, Integer>{
	public ArrayList<Equipamento> findAllByHostname (String hostname);

}