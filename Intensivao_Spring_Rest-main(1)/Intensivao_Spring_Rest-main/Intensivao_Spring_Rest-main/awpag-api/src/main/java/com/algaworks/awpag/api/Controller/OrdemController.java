package com.algaworks.awpag.api.Controller;
import com.algaworks.awpag.domain.model.Ordem;
import com.algaworks.awpag.domain.repository.OrdemRepository;
import com.algaworks.awpag.domain.service.OrdemService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.algaworks.awpag.domain.service.CatalogadorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/ordem")
@Controller
public class OrdemController {

    @Autowired
    private final OrdemService ordemService;
    @Autowired
    private final OrdemRepository ordemRepository;

    @GetMapping("/{ordemlistarya}")
    public List<Ordem> listar(){
        return ordemRepository.findByOrdem("Lima");
    }

    @GetMapping("/{ordemId}")
    public ResponseEntity<Ordem> buscar(@PathVariable Long Id){
        Optional<Ordem> ordem = ordemRepository.findById(Id);

        if(ordem.isPresent()){
            return ResponseEntity.ok(ordem.get());
        }

        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Ordem adicionar(@Valid @RequestBody Ordem ordem){
        return ordemService.salvar(ordem);
    }

    @PutMapping("/{atualzarordem}")
    public ResponseEntity<Ordem> atualizar(@Valid @PathVariable Long Id, @RequestBody Ordem ordem){
        if(!ordemRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }
        ordem.setId(Id);
        Ordem ordemAtualizado = ordemService.salvar(ordem);
        return ResponseEntity.ok(ordemAtualizado);
    }

    @DeleteMapping("/{exluirordem}")
    public ResponseEntity<Void> excluir(@PathVariable Long Id){
        if(!ordemRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }

        ordemService.excluir(Id);
        return ResponseEntity.noContent().build();

    }




}
