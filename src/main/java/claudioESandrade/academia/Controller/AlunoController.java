package claudioESandrade.academia.Controller;

import claudioESandrade.academia.DTO.AlunoForm;
import claudioESandrade.academia.DTO.AlunoUpdateForm;
import claudioESandrade.academia.Entity.Aluno;
import claudioESandrade.academia.Entity.AvaliacaoMedica;
import claudioESandrade.academia.Service.Implementations.AlunoServiceImpl;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@PutMapping("/{id}")
	public Aluno put( @PathVariable Long id, @Valid @RequestBody AlunoUpdateForm form) {
		return service.atualizar(id, form);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.apagar(id);
	}

}
