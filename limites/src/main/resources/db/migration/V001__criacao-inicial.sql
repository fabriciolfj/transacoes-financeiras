create table limite (
id bigint not null auto_increment,
code_cliente varchar(30) not null,
quantidade_saques bigint not null,
quantidade_transferencia bigint not null,
volume_diario decimal(10,2) not null,
primary key (id)
) engine=InnoDB default charset=utf8;