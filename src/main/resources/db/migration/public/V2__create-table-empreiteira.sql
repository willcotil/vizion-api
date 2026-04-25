CREATE TABLE IF NOT EXISTS public.empreiteira (
    id SERIAL PRIMARY KEY,
    cnpj VARCHAR(18) NOT NULL,
    nome_fantasia VARCHAR(150),
    razao_social VARCHAR(150) NOT NULL,
    id_endereco INT,
    id_usuario INT
);
