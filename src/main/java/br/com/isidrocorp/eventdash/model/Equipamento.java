package br.com.isidrocorp.eventdash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //a classe se torna armazenável no banco
@Table(name="itmn_equipamento") //coloca o nome da tabela
public class Equipamento {
	
	@Column(name="id_equip")   //mapear o atributo para o nome da coluna
	@Id							 //indico que é chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //preciso informar que é auto increment
	private int idEquipamento;
	
	@Column(name="hostname", length=50, nullable = false)
	private String hostname;
	
	@Column(name="ipaddr", length=15, nullable = false)
	private String ipAddr;
	
	public int getIdEquipamento() {
		return idEquipamento;
	}
	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	
}
