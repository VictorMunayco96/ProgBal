/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class DUsuario {
    
    
    
int DNI;
String Nombre;
String Apellidos;
String Usuario;
String Contrasena;
String Opcion;

public DUsuario(){}

public DUsuario(int DNI,String Nombre,String Apellidos,String Usuario,String Contrasena,String Opcion){
this.DNI = DNI;
this.Nombre = Nombre;
this.Apellidos = Apellidos;
this.Usuario = Usuario;
this.Contrasena = Contrasena;
this.Opcion = Opcion;
}
public int getDNI(){
return DNI;
}

public String getNombre(){
return Nombre;
}

public String getApellidos(){
return Apellidos;
}

public String getUsuario(){
return Usuario;
}

public String getContrasena(){
return Contrasena;
}

public String getOpcion(){
return Opcion;
}


public void setDNI(int DNI) {
this.DNI=DNI;
}
public void setNombre(String Nombre) {
this.Nombre=Nombre;
}
public void setApellidos(String Apellidos) {
this.Apellidos=Apellidos;
}
public void setUsuario(String Usuario) {
this.Usuario=Usuario;
}
public void setContrasena(String Contrasena) {
this.Contrasena=Contrasena;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetUsuario(DUsuario Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetUsuario(?,?,?,?,?,?)");
Proc.setInt(1, Campo.getDNI());
Proc.setString(2, Campo.getNombre());
Proc.setString(3, Campo.getApellidos());
Proc.setString(4, Campo.getUsuario());
Proc.setString(5, Campo.getContrasena());
Proc.setString(6, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetUsuario(DUsuario Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"DNI","NOMBRE","APELLIDOS","USUARIO","CONTRASEÑA"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetUsuario(?,?,?,?,?)");
Proc.setInt(1, Campo.getDNI());
Proc.setString(2, Campo.getNombre());
Proc.setString(3, Campo.getUsuario());
Proc.setString(4, Campo.getContrasena());
Proc.setString(5, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
registro[3] = rs.getString(4);
registro[4] = rs.getString(5);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }
    
    
}

}
