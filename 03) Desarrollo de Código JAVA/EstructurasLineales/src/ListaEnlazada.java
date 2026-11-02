
public class ListaEnlazada<T> {

    // NODO PARA LISTA SIMPLEMENTE ENLAZADA
    private class NodoSimple {
        T dato;
        NodoSimple siguiente;

        NodoSimple(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // NODO PARA LISTA DOBLEMENTE ENLAZADA
    private class NodoDoble {
        T dato;
        NodoDoble anterior;
        NodoDoble siguiente;

        NodoDoble(T dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    // NODO PARA LISTA CIRCULAR
    private class NodoCircular {
        T dato;
        NodoCircular siguiente;

        NodoCircular(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // REFERENCIAS DE LISTAS
    private NodoSimple cabezaSimple;

    private NodoDoble cabezaDoble;
    private NodoDoble colaDoble;

    private NodoCircular cabezaCircular;
    private NodoCircular colaCircular;

    // CONSTRUCTOR
    public ListaEnlazada() {
        cabezaSimple = null;
        cabezaDoble = null;
        colaDoble = null;
        cabezaCircular = null;
        colaCircular = null;
    }

    // =====================================
    // LISTA SIMPLEMENTE ENLAZADA
    // =====================================

    public void insertarSimple(T dato) {

        NodoSimple nuevo = new NodoSimple(dato);

        nuevo.siguiente = cabezaSimple;
        cabezaSimple = nuevo;
    }

    public void recorrerSimple() {

        System.out.println("\nLISTA SIMPLEMENTE ENLAZADA:");

        NodoSimple actual = cabezaSimple;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    // =====================================
    // LISTA DOBLEMENTE ENLAZADA
    // =====================================

    public void insertarDoble(T dato) {

        NodoDoble nuevo = new NodoDoble(dato);

        if (cabezaDoble == null) {
            cabezaDoble = nuevo;
            colaDoble = nuevo;
        } else {
            colaDoble.siguiente = nuevo;
            nuevo.anterior = colaDoble;
            colaDoble = nuevo;
        }
    }

    public void recorrerDobleAdelante() {

        System.out.println("\nLISTA DOBLE - ADELANTE:");

        NodoDoble actual = cabezaDoble;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public void recorrerDobleAtras() {

        System.out.println("\nLISTA DOBLE - ATRAS:");

        NodoDoble actual = colaDoble;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.anterior;
        }
    }

    // =====================================
    // LISTA CIRCULAR
    // =====================================

    public void insertarCircular(T dato) {

        NodoCircular nuevo = new NodoCircular(dato);

        if (cabezaCircular == null) {

            cabezaCircular = nuevo;
            colaCircular = nuevo;

            nuevo.siguiente = cabezaCircular;

        } else {

            colaCircular.siguiente = nuevo;
            colaCircular = nuevo;

            colaCircular.siguiente = cabezaCircular;
        }
    }

    public void recorrerCircular() {

        System.out.println("\nLISTA CIRCULAR:");

        if (cabezaCircular == null) {
            System.out.println("Lista vacia.");
            return;
        }

        NodoCircular actual = cabezaCircular;

        do {
            System.out.println(actual.dato);
            actual = actual.siguiente;

        } while (actual != cabezaCircular);
    }
}
