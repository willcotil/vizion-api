package com.cognis.vizion.api.core.endereco.dto;


import com.cognis.vizion.api.core.endereco.Endereco;

public record EnderecoResponse (
        Integer id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
    public EnderecoResponse(Endereco endereco){
        this(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep()
        );
    }
}
