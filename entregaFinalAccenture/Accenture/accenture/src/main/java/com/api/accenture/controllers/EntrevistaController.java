package com.api.accenture.controllers;

import com.api.accenture.dtos.EntrevistaDto;
import com.api.accenture.models.EntrevistaModel;
import com.api.accenture.services.EntrevistaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/entrevista")
public class EntrevistaController {

    final EntrevistaService entrevistaService;

    public EntrevistaController(EntrevistaService entrevistaService) {
        this.entrevistaService = entrevistaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEntrevista(@RequestBody @Valid EntrevistaDto entrevistaDto) {
        var entrevistaModel = new EntrevistaModel();
        BeanUtils.copyProperties(entrevistaDto, entrevistaModel);
        entrevistaModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistaService.save(entrevistaModel));
    }

    @GetMapping
    public ResponseEntity<List<EntrevistaModel>> getAllEntrevista() {
        return ResponseEntity.status(HttpStatus.OK).body(entrevistaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEntrevista(@PathVariable(value = "id") UUID id) {
        Optional<EntrevistaModel> entrevistaModelOptional = entrevistaService.findById(id);
        if (!entrevistaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entrevistaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEntrevista(@PathVariable(value = "id") UUID id){
        Optional<EntrevistaModel> entrevistaModelOptional = entrevistaService.findById(id);
        if (!entrevistaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        entrevistaService.delete(entrevistaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Entrevista deletado com sucesso.");
    }

    @Transactional
    public ResponseEntity<Object> updateEntrevista(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid EntrevistaDto entrevistaDto){
        Optional<EntrevistaModel> entrevistaModelOptional = entrevistaService.findById(id);
        if(!entrevistaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrevista não encontrado.");
        }
        var entrevistaModel = entrevistaModelOptional.get();


        return ResponseEntity.status(HttpStatus.OK).body(entrevistaService.save(entrevistaModel));
    }
}
