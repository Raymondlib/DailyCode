package LinkedList;

public class LinkedList {
    Node head=null;
    Node tail=null;
    public class Node{
        int val;
        Node next =null;
        public Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public LinkedList(int val){
        this.head = new Node(val);
        this.tail =head;
    }
    private Node add(int val){
        if(head == null)  {
            head = new Node(val) ;
            tail =head;
        }
        else {

            tail.next =new Node(val);
            tail = tail.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
    private void print(){
        Node t = head;
        while(t!=null){
            System.out.print(t.val + " ");
            t= t.next;
        }
    }
    private void print(Node head){
        Node t = head;
        while(t!=null){
            System.out.print(t.val + " ");
            t= t.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
        Reverse r = new Reverse();
        l.head = r.reverseBy2(l.head);
        l.print(l.head);
        System.out.println(l);
    }

}

