package lucas.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.models.Aluno;
import lucas.school.models.Turma;
import lucas.school.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public List<Aluno> findAll() {
		return repository.findAll();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public Optional<Aluno> findById(Long id) {
		return repository.findById(id);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// create a person
	public Aluno create(Aluno aluno) {
		return repository.save(aluno);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public Aluno update(Aluno aluno) {
	    Aluno existing = repository.findById(aluno.getId())
	        .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
	    existing.setNome(aluno.getNome());
	    existing.setCpf(aluno.getCpf());
	    existing.setEmail(aluno.getEmail());
	    existing.setTelefone(aluno.getTelefone());
	    existing.setGender(aluno.getGender());
	    
	    Turma novaTurma = new Turma();
	    novaTurma.setId(aluno.getTurma().getId());
	    existing.setTurma(novaTurma);
	    
	    return repository.save(existing);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Aluno entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Aluno com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
