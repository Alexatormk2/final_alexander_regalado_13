import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {


    static  int cont;
    public static void main(String[] args) {

        ServerSocket skServidor= null;
        System.out.println("Servidor arrancado");
        try {
            skServidor = new ServerSocket(4999);
        } catch (IOException e) {
            e.printStackTrace();
        }



        while(true){


            try {
                Socket skcliente=skServidor.accept();
                cont++;
                System.out.println("valor de cont: "+cont);
                hiloserver hs=new hiloserver(skcliente,cont);
                hs.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }
}
