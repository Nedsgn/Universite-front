package fr.nedjma.universite.etudiant.controller;

import java.util.List;

import fr.nedjma.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {
	public List<Etudiant> findAll();

	public Etudiant findOne(Integer id);
	
	public void delete(Integer id);
	
	public Etudiant update(Etudiant etudiant, Integer id);

}
