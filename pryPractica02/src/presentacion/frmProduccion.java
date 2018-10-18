/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Color;
import java.awt.PopupMenu;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import negocio.articulo;
import negocio.produccion;
import negocio.produccionDetalle;
import negocio.configuracion;
import negocio.sucursal;
import util.Funciones;

/**
 *
 * @author USER
 */
public class frmProduccion extends javax.swing.JDialog {

//    private ResultSet resultado;
    public int valorRetorno = 0;

    public frmProduccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cargarComboTipoComprobante();
        configurarCabeceraDetalleCompra();
//        obtenerPorcentajeIGV();

        tblCompra.setCellSelectionEnabled(true);
        tblCompra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCompra.setRowHeight(25);

//        txtNumeroSerie.requestFocus();
        obtenerFecha();
    }

    private void obtenerFecha() {
        java.util.Date obj = new java.util.Date();
        txtFecha.setDate(obj);
    }

//    private boolean validarDatos() {
//
//        if (cboTipoComprobante.getSelectedItem().toString().isEmpty()) {
//            Funciones.mensajeAdvertencia("Debe elegir un tipo de comprobando", "Verificar");
//            cboTipoComprobante.requestFocus();
//            return false;
//        } else if (txtNumeroSerie.getText().isEmpty()) {
//            Funciones.mensajeAdvertencia("Debe ingresar la serie", "Verifique");
//            txtNumeroSerie.requestFocus();
//            return false;
//        } else if (txtNumeroDocumento.getText().isEmpty()) {
//            Funciones.mensajeAdvertencia("Debe ingresar numero de documento", "Verifique");
//            txtNumeroDocumento.requestFocus();
//            return false;
//        } else if (txtNumeroDocumento.getText().length() < 8) {
//            Funciones.mensajeAdvertencia("Debe ingresar numero de documento de 8 caracteres", "Verifique");
//            txtNumeroDocumento.requestFocus();
//            return false;
//        } else if (txtFecha.getDate() == null) {
//            Funciones.mensajeAdvertencia("Debe ingresar una fecha", "Verifique");
//            txtFecha.requestFocus();
//            return false;
//        } else if (txtIGV.getText().isEmpty()) {
//            Funciones.mensajeAdvertencia("Debe ingresar igv", "Verifique");
//            txtIGV.requestFocus();
//            return false;
//        } else if (txtRuc.getText().isEmpty()) {
//            Funciones.mensajeAdvertencia("Debe ingresar ruc del proveedor", "Verifique");
//            txtNumeroDocumento.requestFocus();
//            return false;
//        } else if (tblCompra.getRowCount() <= 0) {
//            Funciones.mensajeAdvertencia("Debe agregar articulos para registrar una produccion", "Verifique");
//            return false;
//        }
//
//        int cantidad = 0;
//        String articulo = "";
//        double descuento = 0;
//        for (int i = 0; i < tblCompra.getRowCount(); i++) {
//            cantidad = Integer.parseInt(this.tblCompra.getValueAt(i, 2).toString());
//            articulo = this.tblCompra.getValueAt(i, 1).toString();
//            descuento = Double.parseDouble(this.tblCompra.getValueAt(i, 4).toString());
//            if (cantidad == 0) {
//                Funciones.mensajeAdvertencia("Debe agregar una cantidad al articulo " + articulo, "Verifique");
//                tblCompra.changeSelection(i, 2, false, false);
//                tblCompra.requestFocus();
//                return false;
//            } else if (descuento < 0 || descuento > 100) {
//                Funciones.mensajeAdvertencia("Debe ingresar un descuento entre 0 y 100 en el articulo " + articulo, "Verifique");
//                tblCompra.changeSelection(i, 4, false, false);
//                tblCompra.requestFocus();
//                return false;
//            }
//        }
//
//        return true;
//    }
//
    public void calcularTotales() {
        
        double importePilado=0;
        double importeEnvase=0;
        double subtotal=0;
        
        double subtotalPilado=0;
        double subtotalEnvase=0;
        double total=0;
        for (int i = 0; i < tblCompra.getRowCount(); i++) {
            importePilado = Double.parseDouble(tblCompra.getValueAt(i, 6).toString().replace(",", ""));
            importeEnvase = Double.parseDouble(tblCompra.getValueAt(i, 11).toString().replace(",", ""));
            subtotal = Double.parseDouble(tblCompra.getValueAt(i, 12).toString().replace(",", ""));
            
            subtotalPilado=subtotalPilado+importePilado;
            subtotalEnvase=subtotalEnvase+importeEnvase;
            total=total+subtotal;
        }
        
        subtotal=importeEnvase+importePilado;
        
        lblImportePilado.setText(Funciones.formatearNumero(subtotalPilado));
        lblImporteEnvase.setText(Funciones.formatearNumero(subtotalEnvase));
        lblSubTotal.setText(Funciones.formatearNumero(total));
    }
