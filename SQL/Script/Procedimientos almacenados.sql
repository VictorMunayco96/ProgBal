DELIMITER $$
 CREATE PROCEDURE PASetCategoria(

in _IdCategoria Int,
in _Categoria varchar(45),
in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then 
     insert into Categoria (Categoria) values(_Categoria);
      End IF;
   
   if _Opcion='U' then 
      Update Categoria set Categoria=_Categoria where IdCategoria=_IdCategoria;
      End If;
       if _Opcion='D' then 
    delete from Categoria where IdCategoria=_IdCategoria;
   
   End If; 
   END
   $$
  
  
DELIMITER $$
CREATE PROCEDURE PASetDestino(
in _IdDestino Int,
in _Destino varchar(45),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into Destino (Destino) values(_Destino);
  End IF;
  
  
  if _Opcion='U' then
  Update Destino set Destino=_Destino where IdDestino=_IdDestino;
  End If;
  if _Opcion='D' then
  delete from Destino where IdDestino=_IdDestino;
  End If;
  END
$$

DELIMITER $$
CREATE PROCEDURE PASetUsuario(
in _DNI Int,
in _Nombre varchar(45),
in _Apellidos varchar(45),
in _Usuario varchar(45),
in _Contrasena varchar(45),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into Usuario (DNI, Nombre, Apellidos, Usuario, Contrasena) values(_DNI, _Nombre, _Apellidos, _Usuario, _Contrasena);
  End IF;
  if _Opcion='U' then
  Update Usuario set  Nombre=_Nombre, Apellidos=_Apellidos, Usuario=_Usuario, Contrasena=_Contrasena where DNI=_DNI;
  End If;
  if _Opcion='D' then
  delete from Usuario where DNI=_DNI;
  End If;
  END
$$

DELIMITER $$
CREATE PROCEDURE PASetConductor(
in _IdConductor Int,
in _NumDoc varchar(45),
in _Nombre varchar(60),
in _Apellidos varchar(60),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into Conductor (NumDoc, Nombre, Apellidos) values(_NumDoc, _Nombre, _Apellidos);
  End IF;
  if _Opcion='U' then
  Update Conductor set NumDoc=_NumDoc, Nombre=_Nombre, Apellidos=_Apellidos where IdConductor=_IdConductor;
  End If;
  if _Opcion='D' then
  delete from Conductor where IdConductor=_IdConductor;
  End If;
  END
$$



DELIMITER $$
CREATE PROCEDURE PASetVehiculo(
in _Placa varchar(8),
in _Marca varchar(45),
in _Ruc bigint,
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into Vehiculo (Placa, Marca, Ruc) values(_Placa, _Marca, _Ruc);
  End IF;
  if _Opcion='U' then
  Update Vehiculo set  Marca=_Marca, Ruc=_Ruc where Placa=_Placa;
  End If;
  if _Opcion='D' then
  delete from Vehiculo where Placa=_Placa;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PAGetVehiculo(
in _Placa varchar(8),
in _Ruc bigint,
in _RazonSocial varchar(80),
in _Opcion varchar(2)
)
BEGIN
if _Opcion='T' then
select V.Placa, V.Marca, V.Ruc, E.RazonSocial from Vehiculo V 
inner join EmpreTrans E on V.Ruc=E.Ruc;
  End IF;
  if _Opcion='PL' then
  select V.Placa, V.Marca, V.Ruc, E.RazonSocial from Vehiculo V 
inner join EmpreTrans E on V.Ruc=E.Ruc
where V.Placa=_Placa;
  End If;
  if _Opcion='RU' then
  select V.Placa, V.Marca, V.Ruc, E.RazonSocial from Vehiculo V 
inner join EmpreTrans E on V.Ruc=E.Ruc
where V.Ruc=_Ruc;
  End If;
if _Opcion='RA' then
  select V.Placa, V.Marca, V.Ruc, E.RazonSocial from Vehiculo V 
inner join EmpreTrans E on V.Ruc=E.Ruc
where E.RazonSocial like concat('%',_RazonSocial,'%');
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PASetConductorVehiculo(
in _IdConductorVehiculo int,
in _Fecha varchar(12),
in _IdConductor int,
in _Placa varchar(8),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into ConductorVehiculo (Fecha,IdConductor, Placa) values(_Fecha,_IdConductor, _Placa);
  End IF;
  if _Opcion='U' then
  Update ConductorVehiculo set Fecha=_Fecha,IdConductor=_IdConductor, Placa=_Placa where IdConductorVehiculo=_IdConductorVehiculo;
  End If;
  if _Opcion='D' then
  delete from ConductorVehiculo where IdConductorVehiculo=_IdConductorVehiculo;
  End If;
  END
$$

DELIMITER $$
CREATE PROCEDURE PAGetConductorVehiculo(

in _Fecha varchar(12),
in _IdConductor int,
in _Placa varchar(8),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='T' then
	  Select CV.IdConductorVehiculo, CV.Fecha, C.IdConductor, C.Nombre,C.Apellidos, CV.Placa from ConductorVehiculo CV 
  inner join Conductor C on CV.IdConductor=C.IdConductor
    order by CV.IdConductorVehiculo desc limit 2500;
  End IF;
  if _Opcion='F' then
  Select CV.IdConductorVehiculo, CV.Fecha, C.IdConductor, C.Nombre,C.Apellidos, CV.Placa from ConductorVehiculo CV 
   inner join Conductor C on CV.IdConductor=C.IdConductor
    where CV.Fecha=_Fecha
    order by CV.IdConductorVehiculo desc limit 2500;
  End If;
  if _Opcion='I' then
  Select CV.IdConductorVehiculo, CV.Fecha, C.IdConductor, C.Nombre,C.Apellidos, CV.Placa from ConductorVehiculo CV 
  inner join Conductor C on CV.IdConductor=C.IdConductor
    where CV.IdConductor=_IdConductor
    order by CV.IdConductorVehiculo desc limit 2500;
  End If;
  
    if _Opcion='P' then
  Select CV.IdConductorVehiculo, CV.Fecha, CV.IdConductor, C.Nombre,C.Apellidos, CV.Placa from ConductorVehiculo CV 
  inner join Conductor C on CV.IdConductor=C.IdConductor  
  where CV.Placa=_Placa 
  order by CV.IdConductorVehiculo desc limit 2500;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PASetProducto(
in _IdProducto Int,
in _Producto varchar(45),
in _Descripcion varchar(80),
in _IdCategoria Int,
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into Producto (Producto, Descripcion,IdCategoria) values(_Producto, _Descripcion, _IdCategoria);
  End IF;
  if _Opcion='U' then
  Update Producto set Producto=_Producto, Descripcion=_Descripcion where IdProducto=_IdProducto;
  End If;
  if _Opcion='D' then
  delete from Producto where IdProducto=_IdProducto;
  End If;
  END
$$

DELIMITER $$
CREATE PROCEDURE PAGetProducto(
in _IdProducto Int,
in _Producto varchar(45),
in _Descripcion varchar(80),
in _Categoria varchar(45),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='T' then
 select P.IdProducto, P.Producto, P.Descripcion, P.IdCategoria, C.Categoria from Producto P 
 inner join Categoria C on P.IdCategoria=C.IdCategoria
 order by P.IdProducto desc;
  End IF;
  if _Opcion='I' then
 select P.IdProducto, P.Producto, P.Descripcion, P.IdCategoria, C.Categoria from Producto P 
 inner join Categoria C on P.IdCategoria=C.IdCategoria
 where P.IdProducto=_IdProducto
 order by P.IdProducto desc;
  End If;
  if _Opcion='P' then
 select P.IdProducto, P.Producto, P.Descripcion, P.IdCategoria, C.Categoria from Producto P 
 inner join Categoria C on P.IdCategoria=C.IdCategoria
 where P.Producto like concat('%',_Producto,'%') 
 order by P.IdProducto desc;
  End If;
  
  if _Opcion='D' then
 select P.IdProducto, P.Producto, P.Descripcion, P.IdCategoria, C.Categoria from Producto P 
 inner join Categoria C on P.IdCategoria=C.IdCategoria
 where P.Descripcion like concat('%',_Descripcion,'%') 
 order by P.IdProducto desc;
  End If;
 
    if _Opcion='C' then
 select P.IdProducto, P.Producto, P.Descripcion, P.IdCategoria, C.Categoria from Producto P 
 inner join Categoria C on P.IdCategoria=C.IdCategoria
 where C.Categoria like concat('%',_Categoria,'%') 
 order by P.IdProducto desc;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PASetPeso(
in _IdPeso Int,
in _TipoMovimiento varchar(45),
in _Guia varchar(20),
in _FechaGuia datetime,
in _FechaHoraSal datetime,
in _FechaHoraEnt datetime,
in _PesoCE int,
in _PesoCS int,
in _PesoGE int,
in _PesoGS int,
in _ObservE varchar(100),
in _ObservS varchar(100),
in _DNI int,
in _IdProveClien int,
in _IdDestino int,
in _IdProducto int,
in _IdConductorVehiculo int,
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into Peso (TipoMovimiento, Guia, FechaGuia, FechaHoraSal, FechaHoraEnt, PesoCE, PesoCS, PesoGE, PesoGS, ObservE, ObservS, DNI,
  IdProveClien, IdDestino, IdProducto, IdConductorVehiculo)
  values(_TipoMovimiento, _Guia, _FechaGuia, _FechaHoraSal, _FechaHoraEnt, _PesoCE, _PesoCS, _PesoGE, _PesoGS, _ObservE, _ObservS, _DNI,
  _IdProveClien, _IdDestino, _IdProducto, _IdConductorVehiculo);
  End IF;
  if _Opcion='U' then
  Update Peso set TipoMovimiento=_TipoMovimiento, Guia=_Guia, FechaGuia=_FechaGuia, FechaHoraSal=_FechaHoraSal, FechaHoraEnt=_FechaHoraEnt,
  PesoCE=_PesoCE, PesoCS=_PesoCS, PesoGE=_PesoGE, PesoGS=_PesoGS, ObservE=_ObservE, ObservS=_ObservS, DNI=_DNI, IdProveClien=_IdProveClien
  , IdDestino=_IdDestino, IdProducto=_IdProducto, IdConductorVehiculo=_IdConductorVehiculo where IdPeso=_IdPeso;
  End If;
  if _Opcion='D' then
  delete from Peso where IdPeso=_IdPeso;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PASetEmpreTrans(
in _Ruc bigint,
in _RazonSocial varchar(45),
in _Domicilio varchar(60),
in _NumCel varchar(15),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into EmpreTrans (Ruc, RazonSocial, Domicilio, NumCel) values(_Ruc, _RazonSocial, _Domicilio, _NumCel);
  End IF;
  if _Opcion='U' then
  Update EmpreTrans set  RazonSocial=_RazonSocial, Domicilio=_Domicilio, NumCel=_NumCel where Ruc=Ruc;
  End If;
  if _Opcion='D' then
  delete from EmpreTrans where Ruc=_Ruc;
  End If;
  END
$$

use mydb;
drop procedure PaSetProveClien;

DELIMITER $$
CREATE PROCEDURE PASetProveClien(
in _IdProveClien int,
in _RazonSocial varchar(45),
in _Ruc bigint(15),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into ProveClien (RazonSocial, Ruc) values(_RazonSocial, _Ruc);
  End IF;
  if _Opcion='U' then
  Update ProveClien set RazonSocial=_RazonSocial, Ruc=_Ruc where IdProveClien=_IdProveClien;
  End If;
  if _Opcion='D' then
  delete from ProveClien where IdProveClien=_IdProveClien;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PAGetUsuario(
in _DNI Int,
in _Nombre varchar(45),
in _Usuario varchar(45),
in _Contrasena varchar(45),
in _Opcion varchar(1)
)
BEGIN

if _Opcion='T' then
select Usu.DNI, Usu.Nombre, Usu.Apellidos, Usu.Usuario, Usu.Contrasena from Usuario Usu  order by Usu.DNI desc ;
  End IF;

if _Opcion='D' then
select Usu.DNI, Usu.Nombre, Usu.Apellidos, Usu.Usuario, Usu.Contrasena from Usuario Usu where Usu.DNI=_DNI order by Usu.DNI desc ;
  End IF;
  
  if _Opcion='N' then
select Usu.DNI, Usu.Nombre, Usu.Apellidos, Usu.Usuario, Usu.Contrasena from Usuario Usu where Usu.Nombre like concat('%',_Nombre,'%') order by Usu.DNI desc ;
  End If;
  
  if _Opcion='L' then
  select Usu.DNI, Usu.Nombre, Usu.Apellidos, Usu.Usuario, Usu.Contrasena from Usuario Usu where Usu.Usuario=_Usuario and Usu.Contrasena=_Contrasena 
  order by Usu.DNI desc ;
  
  End If;
  END
$$

DELIMITER $$
CREATE PROCEDURE PAGetConductor(
in _IdConductor Int,
in _NumDoc varchar(45),
in _Nombre varchar(45),
in _Opcion varchar(1)
)
BEGIN

if _Opcion='T' then
select Con.IdConductor, Con.NumDoc, Con.Nombre, Con.Apellidos from Conductor Con  order by Con.IdConductor desc ;
  End IF;

if _Opcion='I' then
select Con.IdConductor, Con.NumDoc, Con.Nombre, Con.Apellidos from Conductor Con where Con.IdConductor=_IdConductor order by Con.IdConductor desc ;
  End IF;
  if _Opcion='D' then
  
  select Con.IdConductor, Con.NumDoc, Con.Nombre, Con.Apellidos from Conductor Con where Con.NumDoc=_NumDoc order by Con.IdConductor desc ;
  
  End If;
  
  if _Opcion='N' then
  
  select Con.IdConductor, Con.NumDoc, Con.Nombre, Con.Apellidos from Conductor Con where Con.Nombre like concat('%',_Nombre,'%') order by Con.IdConductor desc ;
  
  End If;
  END
$$

DELIMITER $$
CREATE PROCEDURE PAGetCategoria(
in _IdCategoria int,
in _Categoria varchar(45),
in _Opcion varchar(1)
)
BEGIN

if _Opcion='T' then
select Cat.IdCategoria, Cat.Categoria from Categoria Cat  order by Cat.IdCategoria desc ;
  End IF;

if _Opcion='C' then
select Cat.IdCategoria, Cat.Categoria from Categoria Cat where Cat.IdCategoria=_IdCategoria  order by Cat.IdCategoria desc ;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PAGetEmpreTrans(
in _Ruc bigint,
in _RazonSocial varchar(80),
in _Opcion varchar(2)
)
BEGIN

if _Opcion='T' then
select ET.Ruc, ET.RazonSocial, ET.Domicilio, ET.NumCel from EmpreTrans ET  order by ET.Ruc desc ;
  End IF;

if _Opcion='RU' then
select ET.Ruc, ET.RazonSocial, ET.Domicilio, ET.NumCel from EmpreTrans ET where ET.Ruc like concat('%',_Ruc,'%')  order by ET.Ruc desc ;
  End If;
  
  if _Opcion='RA' then
  select ET.Ruc, ET.RazonSocial, ET.Domicilio, ET.NumCel from EmpreTrans ET where ET.RazonSocial like concat('%',_RazonSocial,'%') order by ET.Ruc desc ;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PAGetDestino(
in _IdDestino int,
in _Destino varchar(45),
in _Opcion varchar(2)
)
BEGIN

if _Opcion='T' then
select Des.IdDestino, Des.Destino from Destino Des order by Des.IdDestino desc ;
  End IF;

if _Opcion='ID' then
select Des.IdDestino, Des.Destino from Destino Des where Des.IdDestino=_IdDestino  order by Des.IdDestino desc ;
  End If;

if _Opcion='DE' then
select Des.IdDestino, Des.Destino from Destino Des where Des.Destino like concat('%',_Destino,'%')  order by Des.IdDestino desc ;
  End If;
  END
$$


DELIMITER $$
CREATE PROCEDURE PAGetProveClien(
in _IdProveClien Int,
in _RazonSocial varchar(45),
in _Ruc bigint,
in _Opcion varchar(2)
)
BEGIN

if _Opcion='T' then
select PC.IdProveClien, PC.RazonSocial, PC.Ruc from ProveClien PC  order by PC.IdProveClien desc ;
  End IF;

if _Opcion='ID' then
select PC.IdProveClien, PC.RazonSocial, PC.Ruc from ProveClien PC where PC.IdProveClien=_IDProveClien order by PC.IdProveClien desc ;
  End IF;

if _Opcion='RA' then
select PC.IdProveClien, Pc.RazonSocial, PC.Ruc from ProveClien PC where PC.RazonSocial=_RazonSocial order by PC.IdProveClien desc ;
  End IF;
  if _Opcion='RU' then
select PC.IdProveCien, PC.RazonSocial, PC.Ruc from ProveClien PC where PC.Ruc=_Ruc order by PC.IdProveClien desc ; 
  End If;
  END
$$


