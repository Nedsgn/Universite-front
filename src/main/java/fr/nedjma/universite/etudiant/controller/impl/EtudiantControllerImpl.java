package fr.nedjma.universite.etudiant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.nedjma.universite.etudiant.controller.IEtudiantController;
import fr.nedjma.universite.etudiant.domain.Etudiant;
import fr.nedjma.universite.etudiant.service.impl.EtudiantServiceImpl;

@RestController

public class EtudiantControllerImpl implements IEtudiantController{

	@Autowired
	EtudiantServiceImpl etudiantService;

	@Override
	@GetMapping("/etudiant")
	public List<Etudiant> findAll() {
		List<Etudiant> liste = etudiantService.findAll();
		return liste;
	}

	@Override
	@GetMapping("/etudiant/{id}")
	public Etudiant findOne(@PathVariable Integer id) {
		Etudiant e = etudiantService.findOne(id);
		return e;
	}

	@Override
	@DeleteMapping("/etudiant/{id}")
	public void delete(@PathVariable Integer id) {
		etudiantService.suppr(id);		
	}

	@Override
	@PutMapping("/etudiant/{id}")
	public Etudiant update(@RequestBody Etudiant etudiant, @PathVariable Integer id) {//on va plus lui donner un inout id dans le form mais dans l'url
		//la il me donne létudiant mais pas l'id si on le fais pas il va rajouter un nouvel etudiant
		etudiant.setId(id);	
		Etudiant e = etudiantService.modif(etudiant);

		return e;
	}


}
