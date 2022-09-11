package claudioESandrade.academiaJDK11.DTO;

import javax.validation.constraints.DecimalMax;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoMedicaForm {
	
	@Positive(message = "O Id '${validatedValue}' do aluno precisa ser positivo.")
	private Long alunoId;

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "'${validatedValue}' precisa ser positivo.")
	@DecimalMax(value = "200.00", message = "'${validatedValue}' precisa ser até {value}.")
	@DecimalMin(value = "1.00", message = "'${validatedValue}' precisa ser no mínimo {value}.")
	private double peso;

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "$'{validatedValue}' precisa ser positivo.")
	@DecimalMin(value = "0.50", message = "'${validatedValue}' precisa ser no mínimo {value}.")
	@DecimalMax( value = "2.50", message = "'${validatedValue}' precisa ser até {value}.")
	private double altura;

}
