package com.api.accenture.repositories;

import com.api.accenture.models.CandidatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidatoRepository extends JpaRepository <CandidatoModel, UUID>{

}
