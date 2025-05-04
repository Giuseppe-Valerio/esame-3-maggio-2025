package it.epicode.esame_3_maggio_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrenotazioneDTO {

    private Long id;
    private Long eventoId;      // ID dell'evento prenotato
    private Long utenteId;      // ID dell'utente che ha fatto la prenotazione
}
