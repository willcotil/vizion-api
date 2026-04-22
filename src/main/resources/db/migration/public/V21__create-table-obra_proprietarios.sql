CREATE TABLE IF NOT EXISTS public.obra_proprietarios (
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    id_cliente INT NOT NULL,
    tenant_id VARCHAR(50) NOT NULL,
    descricao_obra VARCHAR(300),
    percentual_participacao DECIMAL,
    status VARCHAR(20),
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_proprietarios_obra FOREIGN KEY (id_obra) REFERENCES obra(id),
    CONSTRAINT fk_obra_proprietarios_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);
