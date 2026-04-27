package com.sossegopet.SossegoPetShop.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "o nome deve ter pelo menos 3 caracteres")
    private String nome;

    @NotBlank(message = "o telefone é obrigatório")
    private String telefone;

    private String endereco;

}
