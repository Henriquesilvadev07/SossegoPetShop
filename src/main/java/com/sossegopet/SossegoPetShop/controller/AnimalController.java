package com.sossegopet.SossegoPetShop.controller;

import com.sossegopet.SossegoPetShop.dto.AnimalDto;
import com.sossegopet.SossegoPetShop.model.AnimalModel;
import com.sossegopet.SossegoPetShop.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
@CrossOrigin("*")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalModel> cadastrar(@RequestBody AnimalDto dto) {
        return ResponseEntity.ok(animalService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AnimalModel>> listar() {
        return ResponseEntity.ok(animalService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalModel> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.acharPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalModel> atualizar(@PathVariable Long id, @RequestBody AnimalDto dto) {
        return ResponseEntity.ok(animalService.atualizarPorId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}