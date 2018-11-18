package DAO;

import javax.persistence.Query;

import model.Usuario;

@SuppressWarnings("rawtypes")
public class PorteiroDao extends DAO{

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
