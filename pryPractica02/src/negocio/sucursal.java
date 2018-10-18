package negocio;

import datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class sucursal extends Conexion{
    
    private int codigo;
    private String nombre;

    
    public static ArrayList<sucursal> listaTipoComp = new ArrayList<sucursal>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    private void cargarLista() throws Exception {
        String sql = "select * from sucursal order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);

        listaTipoComp.clear();

        while (resultado.next()) {
            sucursal obj = new sucursal();
            obj.setCodigo(resultado.getInt("codigo"));
            obj.setNombre(resultado.getString("nombre"));
            listaTipoComp.add(obj);
        }
    }
    
    public void cargarCombo(JComboBox objCombo) throws Exception {
        cargarLista();
        objCombo.removeAllItems();
        
        for (sucursal listCom : listaTipoComp) {
            objCombo.addItem(listCom.getNombre());
        }
    }
    
}
