package com.algaworks.awpag.api.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.algaworks.awpag.domain.model.Filo;
import com.algaworks.awpag.domain.repository.FiloRepository;
import com.algaworks.awpag.domain.service.FiloService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/filo")
public class FiloController {
    @Autowired
    private final FiloService filoService;
    @Autowired
    private final FiloRepository filoRepository;

    public FiloController(FiloService filoService, FiloRepository filoRepository) {
        this.filoService = filoService;
        this.filoRepository = filoRepository;
    }
    @GetMapping("/filolista")
    public String listaFilos(Model model) {
        List<Filo> filo = filoRepository.findAll();
        model.addAttribute("filos", filo);
        return "filo";
    }

    @GetMapping("/{filolistar}")
    public List<Filo> listar(){
        return filoRepository.findByFilo("");
    }

    @GetMapping("/{filobus}")
    public ResponseEntity<Filo> buscar(@PathVariable Long Id){
        Optional<Filo> filo = filoRepository.findById(Id);

        if(filo.isPresent()){
            return ResponseEntity.ok(filo.get());
        }

        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Filo adicionar(@Valid @RequestBody Filo filo){
        return filoService.salvar(filo);
    }

    @PutMapping("/{filoat}")
    public ResponseEntity<Filo> atualizar(@Valid @PathVariable Long Id, @RequestBody Filo filo){
        if(!filoRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }
        Filo filoAtualizado = filoService.salvar(filo);
        return ResponseEntity.ok(filoAtualizado);
    }

    @DeleteMapping("/{filoId}")
    public ResponseEntity<Void> excluir(@PathVariable Long Id){
        if(!filoRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }

        filoService.excluir(Id);
        return ResponseEntity.noContent().build();

    }


}
