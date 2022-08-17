set foreign_key_checks = 0;

delete from cargo;
delete from funcionario;
delete from venda;

set foreign_key_checks = 1;

alter table cargo auto_increment = 1;
alter table funcionario auto_increment = 1;
alter table venda auto_increment = 1;

insert into cargo (nome, beneficio, salario) values ('SECRETARIO', 0, 7000);
insert into cargo (nome, beneficio, salario) values ('VENDEDOR', 0, 12000);
insert into cargo (nome, beneficio, salario) values ('GERENTE', 0, 20000);

insert into funcionario (nome, contratacao, cargo_id) values ('Jorge Carvalho', '2018-01-01', 1);
insert into funcionario (nome, contratacao, cargo_id) values ('Maria Souza', '2015-12-01', 1);
insert into funcionario (nome, contratacao, cargo_id) values ('Ana Silva', '2021-12-01', 2);
insert into funcionario (nome, contratacao, cargo_id) values ('João Mendes', '2021-12-01', 2);
insert into funcionario (nome, contratacao, cargo_id) values ('Juliana Alves', '2017-07-01', 3);
insert into funcionario (nome, contratacao, cargo_id) values ('Bento Albino', '2014-03-01', 3);

insert into venda (vendedor_id, data, valor) values (3, '2021-12-01', 5200);
insert into venda (vendedor_id, data, valor) values (3, '2022-01-01', 4000);
insert into venda (vendedor_id, data, valor) values (3, '2022-02-01', 4200);
insert into venda (vendedor_id, data, valor) values (3, '2022-03-01', 5850);
insert into venda (vendedor_id, data, valor) values (3, '2022-04-01', 7000);
insert into venda (vendedor_id, data, valor) values (4, '2021-12-01', 3400);
insert into venda (vendedor_id, data, valor) values (4, '2022-01-01', 7700);
insert into venda (vendedor_id, data, valor) values (4, '2022-02-01', 5000);
insert into venda (vendedor_id, data, valor) values (4, '2022-03-01', 5900);
insert into venda (vendedor_id, data, valor) values (4, '2022-04-01', 6500);
