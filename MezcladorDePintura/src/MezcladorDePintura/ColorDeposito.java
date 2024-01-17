package MezcladorDePintura;

// La clase ColorDeposito representa un depósito de un color específico de pintura.
class ColorDeposito {
    private final String nombre; // Variable para almacenar el nombre del color.

    // Constructor para inicializar el nombre del color del depósito.
    public ColorDeposito(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el nombre del color.
    public String getNombre() {
        return nombre;
    }

    // Método sincronizado para usar el depósito. Asegura que solo un hilo pueda usar este depósito a la vez.
    public synchronized void usarDeposito() throws InterruptedException {
        long inicio = System.currentTimeMillis();
        // Imprime cuando un hilo comienza a usar el depósito.
        System.out.println(Thread.currentThread().getName() + " comienza a utilizar el depósito de " + nombre);
        // El hilo duerme por un tiempo aleatorio entre 100 y 500 milisegundos, simulando el uso del depósito.
        Thread.sleep((long) (Math.random() * 400 + 100));
        long fin = System.currentTimeMillis();
        // Imprime cuando el hilo termina de usar el depósito y el tiempo que tardó.
        System.out.println(Thread.currentThread().getName() + " ha terminado de utilizar el depósito de " + nombre + ". Tiempo de uso: " + (fin - inicio) + " ms");
    }
}