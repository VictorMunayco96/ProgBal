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
in _Contraseña varchar(45),
in _Opcion varchar(1)
)
BEGIN
if _Opcion='I' then
  insert into Usuario (DNI, Nombre, Apellidos, Usuario, Contraseña) values(_DNI, _Nombre, _Apellidos, _Usuario, _Contraseña);
  End IF;
  if _Opcion='U' then
  Update Usuario set  Nombre=_Nombre, Apelido=_Apellido, Usuario=_Usuario, Contraseña=_Contraseña where DNI=_DNI;
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
  Update Conductor set NumDoc=_NumDoc, Nombre=_Nombre, Apelido=_Apellido where IdConductor=_IdConductor;
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
CREATE PROCEDURE PASetConductorVehiculo(
in _IdConductorVehiculo int,
in _Fecha date,
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
  Update EmpreTrans set Ruc=_Ruc, RazonSocial=_RazonSocial, Domicilio=_Domicilio, NumCel=_NumCel where Ruc=Ruc;
  End If;
  if _Opcion='D' then
  delete from EmpreTrans where Ruc=_Ruc;
  End If;
  END
$$

DELIMITER $$
CREATE PROCEDURE PASetProveClien(
in _IdProveClient int,
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
