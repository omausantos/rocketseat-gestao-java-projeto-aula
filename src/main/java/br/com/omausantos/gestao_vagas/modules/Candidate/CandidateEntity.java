package br.com.omausantos.gestao_vagas.modules.Candidate;

import java.io.File;
import java.util.UUID;

import lombok.Data;

@Data
public class CandidateEntity {
    
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private File curriculum;
}
