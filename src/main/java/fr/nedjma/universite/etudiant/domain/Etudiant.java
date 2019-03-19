package fr.nedjma.universite.etudiant.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.nedjma.universite.note.domain.Note;

@Entity
@Table(name="t_etudiant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Etudiant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2671497910175900842L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
private Integer id;
	
	@Column(name="numero_etudiant")
private Integer numeroEtudiant;
	
	@Column(name="nom")
private String nom;
	
	@Column(name="prenom")
private String prenom;
	
	@Column(name="date_naissance")
	@DateTimeFormat(pattern="yyyy-MM-dd")
private Date dateNaissance;
	
	@Column(name="sexe")
private String sexe;
	
	@Column(name="photo")
private String photo;
	
	
	
	//le jpa le gere avec one to many
	//etudiant est donc la pour spécifier la jointure qu'on a crée dans la classe (domain) Note
	//c'ets un lien bi-directionnel d'une jointure déjà existante
	@JsonIgnore//ca sert à lui dire de ne pas boucler sur letudiant qui possede une note qui possede ce meme etudiant qui possede cette note...
	@OneToMany(mappedBy="etudiant")
	//on veut récuperer toutes les notes
	private List<Note> notes;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroEtudiant() {
		return numeroEtudiant;
	}

	public void setNumeroEtudiant(Integer numeroEtudiant) {
		this.numeroEtudiant = numeroEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	
	
	
	
}
