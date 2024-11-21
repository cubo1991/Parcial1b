package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GeneraPc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de componentes disponibles
        String[][] componentesPc = {
                {"AAA", "Placa Madre", "20000", "S"},
                {"BBB", "Procesador", "25000", "S"},
                {"CCC", "Memoria RAM", "5000", "S"},
                {"DDD", "Placa de Red", "3000", "N"},
                {"EEE", "Disco Rigido SSD", "22000", "S"},
                {"FFF", "Placa de Video", "42000", "N"},
                {"GGG", "Monitor Led 21", "32000", "N"},
                {"HHH", "Monitor Led 25", "41000", "N"},
                {"JJJ", "Kit Teclado - Mouse", "9000", "N"},
                {"KKK", "Gabinete", "6500", "S"},
                {"LLL", "Fuente Alimentación", "6500", "S"},
                {"MMM", "Placa de Sonido", "16500", "N"}
        };

        //Instanciamos Computadora
        Computadora pc = new Computadora();
        int cantidadComponentes = 0;


        System.out.println("Ingrese marca");
        pc.setMarca(sc.nextLine());
        System.out.println("ingrese modelo");
        pc.setModelo(sc.nextLine());

        //Pedimos con validacion un codigo de barra
        System.out.println("ingrese codigo de barras");
        while(true){
            String codigoBarras = sc.nextLine();
            if(codigoBarras.length() < 7 || codigoBarras.length() > 15){
                System.out.println("Ingrese un valor entre 7 y 15 caracteres");

            }
            else{
                pc.setCodigoBarras(Long.parseLong(codigoBarras));
                break;
            }
        }



        //Solicitamos la cantidad de componentes que va a tener la computadora
        System.out.println("Ingrese la cantidad de componentes de la computadora. Entre 5 y 12 componentes");
        while (true){
          cantidadComponentes = Integer.parseInt(sc.nextLine());
            if(cantidadComponentes < 5 || cantidadComponentes > 12){
                System.out.println("Ingrese un valor corrrecto");

            }
            else{

                break;
            }

    }

        //Inicializamos componentes de la clase computadora
        pc.iniciarComponentes(cantidadComponentes);

        pc.mostrarComponentes();
       //Solicitamos el ingreso de los componentes
        System.out.println("Componentes de la Computadora");

        int contadorComponentes = 0;
        String [] codigosIngresados = new String[cantidadComponentes];
        do{
            System.out.println("Ingrese codigo del componente");
            String codigoComponente = sc.nextLine();
            if(!Validaciones.validarCodigoExistente(componentesPc, codigoComponente.toUpperCase())){
                System.out.println("El codigo ingresao es incorrecto");
            } else if (Validaciones.validarCodigoRepetido(codigosIngresados, codigoComponente.toUpperCase())) {
                System.out.println("El codigo ya fue ingresado");

            } else{
                codigosIngresados[contadorComponentes] = codigoComponente.toUpperCase();
                pc.agregarComponente(componentesPc, codigoComponente.toUpperCase(), contadorComponentes);
                contadorComponentes++;
                pc.mostrarComponentes();
            }



        }while (contadorComponentes < cantidadComponentes);

        if(!Validaciones.validarObligatorios(pc.getComponentes())){
            System.out.println("Atención, 1 o más de los componentes obligatorios no fueron agregados, por este motivo se cobrara un recargo del 20%");

        }
       pc.calcularPrecioTotal();
        //mostrar la matriz
        pc.mostrarComponentes();



        }
    }
