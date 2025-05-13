package lucas.school.data.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lucas.school.models.Disciplina;

@JacksonXmlRootElement(localName = "Professor")
public class ProfessorDTO extends RepresentationModel<ProfessorDTO> implements Serializable{

	private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Disciplina disciplina;
	private String gender;

    public ProfessorDTO() {
		super();
	}

    public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}

	public String getTelefone() {return telefone;}
	public void setTelefone(String telefone) {this.telefone = telefone;}

	public Disciplina getDisciplina() {return disciplina;}
	public void setDisciplina(Disciplina disciplina) {this.disciplina = disciplina;}
	
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	
	
}
