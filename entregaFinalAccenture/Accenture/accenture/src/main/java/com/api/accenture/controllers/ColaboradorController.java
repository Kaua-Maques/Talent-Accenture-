package com.api.accenture.controllers;

import com.api.accenture.dtos.ColaboradorDto;
import com.api.accenture.models.ColaboradorModel;
import com.api.accenture.services.ColaboradorService;
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
@RequestMapping("/colaborador")
public class ColaboradorController {

    final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @PostMapping
    public ResponseEntity<Object> saveColaborador(@RequestBody @Valid ColaboradorDto colaboradorDto){
        var colaboradorModel = new ColaboradorModel();
        BeanUtils.copyProperties(colaboradorDto, colaboradorModel);
        /*colaboradorModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));*/
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.save(colaboradorModel));
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorModel>> getAllColaborador(){
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneColaborador(@PathVariable(value = "id") UUID id){
        Optional<ColaboradorModel> colaboradorModelOptional = colaboradorService.findById(id);
        if(!colaboradorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteColaborador(@PathVariable(value = "id") UUID id){
        Optional<ColaboradorModel> colaboradorModelOptional = colaboradorService.findById(id);
        if (!colaboradorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        colaboradorService.delete(colaboradorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Colaborador deletado com sucesso.");
    }

    @Transactional
    public ResponseEntity<Object> updateColaborador(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid ColaboradorDto colaboradorDto){
        Optional<ColaboradorModel> colaboradorModelOptional = colaboradorService.findById(id);
        if(!colaboradorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado.");
        }
        var colaboradorModel = colaboradorModelOptional.get();


        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.save(colaboradorModel));
    }

}
