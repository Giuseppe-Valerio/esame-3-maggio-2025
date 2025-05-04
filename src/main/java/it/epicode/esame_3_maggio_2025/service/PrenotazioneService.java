package it.epicode.esame_3_maggio_2025.service;

import it.epicode.esame_3_maggio_2025.entity.Evento;
import it.epicode.esame_3_maggio_2025.entity.Prenotazione;
import it.epicode.esame_3_maggio_2025.entity.Utente;
import it.epicode.esame_3_maggio_2025.repository.PrenotazioneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final EventoService eventoService;

    public Prenotazione prenotaEvento(Long eventoId, Utente utente) {
        Evento evento = eventoService.trovaPerId(eventoId);

        if (evento.getPostiDisponibili() <= 0) {
            throw new RuntimeException("Posti esauriti");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setEvento(evento);

        evento.setPostiDisponibili(evento.getPostiDisponibili() - 1);
        eventoService.aggiornaEvento(evento);

        return prenotazioneRepository.save(prenotazione);
    }
}
