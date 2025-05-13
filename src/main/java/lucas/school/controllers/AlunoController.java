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

import lucas.school.models.Aluno;
import lucas.school.repository.AlunoRepository;
import lucas.school.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

//--------------------------------------------------------------------
//    FIND ALL 
    
    @GetMapping
    public List<Aluno> findAll() {
        return service.findAll();
    }

//--------------------------------------------------------------------    
//    FIND BY ID
    
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

//--------------------------------------------------------------------
//    CREATE
    
    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return service.create(aluno);
    }

//--------------------------------------------------------------------
//    UPDATE
    @PutMapping
    public Aluno update(@RequestBody Aluno aluno) {
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

/*

create via postman com JSON

{
    "nome": "Marcio Gomez",
    "cpf": "34567890123",
    "email": "Marcio.gomez@email.com",
    "telefone": "11977777555",
    "turma": {
        "id": 3
    },
    "gender": "MASC"
}

update via postman com JSON

{
    "id": 5,
    "nome": "Marcio Gomez",
    "cpf": "34567834123",
    "email": "Marcio.gomez@email.com",
    "telefone": "11977777555",
    "turma": {
        "id": 3
    },
    "gender": "MASC"
}

*/
