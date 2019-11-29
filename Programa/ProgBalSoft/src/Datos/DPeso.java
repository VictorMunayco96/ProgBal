/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import Presentacion.PPesosConsul;
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
long NumGuia;
String FechaHoraSal;
String FechaHoraEnt;
int PesoCE;
int PesoCS;
int NetoC;
String ObservE;
String ObservS;
String Estado;
int DNI;
int IdProveClien;
String RazonSocial;
       

int IdDestino;
String Destino;
int IdProducto;
String Descripcion;
int IdConductorVehiculo;
String Placa;
String Opcion;
String FechaIni;
String FechaFin;

public DPeso(){}

    public DPeso(int IdPeso, String TipoMovimiento, long NumGuia, String FechaHoraSal, String FechaHoraEnt, int PesoCE, int PesoCS, int NetoC, String ObservE, String ObservS, String Estado, int DNI, int IdProveClien, String RazonSocial, int IdDestino, String Destino, int IdProducto, String Descripcion, int IdConductorVehiculo, String Placa, String Opcion, String FechaIni, String FechaFin) {
        this.IdPeso = IdPeso;
        this.TipoMovimiento = TipoMovimiento;
        this.NumGuia = NumGuia;
        this.FechaHoraSal = FechaHoraSal;
        this.FechaHoraEnt = FechaHoraEnt;
        this.PesoCE = PesoCE;
        this.PesoCS = PesoCS;
        this.NetoC = NetoC;
        this.ObservE = ObservE;
        this.ObservS = ObservS;
        this.Estado = Estado;
        this.DNI = DNI;
        this.IdProveClien = IdProveClien;
        this.RazonSocial = RazonSocial;
        this.IdDestino = IdDestino;
        this.Destino = Destino;
        this.IdProducto = IdProducto;
        this.Descripcion = Descripcion;
        this.IdConductorVehiculo = IdConductorVehiculo;
        this.Placa = Placa;
        this.Opcion = Opcion;
        this.FechaIni = FechaIni;
        this.FechaFin = FechaFin;
    }

    public String getFechaIni() {
        return FechaIni;
    }

    public void setFechaIni(String FechaIni) {
        this.FechaIni = FechaIni;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }


    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }

 

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }


public int getIdPeso(){
return IdPeso;
}

public String getTipoMovimiento(){
return TipoMovimiento;
}

public long getNumGuia(){
return NumGuia;
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

public int getNetoC(){
return NetoC;
}

public String getObservE(){
return ObservE;
}

public String getObservS(){
return ObservS;
}

public String getEstado(){
return Estado;
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


public void setIdPeso(int IdPeso) {
this.IdPeso=IdPeso;
}
public void setTipoMovimiento(String TipoMovimiento) {
this.TipoMovimiento=TipoMovimiento;
}
public void setNumGuia(long NumGuia) {
this.NumGuia=NumGuia;
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
public void setNetoC(int NetoC) {
this.NetoC=NetoC;
}
public void setObservE(String ObservE) {
this.ObservE=ObservE;
}
public void setObservS(String ObservS) {
this.ObservS=ObservS;
}
public void setEstado(String Estado) {
this.Estado=Estado;
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

public String DSetPeso(DPeso Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetPeso(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
Proc.setInt(1, Campo.getIdPeso());
Proc.setString(2, Campo.getTipoMovimiento());
Proc.setLong(3, Campo.getNumGuia());
Proc.setString(4, Campo.getFechaHoraSal());
Proc.setString(5, Campo.getFechaHoraEnt());
Proc.setInt(6, Campo.getPesoCE());
Proc.setInt(7, Campo.getPesoCS());
Proc.setInt(8, Campo.getNetoC());
Proc.setString(9, Campo.getObservE());
Proc.setString(10, Campo.getObservS());
Proc.setString(11, Campo.getEstado());
Proc.setInt(12, Campo.getDNI());
Proc.setInt(13, Campo.getIdProveClien());
Proc.setInt(14, Campo.getIdDestino());
Proc.setInt(15, Campo.getIdProducto());
Proc.setInt(16, Campo.getIdConductorVehiculo());
Proc.setString(17, Campo.getOpcion());
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
        int Cont=0;
        long PesoAcu=0;
       DefaultTableModel modelo = null ;
String[] titulos = {"ID PESO",
    "TIPO MOVIMIENTO",
    "N° GUIA",
    "FECHA HORA SALIDA",
    "FECHA HORA ENTRADA",
    "PESO ENTRADA",
    "PESO SALIDA",
    "NETO",
    "OBSERV ENTRADA",
    "OBSERV SALIDA",
    "ESTADO",
    "DNI",
    "IDPROVECLIEN",
    "RAZON SOCIAL",
    "IDCONDUCTORVEHICULO",
    "PLACA",
    "NOMBRE",
    "APELLIDOS",
    "IDDESTINO",
    "DESTINO",
    "IDPRODUCTO",
    "TIPO ALIMENTO"};
        String[] registro = new String[22];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetPeso(?,?,?,?,?,?,?,?,?)");
Proc.setInt(1, Campo.getIdPeso());
Proc.setLong(2, Campo.getNumGuia());
Proc.setString(3, Campo.getEstado());
Proc.setString(4, Campo.getRazonSocial());
Proc.setString(5, Campo.getDestino());
Proc.setString(6, Campo.getDescripcion());
Proc.setString(7, Campo.getOpcion());
Proc.setString(8, Campo.getFechaIni()); //VARIABLE CREADA PARA FACILITAR LA BUSQUEDA
Proc.setString(9, Campo.getFechaFin());  //VARIABLE CREADA PARA FACILITAR LA BUSQUEDA
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
registro[19] = rs.getString(20);
registro[20] = rs.getString(21);
registro[21] = rs.getString(22);

modelo.addRow(registro);
Cont++;
PesoAcu=PesoAcu+Long.parseLong(registro[7]);
            }
            PPesosConsul.TxtNumRegistros.setText(String.valueOf(Cont));
            PPesosConsul.TxtPesoAcumulado.setText(String.valueOf(PesoAcu));
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }}
   
    
    

    
    
    
}
