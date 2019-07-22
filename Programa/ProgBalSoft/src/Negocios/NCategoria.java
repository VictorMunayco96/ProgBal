/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DCategoria;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class NCategoria {
    public String NSetCategoria(int IdCategoria,String Categoria,String Opcion){

DCategoria Obj = new DCategoria();


Obj.setIdCategoria(IdCategoria);
Obj.setCategoria(Categoria);
Obj.setOpcion(Opcion);
return Obj.DSetCategoria(Obj);
}


public DefaultTableModel NGetCategoria(int IdCategoria,String Categoria, String Opcion){
DCategoria Obj = new DCategoria();

Obj.setIdCategoria(IdCategoria);
Obj.setCategoria(Categoria);
Obj.setOpcion(Opcion);

 return Obj.DGetCategoria(Obj);
}
}
