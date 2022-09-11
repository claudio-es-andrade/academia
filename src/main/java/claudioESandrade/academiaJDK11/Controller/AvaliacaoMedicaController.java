package claudioESandrade.academiaJDK11.Controller;

import claudioESandrade.academiaJDK11.DTO.AvaliacaoMedicaForm;
import claudioESandrade.academiaJDK11.Entity.AvaliacaoMedica;
import claudioESandrade.academiaJDK11.Service.Implementations.AvaliacaoMedicaServiceImpl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoMedicaController {
	
	@Autowired
	private AvaliacaoMedicaServiceImpl service;

	@GetMapping("/{id}")
	public Optional<AvaliacaoMedica> get(@PathVariable Long id) {
		return service.obter(id);
	}

////	Ambiguidade devido o GetAllbyId  de Alunos
//	@GetMapping
//	public List< AvaliacaoMedica > getAll(){
//		return service.obterTodos();
//	}
		
	@PostMapping
	public AvaliacaoMedica create(@Valid @RequestBody AvaliacaoMedicaForm form) {
		return service.criar(form);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.apagar(id);
	}
	
}