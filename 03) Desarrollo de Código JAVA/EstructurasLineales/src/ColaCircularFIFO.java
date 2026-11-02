
public class ColaCircularFIFO<T> {

    private Object[] elementos;
    private int frente;
    private int finalCola;
    private int cantidad;
    private int capacidad;

    // Constructor
    public ColaCircularFIFO(int capacidad) {

        this.capacidad = capacidad;
        elementos = new Object[capacidad];

        frente = 0;
        finalCola = -1;
        cantidad = 0;
    }

    // Insertar elemento (ENQUEUE)
    public boolean enqueue(T elemento) {

        if (isFull()) {
            System.out.println("Cola llena (OVERFLOW).");
            return false;
        }

        finalCola = (finalCola + 1) % capacidad;

        elementos[finalCola] = elemento;

        cantidad++;

        return true;
    }

    // Retirar elemento (DEQUEUE)
    @SuppressWarnings("unchecked")
    public T dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException(
                "Cola vacia (UNDERFLOW)."
            );
        }

        T elemento = (T) elementos[frente];

        elementos[frente] = null;

        frente = (frente + 1) % capacidad;

        cantidad--;

        if (cantidad == 0) {
            frente = 0;
            finalCola = -1;
        }

        return elemento;
    }

    // Consultar primer elemento (PEEK)
    @SuppressWarnings("unchecked")
    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return (T) elementos[frente];
    }

    // Verificar si esta vacia
    public boolean isEmpty() {
        return cantidad == 0;
    }

    // Verificar si esta llena
    public boolean isFull() {
        return cantidad == capacidad;
    }

    // Obtener cantidad de elementos
    public int size() {
        return cantidad;
    }

    // Mostrar cola
    public void mostrar() {

        System.out.println("\nCOLA CIRCULAR FIFO:");

        if (isEmpty()) {
            System.out.println("Cola vacia.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {

            int indice = (frente + i) % capacidad;

            System.out.println(elementos[indice]);
        }
    }

    // Mostrar posiciones de los punteros
    public void mostrarEstado() {

        System.out.println("Frente: " + frente);
        System.out.println("Final: " + finalCola);
        System.out.println("Cantidad: " + cantidad);
    }
}
