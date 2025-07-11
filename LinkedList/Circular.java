package LinkedList;

public class Circular {
    static class Node{
        int data;
        Node next;
    
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static boolean check(Node head){
        if(head == null){
            return true;
        }
        Node curr = head.next;

        while(curr != null && curr != head){
            curr = curr.next;
        }
        
        if(curr == head){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;
 

        System.out.println(check(head));
    }
}
