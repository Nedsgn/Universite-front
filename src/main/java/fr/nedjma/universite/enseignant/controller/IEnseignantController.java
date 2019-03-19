package fr.nedjma.universite.enseignant.controller;

import java.util.List;

import fr.nedjma.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {
	public List<Enseignant> findAll();
	
	public Enseignant findOne(Integer id);
	
	public Enseignant save(Enseignant enseignant);
	public void delete(Integer id);
	public Enseignant update(Enseignant enseignant, Integer id);	
}
