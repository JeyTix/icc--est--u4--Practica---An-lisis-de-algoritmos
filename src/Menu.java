import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Menu {
    private static int[] arreglo10;
    private static int[] arreglo100;
    private static int[] arreglo1000;
    private static int[] arreglo5000;
    private static int[] arreglo10000;
    private static int[] arreglo30000;
    private static Metodos metodos = new Metodos();

    public static void generarArreglos() {
        Random random = new Random();

        arreglo10 = new int[10];
        for (int i = 0; i < arreglo10.length; i++) {
            arreglo10[i] = random.nextInt(100);
        }
        
        System.out.println("Arreglo10: ");
        System.out.print("[");
        for (int elem : arreglo10) {
            System.out.print(elem + ", ");
        }
        System.out.print("]");

        arreglo100 = Arrays.copyOf(arreglo10, 100);
        for (int i = 10; i < arreglo100.length; i++) {
            arreglo100[i] = random.nextInt(100);
        }

        arreglo1000 = Arrays.copyOf(arreglo100, 1000);
        for (int i = 100; i < arreglo1000.length; i++) {
            arreglo1000[i] = random.nextInt(100);
        }

        arreglo5000 = Arrays.copyOf(arreglo1000, 5000);
        for (int i = 1000; i < arreglo5000.length; i++) {
            arreglo5000[i] = random.nextInt(100);
        }

        arreglo10000 = Arrays.copyOf(arreglo5000, 10000);
        for (int i = 5000; i < arreglo10000.length; i++) {
            arreglo10000[i] = random.nextInt(100);
        }

        arreglo30000 = Arrays.copyOf(arreglo10000, 30000);
        for (int i = 10000; i < arreglo30000.length; i++) {
            arreglo30000[i] = random.nextInt(100);
        }

        System.out.println("Arreglos generados correctamente.");
    }

    public static void ordenarArreglos() {
        System.out.println("\tMetodo de Burbuja Ajuste:");
        ordenarConTiempo(arreglo10, "Arreglo10");

        System.out.println("\tOrdenando arreglo100 con los tres métodos:");
        ordenarConTiempo(arreglo100, "Arreglo100");

        System.out.println("\tOrdenando arreglo1000 con los tres métodos:");
        ordenarConTiempo(arreglo1000, "Arreglo1000");

        System.out.println("\tOrdenando arreglo5000 con los tres métodos:");
        ordenarConTiempo(arreglo5000, "Arreglo5000");

        System.out.println("\tOrdenando arreglo10000 con los tres métodos:");
        ordenarConTiempo(arreglo10000, "Arreglo10000");

        System.out.println("\tOrdenando arreglo30000 con los tres métodos:");
        ordenarConTiempo(arreglo30000, "Arreglo30000");

        System.out.println("Arreglos ordenados.");
    }

    private static void ordenarConTiempo(int[] arreglo, String nombreArreglo) {
        long start, end;
        double tiempoSegundos;

        // Burbuja Ajuste
        start = System.nanoTime();
        metodos.burbujaAjuste(arreglo);
        end = System.nanoTime();
        tiempoSegundos = (end - start) / 1_000_000_000.0;
        System.out.printf("%s Burbuja Ajuste tiempo: %.9f s\n", nombreArreglo, tiempoSegundos);

        // Inserción
        start = System.nanoTime();
        metodos.insercion(arreglo);
        end = System.nanoTime();
        tiempoSegundos = (end - start) / 1_000_000_000.0;
        System.out.printf("%s Inserción tiempo: %.9f s\n", nombreArreglo, tiempoSegundos);

        // Selección
        start = System.nanoTime();
        metodos.seleccion(arreglo);
        end = System.nanoTime();
        tiempoSegundos = (end - start) / 1_000_000_000.0;
        System.out.printf("%s Selección tiempo: %.9f s\n", nombreArreglo, tiempoSegundos);
    }

    public static void buscarValor(int valor) {
        realizarBusquedaEnArreglo("Arreglo 10", arreglo10, valor);
        realizarBusquedaEnArreglo("Arreglo 100", arreglo100, valor);
        realizarBusquedaEnArreglo("Arreglo 1000", arreglo1000, valor);
        realizarBusquedaEnArreglo("Arreglo 5000", arreglo5000, valor);
        realizarBusquedaEnArreglo("Arreglo 10000", arreglo10000, valor);
        realizarBusquedaEnArreglo("Arreglo 30000", arreglo30000, valor);
    }
    
    private static void realizarBusquedaEnArreglo(String nombreArreglo, int[] arreglo, int valor) {
        System.out.println("\t" + nombreArreglo + ":");
        Arrays.sort(arreglo); // Asegurarse de que el arreglo esté ordenado
    
        // Búsqueda binaria normal
        long start = System.nanoTime();
        int resultadoNormal = metodos.busquedaBinaria(arreglo, valor);
        if (resultadoNormal >= 0) {
            System.out.println("Búsqueda Binaria Normal, posición: " + resultadoNormal);
        } else {
            System.out.println("Valor no encontrado en Búsqueda Binaria Normal.");
        }
        long end = System.nanoTime();
        double tiempoNormalSegundos = (end - start) / 1_000_000_000.0;
        System.out.printf("Tiempo de ejecución Búsqueda Binaria Normal: %.9f s\n", tiempoNormalSegundos);
    
        // Búsqueda binaria recursiva
        long inicio = System.nanoTime();
        int resultadoRecursivo = metodos.busqBinRecursividad(arreglo, 0, arreglo.length - 1, valor);
        if (resultadoRecursivo >= 0) {
            System.out.println("Búsqueda Binaria Recursiva, posición: " + resultadoRecursivo);
        } else {
            System.out.println("Valor no encontrado en Búsqueda Binaria Recursiva.");
        }
        long fin = System.nanoTime();
        double tiempoRecursivoSegundos = (fin - inicio) / 1_000_000_000.0;
        System.out.printf("Tiempo de ejecución Búsqueda Binaria Recursiva: %.9f s\n", tiempoRecursivoSegundos);
    
        System.out.println();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Generar arreglos aleatorios con diferente tamaño");
            System.out.println("2. Ordenar arreglo10 por tres métodos diferentes");
            System.out.println("3. Buscar valores con búsqueda binaria normal y recursividad");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción (1-4): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarArreglos();
                    break;
                case 2:
                    ordenarArreglos();
                    break;
                case 3:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valor = scanner.nextInt();
                    buscarValor(valor);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
