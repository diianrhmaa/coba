package FinalProjectBP2;

public class cTransaksi {
    String kode;
    String pembeli;
    cMakanan makanan;
    int jumlahMkn;
    int status;
    int idmakanan;
    cTransaksi next;
    cTransaksi(String k, String p, cMakanan m, int j,int s, int idmk){
        kode=k; pembeli=p; makanan=m; jumlahMkn=j; status=s; idmakanan=idmk;
        next=null;
    }

    public void setStatus(int s){
        status=s;
    }
    public String getKode(){
        return kode;
    }
    public String getPembeli(){
        return pembeli;
    }
    public cMakanan getMakanan(){
       return makanan; 
    }
    public int getJumlah(){
        return jumlahMkn;
    }
    public int getStatus(){
        return status;
    }
    
     int getIdMkn() {
        return idmakanan;
    }
}
