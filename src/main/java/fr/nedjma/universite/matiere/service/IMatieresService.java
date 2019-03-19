package fr.nedjma.universite.matiere.service;

import java.util.List;

import fr.nedjma.universite.matiere.domain.Matieres;


public interface IMatieresService {
	public List<Matieres> findAll();
	public Matieres findOne(Integer id);
	public Matieres add(Matieres matieres);
	public void suppr(Integer id);
	public Matieres modif(Matieres matieres);
	 
}
