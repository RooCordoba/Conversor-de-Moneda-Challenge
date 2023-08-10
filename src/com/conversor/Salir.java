package com.conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Salir implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane pane = new JOptionPane();
        Object[] options = {"Si, quiero salir", "No, quiero quedarme"};
        Integer usersInput = JOptionPane.showOptionDialog(null, "Seguro que deseas salir?",
                "Saliendo",0,3, null,options,options[0]);
        if (usersInput == 0){
            System.exit(0);
        }
    }
}
