package ejSemaforo;

public class MianVehiculo {
    public static void main(String[] args) {
        Puente puente = new Puente();

        Vehiculo v1 = new Vehiculo("BMW1", puente, "izquierda");
        Vehiculo v2 = new Vehiculo("Citroen1", puente, "izquierda");
        Vehiculo v3 = new Vehiculo("Hyundai2", puente, "derecha");
        Vehiculo v4 = new Vehiculo("Mercedes2", puente, "derecha");
        Vehiculo v5 = new Vehiculo("Seat1", puente, "izquierda");
        Vehiculo v6 = new Vehiculo("Peugeot2", puente, "derecha");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();
        v6.start();
    }
}
