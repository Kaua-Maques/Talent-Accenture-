package com.api.accenture.services;

import com.api.accenture.models.CandidatoModel;
import com.api.accenture.models.ColaboradorModel;
import com.api.accenture.repositories.ColaboradorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColaboradorService{

    final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }
    @Transactional
    public ColaboradorModel save(ColaboradorModel colaboradorModel) {
        return colaboradorRepository.save(colaboradorModel);
    }

    public List<ColaboradorModel> findAll() {
        return colaboradorRepository.findAll();
    }

    public Optional<ColaboradorModel> findById(UUID id) {
        return colaboradorRepository.findById(id);
    }

    @Transactional
    public void delete(ColaboradorModel colaboradorModel) {
        colaboradorRepository.delete(colaboradorModel);
    }
}