package com.sossegopet.SossegoPetShop.repository;

import com.sossegopet.SossegoPetShop.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByTelefone(String telefone);

}

