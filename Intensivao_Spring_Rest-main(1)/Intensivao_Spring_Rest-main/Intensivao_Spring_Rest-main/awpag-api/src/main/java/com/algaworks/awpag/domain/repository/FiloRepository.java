package com.algaworks.awpag.domain.repository;

import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.model.Filo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FiloRepository extends JpaRepository<Filo, Long> {

    List<Filo> findByFilo(String filo);
    List<Filo> findByFiloContaining(String filo);
    Optional<Filo> findByfilo(String filo);

}
