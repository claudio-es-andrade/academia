package claudioESandrade.academia.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	String nome;
	
	@Column(unique = true)
	String cpf;
	String bairro;
	LocalDate dataDeNascimento;
	
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AvaliacaoMedica> avaliacoes = new ArrayList<>();
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public List<AvaliacaoMedica> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<AvaliacaoMedica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public Aluno() {
		super();
	}
	public Aluno(Long id, String nome, String cpf, String bairro, LocalDate dataDeNascimento,
			List<AvaliacaoMedica> avaliacoes) {
		super();
		Id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.bairro = bairro;
		this.dataDeNascimento = dataDeNascimento;
		this.avaliacoes = avaliacoes;
	}
	
	

}
