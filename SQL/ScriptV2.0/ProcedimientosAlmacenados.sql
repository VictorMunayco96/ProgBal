/*------------------------------------------TIPO PRODUCTO-----------------------------------*/

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
        insert into TipoProducto (TipoProducto,CodTipoProducto,Estado) values (_TipoProducto,_CodTipoProducto,1);
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

/*------------------------------------------CATEGORIA PRODUCTO-----------------------------------*/

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
        values (_IdCategoriaProd,_CategoriaProd,_CodCategoria,1,_IdTipoProducto);
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
        
    if _Opcion='CATE' then 
        Select CP.IdCategoriaProd, CP.CategoriaProd, CP.CodCategoria, CP.IdTipoProducto, TP.TipoProducto from CategoriaProd CP
        inner join TipoProducto TP on CP.IdTipoProducto=TP.IdTipoProducto
        where Estado=1 and CategoriaProd=_CategoriaProd
        order by IdCategoriaProd desc;
    End If; 

       
    if _Opcion='IDTI' then 
        Select CP.IdCategoriaProd, CP.CategoriaProd, CP.CodCategoria, CP.IdTipoProducto, TP.TipoProducto from CategoriaProd CP
        inner join TipoProducto TP on CP.IdTipoProducto=TP.IdTipoProducto
        where Estado=1 and IdTipoProducto=_IdTipoProducto
        order by IdCategoriaProd desc;
    End If; 

END
$$

/*------------------------------------------PRODUCTO-----------------------------------*/

DELIMITER $$
CREATE PROCEDURE PASetProducto(

in _IdProducto      Int,
in _Producto        varchar(60),
in _CodProducto     varchar(15),
in _Estado          TinyInt,
in _IdCategoriaProd Int,
in _NombreGuia      Varchar(150),
in _Opcion          varchar(1)
 )
BEGIN
    if _Opcion='I' then 
        insert into Producto (Producto, CodProducto, Estado, IdCategoriaProd, NombreGuia) 
        values (_Producto, _CodProducto, 1, _IdCategoriaProd, _NombreGuia);
    End IF;
   
    if _Opcion='U' then 
        Update Producto set Producto=_Producto, CodProducto=_CodProducto, IdCategoriaProd=_IdCategoriaProd, NombreGuia=_NombreGuia  where _IdProducto=_IdProducto;
    End If;

    if _Opcion='D' then 
        Update Producto set Estado=0;
    End If; 
END
$$



