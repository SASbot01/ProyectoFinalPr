package ProyectoFinal;

import java.time.LocalDate;
import java.io.Serializable;


public class Pedido implements Imprimible, Serializable {

    private String nombreCliente;
    private Producto producto;
    private int cantidad;
    private LocalDate fecha;

    public Pedido(String nombreCliente, Producto producto, int cantidad, LocalDate fecha) {
        this.nombreCliente = nombreCliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

	public void imprimir() {
        System.out.println("=================================");
        System.out.println("         TICKET DE PEDIDO        ");
        System.out.println("=================================");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Producto: " + producto.nombre);
        System.out.printf("Precio unitario: %.2f €\n", producto.precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.printf("Total: %.2f €\n", producto.precio * cantidad);
        System.out.println("Fecha del pedido: " + fecha);
        System.out.println("Estado del producto: " + producto.estado);
        System.out.println("Fecha de caducidad: " + producto.obtener_caducidad());
        System.out.println("=================================\n");
    }

	public String getNombreCliente() {
	    return this.nombreCliente;
	}
}
