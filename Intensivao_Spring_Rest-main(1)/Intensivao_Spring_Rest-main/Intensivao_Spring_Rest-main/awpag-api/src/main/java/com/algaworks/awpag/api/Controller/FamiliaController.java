package com.algaworks.awpag.api.Controller;

import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.model.Classe;
import com.algaworks.awpag.domain.model.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.algaworks.awpag.domain.repository.FamiliaRepository;
import com.algaworks.awpag.domain.service.CatalogadorService;
import com.algaworks.awpag.domain.service.FamiliaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/familia")
public class FamiliaController {
@Autowired
    private final FamiliaService familiaService;
@Autowired
    private final FamiliaRepository familiaRepository;

    public FamiliaController(FamiliaService familiaService, FamiliaRepository familiaRepository) {
        this.familiaService = familiaService;
        this.familiaRepository = familiaRepository;
    }

    @GetMapping
    public List<Familia> listar(){
        return familiaRepository.findByFamilia("Lima");
    }

    @GetMapping("/{famlisId}")
    public ResponseEntity<Familia> buscar(@PathVariable Long Id){
        Optional<Familia> familia = familiaRepository.findById(Id);

        if(familia.isPresent()){
            return ResponseEntity.ok(familia.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{famat}")
    public ResponseEntity<Familia> atualizar(@Valid @PathVariable Long Id, @RequestBody Familia Familia){
        if(!familiaRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }
        Familia.setId(Id);
        Familia familiaAtualizada = familiaService.salvar(Familia);
        return ResponseEntity.ok(familiaAtualizada);
    }



    @DeleteMapping("/{famId}")
    public ResponseEntity<Void> excluir(@PathVariable Long Id){
        if(!familiaRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }

        familiaService.excluir(Id);
        return ResponseEntity.noContent().build();

    }


}
