/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DUsuario;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Victor
 */
public class NUsuario {
    
    
    public String NSetUsuario(int DNI,String Nombre,String Apellidos,String Usuario,String Contrasena,String Opcion){

DUsuario Obj = new DUsuario();
Obj.setDNI(DNI);
Obj.setNombre(Nombre);
Obj.setApellidos(Apellidos);
Obj.setUsuario(Usuario);
Obj.setContrasena(Contrasena);
Obj.setOpcion(Opcion);
return Obj.DSetUsuario(Obj);
}


public DefaultTableModel NGetUsuario(int DNI,String Nombre,String Usuario,String Contrasena,String Opcion){
DUsuario Obj = new DUsuario();

Obj.setDNI(DNI);
Obj.setNombre(Nombre);
Obj.setUsuario(Usuario);
Obj.setContrasena(Contrasena);
Obj.setOpcion(Opcion);

 return Obj.DGetUsuario(Obj);
}
    
}
