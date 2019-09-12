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
public class DPeso {
    
    
    int IdPeso;
String TipoMovimiento;
String Guia;
String FechaGuia;
String FechaHoraSal;
String FechaHoraEnt;
int PesoCE;
int PesoCS;
int PesoGE;
int PesoGS;
String ObservE;
String ObservS;
String Estado;
int DNI;
int IdProveClien;
int IdDestino;
int IdProducto;
int IdConductorVehiculo;
String Opcion;

public DPeso(){}

    public DPeso(int IdPeso, String TipoMovimiento, String Guia, String FechaGuia, String FechaHoraSal, String FechaHoraEnt, int PesoCE, int PesoCS, int PesoGE, int PesoGS, String ObservE, String ObservS, String Estado, int DNI, int IdProveClien, int IdDestino, int IdProducto, int IdConductorVehiculo, String Opcion) {
        this.IdPeso = IdPeso;
        this.TipoMovimiento = TipoMovimiento;
        this.Guia = Guia;
        this.FechaGuia = FechaGuia;
        this.FechaHoraSal = FechaHoraSal;
        this.FechaHoraEnt = FechaHoraEnt;
        this.PesoCE = PesoCE;
        this.PesoCS = PesoCS;
        this.PesoGE = PesoGE;
        this.PesoGS = PesoGS;
        this.ObservE = ObservE;
        this.ObservS = ObservS;
        this.Estado = Estado;
        this.DNI = DNI;
        this.IdProveClien = IdProveClien;
        this.IdDestino = IdDestino;
        this.IdProducto = IdProducto;
        this.IdConductorVehiculo = IdConductorVehiculo;
        this.Opcion = Opcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }




public int getIdPeso(){
return IdPeso;
}

public String getTipoMovimiento(){
return TipoMovimiento;
}

public String getGuia(){
return Guia;
}

public String getFechaGuia(){
return FechaGuia;
}

public String getFechaHoraSal(){
return FechaHoraSal;
}

public String getFechaHoraEnt(){
return FechaHoraEnt;
}

public int getPesoCE(){
return PesoCE;
}

public int getPesoCS(){
return PesoCS;
}

public int getPesoGE(){
return PesoGE;
}

public int getPesoGS(){
return PesoGS;
}

public String getObservE(){
return ObservE;
}

public String getObservS(){
return ObservS;
}

public int getDNI(){
return DNI;
}

public int getIdProveClien(){
return IdProveClien;
}

public int getIdDestino(){
return IdDestino;
}

public int getIdProducto(){
return IdProducto;
}

public int getIdConductorVehiculo(){
return IdConductorVehiculo;
}

public String getOpcion(){
return Opcion;
}


public void setIdPeso(int IdPeso) {
this.IdPeso=IdPeso;
}
public void setTipoMovimiento(String TipoMovimiento) {
this.TipoMovimiento=TipoMovimiento;
}
public void setGuia(String Guia) {
this.Guia=Guia;
}
public void setFechaGuia(String FechaGuia) {
this.FechaGuia=FechaGuia;
}
public void setFechaHoraSal(String FechaHoraSal) {
this.FechaHoraSal=FechaHoraSal;
}
public void setFechaHoraEnt(String FechaHoraEnt) {
this.FechaHoraEnt=FechaHoraEnt;
}
public void setPesoCE(int PesoCE) {
this.PesoCE=PesoCE;
}
public void setPesoCS(int PesoCS) {
this.PesoCS=PesoCS;
}
public void setPesoGE(int PesoGE) {
this.PesoGE=PesoGE;
}
public void setPesoGS(int PesoGS) {
this.PesoGS=PesoGS;
}
public void setObservE(String ObservE) {
this.ObservE=ObservE;
}
public void setObservS(String ObservS) {
this.ObservS=ObservS;
}
public void setDNI(int DNI) {
this.DNI=DNI;
}
public void setIdProveClien(int IdProveClien) {
this.IdProveClien=IdProveClien;
}
public void setIdDestino(int IdDestino) {
this.IdDestino=IdDestino;
}
public void setIdProducto(int IdProducto) {
this.IdProducto=IdProducto;
}
public void setIdConductorVehiculo(int IdConductorVehiculo) {
this.IdConductorVehiculo=IdConductorVehiculo;
}
public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetPeso(DPeso Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetPeso(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
Proc.setInt(1, Campo.getIdPeso());
Proc.setString(2, Campo.getTipoMovimiento());
Proc.setString(3, Campo.getGuia());
Proc.setString(4, Campo.getFechaGuia());
Proc.setString(5, Campo.getFechaHoraSal());
Proc.setString(6, Campo.getFechaHoraEnt());
Proc.setInt(7, Campo.getPesoCE());
Proc.setInt(8, Campo.getPesoCS());
Proc.setInt(9, Campo.getPesoGE());
Proc.setInt(10, Campo.getPesoGS());
Proc.setString(11, Campo.getObservE());
Proc.setString(12, Campo.getObservS());
Proc.setString(13, Campo.getEstado());
Proc.setInt(14, Campo.getDNI());
Proc.setInt(15, Campo.getIdProveClien());
Proc.setInt(16, Campo.getIdDestino());
Proc.setInt(17, Campo.getIdProducto());
Proc.setInt(18, Campo.getIdConductorVehiculo());
Proc.setString(19, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetPeso(DPeso Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID PESO","TIPO MOVIMIENTO","GUIA","FECHA GUIA","FECHA SALIDA","FECHA ENTRADA","PE. CAL. ENT","PE. CAL. SAL","PE. GUIA. ENT","PE. GUIA. SAL","OBSER ENT","OBSER SAL","DNI","IDPROVEEDORCLIEN","IDDESTINO","DESTINO","ID PRODUCTO","PRODUCTO","ID CONDUCTOR VEHICULO"};
        String[] registro = new String[19];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetPeso(?,?,?)");
Proc.setInt(1, Campo.getIdPeso());
Proc.setInt(2, Campo.getIdProducto());
Proc.setString(3, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
registro[3] = rs.getString(4);
registro[4] = rs.getString(5);
registro[5] = rs.getString(6);
registro[6] = rs.getString(7);
registro[7] = rs.getString(8);
registro[8] = rs.getString(9);
registro[9] = rs.getString(10);
registro[10] = rs.getString(11);
registro[11] = rs.getString(12);
registro[12] = rs.getString(13);
registro[13] = rs.getString(14);
registro[14] = rs.getString(15);
registro[15] = rs.getString(16);
registro[16] = rs.getString(17);
registro[17] = rs.getString(18);
registro[18] = rs.getString(19);
registro[19] = rs.getString(19);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
    

    
    
    
}
