package fr.nedjma.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.nedjma.universite.enseignant.controller.IEnseignantController;
import fr.nedjma.universite.enseignant.domain.Enseignant;
import fr.nedjma.universite.enseignant.service.impl.EnseignantServiceImpl;

@RestController
//c'est un controlleur qui va pas renvoyer vers une vue mais qui va renvyer des données , le return ce n'est pas la vue, ce que j veux retourner ces des données du /enseigant par ex

public class EnseignantControllerImpl implements IEnseignantController {
	
	
	Logger log = LoggerFactory.getLogger(EnseignantControllerImpl.class);

	@Autowired
	EnseignantServiceImpl enseignantService;
	
	@Override
	@GetMapping("/enseignants")
	public List<Enseignant> findAll() {
		//il renvoie d"sormais la liste complete
		List<Enseignant> liste = enseignantService.findAll();
		log.info("Liste enseignants {}", liste.size());	
		return liste;
		//quand le front va m'appeler il va me rnevoyer ça , c'est ce qu'on appele la sérialisation. il nous faut un lanage commun et c'est le json
	}

	@Override
	@GetMapping("/enseignants/{id}")
	//l'id fait partie de notre url
	public Enseignant findOne(@PathVariable Integer id) {
		Enseignant e = enseignantService.findOne(id);
		return e;
	}
	
	@Override
	@PostMapping("/enseignants")
	public Enseignant save(@RequestBody Enseignant enseignant) {
		Enseignant e = enseignantService.add(enseignant);
		return e;
	}

	@Override
	@DeleteMapping("/enseignants/{id}")
	public void delete(@PathVariable Integer id) {
		enseignantService.suppr(id);
		
	}

	@Override
	@PutMapping("/enseignants/{id}")
	public Enseignant update(@RequestBody Enseignant enseignant, @PathVariable Integer id) {
		enseignant.setId(id); //sinon il fait un ajout
		Enseignant e = enseignantService.modif(enseignant);
		return e;
	}


	

}
