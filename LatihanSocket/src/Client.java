/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alfend
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket s=null;
        PrintStream output;
        BufferedReader pesan;
  
        try {
            s=new Socket("127.0.0.1",212); //IP Server tujuan dan port-nya
            output=new PrintStream(s.getOutputStream());
            pesan=new BufferedReader(new InputStreamReader(System.in));
            
              System.out.println("Mbaknya mau nulis apa? ");
              output.println(pesan.readLine());
              
              output.close();
              s.close();
            
        } catch (IOException e) {
        }
    

    }
}
