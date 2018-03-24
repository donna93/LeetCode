import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BinaryTreePreorderTraversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *
 *   1
 *    \
 *    2
 *   /
 *  3
 * return [1,2,3].
 */
public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
            res.add(cur.val);
        }return res;
    }

    public static List<Integer> preorderTraversal2(TreeNode root){
        List<Integer>res = new ArrayList<>();
        if(root == null)return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal2(root));
    }
}
