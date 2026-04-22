CREATE TABLE IF NOT EXISTS public.obra (
    id SERIAL PRIMARY KEY,
    tenant_id VARCHAR(50) NOT NULL,
    nome_projeto VARCHAR(150) NOT NULL,
    id_endereco INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_previsao_entrega DATE NOT NULL,
    valor_total_estimado DECIMAL NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obra_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id)
);
