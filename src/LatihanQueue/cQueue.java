package LatihanQueue;
public class cQueue {
    cObject front, rear;
    int size;
    cQueue(){
        front = rear = null;        
        size = 0;
    }

    public void enqueue(cObject baru){
        if(rear==null){
            front = rear = baru;
        } else{
            rear.next = baru;
            baru.prev = rear;
            rear = baru;
        }
        size++;
        System.out.println(baru.getNama() + " Berhasil Ditambahkan...");        
    }

    public cObject dequeue(){
        if(rear == null){            
            return(null);
        }
        else if(front.next == null){
            cObject t = front;
            front = rear = null;            
            sleep3s();
            System.out.println("Transaksi " + t.getNama() + " Selesai!");
            size--;
            return(t);
        } else {
            cObject t = front.next;
            cObject t2 = front;
            t2.next = null;
            front = t;
            front.prev = null;                        
            sleep3s();
            System.out.println("Transaksi " + t2.getNama() + " Selesai!");
            size--;
            return(t);
        }
    }

    public void print(){          
        if (size == 0){
            System.out.println("Antrian Barang Kosong!");
        } else {
            System.out.print("Isi Antrian " + size + " : ");
            for (cObject t = front; t != null; t = t.next) {
                System.out.print("[" + t.getNama() + "] ");
            } 
            System.out.println("");
        }
    }

    public static void sleep3s() {
        System.out.println("Loading...");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
