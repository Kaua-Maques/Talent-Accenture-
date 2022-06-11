package com.api.accenture.services;

import com.api.accenture.models.CandidatoModel;
import com.api.accenture.models.EntrevistaModel;
import com.api.accenture.repositories.EntrevistaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EntrevistaService{

    final
    EntrevistaRepository entrevistaRepository;

    public EntrevistaService(EntrevistaRepository entrevistaRepository) {
        this.entrevistaRepository = entrevistaRepository;
    }
    @Transactional
    public EntrevistaModel save(EntrevistaModel entrevistaModel) {
        return entrevistaRepository.save(entrevistaModel);
    }

    public List<EntrevistaModel> findAll() {
        return entrevistaRepository.findAll();
    }

    public Optional<EntrevistaModel> findById(UUID id) {
        return entrevistaRepository.findById(id);
    }

    @Transactional
    public void delete(EntrevistaModel entrevistaModel) {
        entrevistaRepository.delete(entrevistaModel);
    }
}