package com.leaolabs.tarefas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	@NotNull(message = "O titulo é obrigatorio")
	@Length(max = 50, min = 3, message = "O titulo deve ter de 3 a 50 caracteres")
	private String titulo;
	
	@Column(length = 100, nullable = false)
	@Length(max = 100, message = "A descrição deve no maximo 100 caracteres")
	private String descricao;
	

	@Column(name = "data_expiracao", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataExpiracao;
	
	@Column(nullable = false)
	private Boolean concluida = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}
}
