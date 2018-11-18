package DAO;

import java.util.List;

import javax.persistence.Query;

import model.Porteiro;

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

}
