package lucas.school.data.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lucas.school.models.Turma;



@JacksonXmlRootElement(localName = "Aluno")
public class AlunoDTO extends RepresentationModel<AlunoDTO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Turma turma;
	private String gender;

    public AlunoDTO() {
		super();
	}

    public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

	public Turma getTurma() {return turma;}
	public void setTurma(Turma turma) {this.turma = turma;}

	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	
	
}
