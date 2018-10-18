package negocio;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class cliente extends Conexion {

    private int codigo_cliente;
    private String nombre;
    private String telefono;
    private String email;

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public ResultSet listar() throws Exception {
        String sql ="select codigo,nombre,telefono from cliente order by 2"; 
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }

    public String[] obtenerCamposBusqueda() {
        String campos[] = {"codigo", "nombre","telefono"};
                return campos;
    }
    

//    public boolean agregar() throws Exception {
//        String sql = "select * from f_generar_correlativo('cliente') as numero";
//        ResultSet resultado = ejecutarSQLSelect(sql);
//
//        if (resultado.next()) {
//            int nuevoCodigo = resultado.getInt("numero");
//            setCodigo_cliente(nuevoCodigo);
//
//            Connection transaccion = abrirConexion();
//            transaccion.setAutoCommit(false);
//
//            sql = "INSERT INTO cliente(codigo_cliente, apellido_paterno, apellido_materno, nombres, nro_documento_identidad, direccion, telefono_fijo, telefono_movil1, telefono_movil2, email, direccion_web, codigo_departamento, codigo_provincia, codigo_distrito) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//            PreparedStatement sentencia1 = transaccion.prepareStatement(sql);
//            sentencia1.setInt(1, this.getCodigo_cliente());
//            sentencia1.setString(2, this.getApellido_paterno());
//            sentencia1.setString(3, this.getApellido_materno());
//            sentencia1.setString(4, this.getNombres());
//            sentencia1.setString(5, this.getNro_documento_identidad());
//            sentencia1.setString(6, this.getDireccion());
//            sentencia1.setString(7, this.getTelefono_fijo());
//            sentencia1.setString(8, this.getTelefono_movil1());
//            sentencia1.setString(9, this.getTelefono_movil2());
//            sentencia1.setString(10, this.getEmail());
//            sentencia1.setString(11, this.getDireccion_web());
//            sentencia1.setString(12, this.getCodigo_departamento());
//            sentencia1.setString(13, this.getCodigo_provincia());
//            sentencia1.setString(14, this.getCodigo_distrito());
//            this.ejecutarSQL(sentencia1, transaccion);
//
//            sql = "UPDATE correlativo SET numero=numero+1 WHERE tabla=?";
//            PreparedStatement sentencia2 = transaccion.prepareStatement(sql);
//            sentencia2.setString(1, "cliente");
//            this.ejecutarSQL(sentencia2, transaccion);
//
//            transaccion.commit();
//            transaccion.close();
//        } else {
//            throw new Exception("No existe un correlativo registrado para la tabla cliente");
//        }
//        return true;
//    }
//
//    public boolean editar() throws Exception {
//        Connection transaccion = abrirConexion();
//        transaccion.setAutoCommit(false);
//
//        String sql = "UPDATE cliente SET  apellido_paterno=?, apellido_materno=?, nombres=?, nro_documento_identidad=?, direccion=?, telefono_fijo=?, telefono_movil1=?, telefono_movil2=?, email=?, direccion_web=?, codigo_departamento=?, codigo_provincia=?, codigo_distrito=? WHERE codigo_cliente=?;";
//
//        PreparedStatement sentencia = transaccion.prepareStatement(sql);
//        
//        sentencia.setString(1, this.getApellido_paterno());
//        sentencia.setString(2, this.getApellido_materno());
//        sentencia.setString(3, this.getNombres());
//        sentencia.setString(4, this.getNro_documento_identidad());
//        sentencia.setString(5, this.getDireccion());
//        sentencia.setString(6, this.getTelefono_fijo());
//        sentencia.setString(7, this.getTelefono_movil1());
//        sentencia.setString(8, this.getTelefono_movil2());
//        sentencia.setString(9, this.getEmail());
//        sentencia.setString(10, this.getDireccion_web());
//        sentencia.setString(11, this.getCodigo_departamento());
//        sentencia.setString(12, this.getCodigo_provincia());
//        sentencia.setString(13, this.getCodigo_distrito());
//        sentencia.setInt(14, this.getCodigo_cliente());
//
//        this.ejecutarSQL(sentencia, transaccion);
//        transaccion.commit();
//        transaccion.close();
//
//        return true;
//    }
    
    public boolean eliminar() throws Exception {
        Connection transaccion = abrirConexion();
        transaccion.setAutoCommit(false);

        String sql = "delete from cliente where codigo_cliente=?";

        PreparedStatement sentencia = transaccion.prepareStatement(sql);
        sentencia.setInt(1, getCodigo_cliente());

        this.ejecutarSQL(sentencia, transaccion);
        transaccion.commit();
        transaccion.close();

        return true;
    }

//    public ResultSet leerDatos(int cod_cli) throws Exception {
//        String sql = "SELECT   cliente.codigo_cliente as codigo,   cliente.apellido_paterno,   cliente.apellido_materno,   cliente.nombres,   cliente.nro_documento_identidad as dni,  cliente.direccion,   cliente.telefono_fijo,   cliente.telefono_movil1,   cliente.telefono_movil2,   cliente.email,   cliente.direccion_web, departamento.nombre as departamento ,provincia.nombre as provincia,  distrito.nombre as distrito FROM   public.departamento,   public.provincia,   public.distrito,   public.cliente WHERE   provincia.codigo_departamento = departamento.codigo_departamento AND   provincia.codigo_provincia = distrito.codigo_provincia AND  provincia.codigo_departamento = distrito.codigo_departamento AND   distrito.codigo_departamento = cliente.codigo_departamento AND  distrito.codigo_provincia = cliente.codigo_provincia AND  distrito.codigo_distrito = cliente.codigo_distrito AND cliente.codigo_cliente=?";
//        PreparedStatement sentencia = abrirConexion().prepareStatement(sql);
//        sentencia.setInt(1, cod_cli);
//        return ejecutarSQLSelectSP(sentencia);
//    }
    
}
