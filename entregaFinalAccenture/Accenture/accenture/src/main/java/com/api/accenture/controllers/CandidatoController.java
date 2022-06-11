package com.api.accenture.controllers;

import com.api.accenture.dtos.CandidatoDto;
import com.api.accenture.models.CandidatoModel;
import com.api.accenture.models.ColaboradorModel;
import com.api.accenture.services.CandidatoService;
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
@RequestMapping("/candidato")
public class CandidatoController {

    final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService){
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCandidato(@RequestBody @Valid CandidatoDto candidatoDto){
        var candidatoModel = new CandidatoModel();
        BeanUtils.copyProperties(candidatoDto, candidatoModel);
        candidatoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoService.save(candidatoModel));
    }

    @GetMapping
    public ResponseEntity<List<CandidatoModel>> getAllCandidato(){
        return ResponseEntity.status(HttpStatus.OK).body(candidatoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCandidato(@PathVariable(value = "id") UUID id){
        Optional<CandidatoModel> candidatoModelOptional = candidatoService.findById(id);
        if(!candidatoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(candidatoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCandidato(@PathVariable(value = "id") UUID id){
        Optional<CandidatoModel> candidatoModelOptional = candidatoService.findById(id);
        if (!candidatoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        candidatoService.delete(candidatoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Candidato deletado com sucesso.");
    }

    @Transactional
    public ResponseEntity<Object> updateCandidato(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Valid CandidatoDto candidatoDto){
        Optional<CandidatoModel> candidatoModelOptional = candidatoService.findById(id);
        if(!candidatoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidato não encontrado.");
        }
        var candidatoModel = candidatoModelOptional.get();
        candidatoModel.setCargoPretendido(candidatoDto.getCargoPretendido());
        candidatoModel.setGenero(candidatoDto.getGenero());
        candidatoModel.setEstadoCivil(candidatoDto.getEstadoCivil());
        candidatoModel.setTelefone(candidatoDto.getTelefone());
        candidatoModel.setEmail(candidatoDto.getEmail());
        candidatoModel.setCpf(candidatoDto.getCpf());
        candidatoModel.setNascimento(candidatoDto.getNascimento());
        candidatoModel.setLocalidade(candidatoDto.getLocalidade());
        candidatoModel.setCelular(candidatoDto.getCelular());
        candidatoModel.setInstrucao(candidatoDto.getInstrucao());
        candidatoModel.setCurso(candidatoDto.getCurso());
        candidatoModel.setObservacoes(candidatoDto.getObservacoes());
        candidatoModel.setStatus(candidatoDto.getStatus());
        candidatoModel.setHabilidades(candidatoDto.getHabilidades());
        candidatoModel.setEntrevistador(candidatoDto.getEntrevistador());


        return ResponseEntity.status(HttpStatus.OK).body(candidatoService.save(candidatoModel));
    }
}
