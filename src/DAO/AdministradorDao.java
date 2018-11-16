package DAO;

import java.util.List;

import javax.persistence.Query;

import model.Administrador;

@SuppressWarnings("rawtypes")
public class AdministradorDao extends DAO{
	
	@SuppressWarnings("unckecked")
	public List<Administrador> listPaginado(int pagina, int limitePorPagina){
		manager.clear();
		Query query = manager.createQuery("Select a from Administrador a");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
}
