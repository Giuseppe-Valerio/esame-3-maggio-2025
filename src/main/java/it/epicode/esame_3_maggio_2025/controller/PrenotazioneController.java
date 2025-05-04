package it.epicode.esame_3_maggio_2025.controller;

import it.epicode.esame_3_maggio_2025.service.PrenotazioneService;
import it.epicode.esame_3_maggio_2025.entity.Utente;
import it.epicode.esame_3_maggio_2025.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prenotazioni")
@RequiredArgsConstructor
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final UtenteService utenteService;

    // Prenota un posto per un evento
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void prenotaEvento(@RequestParam Long eventoId, @RequestParam String username) {
        Utente utente = utenteService.trovaPerUsername(username);
        prenotazioneService.prenotaEvento(eventoId, utente);
    }
}
