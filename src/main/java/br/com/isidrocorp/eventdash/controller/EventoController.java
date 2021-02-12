package br.com.isidrocorp.eventdash.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.EventoDAO;
import br.com.isidrocorp.eventdash.model.Equipamento;
import br.com.isidrocorp.eventdash.model.Evento;

@RestController
@CrossOrigin("*")
public class EventoController {

	@Autowired
	private EventoDAO dao;
	
	@GetMapping("/eventos")
	public ArrayList<Evento> listarTudo(){
		ArrayList<Evento> lista;
		lista = (ArrayList<Evento>) dao.findAll();
		return lista;
	}
	
	@GetMapping("/buscarpordata")
	public ArrayList<Evento> buscarPorData(@RequestParam(name="inicio") String dataIni,
										   @RequestParam(name="fim") String dataFim){
		//System.out.println("Data recebida de inicio = "+dataIni);
		//System.out.println("Data recebida de fim    = "+dataFim);
		
		LocalDate dtIni = LocalDate.parse(dataIni); //converter os parametros de string para data
		LocalDate dtFim = LocalDate.parse(dataFim);
		ArrayList<Evento> lista = dao.findAllByDataEventoBetween(dtIni, dtFim);
		
		return lista;
	}
	
	@GetMapping("/buscarporidequip")
	public ArrayList<Evento> buscarPorid_equip(@RequestParam(name="id_equip") int id_equip){
		ArrayList<Evento> lista;
		Equipamento eq= new Equipamento(); 
		eq.setIdEquipamento(id_equip);
		lista = (ArrayList<Evento>) dao.findAllByEquipamento(eq);
		return lista;
	}
}
