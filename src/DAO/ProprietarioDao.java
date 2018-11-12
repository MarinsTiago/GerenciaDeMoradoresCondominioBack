package DAO;

import java.util.List;
import javax.persistence.Query;
import model.Proprietario;

@SuppressWarnings("rawtypes")
public class ProprietarioDao extends DAO{
	
	@SuppressWarnings("unckecked")
	public List<Proprietario> listPaginado(int pagina, int limitePorPagina){
		manager.clear();
		Query query = manager.createQuery("select p from Proprietario p");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
}
