package com.algaworks.awpag.domain.repository;

  import com.algaworks.awpag.domain.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

  @Repository
  public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {

      List<Catalogo> findByCatalogo(String Catalogo);
      Optional<Catalogo> findByCatalogoContaining(String Catalogo);
      Optional<Catalogo> findBycatalogo(String Catalogador);

  }
