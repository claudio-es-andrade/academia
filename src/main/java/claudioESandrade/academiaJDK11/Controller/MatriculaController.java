package claudioESandrade.academiaJDK11.Controller;

import claudioESandrade.academiaJDK11.DTO.MatriculaForm;
import claudioESandrade.academiaJDK11.Entity.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private claudioESandrade.academiaJDK11.Service.Implementations.MatriculaServiceImpl service;
	
	@GetMapping("/{id}")
	public Optional<Matricula> get(@PathVariable Long id) {	return service.obter(id);	}
	
	@GetMapping
	public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
		List<Matricula> matriculas = service.obterTodos(bairro);
		return matriculas;
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
