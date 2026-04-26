package com.sossegopet.SossegoPetShop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnimalDto(
        @NotBlank String nome,
        String raca,
        @NotNull Long clienteId
) {
}
