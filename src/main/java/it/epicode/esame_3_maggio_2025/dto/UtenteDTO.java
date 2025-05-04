package it.epicode.esame_3_maggio_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDTO {

    private Long id;
    private String username;
    private String ruolo;
}
