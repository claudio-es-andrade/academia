package claudioESandrade.academia.Controller;

import claudioESandrade.academia.DTO.AlunoForm;
import claudioESandrade.academia.DTO.AlunoUpdateForm;
import claudioESandrade.academia.Entity.Aluno;
import claudioESandrade.academia.Entity.AvaliacaoMedica;
import claudioESandrade.academia.Service.Implementations.AlunoServiceImpl;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping
	public Aluno put(@Valid @RequestBody AlunoUpdateForm form) {
		return service.atualizar(form);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.apagar(id);
	}

}
