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
public class DVehiculo {
   
    
    
String Placa;
String Marca;
long Ruc;
String RazonSocial;
String Opcion;

public DVehiculo(){}

    public DVehiculo(String Placa, String Marca, long Ruc, String RazonSocial, String Opcion) {
        this.Placa = Placa;
        this.Marca = Marca;
        this.Ruc = Ruc;
        this.RazonSocial = RazonSocial;
        this.Opcion = Opcion;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }


public String getPlaca(){
return Placa;
}

public String getMarca(){
return Marca;
}

public long getRuc(){
return Ruc;
}

public String getOpcion(){
return Opcion;
}


public void setPlaca(String Placa) {
this.Placa=Placa;
}
public void setMarca(String Marca) {
this.Marca=Marca;
}
public void setRuc(long Ruc) {
this.Ruc=Ruc;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetVehiculo(DVehiculo Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetVehiculo(?,?,?,?)");
Proc.setString(1, Campo.getPlaca());
Proc.setString(2, Campo.getMarca());
Proc.setLong(3, Campo.getRuc());
Proc.setString(4, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetVehiculo(DVehiculo Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"PLACA","MARCA","RUC","RAZON SOCIAL"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetVehiculo(?,?,?,?)");
Proc.setString(1, Campo.getPlaca());
Proc.setLong(2, Campo.getRuc());
Proc.setString(3, Campo.getRazonSocial());
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
