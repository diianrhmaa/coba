package PkgPalindrom;
public class cStack {
    cSimpul top, bottom;
    int jumlah;

    cStack() {
        top = bottom = null;
        jumlah = 0;        
    }

    public void push(cSimpul item) {
        if (top == null) {
            top = item;
            bottom = item;
        } else {
            item.setNext(top);
            top = item;
        }
      System.out.println("Push " + item.getKata() +" sukses");
    }

    public String pop() {
        if (top == null) {
            System.out.println("Tumpukan kosong");
            return null;
        } else if (top.getNext() == null) {
            cSimpul temp = top;
            top = null;
            bottom = null;            
            return temp.getKata();
        } else {
            cSimpul temp = top;
            top = top.getNext();            
            return temp.getKata();
        }
    }    
}
