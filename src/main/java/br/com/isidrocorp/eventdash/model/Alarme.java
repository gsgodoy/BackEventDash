package br.com.isidrocorp.eventdash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //a classe se torna armazenável no banco
@Table(name="itmn_alarme") //coloca o nome da tabela
public class Alarme {
	
	@Column(name="id_alarme")   //mapear o atributo para o nome da coluna
	@Id							 //indico que é chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //preciso informar que é auto increment
	private int idAlarme;
	
	@Column(name="nome", length=100, nullable = false)
	private String nome;
	
	@Column(name="descricao", length=200)
	private String descricao;
	
	
	public int getIdAlarme() {
		return idAlarme;
	}
	public void setIdAlarme(int idAlarme) {
		this.idAlarme = idAlarme;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
