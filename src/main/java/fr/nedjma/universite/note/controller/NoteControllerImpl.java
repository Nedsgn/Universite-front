package fr.nedjma.universite.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.nedjma.universite.note.domain.Note;
import fr.nedjma.universite.note.service.impl.NoteServiceImpl;

@RestController
public class NoteControllerImpl implements INoteController{

	@Autowired
	NoteServiceImpl noteService;

	@Override
	@GetMapping("/note")
	public List<Note> findAll() {
		List<Note> liste = noteService.findAll();
		return liste;
	}

	@Override
	@GetMapping("/note/{idEtudiant}/{idMatiere}")//convention quand on récupère deux clés (étrangeres)
	public Note findOne(@PathVariable Integer idEtudiant, @PathVariable Integer idMatiere) {//pathvariable sert à expliquer que c'est pour que la variable se retrouve dans un url
		Note N = noteService.findOne(idEtudiant, idMatiere)	;
		return N;


	}

	@Override
	@PostMapping("/note")
	//avan ton lui donnait un formulaire avec model attrivbute , quand on fait du rest c'est @request body. il va recevoir du json et va le transformer en jva. c'est lequivalent de modelattribute quand on utilise thymeleaf dans le front
	public Note save(@RequestBody Note note) {
		Note n = noteService.addOne(note);
		return n;
	}


}