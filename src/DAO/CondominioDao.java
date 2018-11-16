package DAO;

import java.util.List;

import javax.persistence.Query;

import model.Condominio;

@SuppressWarnings("rawtypes")
public class CondominioDao extends DAO{
	@SuppressWarnings("unckecked")
	public List<Condominio> listPaginado(int pagina, int limitePorPagina){
		manager.clear();
		Query query = manager.createQuery("Select c from Condominio c");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
}
