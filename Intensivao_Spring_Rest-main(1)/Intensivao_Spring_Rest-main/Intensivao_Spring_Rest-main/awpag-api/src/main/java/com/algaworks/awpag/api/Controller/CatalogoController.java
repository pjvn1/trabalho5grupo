package com.algaworks.awpag.api.Controller;

import com.algaworks.awpag.domain.model.Catalogo;
import com.algaworks.awpag.domain.repository.CatalogoRepository;
import com.algaworks.awpag.domain.service.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private CatalogoRepository catalogoRepository;

    @GetMapping
    public ResponseEntity<List<Catalogo>> listar() {
        List<Catalogo> catalogo = catalogoRepository.findAll();
        return ResponseEntity.ok(catalogo);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<Catalogo> buscar(@PathVariable Long catId) {
        Optional<Catalogo> catalogo = catalogoRepository.findById(catId);

        if (catalogo.isPresent()) {
            return ResponseEntity.ok(catalogo.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Catalogo> adicionar(@RequestBody Catalogo catalogo) {
        Catalogo novoCatalogo = catalogoService.salvar(catalogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCatalogo);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<Catalogo> atualizar(@PathVariable Long catId, @RequestBody Catalogo catalogo) {
        Optional<Catalogo> catOptional = catalogoRepository.findById(catId);
        if (!catOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Catalogo catToUpdate = catOptional.get();
        catToUpdate.setCatalogo(catalogo.getCatalogo());
        Catalogo catalogoAtualizado = catalogoService.salvar(catToUpdate);
        return ResponseEntity.ok(catalogoAtualizado);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<Void> excluir(@PathVariable Long catId) {
        if (!catalogoRepository.existsById(catId)) {
            return ResponseEntity.notFound().build();
        }

        catalogoService.excluir(catId);
        return ResponseEntity.noContent().build();
    }
}
