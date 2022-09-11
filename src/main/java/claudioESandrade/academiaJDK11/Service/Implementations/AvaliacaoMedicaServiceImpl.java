package claudioESandrade.academiaJDK11.Service.Implementations;

import claudioESandrade.academiaJDK11.DTO.AvaliacaoMedicaForm;
import claudioESandrade.academiaJDK11.DTO.AvaliacaoMedicaUpdateForm;
import claudioESandrade.academiaJDK11.Entity.Aluno;
import claudioESandrade.academiaJDK11.Entity.AvaliacaoMedica;
import claudioESandrade.academiaJDK11.Repository.AlunoRepository;
import claudioESandrade.academiaJDK11.Repository.AvaliacaoMedicaRepository;
import claudioESandrade.academiaJDK11.Service.IAvaliacaoMedicaService;

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