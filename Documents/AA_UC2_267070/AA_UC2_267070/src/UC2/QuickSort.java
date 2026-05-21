/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UC2;

import java.util.Arrays;

/**
 * Clase que implementa el algoritmo Quick Sort.
 * 
 * Quick Sort selecciona un pivote y reorganiza
 * el arreglo de forma que:
 * 
 * - Los elementos menores al pivote queden a la izquierda
 * - Los elementos mayores queden a la derecha
 * 
 * Después aplica el mismo proceso recursivamente
 * a ambos subarreglos.
 * 
 * Complejidad:
 * - Mejor caso: O(n log n)
 * - Caso promedio: O(n log n)
 * - Peor caso: O(n²)
 * 
 * Ventajas:
 * - Muy rápido en la práctica
 * - No requiere arreglos auxiliares grandes
 * 
 * Desventajas:
 * - Puede degradarse a O(n²)
 * - No es estable
 * 
 * @author capri
 */
public class QuickSort {

    /**
     * Método principal del algoritmo Quick Sort.
     * 
     * Divide el arreglo en dos subarreglos
     * usando un pivote y aplica recursividad.
     * 
     * @param arr     Arreglo a ordenar
     * @param inicio  Índice inicial
     * @param fin     Índice final
     */
    public static void quicksort(int[] arr, int inicio, int fin) {

        // Caso base:
        // Solo continúa si hay más de un elemento
        if (inicio < fin) {

            // Obtener posición final del pivote
            int pivoteIndice = particion(arr, inicio, fin);

            System.out.println(
                "El índice del pivote es: " 
                + pivoteIndice 
                + ". El arreglo actualmente es: "
                + Arrays.toString(arr)
            );

            // Ordenar subarreglo izquierdo
            System.out.println("Izquierda");
            quicksort(arr, inicio, pivoteIndice - 1);

            // Ordenar subarreglo derecho
            System.out.println("Derecha");
            quicksort(arr, pivoteIndice + 1, fin);
        }
    }

    /**
     * Método que reorganiza el arreglo
     * alrededor de un pivote.
     * 
     * Los valores menores al pivote
     * quedan a la izquierda y los mayores
     * a la derecha.
     * 
     * @param arr     Arreglo original
     * @param inicio  Inicio del subarreglo
     * @param fin     Fin del subarreglo
     * @return Índice final del pivote
     */
    public static int particion(int[] arr, int inicio, int fin) {

        // Elegir el último elemento como pivote
        int pivote = arr[fin];

        // Índice del elemento menor
        int i = inicio - 1;

        /**
         * Recorrer el arreglo comparando
         * cada elemento con el pivote
         */
        for (int j = inicio; j < fin; j++) {

            // Si el elemento actual es menor al pivote
            if (arr[j] < pivote) {

                i++;

                // Intercambio de elementos
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        /**
         * Colocar el pivote en su posición correcta
         */
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        // Retornar posición final del pivote
        return i + 1;
    }

    /**
     * Método principal del programa.Crea el arreglo, lo imprime,
 aplica Quick Sort y muestra
 el resultado ordenado.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Arreglo original
        int[] numeros = {4, 2 , 4, 3, 1, 4};

        System.out.println(
            "Arreglo desordenado: "
            + Arrays.toString(numeros)
        );

        // Llamada al algoritmo
        quicksort(numeros, 0, numeros.length -1);

        System.out.println(
            "Arreglo Ordenado: "
            + Arrays.toString(numeros)
        );
    }
}