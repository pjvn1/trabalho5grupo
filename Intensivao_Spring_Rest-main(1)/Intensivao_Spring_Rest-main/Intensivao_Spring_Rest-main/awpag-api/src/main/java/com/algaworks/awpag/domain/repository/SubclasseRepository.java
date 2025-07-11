package com.algaworks.awpag.domain.repository;

import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.model.Subclasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubclasseRepository extends JpaRepository<Subclasse, Long> {

    List<Subclasse> findBySubclasse(String Subclasse);
    List<Subclasse> findBySubclasseContaining(String Subclasse);
    Optional<Subclasse> findBysubclasse(String Subclasse);

}
