package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	/*@Column
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="id_apartamento")
	private Apartamento apartamento;
	
	@Column
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="id_porteiro")
	private Porteiro porteiro;*/
	
	@Column
	private String nome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public Porteiro getPorteiro() {
		return porteiro;
	}

	public void setPorteiro(Porteiro porteiro) {
		this.porteiro = porteiro;
	}*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
