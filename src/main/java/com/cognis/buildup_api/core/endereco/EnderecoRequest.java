package com.cognis.buildup_api.core.endereco;

import jakarta.persistence.Column;
import lombok.Data;

@Data

public class EnderecoRequest {

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
