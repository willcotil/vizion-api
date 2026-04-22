CREATE TABLE IF NOT EXISTS fases_obra (
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    nome_fase VARCHAR(100) NOT NULL,
    descricao VARCHAR(500),
    data_inicio_estimada DATE,
    data_iniciada DATE,
    data_fim_estimada DATE,
    data_finalizada DATE,
    valor_estimado DECIMAL,
    valor_pago DECIMAL,
    status VARCHAR(20) NOT NULL,
    ordem_exibicao INT,
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_fases_obra_obra FOREIGN KEY (id_obra) REFERENCES public.obra(id)
);

CREATE TABLE IF NOT EXISTS obra_financeiro (
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
    CONSTRAINT fk_obra_financeiro_obra FOREIGN KEY (id_obra) REFERENCES public.obra(id),
    CONSTRAINT fk_obra_financeiro_material FOREIGN KEY (id_material) REFERENCES public.material(id)
);

CREATE TABLE IF NOT EXISTS obra_material (
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
    CONSTRAINT fk_obra_material_material FOREIGN KEY (id_material) REFERENCES public.material(id)
);

CREATE TABLE IF NOT EXISTS estoque (
    id SERIAL PRIMARY KEY,
    id_material INT NOT NULL,
    quantidade_atual DECIMAL NOT NULL,
    quantidade_minima DECIMAL NOT NULL,
    quantidade_maxima DECIMAL NOT NULL,
    localizacao VARCHAR(50),
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_estoque_material FOREIGN KEY (id_material) REFERENCES public.material(id)
);

CREATE TABLE IF NOT EXISTS movimentacao_estoque (
    id SERIAL PRIMARY KEY,
    id_estoque INT NOT NULL,
    tipo_movimentacao VARCHAR(20) NOT NULL,
    quantidade DECIMAL NOT NULL,
    valor_unitario DECIMAL,
    motivo VARCHAR(200),
    referencia VARCHAR(100),
    data_movimentacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    usuario_responsavel VARCHAR(100),
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_movimentacao_estoque_estoque FOREIGN KEY (id_estoque) REFERENCES estoque(id)
);
