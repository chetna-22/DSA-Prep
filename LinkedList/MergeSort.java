package LinkedList;

public class MergeSort {
    static class Node{
        int data;
        Node next;
    
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = findMid(head);

        //Node left =  head;;
        Node next = mid.next;

        mid.next  = null;

        Node left = mergeSort(head);
        Node right = mergeSort(next);

        Node res = merge(left,right);

        return res;
    }
    public static Node merge(Node left,Node right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        Node ans = new Node(-1);

        while(left != null && right != null){
            if(left.data < right.data){
                ans.next = left;
                ans = left;
                left  = left.next;
            }else{
                ans.next = right;
                ans = right;
                right = right.next;
            }
        }
        while(left != null){
            ans.next = left;
            ans = left;
            left  = left.next;
        }
        while(right != null){
            ans.next = right;
            ans = right;
            right = right.next;
        }

        ans = ans.next;
        return ans;
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

        Node newHead = mergeSort(head);

        print(newHead);
    }
}
