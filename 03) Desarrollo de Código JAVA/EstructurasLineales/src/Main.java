import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("\n======================================");
            System.out.println("       ESTRUCTURAS DE DATOS - EDA");
            System.out.println("       ESPAM MFL");
            System.out.println("       Alex Patricio Vazquez Machay");
            System.out.println("======================================");

            System.out.println("1. Arreglos y matrices");
            System.out.println("2. Lista simplemente enlazada");
            System.out.println("3. Lista doblemente enlazada");
            System.out.println("4. Lista circular");
            System.out.println("5. Pila LIFO");
            System.out.println("6. Cola circular FIFO");
            System.out.println("7. Editor de texto Undo / Redo");
            System.out.println("8. Salir");

            System.out.print("\nSeleccione una opcion: ");
            opcion = leerEntero();

            System.out.println();

            switch (opcion) {

                case 1:
                    probarArreglos();
                    break;

                case 2:
                    probarListaSimple();
                    break;

                case 3:
                    probarListaDoble();
                    break;

                case 4:
                    probarListaCircular();
                    break;

                case 5:
                    probarPila();
                    break;

                case 6:
                    probarCola();
                    break;

                case 7:
                    ejecutarEditor();
                    break;

                case 8:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

            if (opcion != 8) {
                System.out.println("\nPresione ENTER para volver al menu...");
                teclado.nextLine();
            }

        } while (opcion != 8);

        teclado.close();
    }

    // =====================================
    // LEER NUMEROS ENTEROS
    // =====================================

    public static int leerEntero() {

        while (!teclado.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            teclado.nextLine();
        }

        int numero = teclado.nextInt();
        teclado.nextLine();

        return numero;
    }

    // =====================================
    // ARREGLOS Y MATRICES
    // =====================================

    public static void probarArreglos() {

        ArregloLineal arreglo = new ArregloLineal();

        System.out.println("========== ARREGLO ESTATICO ==========");

        arreglo.insertarEstatico(10);
        arreglo.insertarEstatico(20);
        arreglo.insertarEstatico(30);

        arreglo.mostrarEstatico();

        System.out.println("Elemento en indice 1: "
                + arreglo.obtenerEstatico(1));

        System.out.println("\n========== ARREGLO DINAMICO ==========");

        arreglo.insertarDinamico(100);
        arreglo.insertarDinamico(200);
        arreglo.insertarDinamico(300);
        arreglo.insertarDinamico(400);

        arreglo.mostrarDinamico();

        System.out.println("\n========== MATRIZ ==========");

        arreglo.insertarMatriz(0, 0, 1);
        arreglo.insertarMatriz(0, 1, 2);
        arreglo.insertarMatriz(0, 2, 3);

        arreglo.insertarMatriz(1, 0, 4);
        arreglo.insertarMatriz(1, 1, 5);
        arreglo.insertarMatriz(1, 2, 6);

        arreglo.insertarMatriz(2, 0, 7);
        arreglo.insertarMatriz(2, 1, 8);
        arreglo.insertarMatriz(2, 2, 9);

        arreglo.mostrarMatriz();
    }

    // =====================================
    // LISTA SIMPLEMENTE ENLAZADA
    // =====================================

    public static void probarListaSimple() {

        System.out.println("========== LISTA SIMPLE ==========");

        ListaEnlazada<String> lista = new ListaEnlazada<>();

        lista.insertarSimple("Solicitud 1");
        lista.insertarSimple("Solicitud 2");
        lista.insertarSimple("Solicitud 3");

        lista.recorrerSimple();
    }

    // =====================================
    // LISTA DOBLEMENTE ENLAZADA
    // =====================================

    public static void probarListaDoble() {

        System.out.println("========== LISTA DOBLE ==========");

        ListaEnlazada<String> lista = new ListaEnlazada<>();

        lista.insertarDoble("Cancion 1");
        lista.insertarDoble("Cancion 2");
        lista.insertarDoble("Cancion 3");

        lista.recorrerDobleAdelante();
        lista.recorrerDobleAtras();
    }

    // =====================================
    // LISTA CIRCULAR
    // =====================================

    public static void probarListaCircular() {

        System.out.println("========== LISTA CIRCULAR ==========");

        ListaEnlazada<String> lista = new ListaEnlazada<>();

        lista.insertarCircular("Video 1");
        lista.insertarCircular("Video 2");
        lista.insertarCircular("Video 3");

        lista.recorrerCircular();
    }

    // =====================================
    // PILA LIFO
    // =====================================

    public static void probarPila() {

        System.out.println("========== TDA PILA STACK - LIFO ==========");

        PilaLIFO<Integer> pila = new PilaLIFO<>(5);

        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("\nElementos ingresados:");
        pila.mostrar();

        System.out.println("\nElemento superior: " + pila.peek());

        System.out.println("Elemento retirado: " + pila.pop());

        System.out.println("Nueva cima: " + pila.peek());

        System.out.println("Cantidad de elementos: " + pila.size());
    }

    // =====================================
    // COLA CIRCULAR FIFO
    // =====================================

    public static void probarCola() {

        System.out.println("========== COLA CIRCULAR FIFO ==========");

        ColaCircularFIFO<String> cola =
                new ColaCircularFIFO<>(3);

        cola.enqueue("Cliente 1");
        cola.enqueue("Cliente 2");
        cola.enqueue("Cliente 3");

        cola.mostrar();

        System.out.println("\nPrimer elemento: " + cola.peek());

        System.out.println("Elemento atendido: " + cola.dequeue());

        cola.enqueue("Cliente 4");

        System.out.println("\nCola despues de reutilizar espacio:");

        cola.mostrar();

        System.out.println("\nEstado de la cola:");
        cola.mostrarEstado();
    }

    // =====================================
    // EDITOR DE TEXTO UNDO / REDO
    // =====================================

    public static void ejecutarEditor() {

        EditorTextoLIFO editor = new EditorTextoLIFO();

        int opcion;

        do {

            System.out.println("\n======================================");
            System.out.println("       TDA PILA STACK - LIFO");
            System.out.println("       EDITOR DE TEXTO");
            System.out.println("======================================");

            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (UNDO)");
            System.out.println("3. Rehacer (REDO)");
            System.out.println("4. Mostrar texto");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Regresar");

            System.out.print("\nSeleccione una opcion: ");

            opcion = leerEntero();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Escriba el texto: ");
                    String texto = teclado.nextLine();
                    editor.escribir(texto);
                    break;

                case 2:
                    System.out.println("========== DESHACER ==========");
                    editor.deshacer();
                    break;

                case 3:
                    System.out.println("========== REHACER ==========");
                    editor.rehacer();
                    break;

                case 4:
                    System.out.println("========== TEXTO ACTUAL ==========");
                    editor.mostrarTexto();
                    break;

                case 5:
                    System.out.println("========== HISTORIAL ==========");
                    editor.mostrarHistorial();
                    break;

                case 6:
                    System.out.println("Regresando al menu principal...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

            if (opcion != 6) {
                System.out.println("\nPresione ENTER para continuar...");
                teclado.nextLine();
            }

        } while (opcion != 6);
    }
}