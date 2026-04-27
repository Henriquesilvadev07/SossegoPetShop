package com.sossegopet.SossegoPetShop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private LocalDateTime dataHora;

    @NotBlank
    private String servico;

    @Positive(message = "o valor deve ser maior que zero")
    private BigDecimal valor;

    private boolean buscarEntregar;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private AnimalModel pet;


}
