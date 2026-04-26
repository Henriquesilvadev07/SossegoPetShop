package com.sossegopet.SossegoPetShop.repository;

import com.sossegopet.SossegoPetShop.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
}
