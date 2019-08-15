package br.com.start.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.start.entity.UsuarioEntity;

public class QueryUtils<T> {

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public T get(Class<?> classe, Long id) {
		return (T) manager.find(classe, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> all(Class<T> classe) {
		return manager.createQuery("from " + classe.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Long> getIds(Class<T> classe) {
		return manager.createQuery("select p.id from " + classe.getName() + " p").getResultList();
	}

	public UsuarioEntity logar(UsuarioEntity usuario) {
		UsuarioEntity usuarioEntity = null;
		try {
			usuarioEntity = (UsuarioEntity) manager
					.createQuery("from UsuarioEntity p where p.login =:login and p.senha =:senha")
					.setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha())
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return usuarioEntity;
	}

	public boolean validarUsuarioESenha(UsuarioEntity usuario) {
		try {

			UsuarioEntity usuarioAutenticado = new UsuarioEntity();
			usuarioAutenticado = (UsuarioEntity) manager
					.createQuery("select p from UsuarioEntity p where p.login =:login and p.senha =:senha")
					.setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha())
					.getSingleResult();
			if (usuarioAutenticado == null) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@SuppressWarnings("unchecked")
	public List<T> recuperaItensOrdenado(Class<T> classe, String parametroOrdenado) {
		StringBuilder sql = new StringBuilder();
		sql.append("select p from ").append(classe.getName()).append(" as p order by p.").append(parametroOrdenado);
		return manager.createQuery(sql.toString()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> paginationPage(Class<T> classe, List<Long> lIds) {
		return manager.createQuery("select p from " + classe.getName() + " p where p.id in :ids")
				.setParameter("ids", lIds).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> recuperaItem(Class<T> classe, String valorARecuperar, String parametro) {
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(classe.getName()).append(" p where upper (p.").append(parametro)
				.append(") like :param");
		return manager.createQuery(sql.toString()).setParameter("param", "%" + valorARecuperar.toUpperCase() + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> recuperaItemOrdenadoDescendente(Class<T> classe, String value, String nomeColuna) {
		StringBuilder sql = new StringBuilder();
		sql.append("select p  from ");
		sql.append(classe.getName());
		sql.append(" p where p." + nomeColuna);
		sql.append(" like :desc");
		return manager.createQuery(sql.toString()).setParameter("desc", "%" + value + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> recuperaPorData(Class<T> classe, Date inicio, Date fim, String nomeColuna) {
		StringBuilder sql = new StringBuilder();
		sql.append("select p from ");
		sql.append(classe.getName());
		sql.append(" p where p." + nomeColuna);
		sql.append("between :dinicio and :dfim");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("dinicio", inicio);
		query.setParameter("dfim", fim);
		return query.getResultList();
	}

}
