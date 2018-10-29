package DAO;

import javax.persistence.Query;

import model.Usuario;

@SuppressWarnings("rawtypes")
public class LoginDao extends DAO{
	
	public Usuario findByLoginAndSenha(String login, String senha) {
		Object retorno = null;
		try {
			manager.clear();
			Query query = manager.createQuery("Select u from Usuario u WHERE u.login = :login and u.senha = :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
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