/**124.BinaryTreeMaximumPathSum
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * For example:
 * Given the below binary tree,
 *      1
 *    / \
 *  2   3
 * Return 6.
 */
public class BinaryTreeMaximumPathSum {
    static int res = 0;
    public static int BinaryTreeMaximumPathSum(TreeNode root){
        if(root == null)return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public static int helper(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, root.val + left + right);
        return Math.max(0, root.val + Math.max(left, right));
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);root.right = new TreeNode(2);
        root.left.left = new TreeNode(3); root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4); root.left.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9); root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15); root2.right.right = new TreeNode(7);

        System.out.println(BinaryTreeMaximumPathSum(root2));
        System.out.println(BinaryTreeMaximumPathSum(root));
    }
}
