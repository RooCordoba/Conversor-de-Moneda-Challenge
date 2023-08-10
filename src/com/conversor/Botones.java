package com.conversor;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones {

    // hace que los campos del texto a introducir y el de resultado se reseteen
    protected static void resetFields(JButton button, JTextComponent field1, JTextComponent field2, JLabel errorField){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field1.setText("");
                field2.setText("");
                errorField.setText(" ");
            }
        });
    }

    protected static void convertField(JTextComponent field, double number){
        field.setText("");
        field.setText(String.valueOf(number));
    }
}
