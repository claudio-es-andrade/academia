package claudioESandrade.academia.DTO;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class AlunoForm {
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;

	@NotEmpty(message = "Preencha o campo corretamente.")
	//@CPF(message = "'${validatedValue}' é inválido!")
	private String cpf;

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String bairro;

	@NotNull(message = "Prencha o campo corretamente.")
	@Past(message = "Data '${validatedValue}' é inválida.")
	private LocalDate dataDeNascimento;

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

	public AlunoForm() {
		super();
	}

	public AlunoForm(
			@NotEmpty(message = "Preencha o campo corretamente.") @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.") String nome,
			@NotEmpty(message = "Preencha o campo corretamente.") String cpf,
			@NotEmpty(message = "Preencha o campo corretamente.") @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.") String bairro,
			@NotNull(message = "Prencha o campo corretamente.") @Past(message = "Data '${validatedValue}' é inválida.") LocalDate dataDeNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.bairro = bairro;
		this.dataDeNascimento = dataDeNascimento;
	}
}
