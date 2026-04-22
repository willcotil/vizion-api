CREATE TABLE public.obra_funcionario(
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    id_funcionario INT NOT NULL,
    tenant_id VARCHAR(50) NOT NULL,
    descricao_obra VARCHAR(300),
    cargo VARCHAR(50),
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    status VARCHAR(20),
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)

    CONSTRAINT FOREIGN KEY (id_obra) REFERENCES obra(id)
    CONSTRAINT FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);