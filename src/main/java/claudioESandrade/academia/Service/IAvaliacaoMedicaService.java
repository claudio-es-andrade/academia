package claudioESandrade.academia.Service;

import java.util.List;
import java.util.Optional;

import claudioESandrade.academia.DTO.AvaliacaoMedicaForm;
import claudioESandrade.academia.DTO.AvaliacaoMedicaUpdateForm;
import claudioESandrade.academia.Entity.AvaliacaoMedica;

public interface IAvaliacaoMedicaService {
	
	/**
	   * Cria uma Avaliação Física e salva no banco de dados.
	   * @param form - formulário referente aos dados para criação da Avaliação Física no banco de dados.
	   * @return - Avaliação Física recém-criada.
	   */
	  AvaliacaoMedica criar(AvaliacaoMedicaForm form);

	  /**
	   * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
	   * @param id - id da Avaliação Física que será exibida.
	   * @return - Avaliação Física de acordo com o Id fornecido.
	   */
	  Optional <AvaliacaoMedica> obter(Long id);

	  /**
	   * Retorna todas as Avaliações Física que estão no banco de dados.
	   * @return - Uma lista com todas as Avaliações Física que estão salvas no DB.
	   */
	  List<AvaliacaoMedica> obterTodos();

	  /**
	   * Atualiza a avaliação física.
	   * @param id - id da Avaliação Física que será atualizada.
	   * @param formUpdate - formulário referente aos dados necessários para atualização da Avaliação
	   * Física no banco de dados.
	   * @return - Avaliação Física recém-atualizada.
	   */
	  AvaliacaoMedica atualizar(Long id, AvaliacaoMedicaUpdateForm formUpdate);

	  /**
	   * Deleta uma Avaliação Física específica.
	   * @param id - id da Avaliação Física que será removida.
	   */
	  void apagar(Long id);
	
}
