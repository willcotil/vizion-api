CREATE TABLE IF NOT EXISTS public.fases_obra (
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    nome_fase VARCHAR(100) NOT NULL,
    descricao VARCHAR(500),
    data_inicio_estimada DATE,
    data_iniciada DATE,
    data_fim_estimada DATE,
    data_finalizada DATE,
    valor_estimado DECIMAL,
    valor_pago DECIMAL,
    status VARCHAR(20) NOT NULL,
    ordem_exibicao INT,
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_fases_obra_obra FOREIGN KEY (id_obra) REFERENCES obra(id)
);
