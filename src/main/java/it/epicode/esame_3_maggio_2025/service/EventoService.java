package it.epicode.esame_3_maggio_2025.service;

import it.epicode.esame_3_maggio_2025.entity.Evento;
import it.epicode.esame_3_maggio_2025.entity.Utente;
import it.epicode.esame_3_maggio_2025.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public Evento creaEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> tuttiGliEventi() {
        return eventoRepository.findAll();
    }

    public List<Evento> eventiCreatiDa(Utente organizzatore) {
        return eventoRepository.findByOrganizzatore(organizzatore);
    }

    public Evento aggiornaEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public void eliminaEvento(Long idEvento) {
        eventoRepository.deleteById(idEvento);
    }

    public Evento trovaPerId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento non trovato"));
    }
}
