INSERT INTO tb_morador(nome, cpf, data_nascimento, celular, email) VALUES ('Evelyze Reis', 05722452629,'01/07/1983', '31-997082786','evelyze@yahoo.com.br')
INSERT INTO tb_morador(nome, cpf, data_nascimento, celular, email) VALUES ('Roberta Neves', 04872068602,'21/09/1980', '31-988802975','roberta@yahoo.com.br')
INSERT INTO tb_morador(nome, cpf, data_nascimento, celular, email) VALUES ('Mariana Rios', 03768625815,'12/03/1961', '31-936284526','mariana@yahoo.com.br')
INSERT INTO tb_morador(nome, cpf, data_nascimento, celular, email) VALUES ('Alexia Gervasio', 04869623815,'14/04/1987', '31-997806582','alexia@yahoo.com.br')
INSERT INTO tb_morador(nome, cpf, data_nascimento, celular, email) VALUES ('Fabbiana Pinheiro', 25825625816,'21/09/1980', '31-998758258','fabbiana@yahoo.com.br')

INSERT INTO tb_tipoconta(descricao, observacao) VALUES ('conta de luz', '100,00');
INSERT INTO tb_tipoconta(descricao, observacao) VALUES ('conta de agua', '100,00');
INSERT INTO tb_tipoconta(descricao, observacao) VALUES ('aluguel', '1000,00');
INSERT INTO tb_tipoconta(descricao, observacao) VALUES ('telefone', '60,00');
INSERT INTO tb_tipoconta(descricao, observacao) VALUES ('Internet', '100,00');
INSERT INTO tb_tipoconta(descricao, observacao) VALUES ('IPTU', '380,00');
INSERT INTO tb_tipoconta(descricao, observacao) VALUES ('Outros', '120,00');

INSERT INTO tb_conta(observacao, tipo_conta_id, valor, data_Vencimento, situacao, morador_responsavel_id) VALUES('Observação 1', 1, 100, '2025-01-01', 'PENDENTE', 1);
INSERT INTO tb_conta(observacao, tipo_conta_id, valor, data_Vencimento, situacao, morador_responsavel_id) VALUES('Observação 2', 2, 100, '2025-01-01', 'PENDENTE', 2);

INSERT INTO tb_rateioconta(conta_id, valor, morador_id, situacao) VALUES (1, 20, 1, 'EM_ABERTO');
INSERT INTO tb_rateioconta(conta_id, valor, morador_id, situacao) VALUES (1, 20, 2, 'PAGO');
INSERT INTO tb_rateioconta(conta_id, valor, morador_id, situacao) VALUES (1, 20, 3, 'EM_ABERTO');
INSERT INTO tb_rateioconta(conta_id, valor, morador_id, situacao) VALUES (1, 20, 4, 'EM_ABERTO');
INSERT INTO tb_rateioconta(conta_id, valor, morador_id, situacao) VALUES (1, 20, 5, 'PAGO');

INSERT INTO tb_historicoconta(conta_id,  morador_id, data, acao) VALUES(1, 1, '2025-06-30','CRIADA' );
