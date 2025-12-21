package br.com.omausantos.gestao_vagas.modules.Candidate.dto;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String description;

}
