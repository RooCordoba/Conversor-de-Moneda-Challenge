package com.conversor;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private JComponent panel;// panel con todas mis solapitas
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item1, item2, item3;
    private JButton button1;

    public Ventana(){
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("Conversor de Moneda y Temperatura");

        menuBar = new JMenuBar();
        menu = new JMenu("Opciones");
        item1 = new JMenuItem("Ver Créditos");
        item2 = new JMenuItem("Salir");
        menu.add(item1); menu.add(item2);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        panel = hacerPaneles();
        getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        actionListenersProgram();
    }

    public void actionListenersProgram(){
        ActionListener verCreditoAL = new Creditos();
        item1.addActionListener(verCreditoAL);
        ActionListener salirAL = new Salir();
        item2.addActionListener(salirAL);
    }

    private JComponent hacerPaneles(){
        JTabbedPane tabbedPane = new JTabbedPane();
        //tabbedPane.putClientProperty("jgoodies.noContentBorder", Boolean.TRUE);
        tabbedPane.add("Conversor de Moneda", new PanelMonedaConversor().panel());
        tabbedPane.add("Conversor de Temperatura", new TemperaturaConversor().panel());
        return tabbedPane;
    }

}
