package br.up.paciente.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Medicamento {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_MEDICAMENTO", sequenceName = "SEQ_NUM_MEDICAMENTO", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="CONTADOR_MEDICAMENTO" )
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String concentracao;
	
	@NotBlank
	private String laboratorio;
	
	@NotBlank
	private String tarja;
	
	
	public Medicamento() {
		
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


	public String getConcentracao() {
		return concentracao;
	}


	public void setConcentracao(String concentracao) {
		this.concentracao = concentracao;
	}


	public String getLaboratorio() {
		return laboratorio;
	}


	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}


	public String getTarja() {
		return tarja;
	}


	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	
	
}
