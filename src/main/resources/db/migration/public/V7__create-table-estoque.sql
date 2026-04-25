CREATE TABLE IF NOT EXISTS public.estoque (
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
    atualizado_por VARCHAR(255)
);
