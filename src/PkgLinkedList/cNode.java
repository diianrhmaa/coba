package PkgLinkedList;
public class cNode {
    private int data;
    private cNode next;
    cNode(int d){
    data = d; next=null;
}

    public void setData(int d) {
        this.data = d;
    }

    public void setNext(cNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public cNode getNext() {
        return next;
    }
}
