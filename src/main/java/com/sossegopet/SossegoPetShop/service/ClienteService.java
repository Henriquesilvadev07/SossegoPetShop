package com.sossegopet.SossegoPetShop.service;

import com.sossegopet.SossegoPetShop.model.ClienteModel;
import com.sossegopet.SossegoPetShop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel salvar(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }

    public ClienteModel acharPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " nao encontrado."));
    }

    public ClienteModel atualizarPorId(Long id, ClienteModel cliente) {
        ClienteModel clienteExistente = acharPorId(id);

        clienteExistente.setNome(clienteExistente.getNome());
        clienteExistente.setTelefone(clienteExistente.getTelefone());
        clienteExistente.setEndereco(clienteExistente.getEndereco());

        return clienteRepository.save(clienteExistente);
    }



}
