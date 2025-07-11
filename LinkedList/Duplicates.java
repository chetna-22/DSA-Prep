package LinkedList;

public class Duplicates {

    static class Node{
        int data;
        Node next;
    
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void removeDuplicates(Node head){
        Node curr = head;
        while(curr.next != null){
            if(curr.data == curr.next.data){

                Node temp = curr.next.next;
                curr.next = temp;
            }else{
                curr = curr.next;
            }
            
        }
    }
    public static void print(Node head){
       Node curr = head;
       while(curr != null){
        System.out.print(curr.data+" ");
        curr = curr.next;
       }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3); 
        head.next.next.next.next.next = new Node(4); /// arrays is present in sorted order

        removeDuplicates(head);
        print(head);
    }
}
