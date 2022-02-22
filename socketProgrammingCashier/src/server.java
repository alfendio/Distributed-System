/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alfend
 */

import java.io.DataInputStream; //tipe data java primitif
import java.io.DataOutputStream; //tipe data java primitif
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;


public class server {
    public static void main(String[] args) {
        //1. siapkan ss, s, input, barang, dan variabel
        ServerSocket ss;
        Socket s;
        DataInputStream input; //DIS di server, untuk menerima input
        String barang;
        int item;
        int harga = 0;
        int total;
        int diskon;
        
        //2. buat try catch pakai Input Output Exception
        try {
            //ini adalah sambungan dari ServerSocket ss;
            ss=new ServerSocket(212);  //dalam parameter sisipkan port, kita pakai yang 212 
            System.out.println("Server kasir siap Mbak..."); //memberi notice
            
            //ini adalah sambungan dari Socket s;
            s = ss.accept(); //ini menghubungkan S dengan SS, SS menerima
            System.out.println("Ada client yang hadir Mbak..."); //memberi notice, jika ada client hadir SS dengan S terhubung
            
                        //menerima input dari client
                        //input = new DataInputStream((s.getInputStream()));
                        //pesan = input.readLine(); //mengubah data InputStream menjadi string biasa
                        //System.out.println("Mbaknya Client bilang: "+pesan); //server baca pesan dari client
                        
            //menerima input dari client           
            input = new DataInputStream(s.getInputStream());
            barang = input.readUTF();
            item = input.readInt();
            System.out.println("\n---------------------------------");
            System.out.println("Barang yang dibeli : " + barang); // menampilkan input dari client
            System.out.println("Jumlah : " + item); // menampilkan input dari client
            
            // algoritma untuk cek barang
            if ("roti".equals(barang) || "Roti".equals(barang) || "ROTI".equals(barang)) {
            harga = 35000;
            } 
            else if ("selai".equals(barang) || "Selai".equals(barang) || "SELAI".equals(barang)) {
            harga = 20000;
            } 
            else if ("coklat".equals(barang) || "Coklat".equals(barang) || "COKLAT".equals(barang)) {
            harga = 25000;
            } 
            else if ("es krim".equals(barang) || "Es Krim".equals(barang) || "ES KRIM".equals(barang)) {
            harga = 30000;
            } 
            else if ("susu".equals(barang) || "Susu".equals(barang) || "SUSU".equals(barang)) {
            harga = 50000;
            }
            System.out.println("Harga per item : Rp. " + harga);
            
            // algoritma hitung total harga
            total = harga * item;  
            // algortima hitung harga dengan diskon 10%
            diskon = (total * 90) / 100; 
            System.out.println("---------------------------------");
            System.out.println("Total Harga : Rp. " + total);
            System.out.println("Diskon Harga 10% : Rp. " + diskon);
            
            // mengirim data ke client
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            output.writeUTF(String.valueOf(total));
            output.writeUTF(String.valueOf(diskon));
            
            //setelah selesai close semua
            input.close();
            output.close();
            s.close();
            ss.close();
            
            
        } catch (IOException e) {
        }
        
        
    }
}
