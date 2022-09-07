package PkgLinkedList;
public class cLinkedList {
    private cNode header, tail;
    private int jNode;
    cLinkedList(cNode h){
        header=h; tail=h; jNode=0;
        System.out.println("Object dibuat");
    }
    //method untuk menambah simpul di depan
    public void addNodeFront(cNode baru){
       if(header==null){
       header=tail=baru;
    }
       else{
       baru.setNext(header);
       header=baru;
    }
       jNode++;
       System.out.println("Penambahan simpul depan...");
    }
    
    //method untuk menambah simbul di belakang
    public void addNodeBehind(cNode baru){
       if(tail==null){
       header=tail=baru;
    }
       else{
       tail.setNext(baru);//sambungkan linkedlist
       tail=baru; // update posisi tail
    }
       jNode++;
       System.out.println("Penambahan simpul belakang...");
    }
    
    //method untuk menghapus simpul di depan
    public int delNodeFront(){
    int temp=0;
       if(header!=null){
       cNode t=header.getNext();//simpan header baru
       temp=header.getData(); 
       header.setNext(null); //putuskan header lama
       header=t; //update simpul header yang baru
       jNode--;
       System.out.println("Penghapusan simpul depan...");
    }
       else System.out.println("Linked list kosong!");
       return temp;
    }
    
    //method untuk menghapus simpul di belakang
    public cNode delNodeBehind(cNode header){
        if(header==null){
            return header;
        }
        cNode tail = header;
        cNode previousToTail = null;
      
        while(tail.getNext()!= null){
            previousToTail = tail;
            tail = tail.getNext();
//            jNode--;
        }
        previousToTail.setNext(null);
        return tail;
    }
    
    //method untuk menampilkan isi linked list
    public void print(){
    System.out.print("Isi Linked List: ");
        for (cNode t = header; t!=null; t=t.getNext()) {
        System.out.print(t.getData()+" ");
    }
        System.out.println("");
    }
    
    //method untuk mencari data di dalam linked list
    public void find(int f){
    boolean ada=false;
    System.out.print("Hasil pencarian: ");
        for (cNode t = header; t!=null; t=t.getNext()) {
        if(t.getData()==f){
        ada=true;
        break;
        }
    }
        if(ada==false){
        System.out.println("Tidak ditemukan!");
    }
        else{
        System.out.println("Ditemukan...");
    }
        System.out.println("");
    }

}