DELIMITER $$
CREATE PROCEDURE PAGetProducto(

in _IdProducto      Int,
in _Producto        varchar(50),
in _CodProducto     varchar(15),
in _Estado          TinyInt,
in _IdCategoriaProd Int,
in _NombreGuia      Varchar(150),
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
        
    if _Opcion='CATE' then 
        Select CP.IdCategoriaProd, CP.CategoriaProd, CP.CodCategoria, CP.IdTipoProducto, TP.TipoProducto from CategoriaProd CP
        inner join TipoProducto TP on CP.IdTipoProducto=TP.IdTipoProducto
        where Estado=1 and CategoriaProd=_CategoriaProd
        order by IdCategoriaProd desc;
    End If; 

       
    if _Opcion='IDTI' then 
        Select CP.IdCategoriaProd, CP.CategoriaProd, CP.CodCategoria, CP.IdTipoProducto, TP.TipoProducto from CategoriaProd CP
        inner join TipoProducto TP on CP.IdTipoProducto=TP.IdTipoProducto
        where Estado=1 and IdTipoProducto=_IdTipoProducto
        order by IdCategoriaProd desc;
    End If; 

END
$$



/*------------------------------------------TIPO DESTINO-----------------------------------*/

$$ DELIMETER 

CREATE PROCEDURE PASetTipoDestino(

  in _IdTipoDestino     int,  
  in _TipoDestino       Varchar(50),  
  in _CodDestino        Varchar(15),
  in _Estado            Tinyint,

  in _Opcion            Varchar(1)


)
BEGIN

 if _Opcion='I' then 
        
        Insert into TipoDestino (TipoDestino,CodDestino,Estado) values(_TipoDestino,_CodDestino,1);

    End IF;
   
    if _Opcion='U' then 
        Update TipoDestino set TipoDestino=_TipoDestino, CodDestino=_CodDestino where IdTipoDestino=_IdTipoDestino;
    End If;

    if _Opcion='D' then 
        Update TipoDestino set Estado=0;
    End If; 
END




$$

/*------------------------------------------DESTINO-----------------------------------*/

$$ DELIMETER

CREATE PROCEDURE PASetDestino(

  in _IdDestino     int,
  in _Destino       Varchar(80),
  in _CodDestino    Varchar(15),
  in _Estado        Tinyint,
  in _IdTipoDestino Int,

  in _Opcion        Varchar(1)

  

) 
BEGIN

    if _Opcion= 'I' then

        Insert into Destino (Destino,CodDestino,Estado,IdTipoDestino) Values(_Destino,_CodDestino,1,_IdTipoDestino);

    End IF;

    if _Opcion='U' then
    
        Update Destino set Destino=_Destino, CodDestino=_CodDestino, IdTipoDestino=_IdTipoDestino where IdDestino=_IdDestino;
    
    End If;

    if _Opcion='D' then
    
        Update Destino set Estado=0;
    
        End if;
        
    END
    $$

    $$ DELIMETER


/*------------------------------------------TIPO DESTINO DESC-----------------------------------*/


    CREATE PROCEDURE PASetDestinoDesc(

        in _IdDestinoDesc   Int,
        in _DestinoDes      Varchar(80),
        in _CodDestinoDesc  Varchar(15),
        in _Estado          Tinyint,
        in _IdDestino       Int,

        in _Opcion          Varchar(1)

    

    )
    BEGIN

    if _Opcion='I' then

            Insert into DestinoDesc (DestinoDes,CodDestinoDesc,Estado,IdDestino) Values(_DestinoDes,_CodDestinoDesc,1,_IdDestino);

    End IF;

    if _Opcion='U' then
        Update DestinoDesc set DestinoDes=_DestinoDes, CodDestinoDesc=_CodDestinoDesc,IdDestino=_IdDestino where IdDestinoDesc=_IdDestinoDesc;
        End If;

        if _Opcion='D' then
            Update DestinoDesc set Estado=0;
            End if;

        END
        
        $$


        $$ DELIMETER


        /*------------------------------------------TIPO DESTINO BLOQ-----------------------------------*/

        CREATE PROCEDURE PASetDestinoBloq(

            in _IdDestinoBloq       Int,
            in _DestinoBloq         Varchar(45),
            in _CodDestinoBloq      Varchar(15),
            in _Estado              Tinyint,
            in _IdDestinoDesc       Int,

            in _Opcion              Varchar(1)



        )
        BEGIN

        if _Opcion='I' then

                Insert into DestinoBloq (DestinoBloq,CodDestinoBloq,Estado,IdDestinoDesc) Values(_DestinoBloq,_CodDestinoBloq,1,_IdDestinoDesc);

        End If;

        if _Opcion='U' then
        
                Update DestinoBloq set DestinoBloq=_DestinoBloq, CodDestinoBloq=_CodDestinoBloq, IdDestino=_IdDestino where _IdDestinoBloq=_IdDestinoBloq;
        
        End If;

        If _Opcion='D' then 
        
                Update DestinoBloq set Estado=0;
        
        End if;

            END

            $$



/*------------------------------------------TIPO GALPON-----------------------------------*/

  $$ DELIMETER

    CREATE PROCEDURE PASetGalpon(
                
    in _IdGalpon    Int,
    in _Galpon      Varchar(45),
    in _CodGalpon   Varchar(45),
    in _Estado      Tinyint,
    in _IdDestinoBloq   Int,
    in _Opcion      Varchar(1)

     )
    BEGIN

            if _Opcion='I' then

                    Insert into Galpon (Galpon,CodGalpon,Estado,IdDestinoBloq) Values(_Galpon,_CodGalpon,1,_IdDestinoBloq);

            End If;

            if _Opcion='U' then
            
                    Update Galpon set Galpon=_Galpon, CodGalpon=_CodGalpon, Estado=_Estado, IdDestinoBloq=_IdDestinoBloq where IdGalpon=_IdGalpon;
            
            End iF;

            If _Opcion='D' then
            
                    Update Galpon set Estado=0;
                    
            End If;

    END

  $$ 

