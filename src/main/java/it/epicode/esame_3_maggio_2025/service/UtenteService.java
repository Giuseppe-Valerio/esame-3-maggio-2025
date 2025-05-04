package it.epicode.esame_3_maggio_2025.service;

import it.epicode.esame_3_maggio_2025.dto.UtenteDTO;
import it.epicode.esame_3_maggio_2025.entity.Utente;
import it.epicode.esame_3_maggio_2025.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;

    public UtenteDTO registraUtente(Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        Utente savedUtente = utenteRepository.save(utente);
        return new UtenteDTO(savedUtente.getId(), savedUtente.getUsername(), savedUtente.getRuolo().name());
    }

    public Utente trovaPerUsername(String username) {
        return utenteRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }

}
