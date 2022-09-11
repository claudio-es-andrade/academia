package claudioESandrade.academiaJDK11.Service.Implementations;

import claudioESandrade.academiaJDK11.DTO.AlunoForm;
import claudioESandrade.academiaJDK11.DTO.AlunoUpdateForm;
import claudioESandrade.academiaJDK11.Entity.Aluno;
import claudioESandrade.academiaJDK11.Entity.AvaliacaoMedica;
import claudioESandrade.academiaJDK11.Repository.AlunoRepository;
import claudioESandrade.academiaJDK11.Service.IAlunoService;
import claudioESandrade.academiaJDK11.infra.utils.JavaTimeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService{
	
	@Autowired
	private AlunoRepository repository;
	
	@Override
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
	
	@Override
	public List<Aluno> obterTodos(String dataDeNascimento) {

		if(dataDeNascimento == null) {
			return repository.findAll();
		} else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByDataDeNascimento(localDate);
		}

	}
	
	@Override
	public Aluno atualizar(Long id, AlunoUpdateForm form) {
		
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());

		return repository.save(aluno);
	}
	
	@Override
	public List<AvaliacaoMedica> obterTodosAvaliacaoMedicaId(Long id) {
		Aluno aluno = repository.findById(id).get();
		return aluno.getAvaliacoes();

	}
	
	@Override
	public Aluno apagar(Long id) {
		Aluno aluno = repository.findById(id).get();
		repository.delete(aluno);
		return null;
	}
}
