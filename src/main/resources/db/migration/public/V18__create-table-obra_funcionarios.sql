CREATE TABLE IF NOT EXISTS public.obra_funcionarios (
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    id_funcionario INT NOT NULL,
    tenant_id VARCHAR(50) NOT NULL,
    descricao_obra VARCHAR(300),
    cargo VARCHAR(50),
    data_inicio DATE NOT NULL,
    data_fim DATE,
    status VARCHAR(20),
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_funcionarios_obra FOREIGN KEY (id_obra) REFERENCES obra(id),
    CONSTRAINT fk_obra_funcionarios_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);
