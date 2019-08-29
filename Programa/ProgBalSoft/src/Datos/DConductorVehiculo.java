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
public class DConductorVehiculo {

int IdConductorVehiculo;
String Fecha;
int IdConductor;
String Placa;
String Opcion;

public DConductorVehiculo(){}

public DConductorVehiculo(int IdConductorVehiculo,String Fecha,int IdConductor,String Placa,String Opcion){
this.IdConductorVehiculo = IdConductorVehiculo;
this.Fecha = Fecha;
this.IdConductor = IdConductor;
this.Placa = Placa;
this.Opcion = Opcion;
}
public int getIdConductorVehiculo(){
return IdConductorVehiculo;
}

public String getFecha(){
return Fecha;
}

public int getIdConductor(){
return IdConductor;
}

public String getPlaca(){
return Placa;
}

public String getOpcion(){
return Opcion;
}


public void setIdConductorVehiculo(int IdConductorVehiculo) {
this.IdConductorVehiculo=IdConductorVehiculo;
}
public void setFecha(String Fecha) {
this.Fecha=Fecha;
}
public void setIdConductor(int IdConductor) {
this.IdConductor=IdConductor;
}
public void setPlaca(String Placa) {
this.Placa=Placa;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetConductorVehiculo(DConductorVehiculo Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetConductorVehiculo(?,?,?,?,?)");
Proc.setInt(1, Campo.getIdConductorVehiculo());
Proc.setString(2, Campo.getFecha());
Proc.setInt(3, Campo.getIdConductor());
Proc.setString(4, Campo.getPlaca());
Proc.setString(5, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetConductorVehiculo(DConductorVehiculo Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID","FECHA","ID CONDUCTOR","NOM Y APE","PLACA"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetConductorVehiculo(?,?,?,?)");
Proc.setString(1, Campo.getFecha());
Proc.setInt(2, Campo.getIdConductor());
Proc.setString(3, Campo.getPlaca());
Proc.setString(4, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
registro[3] = rs.getString(4)+" "+rs.getString(5);
registro[4] = rs.getString(6);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    


}   

