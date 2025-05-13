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

import lucas.school.data.dto.DisciplinaDTO;
import lucas.school.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

//--------------------------------------------------------------------
//    FIND ALL 
    
    @GetMapping
    public List<DisciplinaDTO> findAll() {
        return service.findAll();
    }

//--------------------------------------------------------------------    
//    FIND BY ID
    
    @GetMapping("/{id}")
    public DisciplinaDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

//--------------------------------------------------------------------
//    CREATE
    
    @PostMapping
    public DisciplinaDTO create(@RequestBody DisciplinaDTO disciplina) {
        return service.create(disciplina);
    }

//--------------------------------------------------------------------
//    UPDATE
    @PutMapping
    public DisciplinaDTO update(@RequestBody DisciplinaDTO disciplina) {
		return service.update(disciplina);
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
