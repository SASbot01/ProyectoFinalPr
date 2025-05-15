package ProyectoFinal;

import java.io.Serializable;
import java.time.LocalDate;

public class Bebida extends Producto implements Serializable {

    private boolean gaseoso;
    private boolean lacteo;
    private String medida;

    public Bebida(String nombre, Double precio, LocalDate fecha_caducidad, String estado,
                  boolean gaseoso, boolean lacteo, String medida) {
        super(nombre, precio, fecha_caducidad, estado);
        this.gaseoso = gaseoso;
        this.lacteo = lacteo;
        this.medida = medida;
    }

    
    public LocalDate obtener_caducidad() {
        if (lacteo) {
            return fecha_caducidad.plusDays(10);
        } else {
            return fecha_caducidad.plusDays(20);
        }
    }

    
    public void detalle_producto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Fecha de caducidad: " + obtener_caducidad());
        System.out.println("Estado: " + estado);
        System.out.println("Gaseoso: " + gaseoso);
        System.out.println("Lácteo: " + lacteo);
        System.out.println("Medida: " + medida);
    }
}
