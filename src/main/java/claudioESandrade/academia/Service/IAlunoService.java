package claudioESandrade.academia.Service;

import java.util.List;

import claudioESandrade.academia.DTO.AlunoForm;
import claudioESandrade.academia.DTO.AlunoUpdateForm;
import claudioESandrade.academia.Entity.Aluno;
import claudioESandrade.academia.Entity.AvaliacaoMedica;

public interface IAlunoService {
	
	/**
	   * Cria um Aluno e salva no banco de dados.
	   * @param form formulário referente aos dados para criação de um Aluno no banco de dados.
	   * @return Aluno recém-criado.
	   */
	  Aluno criar(AlunoForm form);

	  /**
	   * Retorna um Aluno que está no banco de dados de acordo com seu Id.
	   * @param id id do Aluno que será exibido.
	   * @return Aluno de acordo com o Id fornecido.
	   */
	  Aluno obter(Long id);

	  /**
	   * Retorna os Alunos que estão no banco de dados.
	   * @return Uma lista os Alunos que estão salvas no DB.
	   */
	  List<Aluno> obterTodos(String dataDeNascimento);

	  /**
	   * Atualiza o Aluno.
	   * @param id id do Aluno que será atualizado.
	   * @param formUpdate formulário referente aos dados necessários para atualização do Aluno
	   * no banco de dados.
	   * @return Aluno recém-atualizado.
	   */
	  Aluno atualizar(Long id , AlunoUpdateForm formUpdate);

	  /**
	   * Deleta um Aluno específico.
	   * @param id id do Aluno que será removido.
	   * @return
	   */
	  Aluno apagar(Long id);

	  /**
	   *
	   * @param id id do aluno que será recuperada a lista de avaliações
	   * @return uma lista com todas as avaliações do aluno de acordo com o Id
	   */
	  List<AvaliacaoMedica> obterTodosAvaliacaoMedicaId(Long id);
	
}
