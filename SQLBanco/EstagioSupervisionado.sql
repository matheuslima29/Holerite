/* Lógico_1: */

CREATE TABLE Funcionario (
    Id UNIQUEIDENTIFIER PRIMARY KEY UNIQUE,
    Login VARCHAR(100),
    Senha VARCHAR(255),
    Carga_Horaria_Mensal INT
);

CREATE TABLE Pontos (
    Id UNIQUEIDENTIFIER PRIMARY KEY UNIQUE,
    Id_Funcionario UNIQUEIDENTIFIER,
    Data DATE,
    Entrada1 TIME,
    Saida1 TIME,
    Entrada2 TIME,
    Saida2 TIME
);

CREATE TABLE Horarios (
    Id UNIQUEIDENTIFIER PRIMARY KEY UNIQUE,
    Id_Funcionario UNIQUEIDENTIFIER,
    Data_Registro DATE,
    Carga_Horaria_Mensal INT
);
 
ALTER TABLE Pontos ADD CONSTRAINT FK_Pontos_1
    FOREIGN KEY (Id_Funcionario)
    REFERENCES Funcionario (Id);
 
ALTER TABLE Horarios ADD CONSTRAINT FK_Horarios_3
    FOREIGN KEY (Id_Funcionario)
    REFERENCES Funcionario (Id);