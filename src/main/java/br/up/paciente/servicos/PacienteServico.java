package br.up.paciente.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.up.paciente.entidades.Paciente;

/**
 * Class created to manage a patient.
 * @author jclri
 *
 */

@Stateless
public class PacienteServico {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * method created to insert a pacient into the database.
	 * @param paciente
	 * @throws Exception 
	 */
	public void criarPaciente(Paciente paciente) throws Exception {
		
		if(cpfPaciante(paciente).isEmpty()) {
			this.em.persist(paciente);
		}else {
			throw new Exception("CPF Já Cadastrado");
		}
	}
	
	/**
	 * method created to remove a pacient in the database.
	 * @param paciente
	 */
	public void excluirPaciente(Paciente paciente) {
		this.em.remove(this.em.merge(paciente));
	}
	
	/**
	 * method created to list pacients in the database.
	 * @return
	 */
	public List<Paciente> listarPaciente(){
		Query query = this.em.createQuery("SELECT p FROM Paciente p", Paciente.class);
		
		return query.getResultList();
	}

	public List<Paciente> cpfPaciante(Paciente paciente){
		Query query = this.em.createQuery("SELECT p FROM Paciente p WHERE p.cpf=:p1",Paciente.class);
		query.setParameter("p1", paciente.getCpf());
		
		return query.getResultList();
	}
	
	
	
}
