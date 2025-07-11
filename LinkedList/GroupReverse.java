package LinkedList;

public class GroupReverse {
    static class Node{
        int data;
        Node next;
    
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node kGroup(Node head,int k){
        if(head == null){
            return null;
        }

        Node prev = null;
        Node next = null;
        Node curr = head;

        int count = 0;

        while(curr != null && count <k){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
           count++;
        }
        if(next != null){
            head.next = kGroup(next, k);
        }
        return prev;
    }
    public static void print(Node node){
        Node curr = node;

        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node newNode = kGroup(head,3);

        print(newNode);
    }
}
