package BSTree;

public class BinarySearchTree {
    Node root =null;
    static class Node{
        int val;     // 节点的值
        int count=0; // 记录值出现的次数
        Node left =null;
        Node right=null;
        public Node(int val){
            this.val = val;
        }
        // idea 使用 alt + insert 快速生成 toString
        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    private  Node insert(int val){
        return _insert(root,val);
    }
    private Node _insert(Node root,int val){
        if(root == null) return new Node(val);
        if(root.val == val) root.count++;
        if(root.val < val) root.right = _insert(root.right,val);
        if(root.val > val) root.left = _insert(root.left,val);
        return root;
    }
    private Node search(int val){
        return _search(root,val);
    }
    private Node _search(Node root,int val){
        return root ==null || root.val == val ? root :
                root.val < val ? _search(root.right,val): _search(root.left,val);
    }

    private void delete(int val){
        root = _delete(root,val);
    }
    private Node _delete(Node root,int val){
        if(root !=null){
            if(root.val == val ) {
//                if(root.right ==null && root.left==null) return null;
                if(root.count ==0){
                    if(root.left ==null) return root.right;
                    if(root.right ==null) return root.left;
                    Node min =  findMin(root.right);
                    root.val  =min.val;
                    root.count = min.count;
                    root.right = _delete(root.right,min.val);
                }else {
                    root.count--;
                }
            }
            if(root.val < val ) root.right = _delete(root.right,val);
            if(root.val > val ) root.left = _delete(root.left,val);
        }
        return root;
    }
    private Node findMin(Node root){
        if(root == null) return null;
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    private void inorder(){
        _inorder(root);
    }
    public void _inorder(Node root){
        if(root !=null ) {
            _inorder(root.left);
            System.out.print(root.val+ " ");
            _inorder(root.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(50);
        bst.insert(20);
        bst.insert(50);

        bst.insert(40);
        bst.insert(60);
        System.out.println(bst.search(41));
        bst.inorder();

        bst.delete(50);
        System.out.println();
        bst.inorder();

        bst.delete(43);
        System.out.println();
        bst.inorder();
    }
}
