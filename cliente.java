import java.io.*;
import java.net.Socket;

public class cliente {


    static final String HOST = "localhost";
    static final int PUERTO = 4999;

    public cliente() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        try {


            Socket skCliente = new Socket(HOST, PUERTO);
            InputStream aux = skCliente.getInputStream();//Creamos un Input Stream para recibir las respuestas del server
            OutputStream send = skCliente.getOutputStream();
            DataOutputStream fluir = new DataOutputStream(send);
            DataInputStream flujo = new DataInputStream(aux);
            System.out.println("Mensaje escrito desde el server"+flujo.readUTF());
            int opcion =0;
            do{
                System.out.println("mandar algo(1) o salir(2) ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion){
                    case 1:
                        System.out.println("Escribe algo");
                        String mensaje = br.readLine();
                        fluir.writeUTF(mensaje);
                        break;
                    case 2:
                        System.out.println("bye");
                        break;

                }
            }while(opcion != 2);
            aux.close();
            skCliente.close();


        } catch (Exception e) {


            System.out.println(e.getMessage());


        }


    }

    public static void main(String[] arg) throws IOException {


        new cliente();


    }
}
