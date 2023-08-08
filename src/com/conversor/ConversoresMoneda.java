package com.conversor;
import javax.swing.*;

class ConversoresMoneda implements Conversor {
    protected ConversoresMoneda(){

    }
    @Override
    public JComponent panel(){
        JPanel panel = new JPanel();
        return panel;
    }
}
