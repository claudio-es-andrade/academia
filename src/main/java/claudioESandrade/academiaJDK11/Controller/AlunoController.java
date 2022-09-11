package claudioESandrade.academiaJDK11.Controller;

import claudioESandrade.academiaJDK11.DTO.AlunoForm;
import claudioESandrade.academiaJDK11.Entity.Aluno;
import claudioESandrade.academiaJDK11.Entity.AvaliacaoMedica;
import claudioESandrade.academiaJDK11.Service.Implementations.AlunoServiceImpl;

import java.util.List;
import javax.validation.Valid;

import claudioESandrade.academiaJDK11.Entity.AvaliacaoMedica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
	String dataDeNacimento){
		return service.obterTodos(dataDeNacimento);
	}
	
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoMedica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
		return service.obterTodosAvaliacaoMedicaId(id);
	}
	
	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.criar(form);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.apagar(id);
	}

}
