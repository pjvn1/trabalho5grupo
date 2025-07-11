package com.algaworks.awpag.domain.repository;

import com.algaworks.awpag.domain.model.Catalogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogadorRepository extends JpaRepository<Catalogador, Long> {

    List<Catalogador> findByNome(String nome);

    List<Catalogador> findByNomeContaining(String nome);
    Optional<Catalogador> findBynome(String Nome);

}
