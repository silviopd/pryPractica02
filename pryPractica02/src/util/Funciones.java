package util;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Funciones {
    
    public static String NOMBRE_USUARIO_LOGUEADO;
    
    public static final String NOMBRE_SOFTWARE = "SISTEMA COMERCIAL v. 1.0";
    
    public static void mensajeInformacion(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE );
    }

    public static void mensajeError(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE );
    }

    public static void mensajeAdvertencia(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE );
    }

    public static int mensajeConfirmacion(String mensaje, String titulo){
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION );
    }

    public static String obtenerFechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
    }
    
    
    public static void llenarTabla(JTable tabla, ResultSet resultado) throws Exception{
        DefaultTableModel modelo = new DefaultTableModel();
        int nroColumnas = resultado.getMetaData().getColumnCount();
        
        for (int i=0; i<nroColumnas; i++){
            modelo.addColumn(resultado.getMetaData().getColumnLabel(i+1).toUpperCase());
        }
        
        Object datos[] = new Object[nroColumnas];
        while (resultado.next()){
            for(int i=0; i<nroColumnas;i++){
                datos[i] = resultado.getObject(i+1);
            }
            modelo.addRow(datos);
        }
        tabla.setModel(modelo);
        
        /*INMOVILIZAR LAS COLUMAS DE LA TABLA*/
        tabla.getTableHeader().setReorderingAllowed(false);
        /*INMOVILIZAR LAS COLUMAS DE LA TABLA*/
        
    }
    
    public static void llenarTabla(JTable tabla, ResultSet resultado, int[] anchoColumna, String[] alineacionColumna) throws Exception{
        llenarTabla(tabla, resultado);
        
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setAutoCreateRowSorter(true);
        
        for (int i=0; i<anchoColumna.length; i++){
            DefaultTableCellRenderer alineacion = new DefaultTableCellRenderer();
            if (alineacionColumna[i].equalsIgnoreCase("C") ){
                alineacion.setHorizontalAlignment(SwingConstants.CENTER);
            }else if (alineacionColumna[i].equalsIgnoreCase("I") ){
                alineacion.setHorizontalAlignment(SwingConstants.LEFT);
            }else{
                alineacion.setHorizontalAlignment(SwingConstants.RIGHT);
            }
            tabla.getColumnModel().getColumn(i).setCellRenderer(alineacion);
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchoColumna[i]);
        }
    }
    
    
    public static void llenarTablaBusqueda(JTable tabla, ResultSet resultado, String columna, String valor) throws Exception{
        
        if (columna == null){
            columna = "";
        }
        
        if (valor == null){
            valor = "";
        }
        
        resultado.first();
        resultado.previous();
        
        DefaultTableModel modelo = new DefaultTableModel();
        int nroColumnas = resultado.getMetaData().getColumnCount();
        
        for (int i=0; i<nroColumnas; i++){
            modelo.addColumn(resultado.getMetaData().getColumnLabel(i+1).toUpperCase());
        }
        
        Object datos[] = new Object[nroColumnas];
        while (resultado.next()){
            for(int i=0; i<nroColumnas;i++){
                datos[i] = resultado.getObject(i+1);
            }
            
            if (! valor.isEmpty()){
                if (resultado.getObject(columna).toString().toLowerCase().contains(valor.toLowerCase()) ){
                    modelo.addRow(datos);
                }
            }else{
                modelo.addRow(datos);
            }
            
        }
        tabla.setModel(modelo);
        
        /*INMOVILIZAR LAS COLUMAS DE LA TABLA*/
        tabla.getTableHeader().setReorderingAllowed(false);
        /*INMOVILIZAR LAS COLUMAS DE LA TABLA*/
    }
    
    public static void llenarTablaBusqueda(JTable tabla, ResultSet resultado, int[] anchoColumna, String[] alineacionColumna, String columna, String valor) throws Exception{
        llenarTablaBusqueda(tabla, resultado, columna, valor);
        
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setAutoCreateRowSorter(true);
        
        for (int i=0; i<anchoColumna.length; i++){
            DefaultTableCellRenderer alineacion = new DefaultTableCellRenderer();
            if (alineacionColumna[i].equalsIgnoreCase("C") ){
                alineacion.setHorizontalAlignment(SwingConstants.CENTER);
            }else if (alineacionColumna[i].equalsIgnoreCase("I") ){
                alineacion.setHorizontalAlignment(SwingConstants.LEFT);
            }else{
                alineacion.setHorizontalAlignment(SwingConstants.RIGHT);
            }
            tabla.getColumnModel().getColumn(i).setCellRenderer(alineacion);
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchoColumna[i]);
        }
    }
    
    public static void soloNumerosConCaracter(KeyEvent evt, JTextField objTexto, int numeroCaracteres){    
        if (objTexto.getDocument().getClass().getName().equalsIgnoreCase("javax.swing.text.PlainDocument")){
            objTexto.setDocument( new util.ValidaNumeros( ValidaNumeros.ACEPTA_CARACTER ) );
        }        
        if (numeroCaracteres > 0){
            if(objTexto.getText() .length()==numeroCaracteres) evt.consume();
        }        
    }
    
    public static void soloNumerosDecimal(KeyEvent evt, JTextField objTexto, int numeroCaracteres){    
        if (objTexto.getDocument().getClass().getName().equalsIgnoreCase("javax.swing.text.PlainDocument")){
            objTexto.setDocument( new util.ValidaNumeros( ValidaNumeros.ACEPTA_DECIMAL ) );
        }        
        if (numeroCaracteres > 0){
            if(objTexto.getText() .length()==numeroCaracteres) evt.consume();
        }        
    }
    

public static void soloNumeros(KeyEvent evt, JTextField objTexto, int numeroCaracteres){
        if (objTexto.getDocument().getClass().getName().equalsIgnoreCase("javax.swing.text.PlainDocument")){
            objTexto.setDocument( new util.ValidaNumeros() );
        }        
        if (numeroCaracteres > 0){
            if(objTexto.getText() .length()==numeroCaracteres) evt.consume();
        }        
    }


public static void aceptaTodosCaracteres(KeyEvent evt, JTextField objTexto, int numeroCaracteres){
    
        if (! objTexto.getDocument().getClass().getName().equalsIgnoreCase("javax.swing.text.PlainDocument")){
            objTexto.setDocument( new javax.swing.text.PlainDocument() );
        }
        
        if (numeroCaracteres > 0){
            if(objTexto.getText() .length()==numeroCaracteres) evt.consume();
        }
        
    }

 public static void soloLetras(KeyEvent evt, JTextField objTexto, int numeroCaracteres){
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')
            && car !='á' //Minúsculas
            && car !='é'
            && car !='í'
            && car !='ó'
            && car !='ú'
            && car !='Á' //Mayúsculas
            && car !='É'
            && car !='Í'
            && car !='Ó'
            && car !='Ú'
            && (car!=(char)evt.VK_SPACE ))
        {
          evt.consume(); //evita que se escriba el caracter
        }
        
        if (numeroCaracteres > 0){
            if(objTexto.getText() .length()==numeroCaracteres) evt.consume();
        }
        
    }
 
    public static void letrasMayusculas(KeyEvent evt){
        Character c = evt.getKeyChar();
        
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }
    
    public static void letrasMinusculas(KeyEvent evt){
        Character c = evt.getKeyChar();
        
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toLowerCase(c));
        }
    }
    
    public static String formatearNumero(double numero){
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        
        DecimalFormat formato = new DecimalFormat("###,###.00", simbolos);
        
        return formato.format(numero);
        
    }
    
    
}
