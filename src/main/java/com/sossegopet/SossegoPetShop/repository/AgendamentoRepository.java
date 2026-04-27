package com.sossegopet.SossegoPetShop.repository;

import com.sossegopet.SossegoPetShop.model.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

    List<AgendamentoModel> findAllByOrderByDataHoraAsc();

}