//
//    private void obtenerPorcentajeIGV() {
//        try {
//            String valor = new configuracion().obtenerValorConfiguracion(1);
//            txtIGV.setText(valor);
//        } catch (Exception e) {
//            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
//        }
//    }
//
    private void configurarCabeceraDetalleCompra() {
        try {
            ResultSet resultado = new produccionDetalle().configurarTablaDetalleCompra();
            int anchoCol[] = {80, 400, 80, 80, 80, 80, 80, 80,400, 80, 80, 80, 80};
            String alineCol[] = {"C", "I", "D", "D", "D", "D", "D", "D","I", "D", "D", "D", "D"};
            Funciones.llenarTabla(tblCompra, resultado, anchoCol, alineCol);
        } catch (Exception e) {
            Funciones.mensajeInformacion(e.getMessage(), "ERROR...");
        }
    }

    private void cargarComboTipoComprobante() {
        try {
            new sucursal().cargarCombo(cboTipoComprobante);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        /*parte 1*/
        final JTextField field = new JTextField("0");
        final DefaultCellEditor edit = new DefaultCellEditor(field);
        field.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        field.setForeground(Color.blue);
        /*parte 1*/
        tblCompra = new javax.swing.JTable(){
            /*parte 2*/
            public boolean isCellEditable(int fila, int columna){
                if (columna == 3 || columna == 4){
                    return true;
                }
                return false;
            }

            public TableCellEditor getCellEditor(int row, int col) {
                if (col == 2){
                    field.setDocument(new util.ValidaNumeros());
                }else{
                    field.setDocument(new util.ValidaNumeros(util.ValidaNumeros.ACEPTA_DECIMAL));
                }
                edit.setClickCountToStart(2);
                field.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent e) {
                        field.select(0,0);
                    }
                });
                return edit;
            }
            /*parte 2*/

        };
        lblImportePilado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblImporteEnvase = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cboTipoComprobante = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtCantidadSaco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del proveedor"));

        jLabel8.setText("Codigo:");

        jLabel9.setText("Nombre");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);

        jLabel11.setText("Telefono: ");

        txtTelefono.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnQuitar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnQuitar.setText("Quitar artículo");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Grabar la compra");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setText("Agregar artículo");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Artículos registrados de la compra"));

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCompra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblCompraPropertyChange(evt);
            }
        });
        tblCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCompraKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompra);
        /*parte 3*/
        tblCompra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                field.setText("");
                field.requestFocus();
            }
        });

        field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode()==10){
                    if (field.getText().isEmpty()){
                        evt.consume();
                    }
                }
            }
        });
        /*parte 3*/

        lblImportePilado.setEditable(false);
        lblImportePilado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblImportePilado.setForeground(new java.awt.Color(255, 51, 51));
        lblImportePilado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblImportePilado.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Total importe pilados");

        lblImporteEnvase.setEditable(false);
        lblImporteEnvase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblImporteEnvase.setForeground(new java.awt.Color(255, 51, 51));
        lblImporteEnvase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblImporteEnvase.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Total importe envases");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("SubTotal");

        lblSubTotal.setEditable(false);
        lblSubTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(255, 51, 51));
        lblSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblSubTotal.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImportePilado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImporteEnvase, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblImportePilado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblImporteEnvase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("N° Prod:");

        jTextField1.setEditable(false);

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Sucursal");

        jLabel6.setText("Fecha Venta");

        txtCantidadSaco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadSacoKeyPressed(evt);
            }
        });

        jLabel7.setText("Cantidad de saco de arroz cascara");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadSaco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitar)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(35, 35, 35)
                .addComponent(jButton4)
                .addGap(331, 331, 331))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtCantidadSaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnQuitar)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmClienteBuscar obj = new frmClienteBuscar(null, true);
        obj.setTitle("Buscar Proveedor");
        obj.setVisible(true);
        
        if (obj.valorRetorno ==1) {            
            int filaSelecciona = obj.tblListado.getSelectedRow();
            String codigo = obj.tblListado.getValueAt(filaSelecciona, 0).toString();
            String nombre = obj.tblListado.getValueAt(filaSelecciona, 1).toString();
            String telefonofijo = obj.tblListado.getValueAt(filaSelecciona, 2).toString();
                                 
            //ERROR CUANDO ESTA VACIO
            txtCodigo.setText(codigo);
            txtNombre.setText(nombre);
            txtTelefono.setText(telefonofijo);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        frmArticuloBuscar obj = new frmArticuloBuscar(null, true);
        obj.setVisible(true);

        if (obj.valorRetorno1 > 0) {
            int filasel = obj.tblListado.getSelectedRow();
            
            int codigoProducto = Integer.parseInt(obj.tblListado.getValueAt(filasel, 0).toString());
            String nombreProducto = obj.tblListado.getValueAt(filasel, 1).toString();
            int pesoProducto = Integer.parseInt(obj.tblListado.getValueAt(filasel, 2).toString());
            int cantidadSacos = 0;
            int cantidadKilos = 0;
            double precioPilado = Double.parseDouble(obj.tblListado.getValueAt(filasel, 3).toString());
            double importePilado = 0;
            int codigoEnvase = Integer.parseInt(obj.tblListado.getValueAt(filasel, 4).toString());
            String nombreEnvase = obj.tblListado.getValueAt(filasel, 5).toString();
            int cantidadEnvaseUti=0;
            double precioEnvase = Double.parseDouble(obj.tblListado.getValueAt(filasel, 6).toString());
            double importeEnvase = 0;
            double subtotal = 0;

            DefaultTableModel modelo = (DefaultTableModel) this.tblCompra.getModel();

            Object filaDatos[] = new Object[13];
            filaDatos[0] = codigoProducto;
            filaDatos[1] = nombreProducto;
            filaDatos[2] = pesoProducto;
            filaDatos[3] = cantidadSacos;
            filaDatos[4] = cantidadKilos;
            filaDatos[5] = precioPilado;
            filaDatos[6] = importePilado;
            filaDatos[7] = codigoEnvase;
            filaDatos[8] = nombreEnvase;
            filaDatos[9] = cantidadEnvaseUti;
            filaDatos[10] = precioEnvase;
            filaDatos[11] = importeEnvase;
            filaDatos[12] = subtotal;

            modelo.addRow(filaDatos);

            tblCompra.setModel(modelo);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed

        /*metodo 1*/
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            try {
//                leerDatosRUC(txtRuc.getText());
//            } catch (Exception e) {
//                Funciones.mensajeError(e.getMessage(), "Verifique");
//            }
//        }
//
//        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
//            txtRazonSocial.setText("");
//            txtDireccion.setText("");
//            txtTelefono.setText("");
//        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        Funciones.soloNumeros(evt, txtCodigo, 11);
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
//        /*metodo 2*/
//        if (txtRuc.getText().length() == 11) {
//            try {
//                leerDatosRUC(txtRuc.getText());
//            } catch (Exception e) {
//                Funciones.mensajeError(e.getMessage(), "Verifique");
//            }
//        }
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void tblCompraPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblCompraPropertyChange
        if (evt.getPropertyName().equalsIgnoreCase("tableCellEditor")) {
            //System.out.println("Editando datos sobre la tabla");
            int columnaEditar = this.tblCompra.getEditingColumn();
            int filaEditar = this.tblCompra.getEditingRow();

            if (columnaEditar == 3 || columnaEditar == 4) {
                
                int pesoProducto = Integer.parseInt(this.tblCompra.getValueAt(filaEditar, 2).toString());
                int cantidadSacos = Integer.parseInt(this.tblCompra.getValueAt(filaEditar, 3).toString());
                int cantidadKilos = Integer.parseInt(this.tblCompra.getValueAt(filaEditar, 4).toString());
                double precioPilado = Double.parseDouble(this.tblCompra.getValueAt(filaEditar, 5).toString());

                double importePilado = new produccionDetalle().calcularImportePilado(pesoProducto, cantidadSacos, cantidadKilos, precioPilado);

                
                int cantidadEnvase=0;
                if (cantidadKilos>0) {
                    cantidadEnvase=cantidadSacos+1;  
                }else{
                    cantidadEnvase=cantidadSacos;
                }
                double precioEnvase = Double.parseDouble(this.tblCompra.getValueAt(filaEditar, 10).toString());

                double importeEnvase = new produccionDetalle().calcularImporteEnvase(cantidadEnvase, precioEnvase);

                
                
                this.tblCompra.setValueAt(Funciones.formatearNumero(importePilado), filaEditar, 6);
                this.tblCompra.setValueAt(Funciones.formatearNumero(cantidadEnvase), filaEditar, 9);
                this.tblCompra.setValueAt(Funciones.formatearNumero(importeEnvase), filaEditar, 11);
                this.tblCompra.setValueAt(Funciones.formatearNumero(importeEnvase+importePilado), filaEditar, 12);
                calcularTotales();
            }
        }
    }//GEN-LAST:event_tblCompraPropertyChange

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        DefaultTableModel tablaDetalle
                = (DefaultTableModel) this.tblCompra.getModel();

        int fila = this.tblCompra.getSelectedRow();

        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar una fila", "Verifique");
            return;
        }

        String articulo = tblCompra.getValueAt(fila, 1).toString();
        int respuesta = Funciones.mensajeConfirmacion(
                "Esta seguro de quitar el artículo: " + articulo,
                "Confirme"
        );

        if (respuesta != 0) {
            return;
        }

        tablaDetalle.removeRow(fila);
        this.tblCompra.setModel(tablaDetalle);

        calcularTotales();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void tblCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCompraKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DELETE:
                btnQuitar.doClick();
                break;

            case KeyEvent.VK_INSERT:
                btnAgregar.doClick();
                break;
        }
    }//GEN-LAST:event_tblCompraKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        if (validarDatos() == false) {
