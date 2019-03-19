package fr.nedjma.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import fr.nedjma.universite.etudiant.domain.Etudiant;
import fr.nedjma.universite.matiere.domain.Matieres;

@Entity
@Table(name="t_note")
public class Note implements Serializable{
	
	//il faut dire à jpa que c'est ça qui est la clé primaire
	@EmbeddedId //c'est un id intégré
	private NotePK notePk;
	
	@Column(name="note")
	private Double note;
	
	@ManyToOne
	//est ce qu'on peut l'insérer ou faire une mise à jour dans la bdd ? non Parce qu'elle est déjà mise à jour dans la classe note PK 
	@JoinColumn(name="id_etudiant", insertable=false, updatable=false)
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name="id_matiere", insertable=false, updatable=false)
	private Matieres matiere;

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Matieres getMatiere() {
		return matiere;
	}

	public void setMatiere(Matieres matiere) {
		this.matiere = matiere;
	}

	public NotePK getNotePk() {
		return notePk;
	}

	public void setNotePk(NotePK notePk) {
		this.notePk = notePk;
	}
	
	
}
