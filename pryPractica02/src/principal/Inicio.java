package principal;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import presentacion.frmMain;
import presentacion.iniciarSesion;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //new frmLinea().setVisible(true);
        
         try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //new iniciarSesion().setVisible(true);
            new frmMain().setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         /*
        linea obj = new linea();       
       
        try {
            ResultSet resulato = obj.listar();
            while (resulato.next()) {
                System.out.println(resulato.getString("descripcion"));
                //System.out.println(resulato.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        */
    }

}
