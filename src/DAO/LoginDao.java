package DAO;

import javax.persistence.Query;

import model.Morador;
import model.Porteiro;
import model.Proprietario;

@SuppressWarnings("rawtypes")
public class LoginDao extends DAO{
	
	public Object findByLoginAndSenha(String login, String senha) {
		Object retorno = null;
		try {
			manager.clear();
			Query query = manager.createQuery("Select m from Morador m WHERE m.login = :login and m.senha = :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			query.setMaxResults(1);
			retorno = query.getSingleResult();
			if(retorno != null) {
				return (Morador) retorno;
			}else{
				manager.clear(); //limpeza de cache de queries
				query = manager.createQuery("Select p from Porteiro p WHERE p.login = :login and p.senha = :senha");
				query.setParameter("login", login);
				query.setParameter("senha", senha);
				query.setMaxResults(1);
				retorno = query.getSingleResult();
			if(retorno != null) {
				return (Porteiro) retorno;
			}else{
				manager.clear(); //limpeza de cache de queries
				query = manager.createQuery("Select p from Proprietario p WHERE p.login = :login and p.senha = :senha");
				query.setParameter("login", login);
				query.setParameter("senha", senha);
				query.setMaxResults(1);
				retorno = query.getSingleResult();
			if(retorno != null) {
					return (Proprietario) retorno;
			}else{
					return null;
			}
				}
					
			}
		}catch (Exception e) {
			return null;
		}
	}
}
