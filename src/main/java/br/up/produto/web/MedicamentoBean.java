package br.up.produto.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.paciente.entidades.Medicamento;
import br.up.paciente.servicos.MedicamentoServico;

@Named
@RequestScoped
public class MedicamentoBean {

	@EJB
	private MedicamentoServico medicamentoServico;
	
	private Medicamento medicamento;
	
	private List<Medicamento> medicamentos;
	
	public MedicamentoBean() {
		this.medicamento = new Medicamento();
	}
	
	public void cadastrarMedicamento() {
		this.medicamentoServico.cadastrarMedicamento(medicamento);
		this.medicamento = new Medicamento();
		JSFUtils.enviarMensagemDeInformacao("Medicamento cadastrado!");
	}
	
	public void excluirMedicamento() {
		this.medicamentoServico.excluirCliente(medicamento);
		JSFUtils.enviarMensagemDeInformacao("Medicamento excluido!");
	}
	
	public List<Medicamento> listarMedicamento(){
		return this.medicamentoServico.listarMedicamentos();
	}

	public MedicamentoServico getMedicamentoServico() {
		return medicamentoServico;
	}

	public void setMedicamentoServico(MedicamentoServico medicamentoServico) {
		this.medicamentoServico = medicamentoServico;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		if(this.medicamentos==null) {
			this.medicamentos = medicamentoServico.listarMedicamentos();
		}
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	
	
	
}