//            return;
//        }
//
        int respuesta = Funciones.mensajeConfirmacion("Desea grabar la compra", "comfirme");
        if (respuesta == 1) {
            return;
        }
        grabarCompra();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtCantidadSacoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadSacoKeyPressed
       Funciones.soloNumerosDecimal(evt, txtCantidadSaco, 5);
    }//GEN-LAST:event_txtCantidadSacoKeyPressed

    private void grabarCompra() {

        try {
            int Sucursal = sucursal.listaTipoComp.get(cboTipoComprobante.getSelectedIndex()).getCodigo();            
            java.sql.Date fecha_compra = new java.sql.Date(this.txtFecha.getDate().getTime());
            int cantidad_saco_arroz_cascara = Integer.parseInt(txtCantidadSaco.getText());
            int codigoCliente= Integer.parseInt(txtCodigo.getText());
            int codigo_usuario = 1; // esta por cambiar            
            double total_pilado = Double.parseDouble(lblImportePilado.getText().replace(",", ""));
            double total_envases = Double.parseDouble(lblImporteEnvase.getText().replace(",", ""));
            
            produccion objCompra = new produccion();
            objCompra.setCodigo_usuario(codigo_usuario);
            objCompra.setCantidad_sacos_arroz_cascara(cantidad_saco_arroz_cascara);
            objCompra.setFecha(fecha_compra);
            objCompra.setCodigo_sucursal(Sucursal);
            objCompra.setCodigo_cliente(codigoCliente);
            objCompra.setTotal_pilado(total_pilado);
            objCompra.setTotal_envases(total_envases);
            
            
            ArrayList<produccionDetalle> articuloDetalleCompra = new ArrayList<produccionDetalle>();
            
            for (int i = 0; i < tblCompra.getRowCount(); i++) {
                int codigo_producto = Integer.parseInt(tblCompra.getValueAt(i, 0).toString());
                int cantidad_sacos = Integer.parseInt(tblCompra.getValueAt(i, 3).toString());
                int cantidad_kilos = Integer.parseInt(tblCompra.getValueAt(i, 4).toString());
                double precio_pilado = Double.parseDouble(tblCompra.getValueAt(i, 5).toString());
                double importe_pilado = Double.parseDouble(tblCompra.getValueAt(i, 6).toString().replace(",", ""));
                int codigo_envase = Integer.parseInt(tblCompra.getValueAt(i, 7).toString());
                double cantidad_envases_utilizados = Double.parseDouble(tblCompra.getValueAt(i,9).toString().replace(",", ""));
                double precio_envases = Double.parseDouble(tblCompra.getValueAt(i, 10).toString());
                double importe_envases = Double.parseDouble(tblCompra.getValueAt(i, 11).toString().replace(",", ""));
                double sub_total = Double.parseDouble(tblCompra.getValueAt(i, 12).toString().replace(",", ""));
                
                produccionDetalle objFila = new produccionDetalle();
                objFila.setCodigo_producto(codigo_producto);
                objFila.setCantidad_sacos(cantidad_sacos);
                objFila.setCantidad_kilos(cantidad_kilos);
                objFila.setPrecio_pilado(precio_pilado);
                objFila.setImporte_pilado(importe_pilado);
                objFila.setCodigo_envase(codigo_envase);
                //ERROR
                objFila.setCantidad_envases_utilizados((int)cantidad_envases_utilizados);
                objFila.setPrecio_envase(precio_envases);
                objFila.setImporte_envases(importe_envases);
                objFila.setSub_total(sub_total);                

                articuloDetalleCompra.add(objFila);
            }
            objCompra.setArticuloDetalleCompra(articuloDetalleCompra);

            if (objCompra.grabarCompra()) {
                Funciones.mensajeInformacion("Grabado correctamente", "Exito");
                this.valorRetorno = 1;
                this.dispose();
            }

        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cboTipoComprobante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lblImporteEnvase;
    private javax.swing.JTextField lblImportePilado;
    private javax.swing.JTextField lblSubTotal;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTextField txtCantidadSaco;
    private javax.swing.JTextField txtCodigo;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
