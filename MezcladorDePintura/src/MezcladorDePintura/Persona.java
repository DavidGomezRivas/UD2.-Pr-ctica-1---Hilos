package MezcladorDePintura;

// La clase Persona implementa la interfaz Runnable, permitiendo que sus instancias se ejecuten en un hilo.
class Persona implements Runnable {
    private final ColorDeposito primerColor; // Primer color para mezclar.
    private final ColorDeposito segundoColor; // Segundo color para mezclar.
    private final String colorSecundario; // Color resultante de la mezcla.

    // Constructor para inicializar los colores primarios y el color secundario.
    public Persona(ColorDeposito primerColor, ColorDeposito segundoColor, String colorSecundario) {
        this.primerColor = primerColor;
        this.segundoColor = segundoColor;
        this.colorSecundario = colorSecundario;
    }

    @Override
    public void run() {
        while (true) { // Bucle infinito para simular el proceso continuo de mezcla de colores.
            try {
                // Obtiene acceso exclusivo al primer depósito de color.
                synchronized (primerColor) {
                    // Obtiene acceso exclusivo al segundo depósito de color.
                    synchronized (segundoColor) {
                        // Imprime que la persona está preparando el color secundario.
                        System.out.println(Thread.currentThread().getName() + " está preparando color " + colorSecundario);
                        // Usa los depósitos de los colores primarios.
                        primerColor.usarDeposito();
                        segundoColor.usarDeposito();
                        // Imprime que la persona ha terminado de preparar el color secundario.
                        System.out.println(Thread.currentThread().getName() + " ha preparado color " + colorSecundario);
                    }
                }
                // El hilo duerme un tiempo aleatorio entre 1 y 2 segundos antes de intentar preparar el color de nuevo.
             Thread.sleep((long)(Math.random() * 1000 + 1000));
            } catch (InterruptedException e) {
                // En caso de interrupción, interrumpe el hilo actual.
                Thread.currentThread().interrupt();
            }
        }
    }
}