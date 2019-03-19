package fr.nedjma.universite.matiere.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.nedjma.universite.enseignant.domain.Enseignant;
import fr.nedjma.universite.note.domain.Note;

@Entity
@Table(name="t_matiere")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Matieres implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8298719577441606278L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="numero_matiere")
	private Integer numeroMatiere;

	@Column(name="nom")
	private String nom;

	@Column(name="coef")
	private Integer coef;

	//jointure avec la table enseignant
	@ManyToOne
	@JoinColumn(name="id_enseignant")//c'est cette colone qui permet de faire la jointure avec la table enseigannt
	private Enseignant enseignant;//on veut un enseignant complet
	
	@JsonIgnore
	@OneToMany(mappedBy="matiere")//lié a quel objet
	private List<Note> notes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroMatiere() {
		return numeroMatiere;
	}

	public void setNumeroMatiere(Integer numeroMatiere) {
		this.numeroMatiere = numeroMatiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCoef() {
		return coef;
	}

	public void setCoef(Integer coef) {
		this.coef = coef;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}





}
