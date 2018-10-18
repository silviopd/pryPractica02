
package presentacion;

import javax.swing.JFrame;
import util.Funciones;

/**
 *
 * @author laboratorio_computo
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle(Funciones.NOMBRE_SOFTWARE + "  -  Menú Principal");
        this.lblFecha.setText(Funciones.obtenerFechaActual());
        this.lblUsuario.setText("Usuario: "+Funciones.NOMBRE_USUARIO_LOGUEADO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        lblFecha = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        lblUsuario = new javax.swing.JLabel();
        dpContenedor = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCategoria = new javax.swing.JMenu();
        mnuLineas = new javax.swing.JMenuItem();
        mnuCategorias = new javax.swing.JMenuItem();
        mnuMarcas = new javax.swing.JMenuItem();
        mnuArticulos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuZonas = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuProveedores = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuArea = new javax.swing.JMenuItem();
        mnuCargo = new javax.swing.JMenuItem();
        mnuPersonal = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuSucursal = new javax.swing.JMenuItem();
        mnuAlmacen = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuComprobantes = new javax.swing.JMenuItem();
        mnuSeriesCorrelativos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuCompras = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/articulos.png"))); // NOI18N
        jButton1.setToolTipText("Mantenimiento de Articulos");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        jButton2.setToolTipText("Clientes");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator10);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        jButton6.setToolTipText("Proveedores");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator8);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compra.png"))); // NOI18N
        jButton3.setToolTipText("Compras");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        jButton4.setToolTipText("Ventas");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator9);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        jButton5.setToolTipText("Salir del Sistema");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.png"))); // NOI18N
        jLabel1.setText("Bienvenido");
        jToolBar2.add(jLabel1);
        jToolBar2.add(jSeparator7);

        lblFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.png"))); // NOI18N
        lblFecha.setText("Fecha");
        jToolBar2.add(lblFecha);
        jToolBar2.add(jSeparator11);

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        lblUsuario.setText("Usuario");
        jToolBar2.add(lblUsuario);

        javax.swing.GroupLayout dpContenedorLayout = new javax.swing.GroupLayout(dpContenedor);
        dpContenedor.setLayout(dpContenedorLayout);
        dpContenedorLayout.setHorizontalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dpContenedorLayout.setVerticalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        mnuCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/archivo2.png"))); // NOI18N
        mnuCategoria.setText("Archivo");

        mnuLineas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lineas.png"))); // NOI18N
        mnuLineas.setText("Lineas");
        mnuLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLineasActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuLineas);

        mnuCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnuCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        mnuCategorias.setText("Categorias");
        mnuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoriasActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuCategorias);

        mnuMarcas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mnuMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.png"))); // NOI18N
        mnuMarcas.setText("Marcas");
        mnuMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcasActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuMarcas);

        mnuArticulos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnuArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/articulos.png"))); // NOI18N
        mnuArticulos.setText("Articulos");
        mnuArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArticulosActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuArticulos);
        mnuCategoria.add(jSeparator2);

        mnuZonas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mnuZonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zona.png"))); // NOI18N
        mnuZonas.setText("Zonas");
        mnuZonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuZonasActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuZonas);

        mnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        mnuClientes.setText("Clientes");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuClientes);
        mnuCategoria.add(jSeparator1);

        mnuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        mnuProveedores.setText("Proveedores");
        mnuProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProveedoresActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuProveedores);
        mnuCategoria.add(jSeparator6);

        mnuArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/areas.png"))); // NOI18N
        mnuArea.setText("Area");
        mnuCategoria.add(mnuArea);

        mnuCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargos.png"))); // NOI18N
        mnuCargo.setText("Cargo");
        mnuCategoria.add(mnuCargo);

        mnuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        mnuPersonal.setText("Personal");
        mnuCategoria.add(mnuPersonal);
        mnuCategoria.add(jSeparator3);

        mnuSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sucursales.png"))); // NOI18N
        mnuSucursal.setText("Sucursal");
        mnuCategoria.add(mnuSucursal);

        mnuAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/almacen.png"))); // NOI18N
        mnuAlmacen.setText("Almacen");
        mnuCategoria.add(mnuAlmacen);
        mnuCategoria.add(jSeparator5);

        mnuComprobantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas2.png"))); // NOI18N
        mnuComprobantes.setText("Tipos de comprobande de pago");
        mnuCategoria.add(mnuComprobantes);

        mnuSeriesCorrelativos.setText("Series y Correlativo");
        mnuCategoria.add(mnuSeriesCorrelativos);
        mnuCategoria.add(jSeparator4);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuCategoria.add(mnuSalir);

        jMenuBar1.add(mnuCategoria);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/transaccion.png"))); // NOI18N
        jMenu2.setText("Transacciones");

        mnuCompras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compra.png"))); // NOI18N
        mnuCompras.setText("Compras");
        mnuCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuComprasActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCompras);

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        jMenuItem20.setText("Ventas");
        jMenu2.add(jMenuItem20);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        jMenu3.setText("Reportes");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Administracion del Sistema");

        jMenuItem17.setText("Usuario");
        jMenu4.add(jMenuItem17);

        jMenuItem18.setText("Cambiar contraseña");
        jMenu4.add(jMenuItem18);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.png"))); // NOI18N
        jMenu5.setText("Ayuda");

        jMenuItem15.setText("Manuales de usuario");
        jMenu5.add(jMenuItem15);

        jMenuItem16.setText("Acerca de...");
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
            .addComponent(dpContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpContenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoriasActionPerformed
       
    }//GEN-LAST:event_mnuCategoriasActionPerformed

    private void mnuMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcasActionPerformed
     
    }//GEN-LAST:event_mnuMarcasActionPerformed

    private void mnuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArticulosActionPerformed
        
    }//GEN-LAST:event_mnuArticulosActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
       
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuComprasActionPerformed
        frmProduccionListado obj = new frmProduccionListado(this.dpContenedor.getWidth(),this.dpContenedor.getHeight());
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_mnuComprasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mnuClientes.doClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mnuArticulos.doClick();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        mnuSalir.doClick();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void mnuLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLineasActionPerformed
        
    }//GEN-LAST:event_mnuLineasActionPerformed

    private void mnuZonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuZonasActionPerformed
        
    }//GEN-LAST:event_mnuZonasActionPerformed

    private void mnuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuProveedoresActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       mnuCompras.doClick();
    }//GEN-LAST:event_jButton3ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpContenedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnuAlmacen;
    private javax.swing.JMenuItem mnuArea;
    private javax.swing.JMenuItem mnuArticulos;
    private javax.swing.JMenuItem mnuCargo;
    private javax.swing.JMenu mnuCategoria;
    private javax.swing.JMenuItem mnuCategorias;
    private javax.swing.JMenuItem mnuClientes;
    private javax.swing.JMenuItem mnuCompras;
    private javax.swing.JMenuItem mnuComprobantes;
    private javax.swing.JMenuItem mnuLineas;
    private javax.swing.JMenuItem mnuMarcas;
    private javax.swing.JMenuItem mnuPersonal;
    private javax.swing.JMenuItem mnuProveedores;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuSeriesCorrelativos;
    private javax.swing.JMenuItem mnuSucursal;
    private javax.swing.JMenuItem mnuZonas;
    // End of variables declaration//GEN-END:variables
}
