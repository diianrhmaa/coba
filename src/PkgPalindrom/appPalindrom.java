package PkgPalindrom;
import java.util.Scanner;
public class appPalindrom {
    public static void main(String[] args) {
        int pilih=0;
        Scanner s = new Scanner(System.in);    
        do {
            System.out.println("\nMenu Palindrom");
            System.out.println("1. Cek Kata");
            System.out.println("2. Exit");
            System.out.print("Pilih = ");
            pilih=s.nextInt();
            switch(pilih){
                
                case 1:
                    cekPalindrom();
                    break;

                case 2:
                    System.out.println("Thank You!");
                    break;                                
            }            
        } while (pilih!=2);        
        s.close();
    }

    private static void cekPalindrom(){

        Scanner s = new Scanner(System.in);    
        int jumlahKata = 0;
        boolean cek = false;

        cStack stack = new cStack();
        cStack reverseStack = new cStack();

        System.out.print("Masukkan kata : ");
        String kata = s.next();
        jumlahKata = kata.length();

        System.out.println("\nUrutan Kata Maju");
        for (int i = 0; i < jumlahKata; i++) {
            stack.push(new cSimpul(kata.split("")[i]));
        }
        
        System.out.println("\nUrutan Kata Mundur");
        for (int i = jumlahKata - 1; i >= 0; i--) {
            reverseStack.push(new cSimpul(kata.split("")[i]));
        }
        
        System.out.println();
    
        for (int i = 0; i < jumlahKata; i++) {            
            String popKata = stack.pop();            
            String popReverseKata = reverseStack.pop();
            if (popKata.equalsIgnoreCase(popReverseKata)) {                
                cek = true;
            } else {            
                cek = false;
                break;
            }
        }

        if(cek == true){
        System.out.println("Hasil Cek Palindrom Dari Kata " + kata + 
        " Adalah Palindrom");
        } else if(cek == false){
        System.out.println("\nHasil Cek Palindrom Dari Kata " + kata + 
        " Adalah Bukan Palindrom");
        }        
    }
}