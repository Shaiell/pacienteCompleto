package br.up.paciente.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Prescricao {

	@Id
	@SequenceGenerator(name = "CONTADOR_PRESCRICAO", sequenceName = "NUM_SEQ_PRESCRICAO", allocationSize = 0)
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "CONTADOR_PRESCRICAO")
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn (name = "fk_paciente")
	private Paciente paciente;
	
	@NotNull
	@ManyToOne
	@JoinColumn (name = "fk_medicamento")
	private Medicamento medicamento;
	
	@NotNull
	private Date dataInicio;
	
	@NotNull
	private Date dataFinal;
	
	@NotNull
	private String frequencia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	
	
}
