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

import DAO.MoradorDao;
import model.Morador;

@Path("morador")
public class MoradorControl {

	private MoradorDao moradorDao = new MoradorDao();
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Morador> listarMorador(){
		List<Morador> moradores = moradorDao.listaAll(Morador.class);
		return moradores;
	}
	
	@POST
	@Path("inserir")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserirMorador(Morador morador) {
		moradorDao.save(morador);
	}
	
	@PUT
	@Path("editar")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarMorador(Morador morador){
		moradorDao.update(morador);
	}
	
	@GET
	@Path("buscarId")
	@Produces(MediaType.APPLICATION_JSON)
	public Morador buscarId(@QueryParam("id") long id) {
		return (Morador) moradorDao.findById(Morador.class, id);
	}
		
	@DELETE
	@Path("excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(@QueryParam("id") long id) {
		moradorDao.delete(Morador.class, id);
	}
}
