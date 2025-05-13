package lucas.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.models.Turma;
import lucas.school.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public List<Turma> findAll() {
		return repository.findAll();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public Optional<Turma> findById(Long id) {
		return repository.findById(id);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// create a person
	public Turma create(Turma turma) {
		return repository.save(turma);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public Turma update(Turma turma) {
	    Turma existing = repository.findById(turma.getId())
	        .orElseThrow(() -> new EntityNotFoundException("Turma não encontrado"));
	    existing.setNome(turma.getNome());
	    existing.setAnoLetivo(turma.getAnoLetivo());
	    return repository.save(existing);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Turma entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Turma com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
