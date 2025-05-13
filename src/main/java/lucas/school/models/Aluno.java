package lucas.school.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nome;
    
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(unique = true, nullable = false, length = 30)
    private String email;

    @Column(unique = true, nullable = false, length = 12)
    private String telefone;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id")
    private Turma turma;
    
	@Column(nullable = false, length = 6)
	private String gender;


    // Construtores
    public Aluno() {
		super();
	}
    

    // Getters e Setters
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
