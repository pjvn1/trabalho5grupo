package com.algaworks.awpag.domain.repository;
import com.algaworks.awpag.domain.model.Subfamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubfamiliaRepository extends JpaRepository<Subfamilia, Long> {

    List<Subfamilia> findBySubfamilia(String subfamilia);
    List<Subfamilia> findBySubfamiliaContaining(String subfamilia);
    Optional<Subfamilia> findBysubfamilia(String subfamilia);

}
