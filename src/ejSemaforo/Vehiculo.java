package ejSemaforo;

public class Vehiculo extends Thread {
    private Puente puente;
    private String sentido;

    public Vehiculo(String nom, Puente puente, String sentido) {
        super(nom);
        this.puente = puente;
        this.sentido = sentido;
    }

    public void run() {
        for (;;) {
            puente.entrar(sentido);
            System.out.println(getName() + " está cruzando el puente en sentido " + sentido);
            try {
                Thread.sleep((long) (Math.random() * 1500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            puente.salir();
            System.out.println(getName() + " ha salido del puente en sentido " + sentido);

            try {
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
