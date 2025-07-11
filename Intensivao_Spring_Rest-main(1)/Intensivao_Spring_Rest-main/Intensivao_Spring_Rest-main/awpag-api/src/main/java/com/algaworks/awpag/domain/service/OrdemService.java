package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.model.Ordem;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.OrdemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OrdemService {


    private final OrdemRepository ordemRepository;

    public Ordem buscar(long Id){
        return  ordemRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("Cleinte não encontrado"));
    }


    @Transactional
    public Ordem salvar(Ordem Ordem){
        boolean ordemEmUso = ordemRepository.findByordem(Ordem.getOrdem())
                .filter(ordem1 -> !ordem1.equals(Ordem))
                .isPresent();

        if(ordemEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return ordemRepository.save(Ordem);
    }

    @Transactional
    public void excluir(Long Id){
        ordemRepository.deleteById(Id);
    }


}
