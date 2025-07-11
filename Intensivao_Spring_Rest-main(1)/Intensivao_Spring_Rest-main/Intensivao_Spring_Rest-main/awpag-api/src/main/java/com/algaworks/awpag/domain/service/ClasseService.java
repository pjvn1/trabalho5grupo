package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.model.Classe;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.ClasseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClasseService {


    private final ClasseRepository classeRepository;

    public Classe buscar(long Id){
        return  classeRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("Cleinte não encontrado"));
    }


    @Transactional
    public Classe salvar(Classe Classe){
        boolean nomeEmUso = classeRepository.findByClasse(Classe.getClasse())
                .filter(catalogador1 -> !catalogador1.equals(Classe))
                .isPresent();

        if(nomeEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return classeRepository.save(Classe);
    }

    @Transactional
    public void excluir(Long Id){
        classeRepository.deleteById(Id);
    }


}
