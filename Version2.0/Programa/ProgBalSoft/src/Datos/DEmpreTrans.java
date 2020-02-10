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
public class DEmpreTrans {

long RUC;
String RazonSocial;
String Domicilio;
String NumCel;
String Opcion;

public DEmpreTrans(){}

public DEmpreTrans(long RUC,String RazonSocial,String Domicilio,String NumCel,String Opcion){
this.RUC = RUC;
this.RazonSocial = RazonSocial;
this.Domicilio = Domicilio;
this.NumCel = NumCel;
this.Opcion = Opcion;
}
public long getRUC(){
return RUC;
}

public String getRazonSocial(){
return RazonSocial;
}

public String getDomicilio(){
return Domicilio;
}

public String getNumCel(){
return NumCel;
}

public String getOpcion(){
return Opcion;
}


public void setRUC(long RUC) {
this.RUC=RUC;
}
public void setRazonSocial(String RazonSocial) {
this.RazonSocial=RazonSocial;
}
public void setDomicilio(String Domicilio) {
this.Domicilio=Domicilio;
}
public void setNumCel(String NumCel) {
this.NumCel=NumCel;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetEmpreTrans(DEmpreTrans Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetEmpreTrans(?,?,?,?,?)");
Proc.setLong(1, Campo.getRUC());
Proc.setString(2, Campo.getRazonSocial());
Proc.setString(3, Campo.getDomicilio());
Proc.setString(4, Campo.getNumCel());
Proc.setString(5, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetEmpreTrans(DEmpreTrans Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"RUC","RAZON SOCIAL","DOMICILIO","CELULAR"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetEmpreTrans(?,?,?)");
Proc.setLong(1, Campo.getRUC());
Proc.setString(2, Campo.getRazonSocial());
Proc.setString(3, Campo.getOpcion());
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

