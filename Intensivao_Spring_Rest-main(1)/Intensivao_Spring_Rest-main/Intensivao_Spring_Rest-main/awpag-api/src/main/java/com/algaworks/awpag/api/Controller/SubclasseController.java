package com.algaworks.awpag.api.Controller;

import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.model.Subclasse;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.algaworks.awpag.domain.repository.SubclasseRepository;
import com.algaworks.awpag.domain.service.CatalogadorService;
import com.algaworks.awpag.domain.service.SubclasseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/subclasse")
public class SubclasseController {

    private final SubclasseService subclasseService;
    private final SubclasseRepository subclasseRepository;

    public SubclasseController(SubclasseService subclasseService, SubclasseRepository subclasseRepository) {
        this.subclasseService = subclasseService;
        this.subclasseRepository = subclasseRepository;
    }

    @GetMapping
    public Optional<Subclasse> listar(){
        return subclasseRepository.findBysubclasse("Lima");
    }

    @GetMapping("/{buscarsiuclasse}")
    public ResponseEntity<Subclasse> buscar(@PathVariable Long Id){
        Optional<Subclasse> subclasse = subclasseRepository.findById(Id);

        if(subclasse.isPresent()){
            return ResponseEntity.ok(subclasse.get());
        }

        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Subclasse adicionar(@Valid @RequestBody Subclasse subclasse){
        return subclasseService.salvar(subclasse);
    }

    @PutMapping("/{sbclsId}")
    public ResponseEntity<Subclasse> atualizar(@Valid @PathVariable Long Id, @RequestBody Subclasse subclasse){
        if(!subclasseRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }
        subclasse.setId(Id);
        Subclasse subclasseAtualizado = subclasseService.salvar(subclasse);
        return ResponseEntity.ok(subclasseAtualizado);
    }

    @DeleteMapping("/{subclxluir}")
    public ResponseEntity<Void> excluir(@PathVariable Long Id){
        if(!subclasseRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }

        subclasseService.excluir(Id);
        return ResponseEntity.noContent().build();

    }


}
