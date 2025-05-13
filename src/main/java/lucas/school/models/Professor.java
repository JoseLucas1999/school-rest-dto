package lucas.school.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nome;
    
    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true, nullable = false)
    private String telefone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    
    @Column(nullable = false, length = 6)
	private String gender;

    // Construtores
    public Professor() {
		super();
	}

    // Getters e Setters
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
