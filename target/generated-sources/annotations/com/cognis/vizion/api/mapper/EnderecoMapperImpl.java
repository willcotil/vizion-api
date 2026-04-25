package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.endereco.dto.EnderecoRequest;
import com.cognis.vizion.api.core.endereco.dto.EnderecoResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public Endereco toEntity(EnderecoRequest request) {
        if ( request == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setLogradouro( request.logradouro() );
        endereco.setNumero( request.numero() );
        endereco.setComplemento( request.complemento() );
        endereco.setBairro( request.bairro() );
        endereco.setCidade( request.cidade() );
        endereco.setEstado( request.estado() );
        endereco.setCep( request.cep() );

        return endereco;
    }

    @Override
    public EnderecoResponse toResponse(Endereco entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        String logradouro = null;
        String numero = null;
        String complemento = null;
        String bairro = null;
        String cidade = null;
        String estado = null;
        String cep = null;

        id = entity.getId();
        logradouro = entity.getLogradouro();
        numero = entity.getNumero();
        complemento = entity.getComplemento();
        bairro = entity.getBairro();
        cidade = entity.getCidade();
        estado = entity.getEstado();
        cep = entity.getCep();

        EnderecoResponse enderecoResponse = new EnderecoResponse( id, logradouro, numero, complemento, bairro, cidade, estado, cep );

        return enderecoResponse;
    }
}
