package control;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import DAO.AdministradorDao;
import model.Administrador;

@Path("administrador")
public class AdministradorControl {

	private AdministradorDao administradorDao = new AdministradorDao();
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Administrador> listarAdministradores(){
		List<Administrador> administradores = administradorDao.listaAll(Administrador.class);
		return administradores;
	}
	
	@POST
	@Path("inserir")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserirAdministrador(Administrador administrador) {
		administradorDao.save(administrador);	
	}
	
	@PUT
	@Path("editar")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarAdministrador(Administrador administrador) {
		administradorDao.update(administrador);
	}
	
	@GET
	@Path("buscarId")
	@Produces(MediaType.APPLICATION_JSON)
	public Administrador buscarPorId(@QueryParam("id") long id) {
		return (Administrador) administradorDao.findById(Administrador.class, id);
	}
	
	@DELETE
	@Path("excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(@QueryParam("id") long id) {
		administradorDao.delete(Administrador.class, id);
	}
}
