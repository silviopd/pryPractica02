package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Funciones;

public class inicioSesion extends Conexion {

    private String email;
    private String clave;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int iniciarSesion() throws Exception {
        String sql = "select p.apellido_paterno,p.apellido_materno,p.nombres,u.estado from personal p inner join usuario u on p.dni=u.dni_usuario where p.email='" + this.getEmail() + "' and u.clave=md5('" + this.getClave() + "')";

        System.out.println(sql);

        ResultSet resultado = this.ejecutarSQLSelect(sql);

        if (resultado.next()) {
            if (resultado.getString("estado").equals("A")) {
                Funciones.NOMBRE_USUARIO_LOGUEADO = resultado.getString("apellido_paterno") + " " + resultado.getString("apellido_materno") + ", " + resultado.getString("nombres");
                return 1;
            } else {
                return 2;
            }
        }

        return -1;
    }

    public int iniciarSesionSP() throws Exception {
        String sql = "select p.apellido_paterno,p.apellido_materno,p.nombres,u.estado from personal p inner join usuario u on p.dni=u.dni_usuario where p.email=? and u.clave=md5(?)";

        //System.out.println(sql);        
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);

        sentencia.setString(1, getEmail());
        sentencia.setString(2, getClave());

        //ResultSet resultado = this.ejecutarSQLSelect(sql);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);

        if (resultado.next()) {
            if (resultado.getString("estado").equals("A")) {
                Funciones.NOMBRE_USUARIO_LOGUEADO = resultado.getString("apellido_paterno") + " " + resultado.getString("apellido_materno") + ", " + resultado.getString("nombres");
                return 1;
            } else {
                return 2;
            }
        }

        return -1;
    }

}
