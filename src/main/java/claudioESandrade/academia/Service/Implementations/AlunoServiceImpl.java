package claudioESandrade.academia.Service.Implementations;

import claudioESandrade.academia.DTO.AlunoForm;
import claudioESandrade.academia.DTO.AlunoUpdateForm;
import claudioESandrade.academia.Entity.Aluno;
import claudioESandrade.academia.Entity.AvaliacaoMedica;
import claudioESandrade.academia.Repository.AlunoRepository;
import claudioESandrade.academia.Service.IAlunoService;
import claudioESandrade.academia.infra.utils.JavaTimeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService{
	
	@Autowired
	private AlunoRepository repository;

	public Aluno criar(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());

		return repository.save(aluno);
	}

	@Override
	public Aluno obter(Long id) {
		Aluno aluno = repository.findById(id).get();
		return aluno;
	}

	public List<Aluno> obterTodos(String dataDeNascimento) {

		if(dataDeNascimento == null) {
			return repository.findAll();
		} else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByDataDeNascimento(localDate);
		}

	}

	public Aluno atualizar(Long id , AlunoUpdateForm form) {
		
		Aluno aluno = repository.findById(id).get();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());

		return repository.save(aluno);
	}

	public List<AvaliacaoMedica> obterTodosAvaliacaoMedicaId(Long id) {
		Aluno aluno = repository.findById(id).get();
		return aluno.getAvaliacoes();

	}
	
	public Aluno apagar(Long id) {
		Aluno aluno = repository.findById(id).get();
		repository.delete(aluno);
		return null;
	}	
}
