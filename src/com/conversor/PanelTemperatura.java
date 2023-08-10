package com.conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTemperatura{
    private int id;
    private JPanel panelPrincipal;
    private JLabel ingresaTemp;
    private JLabel result;
    private GridBagConstraints gbc;
    private JButton resetButton;
    private JTextField inputText;
    private JTextPane resultado;
    private JButton convertButton;
    private JLabel errorLabel;

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public int getId() {
        return id;
    }

    public PanelTemperatura(int id, String str){
        panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createTitledBorder(str));

        this.id = id;

        ingresaTemp = new JLabel("Ingresa la temperatura: ", SwingConstants.CENTER);
        result = new JLabel("Resultado de la conversión: ", SwingConstants.CENTER);
        errorLabel = new JLabel(" ",SwingConstants.CENTER);
        convertButton = new JButton("Convertir");
        resetButton = new JButton("Resetear");
        inputText = new JTextField(25);
        resultado = new JTextPane();
        resultado.setEditable(false);

        gbc = Funciones.generateGrid();

        panelPrincipal.add(ingresaTemp, gbc);
        gbc.gridx++;
        panelPrincipal.add(inputText, gbc);
        gbc.gridy++;
        panelPrincipal.add(errorLabel,gbc);
        gbc.gridy--;
        gbc.gridx++;
        gbc.fill = GridBagConstraints.CENTER;
        panelPrincipal.add(convertButton, gbc);
        gbc.gridx = 0;
        gbc.gridy=+2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(result,gbc);
        gbc.gridx++;
        panelPrincipal.add(resultado,gbc);
        gbc.gridx++;
        gbc.fill = GridBagConstraints.CENTER;
        panelPrincipal.add(resetButton, gbc);

        // Genero el evento para que solo me permita escribir numeros enteros y no letras
        Funciones.numberOnly(inputText, errorLabel);

        // genero el evento del boton reset
        Botones.resetFields(resetButton, inputText, resultado, errorLabel);

        // genero el evento de conversion de temperatura
        convertTemperatureEvent(convertButton);
    }

    private void convertTemperatureEvent(JButton convertButton){
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = inputText.getText();
                if (in.trim().isEmpty()){
                    Funciones.inputVacioError(errorLabel);
                } else {
                    ConversoresTemperatura.convertir(getId(), inputText,resultado);
                }
            }
        });
    }




}
