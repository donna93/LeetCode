/**
 * 104.MaximumDepthOfBinary
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *      / \
 *    9   20
 *   /     \
 * 15       7
 * return its depth = 3.
 */
public class MaximumDepthOfBinary {
    public static int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }
}
