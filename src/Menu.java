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
        System.out.println("\tOrdenando arreglo10 con los tres métodos:");
        metodos.burbujaAjuste(arreglo10);
        metodos.insercion(arreglo10);
        metodos.seleccion(arreglo10);
        System.out.println("\nArreglo10 Ordenado: ");
        System.out.print("[");
        for (int elem : arreglo10) {
            System.out.print(elem + ", ");
        }
        System.out.print("]\n");
        
        System.out.println();

        System.out.println("\tOrdenando arreglo100 con los tres métodos:");
        metodos.burbujaAjuste(arreglo100);
        metodos.insercion(arreglo100);
        metodos.seleccion(arreglo100);

        System.out.println();
        
        System.out.println("\tOrdenando arreglo1000 con los tres métodos:");
        metodos.burbujaAjuste(arreglo1000);
        metodos.insercion(arreglo1000);
        metodos.seleccion(arreglo1000);

        System.out.println();

        System.out.println("\tOrdenando arreglo5000 con los tres métodos:");
        metodos.burbujaAjuste(arreglo5000);
        metodos.insercion(arreglo5000);
        metodos.seleccion(arreglo5000);

        System.out.println();

        System.out.println("\tOrdenando arreglo10000 con los tres métodos:");
        metodos.burbujaAjuste(arreglo10000);
        metodos.insercion(arreglo10000);
        metodos.seleccion(arreglo10000);

        System.out.println();

        System.out.println("\tOrdenando arreglo30000 con los tres métodos:");
        metodos.burbujaAjuste(arreglo30000);
        metodos.insercion(arreglo30000);
        metodos.seleccion(arreglo30000);

        System.out.println();

        System.out.println("Arreglos ordenados.");
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
        double tiempoNormalSegundos = (end - start) / 1_000_000_000.0; // Convertir a segundos
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
        double tiempoRecursivoSegundos = (fin - inicio) / 1_000_000_000.0; // Convertir a segundos
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