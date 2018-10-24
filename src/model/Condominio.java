package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="condominio")
public class Condominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column(name="id_apartamento")
	@OneToMany
	private Apartamento apartamento;
	
	@Column(name="id_porteiro")
	@OneToMany
	private Porteiro porteiro;
	
}
