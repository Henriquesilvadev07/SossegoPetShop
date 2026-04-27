package com.sossegopet.SossegoPetShop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataHora;

    @NotBlank
    private String servico;

    @Positive(message = "o valor deve ser maior que zero")
    private BigDecimal valor;

    private boolean buscarEntregar;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private AnimalModel pet;

    private String descricao;

    @NotBlank
    private String formaPagamento;


}
