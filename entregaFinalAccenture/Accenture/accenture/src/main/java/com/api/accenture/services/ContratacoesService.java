package com.api.accenture.services;

import com.api.accenture.models.ContratacoesModel;
import com.api.accenture.repositories.ContratacoesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContratacoesService{

    final
    ContratacoesRepository contratacoesRepository;

    public ContratacoesService(ContratacoesRepository contratacoesRepository) {
        this.contratacoesRepository = contratacoesRepository;
    }
    @Transactional
    public ContratacoesModel save(ContratacoesModel contratacoesModel) {
        return contratacoesRepository.save(contratacoesModel);
    }

    public List<ContratacoesModel> findAll() {
        return contratacoesRepository.findAll();
    }

    public Optional<ContratacoesModel> findById(UUID id) {
        return contratacoesRepository.findById(id);
    }
}