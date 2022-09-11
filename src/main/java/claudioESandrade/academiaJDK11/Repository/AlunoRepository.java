package claudioESandrade.academiaJDK11.Repository;

import claudioESandrade.academiaJDK11.Entity.Aluno;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	  /**
	   *
	   * @param dataDeNascimento: data de nascimento dos alunos
	   * @return lista com todos os alunos com a data de nascimento passada como parâmetro da função
	   */
	  List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

	}
