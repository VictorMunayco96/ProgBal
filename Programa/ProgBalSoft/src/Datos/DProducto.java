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

public class DProducto {
    
    
int IdProducto;
String Producto;
String Descripcion;
int IdCategoria;
String Categoria;

 
String Opcion;

public DProducto(){}

    public DProducto(int IdProducto, String Producto, String Descripcion, int IdCategoria, String Categoria, String Opcion) {
        this.IdProducto = IdProducto;
        this.Producto = Producto;
        this.Descripcion = Descripcion;
        this.IdCategoria = IdCategoria;
        this.Categoria = Categoria;
        this.Opcion = Opcion;
    }


public int getIdProducto(){
return IdProducto;
}

public String getProducto(){
return Producto;
}

public String getDescripcion(){
return Descripcion;
}

public int getIdCategoria(){
return IdCategoria;
}

public String getOpcion(){
return Opcion;
}


public void setIdProducto(int IdProducto) {
this.IdProducto=IdProducto;
}
public void setProducto(String Producto) {
this.Producto=Producto;
}
public void setDescripcion(String Descripcion) {
this.Descripcion=Descripcion;
}
public void setIdCategoria(int IdCategoria) {
this.IdCategoria=IdCategoria;
}

   public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

public void setOpcion(String Opcion) {
this.Opcion=Opcion;
}

public String DSetProducto(DProducto Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetProducto(?,?,?,?,?)");
Proc.setInt(1, Campo.getIdProducto());
Proc.setString(2, Campo.getProducto());
Proc.setString(3, Campo.getDescripcion());
Proc.setInt(4, Campo.getIdCategoria());
Proc.setString(5, Campo.getOpcion());
 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }
public DefaultTableModel DGetProducto(DProducto Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID","Producto","Descripcion","IdCategoria","Categoria"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetProducto(?,?,?,?,?)");
Proc.setInt(1, Campo.getIdProducto());
Proc.setString(2, Campo.getProducto());
Proc.setString(3, Campo.getDescripcion());
Proc.setString(4, Campo.getCategoria());
Proc.setString(5, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
registro[3] = rs.getString(4);
registro[4] = rs.getString(5);

modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
    


    
    
}
