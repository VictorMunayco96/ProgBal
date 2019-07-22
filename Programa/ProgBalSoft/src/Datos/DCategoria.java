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
public class DCategoria {

    int IdCategoria;
    String Categoria;
    String Opcion;

    public DCategoria() {
    }

    public DCategoria(int IdCategoria, String Categoria, String Opcion) {
        this.IdCategoria = IdCategoria;
        this.Categoria = Categoria;
        this.Opcion = Opcion;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }

   

    public int getIdCategoria() {
        return IdCategoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String DSetCategoria(DCategoria Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
        try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetCategoria(?,?,?)");
            Proc.setInt(1, Campo.getIdCategoria());
            Proc.setString(2, Campo.getCategoria());
            Proc.setString(3, Campo.getOpcion());
            Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }

    public DefaultTableModel DGetCategoria(DCategoria Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        DefaultTableModel modelo = null;
        String[] titulos = {"IDCATEGORIA", "CATEGORIA"};
        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetCategoria(?,?,?)");
            Proc.setInt(1, Campo.getIdCategoria());
            Proc.setString(2,Campo.getCategoria());
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
