package claudioESandrade.academia.Service.Implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioESandrade.academia.DTO.MatriculaForm;
import claudioESandrade.academia.Entity.Aluno;
import claudioESandrade.academia.Entity.Matricula;
import claudioESandrade.academia.Repository.AlunoRepository;
import claudioESandrade.academia.Repository.MatriculaRepository;
import claudioESandrade.academia.Service.IMatriculaService;

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
