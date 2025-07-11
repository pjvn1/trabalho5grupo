package com.algaworks.awpag.api.Controller;

import com.algaworks.awpag.domain.model.Classe;
import com.algaworks.awpag.domain.repository.ClasseRepository;
import com.algaworks.awpag.domain.service.ClasseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classe")
@AllArgsConstructor
public class ClasseController {

    private final ClasseService classeService;
    private final ClasseRepository classeRepository;

    @GetMapping
    public ResponseEntity<List<Classe>> listar() {
        List<Classe> classes = classeRepository.findAll();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> buscar(@PathVariable Long id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Classe adicionar(@Valid @RequestBody Classe classe) {
        return classeService.salvar(classe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classe> atualizar(@Valid @PathVariable Long id, @RequestBody Classe classe) {
        if (!classeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        classe.setId(id);
        Classe classeAtualizada = classeService.salvar(classe);
        return ResponseEntity.ok(classeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!classeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        classeService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
