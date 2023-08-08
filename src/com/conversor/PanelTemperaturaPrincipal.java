package com.conversor;

import javax.swing.*;
import java.awt.*;

public class PanelTemperaturaPrincipal {
    private JPanel panelPrincipal;
    private PanelTemperatura panelDeGrFa;
    private PanelTemperatura panelDeFaGr;
    private GridBagConstraints gbc;

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public PanelTemperaturaPrincipal() {
        panelPrincipal = new JPanel(new GridBagLayout());
        gbc = Funciones.generateGrid();
        gbc.fill = GridBagConstraints.BOTH;

        panelDeGrFa = new PanelTemperatura(1, "De Grados a Fahrenheit");
        panelDeFaGr = new PanelTemperatura(2, "De Fahrenheit a Grados");
        panelPrincipal.add(panelDeGrFa.getPanelPrincipal(), gbc); // agrego panel de conversor de arriba
        gbc.gridy++;
        panelPrincipal.add(panelDeFaGr.getPanelPrincipal(), gbc); // agrego panel de conversor de abajo
        panelPrincipal.setVisible(true);
    }
}

