package br.com.senior.hotelrestapi.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "dtCriacao", "dtAtualizacao" }, allowGetters = true)
public abstract class Auditoria implements Serializable {
	private static final long serialVersionUID = 5251336598096635119L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_criacao", nullable = false, updatable = false)
	@CreatedDate
	private Date dtCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_atualizacao", nullable = false)
	@LastModifiedDate
	private Date dtAtualizacao;

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

}
