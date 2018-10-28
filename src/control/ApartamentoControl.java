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

import DAO.ApartamentoDao;
import model.Apartamento;

@Path("apartamento")
public class ApartamentoControl {

	private ApartamentoDao apartamentoDao = new ApartamentoDao();
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Apartamento> listarApartamentos(){
		List<Apartamento> apartamentos = apartamentoDao.listaAll(Apartamento.class);
		return apartamentos;
	}
	
	@POST
	@Path("inserir")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserirApartamento(Apartamento apartamento) {
		apartamentoDao.save(apartamento);
	}
	
	@PUT
	@Path("editar")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarApartamento(Apartamento apartamento) {
		apartamentoDao.update(apartamento);
	}
	
	@GET
	@Path("buscarId")
	@Produces(MediaType.APPLICATION_JSON)
	public Apartamento buscarPorId(@QueryParam("id") long id) {
		return (Apartamento) apartamentoDao.findById(Apartamento.class, id);
	}
	
	@DELETE
	@Path("excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(@QueryParam("id") long id) {
		apartamentoDao.delete(Apartamento.class, id);
	}
}
