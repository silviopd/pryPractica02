
package datos;

import java.sql.*;

public class Conexion {
    
    private String controlador = "org.postgresql.Driver";
    private String cadenaConexion = "jdbc:postgresql://localhost:5432/bd_practicaProgra";
//    private String cadenaConexion = "jdbc:postgresql://localhost:5432/bdComercial";
    private String usuario="postgres";
    private String clave="silviopd";
    
    private Connection conexion;
    
    protected Connection abrirConexion() throws Exception{
        Class.forName(this.controlador);
        conexion=DriverManager.getConnection(cadenaConexion, usuario, clave);
        return conexion;
    }
    
    protected void cerrarConexion() throws Exception {
        conexion.close();
        conexion = null;
    }
    
    protected ResultSet ejecutarSQLSelect(String sql) throws Exception {
        Statement sentencial = null;
        ResultSet resultado = null;
        
        sentencial = abrirConexion().createStatement();
        resultado = sentencial.executeQuery(sql);
        cerrarConexion();
        return resultado;
    }
    
    protected ResultSet ejecutarSQLSelectSP(PreparedStatement sentencia) throws Exception{
        ResultSet resultado = null;
        
        resultado=sentencia.executeQuery();
        cerrarConexion();
        return resultado;
    }
    
    protected int ejecutarSQL(PreparedStatement sentencia, Connection con) throws Exception{
        
        int resultado=0;
        try {
            resultado = sentencia.executeUpdate();            
        } catch (Exception e) {
            con.rollback();
           throw e;
        }
        
        return resultado;
    }
    
}

