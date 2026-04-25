CREATE TABLE IF NOT EXISTS public.obra_empreiteiro (
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    id_empreiteiro INT NOT NULL,
    tenant_id VARCHAR(50) NOT NULL,
    descricao_obra VARCHAR(300) NOT NULL,
    data_inicio TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_fim TIMESTAMP WITHOUT TIME ZONE,
    valor_contratado DECIMAL,
    status VARCHAR(20),
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_empreiteiro_obra FOREIGN KEY (id_obra) REFERENCES obra(id),
    CONSTRAINT fk_obra_empreiteiro_empreiteiro FOREIGN KEY (id_empreiteiro) REFERENCES empreiteiro(id)
);
