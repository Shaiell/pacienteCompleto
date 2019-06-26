package br.up.paciente.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



/**
 * class created to represent a patient.
 * 
 * @author jclri
 *
 */
@Entity
public class Paciente {

	@Id
	@SequenceGenerator(name = "CONTADOR_PACIENTE", sequenceName = "NUM_SEQ_PACIENTE", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_PACIENTE")
	private Integer id;

	@NotBlank
	private String nome;

	@NotNull
	private Integer idade;

	@NotNull
	@org.hibernate.validator.constraints.br.CPF
	private String cpf;

	@NotBlank
	private String sexo;

	@NotNull
	private Date dataInternacao;

	public Paciente() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataInternacao() {
		return dataInternacao;
	}

	public void setDataInternacao(Date dataInternacao) {
		this.dataInternacao = dataInternacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
