package br.com.senior.hotelrestapi.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "check_in")
public class CheckIn extends Auditoria {
	private static final long serialVersionUID = 7662432134617341862L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtSaida;

	@NotNull
	private boolean isAdicionalVeiculo;

	@OneToOne
	@JoinColumn(name = "id_hospede", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Hospede hospede;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public boolean isAdicionalVeiculo() {
		return isAdicionalVeiculo;
	}

	public void setAdicionalVeiculo(boolean isAdicionalVeiculo) {
		this.isAdicionalVeiculo = isAdicionalVeiculo;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

}
