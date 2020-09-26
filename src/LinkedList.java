public class LinkedList {
    Object item;
    LinkedList next;
    public int count_items(){
        int n=0;
        for (n=1; next !=  null && item != null; n++){
            item = next.item;
            next = next.next;
        }
        return n;
    }
}
