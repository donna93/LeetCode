import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**very important!!!
 * 94. BinaryInorderTraversal
 * For example:
 * Given binary tree [1,null,2,3],
 *    1
 *     \
 *      2
 *     /
 *   3
 * return [1,3,2].
 */
public class BinaryInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer>res = new ArrayList<>();
        if(root == null)return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }return res;
    }
    public static List<Integer>inorderTraversal2(TreeNode root){
        List<Integer>res = new ArrayList<>();
        if(root == null)return res;
        res.addAll(inorderTraversal2(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal2(root.right));
        return res;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal2(root));
        System.out.println(inorderTraversal(root));
    }
}
