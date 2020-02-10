/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DEmpreTrans;
import javax.swing.table.DefaultTableModel;

public class NEmpreTrans {
    
 public String NSetEmpreTrans(long RUC,String RazonSocial,String Domicilio,String NumCel,String Opcion){

DEmpreTrans Obj = new DEmpreTrans();
Obj.setRUC(RUC);
Obj.setRazonSocial(RazonSocial);
Obj.setDomicilio(Domicilio);
Obj.setNumCel(NumCel);
Obj.setOpcion(Opcion);
return Obj.DSetEmpreTrans(Obj);
}


public DefaultTableModel NGetEmpreTrans(long RUC,String RazonSocial,String Opcion){
DEmpreTrans Obj = new DEmpreTrans();

Obj.setRUC(RUC);
Obj.setRazonSocial(RazonSocial);
Obj.setOpcion(Opcion);

 return Obj.DGetEmpreTrans(Obj);
}
    
}
