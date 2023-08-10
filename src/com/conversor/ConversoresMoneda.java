package com.conversor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConversoresMoneda {

    protected static void seleccionarOpcion(PanelMonedaPrincipal panel){
        for (int i =0 ; i< panel.getMenu().getItemCount(); i++){
            int finalI = i;
            panel.getMenu().getItem(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setErrorField(" ");
                    panel.setSelectedItem(finalI);
                    panel.setTipoConversion("Convertir " + panel.getMenu().getItem(finalI).getText());
                    panel.getInputArea().setEditable(true);
                    panel.getConvertButton().setEnabled(true);
                }
            });
        };
    }

    protected static void conversion(PanelMonedaPrincipal panel){
            panel.getConvertButton().addActionListener(e -> {
                if(panel.getInputArea().getText().trim().isEmpty()){
                    Funciones.inputVacioError(panel.getErrorField());
                } else {
                    Double inputNumber = Double.parseDouble(panel.getInputArea().getText());
                    switch (panel.getSelectedItem()){

                        case 0:
                            inputNumber = inputNumber*0.0035;
                            break;
                        case 1:
                            inputNumber = inputNumber*0.0032;
                            break;
                        case 2:
                            inputNumber = inputNumber*0.000007;
                            break;
                        case 3:
                            inputNumber = inputNumber*0.24;
                            break;
                        case 4:
                            inputNumber = inputNumber*2.22;
                            break;
                        case 5:
                            inputNumber = inputNumber*592.96;
                            break;
                        case 6:
                            inputNumber = inputNumber*650.30;
                            break;
                        case 7:
                            inputNumber = inputNumber*755.49;
                            break;
                        case 8:
                            inputNumber = inputNumber*4.14;
                            break;
                        case 9:
                            inputNumber = inputNumber*0.45;
                            break;
                        default:
                            break;
                    }
                    JOptionPane.showMessageDialog(panel.getPanelConversor(), "La conversion es: $"+inputNumber,
                            panel.getMenu().getItem(panel.getSelectedItem()).getText(),JOptionPane.INFORMATION_MESSAGE);
                }
            });
    }
}
