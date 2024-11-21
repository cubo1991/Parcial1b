package org.example;

public class Validaciones {
   public static boolean validarCodigoExistente (String [][] componentesPc, String codigoComponente){
       boolean codigoExistente = false;
       for(int i = 0; i < componentesPc.length; i++){
           if(componentesPc[i][0].equals(codigoComponente)){
               codigoExistente = true;
               break;
           }

       }

       return codigoExistente;
   }
    public static boolean validarCodigoRepetido (String [] codigos, String codigoComponente){
    boolean codigoRepetido = false;
    for(int i = 0; i < codigos.length; i++){
        if(codigos[i] != null && codigos[i].equals(codigoComponente)){
            codigoRepetido = true;
            break;
        }


    }
    return codigoRepetido;
    }
    public static boolean validarObligatorios (String [][] componentesPc){
       boolean obligatorios = true;
       int cantidad = 0;
        for(int i = 0; i < componentesPc.length; i++){
            if(componentesPc[i][3].equals("S")){
                cantidad++;

            }
        }
        if(cantidad < 5){
            obligatorios = false;
        }
        return obligatorios;
    }
}
