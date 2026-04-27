package com.sossegopet.SossegoPetShop.service;

import com.sossegopet.SossegoPetShop.dto.AnimalDto;
import com.sossegopet.SossegoPetShop.model.AnimalModel;
import com.sossegopet.SossegoPetShop.model.ClienteModel;
import com.sossegopet.SossegoPetShop.repository.AnimalRepository;
import com.sossegopet.SossegoPetShop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public AnimalModel salvar(AnimalDto dto) {

        ClienteModel dono = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Nao da pra cadastrar o animal sem um dono"));

        AnimalModel pet = new AnimalModel();
        pet.setNome(dto.nome());
        pet.setRaca(dto.raca());
        pet.setDono(dono);

        return animalRepository.save(pet);
    }

    public List<AnimalModel> listarTodos() {
        return animalRepository.findAll();
    }

    public AnimalModel acharPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal nao encontrado."));
    }


    public AnimalModel atualizarPorId(Long id, AnimalDto dto){
        AnimalModel animalExistente = acharPorId(id);

        animalExistente.setNome(dto.nome());
        animalExistente.setRaca(dto.raca());

        return animalRepository.save(animalExistente);
    }

    public void deletar(Long id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        }
    }
}
