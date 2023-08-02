package com.conversor;
import javax.swing.*;

class TemperaturaConversor implements Conversor {
    protected TemperaturaConversor(){

    }
    @Override
    public JComponent panel(){
        JPanel panel = new JPanel();
        return panel;
    }
}
