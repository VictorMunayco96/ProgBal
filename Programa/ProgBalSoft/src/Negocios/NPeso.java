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
    
public String NSetPeso(int IdPeso,String TipoMovimiento,String Guia,String FechaGuia,String FechaHoraSal,String FechaHoraEnt,int PesoCE,int PesoCS,int PesoGE,int PesoGS,String ObservE,String ObservS,String Estado,int DNI,int IdProveClien,int IdDestino,int IdProducto,int IdConductorVehiculo,String Opcion){

DPeso Obj = new DPeso();
Obj.setIdPeso(IdPeso);
Obj.setTipoMovimiento(TipoMovimiento);
Obj.setGuia(Guia);
Obj.setFechaGuia(FechaGuia);
Obj.setFechaHoraSal(FechaHoraSal);
Obj.setFechaHoraEnt(FechaHoraEnt);
Obj.setPesoCE(PesoCE);
Obj.setPesoCS(PesoCS);
Obj.setPesoGE(PesoGE);
Obj.setPesoGS(PesoGS);
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


public DefaultTableModel NGetPeso(int IdPeso,int IdProducto,String Opcion){
DPeso Obj = new DPeso();

Obj.setIdPeso(IdPeso);
Obj.setIdProducto(IdProducto);
Obj.setOpcion(Opcion);

 return Obj.DGetPeso(Obj);
}
 
}
