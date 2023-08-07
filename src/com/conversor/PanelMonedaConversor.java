package com.conversor;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelMonedaConversor implements Conversor{
    private JPanel panelPrincipal;
    private JPanel panelDeGrFa;
    private JPanel panelDeFaGr;
    private GridBagConstraints gbc;
    private static JLabel errorLabel;

    @Override
    public JComponent panel() {
        panelPrincipal = new JPanel(new GridBagLayout()); //genero un grid principal
        gbc = generateGrid(); //genero el grid bag contrait

        // panel de conversion 1
        panelDeGrFa = new JPanel(new GridBagLayout());
        generarConversor(panelDeGrFa,"De Grados a Fahrenheit" );

        // panel de conversion 2
        panelDeFaGr = new JPanel(new GridBagLayout());
        generarConversor(panelDeFaGr,"De Fahrenheit a Grados");

        panelPrincipal.add(panelDeGrFa, gbc); // agrego panel de conversor de arriba
        gbc.gridy++;
        panelPrincipal.add(panelDeFaGr, gbc); // agrego panel de conversor de abajo

        panelPrincipal.setVisible(true);
        return panelPrincipal;
    }

    // genera t0do el panel de conversion
     private void generarConversor(JPanel myPanel, String str){
        myPanel.setBorder(BorderFactory.createTitledBorder(str));

        double resTemperatura;
        String input;

        JLabel ingresaTemp = new JLabel("Ingresa la temperatura: ", SwingConstants.CENTER);
        JLabel result = new JLabel("Resultado de la conversión: ", SwingConstants.CENTER);
        errorLabel = new JLabel(" ",SwingConstants.CENTER);
        JButton convertButton = new JButton("Convertir");
        JButton resetButton = new JButton("Resetear");
        JTextField inputText = new JTextField(25);
        JTextPane resultado = new JTextPane();
        resultado.setEditable(false);

        // genera grid interno del panel
        GridBagConstraints gbc = generateGrid();

        // genero el evento del boton reset
        Botones.resetFields(resetButton, inputText, resultado, errorLabel);

        errorLabel.setForeground(Color.red);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Genero el evento para que solo me permita escribir numeros enteros y no letras
         numberOnly(inputText, errorLabel);

         // Agrego evento de conversion
         convertButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(str == "De Grados a Fahrenheit"){
                     ConversoresMoneda.convertir(1, inputText, resultado);
                 } else if(str == "De Fahrenheit a Grados"){
                     ConversoresMoneda.convertir(2, inputText, resultado);
                 }
             }
         });

         myPanel.add(ingresaTemp, gbc);
         gbc.gridx++;
         myPanel.add(inputText, gbc);
         gbc.gridy++;
         myPanel.add(errorLabel,gbc);
         gbc.gridy--;
         gbc.gridx++;
         gbc.fill = GridBagConstraints.CENTER;
         myPanel.add(convertButton, gbc);
        gbc.gridx = 0;
         gbc.gridy=+2;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         myPanel.add(result,gbc);
         gbc.gridx++;
         myPanel.add(resultado,gbc);
         gbc.gridx++;
         gbc.fill = GridBagConstraints.CENTER;
         myPanel.add(resetButton, gbc);
    }

    private GridBagConstraints generateGrid(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    private void numberOnly(JTextComponent inputText, JLabel errorLabel){
        inputText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                    errorLabel.setText("* Ingresa solo números! (dígitos del 0 al 9)");
                } else {
                    errorLabel.setText(" ");
                }
            }
        });
    }


}

