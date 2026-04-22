CREATE TABLE public.obra_arquivos(
    id SERIAL PRIMARY KEY,
    nome_arquivo VARCHAR(100),
    url_arquivo VARCHAR(400),
    descricao_arquivo VARCHAR(200),
    id_obra_arquivos INT,
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)

    CONSTRAINT FOREIGN KEY (id_obra_arquivos) REFERENCES obra_arquivos(id)
);