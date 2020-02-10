/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

/**
 *
 * @author Victor
 */

import Datos.DConductor;
import javax.swing.table.DefaultTableModel;
public class NConductor {
    
    public String NSetConductor(int IdConductor,String NumDoc,String Nombre,String Apellidos,String Opcion){

DConductor Obj = new DConductor();
Obj.setIdConductor(IdConductor);
Obj.setNumDoc(NumDoc);
Obj.setNombre(Nombre);
Obj.setApellidos(Apellidos);
Obj.setOpcion(Opcion);
return Obj.DSetConductor(Obj);
}


public DefaultTableModel NGetConductor(int IdConductor,String NumDoc,String Nombre,String Opcion){
DConductor Obj = new DConductor();

Obj.setIdConductor(IdConductor);
Obj.setNumDoc(NumDoc);
Obj.setNombre(Nombre);
Obj.setOpcion(Opcion);

 return Obj.DGetConductor(Obj);
}
    
}
