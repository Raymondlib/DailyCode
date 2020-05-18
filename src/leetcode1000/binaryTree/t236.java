package leetcode1000.binaryTree;

/**
 * 二叉树 两节点的 最近公共祖先
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int val){
        this.val = val;
        this.left =null;
        this.right =null;
    }
}
public class t236 {
    // 程序员面试金典上的原题，还是忘了怎么写。。
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        // 这个函数 返回 结果，如果不为 null ，就代标 root 包含 p 或 q，且 返回的值，就是 在 该分支上搜索的结果
        // 这个递归太经典了
        if(root ==null || root.val == p.val || root.val ==q.val ){
            return root;
        }
        TreeNode a =lowestCommonAncestor(root.left,p,q);
        TreeNode b =lowestCommonAncestor(root.right,p,q);
        if(a==null && b==null) return  null;
        if(a==null) return b;
        if(b==null) return a;
        return root;

    }
//    f(l1,l2 ,int c){
//        if(l1 =null ) return l2;
//        if(l2 =null ; reutrn l;
//        sum c;
//        node t =new ndoe (sum%10)
//                t.next  = f     (l1,next,l2,next,c);
//        return t;
//    }




}
