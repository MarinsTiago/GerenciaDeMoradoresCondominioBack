package DAO;

import java.util.List;

import javax.persistence.Query;

import model.Apartamento;

@SuppressWarnings("rawtypes")
public class ApartamentoDao extends DAO{
	
	@SuppressWarnings("unckecked")
	public List<Apartamento> listPaginado(int pagina, int limitePorPagina){
		manager.clear();
		Query query = manager.createQuery("Select a from Apartamento a");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
}
