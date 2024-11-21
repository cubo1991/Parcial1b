package org.example;

public class Computadora {
    private String marca;
    private String modelo;
    private long codigoBarras;
    private double precioTotal;
    private double porcentajeAumento;
    private double montoFinal;
    private String [][] componentes;



    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPorcentajeAumento() {
        return porcentajeAumento;
    }

    public void setPorcentajeAumento(double porcentajeAumento) {
        this.porcentajeAumento = porcentajeAumento;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getComponentes() {
        return componentes;
    }

    public void setComponentes(String[][] componentes) {
        this.componentes = componentes;
    }

    public String [][] iniciarComponentes(int cantidad){
    this.componentes = new String[cantidad][4];
    this.componentes[0][0] = "Codigo Componente";
    this.componentes[0][1] = "Denominacion";
    this.componentes[0][2] = "Precio Componente";
    this.componentes[0][3] = "Es obligatorio";

    return this.componentes;
    }

    public void mostrarComponentes() {
        System.out.println("La computadora especificada es: ");

        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año: 2023");
        System.out.println();

        // Imprimir cabeceras (primera fila)
        for (String encabezado : this.componentes[0]) {
            System.out.printf("%-20s", encabezado); // Formato alineado
        }
        System.out.println(); // Línea nueva tras las cabeceras

        // Imprimir datos (resto de las filas)
        for (int i = 1; i < this.componentes.length; i++) {
            for (String valor : this.componentes[i]) {
                System.out.printf("%-20s",  valor); // Evita imprimir "null"
            }
            System.out.println(); // Línea nueva tras cada fila
        }
        System.out.println("\nTotal Componentes: " + this.precioTotal);
        System.out.println("Recargo: " + (this.porcentajeAumento * 100) + "%");
        System.out.println("Monto Final: " + this.montoFinal);

    }

    public void agregarComponente(String [][] componentesPc, String codigoComponente, int ubicacion){

        for(int i = 1; i < componentesPc.length; i++){
            if(componentesPc[i][0].equals(codigoComponente)){
                this.componentes[ubicacion][0] = codigoComponente;
                this.componentes[ubicacion][1] = componentesPc[i][1];
                this.componentes[ubicacion][2] = componentesPc[i][2];
                this.componentes[ubicacion][3] = componentesPc[i][3];

            }
        }
    }

    public void calcularPrecioTotal(){
double total= 0;
        for(int i = 1; i < this.componentes.length; i++){
            if(this.componentes[i][3].equals("S")){
                this.porcentajeAumento = 0.2;
                break;
            } else{
                this.porcentajeAumento=0;
            }

        }

        for(int i = 1; i < this.componentes.length; i++){
            total += Double.parseDouble(this.componentes[i][2]);
        }

        this.precioTotal = total;
        this.montoFinal = total + (total * this.porcentajeAumento);

    }

}
