/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alfend
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) {
        ServerSocket ss;
        Socket s;
        DataInputStream input;
        String pesan="";
        
        try {
            ss=new ServerSocket(212); //ini port
            System.out.println("Server Siap Mbak...");
            
            s = ss.accept(); //ini menghubungkan S dengan SS
            System.out.println("Ada client yang hadir...");
            
            //menerima input dari client
            input = new DataInputStream((s.getInputStream()));
            pesan = input.readLine();
            System.out.println("Mbaknya Client bilang: "+pesan);
            
            input.close();
            s.close();
            ss.close();
            
            
        } catch (IOException e) {
        }
        
    }

    private static class SeverSocket {

        public SeverSocket() {
        }

        private void close() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Socket accept() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
