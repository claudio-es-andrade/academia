package claudioESandrade.academia.Repository;

import claudioESandrade.academia.Entity.AvaliacaoMedica;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AvaliacaoMedicaRepository extends JpaRepository<AvaliacaoMedica, Long> {
		
}
