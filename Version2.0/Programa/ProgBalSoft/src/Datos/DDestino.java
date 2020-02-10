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
public class DDestino {
    int IdDestino;
String Destino;
String Opcion;

public DDestino(){}

public DDestino(int IdDestino,String Destino,String Opcion){
this.IdDestino = IdDestino;
this.Destino = Destino;
this.Opcion = Opcion;
}
public int getIdDestino(){
return IdDestino;
}

public String getDestino(){
return Destino;
}

public String getOpcion(){
return Opcion;
}


public void setIdDestino(int IdDestino) {
this.IdDestino=IdDestino;
}
public void setDestino(String Destino) {
this.Destino=Destino;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetDestino(DDestino Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetDestino(?,?,?)");
Proc.setInt(1, Campo.getIdDestino());
Proc.setString(2, Campo.getDestino());
Proc.setString(3, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetDestino(DDestino Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"IdDestino","Destino"};
        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetDestino(?,?,?)");
Proc.setInt(1, Campo.getIdDestino());
Proc.setString(2, Campo.getDestino());
Proc.setString(3, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }
}
}
