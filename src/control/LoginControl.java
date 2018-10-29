package control;

import DAO.LoginDao;

public class LoginControl {

	private LoginDao loginDao = new LoginDao();
	
	public Object validarLogin(String login, String senha) {
		return loginDao.findByLoginAndSenha(login, senha);
	}
	
}
