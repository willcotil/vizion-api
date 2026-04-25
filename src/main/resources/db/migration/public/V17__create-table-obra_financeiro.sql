CREATE TABLE IF NOT EXISTS public.obra_financeiro (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(200) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    valor DECIMAL(21,6) NOT NULL,
    data_pagamento DATE,
    data_estimado DATE NOT NULL,
    pago BOOLEAN NOT NULL DEFAULT FALSE,
    id_obra INT NOT NULL,
    id_material INT,
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_financeiro_obra FOREIGN KEY (id_obra) REFERENCES obra(id),
    CONSTRAINT fk_obra_financeiro_material FOREIGN KEY (id_material) REFERENCES material(id)
);
