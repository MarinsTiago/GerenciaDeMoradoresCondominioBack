package DAO;

import java.util.List;
import javax.persistence.Query;
import model.Morador;

@SuppressWarnings("rawtypes")
public class MoradorDao extends DAO{
	
	@SuppressWarnings("unckecked")
	public List<Morador> listPaginado(int pagina, int limitePorPagina){
		manager.clear();
		Query query = manager.createQuery("Select m from Morador m");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
	
}
