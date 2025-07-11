package com.algaworks.awpag.domain.repository;
import com.algaworks.awpag.domain.model.Reino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReinoRepository extends JpaRepository<Reino, Long> {

    List<Reino> findByReino(String Reino);
    List<Reino> findByReinoContaining(String nome);
    Optional<Reino> findByreino(String Reino);

}
