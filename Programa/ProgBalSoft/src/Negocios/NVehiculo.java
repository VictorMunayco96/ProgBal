/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DVehiculo;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class NVehiculo {
    public String NSetVehiculo(String Placa,String Marca,int Ruc,String Opcion){

DVehiculo Obj = new DVehiculo();
Obj.setPlaca(Placa);
Obj.setMarca(Marca);
Obj.setRuc(Ruc);
Obj.setOpcion(Opcion);
return Obj.DSetVehiculo(Obj);
}


public DefaultTableModel NGetVehiculo(String Placa,int Ruc,String RazonSocial,String Opcion){
DVehiculo Obj = new DVehiculo();

Obj.setPlaca(Placa);
Obj.setRuc(Ruc);
Obj.setRazonSocial(RazonSocial);
Obj.setOpcion(Opcion);

 return Obj.DGetVehiculo(Obj);
}
 
}
