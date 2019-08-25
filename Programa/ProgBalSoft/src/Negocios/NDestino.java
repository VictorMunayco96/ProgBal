/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DDestino;
import javax.swing.table.DefaultTableModel;

public class NDestino {
    public String NSetDestino(int IdDestino,String Destino,String Opcion){

DDestino Obj = new DDestino();
Obj.setIdDestino(IdDestino);
Obj.setDestino(Destino);
Obj.setOpcion(Opcion);
return Obj.DSetDestino(Obj);
}


public DefaultTableModel NGetDestino(int IdDestino,String Destino,String Opcion){
DDestino Obj = new DDestino();

Obj.setIdDestino(IdDestino);
Obj.setDestino(Destino);
Obj.setOpcion(Opcion);

 return Obj.DGetDestino(Obj);
}
}
