package claudioESandrade.academia.Service.Implementations;

import claudioESandrade.academia.DTO.AvaliacaoMedicaForm;
import claudioESandrade.academia.DTO.AvaliacaoMedicaUpdateForm;
import claudioESandrade.academia.Entity.Aluno;
import claudioESandrade.academia.Entity.AvaliacaoMedica;
import claudioESandrade.academia.Repository.AlunoRepository;
import claudioESandrade.academia.Repository.AvaliacaoMedicaRepository;
import claudioESandrade.academia.Repository.MatriculaRepository;
import claudioESandrade.academia.Service.IAvaliacaoMedicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoMedicaServiceImpl implements IAvaliacaoMedicaService {

	  @Autowired
	  private AvaliacaoMedicaRepository avaliacaoMedicaRepository;

	  @Autowired
	  private AlunoRepository alunoRepository;
	  
	  @Override
	  public AvaliacaoMedica criar(AvaliacaoMedicaForm form) {
		  AvaliacaoMedica avaliacaoMedica = new AvaliacaoMedica();
		  Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

		  avaliacaoMedica.setAluno(aluno);
		  avaliacaoMedica.setPeso(form.getPeso());
		  avaliacaoMedica.setAltura(form.getAltura());

		  return avaliacaoMedicaRepository.save(avaliacaoMedica);
	  }
	  
	  @Override
	  public Optional<AvaliacaoMedica> obter(Long id) {
	    return avaliacaoMedicaRepository.findById(id);
	  }

	  @Override
	  public List< AvaliacaoMedica > obterTodos() {

	    return avaliacaoMedicaRepository.findAll();
	  }

	  @Override
	  public AvaliacaoMedica atualizar(Long id, AvaliacaoMedicaUpdateForm formUpdate) {
		  AvaliacaoMedica avaliacaoMedica = new AvaliacaoMedica();
		  Aluno aluno = alunoRepository.findById(formUpdate.getAlunoId()).get();

		  avaliacaoMedica.setAluno(aluno);
		  avaliacaoMedica.setPeso(formUpdate.getPeso());
		  avaliacaoMedica.setAltura(formUpdate.getAltura());

		  return avaliacaoMedicaRepository.save(avaliacaoMedica);
	  }

	  @Override
	  public void apagar(Long id) {
		  avaliacaoMedicaRepository.deleteById(id);

	  }
}