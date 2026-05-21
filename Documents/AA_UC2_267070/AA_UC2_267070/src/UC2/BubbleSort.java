/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UC2;

/**
 *
 * @author capri
 */
public class BubbleSort {
    public static void main(String[] args) {

        // Se declara e inicializa un arreglo de enteros con valores desordenados
        int[] arreglo = {10, 4, 24, 3, 8, 12};

        // Se obtiene el tamaño del arreglo
        int n = arreglo.length;

        // Primer ciclo: controla el número de pasadas (iteraciones)
        // En cada pasada, el elemento más grande "sube" al final
        for (int i = 0; i < n - 1; i++) {

            // Segundo ciclo: recorre el arreglo comparando elementos adyacentes
            // Se reduce en cada iteración porque los últimos elementos ya están ordenados
            for (int j = 0; j < n - i - 1; j++) {

                // Se comparan dos elementos consecutivos
                if (arreglo[j] > arreglo[j + 1]) {

                    // Si el elemento actual es mayor que el siguiente, se intercambian
                    int temp = arreglo[j];           // Se guarda temporalmente el valor actual
                    arreglo[j] = arreglo[j + 1];     // Se mueve el valor menor a la izquierda
                    arreglo[j + 1] = temp;           // Se coloca el valor mayor a la derecha
                }
            }
        }

        // Se imprime el arreglo ya ordenado
        System.out.println("Arreglo ordenado:");

        // Se recorre el arreglo con un for-each para mostrar cada elemento
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
