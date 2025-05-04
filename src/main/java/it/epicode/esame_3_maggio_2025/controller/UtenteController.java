package it.epicode.esame_3_maggio_2025.controller;

import it.epicode.esame_3_maggio_2025.dto.UtenteDTO;
import it.epicode.esame_3_maggio_2025.entity.Utente;
import it.epicode.esame_3_maggio_2025.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utenti")
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteService utenteService;

    // Registrazione utente
    @PostMapping("/registrazione")
    @ResponseStatus(HttpStatus.CREATED)
    public UtenteDTO registraUtente(@RequestBody Utente utente) {
        return utenteService.registraUtente(utente);
    }
}
