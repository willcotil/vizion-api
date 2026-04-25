CREATE TABLE IF NOT EXISTS public.obras_documentos(
    id SERIAL PRIMARY KEY,
    id_obra INT NOT NULL,
    tipo_documento VARCHAR(20) NOT NULL,
    nome_arquivo VARCHAR(100) NOT NULL,
    url_arquivo VARCHAR(400) NOT NULL,
    descricao_arquivo VARCHAR(200),
    data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255),
    CONSTRAINT fk_obras_documentos_obra FOREIGN KEY (id_obra) REFERENCES obra(id)
);

INSERT INTO public.obras_documentos (id_obra, tipo_documento, nome_arquivo, url_arquivo, descricao_arquivo)
SELECT id_obra, 'ARQUIVO', nome_arquivo, url_arquivo, descricao_arquivo
FROM public.obra_arquivos;

INSERT INTO public.obras_documentos (id_obra, tipo_documento, nome_arquivo, url_arquivo, descricao_arquivo)
SELECT id_obra, 'PLANTA', nome_arquivo, url_arquivo, descricao_arquivo
FROM public.obra_planta;

DROP TABLE IF EXISTS public.obra_planta;
DROP TABLE IF EXISTS public.obra_arquivos;
DROP TABLE IF EXISTS public.obra_alocacao_equipe;
