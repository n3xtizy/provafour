create database cadastros;

create table cadastros(
                          id int not null auto_increment primary key,
                          biblioteca varchar(50),
                          genero varchar(50),
                          livro varchar(50)
)