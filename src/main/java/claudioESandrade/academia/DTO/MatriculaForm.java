package claudioESandrade.academia.DTO;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class MatriculaForm {
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "O Id '${validatedValue}' do aluno precisa ser positivo.")
	private Long alunoId;
	
	
	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public MatriculaForm() {
		super();
	}

	public MatriculaForm(Long alunoId) {
		this.alunoId = alunoId;
	}
	
}
