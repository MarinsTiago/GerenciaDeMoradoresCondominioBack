package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import DAO.EntidadeBase;

@Entity
@Table(name="apartamento")
@Inheritance (strategy=InheritanceType.JOINED)
@XmlRootElement
public class Apartamento implements EntidadeBase{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private int numero;
	
	@Column
	private String bloco;
	
	/*@Column
	@OneToOne(fetch = FetchType.EAGER, optional = false, mappedBy = "apartamento")
	@JoinColumn(name="id_morador")
	private Morador morador;

	@Column
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="id_proprietario_apartamento")
	private ProprietarioApartamento proprietario;
	*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	/*public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}*/
}
