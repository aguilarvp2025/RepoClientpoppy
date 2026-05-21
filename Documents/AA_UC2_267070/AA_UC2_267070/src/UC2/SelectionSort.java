/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UC2;

import java.util.Arrays;

/**
 * Clase que implementa el algoritmo Selection Sort.
 * 
 * Selection Sort busca el elemento más pequeño
 * y lo coloca en la posición correcta.
 * 
 * @author capri
 */
public class SelectionSort {

    /**
     * Método que ordena un arreglo usando Selection Sort.
     * 
     * @param arr Arreglo a ordenar
     */
    public static void selectionSort(int[] arr) {

        // Tamaño del arreglo
        int n = arr.length;

        // Recorrer el arreglo
        for (int i = 0; i < n - 1; i++) {

            // Suponer que el elemento actual es el mínimo
            int indiceMinimo = i;

            // Buscar el elemento más pequeño
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Intercambiar elementos
            int aux = arr[indiceMinimo];
            arr[indiceMinimo] = arr[i];
            arr[i] = aux;

            // Mostrar el arreglo en cada iteración
            System.out.println(
                "Iteración " + (i + 1) + ": "
                + Arrays.toString(arr)
            );
        }
    }

    /**
     * Método principal para ejecutar y debuggear el programa.
     * @param args
     */
    public static void main(String[] args) {

        // Arreglo de prueba
        int[] numeros = {64, 25, 12, 22, 11};

        System.out.println(
            "Arreglo desordenado: "
            + Arrays.toString(numeros)
        );

        // Llamada al algoritmo
        selectionSort(numeros);

        System.out.println(
            "Arreglo ordenado: "
            + Arrays.toString(numeros)
        );
    }
}