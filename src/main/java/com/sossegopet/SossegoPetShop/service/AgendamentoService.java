package com.sossegopet.SossegoPetShop.service;

import com.sossegopet.SossegoPetShop.dto.AgendamentoDto;
import com.sossegopet.SossegoPetShop.model.AgendamentoModel;
import com.sossegopet.SossegoPetShop.model.AnimalModel;
import com.sossegopet.SossegoPetShop.repository.AgendamentoRepository;
import com.sossegopet.SossegoPetShop.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public AgendamentoModel agendar(AgendamentoDto dto) {

        AnimalModel pet = animalRepository.findById(dto.petId())
                .orElseThrow(() -> new RuntimeException("Animal nao encontrado."));

        AgendamentoModel agenda = new AgendamentoModel();

        agenda.setPet(pet);
        agenda.setServico(dto.servico());
        agenda.setValor(dto.valor());
        agenda.setDataHora(dto.dataHora());

        return agendamentoRepository.save(agenda);
    }

    public String finalizarESubirLink(Long id) {
        AgendamentoModel agenda = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento nao encontrado"));

        String telefone = agenda.getPet().getDono().getTelefone();
        String nomePet = agenda.getPet().getNome();
        String mensagem = "Oi! O " +nomePet+ "já terminou o(a) " +agenda.getServico()+ " e está prontinho! \uD83D\uDC3E";
        String textoEncoded = URLEncoder.encode(mensagem, StandardCharsets.UTF_8);
        agendamentoRepository.deleteById(id);

        return "https://api.whatsapp.com/send?phone=55" +telefone+ "&text=" +textoEncoded;
    }

    public List<AgendamentoModel> listarTodos() {
        return agendamentoRepository.findAll();
    }
}
