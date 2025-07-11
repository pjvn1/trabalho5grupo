package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.model.Subclasse;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.SubclasseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class SubclasseService {


    private final SubclasseRepository subclasseRepository;

    public Subclasse buscar(long Id){
        return  subclasseRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("Cleinte não encontrado"));
    }


    @Transactional
    public Subclasse salvar(Subclasse subclasse){
        boolean nomeEmUso = subclasseRepository.findBysubclasse(subclasse.getSubclasse())
                .filter(subclasse1 -> !subclasse1.equals(subclasse))
                .isPresent();

        if(nomeEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return subclasseRepository.save(subclasse);
    }

    @Transactional
    public void excluir(Long Id){
        subclasseRepository.deleteById(Id);
    }


}
