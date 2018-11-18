package DAO;

import java.util.List;

import javax.persistence.Query;

import model.Porteiro;
import model.Usuario;

@SuppressWarnings("rawtypes")
public class PorteiroDao extends DAO{

	@SuppressWarnings("unckecked")
	public List<Porteiro> listPaginado(int pagina, int limitePorPagina){
		manager.clear();
		Query query = manager.createQuery("Select p from Porteiro p");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
	
	public Usuario findByNome(String nome) {
		Object retorno = null;
		try {
			manager.clear();
			Query query = manager.createQuery("Select u from Usuario u WHERE ("
					+ "lower(u.nome) like '%'||lower( coalesce(:nome, '') )||'%' OR "
					+ " coalesce(:nome, '') = ''"
					+ ") ");
			query.setParameter("nome", nome);
			query.setMaxResults(1);
			retorno = query.getSingleResult();
			if(retorno != null) {
				return (Usuario) retorno;
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
