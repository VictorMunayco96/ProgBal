USE mydb;
Insert Into Categoria(IdCategoria, Categoria) values (0,"INGRESAR CAMPO");
Insert Into Producto (IdProducto, Producto,Descripcion,IdCategoria) values(0,"INGRESAR CAMPO","INGRESAR CAMPO",1);
Insert Into Destino (IdDestino, Destino) values(0,"INGRESAR CAMPO");
Insert Into Usuario (DNI,Nombre,Apellidos,Usuario,Contrasena) values (70605597,"ADMIN","","4DM1N","4DM1N");

select * from Usuario;


select * from Categoria;
select * from Producto;
select * from Destino;
select * from empreTrans;
select * from proveclien;
select * from conductor;
select * from vehiculo;
select * from conductorvehiculo;
SELECT * FROM USUARIO;

select * from peso;

DELETE FROM PESO WHERE IDPESO=2;
INSERT INTO USUARIO VALUES (12345678,'VISITANTE','VISITANTE','VISITANTE','VISITANTE');
