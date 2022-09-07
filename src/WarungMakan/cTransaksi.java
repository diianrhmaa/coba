package WarungMakan;
import java.util.Scanner;
//menampung menu yang dipesan
public class cTransaksi {
    private cPembeli pembeli;
    private String nama;
    private cMenu menu[];
    private int jumlah[];
    private int jml;
    private int jmenu,maksmenu,total,count,indeks;
    //Class CONTAINER-nya adalah transaksi
    //Yang menjadi objeknya adalah makanan
    cTransaksi(){
        maksmenu=10; indeks=0;
        jmenu=0; total=0; count=0;
        menu = new cMenu[maksmenu];
        jumlah = new int [maksmenu];
        System.out.println("  Objek transaksi dibuat..");
    }
    public int getJumlah(int idx,int Jumlah){
        count=idx; jml=Jumlah;
        return jumlah[count] = jml;
    }
    public void isiPembeli(cPembeli p){
        pembeli = p;
        System.out.println("    Isi pembeli sukses...");
    }
    public void tambahMenu(cMenu m){
        if(jmenu>=maksmenu){
            System.out.println("    Kapasitas penuh");
        }
        else{
            menu[jmenu]=m;
            jmenu++;
            System.out.println("    Penambahan sukses..");
        }
    }
    public void lihatMenu(){
        if(pembeli==null)
            System.out.println("    Pembeli belum ada!");
        else{
            System.out.println("    "+pembeli.ToString());
            if(jmenu==0){
                System.out.println("    Belum Ada Pesanan!");
            }
            else{
                for (int i = 0; i < jmenu; i++) {
                    System.out.println("    "+(i+1)+"."+menu[i].ToString()+"\t"+jumlah[i]+" porsi");
                }
            }
        }
    }
    public void hapusMenu(String m){
        Scanner sc = new Scanner (System.in);
        boolean ada=false;
        for (int i = 0; i < jmenu; i++) {
            if (m.equalsIgnoreCase(menu[i].getNama())) {
                ada=true;
                indeks=i;
                break;
            }
        }
        if(ada==true){
            int h=0;
            System.out.println("      Yakin dihapus?");
            System.out.println("      1.Ya");
            System.out.println("      2.Tidak");
            System.out.print("      Pilih = ");
            h = sc.nextInt();
            if(h==1){
                menu[indeks]=null;
                //geser maju elemen
                for (int j = indeks; j < jmenu; j++) {
                    if(indeks==jmenu-1){
                        menu[j]=null;
                    }
                    else{
                        menu[j]=menu[j+1];
                    }
                }
                System.out.println("    Penghapusan sukses..");
                jmenu--;
                
            }
            else{
                System.out.println("    Batal dihapus!");
            }
        } 
        else{
            System.out.println("    Makanan tidak ada!");
        } 
    } 
}
