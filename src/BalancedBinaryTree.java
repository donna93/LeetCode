/**110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *        3
 *      / \
 *    9  20
 *       / \
 *     15  7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *           1
 *          / \
 *        2   2
 *      / \
 *     3  3
 *   / \
 * 4   4
 * Return false.
 */
public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int maxDepth(TreeNode root){
        if(root == null)return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);root.right = new TreeNode(2);
        root.left.left = new TreeNode(3); root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4); root.left.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9); root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15); root2.right.right = new TreeNode(7);

        System.out.println(isBalanced(root2));
        System.out.println(isBalanced(root));
    }
}

