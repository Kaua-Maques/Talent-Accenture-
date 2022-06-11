package com.api.accenture.controllers;

import com.api.accenture.dtos.ContratacoesDto;
import com.api.accenture.models.ContratacoesModel;
import com.api.accenture.services.ContratacoesService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contratacoes")
public class ContratacoesController {

    final ContratacoesService contratacoesService;

    public ContratacoesController(ContratacoesService contratacoesService) {
        this.contratacoesService = contratacoesService;
    }

    @PostMapping
    public ResponseEntity<Object> saveContratacoes(@RequestBody @Valid ContratacoesDto contratacoesDto) {
        var contratacoesModel = new ContratacoesModel();
        BeanUtils.copyProperties(contratacoesDto, contratacoesModel);
        //contratacoesModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(contratacoesService.save(contratacoesModel));
    }

    @GetMapping
    public ResponseEntity<List<ContratacoesModel>> getAllContratacoes() {
        return ResponseEntity.status(HttpStatus.OK).body(contratacoesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneContratacoes(@PathVariable(value = "id") UUID id) {
        Optional<ContratacoesModel> contratacoesModelOptional = contratacoesService.findById(id);
        if (!contratacoesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contratacoesModelOptional.get());
    }
}