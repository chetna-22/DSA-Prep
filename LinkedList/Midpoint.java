package LinkedList;

public class Midpoint {

    static class Node{
        int data;
        Node next;
    
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node findMid(Node head){
       Node slow = head;
       Node fast = head;

       while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
       }
       return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
    

        Node mid = findMid(head);

        System.out.println(mid.data);
    }
}
