package br.com.start.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import br.com.start.entity.Pessoa;
import br.com.start.entity.Servico;
import br.com.start.entity.Usuario;
import br.com.start.entity.Veiculo;

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

	public Usuario logar(Usuario usuario) {
		Usuario usuarioLogado = null;
		try {
			usuarioLogado = (Usuario) manager
					.createQuery("from Usuario p where p.login =:login and p.senha =:senha")
					.setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha())
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
		return usuarioLogado;
	}

	public boolean validarUsuarioESenha(Usuario usuario) {
		try {

			Usuario usuarioAutenticado = new Usuario();
			usuarioAutenticado = (Usuario) manager
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
	public List<T> recuperaValores(Class<T> classe, String valor, String parametro) {
		StringBuilder sql = new StringBuilder();
		sql.append("from ");
		sql.append(classe.getName());
		sql.append(" p where upper (p.");
		sql.append(parametro);
		sql.append(") like :param");

		Query query = manager.createQuery(sql.toString());

		if (StringUtils.isNotBlank(valor) && StringUtils.isNumeric(valor)) {
			query.setParameter("param", Long.valueOf(valor));
		} else {
			query.setParameter("param", "%" + valor.toUpperCase() + "%");
		}
		return query.getResultList();
	}
	
	public boolean existeRegistro(Class<T> classe, String parametro, String valor) {
		boolean encontrouRegistro = false;
		try {
			if (StringUtils.isNotBlank(parametro) && StringUtils.isNotBlank(valor)) {
				StringBuilder sql = new StringBuilder();
				sql.append("select count(p.id) from ");
				sql.append(classe.getName());
				sql.append(" as p ");
				sql.append(" where p.");
				sql.append(parametro);
				sql.append(" = :parametro ");
				Query query = manager.createQuery(sql.toString());
				query.setParameter("parametro", valor);
				Long retorno = (Long) query.getSingleResult();
				if (retorno !=null && retorno>0) {
					encontrouRegistro = true;
				}
			}
		} catch (Exception e) {
			encontrouRegistro = false;
		}
		return encontrouRegistro;
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> recuperaVeiculos(String pessoaNome) {
		StringBuilder sql = new StringBuilder();
		sql.append("select v from Veiculo v ");
		sql.append(" left join v.pessoa p ");
		
		if (StringUtils.isNotBlank(pessoaNome)) {
			sql.append(" where upper (p.nome) like :nome ");
		}
		
		sql.append(" order by v.modelo, p.nome ");
		
		Query query = manager.createQuery(sql.toString());
		if (StringUtils.isNotBlank(pessoaNome)) {
			query.setParameter("nome", "%" + pessoaNome.toUpperCase() + "%");
		}
		return (List<Veiculo>) query.getResultList();
	}
	
	public Veiculo recuperaVeiculosPelaPlaca(String placa) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select v from Veiculo v ");
			if (StringUtils.isNotBlank(placa)) {
				sql.append(" where v.placa = :placa ");
			}
			Query query = manager.createQuery(sql.toString());
			if (StringUtils.isNotBlank(placa)) {
				query.setParameter("placa", placa);
			}
			return (Veiculo) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> recuperaServicos(String descricao) {
		StringBuilder sql = new StringBuilder();
		sql.append("select s from Servico s ");
		
		if(StringUtils.isNotBlank(descricao)) {
			sql.append(" where ");
		}
		
		if(StringUtils.isNumeric(descricao)) {
			sql.append(" upper (s.codigo) like :codigo ");
		}else {
			if (StringUtils.isNotBlank(descricao)) {
				sql.append(" upper (s.descricao) like :descricao ");
			}
		}
		
		sql.append(" order by s.descricao, s.valor ");
		
		Query query = manager.createQuery(sql.toString());
		
		if (StringUtils.isNumeric(descricao)) {
			query.setParameter("codigo", "%" + descricao.toUpperCase() + "%");
		}else {
			if (StringUtils.isNotBlank(descricao)) {
				query.setParameter("descricao", "%" + descricao.toUpperCase() + "%");
			}
		}
		
		return (List<Servico>) query.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Pessoa> recuperaFuncionarios(String valorPesquisa) {
		StringBuilder sql = new StringBuilder();

		sql.append("select p from Pessoa p  where ");
		sql.append(" p.tipoPessoa = 'FUNCIONARIO' ");
		
		if (StringUtils.isNotBlank(valorPesquisa)) {
			if (StringUtils.isNumeric(valorPesquisa)) {
				sql.append(" and p.id = :idPessoa ");
			}else {
				sql.append(" and upper (p.nome) like :nome ");
			}
		}
		sql.append("order by  p.nome");

		Query query = manager.createQuery(sql.toString());
		
		if (StringUtils.isNotBlank(valorPesquisa)) {
			if (StringUtils.isNumeric(valorPesquisa)) {
				query.setParameter("idPessoa", Long.valueOf(valorPesquisa));
			}else {
				query.setParameter("nome", "%" + valorPesquisa.toUpperCase() + "%");
			}
		}
		return (List<Pessoa>) query.getResultList();
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> recuperaPessoa(String nome, boolean ehFuncionario, boolean ehPessoaFisica, boolean ehPessoaJuridica) {
		StringBuilder sql = new StringBuilder();

		sql.append("select p from Pessoa p  where ");
		
		if (StringUtils.isNotBlank(nome)) {
			sql.append(" upper (p.nome) like :nome ");
		}
		
		if(StringUtils.isNotBlank(nome) && (ehFuncionario || ehPessoaFisica || ehPessoaJuridica)) {
			sql.append(" and ");
		}
		
		
		if (ehFuncionario) {
			sql.append(" p.tipoPessoa = 'FUNCIONARIO' ");
		}else if (ehPessoaFisica) {
			sql.append(" p.tipoPessoa = 'PESSOAFISICA' ");
		}else if (ehPessoaJuridica) {
			sql.append(" p.tipoPessoa = 'PESSOAJURIDICA' ");
		}else {
			if(StringUtils.isNotBlank(nome)) {
				sql.append(" and ");
			}
			sql.append(" p.tipoPessoa IN('PESSOAFISICA', 'PESSOAJURIDICA') ");
			
		}
		Query query = manager.createQuery(sql.toString());
		if (StringUtils.isNotBlank(nome)) {
			query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		}
		return (List<Pessoa>) query.getResultList();
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
