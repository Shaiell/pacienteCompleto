package br.up.paciente.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.paciente.entidades.Prescricao;

@Stateless
public class PrescricaoServico {
	
	@PersistenceContext
	private EntityManager em;
	
	public void criarPrescricao(Prescricao prescricao) {
		this.em.persist(prescricao);
	}
	
	public void excluirPrescricao(Prescricao prescricao) {
		this.em.remove(this.em.merge(prescricao));
	}
	
	public List<Prescricao> listarPrescricao(){
		Query query = this.em.createQuery("SELECT p FROM Prescricao p", Prescricao.class);
		
		return query.getResultList();
	}

}
