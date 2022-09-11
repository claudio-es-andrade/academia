package claudioESandrade.academiaJDK11.Repository;

import claudioESandrade.academiaJDK11.Entity.AvaliacaoMedica;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AvaliacaoMedicaRepository extends JpaRepository<AvaliacaoMedica, Long> {
		
}
