package LinkedList;

public class Sort {
    static class Node{
        int data;
        Node next;
    
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void insertAtTail(Node tail,Node curr){
        tail.next = curr;
        tail = curr;
    }
    public static Node sort(Node head){
        Node head0 = new Node(-1);
        Node tail0 = head0;

        Node head1 = new Node(-1);
        Node tail1 = head1;

        Node head2 = new Node(-1);
        Node tail2 = head2;

        Node curr = head;


        while(curr != null){
            int val = curr.data;
            if(val == 0){
                insertAtTail(tail0,curr);
            }else if(val == 1){
                insertAtTail(tail1,curr);
            }else{
                insertAtTail(tail2,curr);
            }
            curr = curr.next;
        }

        if(head1.next != null){
            tail0.next = head1.next;
        }else{
            tail0.next = head2.next;
        }

        tail1.next = head2.next;
        tail2.next = null;

        return head0.next;
    }
    public static void print(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
   
        Node sorted = sort(head);

        print(sorted);
        
    }
}
