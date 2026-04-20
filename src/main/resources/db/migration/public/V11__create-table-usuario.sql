CREATE TABLE public.usuario(
    id SERIAL PRIMARY KEY,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    id_status INT NOT NULL,
    id_role INT NOT NULL,
    id_tenant INT,
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)

    CONSTRAINT FOREIGN KEY (id_status) REFERENCES status(id)
    CONSTRAINT FOREIGN KEY (id_role) REFERENCES role(id)
    CONSTRAINT FOREIGN KEY (id_tenant) REFERENCES tenant(id)
);