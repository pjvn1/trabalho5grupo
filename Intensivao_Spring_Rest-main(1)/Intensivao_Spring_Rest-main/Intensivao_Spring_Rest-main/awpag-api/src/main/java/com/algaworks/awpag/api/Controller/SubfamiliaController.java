package com.algaworks.awpag.api.Controller;
import com.algaworks.awpag.domain.model.Subfamilia;
import com.algaworks.awpag.domain.repository.SubfamiliaRepository;
import com.algaworks.awpag.domain.service.SubfamiliaService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import com.algaworks.awpag.domain.model.Catalogador;
import com.algaworks.awpag.domain.repository.CatalogadorRepository;
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
@RequestMapping("/subfamilia")
@Controller
public class SubfamiliaController {

    @Autowired
    private final SubfamiliaService subfamiliaService;
    @Autowired
    private final SubfamiliaRepository subfamiliaRepository;

    @GetMapping
    public List<Subfamilia> listar(){
        return subfamiliaRepository.findBySubfamilia("teste");
    }

    @GetMapping("/{subfamilkiaId}")
    public ResponseEntity<Subfamilia> buscar(@PathVariable Long Id){
        Optional<Subfamilia> subfamilia = subfamiliaRepository.findById(Id);

        if(subfamilia.isPresent()){
            return ResponseEntity.ok(subfamilia.get());
        }

        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Subfamilia adicionar(@Valid @RequestBody Subfamilia subfamilia){
        return subfamiliaService.salvar(subfamilia);
    }

    @PutMapping("/{subfamiliaId}")
    public ResponseEntity<Subfamilia> atualizar(@Valid @PathVariable Long Id, @RequestBody Subfamilia subfamilia){
        if(!subfamiliaRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }
        subfamilia.setId(Id);
        Subfamilia subfamiliaAtualizado = subfamiliaService.salvar(subfamilia);
        return ResponseEntity.ok(subfamiliaAtualizado);
    }

    @DeleteMapping("/{subfamiliexcl}")
    public ResponseEntity<Void> excluir(@PathVariable Long Id){
        if(!subfamiliaRepository.existsById(Id)){
            return ResponseEntity.notFound().build();
        }

        subfamiliaService.excluir(Id);
        return ResponseEntity.noContent().build();

    }




}
