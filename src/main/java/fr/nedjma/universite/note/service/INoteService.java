package fr.nedjma.universite.note.service;

import java.util.List;

import fr.nedjma.universite.note.domain.Note;

public interface INoteService {
public List<Note> findAll();
public Note addOne(Note note);
public Note findOne(Integer idEtudiant, Integer idMatiere);
}
