package ProyectoFinal;

import java.time.LocalDate;
import java.util.List;

public class CartaProductos {

    public static void mostrarCarta(List<Producto> productos) {
        LocalDate hoy = LocalDate.now();

        for (Producto p : productos) {
            LocalDate caducidad = p.obtener_caducidad();

            // Si está caducado
            if (caducidad.isBefore(hoy)) {
                p.estado = "CADUCADO";
                continue; // No lo mostramos
            }

            // Si está a punto de caducar (<5 días)
            if (!caducidad.isBefore(hoy) && caducidad.isBefore(hoy.plusDays(5))) {
                System.out.println("🟡 OFERTA 🟡");
                System.out.println("Nombre: " + p.nombre);
                System.out.printf("Precio (con 30%% descuento): %.2f €\n", p.precio * 0.7);
                p.detalle_producto();
                System.out.println("-------------------------");
            }

            // Si no hay problemas de caducidad
            else {
                System.out.println("Nombre: " + p.nombre);
                System.out.printf("Precio: %.2f €\n", p.precio);
                p.detalle_producto();
                System.out.println("-------------------------");
            }
        }
    }
}

