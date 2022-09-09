package claudioESandrade.academia.Controller;

import claudioESandrade.academia.DTO.MatriculaForm;
import claudioESandrade.academia.Entity.Matricula;
import claudioESandrade.academia.Service.Implementations.MatriculaServiceImpl;

import java.util.List;
import javax.validation.Valid;

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
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaServiceImpl service;
	
	@GetMapping
	public Matricula  get(@PathVariable Long id) {
		return service.obter(id);
	}
	
	@GetMapping("/all")
	public List<Matricula> getAll(@PathVariable String bairro) {
		return service.obterTodos(bairro);
	}
	
	@PostMapping
	public Matricula create(@Valid @RequestBody MatriculaForm form) {
		return service.criar(form);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.apagar(id);
	}
	
}
