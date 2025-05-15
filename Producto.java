package ProyectoFinal;

import java.time.LocalDate;
import java.io.Serializable;


public abstract class Producto implements Serializable {


    protected String nombre;
    protected Double precio;
    protected LocalDate fecha_caducidad;
    protected String estado;

    public Producto(String nombre, Double precio, LocalDate fecha_caducidad, String estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha_caducidad = fecha_caducidad;
        this.estado = estado;
    }

    // Método abstracto para obtener la fecha real de caducidad
    public abstract LocalDate obtener_caducidad();

    // Método abstracto para mostrar los detalles del producto
    public abstract void detalle_producto();
}
