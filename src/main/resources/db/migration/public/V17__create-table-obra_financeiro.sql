CREATE TABLE public.obra_financeiro(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(200) NOT NULL,
    id_tipo INT NOT NULL,
    valor DECIMAL NOT NULL,
    data_pagamento DATE,
    data_pagamento DATE NOT NULL,
    pago BIT NOT NULL,
    id_obra INT NOT NULL,
    id_material INT,
    data_criacao NOT NULL TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP WITHOUT TIME ZONE,
    criado_por NOT NULL VARCHAR(255) DEFAULT 'SYSTEM',
    atualizado_por VARCHAR(255)

    CONSTRAINT FOREIGN KEY (id_tipo) REFERENCES tipo(id)
    CONSTRAINT FOREIGN KEY (id_obra) REFERENCES obra(id)
    CONSTRAINT FOREIGN KEY (id_material) REFERENCES material(id)
);