package com.sossegopet.SossegoPetShop.repository;

import com.sossegopet.SossegoPetShop.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
