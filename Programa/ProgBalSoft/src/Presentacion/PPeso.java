/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Library.DefaultValue;
import Negocios.NConductorVehiculo;
import Negocios.NDestino;
import Negocios.NProducto;
import Negocios.NProveClien;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class PPeso extends javax.swing.JFrame {

    /**
     * Creates new form PPeso
     */
    public PPeso() {
        initComponents();
        TxtIdPlaca.setVisible(false);

    }

    NConductorVehiculo NConductorVehiculo = new NConductorVehiculo();
    NProducto NProducto = new NProducto();
    NDestino NDestino = new NDestino();
     NProveClien NProveClien = new NProveClien();;

    String TipoMovimiento = "";
    String Estado = "T";

    public String Movimiento() {

        if (TxtIdProducto.getText().isEmpty()) {
            return TipoMovimiento = "CLIENTE";
        } else {
            return TipoMovimiento = "PROVEEDOR";
        }

    }

    public String Neto() {

        int P1 = Integer.parseInt(TxtPesoCE.getText());
        int P2 = Integer.parseInt(TxtPesoCS.getText());

        int Neto = P1 - P2;

        if (Neto < 0) {
            return String.valueOf(Neto * (-1));
        } else {
            return String.valueOf(Neto);
        }

    }

    SimpleDateFormat Form = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    Date Now = new Date();

    public void UbicacionPeso() {
        int peso = 0;
        if (Estado.equals("T")) {
            TxtPesoCE.setText(TxtPesoVarianza.getText());
            TipoMovimiento = Movimiento();
            TxtFechaHoraEnt.setText(Form.format(Now));
            VtnPeso.dispose();
        } else if (Estado.equals("D")) {
            TxtPesoCS.setText(TxtPesoVarianza.getText());

            TxtFechaHoraSal.setText(Form.format(Now));
            TxtPesoNeto.setText(Neto());
            VtnPeso.dispose();
        }

    }

    public void BusquedaPlaca() {

        try {
            PGetConductorVehiculo(DefaultValue.Text(TxtPlaca.getText()), "P");

            TxtChofer.setText(TblConductorVehiculo.getValueAt(0, 3).toString());
            TxtIdPlaca.setText(TblConductorVehiculo.getValueAt(0, 0).toString());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "NO HAY REGISTRO", "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void BusquedaIdProducto() {

        try {
            PGetProducto(DefaultValue.Text(TxtIdProducto.getText()), "I");

            TxtIdProducto.setText(TblProducto.getValueAt(0, 0).toString());
            TxtProducto.setText(TblProducto.getValueAt(0, 2).toString());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "NO HAY REGISTRO", "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void BusquedaIdDestino() {

        try {
            PGetDestino(DefaultValue.Text(TxtIdDestino.getText()), "ID");

            TxtIdDestino.setText(TblDestino.getValueAt(0, 0).toString());
            TxtDestino.setText(TblDestino.getValueAt(0, 1).toString());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "NO HAY REGISTRO", "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }

    }

    
     public void PGetProveClien(String TextBusqueda, String Accion) {

        try {

            TblProveClien.setModel(NProveClien.NGetProveClien(DefaultValue.Number(TextBusqueda),DefaultValue.Text(TextBusqueda),DefaultValue.Number(TextBusqueda),Accion));


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    } 
    
    
    public void PGetDestino(String TextBusqueda, String Accion) {

        try {

            TblDestino.setModel(NDestino.NGetDestino(DefaultValue.Number(TextBusqueda), DefaultValue.Text(TextBusqueda), Accion));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    public void PGetProducto(String TextBusqueda, String Accion) {

        try {

            TblProducto.setModel(NProducto.NGetProducto(DefaultValue.Number(TextBusqueda), DefaultValue.Text(TextBusqueda), DefaultValue.Text(TextBusqueda), DefaultValue.Text(TextBusqueda), Accion));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    public void PGetConductorVehiculo(String TextBusqueda, String Accion) {

        try {

            TblConductorVehiculo.setModel(NConductorVehiculo.NGetConductorVehiculo(DefaultValue.Text(TextBusqueda), DefaultValue.Number(TextBusqueda), DefaultValue.Text(TextBusqueda), Accion));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VtnConductorVehiculo = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblConductorVehiculo = new javax.swing.JTable();
        VtnProducto = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TxtBusquedaProducto = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblProducto = new javax.swing.JTable();
        CboBusquedaProducto = new javax.swing.JComboBox<>();
        jButton16 = new javax.swing.JButton();
        VtnDestino = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TxtBusquedaDestino = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblDestino = new javax.swing.JTable();
        CboBusquedaDestino = new javax.swing.JComboBox<>();
        jButton18 = new javax.swing.JButton();
        VtnPeso = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        TxtPesoVarianza = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        VtnProveClien = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        TxtBusquedaProveClien = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        TblProveClien = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        CboBusquedaProveClien = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtIdCategoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtPlaca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TxtChofer = new javax.swing.JTextField();
        TxtIdCategoria1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtFechaHoraSal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TxtFechaHoraEnt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TxtIdPlaca = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        TxtPesoCS = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        TxtIdProducto = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        TxtProducto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton12 = new javax.swing.JButton();
        TxtPesoNeto = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        TxtIdDestino = new javax.swing.JTextField();
        TxtDestino = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        TxtPesoCE = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        TxtIdCategoria15 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        TxtIdCategoria16 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        TxtIdCategoria17 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        TxtIdCategoria2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        TxtIdCategoria18 = new javax.swing.JTextField();
        TxtIdCategoria19 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtBusqueda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblCategoria = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        TblConductorVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TblConductorVehiculo);

        javax.swing.GroupLayout VtnConductorVehiculoLayout = new javax.swing.GroupLayout(VtnConductorVehiculo.getContentPane());
        VtnConductorVehiculo.getContentPane().setLayout(VtnConductorVehiculoLayout);
        VtnConductorVehiculoLayout.setHorizontalGroup(
            VtnConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VtnConductorVehiculoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );
        VtnConductorVehiculoLayout.setVerticalGroup(
            VtnConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VtnConductorVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(0, 153, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("    PRODUCTO");
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(255, 204, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel14.setText("  MANTENIMIENTO");
        jLabel14.setOpaque(true);

        TxtBusquedaProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusquedaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaProductoActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 153, 0));
        jButton15.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton15.setBorderPainted(false);
        jButton15.setFocusPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        TblProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblProducto.setRowHeight(35);
        TblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblProductoMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TblProducto);

        CboBusquedaProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        CboBusquedaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRODUCTO", "DESCRIPCION", "ID PRODUCTO", "CATEGORIA" }));

        jButton16.setBackground(new java.awt.Color(0, 153, 0));
        jButton16.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton16.setBorderPainted(false);
        jButton16.setFocusPainted(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(CboBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CboBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout VtnProductoLayout = new javax.swing.GroupLayout(VtnProducto.getContentPane());
        VtnProducto.getContentPane().setLayout(VtnProductoLayout);
        VtnProductoLayout.setHorizontalGroup(
            VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProductoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        VtnProductoLayout.setVerticalGroup(
            VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProductoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setBackground(new java.awt.Color(0, 153, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DESTINO");
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(255, 204, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel18.setText("  MANTENIMIENTO");
        jLabel18.setOpaque(true);

        TxtBusquedaDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusquedaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaDestinoActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(0, 153, 0));
        jButton17.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton17.setBorderPainted(false);
        jButton17.setFocusPainted(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        TblDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TblDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblDestino.setRowHeight(35);
        TblDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblDestinoMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TblDestino);

        CboBusquedaDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        CboBusquedaDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DESTINO", "ID DESTINO" }));

        jButton18.setBackground(new java.awt.Color(0, 153, 0));
        jButton18.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton18.setBorderPainted(false);
        jButton18.setFocusPainted(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CboBusquedaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtBusquedaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TxtBusquedaDestino, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CboBusquedaDestino, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout VtnDestinoLayout = new javax.swing.GroupLayout(VtnDestino.getContentPane());
        VtnDestino.getContentPane().setLayout(VtnDestinoLayout);
        VtnDestinoLayout.setHorizontalGroup(
            VtnDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        VtnDestinoLayout.setVerticalGroup(
            VtnDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 0));

        TxtPesoVarianza.setBackground(new java.awt.Color(0, 0, 0));
        TxtPesoVarianza.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        TxtPesoVarianza.setForeground(new java.awt.Color(255, 255, 255));
        TxtPesoVarianza.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPesoVarianza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPesoVarianzaActionPerformed(evt);
            }
        });
        TxtPesoVarianza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPesoVarianzaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPesoVarianzaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPesoVarianzaKeyTyped(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 204, 0));
        jButton21.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton21.setBorderPainted(false);
        jButton21.setFocusPainted(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(TxtPesoVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(TxtPesoVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout VtnPesoLayout = new javax.swing.GroupLayout(VtnPeso.getContentPane());
        VtnPeso.getContentPane().setLayout(VtnPesoLayout);
        VtnPesoLayout.setHorizontalGroup(
            VtnPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        VtnPesoLayout.setVerticalGroup(
            VtnPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setBackground(new java.awt.Color(0, 153, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("    PRODUCTO");
        jLabel19.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(255, 204, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel20.setText("  MANTENIMIENTO");
        jLabel20.setOpaque(true);

        TxtBusquedaProveClien.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusquedaProveClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaProveClienActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(0, 153, 0));
        jButton20.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton20.setBorderPainted(false);
        jButton20.setFocusPainted(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        TblProveClien.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TblProveClien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblProveClien.setRowHeight(35);
        TblProveClien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblProveClienMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(TblProveClien);

        jButton22.setBackground(new java.awt.Color(0, 153, 0));
        jButton22.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton22.setBorderPainted(false);
        jButton22.setFocusPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        CboBusquedaProveClien.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        CboBusquedaProveClien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RAZON SOCIAL", "RUC", " " }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(CboBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CboBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout VtnProveClienLayout = new javax.swing.GroupLayout(VtnProveClien.getContentPane());
        VtnProveClien.getContentPane().setLayout(VtnProveClienLayout);
        VtnProveClienLayout.setHorizontalGroup(
            VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProveClienLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        VtnProveClienLayout.setVerticalGroup(
            VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProveClienLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   CATEGORIA");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel2.setText("    MANTENIMIENTO");
        jLabel2.setOpaque(true);

        TxtIdCategoria.setEditable(false);
        TxtIdCategoria.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("PLACA");

        TxtPlaca.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPlacaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Guardar-32.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Nuevo.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Eliminar -32.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("REGISTROS");
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel8.setText("CHOFER");

        TxtChofer.setEditable(false);
        TxtChofer.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtChoferActionPerformed(evt);
            }
        });

        TxtIdCategoria1.setEditable(false);
        TxtIdCategoria1.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoria1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setText("N° GUIA");

        TxtFechaHoraSal.setEditable(false);
        TxtFechaHoraSal.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtFechaHoraSal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFechaHoraSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaHoraSalActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel15.setText("FECHA SALIDA");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel16.setText("FECHA ENTRADA");

        TxtFechaHoraEnt.setEditable(false);
        TxtFechaHoraEnt.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtFechaHoraEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFechaHoraEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaHoraEntActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel32.setText("PESO 1");

        TxtIdPlaca.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        TxtIdPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdPlacaActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel33.setText("PESO 2");

        TxtPesoCS.setEditable(false);
        TxtPesoCS.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        TxtPesoCS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPesoCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPesoCSActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel36.setText("OBSERVACION");

        jLabel37.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel37.setText("OBSERVACION");

        TxtIdProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdProductoActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel39.setText("PRODUCTO");

        TxtProducto.setEditable(false);
        TxtProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProductoActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 102, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Guardar-32.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setFocusPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        TxtPesoNeto.setEditable(false);
        TxtPesoNeto.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        TxtPesoNeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel34.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel34.setText("NETO");

        jButton13.setBackground(new java.awt.Color(0, 153, 0));
        jButton13.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setFocusPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel44.setText("DESTINO");

        TxtIdDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdDestinoActionPerformed(evt);
            }
        });

        TxtDestino.setEditable(false);
        TxtDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDestinoActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 153, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton14.setBorderPainted(false);
        jButton14.setFocusPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        TxtPesoCE.setEditable(false);
        TxtPesoCE.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        TxtPesoCE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPesoCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPesoCEActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(jEditorPane1);

        jScrollPane7.setViewportView(jEditorPane2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFechaHoraSal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtPesoCS, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFechaHoraEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtPesoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtIdPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TxtPesoNeto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(626, 626, 626)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TxtIdCategoria))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtChofer, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtIdCategoria1))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtIdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIdCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtIdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFechaHoraEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtIdPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPesoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtPesoCS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtFechaHoraSal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(TxtPesoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("MATENIMIENTO", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(0, 153, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("   CATEGORIA");
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(255, 204, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel11.setText("    MANTENIMIENTO");
        jLabel11.setOpaque(true);

        jButton7.setBackground(new java.awt.Color(0, 153, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        TxtIdCategoria15.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoria15ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel40.setText("PESO G2");

        TxtIdCategoria16.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoria16ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel41.setText("PESO G1");

        TxtIdCategoria17.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoria17ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel42.setText("FECHA GUIA");

        TxtIdCategoria2.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoria2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel12.setText("N° GUIA");

        jLabel43.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel43.setText("PROVEDOR");

        TxtIdCategoria18.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoria18ActionPerformed(evt);
            }
        });

        TxtIdCategoria19.setEditable(false);
        TxtIdCategoria19.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdCategoria19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCategoria19ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 153, 0));
        jButton19.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton19.setBorderPainted(false);
        jButton19.setFocusPainted(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(0, 153, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton23.setBorderPainted(false);
        jButton23.setFocusPainted(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtIdCategoria16, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtIdCategoria15, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtIdCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtIdCategoria17, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtIdCategoria18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtIdCategoria19, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(161, 170, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIdCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIdCategoria17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtIdCategoria18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIdCategoria19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19)))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIdCategoria15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIdCategoria16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DATOS GUIA", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(0, 153, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("   CATEGORIA");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 204, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel6.setText("  MANTENIMIENTO");
        jLabel6.setOpaque(true);

        TxtBusqueda.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel7.setText("ID");

        jButton8.setBackground(new java.awt.Color(0, 153, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setFocusPainted(false);

        TblCategoria.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblCategoria.setRowHeight(35);
        TblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblCategoriaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TblCategoria);

        jButton6.setBackground(new java.awt.Color(0, 153, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 386, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtIdCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoriaActionPerformed

    private void TxtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPlacaActionPerformed
        BusquedaPlaca();        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPlacaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//jPanel5.setVisible(true);
//        PSetCategoria();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        PNew();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        Accion = "D";
//        PSetCategoria();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TxtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBusquedaActionPerformed

    private void TblCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCategoriaMousePressed
//        try {
//            if (evt.getClickCount() == 2) {
//                Accion = "U";
//                int fila = TblCategoria.getSelectedRow();
//
//                TxtIdCategoria.setText(TblCategoria.getValueAt(fila, 0).toString());
//                TxtCategoria.setText(TblCategoria.getValueAt(fila, 1).toString());
//                jTabbedPane1.setSelectedIndex(0);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: "+e);
//
//        }
    }//GEN-LAST:event_TblCategoriaMousePressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void TxtChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtChoferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtChoferActionPerformed

    private void TxtIdCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoria1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void TxtFechaHoraSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaHoraSalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaHoraSalActionPerformed

    private void TxtFechaHoraEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaHoraEntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaHoraEntActionPerformed

    private void TxtIdPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdPlacaActionPerformed

    private void TxtPesoCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPesoCSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoCSActionPerformed

    private void TxtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdProductoActionPerformed
        BusquedaIdProducto();        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdProductoActionPerformed

    private void TxtIdCategoria15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoria15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoria15ActionPerformed

    private void TxtIdCategoria16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoria16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoria16ActionPerformed

    private void TxtIdCategoria17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoria17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoria17ActionPerformed

    private void TxtIdCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoria2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoria2ActionPerformed

    private void TxtIdCategoria18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoria18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoria18ActionPerformed

    private void TxtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtProductoActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        VtnPeso.setVisible(true);
        VtnPeso.setSize(457, 253);
        VtnPeso.setLocationRelativeTo(this);
        VtnPeso.setAlwaysOnTop(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void TxtIdDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdDestinoActionPerformed
        BusquedaIdDestino();        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdDestinoActionPerformed

    private void TxtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDestinoActionPerformed

    private void TxtBusquedaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaProductoActionPerformed
        if (TxtBusquedaProducto.getText().isEmpty()) {
            PGetProducto(TxtBusquedaProducto.getText(), "T");
        } else {
            PGetProducto(TxtBusquedaProducto.getText(), CboBusquedaProducto.getSelectedItem().toString().substring(0, 1));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBusquedaProductoActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (TxtBusquedaProducto.getText().isEmpty()) {
            PGetProducto(TxtBusquedaProducto.getText(), "T");
        } else {
            PGetProducto(TxtBusquedaProducto.getText(), CboBusquedaProducto.getSelectedItem().toString().substring(0, 1));
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void TblProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblProductoMousePressed
        try {
            if (evt.getClickCount() == 2) {

                int fila = TblProducto.getSelectedRow();

                TxtIdProducto.setText(TblProducto.getValueAt(fila, 0).toString());
                TxtProducto.setText(TblProducto.getValueAt(fila, 2).toString());

                VtnProducto.dispose();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }
    }//GEN-LAST:event_TblProductoMousePressed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        VtnProducto.setVisible(true);
        VtnProducto.setSize(588, 602);
        VtnProducto.setLocationRelativeTo(this);
        VtnProducto.setAlwaysOnTop(true);
        PGetProducto(TxtBusquedaProducto.getText(), "T");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        VtnDestino.setVisible(true);
        VtnDestino.setSize(527, 507);
        VtnDestino.setLocationRelativeTo(this);
        VtnDestino.setAlwaysOnTop(true);
        PGetDestino(TxtBusquedaDestino.getText(), "T");

    }//GEN-LAST:event_jButton14ActionPerformed

    private void TxtBusquedaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaDestinoActionPerformed
        if (TxtBusquedaDestino.getText().isEmpty()) {
            PGetDestino(TxtBusquedaDestino.getText(), "T");
        } else {
            PGetDestino(TxtBusquedaDestino.getText(), CboBusquedaDestino.getSelectedItem().toString().substring(0, 2));
        }
    }//GEN-LAST:event_TxtBusquedaDestinoActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (TxtBusquedaDestino.getText().isEmpty()) {
            PGetDestino(TxtBusquedaDestino.getText(), "T");
        } else {
            PGetDestino(TxtBusquedaDestino.getText(), CboBusquedaDestino.getSelectedItem().toString().substring(0, 2));
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void TblDestinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDestinoMousePressed
        try {
            if (evt.getClickCount() == 2) {

                int fila = TblDestino.getSelectedRow();

                TxtIdDestino.setText(TblDestino.getValueAt(fila, 0).toString());
                TxtDestino.setText(TblDestino.getValueAt(fila, 1).toString());
                VtnDestino.dispose();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }
    }//GEN-LAST:event_TblDestinoMousePressed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void TxtIdCategoria19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCategoria19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCategoria19ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
  VtnProveClien.setVisible(true);
        VtnProveClien.setSize(588, 602);
        VtnProveClien.setLocationRelativeTo(this);
        VtnProveClien.setAlwaysOnTop(true);
        PGetProveClien(TxtBusquedaProveClien.getText(), "T");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void TxtPesoCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPesoCEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoCEActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        UbicacionPeso();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void TxtPesoVarianzaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoVarianzaKeyPressed

    private void TxtPesoVarianzaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoVarianzaKeyReleased

    private void TxtPesoVarianzaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaKeyTyped
        if (TxtPesoVarianza.getText().trim().length() > 4) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ';' || c == '.' || c == ',' || c == '+' || c == '-' || c == '*' || c == '/') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }              // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoVarianzaKeyTyped

    private void TxtPesoVarianzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaActionPerformed
        UbicacionPeso();
    }//GEN-LAST:event_TxtPesoVarianzaActionPerformed

    private void TxtBusquedaProveClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaProveClienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBusquedaProveClienActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void TblProveClienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblProveClienMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TblProveClienMousePressed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PPeso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboBusquedaDestino;
    private javax.swing.JComboBox<String> CboBusquedaProducto;
    private javax.swing.JComboBox<String> CboBusquedaProveClien;
    private javax.swing.JTable TblCategoria;
    private javax.swing.JTable TblConductorVehiculo;
    private javax.swing.JTable TblDestino;
    private javax.swing.JTable TblProducto;
    private javax.swing.JTable TblProveClien;
    private javax.swing.JTextField TxtBusqueda;
    private javax.swing.JTextField TxtBusquedaDestino;
    private javax.swing.JTextField TxtBusquedaProducto;
    private javax.swing.JTextField TxtBusquedaProveClien;
    private javax.swing.JTextField TxtChofer;
    private javax.swing.JTextField TxtDestino;
    private javax.swing.JTextField TxtFechaHoraEnt;
    private javax.swing.JTextField TxtFechaHoraSal;
    private javax.swing.JTextField TxtIdCategoria;
    private javax.swing.JTextField TxtIdCategoria1;
    private javax.swing.JTextField TxtIdCategoria15;
    private javax.swing.JTextField TxtIdCategoria16;
    private javax.swing.JTextField TxtIdCategoria17;
    private javax.swing.JTextField TxtIdCategoria18;
    private javax.swing.JTextField TxtIdCategoria19;
    private javax.swing.JTextField TxtIdCategoria2;
    private javax.swing.JTextField TxtIdDestino;
    private javax.swing.JTextField TxtIdPlaca;
    private javax.swing.JTextField TxtIdProducto;
    private javax.swing.JTextField TxtPesoCE;
    private javax.swing.JTextField TxtPesoCS;
    private javax.swing.JTextField TxtPesoNeto;
    private javax.swing.JTextField TxtPesoVarianza;
    private javax.swing.JTextField TxtPlaca;
    private javax.swing.JTextField TxtProducto;
    private javax.swing.JDialog VtnConductorVehiculo;
    private javax.swing.JDialog VtnDestino;
    private javax.swing.JDialog VtnPeso;
    private javax.swing.JDialog VtnProducto;
    private javax.swing.JDialog VtnProveClien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
