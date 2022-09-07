package PkgPalindrom;
public class cSimpul {
    private String kata;
    cSimpul next,prev;

    cSimpul(String kata) {
    this.kata = kata;
    next = null;    
    }

    public String getKata() {
        return kata;
    }

    public cSimpul getNext() {
        return next;
    }

    public void setNext(cSimpul next) {
        this.next = next;
    }
}
