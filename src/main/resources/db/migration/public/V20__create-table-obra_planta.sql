CREATE TABLE IF NOT EXISTS public.obra_planta (
    id SERIAL PRIMARY KEY,
    nome_arquivo VARCHAR(100) NOT NULL,
    url_arquivo VARCHAR(400) NOT NULL,
    descricao_arquivo VARCHAR(200),
    id_obra INT NOT NULL,
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_planta_obra FOREIGN KEY (id_obra) REFERENCES obra(id)
);
