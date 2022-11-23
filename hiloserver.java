import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class hiloserver extends Thread{


    Socket cliente;
    int contador;

    public hiloserver(Socket cliente) {
        this.cliente = cliente;
    }

    public hiloserver(Socket cliente, int contador) {
        this.cliente = cliente;
        this.contador=contador;
    }

    @Override
    public void run() {
        System.out.println("le llega al hilo el valor:"+contador);
        OutputStream aux = null;
        try {
            aux = cliente.getOutputStream();
            DataOutputStream flujo = new DataOutputStream(aux);

            flujo.writeUTF("Hola cliente "+ contador );

            flujo.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
