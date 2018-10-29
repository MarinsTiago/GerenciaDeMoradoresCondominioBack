package control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import DAO.LoginDao;
import model.Usuario;

@Path("login")
public class LoginControl {

	private LoginDao loginDao = new LoginDao();
	
	@GET
	@Path("validar")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario validarLogin(@QueryParam("login") String login, @QueryParam("senha") String senha) {
		return loginDao.findByLoginAndSenha(login, senha);
	}
	
}
