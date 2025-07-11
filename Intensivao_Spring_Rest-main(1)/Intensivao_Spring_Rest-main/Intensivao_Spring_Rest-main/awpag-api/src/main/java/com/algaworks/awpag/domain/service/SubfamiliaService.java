package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.model.Subfamilia;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.SubfamiliaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class SubfamiliaService {


    private final SubfamiliaRepository subfamiliaRepository;

    public Subfamilia buscar(long Id){
        return  subfamiliaRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("subfamila não encontrada"));
    }


    @Transactional
    public Subfamilia salvar(Subfamilia subfamilia){
        boolean subfamiliaEmUso = subfamiliaRepository.findBysubfamilia(subfamilia.getSubfamilia())
                .filter(catalogador1 -> !catalogador1.equals(subfamilia))
                .isPresent();

        if(subfamiliaEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return subfamiliaRepository.save(subfamilia);
    }

    @Transactional
    public void excluir(Long Id){
        subfamiliaRepository.deleteById(Id);
    }


}
