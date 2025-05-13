package lucas.school.service;

import static br.com.lucas.mapper.ObjectMapper.parseListObjects;
import static br.com.lucas.mapper.ObjectMapper.parseObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.data.dto.DisciplinaDTO;
import lucas.school.models.Disciplina;
import lucas.school.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public List<DisciplinaDTO> findAll() {
		return parseListObjects(repository.findAll(), DisciplinaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public DisciplinaDTO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Aluno com ID " + id + " não encontrado"));
		return parseObject(entity, DisciplinaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// create a person
	public DisciplinaDTO create(DisciplinaDTO disciplina) {
		var entity = parseObject(disciplina, Disciplina.class);
		return parseObject(repository.save(entity), DisciplinaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public DisciplinaDTO update(DisciplinaDTO disciplina) {
	    Disciplina existing = repository.findById(disciplina.getId())
	        .orElseThrow(() -> new EntityNotFoundException("DisciplinaDTO não encontrado"));
	    existing.setNome(disciplina.getNome());
	    existing.setCargaHoraria(disciplina.getCargaHoraria());
	    existing.setDescricao(disciplina.getDescricao());
	    
	    return parseObject(repository.save(existing), DisciplinaDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Disciplina entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("DisciplinaDTO com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
