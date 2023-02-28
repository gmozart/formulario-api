CREATE TABLE enderecos(
    id_endereco INT PRIMARY KEY NOT NULL,
    id_pessoa INT NOT NULL,
    cep INT NOT NULL,
    logradouro VARCHAR(300) NOT NULL,
    tipoEndereco VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    constraint fk_endereco_pessoa foreign key(id_pessoa) references pessoas(id_pessoa)
);

