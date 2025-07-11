package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.model.Familia;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.FamiliaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FamiliaService {


    private final FamiliaRepository familiarRepository;

    public Familia buscar(long Id){
        return  familiarRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("Cleinte não encontrado"));
    }


    @Transactional
    public Familia salvar(Familia Familia){
        boolean nomeEmUso = familiarRepository.findByfamilia(Familia.getFamilia())
                .filter(catalogador1 -> !catalogador1.equals(Familia))
                .isPresent();

        if(nomeEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return familiarRepository.save(Familia);
    }

    @Transactional
    public void excluir(Long Id){
        familiarRepository.deleteById(Id);
    }


}
