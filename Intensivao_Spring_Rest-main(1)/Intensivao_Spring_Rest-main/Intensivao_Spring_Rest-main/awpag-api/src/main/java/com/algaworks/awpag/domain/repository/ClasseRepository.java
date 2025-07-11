package com.algaworks.awpag.domain.repository;


import com.algaworks.awpag.domain.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {


    List<Classe> findByClasseContaining(String Classe);
    Optional<Classe> findByClasse(String Classe);

}