package it.epicode.esame_3_maggio_2025.repository;

import it.epicode.esame_3_maggio_2025.entity.Evento;
import it.epicode.esame_3_maggio_2025.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByOrganizzatore(Utente organizzatore);
}
