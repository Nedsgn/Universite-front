package fr.nedjma.universite.matiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nedjma.universite.matiere.domain.Matieres;

@Repository

public interface IMatiereRepository extends JpaRepository<Matieres, Integer>{

}
