package cripto_udp_atv8_seg_redes;

// created on 29/09/2010 at 22:30import java.io.*;
import java.io.*;
import java.net.*;

class UDPClient {
    //public static void main(String args[]) throws Exception

    public void iniciarComunicacao() throws Exception {
        BufferedReader inFromUser
                = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String resp = "n";
        while (!resp.equals("s") || !resp.equals("S")) { 
            System.out.println("******************************************************");
            System.out.println("Digite a mensagem que você deseja enviar:");
            String sentence = inFromUser.readLine();
            System.out.println("Digite a senha para criptografar");
            String senha = inFromUser.readLine();
            StringEncrypter c = new StringEncrypter(senha);
            sentence = c.encrypt(sentence);
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("Do servidor:" + modifiedSentence);
            System.out.println("Deseja sair? (s/n)");
            resp = inFromUser.readLine();
            receivePacket = null;
            receiveData = null;
            receiveData = new byte[1024];
            System.out.println("******************************************************");
        }

        clientSocket.close();
    }
}
