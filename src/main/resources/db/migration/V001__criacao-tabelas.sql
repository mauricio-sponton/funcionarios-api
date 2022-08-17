create table cargo (
       id bigint not null auto_increment,
        beneficio decimal(19,2),
        nome varchar(255),
        salario decimal(19,2),
        primary key (id)
    ) engine=InnoDB;

    create table funcionario (
       id bigint not null auto_increment,
        contratacao date not null,
        nome varchar(255) not null,
        cargo_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table venda (
       id bigint not null auto_increment,
        vendedor_id bigint not null,
        data date not null,
        valor decimal(19,2),
        primary key (id)
    ) engine=InnoDB;

    alter table funcionario 
       add constraint fk_funcionario_cargo 
       foreign key (cargo_id) 
       references cargo (id);

    alter table venda 
       add constraint venda_funcionario 
       foreign key (vendedor_id) 
       references funcionario (id);
