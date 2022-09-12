package claudioESandrade.academia.Service;

import java.util.List;
import java.util.Optional;

import claudioESandrade.academia.DTO.MatriculaForm;
import claudioESandrade.academia.Entity.Matricula;

public interface IMatriculaService {
	
	/**
	   * Cria uma Matrícula e salva no banco de dados.
	   * @param form - formulário referente aos dados para criação da Matrícula no banco de dados.
	   * @return - Matrícula recém-criada.
	   */
	  Matricula criar(MatriculaForm form);

	  /**
	   * Retorna uma Matrícula que está no banco de dados de acordo com seu Id.
	   * @param id - id da Matrícula que será exibida.
	   * @return - Matrícula de acordo com o Id fornecido.
	   */
	  Optional<Matricula> obter(Long id);

	  /**
	   * Retorna todas as Matrículas que estão no banco de dados.
	   * @return - uma lista com todas as Matrículas que estão salvas no DB.
	   */
	  List<Matricula> obterTodos(String bairro);

	  /**
	   * Deleta uma Matrícula específica.
	   * @param id - id da Matrícula que será removida.
	   */
	  void apagar(Long id);
	
	
}
