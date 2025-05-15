package ProyectoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static List<Producto> listaProductos = new ArrayList<>();
    private static List<Pedido> listaPedidos = new ArrayList<>();

    public static List<Producto> getListaProductos() {
        return listaProductos;
    }

    public static List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public static void setListaProductos(List<Producto> productos) {
        listaProductos = productos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcionPrincipal = 0;

        do {
            System.out.println("\n======= MENÚ PRINCIPAL =======");
            System.out.println("1. Gestión de Pedidos");
            System.out.println("2. Gestión de Productos");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuGestionPedidos(sc, listaProductos, listaPedidos);
                    break;
                case 2:
                    menuGestionProductos(sc, listaProductos);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcionPrincipal != 3);

        sc.close();
    }

    public static void menuGestionPedidos(Scanner sc, List<Producto> listaProductos, List<Pedido> listaPedidos) {
        int opcionSubmenu;

        do {
            System.out.println("\n--- Gestión de Pedidos ---");
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Borrar Pedido");
            System.out.println("3. Ver Pedidos");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcionSubmenu = sc.nextInt();

            switch (opcionSubmenu) {
                case 1:
                    sc.nextLine();
                    if (listaProductos.isEmpty()) {
                        System.out.println("⚠️ No hay productos disponibles para crear un pedido.");
                        break;
                    }

                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = sc.nextLine();

                    System.out.println("Selecciona un producto:");
                    for (int i = 0; i < listaProductos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaProductos.get(i).nombre);
                    }
                    System.out.print("Opción: ");
                    int productoIndex = sc.nextInt() - 1;

                    if (productoIndex < 0 || productoIndex >= listaProductos.size()) {
                        System.out.println("❌ Producto no válido.");
                        break;
                    }

                    Producto productoSeleccionado = listaProductos.get(productoIndex);

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    LocalDate fecha = LocalDate.now();

                    Pedido nuevoPedido = new Pedido(nombreCliente, productoSeleccionado, cantidad, fecha);
                    listaPedidos.add(nuevoPedido);
                    System.out.println("✅ Pedido creado con éxito:");
                    nuevoPedido.imprimir();
                    break;

                case 2:
                    if (listaPedidos.isEmpty()) {
                        System.out.println("⚠️ No hay pedidos para borrar.");
                        break;
                    }
                    System.out.println("Selecciona el número del pedido a borrar:");
                    for (int i = 0; i < listaPedidos.size(); i++) {
                        System.out.println((i + 1) + ". Pedido de " + listaPedidos.get(i).getNombreCliente());
                    }
                    System.out.print("Opción: ");
                    int borrarIndex = sc.nextInt() - 1;
                    if (borrarIndex < 0 || borrarIndex >= listaPedidos.size()) {
                        System.out.println("❌ Índice inválido.");
                        break;
                    }
                    listaPedidos.remove(borrarIndex);
                    System.out.println("✅ Pedido borrado correctamente.");
                    break;

                case 3:
                    if (listaPedidos.isEmpty()) {
                        System.out.println("⚠️ No hay pedidos para mostrar.");
                    } else {
                        System.out.println("📋 Lista de Pedidos:");
                        for (int i = 0; i < listaPedidos.size(); i++) {
                            System.out.println((i + 1) + ".");
                            listaPedidos.get(i).imprimir();
                        }
                    }
                    break;

                case 4:
                    System.out.println("🔁 Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcionSubmenu != 4);
    }

    public static void menuGestionProductos(Scanner sc, List<Producto> listaProductos) {
        int opcionSubmenu = 0;

        do {
            System.out.println("\n--- Gestión de Productos ---");
            System.out.println("1. Añadir Producto");
            System.out.println("2. Borrar Producto");
            System.out.println("3. Ver Productos");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcionSubmenu = sc.nextInt();

            switch (opcionSubmenu) {
                case 1:
                    System.out.println("¿Qué tipo de producto quieres añadir?");
                    System.out.println("1. Comida");
                    System.out.println("2. Bebida");
                    int tipoProducto = sc.nextInt();
                    sc.nextLine(); // limpiar buffer

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Año de caducidad: ");
                    int a = sc.nextInt();
                    System.out.print("Mes: ");
                    int m = sc.nextInt();
                    System.out.print("Día: ");
                    int d = sc.nextInt();
                    LocalDate fechaCaducidad = LocalDate.of(a, m, d);

                    sc.nextLine(); // limpiar buffer
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();

                    if (tipoProducto == 1) {
                        System.out.print("¿Es perecedero? (true/false): ");
                        boolean perecedero = sc.nextBoolean();

                        System.out.print("Calorías: ");
                        float calorias = sc.nextFloat();

                        System.out.print("¿Es vegano? (true/false): ");
                        boolean vegano = sc.nextBoolean();

                        System.out.print("Año de envasado: ");
                        int ae = sc.nextInt();
                        System.out.print("Mes: ");
                        int me = sc.nextInt();
                        System.out.print("Día: ");
                        int de = sc.nextInt();
                        LocalDate fechaEnvase = LocalDate.of(ae, me, de);

                        Producto nuevaComida = new Comida(nombre, precio, fechaCaducidad, estado, perecedero, calorias, vegano, fechaEnvase);
                        listaProductos.add(nuevaComida);
                        System.out.println("✅ Comida añadida correctamente.");

                    } else if (tipoProducto == 2) {
                        System.out.print("¿Es gaseosa? (true/false): ");
                        boolean gaseoso = sc.nextBoolean();

                        System.out.print("¿Es láctea? (true/false): ");
                        boolean lacteo = sc.nextBoolean();

                        sc.nextLine(); // limpiar buffer
                        System.out.print("Medida (cc): ");
                        String medida = sc.nextLine();

                        Producto nuevaBebida = new Bebida(nombre, precio, fechaCaducidad, estado, gaseoso, lacteo, medida);
                        listaProductos.add(nuevaBebida);
                        System.out.println("✅ Bebida añadida correctamente.");
                    }
                    break;

                case 2:
                    if (listaProductos.isEmpty()) {
                        System.out.println("⚠️ No hay productos para borrar.");
                        break;
                    }
                    System.out.println("Selecciona el número del producto a borrar:");
                    for (int i = 0; i < listaProductos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaProductos.get(i).nombre);
                    }
                    System.out.print("Opción: ");
                    int borrarIndex = sc.nextInt() - 1;
                    if (borrarIndex < 0 || borrarIndex >= listaProductos.size()) {
                        System.out.println("❌ Índice inválido.");
                        break;
                    }
                    listaProductos.remove(borrarIndex);
                    System.out.println("✅ Producto borrado correctamente.");
                    break;

                case 3:
                    if (listaProductos.isEmpty()) {
                        System.out.println("⚠️ No hay productos para mostrar.");
                    } else {
                        System.out.println("📋 Lista de Productos:");
                        for (int i = 0; i < listaProductos.size(); i++) {
                            System.out.println((i + 1) + ". " + listaProductos.get(i).nombre + " - Precio: " + listaProductos.get(i).precio + " € - Estado: " + listaProductos.get(i).estado);
                        }
                    }
                    break;

                case 4:
                    System.out.println("🔁 Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcionSubmenu != 4);
        
    }
}
