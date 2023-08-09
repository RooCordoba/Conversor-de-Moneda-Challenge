package com.conversor;

import javax.swing.*;
import java.awt.*;

public class PanelMonedaPrincipal {
    private JPanel panel;
    private GridBagConstraints gbc;
    private JMenuBar menuBar;
    private JMenu menu;
    private JLabel tipoConversion;
    private JTextField inputArea;
    private JButton convertButton;
    private JButton resetButton;
    private JLabel errorField;
    private JFrame frame = new JFrame();

    public JFrame getFrame() {
        return frame;
    }
    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public JLabel getTipoConversion() {
        return tipoConversion;
    }

    public void setTipoConversion(String str) {
        this.tipoConversion.setText(str);
    }

    public JTextField getInputArea() {
        return inputArea;
    }

    public void setInputArea(JTextField inputArea) {
        this.inputArea = inputArea;
    }

    public JButton getConvertButton() {
        return convertButton;
    }

    public void setConvertButton(JButton convertButton) {
        this.convertButton = convertButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    public JLabel getErrorField() {
        return errorField;
    }

    public void setErrorField(String str) {
        this.errorField.setText(str);
    }

    public PanelMonedaPrincipal(){
        panel = new JPanel(new GridBagLayout());
        inputArea = new JTextField(20);
        inputArea.setEditable(false);
        tipoConversion = new JLabel("Antes elija el tipo de conversion: ");
        menuBar = new JMenuBar();
        menu = new JMenu("Elija una opcion de conversión");
        convertButton = new JButton("Convertir");
        errorField = new JLabel(" ");
        resetButton = new JButton("Reset");

        gbc = Funciones.generateGrid();

        gbc.fill = SwingConstants.CENTER;
        gbc.gridx++;
        panel.add(menuBar, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(tipoConversion,gbc);
        gbc.gridx++;
        panel.add(inputArea,gbc);
        gbc.gridx++;
        panel.add(convertButton,gbc);
        gbc.gridy++;
        gbc.gridx=1;
        panel.add(errorField,gbc);
        gbc.gridx++;
        panel.add(resetButton, gbc);

        panel.setVisible(true);
        String[] possibilities = {"De Pesos a Dolar", "De Pesos a Euro", "De pesos a Libras", "De Pesos a Yen",
                                  "De Pesos a Won Coreano", "De Dolar a Pesos", "De Euro a Pesos", "De Libras a Pesos",
                                  "De Yen a Pesos", "De Won Coreano a Pesos"};
        for (int i=0;i<possibilities.length;i++) {
            menu.add(new JMenuItem(possibilities[i]));
        }
        Funciones.numberOnly(inputArea, errorField); // evento error solo numeros
        resetButtonEvent(resetButton); // evento del boton reset
        ConversoresMoneda.seleccionarOpcion(this); // evento seleccion de opcion
        menuBar.add(menu,gbc);
    }

    private void resetButtonEvent(JButton button){
        button.addActionListener(e ->{
            this.tipoConversion.setText("Antes elija el tipo de conversion: ");
            this.errorField.setText(" ");
            this.inputArea.setText("");
            this.inputArea.setEditable(false);
        });
    }
}
