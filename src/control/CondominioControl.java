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

import DAO.CondominioDao;
import model.Condominio;

@Path("condominio")
public class CondominioControl {

	private CondominioDao condominioDao = new CondominioDao();
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Condominio> listarCondominio(){
		List<Condominio> condominios = condominioDao.listaAll(Condominio.class);
		return condominios;
	}
	
	@POST
	@Path("inserir")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserirCondominio(Condominio condominio) {
		condominioDao.save(condominio);
	}
	
	@PUT
	@Path("editar")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarCondominio(Condominio condominio) {
		condominioDao.update(condominio);
	}
	
	@GET
	@Path("buscarId")
	@Produces(MediaType.APPLICATION_JSON)
	public Condominio buscarPorId(@QueryParam("id") long id) {
		return (Condominio) condominioDao.findById(Condominio.class, id);
	}
	
	@DELETE
	@Path("excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(@QueryParam("id") long id) {
		condominioDao.delete(Condominio.class, id);
	}
}
