CREATE TABLE public.obra_material(
    id SERIAL PRIMARY KEY,
    id_fase_obra INT,
    id_material INT NOT NULL,
    quantidade DECIMAL NOT NULL,
    valor_material DECIMAL NOT NULL,
    data_alocacao DATE,
    descricao_material VARCHAR(200),
    nome_material VARCHAR(100),
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)

    CONSTRAINT FOREIGN KEY (id_fase_obra) REFERENCES fase_obra(id)
    CONSTRAINT FOREIGN KEY (id_material) REFERENCES material(id)
);