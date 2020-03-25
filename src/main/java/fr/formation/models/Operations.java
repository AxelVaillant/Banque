package fr.formation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Operations {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_operations")
	private long idoperations;
	private String nomoperations;
	@Temporal(TemporalType.DATE)
	private Date dateoperations;
	private double montant;
	
	@OneToOne
	@JoinColumn(name="Compte_emetteur")
	private Compte emetteur;
	@OneToOne
	@JoinColumn(name="Compte_receveur")
	private Compte receveur;

	public Operations(long idoperations, String nomoperations, Date dateoperations, double montant, Compte emetteur,
			Compte receveur) {
		super();
		this.idoperations = idoperations;
		this.nomoperations = nomoperations;
		this.dateoperations = dateoperations;
		this.montant = montant;
		this.emetteur = emetteur;
		this.receveur = receveur;
	}
	public Operations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdoperations() {
		return idoperations;
	}
	public void setIdoperations(long idoperations) {
		this.idoperations = idoperations;
	}
	public String getNomoperations() {
		return nomoperations;
	}
	public void setNomoperations(String nomoperations) {
		this.nomoperations = nomoperations;
	}
	public Date getDateoperations() {
		return dateoperations;
	}
	public void setDateoperations(Date dateoperations) {
		this.dateoperations = dateoperations;
	}
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(Compte emetteur) {
		this.emetteur = emetteur;
	}
	public Compte getReceveur() {
		return receveur;
	}
	public void setReceveur(Compte receveur) {
		this.receveur = receveur;
	}
	@Override
	public String toString() {
		return "Operations [idoperations=" + idoperations + ", nomoperations=" + nomoperations + ", dateoperations="
				+ dateoperations + ", montant=" + montant + ", emetteur=" + emetteur + ", receveur=" + receveur + "]";
	}

	
	
}
