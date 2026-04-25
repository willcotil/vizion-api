package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.obra.obraDocumentos.ObrasDocumentos;
import com.cognis.vizion.api.core.obra.obraDocumentos.TipoDocumento;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosRequest;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class ObrasDocumentosMapperImpl implements ObrasDocumentosMapper {

    @Override
    public ObrasDocumentosResponse toResponse(ObrasDocumentos entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        String tenant_id = null;
        TipoDocumento tipo_documento = null;
        String nome_arquivo = null;
        String url_arquivo = null;
        String descricao_arquivo = null;

        id = entity.getId();
        tenant_id = entity.getTenant_id();
        tipo_documento = entity.getTipo_documento();
        nome_arquivo = entity.getNome_arquivo();
        url_arquivo = entity.getUrl_arquivo();
        descricao_arquivo = entity.getDescricao_arquivo();

        Integer id_obra = null;

        ObrasDocumentosResponse obrasDocumentosResponse = new ObrasDocumentosResponse( id, id_obra, tenant_id, tipo_documento, nome_arquivo, url_arquivo, descricao_arquivo );

        return obrasDocumentosResponse;
    }

    @Override
    public ObrasDocumentos toEntity(ObrasDocumentosRequest request) {
        if ( request == null ) {
            return null;
        }

        ObrasDocumentos obrasDocumentos = new ObrasDocumentos();

        obrasDocumentos.setObra( map( request.id_obra() ) );
        obrasDocumentos.setTipo_documento( request.tipo_documento() );
        obrasDocumentos.setNome_arquivo( request.nome_arquivo() );
        obrasDocumentos.setUrl_arquivo( request.url_arquivo() );
        obrasDocumentos.setDescricao_arquivo( request.descricao_arquivo() );

        return obrasDocumentos;
    }
}
