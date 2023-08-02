package com.conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{

    private JComponent panel;// panel con todas mis solapitas
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item1, item2, item3;
    private JButton button1;

    public Ventana(){
        setSize(600, 400);
        setTitle("Conversor de Moneda y Temperatura");
        panel = this.hacerPaneles();
        this.getContentPane().add(panel);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //JPanel panel = new JPanel();


        //mostrarMenu();

        //panel.add(menuBar);
        //add(panel);
    }
    public void mostrarMenu(){
        // inicializo los atributos
        menuBar = new JMenuBar();
        menu = new JMenu("Elija una opcion válida");
        item1 = new JMenuItem("De grados a fahrenheit");
        item2 = new JMenuItem("De a fahrenheit a grados");
        item3 = new JMenuItem("Salir");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menuBar.add(menu);

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                button1 = new JButton("aceptar");
                button1.setVisible(true);
            }
        });

        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = new JOptionPane();
                Object[] options = {"Si, quiero salir", "No, quiero quedarme"};
                Integer s = JOptionPane.showOptionDialog(null, "Seguro que deseas salir?",
                        "Saliendo",0,3, null,options,options[0]);
                if (s == 0){
                    System.exit(0);
                }
            }
        });
    }

    private JComponent hacerPaneles(){
        JTabbedPane tabbedPane = new JTabbedPane();
        //tabbedPane.putClientProperty("jgoodies.noContentBorder", Boolean.TRUE);
        tabbedPane.add("Conversor de Moneda", new MonedaConversor().panel());
        tabbedPane.add("Conversor de Temperatura", new TemperaturaConversor().panel());
        tabbedPane.add("Créditos :)", new Creditos().panel());
        return tabbedPane;
    }
}
