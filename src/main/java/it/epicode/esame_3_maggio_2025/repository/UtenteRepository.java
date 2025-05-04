package it.epicode.esame_3_maggio_2025.repository;

import it.epicode.esame_3_maggio_2025.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByUsername(String username);
}
