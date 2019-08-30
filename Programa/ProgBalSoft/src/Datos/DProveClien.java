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
 * @author Administrador
 */
public class DProveClien {
    
int IdProveClien;
String RazonSocial;
int Ruc;
String Opcion;

public DProveClien(){}

public DProveClien(int IdProveClien,String RazonSocial,int Ruc,String Opcion){
this.IdProveClien = IdProveClien;
this.RazonSocial = RazonSocial;
this.Ruc = Ruc;
this.Opcion = Opcion;
}
public int getIdProveClien(){
return IdProveClien;
}

public String getRazonSocial(){
return RazonSocial;
}

public int getRuc(){
return Ruc;
}

public String getOpcion(){
return Opcion;
}


public void setIdProveClien(int IdProveClien) {
this.IdProveClien=IdProveClien;
}
public void setRazonSocial(String RazonSocial) {
this.RazonSocial=RazonSocial;
}
public void setRuc(int Ruc) {
this.Ruc=Ruc;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetProveClien(DProveClien Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetProveClien(?,?,?,?)");
Proc.setInt(1, Campo.getIdProveClien());
Proc.setString(2, Campo.getRazonSocial());
Proc.setInt(3, Campo.getRuc());
Proc.setString(4, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetProveClien(DProveClien Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID","RAZON SOCIAL","RUC"};
        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetProveClien(?,?,?,?)");
Proc.setInt(1, Campo.getIdProveClien());
Proc.setString(2, Campo.getRazonSocial());
Proc.setInt(3, Campo.getRuc());
Proc.setString(4, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
    


}
