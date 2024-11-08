package ejSemaforo;

public class Puente {
    public enum EstatPont {
        LLIURE, OCUPAT
    }

    private int vehiculos;
    private EstatPont estatP;
    private String sentidoActual;

    public Puente() {
        this.estatP = EstatPont.LLIURE; // Inicializamos el puente como libre
        this.vehiculos = 0;
        this.sentidoActual = null; // Sin sentido hasta que entre el primer vehículo
    }

    public synchronized void entrar(String sentido) {
        try {
            while (estatP == EstatPont.OCUPAT && (!sentido.equals(sentidoActual) || vehiculos >= 3))wait();
            estatP = EstatPont.OCUPAT;
            sentidoActual = sentido;
            vehiculos++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void salir() {
        vehiculos--;
        if (vehiculos == 0) {
            estatP = EstatPont.LLIURE;
            sentidoActual = null;
        }

        notifyAll();
    }
}
