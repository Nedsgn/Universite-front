package fr.nedjma.universite.note.controller;

import java.util.List;

import fr.nedjma.universite.note.domain.Note;

public interface INoteController {
	public List<Note> findAll();
	public Note findOne(Integer idEtudiant, Integer idMatiere);
	public Note save(Note note);
}
