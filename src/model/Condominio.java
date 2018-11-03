package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import DAO.EntidadeBase;

@Entity
@XmlRootElement
@Table(name="condominio")
public class Condominio implements EntidadeBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nome;
	
	/*@OneToMany(mappedBy="condominio", cascade=CascadeType.ALL)
	private List<Apartamento> apartamentos;*/
	
	@OneToMany(mappedBy="condominio", cascade=CascadeType.ALL)
	private List<Porteiro> porteiros;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}*/

	public List<Porteiro> getPorteiros() {
		return porteiros;
	}

	public void setPorteiros(List<Porteiro> porteiros) {
		this.porteiros = porteiros;
	}
	
}
