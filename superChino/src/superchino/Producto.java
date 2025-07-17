/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superchino;

/**
 *
 * @author HP
 */

public class Producto {

    // Atributos del producto
    private String codigoProducto;
    private String nombreProducto;
    private String tipoProducto;
    private int cantidad;
    private double precioBase;
    private double precioBruto;
    private double gananciaEsperada;
    private String nombreEmpleado;

    // Constructor para crear producto 
    public Producto(String codigoProducto, String nombreProducto, String tipoProducto, int cantidad, double precioBase, String nombreEmpleado) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.nombreEmpleado = nombreEmpleado;

        calcularPrecioBrutoYGanancia();

    }

    // Método para calcular el precio bruto y la ganancia
    private void calcularPrecioBrutoYGanancia() {
        precioBruto = switch (tipoProducto.toLowerCase()) {
            case "alimentos" -> precioBase * 0.20 + precioBase;
            case "bebidas" -> precioBase * 0.30 + precioBase;
            case "higiene" -> precioBase * 0.25 + precioBase + 500;
            case "limpieza" -> precioBase * 0.19 + precioBase * 0.04 + 1000 + precioBase;
            default -> precioBase;
        };
        gananciaEsperada = (precioBruto - precioBase) * cantidad;
    }

    // Danancia del producto
    public double getGananciaEsperada() {
        return gananciaEsperada;
    }

    public String toString() {
        return "Código: " + codigoProducto
                + " Nombre: " + nombreProducto
                + " Tipo: " + tipoProducto
                + " Cantidad: " + cantidad
                + " Precio Base: " + precioBase
                + " Precio Bruto: " + precioBruto
                + " Ganancia Esperada: " + gananciaEsperada
                + " Empleado: " + nombreEmpleado;
    }
}
