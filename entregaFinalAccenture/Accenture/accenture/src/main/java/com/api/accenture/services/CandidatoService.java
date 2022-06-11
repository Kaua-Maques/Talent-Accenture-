package com.api.accenture.services;

import com.api.accenture.models.CandidatoModel;
import com.api.accenture.repositories.CandidatoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidatoService{

        final
        CandidatoRepository candidatoRepository;

        public CandidatoService(CandidatoRepository candidatoRepository) {
            this.candidatoRepository = candidatoRepository;
        }
    @Transactional
    public CandidatoModel save(CandidatoModel candidatoModel) {
            return candidatoRepository.save(candidatoModel);
    }

    public List<CandidatoModel> findAll() {
            return candidatoRepository.findAll();
    }

    public Optional<CandidatoModel> findById(UUID id) {
            return candidatoRepository.findById(id);
    }

    @Transactional
    public void delete(CandidatoModel candidatoModel) {
            candidatoRepository.delete(candidatoModel);
    }
}