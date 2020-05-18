package LinkedList;
import BSTree.BinarySearchTree;
// 链表反转，
// 1使用栈 ；  2原地反转  3 头插法

public class Reverse {
    public LinkedList.Node reverseBy2(LinkedList.Node head){

        if(head == null || head.next ==null) return head ;
        LinkedList.Node pr=null;
        LinkedList.Node cur= head;
        LinkedList.Node next = cur.next;

//        1 2 3

        while(cur != null){
            next = cur.next;
            cur.next = pr;
            pr= cur;
            cur = next;
        }
        System.out.println(head);
        LinkedList.Node t = pr;
        while(t!=null){
            System.out.print(t.val + "+");
            t= t.next;
        }
        return pr;


    }

}
