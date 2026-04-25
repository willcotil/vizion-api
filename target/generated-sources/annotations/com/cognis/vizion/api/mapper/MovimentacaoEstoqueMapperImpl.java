package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Estoque;
import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import com.cognis.vizion.api.core.estoque.TipoMovimentacao;
import com.cognis.vizion.api.core.estoque.dto.MovimentacaoEstoqueRequest;
import com.cognis.vizion.api.core.estoque.dto.MovimentacaoEstoqueResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class MovimentacaoEstoqueMapperImpl implements MovimentacaoEstoqueMapper {

    @Override
    public MovimentacaoEstoqueResponse toResponse(MovimentacaoEstoque entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id_estoque = null;
        Integer id = null;
        TipoMovimentacao tipo_movimentacao = null;
        BigDecimal quantidade = null;
        BigDecimal valor_unitario = null;
        String motivo = null;
        String referencia = null;
        LocalDateTime data_movimentacao = null;
        String usuario_responsavel = null;

        id_estoque = entityEstoqueId( entity );
        id = entity.getId();
        tipo_movimentacao = entity.getTipo_movimentacao();
        quantidade = entity.getQuantidade();
        valor_unitario = entity.getValor_unitario();
        motivo = entity.getMotivo();
        referencia = entity.getReferencia();
        data_movimentacao = entity.getData_movimentacao();
        usuario_responsavel = entity.getUsuario_responsavel();

        MovimentacaoEstoqueResponse movimentacaoEstoqueResponse = new MovimentacaoEstoqueResponse( id, id_estoque, tipo_movimentacao, quantidade, valor_unitario, motivo, referencia, data_movimentacao, usuario_responsavel );

        return movimentacaoEstoqueResponse;
    }

    @Override
    public MovimentacaoEstoque toEntity(MovimentacaoEstoqueRequest request) {
        if ( request == null ) {
            return null;
        }

        MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque();

        movimentacaoEstoque.setEstoque( map( request.id_estoque() ) );
        movimentacaoEstoque.setTipo_movimentacao( request.tipo_movimentacao() );
        movimentacaoEstoque.setQuantidade( request.quantidade() );
        movimentacaoEstoque.setValor_unitario( request.valor_unitario() );
        movimentacaoEstoque.setMotivo( request.motivo() );
        movimentacaoEstoque.setReferencia( request.referencia() );
        movimentacaoEstoque.setData_movimentacao( request.data_movimentacao() );
        movimentacaoEstoque.setUsuario_responsavel( request.usuario_responsavel() );

        return movimentacaoEstoque;
    }

    private Integer entityEstoqueId(MovimentacaoEstoque movimentacaoEstoque) {
        Estoque estoque = movimentacaoEstoque.getEstoque();
        if ( estoque == null ) {
            return null;
        }
        return estoque.getId();
    }
}
