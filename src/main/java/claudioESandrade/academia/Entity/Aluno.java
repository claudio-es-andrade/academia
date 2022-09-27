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


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
