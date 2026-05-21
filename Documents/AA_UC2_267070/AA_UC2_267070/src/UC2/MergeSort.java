/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UC2;

/**
 * Clase que implementa el algoritmo Merge Sort.
 * 
 * Merge Sort divide el arreglo en dos mitades,
 * ordena cada mitad recursivamente y después
 * las combina en un solo arreglo ordenado.
 * 
 * Complejidad:
 * - Mejor caso: O(n log n)
 * - Caso promedio: O(n log n)
 * - Peor caso: O(n log n)
 * 
 * Ventaja:
 * - Es un algoritmo estable.
 * 
 * Desventaja:
 * - Utiliza memoria adicional para los arreglos temporales.
 * 
 * @author capri
 */
public class MergeSort {

    /**
     * Método principal.Aquí se crea el arreglo, se imprime antes
 de ordenar y después de aplicar Merge Sort.
     * @param args
     */
    public static void main(String[] args) {

        // Arreglo original
        int[] arreglo = {8, 2, 1, 4, 8, 9, 2, 3, 4};

        System.out.println("El arreglo antes de ordenar:");
        imprimirArreglo(arreglo);

        // Llamada al algoritmo Merge Sort
        mergeSort(arreglo, 0, arreglo.length - 1);

        System.out.println("El arreglo después de ordenar:");
        imprimirArreglo(arreglo);
    }

    /**
     * Método para imprimir el contenido del arreglo.
     * 
     * @param arreglo Arreglo a imprimir
     */
    public static void imprimirArreglo(int[] arreglo) {

        // Recorre el arreglo mostrando cada elemento
        for (int num : arreglo) {
            System.out.print(num + " ");
        }

        System.out.println("");
    }

    /**
     * Método recursivo que divide el arreglo
     * en dos partes hasta llegar a subarreglos
     * de tamaño 1.
     * 
     * @param arreglo   Arreglo original
     * @param izquierda Índice inicial
     * @param derecha   Índice final
     */
    public static void mergeSort(int[] arreglo, int izquierda, int derecha) {

        // Caso base:
        // Solo continúa si hay más de un elemento
        if (izquierda < derecha) {

            // Cálculo del punto medio
            int medio = izquierda + (derecha - izquierda) / 2;

            // Ordenar mitad izquierda
            mergeSort(arreglo, izquierda, medio);

            // Ordenar mitad derecha
            mergeSort(arreglo, medio + 1, derecha);

            // Combinar ambas mitades ordenadas
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    /**
     * Método que combina dos subarreglos ordenados
     * en un solo arreglo ordenado.
     * 
     * @param arreglo   Arreglo original
     * @param izquierda Inicio del subarreglo izquierdo
     * @param medio     Punto medio
     * @param derecha   Fin del subarreglo derecho
     */
    public static void merge(int[] arreglo, int izquierda, int medio, int derecha) {

        // Tamaño del subarreglo izquierdo
        int n1 = medio - izquierda + 1;

        // Tamaño del subarreglo derecho
        int n2 = derecha - medio;

        // Crear arreglos temporales
        int[] izquierdaArr = new int[n1];
        int[] derechaArr = new int[n2];

        // Copiar datos al arreglo izquierdo
        for (int i = 0; i < n1; i++) {
            izquierdaArr[i] = arreglo[izquierda + i];
        }

        // Copiar datos al arreglo derecho
        for (int j = 0; j < n2; j++) {
            derechaArr[j] = arreglo[medio + 1 + j];
        }

        // Índices auxiliares
        int i = 0; // Recorre izquierdaArr
        int j = 0; // Recorre derechaArr
        int k = izquierda; // Recorre arreglo original

        /**
         * Comparar elementos de ambos subarreglos
         * y copiar el menor al arreglo original.
         */
        while (i < n1 && j < n2) {

            // Si el elemento izquierdo es menor o igual
            if (izquierdaArr[i] <= derechaArr[j]) {

                arreglo[k] = izquierdaArr[i];
                i++;

            } else {

                // Si el derecho es menor
                arreglo[k] = derechaArr[j];
                j++;
            }

            k++;
        }

        /**
         * Copiar elementos restantes
         * del arreglo izquierdo.
         */
        while (i < n1) {

            arreglo[k] = izquierdaArr[i];
            i++;
            k++;
        }

        /**
         * Copiar elementos restantes
         * del arreglo derecho.
         */
        while (j < n2) {

            arreglo[k] = derechaArr[j];
            j++;
            k++;
        }
    }
}