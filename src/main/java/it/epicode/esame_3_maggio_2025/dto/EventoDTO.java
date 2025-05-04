package it.epicode.esame_3_maggio_2025.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDTO {

    private Long id;
    private String titolo;
    private String descrizione;
    private LocalDateTime data;
    private String luogo;
    private int postiDisponibili;
    private Long organizzatoreId;  // Solo l'ID dell'organizzatore per evitare esposizione di dati sensibili
}
