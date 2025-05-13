package lucas.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.models.Disciplina;
import lucas.school.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public List<Disciplina> findAll() {
		return repository.findAll();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public Optional<Disciplina> findById(Long id) {
		return repository.findById(id);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// create a person
	public Disciplina create(Disciplina disciplina) {
		return repository.save(disciplina);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public Disciplina update(Disciplina disciplina) {
	    Disciplina existing = repository.findById(disciplina.getId())
	        .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrado"));
	    existing.setNome(disciplina.getNome());
	    existing.setCargaHoraria(disciplina.getCargaHoraria());
	    existing.setDescricao(disciplina.getDescricao());
	    return repository.save(existing);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Disciplina entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Disciplina com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
