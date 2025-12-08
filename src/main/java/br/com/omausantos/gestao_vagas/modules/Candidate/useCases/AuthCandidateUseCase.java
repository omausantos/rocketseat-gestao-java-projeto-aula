package br.com.omausantos.gestao_vagas.modules.Candidate.useCases;

import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.omausantos.gestao_vagas.modules.Candidate.CandidateRepository;
import br.com.omausantos.gestao_vagas.modules.Candidate.dto.AuthCandidateRequestDTO;
import br.com.omausantos.gestao_vagas.modules.Candidate.dto.AuthCandidateResponseDTO;

@Service
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateRequestDTO)
            throws AuthenticationException {

                System.out.println("TESTE");
        var candidate = this.candidateRepository.findByUsername(authCandidateRequestDTO.username()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Usuário ou Senha invalidos");
        });

        var passwordMatches = this.passwordEncoder.matches(authCandidateRequestDTO.password(), candidate.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expireIn = Instant.now().plus(java.time.Duration.ofMinutes(10));
        var token = JWT.create()
                .withIssuer("javagas")
                .withSubject(candidate.getId().toString())
                .withClaim("roles", Arrays.asList("candidate"))
                .withExpiresAt(expireIn)
                .sign(algorithm);

        var authCandidateResponseDTO = AuthCandidateResponseDTO.builder()
                                        .access_token(token)
                                        .expire_in(expireIn.toEpochMilli())
                                        .build();

        return authCandidateResponseDTO;
    }

}
