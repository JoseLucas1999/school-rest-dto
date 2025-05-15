package lucas.school.service;

import static lucas.school.mapper.ObjectMapper.parseListObjects;
import static lucas.school.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.controllers.ProfessorController;
import lucas.school.controllers.TurmaController;
import lucas.school.data.dto.DisciplinaDTO;
import lucas.school.data.dto.TurmaDTO;
import lucas.school.models.Disciplina;
import lucas.school.models.Turma;
import lucas.school.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public List<TurmaDTO> findAll() {
		return parseListObjects(repository.findAll(), TurmaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public TurmaDTO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Aluno com ID " + id + " não encontrado"));
		return parseObject(entity, TurmaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// create a person
	public TurmaDTO create(TurmaDTO turma) {
		var entity = parseObject(turma, Turma.class);
		return parseObject(repository.save(entity), TurmaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public TurmaDTO update(TurmaDTO turma) {
	    Turma existing = repository.findById(turma.getId())
	        .orElseThrow(() -> new EntityNotFoundException("Turma não encontrado"));
	    existing.setNome(turma.getNome());
	    existing.setAnoLetivo(turma.getAnoLetivo());
	    return parseObject(repository.save(existing), TurmaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Turma entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Turma com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
