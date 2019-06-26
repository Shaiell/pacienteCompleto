package br.up.produto.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.paciente.entidades.Prescricao;
import br.up.paciente.servicos.PrescricaoServico;

@Named
@RequestScoped
public class PrescricaoBean {
	
	@EJB
	private PrescricaoServico prescricaoServico;
	
	private Prescricao prescricao;

	
	public PrescricaoBean() {
		this.prescricao = new Prescricao();
	}
	
	public void cadastrarPrescricao() {
		this.prescricaoServico.criarPrescricao(prescricao);
		this.prescricao = new Prescricao();
		JSFUtils.enviarMensagemDeInformacao("Precricão Cadastrada!");
	}
	
	public void excluirPrescricao() {
		this.prescricaoServico.excluirPrescricao(prescricao);
		JSFUtils.enviarMensagemDeInformacao("Prescricão excluida!");
		
	}
	
	public List<Prescricao> listarPrescricao(){
		return this.prescricaoServico.listarPrescricao();
	}


	public PrescricaoServico getPrescricaoServico() {
		return prescricaoServico;
	}


	public void setPrescricaoServico(PrescricaoServico prescricaoServico) {
		this.prescricaoServico = prescricaoServico;
	}


	public Prescricao getPrescricao() {
		return prescricao;
	}


	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}
	
	
}
