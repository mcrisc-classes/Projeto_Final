use ComparsasBanco;

insert into `carros`(`placa`,  `descricao`, `duracao`,`quantidade_blocos`,`hora_entrada`,`hora_saida`)
values ('ASD0000', 'preto', 30, 4, '2022-03-21 12:30:00', '2022-03-21 13:00:00');
insert into `carros`(`placa`,  `descricao`, `duracao`,`quantidade_blocos`,`hora_entrada`,`hora_saida`)
values ('FFF0230', 'preto', 43, 1, '2022-03-22 14:30:00', '2022-03-21 15:13:00');
insert into `carros`(`placa`,  `descricao`, `duracao`,`quantidade_blocos`,`hora_entrada`,`hora_saida`)
values ('EEE0000', 'reabaixado', 5, 2, '2022-03-21 12:30:00', '2022-03-21 12:35:00');
insert into `carros`(`placa`,  `descricao`, `duracao`,`quantidade_blocos`,`hora_entrada`,`hora_saida`)
values ('CCC0000', 'branco', 25, 3, '2022-03-30 12:25:00', '2022-03-21 12:50:00');

select * from `carros`;

insert into `cliente`(`cpf`,  `telefone`,`n_cliente`, `observacoes`,`placa`)
values ('450454234-02', '9888888', 4, 'chato', 'FFF0230');
insert into `cliente`(`cpf`,  `telefone`,`n_cliente`, `observacoes`,`placa`)
values ('450454234-03', '9988888',  1, 'caloteiro', 'ASD0000');
insert into `cliente`(`cpf`,  `telefone`,`n_cliente`, `observacoes`,`placa`)
values ('450454234-04', '9998888', 2, 'vascaino', 'CCC0000');
insert into `cliente`(`cpf`,  `telefone`,`n_cliente`, `observacoes`,`placa`)
values ('450454234-05', '9999888',  3, 'tem amante','EEE0000');

select * from `cliente`;

insert into `estacionamento`(`id`,`vagas_totais`, `vagas_ocupadas`,`vagas_livre`, `tipo_bloco`)
values (1,30, 13, 17 , 'Blocos_meia_hora');

select * from `estacionamento`;

insert into `vaga`(`id`,`placa`)
values (1, 'FFF0230');
insert into `vaga`(`id`,`placa`)
values (2, 'ASD0000');
insert into `vaga`(`id`,`placa`)
values (3, 'CCC0000');
insert into `vaga`(`id`,`placa`)
values (4, 'EEE0000');


select * from `vaga`;

insert into `tarifa`(`placa`,  `preco_bloco`,`dt_pagamento`, `valor_pago`)
values ('ASD0000', 34.34, '2022-03-21 12:30:00', 100.80);
insert into `tarifa`(`placa`,  `preco_bloco`,`dt_pagamento`, `valor_pago`)
values ('FFF0230', 50.00, '2022-03-22 14:30:00',80.00);
insert into `tarifa`(`placa`,  `preco_bloco`,`dt_pagamento`, `valor_pago`)
values ('EEE0000', 34.00, '2022-03-21 12:30:00', 990.00 );
insert into `tarifa`(`placa`,  `preco_bloco`,`dt_pagamento`, `valor_pago`)
values ('CCC0000', 10.00, '2022-03-30 12:25:00', 200.00 );

select * from `tarifa`;
