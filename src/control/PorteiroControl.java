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

import DAO.PorteiroDao;
import model.Porteiro;

@Path("porteiro")
public class PorteiroControl {

	private PorteiroDao porteiroDao = new PorteiroDao();
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Porteiro> listarPorteiro(){
		List<Porteiro> porteiros = porteiroDao.listaAll(Porteiro.class);
		return porteiros;
	}
	
	@POST
	@Path("inserir")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserirPorteiro(Porteiro porteiro) {
		porteiroDao.save(porteiro);
	}
	
	@PUT
	@Path("editar")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarPorteiro(Porteiro porteiro) {
		porteiroDao.update(porteiro);
	}
	
	@GET
	@Path("buscarId")
	@Produces(MediaType.APPLICATION_JSON)
	public Porteiro buscarPorId(@QueryParam("id") long id) {
		return (Porteiro) porteiroDao.findById(Porteiro.class, id);
	}
	
	@DELETE
	@Path("excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(@QueryParam("id") long id){
		porteiroDao.delete(Porteiro.class, id);
	}
}
