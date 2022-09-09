package claudioESandrade.academia.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import claudioESandrade.academia.Entity.Matricula;
import claudioESandrade.academia.Repository.MatriculaRepository;

public class AvaliacaoMedicaUpdateForm {

	@Positive(message = "O Id do aluno precisa ser positivo.")
	private Long alunoId;

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "${validatedValue}' precisa ser positivo.")
	@DecimalMax(value = "200.00", message = "'${validatedValue}' precisa ser até {value}.")
	@DecimalMin(value = "1.00", message = "'${validatedValue}' precisa ser no mínimo {value}.")
	private double peso;

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "${validatedValue}' precisa ser positivo.")
	@DecimalMin(value = "0.50", message = "'${validatedValue}' precisa ser no mínimo {value}.")
	@DecimalMax( value = "2.50", message = "'${validatedValue}' precisa ser até {value}.")
	private double altura;


	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public AvaliacaoMedicaUpdateForm() {
		super();
		
	}


	public AvaliacaoMedicaUpdateForm(	Long alunoId, double peso, double altura) {
		super();
		this.alunoId = alunoId;
		this.peso = peso;
		this.altura = altura;
	}

}
