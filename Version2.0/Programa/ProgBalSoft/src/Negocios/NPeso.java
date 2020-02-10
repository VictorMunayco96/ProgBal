/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DPeso;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Victor
 */
public class NPeso {
    

public String NSetPeso(int IdPeso,String TipoMovimiento,long NumGuia,String FechaHoraSal,String FechaHoraEnt,int PesoCE,int PesoCS,int NetoC,String ObservE,String ObservS,String Estado,int DNI,int IdProveClien,int IdDestino,int IdProducto,int IdConductorVehiculo,String Opcion){

DPeso Obj = new DPeso();
Obj.setIdPeso(IdPeso);
Obj.setTipoMovimiento(TipoMovimiento);
Obj.setNumGuia(NumGuia);
Obj.setFechaHoraSal(FechaHoraSal);
Obj.setFechaHoraEnt(FechaHoraEnt);
Obj.setPesoCE(PesoCE);
Obj.setPesoCS(PesoCS);
Obj.setNetoC(NetoC);
Obj.setObservE(ObservE);
Obj.setObservS(ObservS);
Obj.setEstado(Estado);
Obj.setDNI(DNI);
Obj.setIdProveClien(IdProveClien);
Obj.setIdDestino(IdDestino);
Obj.setIdProducto(IdProducto);
Obj.setIdConductorVehiculo(IdConductorVehiculo);
Obj.setOpcion(Opcion);
return Obj.DSetPeso(Obj);
}


public DefaultTableModel NGetPeso(int IdPeso,long NumGuia,String Estado,String RazonSocial,String Destino,String Descripcion,String Opcion,String FechaIni, String FechaFin){
DPeso Obj = new DPeso();

Obj.setIdPeso(IdPeso);
Obj.setNumGuia(NumGuia);
Obj.setEstado(Estado);
Obj.setRazonSocial(RazonSocial);
Obj.setDestino(Destino);
Obj.setDescripcion(Descripcion);
Obj.setOpcion(Opcion);
Obj.setFechaIni(FechaIni);
Obj.setFechaFin(FechaFin);

 return Obj.DGetPeso(Obj);
}
}
