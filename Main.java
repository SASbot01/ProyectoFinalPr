package ProyectoFinal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Cargar productos desde archivo
        List<Producto> productosCargados = GestorFicheros.cargarProductos();
        MenuPrincipal.setListaProductos(productosCargados); // pasar la lista al menú

        // Ejecutar el menú principal
        MenuPrincipal.main(args);

        // Al cerrar la aplicación, guardar productos y clientes
        GestorFicheros.guardarProductos(MenuPrincipal.getListaProductos());
        GestorFicheros.guardarClientes(MenuPrincipal.getListaPedidos());
    }
}

