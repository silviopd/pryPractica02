/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class produccionDetalle extends Conexion {
    
  private int codigo_producto;
  private int cantidad_sacos;
  private int cantidad_kilos;
  private double precio_pilado;
  private double importe_pilado;
  private int codigo_envase;
  private int cantidad_envases_utilizados;
  private double precio_envase;
  private double importe_envases;
  private double sub_total;


    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCantidad_sacos() {
        return cantidad_sacos;
    }

    public void setCantidad_sacos(int cantidad_sacos) {
        this.cantidad_sacos = cantidad_sacos;
    }

    public int getCantidad_kilos() {
        return cantidad_kilos;
    }

    public void setCantidad_kilos(int cantidad_kilos) {
        this.cantidad_kilos = cantidad_kilos;
    }

    public double getPrecio_pilado() {
        return precio_pilado;
    }

    public void setPrecio_pilado(double precio_pilado) {
        this.precio_pilado = precio_pilado;
    }

    public double getImporte_pilado() {
        return importe_pilado;
    }

    public void setImporte_pilado(double importe_pilado) {
        this.importe_pilado = importe_pilado;
    }

    public int getCodigo_envase() {
        return codigo_envase;
    }

    public void setCodigo_envase(int codigo_envase) {
        this.codigo_envase = codigo_envase;
    }

    public int getCantidad_envases_utilizados() {
        return cantidad_envases_utilizados;
    }

    public void setCantidad_envases_utilizados(int cantidad_envases_utilizados) {
        this.cantidad_envases_utilizados = cantidad_envases_utilizados;
    }

    public double getPrecio_envase() {
        return precio_envase;
    }

    public void setPrecio_envase(double precio_envase) {
        this.precio_envase = precio_envase;
    }

    public double getImporte_envases() {
        return importe_envases;
    }

    public void setImporte_envases(double importe_envases) {
        this.importe_envases = importe_envases;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    
    public ResultSet configurarTablaDetalleCompra() throws Exception {
        String sql = "select * from( select 0 as codigo_producto, ''::character varying(100) producto, 0 as peso_producto,0 as cantidad_sacos,0 as cantidad_kilos , 0 as precio_pilado,0 as importe_pilado,0 as codigo_envase,''::character varying(100) envase,0 cantidad_envases_uti,0 as precio_envase,0 importe_envases,0 subtotal) as tb_temporal where tb_temporal.codigo_producto <> 0";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }

    public double calcularImportePilado(int peso_producto,int cantidad_sacos,double cantidad_kilos,double precio){
        //ERROR SUMA
        double importeNeto = 0;
        importeNeto=(cantidad_sacos*precio)+((cantidad_kilos/peso_producto)*precio);
        return importeNeto;
    }
    
    public double calcularImporteEnvase(int cantidadEnvase,double precioEnvase){
        double importeNeto = 0;
        importeNeto=cantidadEnvase*precioEnvase;
        return importeNeto;
    }

}
