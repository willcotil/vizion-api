CREATE TABLE IF NOT EXISTS public.obra_alocacao_equipe (
    id SERIAL PRIMARY KEY,
    id_obra INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    role_obra VARCHAR(50) NOT NULL,
    data_inicio TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_alocacao_obra FOREIGN KEY (id_obra) REFERENCES obra(id),
    CONSTRAINT fk_obra_alocacao_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
