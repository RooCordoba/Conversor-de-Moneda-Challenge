package com.conversor;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Funciones {
    protected static void numberOnly(JTextComponent inputText, JLabel errorLabel){
        inputText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                    errorLabel.setForeground(Color.red);
                    errorLabel.setText("* Ingresa solo números! (dígitos del 0 al 9)");
                } else {
                    errorLabel.setText(" ");
                }
            }
        });
    }

    protected static GridBagConstraints generateGrid(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    public static void setErrorLabel(JLabel errorLabel, String str) {
        errorLabel.setText(str);
    }
    protected static void inputVacioError(JLabel errorLabel){
        errorLabel.setForeground(Color.red);
        Toolkit.getDefaultToolkit().beep();
        setErrorLabel(errorLabel, "* Ingresar al menos un numero");
    }
}
