package com.api.accenture.services;

import com.api.accenture.models.CandidatoModel;
import com.api.accenture.models.VagasModel;
import com.api.accenture.repositories.VagasRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VagasService{

    final
    VagasRepository vagasRepository;

    public VagasService(VagasRepository vagasRepository) {
        this.vagasRepository = vagasRepository;
    }
    @Transactional
    public VagasModel save(VagasModel vagasModel) {
        return vagasRepository.save(vagasModel);
    }

    public List<VagasModel> findAll() {
        return vagasRepository.findAll();
    }

    public Optional<VagasModel> findById(UUID id) {
        return vagasRepository.findById(id);
    }

    @Transactional
    public void delete(VagasModel vagasModel) {
        vagasRepository.delete(vagasModel);
    }
}