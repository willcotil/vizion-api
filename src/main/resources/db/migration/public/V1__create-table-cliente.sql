CREATE TABLE public.cliente(
    id SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    tenantId TEXT NOT NULL,
    name VARCHAR(150) NOT NULL,
    documento VARCHAR(20) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(150) NOT NULL,
    CONSTRAINT FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
