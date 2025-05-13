package lucas.school.data.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lucas.school.models.Aluno;

@JacksonXmlRootElement(localName = "Turma")
public class TurmaDTO extends RepresentationModel<TurmaDTO> implements Serializable{

	private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String anoLetivo;
    private List<Aluno> alunos;

    public TurmaDTO() {}

    public TurmaDTO(Long id, String nome, String anoLetivo) {
        this.id = id;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TurmaDTO)) return false;
        TurmaDTO turmaDTO = (TurmaDTO) o;
        return id != null && id.equals(turmaDTO.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAnoLetivo() { return anoLetivo; }
    public void setAnoLetivo(String anoLetivo) { this.anoLetivo = anoLetivo; }

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
    
    
}
