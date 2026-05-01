package com.sossegopet.SossegoPetShop.controller;

import com.sossegopet.SossegoPetShop.dto.AgendamentoDto;
import com.sossegopet.SossegoPetShop.model.AgendamentoModel;
import com.sossegopet.SossegoPetShop.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoModel> agendar(@RequestBody AgendamentoDto dto) {
        return ResponseEntity.ok(agendamentoService.agendar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoModel>> listarFila() {
        return ResponseEntity.ok(agendamentoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> finalizar(@PathVariable Long id) {
        // Aqui o retorno é a String do link do WhatsApp
        String link = agendamentoService.finalizarESubirLink(id);
        return ResponseEntity.ok(link);
    }
}