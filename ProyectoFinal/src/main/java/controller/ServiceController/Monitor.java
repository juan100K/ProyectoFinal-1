package controller.ServiceController;

public class Monitor {

    private int senial=0;

    private int bount=0;

    public Monitor(int top){
        this.bount=top;
    }

    public synchronized void ocupar() throws InterruptedException {
        while (this.senial==bount){
            wait();
        }
        this.senial++;
        this.notify();
    }

    public synchronized void liberar() throws InterruptedException {
        while (this.senial==0){
            wait();
        }
        this.senial--;
        this.notify();
    }
}
