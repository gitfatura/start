package br.com.start.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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

}
