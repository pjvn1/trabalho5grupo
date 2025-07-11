package com.algaworks.awpag.domain.repository;

import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.model.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {

    List<Ordem> findByOrdem(String Ordem);
    List<Ordem> findByOrdemContaining(String Ordem);
    Optional<Ordem> findByordem(String Ordem);

}
