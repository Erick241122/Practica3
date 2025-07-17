/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superchino;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */

public class Inventario {

    private String nombreSuper;
    private String codigoSuper;
    private String nombreEmpleado;
    private String cedulaEmpleado;

    // Arreglo de productos
    private Producto[] productos;

    // Registrar los datos del supermercado y del empleado
    public void registrarSupermercadoYEmpleado() {
        nombreSuper = JOptionPane.showInputDialog("Nombre del Supermercado:");
        codigoSuper = JOptionPane.showInputDialog("Código del Supermercado:");
        nombreEmpleado = JOptionPane.showInputDialog("Nombre del empleado:");
        cedulaEmpleado = JOptionPane.showInputDialog("Cédula del empleado:");
    }

    // Agregar productos al inventario
    public void agregarProductos() {
        int cantidadProductos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos productos desea ingresar?"));
        productos = new Producto[cantidadProductos];

        for (int i = 0; i < cantidadProductos; i++) {
            // Solicitar los datos de cada producto
            String codigoProducto = JOptionPane.showInputDialog("Ingrese código del producto #" + (i + 1));
            String nombreProducto = JOptionPane.showInputDialog("Ingrese nombre del producto #" + (i + 1));
            String tipoProducto = JOptionPane.showInputDialog("Tipo (alimentos, bebidas, higiene, limpieza):");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos a ingresar:"));
            double precioBase = Double.parseDouble(JOptionPane.showInputDialog("Precio base del producto:"));
            productos[i] = new Producto(
                    codigoProducto,
                    nombreProducto,
                    tipoProducto,
                    cantidad,
                    precioBase,
                    nombreEmpleado
            );
        }
    }

    //muestra todos los productos agregados y la ganancia total
    public void mostrarProductos() {
        // Datos del supermercado y el empleado
        String resumen = "Supermercado: " + nombreSuper + " (Código: " + codigoSuper + ")\n";
        resumen += "Empleado: " + nombreEmpleado + " | Cédula: " + cedulaEmpleado + "\n\n";
        resumen += "Productos registrados:\n\n";

        double gananciaTotal = 0;

        // Recorre todos los productos y los agrega
        for (Producto producto : productos) {
            resumen += producto.toString() + "\n\n";
            gananciaTotal += producto.getGananciaEsperada(); 
        }

        // Mostrar la ganancia total esperada
        resumen += "Ganancia total esperada: " + gananciaTotal;

        // Mostrar todo en una ventana
        JOptionPane.showMessageDialog(null, resumen);
    }
}
