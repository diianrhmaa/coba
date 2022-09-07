package FinalProjectBP2;

public class cMakanan {
    String nama;
    int harga;

    cMakanan(String n, int h){
        nama=n;
        harga=h;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
    public String disp(){
        return nama+" "+harga;
    }

    public void setharga(int hrgbaru) {
       harga=hrgbaru;
    }
}