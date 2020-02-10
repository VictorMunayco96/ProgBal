/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DProducto;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Victor
 */
public class NProducto {
    public String NSetProducto(int IdProducto,String Producto,String Descripcion,int IdCategoria,String Opcion){

DProducto Obj = new DProducto();
Obj.setIdProducto(IdProducto);
Obj.setProducto(Producto);
Obj.setDescripcion(Descripcion);
Obj.setIdCategoria(IdCategoria);
Obj.setOpcion(Opcion);
return Obj.DSetProducto(Obj);
}


public DefaultTableModel NGetProducto(int IdProducto,String Producto,String Descripcion,String Categoria,String Opcion){
DProducto Obj = new DProducto();

Obj.setIdProducto(IdProducto);
Obj.setProducto(Producto);
Obj.setDescripcion(Descripcion);
Obj.setCategoria(Categoria);
Obj.setOpcion(Opcion);

 return Obj.DGetProducto(Obj);
}
}
