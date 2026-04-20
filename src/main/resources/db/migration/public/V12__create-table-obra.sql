CREATE TABLE public.obra(
    id SERIAL PRIMARY KEY,
    id_tenant INT NOT NULL,
    nome_projeto VARCHAR(150) NOT NULL ,
    id_endereco INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_previsao_entrega DATE NOT NULL,
    valor_total_estimado DECIMAL NOT NULL,
    status VARCHAR(20) NOT NULL,
    id_financeiro INT,
    id_planta INT,
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)

    CONSTRAINT FOREIGN KEY (id_tenant) REFERENCES tenant(id)
    CONSTRAINT FOREIGN KEY (id_endereco) REFERENCES endereco(id)
    CONSTRAINT FOREIGN KEY (id_financeiro) REFERENCES financeiro(id)
    CONSTRAINT FOREIGN KEY (id_planta) REFERENCES planta(id)
);