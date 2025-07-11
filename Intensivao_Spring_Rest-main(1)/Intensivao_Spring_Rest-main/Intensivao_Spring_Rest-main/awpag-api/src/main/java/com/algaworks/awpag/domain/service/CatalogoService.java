package com.algaworks.awpag.domain.service;
import com.algaworks.awpag.domain.model.Catalogo;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.repository.CatalogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoService {


    private final CatalogoRepository catalogoRepository;

    public Catalogo buscar(long Id){
        return  catalogoRepository.findById(Id)
                .orElseThrow(() -> new NegocioException("Cleinte não encontrado"));
    }


    @Transactional
    public Catalogo salvar(Catalogo Catalogo){
        boolean nomeEmUso = catalogoRepository.findBycatalogo(Catalogo.getCatalogo())
                .filter(catalogo1 -> !catalogo1.equals(Catalogo))
                .isPresent();

        if(nomeEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return catalogoRepository.save(Catalogo);
    }

    @Transactional
    public void excluir(Long Id){
        catalogoRepository.deleteById(Id);
    }


}
