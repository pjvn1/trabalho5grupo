package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Catalogador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogadorService {
    private final CatalogadorRepository catalogadorRepository;
    public Catalogador buscar(long Id){
        return  catalogadorRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("catalogador não encontrado"));
    }
    @Transactional
    public Catalogador salvar(Catalogador catalogador) {
        boolean nomeEmUso = catalogadorRepository.findBynome(catalogador.getNome())
                .filter(c -> !c.equals(catalogador))
                .isPresent();
        if (nomeEmUso) {
            throw new NegocioException("Já existe um catalogador cadastrado com esse nome");
        }
        return catalogadorRepository.save(catalogador);
    }
    @Transactional
    public void excluir(Long Id){
        catalogadorRepository.deleteById(Id);
    }
}
