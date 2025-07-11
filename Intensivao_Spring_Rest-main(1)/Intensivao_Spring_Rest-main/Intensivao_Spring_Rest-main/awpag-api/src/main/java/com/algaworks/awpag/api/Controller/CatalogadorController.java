package com.algaworks.awpag.api.Controller;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
import com.algaworks.awpag.domain.service.CatalogadorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/catalogador")
public class CatalogadorController {
    private final CatalogadorService catalogadorService;
    private final CatalogadorRepository catalogadorRepository;
    @GetMapping
    public List<Catalogador> listar(){
        return catalogadorRepository.findAll();
    }
    @GetMapping("/{ctlgdrId}")
    public ResponseEntity<Catalogador> buscar(@PathVariable Long ctlgdrId){
        Optional<Catalogador> catalogador = catalogadorRepository.findById(ctlgdrId);
        if(catalogador.isPresent()){
            return ResponseEntity.ok(catalogador.get());
        }
        return ResponseEntity.notFound().build();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Catalogador adicionar(@Valid @RequestBody Catalogador catalogador) {
        return catalogadorService.salvar(catalogador);
    }
    @PutMapping("/{ctlgdrIdatualiz}")
    public ResponseEntity<Catalogador> atualizar(@Valid @PathVariable Long ctlgdrId, @RequestBody Catalogador catalogador) {
        if (!catalogadorRepository.existsById(ctlgdrId)) {
            return ResponseEntity.notFound().build();
        }
        catalogador.setId(ctlgdrId);
        Catalogador catalogadorAtualizado = catalogadorService.salvar(catalogador);
        return ResponseEntity.ok(catalogadorAtualizado);
    }
    @DeleteMapping("/{ctlgdrIdexlc}")
    public ResponseEntity<Void> excluir(@PathVariable Long ctlgdrId) {
        if (!catalogadorRepository.existsById(ctlgdrId)) {
            return ResponseEntity.notFound().build();
        }

        catalogadorService.excluir(ctlgdrId);
        return ResponseEntity.noContent().build();
    }
}
