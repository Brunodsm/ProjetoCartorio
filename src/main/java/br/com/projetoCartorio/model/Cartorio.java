package br.com.projetoCartorio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="cartorio")
public class Cartorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	public Cartorio() {}
	
	public Cartorio (String nome) {
		this.nome = nome;
	}
	
	public Cartorio(Integer id) {
		this.id = id;
	}
	
	public Cartorio(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
