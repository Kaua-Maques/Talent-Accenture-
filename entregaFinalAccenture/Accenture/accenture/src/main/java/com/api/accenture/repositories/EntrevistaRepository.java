package com.api.accenture.repositories;

import com.api.accenture.models.EntrevistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EntrevistaRepository extends JpaRepository<EntrevistaModel, UUID> {
}
