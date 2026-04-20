CREATE TABLE public.movimentacao_estoque(
    id SERIAL PRIMARY KEY,
    id_estoque INT NOT NULL,
    id_tipo_movimentacao INT NOT NULL,
    quantidade DECIMAL NOT NULL,
    valor_unitario DECIMAL,
    motivo VARCHAR(200),
    referencia VARCHAR(100),
    data_movimentacao NOT NULL TIMESTAMP TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    usuario_responsavel VARCHAR(100),
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)
);