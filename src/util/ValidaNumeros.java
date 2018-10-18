package util;

import java.awt.event.KeyEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author hmera
 */
public class ValidaNumeros extends PlainDocument {

    private int tipo = 0;
    public static int ACEPTA_DECIMAL = 1;
    public static int ACEPTA_CARACTER = 1;

    public ValidaNumeros() {
    }

    public ValidaNumeros(int tipo) {
        this.tipo = tipo;
    }

    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
        if (this.tipo == ACEPTA_CARACTER) {
            if (validaCaracter(arg1)) {
                super.insertString(arg0, arg1, arg2);
            }
        } else if (this.tipo == ACEPTA_DECIMAL) {
            if (validaDecimal(arg1)) {
                super.insertString(arg0, arg1, arg2);
            }
        } else {
            if (validaEntero(arg1)) {
                super.insertString(arg0, arg1, arg2);
            }
        }

    }

    public boolean validaEntero(String text) {
        //System.out.println(text);
        char caracter = text.charAt(0);

        if (((caracter < '0') || (caracter > '9')) && caracter != KeyEvent.VK_BACK_SPACE) {
            return false;
        } else {
            return true;
        }

    }

    public boolean validaDecimal(String text) throws BadLocationException {
        //System.out.println( "Texto:" + getText(0, this.getLength()));

        char caracter = text.charAt(0);

        if (super.getText(0, super.getLength()).contains(".")) {
            if (caracter == '.') {
                return false;
            }

        }

        if (((caracter < '0') || (caracter > '9')) && caracter != KeyEvent.VK_BACK_SPACE && caracter != '.') {
            return false;
        } else {
            return true;
        }

    }

    public boolean validaCaracter(String text) throws BadLocationException {
        //System.out.println( "Texto:" + getText(0, this.getLength()));

        char caracter = text.charAt(0);

        if (super.getText(0, super.getLength()).contains("-")) {
            if (caracter == '-') {
                return false;
            }

        }

        if (((caracter < '0') || (caracter > '9')) && caracter != KeyEvent.VK_BACK_SPACE && caracter != '-') {
            return false;
        } else {
            return true;
        }

    }

}
