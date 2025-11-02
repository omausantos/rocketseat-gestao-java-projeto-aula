package br.com.omausantos.gestao_vagas.modules.Candidate;

import java.io.File;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    
    private UUID id;
    private String name;

    @Pattern(regexp = "^[^\\s]+$", message = "Campo não deve conter espaços")
    private String username;

    @Email(message = "Campo deve conter um e-mail válido")
    private String email;

    @Length(min = 3, max = 15, message = "Campo deve conter entre 3 e 15 caracteres")
    private String password;
    private String description;
    private File curriculum;
}
