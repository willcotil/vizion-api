CREATE TABLE public.obra|_empreiteiro(
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    id_empreiteiro INT NOT NULL,
    tenant_id VARCHAR(50) NOT NULL,
    descricao_obra VARCHAR(300) NOT NULL,
    data_inicio NOT NULL TIMESTAMP TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_fim NOT NULL TIMESTAMP TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    valor_contratado DECIMAL,
    status VARCHAR(20),
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)

    CONSTRAINT FOREIGN KEY (id_obra) REFERENCES obra(id)
    CONSTRAINT FOREIGN KEY (id_empreiteiro) REFERENCES empreiteiro(id)
);}