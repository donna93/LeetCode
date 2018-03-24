import java.util.Stack;

/**
 * 99.Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if(root == null)return;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void helper(TreeNode root){
        if(root == null)return;
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null)first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
    }

    public void recoverTree2(TreeNode root){
        if(root == null)return;
        Stack<TreeNode>stack = new Stack<>();
        TreeNode cur = new TreeNode(root.val);
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(prev != null && cur.val <= prev.val){
                    if(first == null) first = prev;
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
