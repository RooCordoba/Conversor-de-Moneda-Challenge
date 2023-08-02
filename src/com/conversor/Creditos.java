package com.conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Creditos extends JFrame implements Conversor, ActionListener {

    @Override
    public JComponent panel() {
        JPanel panel =  new JPanel();
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame creditsFrame =  new Creditos();
        creditsFrame.setSize(600,400);
        creditsFrame.setLocationRelativeTo(null);
        creditsFrame.setTitle("Creditos del programa");
        creditsFrame.setVisible(true);
    }
}
