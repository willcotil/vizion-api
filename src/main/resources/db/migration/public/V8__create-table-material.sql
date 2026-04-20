CREATE TABLE public.material(
    id SERIAL PRIMARY KEY,
    nome_material VARCHAR(100) NOT NULL,
    descricao_material VARCHAR(300),
    unidade_medida VARCHAR(20) NOT NULL,
    preco_unitario DECIMAL NOT NULL,
    categoria VARCHAR(50),
    ativo BIT,
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)


);