package br.up.produto.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.paciente.entidades.Paciente;
import br.up.paciente.servicos.PacienteServico;

/**
 * method created control pacient data on the web.
 * @author jclri
 *
 */
@Named
@RequestScoped
public class PacienteBean {
	
	@EJB
	private PacienteServico pacienteServico;
	
	private Paciente paciente;
	
	private List<Paciente> pacientes;
	
	public PacienteBean() {
		this.paciente = new Paciente();
	}
	
	public void criarPacientes() {
		
		try {
		this.pacienteServico.criarPaciente(paciente);
		JSFUtils.enviarMensagemDeInformacao("Paciente "+paciente.getNome()+" Cadastrado!");
		this.paciente = new Paciente();
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	public void excluirPacientes(Paciente paciente) {
		this.pacienteServico.excluirPaciente(paciente);
		JSFUtils.enviarMensagemDeInformacao("Paciente "+paciente.getNome()+" Excluido!");
	}
	
	public List<Paciente> listarPaciente(){
		return this.pacienteServico.listarPaciente();
	}

	public PacienteServico getPacienteServico() {
		return pacienteServico;
	}

	public void setPacienteServico(PacienteServico pacienteServico) {
		this.pacienteServico = pacienteServico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		if(this.pacientes==null) {
			this.pacientes = pacienteServico.listarPaciente();
		}
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	

}
