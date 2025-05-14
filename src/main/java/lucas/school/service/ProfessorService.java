package lucas.school.service;

import static lucas.school.mapper.ObjectMapper.parseListObjects;
import static lucas.school.mapper.ObjectMapper.parseObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.data.dto.ProfessorDTO;
import lucas.school.models.Disciplina;
import lucas.school.models.Professor;
import lucas.school.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public List<ProfessorDTO> findAll() {
		return parseListObjects(repository.findAll(), ProfessorDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public ProfessorDTO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Aluno com ID " + id + " não encontrado"));
		return parseObject(entity, ProfessorDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// CREATE
	public ProfessorDTO create(ProfessorDTO professor) {
		var entity = parseObject(professor, Professor.class);
		return parseObject(repository.save(entity), ProfessorDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public ProfessorDTO update(ProfessorDTO professor) {
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
	    
	    return parseObject(repository.save(existing), ProfessorDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Professor entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Professor com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
