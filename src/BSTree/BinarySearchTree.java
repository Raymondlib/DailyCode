package BSTree;

public class BinarySearchTree {
    static class Node{
        int val;
        int count=0;
        Node left =null;
        Node right=null;
        public Node(int val){
            this.val = val;
        }
    }
    private Node insert(Node root,int val){
        if(root == null) return new Node(val);
        if(root.val == val) root.count++;
        if(root.val < val) root.right = insert(root.right,val);
        if(root.val > val) root.left = insert(root.left,val);
        return root;
    }
    private void delete(Node root,int val){
        if(root !=null){

            if(root.val == val ) {
                if(root.right ==null && root.left==null) root=null;
                if(root.left ==null) root = root.right;
                if(root.right ==null) root = root.left;
                root.val = findMin(root.right);
            }
            if(root.val < val ) delete(root.right,val);
            if(root.val > val ) delete(root.right,val);
        }
    }
    private int findMin(Node root){
        if(root == null) return Integer.MIN_VALUE;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }
    public void inorder(Node root){
        if(root !=null ) {
            inorder(root.left);
            System.out.print(root.val+ " ");
            inorder(root.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = new Node(50);
        bst.insert(root,20);
        bst.insert(root,40);
        bst.insert(root,60);
        bst.inorder(root);
    }
}
