package po1.it.unive.car;
//es.2.2

public class LinkedList {
    private Object item;
    LinkedList next;
    // Es.2.8
    LinkedList (Object car) {
        this.item = car;
    }
    public void setNext(LinkedList next){
        this.next=next;
    }
    //es.2.16
    public int count_items(){
        int n;
        for(n=0; this.item!=null; n++) {
            if(this.next!=null){
                this.item = this.next.item;
                next = next.next;
            }
            else
                this.item = null;
        }
        return n;
    }
}
