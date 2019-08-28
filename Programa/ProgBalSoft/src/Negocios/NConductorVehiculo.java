/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DConductorVehiculo;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Victor
 */
public class NConductorVehiculo {
    
    
    public String NSetConductorVehiculo(int IdConductorVehiculo,String Fecha,int IdConductor,String Placa,String Opcion){

DConductorVehiculo Obj = new DConductorVehiculo();
Obj.setIdConductorVehiculo(IdConductorVehiculo);
Obj.setFecha(Fecha);
Obj.setIdConductor(IdConductor);
Obj.setPlaca(Placa);
Obj.setOpcion(Opcion);
return Obj.DSetConductorVehiculo(Obj);
}


public DefaultTableModel NGetConductorVehiculo(String Fecha,int IdConductor,String Placa,String Opcion){
DConductorVehiculo Obj = new DConductorVehiculo();

Obj.setFecha(Fecha);
Obj.setIdConductor(IdConductor);
Obj.setPlaca(Placa);
Obj.setOpcion(Opcion);

 return Obj.DGetConductorVehiculo(Obj);
 
 
}
}
