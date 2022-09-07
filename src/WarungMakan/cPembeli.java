package WarungMakan;
public class cPembeli {
    //menampung seluruh pembeli yang melakukan transaksi
    //menampung data pembeli yang berstatus sebagai member
    private String nama;
    private String Member;
    private String alamat;
    private cPembeli member[];
    private int maksmbr,jmbr=0,indeks;
    //CONSTRUCTOR kosongan
    cPembeli(){
        nama="";
        member = new cPembeli[maksmbr];
        System.out.println("      Objek pembeli dibuat..");
    }
    cPembeli(String n,String al){
        Member = n; alamat = al;
        maksmbr=20; jmbr=0; indeks=0;
        System.out.println("      Objek "+Member+" dibuat..");
    }
    public void setNama(String n){
        nama=n;
    }
    public String getNama(){
        return nama;
    }
    public String ToString(){
        return "pembeli = "+nama;
    }
    public String getMember(){
        return Member;
    }
    public void setAlamat(String al){
        alamat=al;
    }
    public String getAlamat(){
        return alamat;
    }
    public String ToStringMember(){
        return Member+"\t["+alamat+"]";
    }
}
