package br.com.start.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.start.entity.Produto;

public class PersistenceUtils<T> implements Serializable {

	private static final long serialVersionUID = 185718985977163028L;

	@Inject
	private EntityManager manager;

	public void save(T t) {
		manager.merge(t);
	}

	public void remove(T t) {
		manager.remove(manager.merge(t));
		manager.flush();
	}
	
	public void entradaProduto(Produto p) {
		Query query = manager.createQuery(
				"update Produto p set p.quantidade = p.quantidade + :novaquantidade where p.id = :idproduto");
		query.setParameter("novaquantidade", p.getQuantidade());
		query.setParameter("idproduto", p.getId());
		query.executeUpdate();
		//manager.getTransaction().commit();
		//manager.close();
	}

	public void saidaProduto(Produto p) {
		Query query = manager.createQuery(
				"update Produto p set p.quantidade = p.quantidade - :novaquantidade where p.id = :idproduto");
		query.setParameter("novaquantidade", p.getQuantidade());
		query.setParameter("idproduto", p.getId());
		query.executeUpdate();
		//manager.getTransaction().commit();
		//manager.close();
	}
}
