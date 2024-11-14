public class Metodos {
    public void burbujaAjuste(int[] arreglo) {
        long inicio= System.currentTimeMillis();
        int n = arreglo.length;
        boolean intercambio;
        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    intercambio = true;
                }
            }
            if (!intercambio) break;
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución Burbuja Ajuste: " + (fin - inicio) + " ms");
    }

    public void insercion(int[] arreglo) {
        long inicio= System.currentTimeMillis();
        for (int j = 1; j < arreglo.length; j++) {
            int key = arreglo[j];
            int i = j - 1;
            while (i >= 0 && arreglo[i] > key) {
                arreglo[i + 1] = arreglo[i];
                i--;
            }
            arreglo[i + 1] = key;
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución Insercion: " + (fin - inicio) + " ms");
    }

    public void seleccion(int[] arreglo) {
        long inicio= System.currentTimeMillis();
        for (int i = 0; i < arreglo.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución Seleccion: " + (fin - inicio) + " ms");
    }
    
    public int busquedaBinaria(int[] arreglo, int valor) {
        int inicio = 0;
        int fin = arreglo.length - 1;
        int posicion = -1;
    
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arreglo[medio] == valor) {
                posicion = medio;
                break;
            } else if (arreglo[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return posicion;
    }

    public int busqBinRecursividad(int[] arreglo, int inicio, int fin, int objetivo) {
        if (inicio > fin) return -1; 
        int medio = inicio + (fin - inicio) / 2;
        if (arreglo[medio] == objetivo) return medio;
        if (arreglo[medio] > objetivo) {
            return busqBinRecursividad(arreglo, inicio, medio - 1, objetivo);  
        } else {
            return busqBinRecursividad(arreglo, medio + 1, fin, objetivo);
        }
    }
    
}
