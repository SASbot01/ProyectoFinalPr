package ProyectoFinal;


import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestorFicheros {

    private static final String RUTA_PRODUCTOS = "productos.dat";
    private static final String RUTA_CLIENTES = "clientes.txt";

    // Guardar lista de productos en archivo binario
    public static void guardarProductos(List<Producto> productos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_PRODUCTOS))) {
            oos.writeObject(productos);
            System.out.println("✅ Productos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar productos: " + e.getMessage());
        }
    }

    // Cargar lista de productos desde archivo binario
    public static List<Producto> cargarProductos() {
        File archivo = new File(RUTA_PRODUCTOS);
        if (!archivo.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_PRODUCTOS))) {
            return (List<Producto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error al cargar productos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Guardar lista de clientes únicos en archivo de texto
    public static void guardarClientes(List<Pedido> pedidos) {
        Set<String> clientes = new HashSet<>();
        for (Pedido p : pedidos) {
            clientes.add(p.getNombreCliente());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_CLIENTES))) {
            for (String cliente : clientes) {
                writer.write(cliente);
                writer.newLine();
            }
            System.out.println("✅ Clientes guardados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar clientes: " + e.getMessage());
        }
    }

    // Cargar clientes desde archivo de texto (opcional)
    public static List<String> cargarClientes() {
        List<String> clientes = new ArrayList<>();

        File archivo = new File(RUTA_CLIENTES);
        if (!archivo.exists()) return clientes;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                clientes.add(linea);
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer clientes: " + e.getMessage());
        }

        return clientes;
    }
}

