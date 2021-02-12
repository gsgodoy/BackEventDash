package br.com.isidrocorp.eventdash.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //a classe se torna armazenável no banco
@Table(name="itmn_evento") //coloca o nome da tabela
public class Evento {

	@Column(name="num_seq")   //mapear o atributo para o nome da coluna
	@Id							 //indico que é chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //preciso informar que é auto increment
	private int numSeq;
	
	@Column(name="data_evt")
	private LocalDate dataEvento;
	
	@ManyToOne
	@JoinColumn(name = "id_alarme")
	private Alarme alarme;
	
	@ManyToOne
	@JoinColumn(name = "id_equip")
	private Equipamento equipamento;
	
	public int getNumSeq() {
		return numSeq;
	}
	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}
	public LocalDate getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Alarme getAlarme() {
		return alarme;
	}
	public void setAlarme(Alarme alarme) {
		this.alarme = alarme;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}	
	
}
