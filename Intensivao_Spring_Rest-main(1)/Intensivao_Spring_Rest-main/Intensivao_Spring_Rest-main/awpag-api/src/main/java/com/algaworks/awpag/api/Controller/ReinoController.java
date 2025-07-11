package com.algaworks.awpag.api.Controller;
import org.springframework.ui.Model;
import com.algaworks.awpag.domain.model.Reino;
import com.algaworks.awpag.domain.repository.ReinoRepository;
import com.algaworks.awpag.domain.service.ReinoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
@Controller
@RestController
@RequestMapping("/reino")
public class ReinoController {
    @Autowired
    private final ReinoService reinoService;
    @Autowired
    private final ReinoRepository reinoRepository;

    public ReinoController(ReinoService reinoService, ReinoRepository reinoRepository) {
        this.reinoService = reinoService;
        this.reinoRepository = reinoRepository;
    }

    @GetMapping
    public List<Reino> listar(){
        return reinoRepository.findByReinoContaining("Lima");
    }
    @GetMapping("/{rId}")
    public ResponseEntity<Reino> buscar(@PathVariable Long Id){
        Optional<Reino> reino = reinoRepository.findById(Id);
        if(reino.isPresent()){
            return ResponseEntity.ok(reino.get());
        }
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Reino adicionar(@Valid @RequestBody Reino reino){
        return reinoService.salvar(reino);
    }

    @PutMapping("/{rId}")
    public ResponseEntity<Reino> atualizar(@Valid @PathVariable Long Id, @RequestBody Reino Reino){
        if(!reinoRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }
        Reino.setId(Id);
        Reino reinoAtualizado = reinoService.salvar(Reino);
        return ResponseEntity.ok(reinoAtualizado);
    }

    @DeleteMapping("/{rId}")
    public ResponseEntity<Void> excluir(@PathVariable Long Id){
        if(!reinoRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }

        reinoService.excluir(Id);
        return ResponseEntity.noContent().build();

    }


}
