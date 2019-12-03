package com.done.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vestuario")
public class Vestuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ves_id")
	private Long id;
	@Column(name = "ves_descricao")
	private String descricao;
	@Column(name = "ves_qtdeestoque")
	private int qtdeestoque;
	@Column(name = "ves_tamanho")
	private String tamanho;
	@Column(name = "ves_cor")
	private String cor;
	@Column(name = "ves_datacad")
	private Date datacad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdeestoque() {
		return qtdeestoque;
	}

	public void setQtdeestoque(int qtdeestoque) {
		this.qtdeestoque = qtdeestoque;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getDatacad() {
		return datacad;
	}

	public void setDatacad(Date datacad) {
		this.datacad = datacad;
	}

}