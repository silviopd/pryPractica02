/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;
import javax.xml.transform.Result;

/**
 *
 * @author USER
 */
public class configuracion extends Conexion{
    
    public String obtenerValorConfiguracion (int codigo) throws Exception{
    String sql = "select valor from configuracion where codigo=?";
        PreparedStatement sentencia = abrirConexion().prepareCall(sql);
        sentencia.setInt(1, codigo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        if (resultado.next()) {
            return resultado.getString("valor");
        }
        
        return "Valor no encontrado";
    }
}
