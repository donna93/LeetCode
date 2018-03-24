import java.util.*;
/**less important
 * 145.Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
 *    1
 *     \
 *      2
 *     /
 *   3
 * return [3,2,1].
 */
//solution 1: use stack and while
public class BinaryTreePostOrder {
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer>res = new LinkedList<>();
        if(root == null)return res;
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if(cur.left != null)stack.push(cur.left);
            if(cur.right != null)stack.push(cur.right);
        }return res;
    }
    public static List<Integer> postorderTraversal2(TreeNode root){
        LinkedList<Integer>res = new LinkedList<>();
        if(root == null)return res;
        res.addAll(postorderTraversal2(root.right));
        res.addAll(postorderTraversal2(root.left));
        res.add(root.val);
        return res;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal2(root));
        System.out.println(postorderTraversal(root));
    }
}
