package fr.nedjma.universite.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.nedjma.universite.note.domain.Note;
import fr.nedjma.universite.note.domain.NotePK;
import fr.nedjma.universite.note.repository.INoteRepository;
import fr.nedjma.universite.note.service.INoteService;
@Service
public class NoteServiceImpl implements INoteService{

	@Autowired
	INoteRepository noteRepository;

	@Override
	public List<Note> findAll() {
		List<Note> liste = noteRepository.findAll();

		return liste;
	}
	//mon service permet de sauvegarder une note
	@Override
	public Note addOne(Note note) {
		Note notes = noteRepository.save(note);
		return notes;
	}
	@Override
	public Note findOne(Integer idEtudiant, Integer idMatiere) {
		//on crée un objet qui va etre récupérer das le getOne car on pas un id (clé primaire) mais un objet de type NotePK
		NotePK npk= new NotePK();
		npk.setEtudiant(idEtudiant);
		npk.setMatiere(idMatiere);
		Note n = noteRepository.getOne(npk)	;
		return n;//il nous renvoie la note de l'étudiant dans cette matiere mais comme on est dans la clé primaire , on est obligé de lui demander les elements qui la compose
	}




}
