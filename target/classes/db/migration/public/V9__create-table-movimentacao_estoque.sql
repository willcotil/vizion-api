CREATE TABLE IF NOT EXISTS public.movimentacao_estoque (
    id SERIAL PRIMARY KEY,
    id_estoque INT NOT NULL,
    tipo_movimentacao VARCHAR(20) NOT NULL,
    quantidade DECIMAL NOT NULL,
    valor_unitario DECIMAL,
    motivo VARCHAR(200),
    referencia VARCHAR(100),
    data_movimentacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    usuario_responsavel VARCHAR(100),
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_movimentacao_estoque_estoque FOREIGN KEY (id_estoque) REFERENCES estoque(id)
);
