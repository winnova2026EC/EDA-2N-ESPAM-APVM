
public class PilaLIFO<T> {

    private Object[] elementos;
    private int tope;
    private int capacidad;

    public PilaLIFO(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.tope = -1;
    }

    // Insertar un elemento en la pila
    public boolean push(T elemento) {
        if (isFull()) {
            System.out.println("Error: La pila esta llena (OVERFLOW).");
            return false;
        }

        elementos[++tope] = elemento;
        return true;
    }

    // Retirar el ultimo elemento ingresado
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacia (UNDERFLOW).");
        }

        T elemento = (T) elementos[tope];
        elementos[tope] = null;
        tope--;

        return elemento;
    }

    // Consultar el elemento superior sin retirarlo
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return (T) elementos[tope];
    }

    // Verificar si la pila esta vacia
    public boolean isEmpty() {
        return tope == -1;
    }

    // Verificar si la pila esta llena
    public boolean isFull() {
        return tope == capacidad - 1;
    }

    // Obtener la cantidad de elementos
    public int size() {
        return tope + 1;
    }

    // Vaciar la pila
    public void limpiar() {
        while (!isEmpty()) {
            elementos[tope--] = null;
        }
    }

    // Mostrar los elementos de la pila
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia.");
            return;
        }

        System.out.println("Elementos de la pila:");

        for (int i = tope; i >= 0; i--) {
            System.out.println(elementos[i]);
        }
    }
}
