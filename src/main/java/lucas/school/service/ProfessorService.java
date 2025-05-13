package lucas.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.models.Disciplina;
import lucas.school.models.Professor;
import lucas.school.models.Turma;
import lucas.school.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public List<Professor> findAll() {
		return repository.findAll();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public Optional<Professor> findById(Long id) {
		return repository.findById(id);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// create a person
	public Professor create(Professor professor) {
		return repository.save(professor);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public Professor update(Professor professor) {
	    Professor existing = repository.findById(professor.getId())
	        .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
	    existing.setNome(professor.getNome());
	    existing.setCpf(professor.getCpf());
	    existing.setEmail(professor.getEmail());
	    existing.setTelefone(professor.getTelefone());
	    existing.setDisciplina(professor.getDisciplina());
	    existing.setGender(professor.getGender());
	    
	    Disciplina novaDisciplina = new Disciplina();
	    novaDisciplina.setId(professor.getDisciplina().getId());
	    existing.setDisciplina(novaDisciplina);
	    
	    return repository.save(existing);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Professor entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Professor com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
