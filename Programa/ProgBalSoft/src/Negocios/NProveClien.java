/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DProveClien;
import javax.swing.table.DefaultTableModel;
public class NProveClien {
 
    
    public String NSetProveClien(int IdProveClien,String RazonSocial,int Ruc,String Opcion){

DProveClien Obj = new DProveClien();
Obj.setIdProveClien(IdProveClien);
Obj.setRazonSocial(RazonSocial);
Obj.setRuc(Ruc);
Obj.setOpcion(Opcion);
return Obj.DSetProveClien(Obj);
}


public DefaultTableModel NGetProveClien(int IdProveClien,String RazonSocial,int Ruc,String Opcion){
DProveClien Obj = new DProveClien();

Obj.setIdProveClien(IdProveClien);
Obj.setRazonSocial(RazonSocial);
Obj.setRuc(Ruc);
Obj.setOpcion(Opcion);

 return Obj.DGetProveClien(Obj);
}
    
}
