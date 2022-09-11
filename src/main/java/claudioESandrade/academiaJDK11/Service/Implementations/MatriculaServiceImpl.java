package claudioESandrade.academiaJDK11.Service.Implementations;

import claudioESandrade.academiaJDK11.DTO.MatriculaForm;
import claudioESandrade.academiaJDK11.Entity.Aluno;
import claudioESandrade.academiaJDK11.Entity.Matricula;
import claudioESandrade.academiaJDK11.Repository.AlunoRepository;
import claudioESandrade.academiaJDK11.Repository.MatriculaRepository;
import claudioESandrade.academiaJDK11.Service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

		  @Autowired
		  private MatriculaRepository matriculaRepository;

		  @Autowired
		  private AlunoRepository alunoRepository;
		  
		  @Override
		  public Matricula criar(MatriculaForm form) {
		    Matricula matricula = new Matricula();
		    Aluno aluno = alunoRepository.findById( form.getAlunoId() ).get();
		    matricula.setAluno(aluno);
		    return matriculaRepository.save(matricula);
		  }

		  @Override
		  public Optional<Matricula> obter(Long id) {
		    return matriculaRepository.findById(id);
		  }

		  @Override
		  public List<Matricula> obterTodos(String bairro) {

		    if(bairro == null){
		      return matriculaRepository.findAll();
		    }else{
		      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
		    }

		  }

		  @Override
		  public void apagar(Long id) {
			  matriculaRepository.deleteById(id);
		  }
}
