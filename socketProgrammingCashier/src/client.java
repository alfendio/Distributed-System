/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alfend
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket; //karena di client maka pake S (Socket)
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Socket s=null; //buat S
                    //PrintStream output; //diclient pake PS untuk mengirim output
                    //BufferedReader pesan; //untuk baca inputan teks dari keyboard
                    
        DataOutputStream output; //tipe data java primitif
        DataInputStream input; 
        Scanner sc;
        String barang;
        String total;
        String diskon;
        int item;
  
        //buat try catch pakai Input Output Exception
        try {
            s=new Socket("127.0.0.1",212); //pakai 2 parameter, IP Server tujuan dan port-nya
            
            // menampilkan data barang
            System.out.println("Silahkan mau beli apa? ada diskon 10% lohh..");
            System.out.println("-----------------------------");
            System.out.println("|    Barang    |    Harga   |");
            System.out.println("----------------------------");
            System.out.println("|    Roti      | Rp. 35.000 |");
            System.out.println("|    Selai     | Rp. 20.000 |");
            System.out.println("|    Coklat    | Rp. 25.000 |");
            System.out.println("|    Es Krim   | Rp. 30.000 |");
            System.out.println("|    Susu      | Rp. 50.000 |");
            System.out.println("-----------------------------");
            
            // mengambil inputan user
            sc = new Scanner(System.in);
            System.out.println("Barang yang dibeli:");
            barang = sc.nextLine();
            System.out.println("Jumlah :");
            item = sc.nextInt();
            
                        //output=new PrintStream(s.getOutputStream()); //output meletakkan teks di s
                        //pesan=new BufferedReader(new InputStreamReader(System.in)); //perintah untuk menerima inputan string
            
            // mengirim data ke server
            output = new DataOutputStream(s.getOutputStream());
            output.writeUTF(barang);
            output.writeInt(item);
 
            // menerima data dari server
            input = new DataInputStream(s.getInputStream());
            total = input.readUTF();
            diskon = input.readUTF();
            
                        //System.out.println("Mbaknya mau nulis apa? ");
                        //output.println(pesan.readLine()); //perintah untuk membawa teks
            
            // menampilkan total harga
            System.out.println("---------------------------------");
            System.out.println("Total Harga : Rp. " + total);
            // menampilkan total diskon harga
            System.out.println("Diskon Harga 10% : Rp. " + diskon);
             
            //setelah selesai, close semua
            output.close();
            input.close();
            s.close();
            
        } catch (IOException e) {
        }
    

    }
}






