package com.algaworks.awpag.domain.service;
import com.algaworks.awpag.domain.model.Filo;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.repository.FiloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FiloService {


    private final FiloRepository filoRepository;

    public Filo buscar(long Id){
        return  filoRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("filo não encontrado"));
    }


    @Transactional
    public Filo salvar(Filo filo){
        boolean filoEmUso = filoRepository.findByfilo(filo.getFilo())
                .filter(filo1 -> !filo1.equals(filo))
                .isPresent();

        if(filoEmUso){
            throw new NegocioException("Já existe um filo cadastrado");
        }

        return filoRepository.save(filo);
    }

    @Transactional
    public void excluir(Long Id){
        filoRepository.deleteById(Id);
    }


}
