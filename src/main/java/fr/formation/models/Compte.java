package fr.formation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_compte")
	private long idcompte;
	private String nomcompte;
	private double soldecompte;

	@ManyToOne
	@JoinColumn(name="conseiller")
	private User conseiller;
	@ManyToOne
	@JoinColumn(name="client")
	private User client;


	public Compte(long idcompte, String nomcompte, double soldecompte, User conseiller, User client) {
		super();
		this.idcompte = idcompte;
		this.nomcompte = nomcompte;
		this.soldecompte = soldecompte;
		this.conseiller = conseiller;
		this.client = client;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdcompte() {
		return idcompte;
	}
	public void setIdcompte(long idcompte) {
		this.idcompte = idcompte;
	}
	public String getNomcompte() {
		return nomcompte;
	}
	public void setNomcompte(String nomcompte) {
		this.nomcompte = nomcompte;
	}

	
	public double getSoldecompte() {
		return soldecompte;
	}
	public void setSoldecompte(double soldecompte) {
		this.soldecompte = soldecompte;
	}

	@Override
	public String toString() {
		return "Compte [idcompte=" + idcompte + ", nomcompte=" + nomcompte + ", soldecompte=" + soldecompte
				+ ", conseiller=" + conseiller + ", client=" + client + "]";
	}
	public User getConseiller() {
		return conseiller;
	}
	public void setConseiller(User conseiller) {
		this.conseiller = conseiller;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}



	
}
