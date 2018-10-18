package util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagenFondo implements Border{
    public BufferedImage fondo;
    private String tipo;

    public ImagenFondo(String tipo) {
        this.tipo = tipo;
        try {
            //URL imagen = new URL(getClass().getResource("/imagenes/fondo3.jpeg").toString());
            URL imagen = new URL(getClass().getResource("/imagenes/inicio_sesion.png").toString());
            System.out.println(imagen);
            //URL imagen = new URL("file:/E:/h/s/Innovasys/build/classes/imagenes/fondo3.jpeg");
            //System.out.println(this.getClass().getResource("../imagenes/fondo3.jpeg").toString());
            fondo = ImageIO.read(imagen);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen de fondo: " + e.getMessage());
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (this.tipo.equalsIgnoreCase("centrado")){
            g.drawImage(fondo, (x + (width - fondo.getWidth())/2), (y + (height - fondo.getHeight()) / 2), null);
        }else{
            g.drawImage(fondo, 0, 0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
}
