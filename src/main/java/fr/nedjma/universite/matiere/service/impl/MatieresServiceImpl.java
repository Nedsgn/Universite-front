package fr.nedjma.universite.matiere.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.nedjma.universite.matiere.domain.Matieres;
import fr.nedjma.universite.matiere.repository.IMatiereRepository;
import fr.nedjma.universite.matiere.service.IMatieresService;

@Service

public class MatieresServiceImpl implements IMatieresService{

	@Autowired
	IMatiereRepository matiereRepository;

	@Override
	public List<Matieres> findAll() {
		List<Matieres> liste = matiereRepository.findAll();


		return liste;
	}

	@Override
	public Matieres findOne(Integer id) {
		Matieres mat = matiereRepository.getOne(id);	
		return mat;
	}

	@Override
	public Matieres add(Matieres matieres) {
		Matieres matAdd = matiereRepository.save(matieres);//save : le nom de l'objet Matieres qui est matieres
		return matAdd;
	}

	@Override
	public void suppr(Integer id) {
		matiereRepository.deleteById(id);

	}

	@Override
	public Matieres modif(Matieres matieres) {
		Matieres matModif = matiereRepository.save(matieres);
		return matModif;
	}

}
