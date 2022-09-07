package PkgLinkedList;
import java.util.Scanner;
public class AppLinkedList {
    //method menampilkan isi
    public static void cetakLL(cNode n){
        System.out.print("Isi LL:");
        for(cNode t=n; t!=null; t=t.getNext()){
        System.out.print(t.getData()+" ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
//        cNode n1,n2,n3;
//        n1 = new cNode(12);
//        n2 = new cNode(34);
//        n3 = new cNode(56);
        //sambungkan/ kaitkan antar simpul
//        n1.setNext(n3);
//        n3.setNext(n2);
//        cetakLL(n1);
        Scanner sc = new Scanner(System.in);
        cNode node=null;
        cLinkedList LL = new cLinkedList(null);
        int pilih=0;
        do{
            System.out.println("\nMENU LINKED LIST");
            System.out.println("1. Tambah Node");
            System.out.println("2. Hapus Node");
            System.out.println("3. Cari Data");
            System.out.println("4. Cetak Linked List");
            System.out.println("5. Exit");
            System.out.print("Pilih = ");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Masukkan Data = ");
                    int d = sc.nextInt();
                    node = new cNode(d);
                    LL.addNodeFront(node);
                    break;
                case 2:
                    LL.delNodeBehind(node);
                    break;
                case 3:
                    System.out.print("Masukkan Data yang dicari =");
                    d = sc.nextInt();
                    LL.find(d);
                    break;
                case 4:
                    LL.print();
                    break;
                case 5:
                System.out.println("Terima kasih...");
                     break;
                    }
                }while(pilih!=5);
            }
    
//        cNode n1,n2,n3;
//
//        n1 = new cNode(12);
//
//        n2 = new cNode(34);
//
//        n3 = new cNode(56);
        
//        n1.setNext(n2);
//        n2.setNext(n3);
//        //hapus
//        n1.setNext(n3);
//        n2 = null; // memutus link
//
//        cetakLL(n1); //cetak mulai dari n1
    }

    
       
    

