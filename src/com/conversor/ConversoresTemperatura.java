package com.conversor;

import javax.swing.text.JTextComponent;

public class ConversoresTemperatura {
    public static void convertir(int option,
                                 JTextComponent inputTextField,
                                 JTextComponent outputTextField){
        double myOutputResult;
        String myInput = inputTextField.getText();

        if (option == 1){
            myOutputResult = deGradosAFahrenheit(myInput);
            Botones.convertField(outputTextField, myOutputResult);
        } else if(option == 2){
            myOutputResult = deFahrenheitAGrados(myInput);
            Botones.convertField(outputTextField, myOutputResult);
        }
    }

    public static double deGradosAFahrenheit(String grados){
        double res = Double.parseDouble(grados);
        return (res*1.8)+32;
    }
    protected static double deFahrenheitAGrados(String fahrenheit){
        double res = Double.parseDouble(fahrenheit);
        return (res-32)/1.8;
    }
}
