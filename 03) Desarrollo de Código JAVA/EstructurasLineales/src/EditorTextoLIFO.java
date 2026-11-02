public class EditorTextoLIFO {

    private String texto = "";
    private PilaLIFO<String> deshacer = new PilaLIFO<>(10);
    private PilaLIFO<String> rehacer = new PilaLIFO<>(10);

    // Escribir
    public void escribir(String nuevoTexto) {
        if (deshacer.isFull()) {
            System.out.println("Historial lleno");
            return;
        }

        deshacer.push(texto);
        texto = texto + nuevoTexto;
        rehacer.limpiar();

        System.out.println("Texto guardado: " + texto);
    }

    // Deshacer
    public void deshacer() {
        if (!deshacer.isEmpty() && !rehacer.isFull()) {
            rehacer.push(texto);
            texto = deshacer.pop();
            System.out.println("Texto actual: " + texto);
        } else {
            System.out.println("No se puede deshacer");
        }
    }

    // Rehacer
    public void rehacer() {
        if (!rehacer.isEmpty() && !deshacer.isFull()) {
            deshacer.push(texto);
            texto = rehacer.pop();
            System.out.println("Texto actual: " + texto);
        } else {
            System.out.println("No se puede rehacer");
        }
    }

    // Mostrar texto
    public void mostrarTexto() {
        System.out.println("Texto actual: " + texto);
    }

    // Mostrar historial
    public void mostrarHistorial() {
        System.out.println("\nPila Deshacer:");
        deshacer.mostrar();

        System.out.println("\nPila Rehacer:");
        rehacer.mostrar();
    }
}