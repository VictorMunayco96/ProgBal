DELIMITER $$
CREATE PROCEDURE PASetTipoProducto(

in _IdTipoProducto  Int,
in _TipoProducto    varchar(50),
in _CodTipoProducto varchar(15),
in _Estado          TinyInt,
in _Opcion          varchar(1)

 )
BEGIN
    if _Opcion='I' then 
        insert into TipoProducto (TipoProducto,CodTipoProducto,Estado) values (_TipoProducto,_CodTipoProducto,1)
    End IF;
   
    if _Opcion='U' then 
        Update TipoProducto set TipoProducto=_IdProducto, CodTipoProducto=_CodTipoProducto where IdTipoProducto=_IdTipoProducto;
    End If;

    if _Opcion='D' then 
        Update TipoProducto set Estado=0;
    End If; 
END
$$


DELIMITER $$
CREATE PROCEDURE PAGetTipoProducto(

in _IdTipoProducto  Int,
in _TipoProducto    varchar(50),
in _CodTipoProducto varchar(15),
in _Opcion          varchar(1)

 )
BEGIN
    if _Opcion='TODO' then 
        Select * from TipoProducto
        where Estado=1 
        order by IdTipoProducto desc; 
    End IF;
   
    if _Opcion='CODT' then 
        Select * from TipoProducto
        where Estado=1 and CodTipoProducto=_CodTipoProducto 
        order by IdTipoProducto desc;
    End If;
        
    if _Opcion='TIPO' then 
        Select * from TipoProducto
        where Estado=1 and TipoProducto=_TipoProducto 
        order by IdTipoProducto desc;
    End If; 
END
$$



DELIMITER $$
CREATE PROCEDURE PASetCategoriaProd(

in _IdCategoriaProd Int,
in _CategoriaProd   varchar(50),
in _CodCategoria    varchar(15),
in _Estado          TinyInt,
in _Opcion          varchar(1)

 )
BEGIN
    if _Opcion='I' then 
        insert into CategoriaProd (IdCategoriaProd,CategoriaProd,CodCategoria,Estado,IdTipoProducto) 
        values (_IdCategoriaProd,_CategoriaProd,_CodCategoria,1,_IdTipoProducto)
    End IF;
   
    if _Opcion='U' then 
        Update CategoriaProd set CategoriaProd=_CategoriaProd, CodCategoria=_CodCategoria where IdCategoriaProd=_IdCategoriaProd;
    End If;

    if _Opcion='D' then 
        Update CategoriaProd set Estado=0;
    End If; 
END
$$


DELIMITER $$
CREATE PROCEDURE PAGetCategoriaProd(

in _IdCategoriaProd Int,
in _CategoriaProd   varchar(50),
in _CodCategoria    varchar(15),
in _Estado          TinyInt,
in _Opcion          varchar(1)

 )
BEGIN
    if _Opcion='TODO' then 
        Select CP.IdCategoriaProd, CP.CategoriaProd, CP.CodCategoria, CP.IdTipoProducto, TP.TipoProducto from CategoriaProd CP
        inner join TipoProducto TP on CP.IdTipoProducto=TP.IdTipoProducto
        where Estado=1 
        order by IdCategoriaProd desc; 
    End IF;
   
    if _Opcion='CODC' then 
          Select CP.IdCategoriaProd, CP.CategoriaProd, CP.CodCategoria, CP.IdTipoProducto, TP.TipoProducto from CategoriaProd CP
        inner join TipoProducto TP on CP.IdTipoProducto=TP.IdTipoProducto
        where Estado=1 and CodCategoria=_CodCategoria
        order by IdCategoriaProd desc; 
    End If;
        
    if _Opcion='TIPO' then 
        Select * from TipoProducto
        where Estado=1 and TipoProducto=_TipoProducto 
        order by IdTipoProducto desc;
    End If; 
END
$$