package LatihanQueue;
public class cObject{
    private String nama;
    cObject next,prev;
    cObject(String n){
        nama = n;
        next = prev = null;        
    }
    public String getNama(){
        return nama;
    }
}
