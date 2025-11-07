package br.com.omausantos.gestao_vagas.modules.Candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omausantos.gestao_vagas.exceptions.UserFoundException;
import br.com.omausantos.gestao_vagas.modules.Candidate.CandidateEntity;
import br.com.omausantos.gestao_vagas.modules.Candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

     @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }

}
