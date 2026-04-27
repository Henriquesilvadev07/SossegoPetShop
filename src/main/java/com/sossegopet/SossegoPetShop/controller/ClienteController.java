package com.sossegopet.SossegoPetShop.controller;


import com.sossegopet.SossegoPetShop.model.ClienteModel;
import com.sossegopet.SossegoPetShop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody ClienteModel cliente){
        ClienteModel salvo = new ClienteModel();
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listar(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscar(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.acharPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizar(@PathVariable Long id, @RequestBody ClienteModel cliente) {
        return ResponseEntity.ok(clienteService.atualizarPorId(id, cliente));
    }
}
