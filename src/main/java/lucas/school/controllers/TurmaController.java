package lucas.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucas.school.data.dto.TurmaDTO;
import lucas.school.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService service;

//--------------------------------------------------------------------
//    FIND ALL 
    
    @GetMapping
    public List<TurmaDTO> findAll() {
        return service.findAll();
    }

//--------------------------------------------------------------------    
//    FIND BY ID
    
    @GetMapping("/{id}")
    public TurmaDTO findById(@PathVariable Long id) {
        return service.findById(id);

    }

//--------------------------------------------------------------------
//    CREATE
    
    @PostMapping
    public TurmaDTO create(@RequestBody TurmaDTO turma) {
        return service.create(turma);
    }

//--------------------------------------------------------------------
//    UPDATE
    @PutMapping
    public TurmaDTO update(@RequestBody TurmaDTO turma) {
		return service.update(turma);
    }

//--------------------------------------------------------------------
//    DELETE
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
//--------------------------------------------------------------------    
}
