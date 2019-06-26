package br.up.paciente.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.paciente.entidades.Medicamento;

@Stateless
public class MedicamentoServico {
	
	@PersistenceContext
	private EntityManager em;
	

	
	public void cadastrarMedicamento(Medicamento medicamento) {
		
		this.em.persist(medicamento);
	}
	
	public void excluirCliente(Medicamento medicamento) {
		this.em.remove(em.merge(medicamento));
	}
	
	public List<Medicamento> listarMedicamentos(){
		Query query = this.em.createQuery("SELECT m FROM Medicamento m", Medicamento.class);
				
		return query.getResultList();
	}

}
