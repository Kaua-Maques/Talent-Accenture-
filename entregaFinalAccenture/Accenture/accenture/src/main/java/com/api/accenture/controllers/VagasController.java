package com.api.accenture.controllers;

import com.api.accenture.dtos.VagasDto;
import com.api.accenture.models.VagasModel;
import com.api.accenture.services.VagasService;
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
@RequestMapping("/vagas")
public class VagasController {

    final VagasService vagasService;

    public VagasController (VagasService vagasService){this.vagasService = vagasService;}

    @PostMapping
    public ResponseEntity<Object> saveVagas(@RequestBody @Valid VagasDto vagasDto){
        var vagasModel = new VagasModel();
        BeanUtils.copyProperties(vagasDto, vagasModel);
        vagasModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(vagasService.save(vagasModel));
    }

    @GetMapping
    public ResponseEntity<List<VagasModel>> getAllVagas(){
        return ResponseEntity.status(HttpStatus.OK).body(vagasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVagas(@PathVariable(value = "id") UUID id){
        Optional<VagasModel> vagasModelOptional = vagasService.findById(id);
        if(!vagasModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vagasModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVagas(@PathVariable(value = "id") UUID id){
        Optional<VagasModel> vagasModelOptional = vagasService.findById(id);
        if (!vagasModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        vagasService.delete(vagasModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vagas deletado com sucesso.");
    }

    @Transactional
    public ResponseEntity<Object> updateVagas(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid VagasDto vagasDto){
        Optional<VagasModel> vagasModelOptional = vagasService.findById(id);
        if(!vagasModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vagas não encontrado.");
        }
        var vagasModel = vagasModelOptional.get();


        return ResponseEntity.status(HttpStatus.OK).body(vagasService.save(vagasModel));
    }

}
