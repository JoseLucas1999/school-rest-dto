package lucas.school.service;

import static lucas.school.mapper.ObjectMapper.parseListObjects;
import static lucas.school.mapper.ObjectMapper.parseObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lucas.school.data.dto.AlunoDTO;
import lucas.school.models.Aluno;
import lucas.school.models.Turma;
import lucas.school.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// FIND ALL
	public List<AlunoDTO> findAll() {
        return parseListObjects(repository.findAll(), AlunoDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// FIND BY ID
	public AlunoDTO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Aluno com ID " + id + " não encontrado"));
		return parseObject(entity, AlunoDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	// CREATE
	
	public AlunoDTO create(AlunoDTO aluno) {
		var entity = parseObject(aluno, Aluno.class);
		return parseObject(repository.save(entity), AlunoDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public AlunoDTO update(AlunoDTO aluno) {
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
	    
	    return parseObject(repository.save(existing), AlunoDTO.class);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public void delete(Long id) {
		Aluno entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Aluno com ID " + id + " não encontrado."));
		repository.delete(entity);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
}
