package MezcladorDePintura;

// Clase principal que simula el mezclador de pintura.
public class MezcladorDePintura {
    public static void main(String[] args) {
        // Creación de depósitos de colores primarios.
        ColorDeposito cian = new ColorDeposito("Cian");
        ColorDeposito magenta = new ColorDeposito("Magenta");
        ColorDeposito amarillo = new ColorDeposito("Amarillo");

        // Creación e inicio de hilos que representan personas mezclando colores.
        Thread persona1 = new Thread(new Persona(amarillo, magenta, "Rojo"), "Persona 1");
        Thread persona2 = new Thread(new Persona(magenta, cian, "Azul"), "Persona 2");
        Thread persona3 = new Thread(new Persona(amarillo, cian, "Verde"), "Persona 3");

        persona1.start();
        persona2.start();
        persona3.start();
    }
}
