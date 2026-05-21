/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UC2;

/**
 *
 * @author capri
 */
/**
 * Clase que implementa el algoritmo de ordenamiento Insertion Sort.
 * 
 * El algoritmo Insertion Sort funciona tomando un elemento del arreglo
 * y colocándolo en la posición correcta dentro de la parte ya ordenada.
 * 
 * Complejidad:
 * - Mejor caso: O(n)
 * - Peor caso: O(n²)
 * - Caso promedio: O(n²)
 */
public class InsertionSort {

    /**
     * Método principal del programa.Aquí se crea el arreglo y se llama al método de ordenamiento.
     * @param args
     */
    public static void main(String[] args) {

        // Arreglo de prueba
        int[] arr = {5, 3, 8, 1, 2};
        // Mostrar arreglo original
        System.out.println("Arreglo original:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Llamada al método de ordenamiento
        insertionSort(arr);

        // Mostrar arreglo ordenado
        System.out.println("\nArreglo ordenado:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * Método que implementa el algoritmo Insertion Sort.
     * 
     * @param arr Arreglo de enteros que será ordenado.
     */
    public static void insertionSort(int[] arr){

        // Obtiene el tamaño del arreglo
        int n = arr.length;

        // Recorre el arreglo desde el segundo elemento
        for (int i = 1; i < n; i++){

            // Guarda el valor actual que se va a insertar
            int key = arr[i];

            // Índice del elemento anterior
            int j = i - 1;

            /**
             * Desplaza los elementos mayores que 'key'
             * una posición hacia la derecha
             */
            while (j >= 0 && arr[j] > key){

                // Mueve el elemento una posición adelante
                arr[j + 1] = arr[j];

                // Decrementa el índice para seguir comparando
                j = j - 1;
            }

            // Inserta el valor 'key' en su posición correcta
            arr[j + 1] = key;
        }
    }
}