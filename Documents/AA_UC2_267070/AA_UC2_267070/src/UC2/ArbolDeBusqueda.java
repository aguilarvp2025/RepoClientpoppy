/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UC2;

/**
 * Clase Nodo
 * Representa cada nodo del árbol binario de búsqueda.
 */
class Nodo {

    int valor;
    Nodo izquierda;
    Nodo derecha;

    /**
     * Constructor del nodo.
     * @param valor Valor que almacenará el nodo.
     */
    public Nodo(int valor) {
        this.valor = valor;
        izquierda = null;
        derecha = null;
    }
}

/**
 * Clase ArbolDeBusqueda
 * Implementa un Árbol de Búsqueda Binaria.
 */
public class ArbolDeBusqueda {

    // Raíz del árbol
    Nodo raiz;

    /**
     * Inserta un nuevo valor en el árbol.
     * @param valor Valor a insertar.
     */
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    /**
     * Método recursivo para insertar nodos.
     */
    private Nodo insertarRec(Nodo raiz, int valor) {

        // Si el árbol está vacío, crea un nodo
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        // Inserta a la izquierda si el valor es menor
        if (valor < raiz.valor) {
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        }

        // Inserta a la derecha si el valor es mayor
        else if (valor > raiz.valor) {
            raiz.derecha = insertarRec(raiz.derecha, valor);
        }

        return raiz;
    }

    /**
     * Busca un valor dentro del árbol.
     * @param valor Valor a buscar.
     * @return true si existe, false si no.
     */
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    /**
     * Método recursivo de búsqueda.
     */
    private boolean buscarRec(Nodo raiz, int valor) {

        // Si no existe el nodo
        if (raiz == null) {
            return false;
        }

        // Si encuentra el valor
        if (raiz.valor == valor) {
            return true;
        }

        // Buscar en subárbol izquierdo
        if (valor < raiz.valor) {
            return buscarRec(raiz.izquierda, valor);
        }

        // Buscar en subárbol derecho
        return buscarRec(raiz.derecha, valor);
    }

    /**
     * Elimina un valor del árbol.
     * @param valor Valor a eliminar.
     */
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    /**
     * Método recursivo para eliminar nodos.
     */
    private Nodo eliminarRec(Nodo raiz, int valor) {

        if (raiz == null) {
            return raiz;
        }

        // Buscar el nodo a eliminar
        if (valor < raiz.valor) {
            raiz.izquierda = eliminarRec(raiz.izquierda, valor);
        }

        else if (valor > raiz.valor) {
            raiz.derecha = eliminarRec(raiz.derecha, valor);
        }

        else {

            // Caso 1: nodo sin hijo izquierdo
            if (raiz.izquierda == null) {
                return raiz.derecha;
            }

            // Caso 2: nodo sin hijo derecho
            else if (raiz.derecha == null) {
                return raiz.izquierda;
            }

            /**
             * Caso 3:
             * Nodo con dos hijos.
             * Se utiliza el sucesor inorden.
             */
            raiz.valor = valorMinimo(raiz.derecha);

            // Elimina el sucesor duplicado
            raiz.derecha = eliminarRec(raiz.derecha, raiz.valor);
        }

        return raiz;
    }

    /**
     * Obtiene el menor valor del subárbol.
     */
    private int valorMinimo(Nodo raiz) {

        int minimo = raiz.valor;

        while (raiz.izquierda != null) {
            minimo = raiz.izquierda.valor;
            raiz = raiz.izquierda;
        }

        return minimo;
    }

    /**
     * Realiza recorrido inorden.
     */
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    /**
     * Método recursivo del recorrido inorden.
     */
    private void inordenRec(Nodo raiz) {

        if (raiz != null) {

            inordenRec(raiz.izquierda);

            System.out.print(raiz.valor + " ");

            inordenRec(raiz.derecha);
        }
    }

    /**
     * Método principal.
     * @param args
     */
    public static void main(String[] args) {

        ArbolDeBusqueda arbol = new ArbolDeBusqueda();

        // Insertar valores
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        // Mostrar recorrido antes de eliminar
        System.out.println("Recorrido inorden antes de eliminar:");
        arbol.inorden();

        // Eliminar nodo 50
        arbol.eliminar(50);

        // Mostrar recorrido después de eliminar
        System.out.println("Recorrido inorden después de eliminar:");
        arbol.inorden();

        // Búsquedas
        System.out.println("\nBúsquedas:");

        int[] valoresBuscar = {30, 50, 60};

        for (int valor : valoresBuscar) {

            if (arbol.buscar(valor)) {
                System.out.println(valor + " encontrado.");
            } else {
                System.out.println(valor + " no encontrado.");
            }
        }
    }
}