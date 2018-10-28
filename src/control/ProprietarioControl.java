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

import DAO.ProprietarioDao;
import model.ProprietarioApartamento;

@Path("proprietario")
public class ProprietarioControl {

	private ProprietarioDao dao = new ProprietarioDao();
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProprietarioApartamento> listarProprietario(){
		List<ProprietarioApartamento> proprietarios = dao.listaAll(ProprietarioApartamento.class);
		return proprietarios;
	}
	
	@POST
	@Path("inserir")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserirProprietario(ProprietarioApartamento proprietarioApartamento) {
		dao.save(proprietarioApartamento);
	}
	
	@PUT
	@Path("editar")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarProprietario(ProprietarioApartamento proprietarioApartamento) {
		dao.update(proprietarioApartamento);
	}
	
	@GET
	@Path("buscarId")
	@Produces(MediaType.APPLICATION_JSON)
	public ProprietarioApartamento buscarPorId(@QueryParam("id") long id) {
		return (ProprietarioApartamento) dao.findById(ProprietarioApartamento.class, id);
	}
	
	@DELETE
	@Path("excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(@QueryParam("id") long id) {
		dao.delete(ProprietarioApartamento.class, id);
	}
}
