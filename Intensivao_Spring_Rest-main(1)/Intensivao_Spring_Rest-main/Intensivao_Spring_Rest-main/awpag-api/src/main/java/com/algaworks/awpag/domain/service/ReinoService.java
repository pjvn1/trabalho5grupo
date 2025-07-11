package com.algaworks.awpag.domain.service;
import com.algaworks.awpag.domain.model.Reino;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.ReinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ReinoService {


    private final ReinoRepository reinoRepository;

    public Reino buscar(long Id){
        return  reinoRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("Cleinte não encontrado"));
    }


    @Transactional
    public Reino salvar(Reino Reino){
        boolean nomeEmUso = reinoRepository.findByreino(Reino.getReino())
                .filter(catalogador1 -> !catalogador1.equals(Reino))
                .isPresent();

        if(nomeEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return reinoRepository.save(Reino);
    }

    @Transactional
    public void excluir(Long Id){
        reinoRepository.deleteById(Id);
    }


}
