/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.ResultSet;
import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class articulo extends Conexion {

    private int codigo_articulo;
    private String nombre;
    private double precio;
    private int codigo_linea;
    private int codigo_categoria;
    private int codigo_marca;
    private int stock;
    private String estado;
    private double descuento;

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo_linea() {
        return codigo_linea;
    }

    public void setCodigo_linea(int codigo_linea) {
        this.codigo_linea = codigo_linea;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public int getCodigo_marca() {
        return codigo_marca;
    }

    public void setCodigo_marca(int codigo_marca) {
        this.codigo_marca = codigo_marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ResultSet listar() throws Exception {
        String sql = "select tb1.codigo as codigo_producto,tb1.nombre as producto,tb1.peso_producto,tb1.precio_pilado,tb1.codigo_envase,tb2.nombre as envase,tb2.precio_envase"
                + " from "
                + "(select * from articulo where linea='P') as tb1"
                + " inner join"
                + " (select * from articulo where linea='E') as tb2"
                + " on tb1.codigo_envase=tb2.codigo";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }

}
