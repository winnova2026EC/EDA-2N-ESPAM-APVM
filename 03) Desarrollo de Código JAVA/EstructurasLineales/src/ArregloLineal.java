
public class ArregloLineal {

    // ARREGLO ESTATICO
    private int[] arregloEstatico;
    private int cantidadEstaticos;

    // ARREGLO DINAMICO
    private int[] arregloDinamico;
    private int cantidadDinamicos;

    // MATRIZ
    private int[][] matriz;

    public ArregloLineal() {
        arregloEstatico = new int[5];
        cantidadEstaticos = 0;

        arregloDinamico = new int[2];
        cantidadDinamicos = 0;

        matriz = new int[3][3];
    }

    // Insertar en arreglo estatico
    public boolean insertarEstatico(int valor) {

        if (cantidadEstaticos == arregloEstatico.length) {
            System.out.println("Arreglo estatico lleno.");
            return false;
        }

        arregloEstatico[cantidadEstaticos++] = valor;
        return true;
    }

    // Acceder por indice
    public int obtenerEstatico(int indice) {

        if (indice < 0 || indice >= cantidadEstaticos) {
            throw new IndexOutOfBoundsException("Indice invalido.");
        }

        return arregloEstatico[indice];
    }

    // Insertar en arreglo dinamico
    public void insertarDinamico(int valor) {

        if (cantidadDinamicos == arregloDinamico.length) {
            aumentarCapacidad();
        }

        arregloDinamico[cantidadDinamicos++] = valor;
    }

    // Aumentar manualmente la capacidad
    private void aumentarCapacidad() {

        int nuevaCapacidad = arregloDinamico.length * 2;

        int[] nuevoArreglo = new int[nuevaCapacidad];

        for (int i = 0; i < cantidadDinamicos; i++) {
            nuevoArreglo[i] = arregloDinamico[i];
        }

        arregloDinamico = nuevoArreglo;

        System.out.println("Capacidad ampliada a: " + nuevaCapacidad);
    }

    // Obtener elemento del arreglo dinamico
    public int obtenerDinamico(int indice) {

        if (indice < 0 || indice >= cantidadDinamicos) {
            throw new IndexOutOfBoundsException("Indice invalido.");
        }

        return arregloDinamico[indice];
    }

    // Insertar valor en una matriz
    public void insertarMatriz(int fila, int columna, int valor) {

        if (fila < 0 || fila >= matriz.length ||
            columna < 0 || columna >= matriz[0].length) {

            throw new IndexOutOfBoundsException("Posicion invalida.");
        }

        matriz[fila][columna] = valor;
    }

    // Consultar valor de una matriz
    public int obtenerMatriz(int fila, int columna) {

        return matriz[fila][columna];
    }

    // Mostrar arreglo estatico
    public void mostrarEstatico() {

        System.out.println("\nARREGLO ESTATICO:");

        for (int i = 0; i < cantidadEstaticos; i++) {
            System.out.println("Indice [" + i + "]: "
                    + arregloEstatico[i]);
        }
    }

    // Mostrar arreglo dinamico
    public void mostrarDinamico() {

        System.out.println("\nARREGLO DINAMICO:");

        for (int i = 0; i < cantidadDinamicos; i++) {
            System.out.println("Indice [" + i + "]: "
                    + arregloDinamico[i]);
        }
    }

    // Mostrar matriz
    public void mostrarMatriz() {

        System.out.println("\nMATRIZ:");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
