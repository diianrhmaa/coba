package WarungMakan;
//class induk dari class makanan dan class minuman
public class cMenu {
    private cMakanan[] makanan; 
    private cMinuman minuman[];
    private String nama;
    private int harga;
    private cMenu menu[];
    private int jmenu,maksmenu,total,indeks=0;
    cMenu(String n, int h){
        nama=n; harga=h;
        maksmenu=15;
        jmenu = 0; total=0;
        System.out.println("      Objek "+nama+" dibuat..");
    }
    cMenu(){
        menu = new cMenu[maksmenu];
        makanan = new cMakanan[maksmenu];
        minuman = new cMinuman[maksmenu];
        System.out.println("      Objek "+nama+" dibuat..");
    }
    public void setHarga(int h){
        harga=h;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
    public String ToString(){
        return nama+" ["+harga+"]";
    }
}
