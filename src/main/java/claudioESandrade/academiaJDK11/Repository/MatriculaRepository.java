package claudioESandrade.academiaJDK11.Repository;

import claudioESandrade.academiaJDK11.Entity.Matricula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	  /**
	   *
	   * @param bairro bairro referência para o filtro
	   * @return lista de alunos matriculados que residem no bairro passado como parâmetro
	   */
//	@Query(value = "SELECT m FROM tb_matriculas m JOIN m.tb_alunos a"
//			  + " WHERE a.bairro = :bairro", nativeQuery = true)
	
	@Query(value = "SELECT * FROM tb_matriculas m "
			  + " INNER JOIN tb_alunos a ON m.aluno_id = a.id "
			  + " INNER JOIN tb_avaliacoes av ON m.aluno_id = av.id "
			  + " WHERE a.bairro = :bairro ", nativeQuery = true)
	  //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
	  List<Matricula> findAlunosMatriculadosBairro(String bairro);

	  //List<Matricula> findByAlunoBairro(String bairro);


	}
