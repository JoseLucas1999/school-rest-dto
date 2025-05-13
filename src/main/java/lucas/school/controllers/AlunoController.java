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

import lucas.school.data.dto.AlunoDTO;
import lucas.school.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

//--------------------------------------------------------------------
//    FIND ALL 
    
    @GetMapping
    public List<AlunoDTO> findAll() {
        return service.findAll();
    }

//--------------------------------------------------------------------    
//    FIND BY ID
    
    @GetMapping("/{id}")
    public AlunoDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

//--------------------------------------------------------------------
//    CREATE
    
    @PostMapping
    public AlunoDTO create(@RequestBody AlunoDTO aluno) {
        return service.create(aluno);
    }

//--------------------------------------------------------------------
//    UPDATE
    @PutMapping
    public AlunoDTO update(@RequestBody AlunoDTO aluno) {
		return service.update(aluno);
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
