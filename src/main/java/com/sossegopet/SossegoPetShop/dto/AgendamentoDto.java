package com.sossegopet.SossegoPetShop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AgendamentoDto(
        @NotNull LocalDateTime dataHora,
        @NotBlank String servico,
        @Positive BigDecimal valor,
        @NotNull Long petId
        ) {}
