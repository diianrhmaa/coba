package LatihanQueue;
import java.util.Scanner;
public class appQueue {
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int pilih = 0;
        cQueue q = new cQueue();
        do{
            System.out.println("\nAPP TOKO");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Proses Barang");
            System.out.println("3. Daftar Pembelian Barang");
            System.out.println("4. Exit");
            System.out.print("Pilih : ");
            pilih = s.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Masukkan Nama : ");
                    String nm = s.next();
                    cObject b = new cObject(nm);
                    q.enqueue(b);
                    break;
                case 2:
                    cObject t = q.dequeue();                    
                    if(t == null){
                        System.out.println("Transaksi kosong!");   
                    }                    
                    break;
                case 3:
                    q.print();
                    break;
                case 4:
                    System.out.println("Terima Kasih...");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia");
            }
        }while(pilih != 4);
    }  
}