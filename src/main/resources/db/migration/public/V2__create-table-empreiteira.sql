CREATE TABLE public.empreiteira(
    id SERIAL PRIMARY KEY,
    cnpj VARCHAR(18) NOT NULL,
    nome_fantasia VARCHAR(150) NOT NULL,
    razao_social VARCHAR(150) NOT NULL,
    id_endereco INT NOT NULL,
    id_usuario INT NOT NULL

    CONSTRAINT FOREIGN KEY (id_endereco) REFERENCES endereco(id)
    CONSTRAINT FOREIGN KEY (id_usuario) REFERENCES usuario(id)
)


