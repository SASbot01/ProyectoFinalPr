package ProyectoFinal;

import java.time.LocalDate;
import java.io.Serializable;


public class Comida extends Producto implements Serializable {

    private boolean perecedero;
    private float calorias;
    private boolean vegano;
    private LocalDate fecha_envase;

    public Comida(String nombre, Double precio, LocalDate fecha_caducidad, String estado,
                  boolean perecedero, float calorias, boolean vegano, LocalDate fecha_envase) {
        super(nombre, precio, fecha_caducidad, estado);
        this.perecedero = perecedero;
        this.calorias = calorias;
        this.vegano = vegano;
        this.fecha_envase = fecha_envase;
    }

    
    public LocalDate obtener_caducidad() {
        if (perecedero) {
            return fecha_envase.plusDays(10);
        } else {
            return fecha_caducidad;
        }
    }

    
    public void detalle_producto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Fecha de caducidad: " + obtener_caducidad());
        System.out.println("Estado: " + estado);
        System.out.println("Perecedero: " + perecedero);
        System.out.println("Calorías: " + calorias);
        System.out.println("Vegano: " + vegano);
        System.out.println("Fecha de envasado: " + fecha_envase);
    }
}
