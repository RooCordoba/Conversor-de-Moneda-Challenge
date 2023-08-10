package com.conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Creditos extends JFrame implements ActionListener{

    private JPanel panel;
    String git = "https://github.com/RooCordoba";
    String lkin = "https://www.linkedin.com/in/rocio-cordoba/";
    private JLabel titulo, nombre, gitHub, linkedIn;
    private JButton gitHubCopiar, linkedInCopiar;


    @Override
    public void actionPerformed(ActionEvent e) {
        setSize(600,400);
        setLocationRelativeTo(null);
        setTitle("Creditos del programa");
        setVisible(true);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = Funciones.generateGrid();
        titulo = new JLabel("Challenge de Alura para el curso Oracle ONE");
        nombre = new JLabel("Hecho por Rocio Córdoba -2023");
        gitHub = new JLabel("Mi Github: " + git);
        linkedIn = new JLabel("Mi LinkedIn: " + lkin);
        gitHubCopiar = new JButton("Copiar Github al clipboard");
        linkedInCopiar = new JButton("Copiar LinkedIn al clipboard");

        gbc.fill = GridBagConstraints.CENTER;
        panel.add(titulo,gbc);
        gbc.gridx++;
        panel.add(nombre, gbc);
        gbc.gridy++;
        gbc.gridx =0;
        panel.add(gitHub, gbc);
        gbc.gridx++;
        panel.add(linkedIn,gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(gitHubCopiar, gbc);
        gbc.gridx++;
        panel.add(linkedInCopiar,gbc);

        this.add(panel);


        gitHubCopiar.addActionListener( e1 ->{
            copiarAlClipboar(git);
        });
        linkedInCopiar.addActionListener(e2 ->{
            copiarAlClipboar(lkin);
        });
    }

    private void copiarAlClipboar(String str){
        StringSelection ss = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(ss,null);
        JOptionPane copiado = new JOptionPane();
        JOptionPane.showMessageDialog(copiado, "Link Copiado al portapapeles! :)", "Copiado con exito", JOptionPane.INFORMATION_MESSAGE);
    }
}
