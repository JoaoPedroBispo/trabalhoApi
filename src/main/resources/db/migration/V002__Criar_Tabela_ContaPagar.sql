Create Table contapagar(
    id int not null primary key auto_increment,
    data date,
    datavencimento date,
    valor decimal (12,2),
    idcliente int not null
);

alter table contapagar add constraint FK_ContaPagar_Cliente foreign key(idcliente) references cliente(id);

insert into contapagar(data, datavencimento, valor, idcliente) values ('2023/06/28', '2023/06/29', 1000, 1);
insert into contapagar(data, datavencimento, valor, idcliente) values ('2023/06/28', '2023/06/29', 1000, 2);
insert into contapagar(data, datavencimento, valor, idcliente) values ('2023/06/28', '2023/06/29', 1000, 3);
insert into contapagar(data, datavencimento, valor, idcliente) values ('2023/06/28', '2023/06/29', 1000, 4);
insert into contapagar(data, datavencimento, valor, idcliente) values ('2023/06/28', '2023/06/29', 1000, 5);