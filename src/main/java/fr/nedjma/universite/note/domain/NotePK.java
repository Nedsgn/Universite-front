package fr.nedjma.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//il faut dire a jpa que c'es un sous ensemble d'une autre entité, elle est là que pour etre utilisée dans une autre entité

@Embeddable
//serializable : cet objet java on peut le transformer en n'imorote quel langage : json par ex....
public class NotePK implements Serializable{

	
	@Column(name="id_etudiant")
	private Integer etudiant;
	
	@Column(name="id_matiere")
	private Integer matiere;

	public Integer getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Integer etudiant) {
		this.etudiant = etudiant;
	}

	public Integer getMatiere() {
		return matiere;
	}

	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}
	
	
}
