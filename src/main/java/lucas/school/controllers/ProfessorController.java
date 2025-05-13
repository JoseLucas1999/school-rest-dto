package lucas.school.controllers;

import java.util.List;
import java.util.Optional;

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

import lucas.school.models.Professor;
import lucas.school.repository.ProfessorRepository;
import lucas.school.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

//--------------------------------------------------------------------
//    FIND ALL 
    
    @GetMapping
    public List<Professor> findAll() {
        return service.findAll();
    }

//--------------------------------------------------------------------    
//    FIND BY ID
    
    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

//--------------------------------------------------------------------
//    CREATE
    
    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return service.create(professor);
    }

//--------------------------------------------------------------------
//    UPDATE
    @PutMapping
    public Professor update(@RequestBody Professor professor) {
		return service.update(professor);
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
