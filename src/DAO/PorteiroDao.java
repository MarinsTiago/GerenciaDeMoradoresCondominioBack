package DAO;

import java.util.List;

import javax.persistence.Query;

import model.Morador;
import model.Porteiro;
import model.Usuario;

@SuppressWarnings("rawtypes")
public class PorteiroDao extends DAO{

	
	@SuppressWarnings("unchecked")
	public List<Porteiro> listPaginado(int pagina, int limitePorPagina){
		manager.clear();
		Query query = manager.createQuery("Select p from Porteiro p");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
	
	public Morador findByNome(String nome) {
		Object retorno = null;
		try {
			manager.clear();
			
			/*
			 * "Select m from Morador m WHERE ("
					+ "lower(m.nome) like '%'||lower( coalesce(:nome, '') )||'%' OR "
					+ " coalesce(:nome, '') = ''"
					+ ") "
			 * */
			Query query = manager.createQuery("Select m from Morador m where m.nome = lower(:nome)");
			query.setParameter("nome", nome);
			query.setMaxResults(1);
			retorno = query.getSingleResult();
			if(retorno != null) {
				return (Morador) retorno;
			}else{
				System.out.println("Errou!");
					return null;
			}	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
