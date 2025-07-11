package com.algaworks.awpag.domain.repository;

import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

    List<Familia> findByFamilia(String Familia);
    List<Familia> findByFamiliaContaining(String Familia);
    Optional<Familia> findByfamilia(String Familia);



}
