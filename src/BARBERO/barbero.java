package BARBERO;

public class barbero {
    private boolean dormido;
    private int sillas;
    private boolean hayCliente;

    public barbero(boolean dormido, int sillas, boolean hayCliente) {
        this.dormido = dormido;
        this.sillas = sillas;
        this.hayCliente = hayCliente;
    }

    public boolean isDormido() {
        return dormido;
    }

    public void setDormido(boolean dormido) {
        this.dormido = dormido;
    }

    public int getSillas() {
        return sillas;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }

    public boolean isHayCliente() {
        return hayCliente;
    }

    public void setHayCliente(boolean hayCliente) {
        this.hayCliente = hayCliente;
    }

    public synchronized void dormir(){
        try {
            while (!hayCliente) wait();
            hayCliente= true;
            dormido= true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void despertarBarbero(){
        while(!dormido)
    }

    public synchronized void cortarPelo(){

    }




}
