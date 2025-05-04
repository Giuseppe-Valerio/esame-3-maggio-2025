package it.epicode.esame_3_maggio_2025.controller;

import it.epicode.esame_3_maggio_2025.dto.EventoDTO;
import it.epicode.esame_3_maggio_2025.entity.Evento;
import it.epicode.esame_3_maggio_2025.entity.Utente;
import it.epicode.esame_3_maggio_2025.service.EventoService;
import it.epicode.esame_3_maggio_2025.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventi")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService eventoService;
    private final UtenteService utenteService;

    // Crea evento (solo per organizzatori)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento creaEvento(@RequestBody Evento evento, @RequestParam String username) {
        Utente organizzatore = utenteService.trovaPerUsername(username);
        evento.setOrganizzatore(organizzatore);
        return eventoService.creaEvento(evento);
    }

    // Ottieni tutti gli eventi
    @GetMapping
    public List<Evento> getAllEventi() {
        return eventoService.tuttiGliEventi();
    }

    // Ottieni eventi creati da un determinato organizzatore
    @GetMapping("/organizzatore/{username}")
    public List<Evento> getEventiPerOrganizzatore(@PathVariable String username) {
        Utente organizzatore = utenteService.trovaPerUsername(username);
        return eventoService.eventiCreatiDa(organizzatore);
    }

    // Modifica evento (solo per l'organizzatore che ha creato l'evento)
    @PutMapping("/{id}")
    public Evento aggiornaEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Evento eventoEsistente = eventoService.trovaPerId(id);
        if (!eventoEsistente.getOrganizzatore().equals(evento.getOrganizzatore())) {
            throw new RuntimeException("Non puoi modificare un evento che non hai creato");
        }
        evento.setId(id);
        return eventoService.aggiornaEvento(evento);
    }

    // Elimina evento (solo per l'organizzatore che ha creato l'evento)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaEvento(@PathVariable Long id) {
        Evento evento = eventoService.trovaPerId(id);
        eventoService.eliminaEvento(id);
    }
}
