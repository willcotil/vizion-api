CREATE TABLE IF NOT EXISTS public.obra_material (
    id SERIAL PRIMARY KEY,
    id_fase INT,
    id_material INT NOT NULL,
    quantidade DECIMAL NOT NULL,
    valor_material DECIMAL NOT NULL,
    data_alocacao DATE,
    descricao_material VARCHAR(200),
    nome_material VARCHAR(100),
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_material_fase FOREIGN KEY (id_fase) REFERENCES fases_obra(id),
    CONSTRAINT fk_obra_material_material FOREIGN KEY (id_material) REFERENCES material(id)
);
