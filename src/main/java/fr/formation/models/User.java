package fr.formation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_user")
	private long iduser;
	private String prenomuser;
	private String nomuser;        
	private String password;

	@OneToOne
	@JoinColumn(name="role")
	private Role role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long iduser, String prenomuser, String nomuser, String password, Role role) {
		super();
		this.iduser = iduser;
		this.prenomuser = prenomuser;
		this.nomuser = nomuser;
		this.password = password;

		this.role = role;
	}
	public long getIduser() {
		return iduser;
	}
	public void setIduser(long iduser) {
		this.iduser = iduser;
	}
	public String getPrenomuser() {
		return prenomuser;
	}
	public void setPrenomuser(String prenomuser) {
		this.prenomuser = prenomuser;
	}
	public String getNomuser() {
		return nomuser;
	}
	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", prenomuser=" + prenomuser + ", nomuser=" + nomuser + ", password="
				+ password +  ", role=" + role + "]";
	}

	
}
