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

/**
 *
 * @author Victor
 */
public class DConductor {
    int IdConductor;
String NumDoc;
String Nombre;
String Apellidos;
String Opcion;

public DConductor(){}

public DConductor(int IdConductor,String NumDoc,String Nombre,String Apellidos,String Opcion){
this.IdConductor = IdConductor;
this.NumDoc = NumDoc;
this.Nombre = Nombre;
this.Apellidos = Apellidos;
this.Opcion = Opcion;
}
public int getIdConductor(){
return IdConductor;
}

public String getNumDoc(){
return NumDoc;
}

public String getNombre(){
return Nombre;
}

public String getApellidos(){
return Apellidos;
}

public String getOpcion(){
return Opcion;
}


public void setIdConductor(int IdConductor) {
this.IdConductor=IdConductor;
}
public void setNumDoc(String NumDoc) {
this.NumDoc=NumDoc;
}
public void setNombre(String Nombre) {
this.Nombre=Nombre;
}
public void setApellidos(String Apellidos) {
this.Apellidos=Apellidos;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetConductor(DConductor Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetConductor(?,?,?,?,?)");
Proc.setInt(1, Campo.getIdConductor());
Proc.setString(2, Campo.getNumDoc());
Proc.setString(3, Campo.getNombre());
Proc.setString(4, Campo.getApellidos());
Proc.setString(5, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetConductor(DConductor Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID","N° DOC","NOMBRE","APELLIDOS"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetConductor(?,?,?,?)");
Proc.setInt(1, Campo.getIdConductor());
Proc.setString(2, Campo.getNumDoc());
Proc.setString(3, Campo.getNombre());
Proc.setString(4, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
registro[3] = rs.getString(4);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
}
